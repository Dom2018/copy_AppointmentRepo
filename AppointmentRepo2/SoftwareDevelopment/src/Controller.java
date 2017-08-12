import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.sql.*;


	public class Controller {
	private String uName; 
	private String password;
 	private User u;
 	private Boolean userSet = false;
 	private	String dbUrl = "jdbc:mysql://localhost:3306/IT7320DB";
	private	String user  = "root";   
	private	String pass = "root"; // Dom's use of DB
//  private String pass = ""; // for Charlie's use DB
	private String Driver_Manager= "com.mysql.jdbc.Driver";
 	
	
 private Vector<Vector<String>> testOnly = new Vector<Vector<String>>();
 private static Controller cntlr = null;
	
 protected Controller() {}
 
 public static Controller getController() {
	 if(cntlr == null) {
		 cntlr = new Controller();
	 }
	 return cntlr;
 }
 
 public Boolean getStatus() {
	 return userSet;
 }
 
 public void setStatus(Boolean status) {
	 userSet = status;
 }
 public Boolean createUser(String uName, String password) {
	//Search database for user and if found construct, set and return true,
	 //If not return fasle
	 try {
			Class.forName(Driver_Manager);
			
			Connection myConnect = DriverManager.getConnection(dbUrl, user, pass);
			Statement myStmt = myConnect.createStatement();
			
			// info for getting the username and password from the user table in DB
			ResultSet myRs = myStmt.executeQuery("select * from user");
			
			
			// will loop through while loop and find username and password and print a statement on concole to let user know they
			// were able to get the right username and password and that it was successful. 
			while(myRs.next()) {
				if( myRs.getString("User_name").equals(uName) && myRs.getString("User_pass").equals(password)) {
					String id = myRs.getString("User_ID");
					String username = myRs.getString("User_name");
					String passWord = myRs.getString("User_pass");
					String Fname = myRs.getString("User_Fname");
					u = new User( id, Fname, passWord, username);
					setStatus(true);
				}	
				
//				String sql = "insert into user(User_name, User_pass) " + "values ('uName', 'password')";
//				myStmt.executeUpdate(sql);
				
			}
			ResultSet Rs = myStmt.executeQuery("select * from Appointment where User_ID =" + u.getID());
			
			while(Rs.next()) {
				System.out.println(Rs.getString("App_ID"));
				Vector<String> v = new Vector<String>();
				v.add(Rs.getString("App_ID"));
				v.add(Rs.getString("App_Date"));
				v.add(Rs.getString("App_Patient_Name"));
				v.add(Rs.getString("App_Notes"));
				
				addAppointment(v);
			}
			myStmt.close();
			myConnect.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	 return null;
 }
 
 public void addAppointment(Vector<String> appt) {
	 u.addAppointment(appt.get(0), appt.get(1), appt.get(2), appt.get(3));
 }
 
 public void addNewAppointment(Vector<String> appt) {
	 u.addAppointment(appt.get(0), appt.get(1), appt.get(2), appt.get(3));
	 //add appointment to db
	 Connection myConnect;
	try {
		myConnect = DriverManager.getConnection(dbUrl, user, pass);
		Statement myStmt = myConnect.createStatement();
		
		 String sql = "insert into Appointment(User_ID, App_Patient_Name, App_Date, App_Notes) " + "values ("+ u.getID() +", " +  "'" + appt.get(2) + "', " + "'"+ appt.get(1) +"', "+ "'" + appt.get(3)+"')";
		 System.out.println(sql);
		 myStmt.executeUpdate(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
 }
 
 public Vector<Vector<String>> getAppointments() {
	 Vector<Vector<String>> m = new Vector<Vector<String>>();
	 for(Appointment v : u.getAppointments()) {
		 Vector<String> vS = new Vector<String>();
		 vS.add(v.getID());
		 vS.add(v.getDate());
		 vS.add(v.getPatName());
		 vS.add(v.getNotes());
		 m.add(vS);
	 }
	 return m;
 }
 
 public Vector<String> getAppointment(String id){
	 for(Vector<String> v : testOnly) {
		 if(v.firstElement().equals(id))
			 //get from user
			 return testOnly.get(testOnly.indexOf(v));
	 }
	return null;
 }
 
 public void deleteAppointment(String id) {
	 for(Vector<String> v : testOnly) {
		 if(v.firstElement().equals(id))
			 //Delete from db
			 testOnly.remove(v);
	 }
	 //update user list
 }
 
}
