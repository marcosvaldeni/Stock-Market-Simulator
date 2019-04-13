package model;

public class Aero extends Company {
	
	private String type;

	public Aero(int id, String name, int shares, double sharePrice) {
		super(id, name, shares, sharePrice);
		this.type = "Aero";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
}
