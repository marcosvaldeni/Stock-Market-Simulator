package view;


import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class InvestorLeastCompanyTablePanel extends JPanel {
	
	private JTable table;
	private InvestorLeastCompanyTableModel investorLeastCompanyTableModel;
	
	public InvestorLeastCompanyTablePanel() {
		
		investorLeastCompanyTableModel = new InvestorLeastCompanyTableModel();
		table = new JTable(investorLeastCompanyTableModel);
		
		setLayout(new BorderLayout());
		
		add(new JScrollPane(table), BorderLayout.CENTER);
	}
	
	public void setData(ArrayList<String[]> db) {
		investorLeastCompanyTableModel.setData(db);
	}
	
	public void refresh() {
		investorLeastCompanyTableModel.fireTableDataChanged();
	}
}
