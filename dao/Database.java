package dao;

import java.util.ArrayList;
import java.util.List;

import model.Company;

public class Database {
	
	private ArrayList<Company> Companys;
	
	public Database() {
		Companys = new ArrayList<Company>();
	}
	
	public void addCompany(Company company) {
		Companys.add(company);
	}
	
	public List<Company> getCompany() {
		return Companys;
	}
}
