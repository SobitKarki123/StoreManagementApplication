package mum.store.bal;

public class LoginRecordhelper {
	private static String userName;
	private static String password;
	private static int userId;

	public static int getUserId() {
		return userId;
	}

	public static void setUserId(int userId) {
		LoginRecordhelper.userId = userId;
	}

	public static String getUserName() {
		return userName;
	}

	public static void setUserName(String userName) {
		LoginRecordhelper.userName = userName;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		LoginRecordhelper.password = password;
	}

}
