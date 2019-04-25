package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;

public class SimulationTablePanel extends JPanel {
	
	private JTable table;
	private SimulationTableModel simulationTableModel;
	private TableListener tableListener;
	
	public SimulationTablePanel() {
		
		setMinimumSize(new Dimension(350, 400));
		Dimension dim = getPreferredSize();
		dim.width = 350;
		setPreferredSize(dim);
		
		simulationTableModel = new SimulationTableModel();
		table = new JTable(simulationTableModel);
		
		table.setRowHeight(20);
		
		TableColumnModel cmodel = table.getColumnModel();
		cmodel.getColumn(0).setPreferredWidth(10);
		cmodel.getColumn(1).setPreferredWidth(50);
		cmodel.getColumn(2).setPreferredWidth(150);
		
		table.addMouseListener(new MouseAdapter() {
		
			public void mouseClicked(MouseEvent e) {
				
				int row = table.rowAtPoint(e.getPoint());
				
				if(e.getClickCount() == 2) {

					if(tableListener != null) {
						tableListener.setSimulation(row+1);
					}
					
				}
			}
		});
		
		setLayout(new BorderLayout());
		
		add(new JScrollPane(table), BorderLayout.CENTER);
	}
	
	public void setData(List<String[]> db) {
		simulationTableModel.setData(db);
	}
	
	public void refresh() {
		simulationTableModel.fireTableDataChanged();
	}
	
	public void setSimulationTablePanelListener(TableListener listener) {
		this.tableListener = listener;
	}
}
