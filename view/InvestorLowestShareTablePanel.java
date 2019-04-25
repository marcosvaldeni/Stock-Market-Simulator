package view;


import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Company;


public class InvestorLowestShareTablePanel extends JPanel {
	
	private JTable table;
	private InvestorLowestShareTableModel investorLowestShareTableModel;
	
	public InvestorLowestShareTablePanel() {
		
		investorLowestShareTableModel = new InvestorLowestShareTableModel();
		table = new JTable(investorLowestShareTableModel);
		
		setLayout(new BorderLayout());
		
		add(new JScrollPane(table), BorderLayout.CENTER);
	}
	
	public void setData(List<String[]> db) {
		investorLowestShareTableModel.setData(db);
	}
	
	public void refresh() {
		investorLowestShareTableModel.fireTableDataChanged();
	}
}
