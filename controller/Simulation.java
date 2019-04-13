package controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import model.Company;
import model.Investor;
import model.Transaction;

public class Simulation {
	
	private int transactionAmount;
	Generator gen = new Generator();
	Random rand;
	List<Company> companies = gen.CompanyGen();
	List<Investor> investors = gen.InvestorGen();
	ArrayList<Transaction> transactions;
	LinkedList<Integer> raffleCompanies;
	LinkedList<Integer> raffleInvestors;
	
	public Simulation() {
		transactionAmount = 0;
		this.rand = new Random();
		this.transactions = new ArrayList<>();
		this.raffleCompanies = new LinkedList<>();
		this.raffleInvestors = new LinkedList<>();;
	
		for (Company company : companies) {
			System.out.println("id: " + company.getId() + " name: " + company.getName() + " Share Price: " + company.getSherePrice());
		}
		
		int shares = 0;
		for (Company company : companies) {
			shares += company.getShares();
		}
		

		System.out.println();
		
		for (Investor investor : investors) {
			System.out.println("id: " + investor.getId() + " name: " + investor.getName() + " Share Price: " + investor.getBudget());
		}
	

		
		do {
			System.out.println("---------------");
			int investorId = this.raffleInvestor();
			Investor investor = null;
			Company company = null;
			for (Investor inv : investors) {
				if (inv.getId() == investorId) {
					investor = inv;
				}
			}
			System.out.println("id: " + investor.getId() + " name: " + investor.getName() + " Budget: " + investor.getBudget());
			int companyId = this.raffleCompany(investor.getBudget());
			for (Company comp : companies) {
				if (comp.getId() == companyId) {
					company = comp;
				}
			}
			System.out.println("id: " + company.getId() + " name: " + company.getName() + " Share Price: " + company.getSherePrice());
			investor.buyShare(company.getSherePrice());
			company.sellShare();
			transId();
		} while (contin());
		System.out.println(transactionAmount);
		
	}
	
	boolean contin() {
		
		boolean check;
		int shares = 0;
		
		for (Company company : companies) {
			shares =+ company.getShares();
		}
		
		if (shares > 0) {
			
			double maxBudget = Double.MIN_VALUE;
			for (Investor investor : investors) {
				if (maxBudget < investor.getBudget()) {
					maxBudget = investor.getBudget();
				} 
			}
			
			double minSharePrice = Double.MAX_VALUE;
			for (Company company : companies) {
				if (minSharePrice > company.getSherePrice()) {
					minSharePrice = company.getSherePrice();
				} 
			}
			
			if (maxBudget >= minSharePrice) {
				check = true;
			} else {
				check = false;
			}
			
		} else {
			check = false;
		}
		
		return check;
	}
	
	int raffleInvestor() {
		this.selectInvestors();
		
		if (raffleInvestors.size() > 1 ) {
			return  raffleInvestors.get(rand.nextInt(raffleInvestors.size() - 1) + 1);
		} else {
			return  raffleInvestors.get(0);
		}

	}
	
	int raffleCompany(double budget) {
		this.selectCompanies(budget);
		if (raffleCompanies.size() > 1) {
			return raffleCompanies.get(rand.nextInt(raffleCompanies.size() - 1) + 1);
		} else {
			return raffleCompanies.get(0);
		}

	}
	
	private int transId() {
		return this.transactionAmount++;
	}
	
	private double getMinShare() {
		
		double minSharePrice = Double.MAX_VALUE;
		for (Company company : companies) {
			if (minSharePrice > company.getSherePrice()) {
				minSharePrice = company.getSherePrice();
			} 
		}
		return minSharePrice;
	}
	
	private void selectInvestors() {
		this.raffleInvestors.clear();
		double minSharePrice = this.getMinShare();
		for (Investor investor : investors) {
			if (minSharePrice <= investor.getBudget()) {
				raffleInvestors.add(investor.getId());
			}
		}
	}
	
	private void selectCompanies(double budget) {
		raffleCompanies.clear();
		for (Company company : companies) {
			if (budget >= company.getSherePrice() && company.getShares() > 0 ) {
				raffleCompanies.add(company.getId());
			}
		}
	}
}
