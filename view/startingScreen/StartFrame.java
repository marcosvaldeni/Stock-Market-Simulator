package view.startingScreen;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;

import controller.Controller;
import view.MainFrame;

public class StartFrame extends JFrame {

	private SettingPanel settingPanel;
	private Controller controller;

	public StartFrame() {
		super("Stock Market Simulator");

		settingPanel = new SettingPanel();
		
		setLayout(new BorderLayout());
		
		settingPanel.setSettingListener(new SettingListener() {
			public void actionButton(String[] string) {
				try {
					controller = Controller.getController(string);
					
					if (controller.testConnection()) {
						JOptionPane.showMessageDialog(StartFrame.this, "Connection established successfully!", "Database Message", JOptionPane.INFORMATION_MESSAGE);
						new MainFrame(string);
						dispose();
					} else {
						JOptionPane.showMessageDialog(StartFrame.this, "Invalid connection information!", "Database Error", JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(StartFrame.this, "Error: " + e, "Database Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		add(settingPanel, BorderLayout.CENTER);

		setSize(400, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
}
