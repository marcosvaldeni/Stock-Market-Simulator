package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {

	private int companyId;
	private int investorId;
	
	// Variables beginning, middle, end and surname are the statics parts that will compose investor names randomly
	private String[] beginning = { "Kr", "Ca", "Ra", "Mrok", "Cru", "Ray", "Bre", "Zed", "Drak", "Mor", "Jag", "Mer", "Jar", "Mjol", "Zork", "Mad", "Cry", "Zur", "Creo", "Azak", "Azur", "Rei", "Cro", "Mar", "Luk" };
	private String[] middle = { "air", "ir", "mi", "sor", "mee", "clo", "red", "cra", "ark", "arc", "miri", "lori",	"cres", "mur", "zer", "marac", "zoir", "slamar", "salmar", "urak" };
	private String[] end = { "d", "ed", "ark", "arc", "es", "er", "der", "tron", "med", "ure", "zur", "cred", "mur" };
	private String[] surname = {"Kass", "Goth", "Shirc", "Drobosh", "Trashtinn", "Xibos", "Mvommal", "Ngistrark", "Vrelmaki", "Kmpok", "Ktog", "Tirc", "Mvuss", "Mrehnas", "Xagh", "Rewreg", "Nukucto", "Ktakorgh", "Mverc", "Sarr"};
	
	// Variables on, two and three are the statics parts that will compose company names randomly
	private String[] one = { "Targaryen", "Stark", "Lannister", "Arryn ", "Tully ", "Greyjoy", "Baratheon ", "Tyrell ", "Martell ", "Frey", "Allyrion", "Amber", "Ambrose", "Blackwood", "Cressey", "Donniger", "Hawthorne", "Harroway", "Ironsmith", "Mallery", "Westford", "Bolton", "Tarly"};
	// Variable two will be used as type of a company
	private String[] two = { "Textile", "Automotive", "Mine", "Tech", "Aero", "AeroSpace", "Gas", "Cosmetics", "Petro", "Electric" };
	private String[] three = { "Association", "S.A.", "Corporation", "Limited", "LLP", "LLLP", "Limited Partnership", "General Partnership", "Sole Proprietorship" };

	public Generator(int companyId, int investorId) {
		
		this.companyId = companyId;
		this.investorId = investorId;
	}

    /**
     * Generates a new investor name
     * @returns A investor name
     */
	private String inverstorNameGen() {

		return beginning[Util.numberGen(0, beginning.length)] + middle[Util.numberGen(0, middle.length)] + end[Util.numberGen(0, end.length)] + " " + surname[Util.numberGen(0, surname.length)];

	}
	
    /**
     * Generates a new company name
     * @returns A company name as a array of Strings, the position [1] will be the company Type
     */
	private String[] companyNameGen() {

		String[] name = { one[Util.numberGen(0, one.length)], two[Util.numberGen(0,two.length)], three[Util.numberGen(0,three.length)] };

		return name;

	}

    /**
     * Generates 100 companies, with all its randomly generated attributes
     * @returns A ArrayList of 100 companies
     */
	public ArrayList<Company> companyGen() {

		ArrayList<Company> companies = new ArrayList<>();

		for (int i = 0; i < 100; i++) {

			String[] name = companyNameGen();

			Company company = CompanyFactory.getCompany(this.getCompanyId(), name[0] + " " + name[1] + " " + name[2],
					Util.numberGen(500, 1000), Util.numberGen(10, 100), name[1]);

			companies.add(company);
		}

		return companies;
	}

    /**
     * Generates 100 investors, with all its randomly generated attributes
     * @returns A ArrayList of 100 investors
     */
	public ArrayList<Investor> investorGen() {

		ArrayList<Investor> investors = new ArrayList<>();

		for (int i = 0; i < 100; i++) {
			Investor investor = new Investor.InvestorBuilder(this.getInvestorId(), this.inverstorNameGen(),
					Util.numberGen(1000, 10000)).build();
			investors.add(investor);
		}

		return investors;
	}

    /**
     * Generates a new investor id
     * @returns A integer, that will be an attribute of a investor
     */
	private int getInvestorId() {
		
		return ++investorId;
	}

    /**
     * Generates a new company id
     * @returns A integer, that will be an attribute of a company
     */
	private int getCompanyId() {
		
		return ++companyId;
	}

}