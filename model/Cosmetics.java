package model;

public class Cosmetics extends Company {

	private String type;

	public Cosmetics(int id, String name, int shares, double sherePrice) {
		super(id, name, shares, sherePrice);
		this.type = "Cosmetics";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
