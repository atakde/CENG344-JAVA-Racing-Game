package RacingProject;

import javax.swing.JFrame;

import RacingProject.Game;

public class Cars {

	public Cars() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		
		JFrame app = new JFrame();
		Game newGame = new Game();
		app.add(newGame);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(500,720);
		app.setVisible(true);
	}

}
