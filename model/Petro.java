package model;

public class Petro extends Company {

	private String type;

	public Petro(int id, String name, int shares, double sherePrice) {
		super(id, name, shares, sherePrice);
		this.type = "Petro";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
