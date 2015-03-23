package usermanagement;

import java.rmi.RemoteException;
import java.util.UUID;

public class AdminChapter extends User {
	
  private static final String TABLE_NAME = "AdminChapter";
	
  public AdminChapter(UUID user_id, String first_name, String second_name, String login, String password, UUID role_id) {
    super(user_id, first_name, second_name, login, password, role_id);
  }
  
  /**
   * Creates this user object into the database.
   */
  public String create() {
    try {
		return super.databaseSave(TABLE_NAME, "ac_id");
	} catch (RemoteException e) {
		throw new AssertionError(e);
	}
  }
  
  /**
  * Change the user's password.
  */  
  public String changePassw(String newPassword) {
    try {
		return super.changePassword(newPassword, TABLE_NAME);
	} catch (RemoteException e) {
		throw new AssertionError(e);
	}
  }
  
  /**
   * Change the user's login.
   */  
   public String changeLogin(String newLogin) {
     try {
		return super.changePassword(TABLE_NAME, newLogin);
	} catch (RemoteException e) {
		throw new AssertionError(e);
	}
   }
   
   /**
    * Delete the user.
    */  
    public String deleteUser(String newLogin) {
      try {
		return super.delete(TABLE_NAME);
	} catch (RemoteException e) {
		throw new AssertionError(e);
	}
    }
}
