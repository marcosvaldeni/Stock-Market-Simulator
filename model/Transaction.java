package model;

public class Transaction {
	
	private int id;
	private int investor;
	private int company;
	private float sharePrice;
	
	public Transaction(int id, int investor, int company, float sharePrice) {
		this.id = id;
		this.investor = investor;
		this.company = company;
		this.sharePrice = sharePrice;
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
     * Get the attribute investor content
     * @returns A integer, the data of investor
     */
	public int getInvestor() {
		return investor;
	}

    /**
     * Set a data into the investor
     * @param investor, The new data to be set into the investor
     */
	public void setInvestor(int investor) {
		this.investor = investor;
	}

    /**
     * Get the attribute company content
     * @returns A integer, the data of company
     */
	public int getCompany() {
		return company;
	}

    /**
     * Set a data into the company
     * @param company, The new data to be set into the company
     */
	public void setCompany(int company) {
		this.company = company;
	}

    /**
     * Get the attribute sharePrice content
     * @returns A float, the data of sharePrice
     */
	public float getSharePrice() {
		return sharePrice;
	}

    /**
     * Set a data into the sharePrice
     * @param sharePrice, The new data to be set into the sharePrice
     */
	public void setSharePrice(float sharePrice) {
		this.sharePrice = sharePrice;
	}
	
}
