package Reference;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UncleErnies {
	public ArrayList<CustomerOrder> blurb = new ArrayList<CustomerOrder>();

	PreparedStatement ps;
	Statement stmt;
	
	public static void main(String[] args) throws Exception{
		UncleErnies pse = new UncleErnies();
	
		pse.doTableStuff();
	
	}
	
	public UncleErnies() throws Exception {
		DBConnectionManagerSingleton dbc = DBConnectionManagerSingleton.getInstance();
		Connection conn = dbc.getConnection();
		String insertRecord = "INSERT INTO CUSTOMER_ORDER VALUES(?, ?, ?, ?, ?, ?, ?)";
		 ps = conn.prepareStatement(insertRecord);
		
		stmt = dbc.getStatement();
	}
	
	public void doTableStuff() throws Exception {
		//createDBTable();
		CustomerOrder c= new CustomerOrder();
		insertDBRecord(c);
		//dropTable();
	}
	
	
	public  void createDBTable() throws Exception {
		String TableString = "Create table CUSTOMER_ORDER (FIRST_NAME varchar (30), LAST_NAME "
				+ "varchar (35), FLAVOR varchar (30), TOPPING varchar (30), COC varchar (30),"
				+ " PRICE float, ORDER_DATE date, ID integer identity (1,1) primary key)";
		 stmt.executeUpdate(TableString);
	}
	public  void insertDBRecord(CustomerOrder x) throws Exception {
		ps.setString(1,  x.getfirstName());
		ps.setString(2,  x.getlastName());
		ps.setString(3,  x.getflavor());
		ps.setString(4,  x.gettopping());
		ps.setString(5,  x.getcoc());
		ps.setDouble(6,  x.getprice());
		ps.setString(7,  x.getCurrentDate());
		ps.execute();
		ps.clearParameters();
	}
	public  void dropTable() throws Exception {
		String drop = "DROP TABLE CUSTOMER_ORDER";
		stmt.executeUpdate(drop);
	}
}
