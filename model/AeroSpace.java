package model;

public class AeroSpace extends Company {
	
	private String type;

	public AeroSpace(int id, String name, int shares, double sharePrice) {
		super(id, name, shares, sharePrice);
		this.type = "AeroSpace";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
