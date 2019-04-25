package view;


import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;


public class CompanyHighestCapitalTablePanel extends JPanel {
	
	private JTable table;
	private CompanyHighestCapitalTableModel companyHighestCapitalTableModel;
	
	public CompanyHighestCapitalTablePanel() {
		
		companyHighestCapitalTableModel = new CompanyHighestCapitalTableModel();
		table = new JTable(companyHighestCapitalTableModel);
		
		TableColumnModel cmodel = table.getColumnModel();
		cmodel.getColumn(0).setPreferredWidth(10);
		cmodel.getColumn(1).setPreferredWidth(200);
		cmodel.getColumn(2).setPreferredWidth(10);
		cmodel.getColumn(3).setPreferredWidth(50);
		
		setLayout(new BorderLayout());
		
		add(new JScrollPane(table), BorderLayout.CENTER);
	}
	
	public void setData(ArrayList<String[]> db) {
		companyHighestCapitalTableModel.setData(db);
	}
	
	public void refresh() {
		companyHighestCapitalTableModel.fireTableDataChanged();
	}
}
