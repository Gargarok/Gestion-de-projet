package usermanagement;

import java.util.UUID;

public class Writer extends User {
	
  private static final String TABLE_NAME = "Writer";
  
  public Writer(UUID user_id, String first_name, String second_name, String login, String password, UUID role_id, ServerRequest server) {
    super(user_id, first_name, second_name, login, password, role_id, server);
  }
				
  /**
   * Creates this user object into the database.
   */
  public String create() {
    return super.databaseSave(TABLE_NAME, "wr_id");
  }
  
  /**
  * Change the user's password.
  */  
  public String changePassw(String newPassword) {
    return super.changePassword(newPassword, TABLE_NAME);
  }
  
  /**
   * Change the user's login.
   */  
   public String changeLogin(String newLogin) {
     return super.changePassword(TABLE_NAME, newLogin);
   }
   
   /**
    * Delete the user.
    */  
    public String deleteUser(String newLogin) {
      return super.delete(TABLE_NAME);
    }
}
