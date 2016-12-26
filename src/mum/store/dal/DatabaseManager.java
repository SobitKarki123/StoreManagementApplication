package mum.store.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import dbconnectionandtestpackage.DbConnection;

public final class DatabaseManager {

	private static Connection con;
	private static ResultSet resultSet;
	private static Statement statement;
	private static PreparedStatement preparedStatement;
	private static String URL = "jdbc:mysql://localhost:3306/storemanagement";
	private static String CLASS = "com.mysql.jdbc.Driver";

	static {
		try {
			if (con == null) {
				Class.forName(CLASS);
				con = DriverManager.getConnection(URL, "root", "root");
			}
		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static Connection getConnection() {
		return con;
	}

	public static Statement getStatement() throws SQLException {
		statement = con.createStatement();
		return statement;
	}

	public static PreparedStatement getPreparedStatement(String query) throws SQLException {
		preparedStatement = con.prepareStatement(query);
		return preparedStatement;
	}

	public static ResultSet getResultSet() throws SQLException {
		resultSet = preparedStatement.executeQuery();
		return resultSet;
	}
}
