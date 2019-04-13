package model;

public class Petro extends Company {

	private String type;

	public Petro(int id, String name, int shares, double sharePrice) {
		super(id, name, shares, sharePrice);
		this.type = "Petro";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
