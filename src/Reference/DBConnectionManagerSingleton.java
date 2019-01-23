package Reference;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.sql.Statement;


public class DBConnectionManagerSingleton {
	
	private static DBConnectionManagerSingleton dbConnectionManager = null;

	private static final String user = "sa";
	
	private static final String pass = "Suncoast$1";
	private static final String dbURL = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=CSProject";

	private Connection conn;
	private Statement stmt;

	public Connection getConnection() {
		return conn;
	}
	public Statement getStatement() {
		return stmt;
	}

	private DBConnectionManagerSingleton() throws ClassNotFoundException, SQLException {
		try {

			// Use this if passing in login and password
			conn = DriverManager.getConnection(dbURL, user, pass);

			// Use this if using windows authentication
			// (integratedSecurity=true)
			//conn = DriverManager.getConnection(dbURL);
			System.out.println("Conn has been set");

			if (conn != null) {
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				System.out.println("Driver name: " + dm.getDriverName());
				System.out.println("Driver version: " + dm.getDriverVersion());
				System.out.println("Product name: " + dm.getDatabaseProductName());
				System.out.println("Product version: " + dm.getDatabaseProductVersion());
			}
			stmt = conn.createStatement();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}
	
	public static DBConnectionManagerSingleton getInstance() throws Exception {
		if (dbConnectionManager == null) {
			dbConnectionManager = new DBConnectionManagerSingleton();
		}
		return dbConnectionManager;
	}
	
	
	
	public static void main(String[] args) throws Exception {
		DBConnectionManagerSingleton dbConn = DBConnectionManagerSingleton.getInstance();
		
		Connection conn = dbConn.getConnection();
		if (conn != null) {
			System.out.println("We have a database connection!!!");
			
		}
	}


}


