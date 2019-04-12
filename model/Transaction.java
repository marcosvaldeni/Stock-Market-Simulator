package model;

public class Transaction {
	
	private int id;
	private int investor;
	private int company;
	private double sharePrice;
	
	public Transaction(int id, int investor, int company, double sharePrice) {
		this.id = id;
		this.investor = investor;
		this.company = company;
		this.sharePrice = sharePrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getInvestor() {
		return investor;
	}

	public void setInvestor(int investor) {
		this.investor = investor;
	}

	public int getCompany() {
		return company;
	}

	public void setCompany(int company) {
		this.company = company;
	}

	public double getSharePrice() {
		return sharePrice;
	}

	public void setSharePrice(double sharePrice) {
		this.sharePrice = sharePrice;
	}
	
}
