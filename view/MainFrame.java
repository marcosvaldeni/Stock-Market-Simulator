package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;

import controller.Controller;

public class MainFrame extends JFrame {

	private Toolbar toolbar;
	private JTabbedPane tabpane;
	private JSplitPane splitPane;
	private SimulationTablePanel simulationTablePanel;
	private CompanyHighestCapitalTablePanel companyHighestCapitalTablePanel;
	private CompanyLowestCapitalTablePanel companyLowestCapitalTablePanel;
	private InvestorHighestShareTablePanel investorHighestShareTablePanel;
	private InvestorMostCompanyTablePanel investorMostCompanyTablePanel;
	private InvestorLowestShareTablePanel investorLowestShareTablePanel;
	private InvestorLeastCompanyTablePanel investorLeastCompanyTablePanel;
	private Controller controller;

	public MainFrame(String[] string) {
		super("Stock Market Simulator");

		simulationTablePanel = new SimulationTablePanel();
		companyHighestCapitalTablePanel = new CompanyHighestCapitalTablePanel();
		companyLowestCapitalTablePanel = new CompanyLowestCapitalTablePanel();
		investorHighestShareTablePanel = new InvestorHighestShareTablePanel();
		investorMostCompanyTablePanel = new InvestorMostCompanyTablePanel();
		investorLowestShareTablePanel = new InvestorLowestShareTablePanel();
		investorLeastCompanyTablePanel = new InvestorLeastCompanyTablePanel();
		controller = Controller.getController(string);

		toolbar = new Toolbar();
		tabpane = new JTabbedPane();
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, simulationTablePanel, tabpane);
		
		splitPane.setEnabled(false);
		
		splitPane.setOneTouchExpandable(true);
		
		tabpane.addTab("Companies with the Highest Capital", companyHighestCapitalTablePanel);
		tabpane.addTab("Companies with the Lowest Capital", companyLowestCapitalTablePanel);
		tabpane.addTab("Investors with the Highest number of Shares", investorHighestShareTablePanel);
		tabpane.addTab("Invested in the most Companies", investorMostCompanyTablePanel);
		tabpane.addTab("Investor with the Lowest number of Shares", investorLowestShareTablePanel);
		tabpane.addTab("Investors that have invested in the least number of the Companies", investorLeastCompanyTablePanel);
		
		setLayout(new BorderLayout());
		
		setData(controller.getSimulationId());
		simulationTablePanel.setData(controller.getSimulationList());
		
		setJMenuBar(createMenuBar());

		toolbar.setToolBarListener(new ButtonListener() {
			public void actionButton() {
				
				controller.createSimulation();
				setData(controller.getSimulationId());
				simulationTablePanel.setData(controller.getSimulationList());	
				refreshData();
				simulationTablePanel.refresh();
			}
		});
		
		simulationTablePanel.setSimulationTablePanelListener(new TableListener() {
			public void setSimulation(int id) {
				
				setData(id);	
				refreshData();

			}
		});

		add(toolbar, BorderLayout.NORTH);
		add(splitPane, BorderLayout.CENTER);

		setSize(1200, 900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
		private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu simMenu = new JMenu("Simulation");
		JMenuItem newSimulation = new JMenuItem("New Simulation");
		JMenuItem exitItem = new JMenuItem("Exit");
		
		simMenu.add(newSimulation);
		simMenu.addSeparator();
		simMenu.add(exitItem);
		
		JMenu windowMenu = new JMenu("Window");
		JMenu showMenu = new JMenu("Show");
		
		JCheckBoxMenuItem showSimulationList = new JCheckBoxMenuItem("Simulation List");
		showSimulationList.setSelected(true);
		
		showMenu.add(showSimulationList);
		windowMenu.add(showMenu);
		
		menuBar.add(simMenu);
		menuBar.add(windowMenu);
			
		showSimulationList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem) ev.getSource();
				
				if(menuItem.isSelected()) {
					splitPane.setDividerLocation((int)simulationTablePanel.getMinimumSize().getWidth());
				}
				
				simulationTablePanel.setVisible(menuItem.isSelected());
			}
		});
		
		return menuBar;
	}
		
	public void setData(int id) {
		companyHighestCapitalTablePanel.setData(controller.getCompanyHighestCapital(id));
		companyLowestCapitalTablePanel.setData(controller.getCompanyLowestCapital(id));
		investorHighestShareTablePanel.setData(controller.getInvestorHighestShare(id));
		investorMostCompanyTablePanel.setData(controller.getInvestorMostCompany(id));
		investorLowestShareTablePanel.setData(controller.getInvestorLowestShare(id));
		investorLeastCompanyTablePanel.setData(controller.getInvestorLeastCompany(id));
	}
	
	public void refreshData() {
		companyHighestCapitalTablePanel.refresh();
		companyLowestCapitalTablePanel.refresh();
		investorHighestShareTablePanel.refresh();
		investorMostCompanyTablePanel.refresh();
		investorLowestShareTablePanel.refresh();
		investorLeastCompanyTablePanel.refresh();
	}
}
