package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class CompanyHighestCapitalTableModel extends AbstractTableModel {
	
	private ArrayList<String[]> db;
	
	private String[] colNames = {"Id", "Company", "Shares", "Capital"};
	
	public CompanyHighestCapitalTableModel() {
	}
	
	@Override
	public String getColumnName(int column) {
		return colNames[column];
	}

	public void setData(ArrayList<String[]> db) {
		this.db = db;
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public int getRowCount() {
		return db.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		String[] string = db.get(row);
		
		switch(col) {
		case 0:
			return string[0];
		case 1:
			return string[1];
		case 2:
			return string[2];
		case 3:
			return string[3];
		}
		
		return null;
	}

}
