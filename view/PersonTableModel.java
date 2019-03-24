package view;


import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Company;



public class PersonTableModel extends AbstractTableModel {
	
	private List<Company> db;
	
	private String[] colNames = {"ID", "Name", "Occupation", "Age Category", "Employment Category", "US Citizen", "Tax ID"};
	
	public PersonTableModel() {
	}
	
	
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return colNames[column];
	}



	public void setData(List<Company> db) {
		this.db = db;
	}

	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public int getRowCount() {
		return db.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		
		return null;
	}

}