package model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Simulation {
	
	private int transactionId;
	private Generator gen;
	private ArrayList<Company> companies;
	private ArrayList<Investor> investors;
	private ArrayList<Transaction> transactions;
	private LinkedList<Integer> raffleCompanies;
	private LinkedList<Integer> raffleInvestors;
	
	public Simulation(int companyId, int investorId, int transactionId) {
		
		this.gen = new Generator(companyId, investorId);
		this.companies = gen.companyGen();
		this.investors = gen.investorGen();
		this.transactions = new ArrayList<>();
		this.raffleCompanies = new LinkedList<>();
		this.raffleInvestors = new LinkedList<>();
		this.transactionId = transactionId;
		
		// Runs all possibles transactions
		do {
			transaction();
		} while (continues());

	}
	
    /**
     * This method runs through the entire list of investors, checked one by one 
     * those who have enough budget to buy the cheapest  company shares. Thus 
     * generating a list of valid investors.
     * @returns A LinkedList of integer
     */
	private void selectInvestors() {
		// Clear the previously list if exists
		this.raffleInvestors.clear();
		
		float minSharePrice = this.getMinSharePrice();
		for (int i = 0; i < investors.size(); i++) {
			if (minSharePrice <= investors.get(i).getBudget() && investors.get(i).getBudget() > 0.009) {
				raffleInvestors.add(i);
			}
		}
	}
	
    /**
     * This method runs through the entire list of companies, checking one by one 
     * the ones that have the value of shares compatible with the investor already 
     * selected (selected by the method selectInvestors). Thus generating a list of 
     * companies available to the investor in question.
     * @param budget, The budget that will be used as a maximal share price
     * @returns A LinkedList of integer
     */
	private void selectCompanies(float budget) {
		// Clear the previously list if exists
		raffleCompanies.clear();
		
		for (int i = 0; i < companies.size(); i++) {
			if (budget >= companies.get(i).getSharePrice() && companies.get(i).getShares() > 0) {
				raffleCompanies.add(i);
			}
		}
	}
	
    /**
     * If the simulation has available resources, this method 
     * will randomly select (when possible) an investor and a company 
     * and create a new transaction with its due attributes.
     */
	private void transaction() {
		
		try {
			// Raffle an able investor for a new transaction
			int investorId = this.raffleInvestor();
			
			// Raffle an able company for a new transaction
			int companyId = this.raffleCompany(investors.get(investorId).getBudget());

			// Get a new transaction id
			int transId = transId();
			
			// Create a new transaction
			Transaction transaction = new Transaction(transId,investors.get(investorId).getId(), companies.get(companyId).getId(), companies.get(companyId).getSharePrice());
			
			// Sum a new transaction number to the investor list and reduces the value of the investor's budget
			investors.get(investorId).buyShare(transId, companies.get(companyId).getSharePrice());
			
			// Reduces a number on company shares list and check if is necessary increase the shares price
			companies.get(companyId).sellShare(transId);
			
			// Add the new transaction to the transaction ArrayList
			transactions.add(transaction);
			
			// Check if is necessary to depreciate any company shares
			depreciateShare();
		} catch (Exception e) {}

	}
	
    /**
     * For every ten transactions made, companies that have never sold a stock should 
     * depreciate their price by two percent. In order to perform this procedure, 
     * this method checks the number of transactions and lower the price when necessary.
     */
	private void depreciateShare() {
		if (transactionId % 10 == 0) {
			for (Company comp : companies) {
				if (comp.getTransNum() == 0) {
					comp.depreciateShare();
				}
			}
		}
	}
	
    /**
     * The method continues is checking on each transaction creation if
     * the remaining resources are sufficient for a new transaction.
     */
	private boolean continues() {
		
		boolean check;
		int shares = 0;
		
		// Count how many shares are still available
		for (Company company : companies) {
			shares =+ company.getShares();
		}
		
		// Check if are there enough shares for more transaction
		if (shares > 0) {
			
			// Receives the highest investor budget
			float maxBudget = getMaxBudget();
			// Receives the smallest share price
			float minSharePrice = getMinSharePrice();
			
			// Check if the highest investor budget can buy the smallest share price
			if (maxBudget >= minSharePrice) {
				check = true;
			} else {
				check = false;
			}
			
		} else {
			check = false;
		}
		
		return check;
	}
	
    /**
     * To select a investor with values that are compatible with the smallest company share, 
     * the raffleInvestor calls selectInvestors method to select investors within the range value.
     * @returns A integer, that is the position of the raffled investor
     */
	private int raffleInvestor() {
		// Select all investors with compatible budget
		this.selectInvestors();
		if (raffleInvestors.size() > 1 ) {
			return  raffleInvestors.get(Util.numberGen(0, raffleInvestors.size()));
		} else {
			return  raffleInvestors.get(0);
		}
	}
	
    /**
     * To select a company with values that are compatible with the investor's budget, 
     * the raffleCompany calls selectCompanies method to select companies within the range.
     * @param budget, The budget that will be used as a maximal share price
     * @returns A integer, that is the position of the raffled company
     */
	private int raffleCompany(float budget) {
		// Select all companies with compatible share price
		this.selectCompanies(budget);
		if (raffleCompanies.size() > 1) {
			return raffleCompanies.get(Util.numberGen(0, raffleCompanies.size()));
		} else {
			return raffleCompanies.get(0);
		}
	}
	
    /**
     * Generates a new transaction id.
     * @returns A integer, that will be an attribute of a transaction
     */
	private int transId() {
		return ++transactionId;
	}
	
    /**
     * Get the highest budget value among all the investors on the list.
     * @returns A float that is the highest budget between all investors
     */
	private float getMaxBudget() {
		float maxBudget = Float.MIN_VALUE;
		for (Investor investor : investors) {
			// Check if this budget is grater than the previous one and is worth more than 0.009 of cents
			if (maxBudget < investor.getBudget() && investor.getBudget() > 0.009) {
				maxBudget = investor.getBudget();
			} 
		}
		return maxBudget;
	}
	
    /**
     * In order to get the smallest share price between all companies, 
     * this method runs through the list of companies and select the small value.
     * @returns A float that is the smallest share price between all companies
     */
	private float getMinSharePrice() {
		float minSharePrice = Float.MAX_VALUE;
		for (Company company : companies) {
			// Check if this share is smaller than the previous one and is worth more than 0.009 of cents
			if (minSharePrice > company.getSharePrice() && company.getSharePrice() > 0.009) {
				minSharePrice = company.getSharePrice();
			} 
		}
		return minSharePrice;
	}

    /**
     * Get all companies after the simulation
     * @returns A ArrayList of companies
     */
	public ArrayList<Company> getCompanies() {
		return companies;
	}

    /**
     * Get all investors after the simulation
     * @returns A ArrayList of investors
     */
	public ArrayList<Investor> getInvestors() {
		return investors;
	}

    /**
     * Get all transactions after the simulation
     * @returns A ArrayList of transactions
     */
	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}
	
}
