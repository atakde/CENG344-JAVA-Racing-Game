package RacingProject;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Game extends JPanel implements ActionListener {
	
	private int speed;
	private int space;
	private int width = 500;
	private int height = 720;
	private Rectangle car;

	public Game() {
		this.car = new Rectangle((this.width/2)-90, this.height - 100, 80, 70);
		this.space = 100;
		this.speed = 2;
	}
	
	public void paint(Graphics g) {
		
		super.paintComponents(g);
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, this.width, this.height);
		g.setColor(Color.blue);
		g.fillRect((this.width/2)-100, 0, 200, this.height);
		g.setColor(Color.red);
		g.fillRect(car.x, car.y, car.width, car.height);
		g.setColor(Color.red);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
