package mum.store.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbconnectionandtestpackage.DbConnection;
import javafx.collections.FXCollections;
import mum.store.dal.DatabaseManager;
import mum.store.model.Product;

public class ProductRepository implements IRepository {

	@Override
	public <T> boolean add(T product) {
		// TODO Auto-generated method stub
		Product item = (Product) product;

		try {
			String query = String.format("insert into tbl_item values(%d,'%s','%s',%.2f,%d)", 0, item.getItemCode(),
					item.getItemName(), item.getPrice(), 1);

			System.out.println(query);
			DatabaseManager.getStatement().executeUpdate(query);
			return true;

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;

	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> list() {
		List<Product> productList = new ArrayList<Product>();
		try {
			//DatabaseManager manager = new DatabaseManager();
			String query = "select * from tbl_item";
			ResultSet resultSet = DatabaseManager.getPreparedStatement(query).executeQuery();
			while (resultSet.next()) {
				Product p = new Product(resultSet.getString("itemname"),resultSet.getString("itemcode"),
						Double.parseDouble(resultSet.getString("itemprice")),
						Long.parseLong(resultSet.getString("itemid")));
				productList.add(p);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return (List<T>) productList;
	}
}
