package model;

import java.util.ArrayList;

public class Investor {
	
	private int id;
	private String name;
	private double budget;
	private ArrayList<Integer> transactions;
	
	public Investor(int id, String name, double budget) {
		this.id = id;
		this.name = name;
		this.budget = budget;
		this.transactions = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public ArrayList<Integer> getTransactions() {
		return transactions;
	}

	public void setTransactions(ArrayList<Integer> transactions) {
		this.transactions = transactions;
	}
	
	public void buyShare(double sharePrice) {
		budget -= sharePrice;
	}
	
}
