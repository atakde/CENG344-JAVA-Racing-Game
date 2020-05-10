package RacingProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.*;
import java.awt.Color;
import  java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer ; 
import java.awt.event.KeyListener; 
import java.awt.Image;
import java.awt.image.BufferedImage;

public class Game extends JPanel implements ActionListener, KeyListener {
	private int w = 80  ; 
	private int h = 70 ; 
	private int move = 20 ; 
	private int count = 1;
	private int space; 
	private int speed ; 
	private int width = 700 ; 
	private int height = 700 ; 
	private ArrayList<Rectangle> ocars ; 
	private Rectangle car;
	private Random rand;
	BufferedImage bg ,bg1, road1, road2, road3;
	Timer t ; 
	public Game() {
		try {
			bg = ImageIO.read(new File("src/RacingProject/araba.png"));
			bg1 = ImageIO.read(new File("src/RacingProject/araba1.png"));
			road1 = ImageIO.read(new File("src/RacingProject/road.png"));
			road2 = ImageIO.read(new File("src/RacingProject/road.png"));
			road3 = ImageIO.read(new File("src/RacingProject/road.png"));
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t = new Timer(20 , this);
		rand = new Random();
		ocars = new ArrayList<Rectangle>();
		car = new Rectangle(width/2-90 , height-100, w , h);
		space  = 300 ; // diðer arabanýn gelme süresi  
		speed = 2 ; 
		addKeyListener(this);
		setFocusable(true);
		addocars(true);
		addocars(true);
		addocars(true);
		addocars(true);
		
		t.restart();
	}
public void addocars(boolean first )
{
	
	int positionx = rand.nextInt()%3 ; 
	System.out.println(positionx);
	int x = 0 ,y  = 0  ; 
	int width1 = w;
	int height1 = h; 
	
	if(positionx == 0 ) {
		x = width/2 - 150 ; 
	}
	
	else if(positionx == 1) {
		x = width / 2 - 50  ; 
	}
	
	else {
		x = width / 2  + 50 ; 
	}
	
	if(first) {
		ocars.add(new Rectangle(x,y-100-(ocars.size()*space),width1, height1));
	} 
	
	else {
		ocars.add(new Rectangle(x,ocars.get(ocars.size()-1).y-300,width1,height1));
	}
	
}
	public void paintComponent(Graphics g )
	{
		super.paintComponents(g);
		Graphics2D g2 = (Graphics2D)g;
		g.setColor(Color.green);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.gray);
		g.fillRect(width/2 - 150 ,0  , 300,height);
		
		// road 
		g.drawImage(road1, 200 , 0 , null);
		g.drawImage(road2, 300, 0 , null);
		g.drawImage(road3, 400 ,0, null);
		// car 
		g.drawImage(bg, car.x , car.y , null);
		
		for(Rectangle rect:ocars) {
			//g.fillRect(rect.x, rect.y, rect.width, rect.height);
			g.drawImage(bg1, rect.x , rect.y , null);
		}

		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Rectangle rect ; 
		 count++;
		for(int i = 0 ; i < ocars.size(); i ++){
			rect = ocars.get(i);
			if(count % 1000 == 0 ) {
				speed++;
				if(move < 50) {
					move+=10;
				}
			}
			rect.y+= speed ; 
		}
		for(Rectangle r:ocars) {
			if(r.intersects(car)) {
				car.y = r.y+h;		
			}
		}
		for(int i = 0 ; i < ocars.size(); i++) {
			rect = ocars.get(i);
			if(rect.y+rect.height > height ) {
				ocars.remove(rect);
				addocars(false);
			}
		}

		repaint();
		
	}
	
	public void moveUp() {
		if(car.y-move < 0 ) {
			
		}else {
			car.y -= move;
		}
	}
	

	public void moveDown() {
		if(car.y+move+car.height>height - 1  ) {
			
		}else {
			car.y += move;
		}
	}
	

	public void moveLeft() {
		if(car.x-move < 200 ) {
			
		}else {
			car.x -= move;
		}
	}
	
	public void moveRight() {
		if(car.x +move > 430  ) {
		
		}else {
			
			car.x += move;
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {

		
	}
	@Override
	public void keyPressed(KeyEvent e) {
	
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key) {
		case KeyEvent.VK_UP:
			moveUp();
			break;
		case KeyEvent.VK_DOWN:
			moveDown();
			break;
		case KeyEvent.VK_LEFT:
			moveLeft();
			break;
		case KeyEvent.VK_RIGHT:
			moveRight();
			break;
			default: 
				break; 
		}
	}

}
