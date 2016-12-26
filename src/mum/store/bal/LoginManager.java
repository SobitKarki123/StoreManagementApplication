package mum.store.bal;

import mum.store.dal.EmployeeManager;
import mum.store.model.MinimalEmployee;

public class LoginManager {
	
  EmployeeManager eManager = new EmployeeManager();
  
  public MinimalEmployee login(String username, String password)
  {
	  return eManager.login(username, password);
  }
  
  public boolean changePassword(String oldPassword, String newPassword)
  {
	  return eManager.changePassword(oldPassword, newPassword);
  }
}
