package IA;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;



public class UserDatabase {
	
	public ArrayList<User> users = new ArrayList<User>();

	PreparedStatement ps;
	Statement stmt;
	
	public static void main(String[] args) throws Exception{
		UserDatabase pse = new UserDatabase();
	
		pse.doTableStuff();
	
	}
	
	public UserDatabase() throws Exception {
		DBConnectionManagerSingleton dbc = DBConnectionManagerSingleton.getInstance();
		Connection conn = dbc.getConnection();
		String insertRecord = "INSERT INTO USER_INFO VALUES(?, ?, ?, ?, ?, ?, ?)";
		 ps = conn.prepareStatement(insertRecord);
		
		stmt = dbc.getStatement();
	}
	
	public void doTableStuff() throws Exception {
		//createDBTable();
		User u = new User();
		insertDBRecord(u);
		//dropTable();
	}
	
	
	public  void createDBTable() throws Exception {
		String TableString = "Create table USER_INFO (FIRST_NAME varchar (30), LAST_NAME "
				+ "varchar (30), USERNAME varchar (30) primary key, PASSWORD varchar (30), "
				+ "SECURITY_QUESTION varchar (100), SECURITY_ANSWER varchar(30), HINT varchar(30))";
		 stmt.executeUpdate(TableString);
	}
	public  void insertDBRecord(User u) throws Exception {
		ps.setString(1,  u.getfName());
		ps.setString(2,  u.getlName());
		ps.setString(3,  u.getuName());
		ps.setString(4,  u.getPassword());
		ps.setString(5,  u.getsQuestion());
		ps.setString(6,  u.getsAnswer());
		ps.setString(7,  u.getHint());
		ps.execute();
		ps.clearParameters();
	}
	public  void dropTable() throws Exception {
		String drop = "DROP TABLE USER_INFO";
		stmt.executeUpdate(drop);
	}
}