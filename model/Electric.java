package model;

public class Electric extends Company {

	private String type;

	public Electric(int id, String name, int shares, double sherePrice) {
		super(id, name, shares, sherePrice);
		this.type = "Electric";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
