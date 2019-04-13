package model;

public class Electric extends Company {

	private String type;

	public Electric(int id, String name, int shares, double sharePrice) {
		super(id, name, shares, sharePrice);
		this.type = "Electric";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
