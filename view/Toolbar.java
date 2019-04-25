package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;


public class Toolbar extends JPanel implements ActionListener {
	
	private JButton newSimulation;
	private ButtonListener number;
	
	public Toolbar() {
		setBorder(BorderFactory.createEtchedBorder());
		
		newSimulation = new JButton("New Simulation");
		
		newSimulation.addActionListener(this);
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(newSimulation);

	}
	
	public void setToolBarListener(ButtonListener listener ) {
		this.number = listener;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton)e.getSource();
		
		if(clicked == newSimulation) {

			number.actionButton();
			
		}
	
	}
}
