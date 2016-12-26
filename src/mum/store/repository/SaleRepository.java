package mum.store.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javafx.collections.ObservableList;
import mum.store.dal.DatabaseManager;
import mum.store.model.Product;
import mum.store.model.SaleMaster;

public class SaleRepository implements IRepository {

	@Override
	public <T> boolean add(T saleMap) {

		@SuppressWarnings("unchecked")
		HashMap<SaleMaster, ObservableList<Product>> saleMapList = (HashMap<SaleMaster, ObservableList<Product>>) saleMap;

		SaleMaster saleMaster = saleMapList.keySet().iterator().next();
		ObservableList<Product> saleItems = saleMapList.get(saleMaster);

		try {
			// DatabaseManager manager = new DatabaseManager();
			String query = String.format("insert into tbl_salemaster values(%d,%.2f,%d,%d,'%s',%d)", 0,
					saleMaster.getTotalAmount(), Integer.parseInt(saleMaster.getBillNumber()), 1,
					saleMaster.getSaleDate(), 1);
			DatabaseManager.getStatement().executeUpdate(query);
			System.out.println(query);
			ResultSet result = DatabaseManager
					.getPreparedStatement("SELECT max(smid) as maxid FROM storemanagement.tbl_salemaster")
					.executeQuery();

			if (result.next()) {
				int smid = Integer.parseInt(result.getString("maxid"));

				System.out.println(smid);
				saleItems.forEach(sitem -> {
					String queryString = String.format(
							"INSERT into storemanagement.tbl_saledetail values(%d,%d,%d,%d,%.2f,%.2f,%d)", 0, smid,
							sitem.getItemId(), sitem.getItemQty(), sitem.getPrice(), sitem.getItemAmount(), 1);
					System.out.println(queryString);

					try {
						DatabaseManager.getStatement().executeUpdate(queryString);

						String querySelectId = "select * from storemanagement.tbl_stock where itemidFk ="
								+ sitem.getItemId();
						System.out.println(querySelectId);
						String queryAddUpdatQty;

						ResultSet resultSet = DatabaseManager.getPreparedStatement(querySelectId).getResultSet();

						System.out.println(resultSet);

						//

						//

						if (!resultSet.equals(null)) {
							queryAddUpdatQty = String.format(
									"update storemanagement.tbl_stock set quantity = quantity - %d where itemidfk=%d",
									0, sitem.getItemQty(), sitem.getItemId());
							System.out.println(queryAddUpdatQty);
						} else {
							queryAddUpdatQty = String.format("insert into storemanagement.tbl_stock values(%d,%d,%d)",
									0, sitem.getItemId(), sitem.getItemQty());
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
