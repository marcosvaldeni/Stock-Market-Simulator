package model;

public class Aero extends Company {
	
	private String type;

	public Aero(int id, String name, int shares, double sherePrice) {
		super(id, name, shares, sherePrice);
		this.type = "Aero";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
}
