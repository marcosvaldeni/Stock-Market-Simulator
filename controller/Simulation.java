package controller;

import java.util.List;

import model.Company;
import model.Investor;
import model.Transaction;

public class Simulation {
	
	Generator gen = new Generator();
	List<Company> companies = gen.CompanyGen();
	List<Investor> investors = gen.InvestorGen();
	List<Transaction> transactions;
	
	public Simulation() {
		
	
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
			
		} while (contin());

		
	}
	
	boolean contin() {
		
		boolean check;
		
		double minBudget = Double.MAX_VALUE;
		for (Investor investor : investors) {
			if (minBudget > investor.getBudget()) {
				minBudget = investor.getBudget();
			} 
		}
		
		double minSharePrice = Double.MAX_VALUE;
		for (Company company : companies) {
			if (minSharePrice > company.getShares()) {
				minSharePrice = company.getShares();
			} 
		}
		
		if (minBudget >= minSharePrice) {
			check = true;
		} else {
			check = false;
		}
		
		return check;
	}
}
