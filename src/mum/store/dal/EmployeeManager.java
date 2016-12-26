package mum.store.dal;

import java.sql.ResultSet;
import java.sql.SQLException;

import mum.store.bal.LoginRecordhelper;
import mum.store.model.MinimalEmployee;

public class EmployeeManager {

	public MinimalEmployee login(String username, String password) {
		// return new MinimalEmployee(username, 2, 2, true);
		String queryString = String.format(
				"SELECT empid as userid , roleidfk as usertype FROM storemanagement.tbl_employee where username='%s' and password='%s'",
				username, password);
		MinimalEmployee emp = new MinimalEmployee();
		try {
			ResultSet result = DatabaseManager.getPreparedStatement(queryString).executeQuery();
			if (result.next()) {
				emp.setUserId(Integer.parseInt(result.getString("userid")));
				emp.setUsername(username);
				emp.setUserType(Integer.parseInt(result.getString("usertype")));
				emp.setValid(true);
				LoginRecordhelper.setUserName(username);
				LoginRecordhelper.setPassword(password);
				LoginRecordhelper.setUserId(emp.getUserId());
			} else {
				emp.setValid(false);
				emp.setUserType(-1);
				emp.setUsername(username);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return emp;
	}

	public boolean changePassword(String oldPassword, String newPassword) {
		String queryString = String.format(
				"Update storemanagement.tbl_employee set password = '%s' where empid=%d", newPassword,
				LoginRecordhelper.getUserId());
		System.out.println(queryString);
		try {
			DatabaseManager.getStatement().executeUpdate(queryString);
			return true;

		} catch (SQLException ex) {
		}
		return false;
	}
}
