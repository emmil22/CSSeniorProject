package IA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;



public class ErrorDatabase {
	
	public ArrayList<Error> errors = new ArrayList<Error>();

	PreparedStatement ps;
	Statement stmt;
	
	public static void main(String[] args) throws Exception{
		UserDatabase pse = new UserDatabase();
	
		pse.doTableStuff();
	
	}
	
	public ErrorDatabase() throws Exception {
		DBConnectionManagerSingleton dbc = DBConnectionManagerSingleton.getInstance();
		Connection conn = dbc.getConnection();
		String insertRecord = "INSERT INTO ERROR_LOG VALUES(?, ?, ?, ?, ?, ?, ?)";
		 ps = conn.prepareStatement(insertRecord);
		
		stmt = dbc.getStatement();
	}
	
	public void doTableStuff() throws Exception {
		//createDBTable();
		Error e = new Error();
		insertDBRecord(e);
		//dropTable();
	}
	
	
	public  void createDBTable() throws Exception {
		String TableString = "Create table ERROR_LOG(BROKEN_MIC varchar (30) primary key, REPLACED_MIC "
				+ "varchar (35), ERROR varchar (100), TIME varchar (30))";
				
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