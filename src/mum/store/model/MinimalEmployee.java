package mum.store.model;

public class MinimalEmployee {
	private String username;
	private int userId;
	private int userType;
	private boolean isValid;

	public MinimalEmployee(String username, int userId, int userType, boolean isValid) {
		this.username = username;
		this.userId = userId;
		this.userType = userType;
		this.isValid = isValid;
	}

	public MinimalEmployee(){}
	
	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}
}
