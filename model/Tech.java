package model;

public class Tech extends Company {
	
	private String type;

	public Tech(int id, String name, int shares, double sharePrice) {
		super(id, name, shares, sharePrice);
		this.type = "Tech";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
