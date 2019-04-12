package model;

public class Gas extends Company {

	private String type;

	public Gas(int id, String name, int shares, double sherePrice) {
		super(id, name, shares, sherePrice);
		this.type = "Gas";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
