package model;

public class CompanyFactory {

    /**
     * At the time of construction of a new company, the factoryCompany 
     * method is called and based on the type of companies, this method will 
     * return an instance appropriate.
     * @returns A new object based on the type
     */
	public static Company getCompany(int id, String name, int shares, float sharePrice, String type) {

		if (type.equals("Textile")) {
			return new Textile(id, name, shares, sharePrice, type);
		} else if (type.equals("Automotive")) {
			return new Automotive(id, name, shares, sharePrice, type);
		} else if (type.equals("Mine")) {
			return new Mine(id, name, shares, sharePrice, type);
		} else if (type.equals("Tech")) {
			return new Tech(id, name, shares, sharePrice, type);
		} else if (type.equals("Aero")) {
			return new Aero(id, name, shares, sharePrice, type);
		} else if (type.equals("AeroSpace")) {
			return new AeroSpace(id, name, shares, sharePrice, type);
		} else if (type.equals("Gas")) {
			return new Gas(id, name, shares, sharePrice, type);
		} else if (type.equals("Cosmetics")) {
			return new Cosmetics(id, name, shares, sharePrice, type);
		} else if (type.equals("Petro")) {
			return new Petro(id, name, shares, sharePrice, type);
		} else if (type.equals("Electric")) {
			return new Electric(id, name, shares, sharePrice, type);
		} else {
			return null;
		}

	}
}
