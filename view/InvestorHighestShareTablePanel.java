package view;


import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Company;


public class InvestorHighestShareTablePanel extends JPanel {
	
	private JTable table;
	private InvestorHighestShareTableModel investorHighestShareTableModel;
	
	public InvestorHighestShareTablePanel() {
		
		investorHighestShareTableModel = new InvestorHighestShareTableModel();
		table = new JTable(investorHighestShareTableModel);
		
		setLayout(new BorderLayout());
		
		add(new JScrollPane(table), BorderLayout.CENTER);
	}
	
	public void setData(ArrayList<String[]> db) {
		investorHighestShareTableModel.setData(db);
	}
	
	public void refresh() {
		investorHighestShareTableModel.fireTableDataChanged();
	}
}
