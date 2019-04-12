package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.Company;
import model.CompanyFactory;
import model.Investor;

public class Generator {

	private String[] Beginning = { "Kr", "Ca", "Ra", "Mrok", "Cru", "Ray", "Bre", "Zed", "Drak", "Mor", "Jag",
			"Mer", "Jar", "Mjol", "Zork", "Mad", "Cry", "Zur", "Creo", "Azak", "Azur", "Rei", "Cro", "Mar", "Luk" };
	private String[] Middle = { "air", "ir", "mi", "sor", "mee", "clo", "red", "cra", "ark", "arc", "miri",
			"lori", "cres", "mur", "zer", "marac", "zoir", "slamar", "salmar", "urak" };
	private String[] End = { "d", "ed", "ark", "arc", "es", "er", "der", "tron", "med", "ure", "zur", "cred",
			"mur" };
	private String[] one = { "Kiwi ", "Coconuts ", "Plum ", "Big ", "Mega ", "Giga ", "Ultra ", "Hyper " };
	//private String[] two = { "Software ", "Tech ", "Hardare ", "AirLine ", "Helth ", "Petro ", "Gas ", "Mine ",
	//		"Games " };
	
	private String[] three = {"Association", "S.A.", "Corporation", "Limited", "LLP", "LLLP", "Limited Partnership", "General Partnership","Sole Proprietorship"};
	private String[] type = { "Textile", "Automotive", "Mine", "Tech", "Aero", "AeroSpace", "Gas", "Cosmetics", "Petro", "Electric" };
	private Random rand;
	
	public Generator() {
		this.rand = new Random();
	}

	public String InverstorNameGen() {

		return Beginning[rand.nextInt(Beginning.length)] + Middle[rand.nextInt(Middle.length)]
				+ End[rand.nextInt(End.length)];

	}
	
	public String TypeGen() {

		return type[rand.nextInt(type.length)];

	}

	public String CompanyNameGen() {

		return one[rand.nextInt(one.length)] + three[rand.nextInt(three.length)];

	}
	
	public double AmountGen(int min, int max) {


		double result = min + (max - min) * rand.nextDouble();
		
		return result;

	}
	
	public int NumberGen(int min, int max) {


		int result = rand.nextInt(max - min) + min;
		
		return result;

	}
	
	public List<Company> CompanyGen(){
		
		ArrayList<Company> companies = new ArrayList<>();
		
		for (int i = 0; i < 100; i++) {

			Company company = CompanyFactory.getCompany(i+1, this.CompanyNameGen(), this.NumberGen(500,1000), this.AmountGen(10,100), this.TypeGen());

			
			companies.add(company);
		}
		
		return companies;
	}
	
	public List<Investor> InvestorGen(){
		
		ArrayList<Investor> investors = new ArrayList<>();
		
		for (int i = 100; i > 0; i--) {
			Investor investor = new Investor(i+1, InverstorNameGen(), AmountGen(1000, 10000));
			investors.add(investor);
		}
		
		return investors;
	}

}