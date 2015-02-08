package usermanagement;

import java.util.UUID;


public abstract class User {
  private UUID user_id;
  private String first_name;
  private String second_name;
  private String login;
  private String password;
  private UUID role_id;
  private ServerRequest server;
  
  
  public abstract String create();
  
  public User(UUID user_id, String first_name, String second_name, String login, String password, UUID role_id, ServerRequest server) {
	this.user_id = user_id;
	this.first_name = first_name;
	this.second_name = second_name;
	this.login = login;
	this.password = password;
	this.server = server;
  }
  
  /**
   * Change the user's password.
   */
  protected String changePassword(String newPassword, String table_name) {
    String query = "UPDATE ";
	    query += table_name;
	    query += " SET usr_password='";
	    query += newPassword;
	    query += "' WHERE usr_id='";
	    query += this.user_id.toString();
	    query += "';";

	    boolean res = this.server.executeQuery(query);
	    if (!res) {
	      //System.out.println("Unable to create user");
	      return "Unable to change your password, sorry.";
	    }
	    this.password = newPassword;
	    return "Password changed successfully";
	  
  }

  /**
   * Change the user's login.
   */
  protected String changeLogin(String table_name, String newlogin) {
    String query = "UPDATE ";
	    query += table_name;
	    query += " SET usr_login='";
	    query += newlogin;
	    query += "' WHERE usr_id='";
	    query += this.user_id.toString();
	    query += "';";

	    boolean res = this.server.executeQuery(query);
	    if (!res) {
	      //System.out.println("Unable to create user");
	      return "Unable to change your login, sorry.";
	    }
	    this.login = newlogin;
	    return "Login changed successfully";  
  }
  
  /**
  Creates the given user in the database given in parameters.
  */
  protected String databaseSave(String database_name, String id_name) {
    String query = "INSERT INTO ";
    query += database_name;
    query += "(usr_id, usr_name,usr_first_name,usr_login,usr_password,usr_rl_id,";
    query += id_name;
    query += ") VALUES ('";
    query += this.user_id.toString();
    query += "','";
    query += this.second_name;
    query += "','";
    query += this.first_name;
    query += "','";
    query += this.login;
    query += "','";
    query += this.password;
    query += "','";
    query += this.role_id.toString();
    query += "');";
    
    boolean res = this.server.executeQuery(query);
    if (!res) {
      //System.out.println("Unable to create user");
      return "Unable to create user in the database.";
    }
    return "User created successfully";
  }
  
  /**
   * Delete the given user from the database (only if he does exists, of course).
   */
  protected String delete(String table_name) {
    String query = "DELETE FROM ";
	    query += table_name;
	    query += " WHERE usr_id='";
	    query += this.user_id.toString();
	    query += "';";

	    boolean res = this.server.executeQuery(query);
	    if (!res) {
	      //System.out.println("Unable to create user");
	      return "Unable to delete the user, sorry (it may already exist in the database).";
	    }
	    return "User deleted successfully.";
	  
  }
}
