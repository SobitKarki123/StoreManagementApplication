package mum.store.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mum.store.dal.DatabaseManager;
import mum.store.model.Employee;

public class EmployeeRepository implements IRepository {

	@Override
	public <T> boolean add(T employee) {
		Employee emp = (Employee) employee;
		try {
			String query = "insert into tbl_employee values (" + 0 + ",'" + emp.getEmpName() + "','"
					+ emp.getEmpAddress() + "','" + emp.getEmpEmail() + "','" + emp.getUserName() + "','"
					+ emp.getPassword() + "'," + emp.getRoleId() + ")";
			/*
			 * String query = String.format(
			 * "insert into tbl_employee values ({0},'{1}','{2}','{3}','{4},'{5}','{6}'"
			 * , 0, emp.getEmpName(), emp.getEmpAddress(), emp.getEmpEmail(),
			 * emp.getUserName(), emp.getPassword(), emp.getRoleId());
			 */
			System.out.println(query);
			DatabaseManager.getStatement().executeUpdate(query);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@SuppressWarnings("static-access")
	@Override
	public <T> List<T> list() {
		List<Employee> empList = new ArrayList<>();
		try {
			DatabaseManager manager = new DatabaseManager();
			String query = "select * from tbl_employee";
			ResultSet resultSet = manager.getPreparedStatement(query).getResultSet();
			while (resultSet.next()) {
				Employee e = new Employee();
				e.setEmpName(resultSet.getString("empname"));
				e.setEmpAddress(resultSet.getString("empaddress"));
				e.setEmpEmail(resultSet.getString("empemail"));
				e.setUserName(resultSet.getString("username"));
				e.setPassword(resultSet.getString("password"));
				e.setRoleId(resultSet.getInt("roleid"));
				empList.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (List<T>) empList;
	}

}
