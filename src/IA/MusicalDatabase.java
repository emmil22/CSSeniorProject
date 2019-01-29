package IA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;



public class MusicalDatabase {
	
	public ArrayList<Musical> musical = new ArrayList<Musical>();

	PreparedStatement ps;
	Statement stmt;
	
	public static void main(String[] args) throws Exception{
		MusicalDatabase pse = new MusicalDatabase();
	
		pse.doTableStuff();
	
	}
	
	public MusicalDatabase() throws Exception {
		DBConnectionManagerSingleton dbc = DBConnectionManagerSingleton.getInstance();
		Connection conn = dbc.getConnection();
		String insertRecord = "INSERT INTO MUSICAL_INFO VALUES(?, ?, ?, ?)";
		 ps = conn.prepareStatement(insertRecord);
		
		stmt = dbc.getStatement();
	}
	
	public void doTableStuff() throws Exception {
		//createDBTable();
		Musical m = new Musical();
		insertDBRecord(m);
		//dropTable();
	}
	
	
	public  void createDBTable() throws Exception {
		String TableString = "Create table MUSICAL_INFO(MUSICAL_NAME varchar (30),"
				+ " ACTOR varchar (30) primary key, ROLES varchar (30), SONGS_IN varchar (500))";
				
		 stmt.executeUpdate(TableString);
	}
	public  void insertDBRecord(Musical m) throws Exception {
		ps.setString(1,  m.getrole());
		ps.setString(2,  m.getactors());
		ps.setString(3,  m.getrole());
		ps.setString(4,  m.getsongsin());
		
		ps.execute();
		ps.clearParameters();
	}
	public  void dropTable() throws Exception {
		String drop = "DROP TABLE MUSICAL_INFO";
		stmt.executeUpdate(drop);
	}
}
