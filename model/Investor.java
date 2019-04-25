package model;

import java.util.ArrayList;

public class Investor {
	
	private int id;
	private String name;
	private float budget;
	private ArrayList<Integer> transactions;
	
	public Investor(int id, String name, float budget) {
		this.id = id;
		this.name = name;
		this.budget = budget;
		this.transactions = new ArrayList<>();
	}

    /**
     * Get the attribute id content
     * @returns A integer, the data of id
     */
	public int getId() {
		return id;
	}

    /**
     * Set a data into the id
     * @param id, The new data to be set into the id
     */
	public void setId(int id) {
		this.id = id;
	}

    /**
     * Get the attribute name content
     * @returns A string, the data of name
     */
	public String getName() {
		return name;
	}

    /**
     * Set a data into the name
     * @param name, The new data to be set into the name
     */
	public void setName(String name) {
		this.name = name;
	}

    /**
     * Get the attribute budget content
     * @returns A float, the data of budget
     */
	public float getBudget() {
		return budget;
	}

    /**
     * Set a data into the budget
     * @param budget, The new data to be set into the budget
     */
	public void setBudget(float budget) {
		this.budget = budget;
	}
	
    /**
     * Every time the investor buys an share, the buyShare method is called 
     * and with it comes the amount spent. The new transaction id is added to 
     * the investor list and the amount spent is deducted from the budget.
     */
	public void buyShare(int transaction, float sharePrice) {
		transactions.add(transaction);
		budget = budget - sharePrice;
	}
	
    /**
     * ...
     */
	public static class InvestorBuilder{
		
		private int id;
		private String name;
		private float budget;
		
	    /**
	     * ...
	     * @param id, 
	     * @param name, 
	     * @param budget, 
	     */
		public InvestorBuilder(int id, String name, float budget) {
			this.id = id;
			this.name = name;
			this.budget = budget;
		}
		
	    /**
	     * ...
	     */
		public Investor build() {
			return new Investor(id,  name,  budget);
		}
		
	}
	
}
