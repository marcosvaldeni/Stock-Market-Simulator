package model;

import java.util.ArrayList;

public abstract class Company {
	
	private int id;
	private String name;
	private int shares;
	private double sherePrice;
	private ArrayList<Integer> transactions;
	
	public Company(int id, String name, int shares, double sherePrice) {
		this.id = id;
		this.name = name;
		this.shares = shares;
		this.sherePrice = sherePrice;
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

	public int getShares() {
		return shares;
	}

	public void setShares(int shares) {
		this.shares = shares;
	}

	public double getSherePrice() {
		return sherePrice;
	}

	public void setSherePrice(double sherePrice) {
		this.sherePrice = sherePrice;
	}
	
	public int getNumTrans() {
		return 0;
	}
	
	
}
