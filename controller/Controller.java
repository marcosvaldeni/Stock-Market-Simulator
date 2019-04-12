package controller;

import java.util.ArrayList;
import java.util.List;

import dao.Database;
import model.Company;

public class Controller {
	
	private Database db = new Database();
	
	public Controller() {
 	
	}
	
	public void addCompany(Company company) {
		db.addCompany(company);
	}
	
	public List<Company> getCompany() {
		return db.getCompany();
	}

}
