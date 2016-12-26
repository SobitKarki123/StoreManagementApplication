package mum.store.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import javafx.collections.ObservableList;
import mum.store.dal.DatabaseManager;
import mum.store.model.Product;
import mum.store.model.PurchaseMaster;

public class PurchaseRepository implements IRepository {
	@Override
	public <T> boolean add(T purchaseMap) {
		@SuppressWarnings("unchecked")
		HashMap<PurchaseMaster, ObservableList<Product>> purchaseMapList = (HashMap<PurchaseMaster, ObservableList<Product>>) purchaseMap;
		PurchaseMaster purchaseMaster = purchaseMapList.keySet().iterator().next();
		ObservableList<Product> purchaseItems = purchaseMapList.get(purchaseMaster);

		try {
			// DatabaseManager manager = new DatabaseManager();
			String query = String.format("insert into tbl_purchasemaster values(%d,%.2f,%d,%d,'%s',%d)", 0,
					purchaseMaster.getTotalAmount(), Integer.parseInt(purchaseMaster.getBillNumber()), 1,
					purchaseMaster.getPurchaseDate(), 1);
			DatabaseManager.getStatement().executeUpdate(query);
			System.out.println(query);

			ResultSet result = DatabaseManager
					.getPreparedStatement("SELECT max(pmid) as maxid FROM storemanagement.tbl_purchasemaster").executeQuery();

			if (result.next()) {
				int pmid = Integer.parseInt(result.getString("maxid"));
				System.out.println(pmid);
				purchaseItems.forEach(pitem -> {
					String queryString = String.format(
							"INSERT into storemanagement.tbl_purchasedetail values(%d,%d,%d,%d,%.2f,%.2f,%d)", 0, pmid,
							pitem.getItemId(), pitem.getItemQty(), pitem.getPrice(), pitem.getItemAmount(), 1);
					System.out.println(queryString);
					try {
						DatabaseManager.getStatement().executeUpdate(queryString);

						String querySelectId = "select count(stockid) as count from storemanagement.tbl_stock where itemidfk ="
								+ pitem.getItemId();
						 System.out.println(querySelectId);
						String queryAddUpdatQty;
						int rowEffected=Integer.parseInt(DatabaseManager.getPreparedStatement(querySelectId).executeQuery().getString("count"));
						if (rowEffected > 0) {
							 queryAddUpdatQty = String.format(
									"update storemanagement.tbl_stock set quantity = quantity + %d where itemidfk=%d",
									0, pitem.getItemQty(), pitem.getItemId());
							 System.out.println(queryAddUpdatQty);
						} else {
							 queryAddUpdatQty = String.format("insert into storemanagement.tbl_stock values(%d,%d,%d)",
									0, pitem.getItemId(), pitem.getItemQty());
							 System.out.println(queryAddUpdatQty);
						}
						DatabaseManager.getStatement().executeUpdate(queryAddUpdatQty);
					} catch (SQLException ex) {
					}
				});
				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public <T> List<T> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
