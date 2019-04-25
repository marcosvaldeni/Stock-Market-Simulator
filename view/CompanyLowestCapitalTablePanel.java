package view;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;

import model.Company;

public class CompanyLowestCapitalTablePanel extends JPanel {
	
	private JTable table;
	private CompanyLowestCapitalTableModel companyLowestCapitalTableModel;
	
	public CompanyLowestCapitalTablePanel() {
		
		companyLowestCapitalTableModel = new CompanyLowestCapitalTableModel();
		table = new JTable(companyLowestCapitalTableModel);
		
		setLayout(new BorderLayout());
		
		add(new JScrollPane(table), BorderLayout.CENTER);
	}
	
	public void setData(List<String[]> db) {
		companyLowestCapitalTableModel.setData(db);
	}
	
	public void refresh() {
		companyLowestCapitalTableModel.fireTableDataChanged();
	}
}
