package model;

public class CompanyFactory {

	public static Company getCompany(int id, String name, int shares, double sharePrice, String type) {

		if (type.equals("Textile")) {
			return new Textile(id, name, shares, sharePrice);
		} else if (type.equals("Automotive")) {
			return new Automotive(id, name, shares, sharePrice);
		} else if (type.equals("Mine")) {
			return new Mine(id, name, shares, sharePrice);
		} else if (type.equals("Tech")) {
			return new Tech(id, name, shares, sharePrice);
		} else if (type.equals("Aero")) {
			return new Aero(id, name, shares, sharePrice);
		} else if (type.equals("AeroSpace")) {
			return new AeroSpace(id, name, shares, sharePrice);
		} else if (type.equals("Gas")) {
			return new Gas(id, name, shares, sharePrice);
		} else if (type.equals("Cosmetics")) {
			return new Cosmetics(id, name, shares, sharePrice);
		} else if (type.equals("Petro")) {
			return new Petro(id, name, shares, sharePrice);
		} else if (type.equals("Electric")) {
			return new Electric(id, name, shares, sharePrice);
		} else {
			return null;
		}

	}
}
