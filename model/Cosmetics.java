package model;

public class Cosmetics extends Company {

	private String type;

	public Cosmetics(int id, String name, int shares, double sharePrice) {
		super(id, name, shares, sharePrice);
		this.type = "Cosmetics";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
