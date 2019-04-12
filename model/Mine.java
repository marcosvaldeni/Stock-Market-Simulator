package model;

public class Mine extends Company {

	private String type;

	public Mine(int id, String name, int shares, double sherePrice) {
		super(id, name, shares, sherePrice);
		this.type = "Mine";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
