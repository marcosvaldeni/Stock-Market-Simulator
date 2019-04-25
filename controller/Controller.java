package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.Instant;
import java.util.ArrayList;

import dao.DataSource;
import model.Company;
import model.Investor;
import model.Simulation;
import model.Transaction;

public class Controller {
	
	private DataSource db;
	private Simulation simulation;
	private ArrayList<Company> companies;
	private ArrayList<Investor> invertors;
	private ArrayList<Transaction> transactions;
	
    /**
     * A static controller object that will be passed when the method getController been called.
     */
	private static Controller controller;
	
    /**
     * Constructor declared private to ensure that when an instance of the 
     * controller is called, it will be through the static 
     * getContoller method. So using the singleton design.
     * @param array of Strings that will be used as password, 
     * username and localhost of the database hosting.
     */
	private Controller(String[] string) {
		/*
		 Construct receives a String[] where the position 0 user, position 1 password, 
		 position 2 port and position 3 address. 
		 Date that will be resends to the DataSource class.
		 */
		db = new DataSource(string);
	}
	
    /**
     * This method will check if any controller instance has already 
     * been created, if yes, will return the same instance if not,
     * it will return a new instance.
     * @param array of Strings that will be used as password, 
     * username and localhost on the database hosting.
     */
	public static Controller getController(String[] string) {
		if (controller == null) {
			controller = new Controller(string);
			return controller;
		} else {
			return controller;
		}
	}
	
    /**
	 *	Save all investors into the database.
     * @param simulatior, A integer that will be the id of the current simulation
     * @param invertors, A ArrayList of investors
     */
	private void saveInvestor(int simulatior, ArrayList<Investor> invertors) {
		
		// Create a database connection 
		db.openConnection();
	
		for (Investor investor : invertors) {
			String query = "INSERT INTO investors (investor_name, investor_budget, simulation_id) VALUES ('" + investor.getName() + "', " + investor.getBudget() + ", " + simulatior + ")";
			db.save(query);
		}
		
		// Terminate the current database connection 
		db.closeConnection();
	}
	
    /**
	 * Save all companies into the database.
     * @param simulatior, A integer that will be the id of the current simulation
     * @param companies, A ArrayList of companies
     */
	private void saveCompany(int simulation, ArrayList<Company> companies) {
		
		// Create a database connection 
		db.openConnection();
		
		for (Company company : companies) {
			
			String query = "INSERT INTO companies (company_name, company_shares, company_sharePrice, company_type, simulation_id) VALUES ('" + company.getName() + "', " + company.getShares() + ", " + company.getSharePrice() + ", '" + company.getType() + "', " + simulation + ");";
			
			db.save(query);
		}
		
		// Terminate the current database connection 
		db.closeConnection();
	}
	
    /**
	 * Save all transactions into the database.
     * @param simulatior, A integer that will be the id of the current simulation
     * @param transactions, A ArrayList of transactions
     */
	private void saveTransaction(int simulation, ArrayList<Transaction> transactions) {
		
		// Create a database connection 
		db.openConnection();
	
		for (Transaction transaction : transactions) {
			
			String query = "INSERT INTO transactions (transaction_sharePrice, investor_id, company_id, simulation_id) VALUES (" + transaction.getSharePrice() + ", " + transaction.getInvestor() + ", " + transaction.getCompany() + ", " + simulation + ")";
			
			db.save(query);
		}
		
		// Terminate the current database connection 
		db.closeConnection();
		
	}
	
    /**
	 * Save all transactions into the database.
     * @param simulatior, A integer that will be the id of the current simulation
     * @param transactions, A ArrayList of transactions
     */
	private void saveSimulation() {
		
		// Create a database connection 
		db.openConnection();
		
		String query = "INSERT INTO simulations (simulation_date) VALUES (" + Instant.now().getEpochSecond() + ")";
			
		db.save(query);

		// Terminate the current database connection 
		db.closeConnection();
	}
	
    /**
	 * This method brings together all the pieces in order to create a new ecosystem
	 *  of investors, companies and transactions. Firstly, a new instance of 
	 *  the simulation class has been created and then the data is rescued 
	 *  and linked to a simulation id.
     */
	public void createSimulation() {
		// Creating a new instance of Simulation class
		this.simulation = new Simulation(getCompanyId(), getInvestorId(), getTransactionId());
		
		// Creating a new Simulation row on the database
		this.saveSimulation();
		
		// Saving all investors using the last simulation id on the database
		this.saveInvestor(this.getSimulationId(), simulation.getInvestors());
		
		// Saving all companies using the last simulation id on the database
		this.saveCompany(this.getSimulationId(), simulation.getCompanies());
		
		// Saving all transactions using the last simulation id on the database
		this.saveTransaction(this.getSimulationId(), simulation.getTransactions());

	}
	
    /**
     * Get the last simulation id on the database
     * @returns A integer, the last simulation id on the database
     */
	public int getSimulationId() {

		return getId("simulations");
	}
	
    /**
     * Get the last company id on the database
     * @returns A integer, the last company id on the database
     */
	private int getCompanyId() {

		return getId("companies");
	}
	
    /**
     * Get the last investor id on the database
     * @returns A integer, the last investor id on the database
     */
	private int getInvestorId() {
		
		return getId("investors");
	}
	
    /**
     * Get the last transaction id on the database
     * @returns A integer, the last transaction id on the database
     */
	private int getTransactionId() {
		
		return getId("transactions");
		
	}
	
    /**
     * Get last id generic, this method should be used by another method.
     * @param table Name of the table that will be used
     * @returns integer, The last id
     */
	private int getId(String table) {
		
		// Create a database connection 
		db.openConnection();
				
		String query = "SELECT COUNT(*) as id FROM " + table;

		ResultSet rs = db.select(query);
		try {
			rs.next();
			int id = rs.getInt("id");
			
			// Terminate the current database connection 
			db.closeConnection();
			return id;
			
		} catch (SQLException e) {}
		return 0;
		
	}
	
	//List of Simulation
	public ArrayList getSimulationList() {
		
		// Create a database connection 
		db.openConnection();
		
		ArrayList<String[]> simulations = new ArrayList<>(); 
		
		String query = "SELECT simulations.simulation_id as id, " + 
				"count(*) as transaction, " + 
				"FROM_UNIXTIME(simulations.simulation_date, \"%H:%i:%s - %D of %M %Y\") as date  FROM simulations " + 
				"inner join transactions on simulations.simulation_id = transactions.simulation_id " + 
				"group by simulations.simulation_id";

		ResultSet rs = db.select(query);
		
		try {
			while(rs.next()){
				
				String[] str = {rs.getString("id"), rs.getString("transaction"), rs.getString("date")};
				
				simulations.add(str);
				
			}
		} catch (SQLException e) {}
		
		db.closeConnection();
		return simulations;
	}
	
	//Company with the lowest capital 
	public ArrayList getCompanyLowestCapital(int simulation) {
		
		// Create a database connection 
		db.openConnection();
		
		ArrayList<String[]> alr = new ArrayList<>(); 
		
		String query = "SELECT companies.company_id AS id, " + 
				"companies.company_name AS name, " + 
				"(COUNT(*) + companies.company_shares) AS shareTotal, " + 
				"TRUNCATE(((COUNT(*) + companies.company_shares) * companies.company_sharePrice), 2) AS capital " + 
				"FROM companies LEFT JOIN transactions " + 
				"ON companies.company_id = transactions.company_id " + 
				"WHERE companies.simulation_id = " + simulation + " " +
				"GROUP BY companies.company_id " + 
				"ORDER BY capital;";

		ResultSet rs = db.select(query);
		
		try {
			while(rs.next()){
				
				String[] str = {rs.getString("id"), rs.getString("name"), rs.getString("shareTotal"), rs.getString("capital")};
				
				alr.add(str);
				
			}
		} catch (SQLException e) {}
		
		db.closeConnection();
		return alr;
	}
	
	//Company with the highest capital
	public ArrayList getCompanyHighestCapital(int simulation) {
		
		// Create a database connection 
		db.openConnection();
		
		ArrayList<String[]> alr = new ArrayList<>(); 
		
		String query = "SELECT companies.company_id AS id, " + 
				"companies.company_name AS name, " + 
				"(COUNT(*) + companies.company_shares) AS shareTotal, " + 
				"TRUNCATE(((COUNT(*) + companies.company_shares) * companies.company_sharePrice), 2) AS capital " + 
				"FROM companies LEFT JOIN transactions " + 
				"ON companies.company_id = transactions.company_id " + 
				"WHERE companies.simulation_id = " + simulation + " " +
				"GROUP BY companies.company_id " + 
				"ORDER BY capital DESC;";

		ResultSet rs = db.select(query);
		
		try {
			while(rs.next()){
				
				String[] str = {rs.getString("id"), rs.getString("name"), rs.getString("shareTotal"), rs.getString("capital")};
				
				alr.add(str);
				
			}
		} catch (SQLException e) {}
		
		db.closeConnection();
		return alr;
	}
	
	//Investors that have Invested in the most Companies
	public ArrayList getInvestorMostCompanies(int simulation) {
		
		// Create a database connection 
		db.openConnection();
		
		ArrayList<String[]> alr = new ArrayList<>(); 
		
		String query = "SELECT iv.investor_id AS id, iv.investor_name, " + 
				"count(distinct(tr.company_id)) as totalCompanies from transactions as tr " + 
				"inner join investors as iv on iv.investor_id = tr.investor_id " + 
				"where iv.simulation_id = " + simulation + " group by tr.investor_id " + 
				"order by totalCompanies desc;";

		ResultSet rs = db.select(query);
		
		try {
			while(rs.next()){
				
				String[] str = {rs.getString("id"), rs.getString("name"), rs.getString("totalCompanies")};
				
				alr.add(str);
				
			}
		} catch (SQLException e) {}
		
		db.closeConnection();
		return alr;
	}
	
	//Investor with the highest number of shares
	public ArrayList getInvestorHighestShare(int simulation) {
		
		// Create a database connection 
		db.openConnection();
		
		ArrayList<String[]> alr = new ArrayList<>(); 
		
		String query = "SELECT investors.investor_id AS id, " + 
				"investors.investor_name AS name, " + 
				"COUNT(*) AS trans FROM investors " + 
				"LEFT JOIN transactions " + 
				"ON investors.investor_id = transactions.investor_id " + 
				"WHERE investors.simulation_id = " + simulation + " " +
				"GROUP BY investors.investor_id " +
				"ORDER BY trans DESC";

		ResultSet rs = db.select(query);
		
		try {
			while(rs.next()){
				
				String[] str = {rs.getString("id"), rs.getString("name"), rs.getString("trans")};
				
				alr.add(str);
				
			}
		} catch (SQLException e) {}
		
		db.closeConnection();
		return alr;
	}
	
	//Investor with the lowest number of shares
	public ArrayList getInvestorLowestShare(int simulation) {
		
		// Create a database connection 
		db.openConnection();
		
		ArrayList<String[]> alr = new ArrayList<>(); 
		
		String query = "SELECT investors.investor_id AS id, " + 
				"investors.investor_name AS name, " + 
				"COUNT(*) AS trans FROM investors " + 
				"LEFT JOIN transactions " + 
				"ON investors.investor_id = transactions.investor_id " + 
				"WHERE investors.simulation_id = " + simulation + " " +
				"GROUP BY investors.investor_id " +
				"ORDER BY trans";

		ResultSet rs = db.select(query);
		
		try {
			while(rs.next()){
				
				String[] str = {rs.getString("id"), rs.getString("name"), rs.getString("trans")};
				
				alr.add(str);
				
			}
		} catch (SQLException e) {}
		
		db.closeConnection();
		return alr;
	}
	
	//Investors that have invested in the most companies
	public ArrayList getInvestorMostCompany(int simulation) {
		
		// Create a database connection 
		db.openConnection();
		
		ArrayList<String[]> alr = new ArrayList<>(); 
		
		String query = "SELECT iv.investor_id  AS id, iv.investor_name AS name, " + 
				"COUNT(DISTINCT(tr.company_id)) AS companyTotal FROM transactions AS tr " + 
				"INNER JOIN investors AS iv ON iv.investor_id = tr.investor_id " + 
				"WHERE iv.simulation_id = " + simulation + " GROUP BY tr.investor_id " + 
				"ORDER BY companyTotal DESC;";

		ResultSet rs = db.select(query);
		
		try {
			while(rs.next()){
				
				String[] str = {rs.getString("id"), rs.getString("name"), rs.getString("companyTotal")};
				
				alr.add(str);
				
			}
		} catch (SQLException e) {}
		
		db.closeConnection();
		return alr;
	}
	
	//Investors that have invested in the least number of companies
	public ArrayList getInvestorLeastCompany(int simulation) {
		
		// Create a database connection 
		db.openConnection();
		
		ArrayList<String[]> alr = new ArrayList<>(); 
		
		String query = "SELECT iv.investor_id  AS id, iv.investor_name AS name, " + 
				"COUNT(DISTINCT(tr.company_id)) AS companyTotal FROM transactions AS tr " + 
				"INNER JOIN investors AS iv ON iv.investor_id = tr.investor_id " + 
				"WHERE iv.simulation_id = " + simulation + " GROUP BY tr.investor_id " + 
				"ORDER BY companyTotal;";

		ResultSet rs = db.select(query);
		
		try {
			while(rs.next()){
				
				String[] str = {rs.getString("id"), rs.getString("name"), rs.getString("companyTotal")};
				
				alr.add(str);
				
			}
		} catch (SQLException e) {}
		
		db.closeConnection();
		return alr;
	}
	
	public int testConnection() throws Exception {
		
		return db.testConnection();
		
	}
	
}
