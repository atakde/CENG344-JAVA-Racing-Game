package RacingProject;

import javax.swing.JFrame;

public class Cars extends JFrame {

	public Cars() {
		// TODO Auto-generated constructor stub
	}

	 	public static void main(String[] args) {
	 		JFrame app = new JFrame();
	 		Game w = new Game();
	 		app.add(w);
	 
	 		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 		app.setSize(700,720);
	 		app.setVisible(true);	 		
	 		
	 		
	 	}
}
