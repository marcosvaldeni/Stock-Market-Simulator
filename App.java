import javax.swing.SwingUtilities;

import view.startingScreen.StartFrame;

public class App {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new StartFrame();
			}
		});	

		
	}

}
