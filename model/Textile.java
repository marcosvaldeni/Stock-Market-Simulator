package model;

public class Textile extends Company {

	private String type;

	public Textile(int id, String name, int shares, double sharePrice) {
		super(id, name, shares, sharePrice);
		this.type = "Textile";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
