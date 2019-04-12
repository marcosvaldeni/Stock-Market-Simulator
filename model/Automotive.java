package model;

public class Automotive extends Company {

	private String type;

	public Automotive(int id, String name, int shares, double sherePrice) {
		super(id, name, shares, sherePrice);
		this.type = "Automotive";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
