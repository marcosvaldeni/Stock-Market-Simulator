import java.util.List;

import controller.Generator;
import model.Company;
import model.Investor;

public class Test {

	public static void main(String[] args) {

		Generator gen = new Generator();
		List<Company> companies = gen.CompanyGen();
		List<Investor> investors = gen.InvestorGen();
		
		for (Company company : companies) {
			System.out.println("id: " + company.getId() + " name: " + company.getName() + " Share Price: " + company.getSherePrice());
		}
		
		int shares = 0;
		for (Company company : companies) {
			shares += company.getShares();
		}
		
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
		
		System.out.println();
		
		for (Investor investor : investors) {
			System.out.println("id: " + investor.getId() + " name: " + investor.getName() + " Share Price: " + investor.getBudget());
		}
	
		
		System.out.println("min budget: " + minBudget);
		System.out.println("min share: " + minSharePrice);

	}

}
