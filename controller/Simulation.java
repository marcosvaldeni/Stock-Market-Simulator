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
		System.out.println(getMinShare());
		System.out.println(getMaxBudget());
		transactionAmount = 0;
		this.rand = new Random();
		this.transactions = new ArrayList<>();
		this.raffleCompanies = new LinkedList<>();
		this.raffleInvestors = new LinkedList<>();;
	
		for (Company company : companies) {
			System.out.println("id: " + company.getId() + " name: " + company.getName() + " Share Price: " + company.getSharePrice());
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
			System.out.println(getMaxSharePrice());
			int transId = transId();
			Transaction transaction;
			System.out.println("---------------");
			int investorId = this.raffleInvestor();
			System.out.println(investorId);
			Investor investor = null;
			Company company = null;
			for (Investor inv : investors) {
				if (inv.getId() == investorId) {
					investor = inv;
				}
			}
			System.out.println("id: " + investor.getId() + " name: " + investor.getName() + " Budget: " + investor.getBudget());
			int companyId = this.raffleCompany(investor.getBudget());
			System.out.println(companyId);
			for (Company comp : companies) {
				if (comp.getId() == companyId) {
					company = comp;
				}
			}
			System.out.println("id: " + company.getId() + " name: " + company.getName() + " Share Price: " + company.getSharePrice());
			transaction = new Transaction(transId,investor.getId(), company.getId(), company.getSharePrice());
			investor.buyShare(transId, company.getSharePrice());
			company.sellShare(transId);
			transactions.add(transaction);
			
			if (transactionAmount%10 == 0) {
				for (Company comp : companies) {
					if (comp.getTransNum() == 0) {
						comp.depreciateShare();
					}
				}
			}
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
				if (minSharePrice > company.getSharePrice()) {
					minSharePrice = company.getSharePrice();
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
			if (minSharePrice > company.getSharePrice()) {
				minSharePrice = company.getSharePrice();
			} 
		}
		return minSharePrice;
	}
	
	private double getMaxBudget() {
		
		double maxBudget = Double.MIN_VALUE;
		for (Investor investor : investors) {
			if (maxBudget < investor.getBudget()) {
				maxBudget = investor.getBudget();
			} 
		}
		return maxBudget;
	}
	
	private double getMaxSharePrice() {
		
		double maxSharePrice = Double.MIN_VALUE;
		for (Company company : companies) {
			if (maxSharePrice < company.getSharePrice()) {
				maxSharePrice = company.getSharePrice();
			} 
		}
		return maxSharePrice;
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
			if (budget >= company.getSharePrice() && company.getShares() > 0 ) {
				raffleCompanies.add(company.getId());
			}
		}
	}
}
