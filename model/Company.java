package model;

import java.util.ArrayList;

public abstract class Company {
	
	private int id;
	private String name;
	private int shares;
	private float sharePrice;
	private String type;
	private ArrayList<Integer> transactions;
	
	public Company(int id, String name, int shares, float sharePrice, String type) {
		this.id = id;
		this.name = name;
		this.shares = shares;
		this.sharePrice = sharePrice;
		this.type = type;
		transactions = new ArrayList<>();
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
     * Get the shares budget content
     * @returns A integer, the data of shares
     */
	public int getShares() {
		return shares;
	}

    /**
     * Set a data into the shares
     * @param shares, The new data to be set into the shares
     */
	public void setShares(int shares) {
		this.shares = shares;
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

    /**
     * Get the attribute type content
     * @returns A string, the data of type
     */
	public String getType() {
		return type;
	}

    /**
     * Set a data into the type
     * @param type, The new data to be set into the type
     */
	public void setType(String type) {
		this.type = type;
	}

    /**
     * Set a data into the type
     * @param type, The new data to be set into the type
     */
	public void sellShare(int transaction) {
		transactions.add(transaction);
		shares--;
		riseSharePrice();
	}
	
    /**
     * Depreciate share price two per cent.
     */
	public void depreciateShare() {
		sharePrice -= (float) (sharePrice - (sharePrice * 0.2));
	}
	
    /**
     * Rise the share price two per cent, every ten shares sold.
     */
	public void riseSharePrice() {
		if ((transactions.size()%10) == 0) {
			sharePrice += (float) (sharePrice * 2);
		}
	}
	
    /**
     * Get the number of transactions of the company
     * @returns A integer, the number of transactions
     */
	public int getTransNum() {
		return transactions.size();
	}
	
	
}
