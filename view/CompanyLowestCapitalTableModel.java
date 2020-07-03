package view;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class CompanyLowestCapitalTableModel extends AbstractTableModel {
	
	private List<String[]> db;
	
	private String[] colNames = {"Id", "Name", "Capital"};
	
	public CompanyLowestCapitalTableModel() {
	}
	
	@Override
	public String getColumnName(int column) {
		return colNames[column];
	}

	public void setData(List<String[]> db) {
		this.db = db;
	}

	@Override
	public int getColumnCount() {
		return 3;
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
		}
		
		return null;
	}

}
