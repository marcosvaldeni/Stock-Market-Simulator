package view;


import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Company;


public class InvestorMostCompanyTablePanel extends JPanel {
	
	private JTable table;
	private InvestorMostCompanyTableModel investorMostCompanyTableModel;
	
	public InvestorMostCompanyTablePanel() {
		
		investorMostCompanyTableModel = new InvestorMostCompanyTableModel();
		table = new JTable(investorMostCompanyTableModel);
		
		setLayout(new BorderLayout());
		
		add(new JScrollPane(table), BorderLayout.CENTER);
	}
	
	public void setData(List<String[]> db) {
		investorMostCompanyTableModel.setData(db);
	}
	
	public void refresh() {
		investorMostCompanyTableModel.fireTableDataChanged();
	}
}
