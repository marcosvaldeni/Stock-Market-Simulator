package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
* Object Orientation with Design Patterns
* CCT College Dublin
* Marcos Valdeni Lucas 2016280
*/
public class DataSource {

	// Database connection details
	private String url;
	private String database;
	private String user;
	private String pass;
	private String port;
	private String address;

	// Database objects
	private Connection conn;
	private Statement stmt;

	public DataSource(String[] string) {
		this.database = "StockMarketSimulator";
		this.user = string[0];
		this.pass = string[1];
		this.port = string[2];
		this.address = string[3];
		this.url = "jdbc:mysql://" + this.address + ":" + this.port + "/" + this.database + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

	}

    /**
     * Method to execute any SELECT query.
     * @returns ResultSet, This returns a result of any select
     */
	public ResultSet select(String query) {
		
		// Execute the query
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}

    /**
     * Method to execute any INSERT statement
     * @returns boolean, This returns a true if the insert occurred successfully and false if it fails
     */
	public boolean save(String query) {
		
		try {
			// Execute the INSERT statement
			stmt.execute(query);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}
	
    /**
     * Test the connection could be established with the passed parameters on the first screen.
     * @returns boolean, This returns true when the connection was successfully established and false when it fails
     */
	public boolean testConnection() throws Exception {
		
		try {

			// Get a connection to the database
			conn = DriverManager.getConnection(this.url, this.user, this.pass);

			// Get a statement from the connection
			stmt = conn.createStatement();
			return true;

		} catch (SQLException ex) {

			throw new Exception(ex.getMessage());
		}
		
	}

    /**
     * Create a new connection with the database.
     */
	public void openConnection() {
		// Establishing connection
		try {

			// Get a connection to the database
			conn = DriverManager.getConnection(this.url, this.user, this.pass);

			// Get a statement from the connection
			stmt = conn.createStatement();

		} catch (SQLException se) {
			System.out.println("SQL Exception:");

			// Loop through the SQL Exceptions
			while (se != null) {
				System.out.println("State  : " + se.getSQLState());
				System.out.println("Message: " + se.getMessage());
				System.out.println("Error  : " + se.getErrorCode());

				se = se.getNextException();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
    /**
     * Close any connection with the database.
     */
	public void closeConnection() {
		try {
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
