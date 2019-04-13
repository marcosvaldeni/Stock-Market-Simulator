package model;

import java.util.ArrayList;

public abstract class Company {
	
	private int id;
	private String name;
	private int shares;
	private double sharePrice;
	private ArrayList<Integer> transactions;
	
	public Company(int id, String name, int shares, double sharePrice) {
		this.id = id;
		this.name = name;
		this.shares = shares;
		this.sharePrice = sharePrice;
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

	public double getSharePrice() {
		return sharePrice;
	}

	public void setSharePrice(double sharePrice) {
		this.sharePrice = sharePrice;
	}
	
	public int getNumTrans() {
		return 0;
	}
	
	public void sellShare(int transaction) {
		transactions.add(transaction);
		shares--;
		valorizeShare();
	}
	
	public void depreciateShare() {
		sharePrice = sharePrice - (sharePrice * 0.2);
	}
	
	public void valorizeShare() {
		if ((transactions.size()%10) == 0) {
			sharePrice = sharePrice + (sharePrice * 0.2);
		}
	}
	
	public int getTransNum() {
		return transactions.size();
	}
	
	
}
