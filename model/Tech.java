package model;

public class Tech extends Company {
	
	private String type;

	public Tech(int id, String name, int shares, double sherePrice) {
		super(id, name, shares, sherePrice);
		this.type = "Tech";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
