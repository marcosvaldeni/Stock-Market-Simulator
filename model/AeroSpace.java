package model;

public class AeroSpace extends Company {
	
	private String type;

	public AeroSpace(int id, String name, int shares, double sherePrice) {
		super(id, name, shares, sherePrice);
		this.type = "AeroSpace";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
