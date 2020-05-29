package RacingProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import java.awt.event.KeyListener;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;

public class Game extends JPanel implements ActionListener, KeyListener {
	ArrayList<Tree> treeList = new ArrayList<Tree>();
	ArrayList<star> starList;
	
	private int w = 60;
	private int h = 55;
	private int move = 20;
	private int count = 1;
	private int space;
	private int speed;
	private int width = 700;
	private int height = 700;
	private ArrayList<Rectangle> ocars;
	private Rectangle car;
	private Random rand;
	private boolean stopGame = false;
	private int points;
	private int StarPoints = 0;
	
	BufferedImage bg, bg1, road1, road2, road3;
	Timer t;

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
		t = new Timer(20, this);
		rand = new Random();
		ocars = new ArrayList<Rectangle>();
		starList = new ArrayList<star>();
		car = new Rectangle(width / 2 - 90, height - 100, w, h);
		space = 300; // diðer arabanýn gelme süresi
		speed = 2;
		addKeyListener(this);
		setFocusable(true);

		addocars(true);
		addocars(true);
		addocars(true);
		addocars(true);
		addstars(true);
		addstars(false);

		tree(115, 500);
		tree(145, 600);
		tree(145, 400);
		tree(115, 300);
		tree(145, 200);
		tree(115, 100);

		tree(540, 100);
		tree(570, 200);
		tree(540, 300);
		tree(570, 400);
		tree(540, 500);
		tree(570, 600);

		t.restart();
	}

	public void star(int a, int b) {
		star c = new star(a, b);
		this.starList.add(c);
	}

	public void tree(int i, int j) {
		Tree a = new Tree(i, j);
		treeList.add(a);
	}

	public void addocars(boolean first) {

		int positionx = rand.nextInt() % 3;
		int x = 0, y = 0;
		int width1 = w;
		int height1 = h;

		if (positionx == 0) {
			x = width / 2 - 150;
		}

		else if (positionx == 1) {
			x = width / 2 - 50;
		}

		else {
			x = width / 2 + 50;
		}

		if (first) {
			ocars.add(new Rectangle(x, y - 100 - (ocars.size() * space), width1, height1));
		}

		else {
			ocars.add(new Rectangle(x, ocars.get(ocars.size() - 1).y - 300, width1, height1));
		}

	}

	public void addstars(boolean first) {

		int positionx = rand.nextInt() % 3;
		int x = 0;

		if (positionx == 0) {
			x = width / 2 - 100;
		}

		else if (positionx == 1) {
			x = width / 2 - 0;
		}

		else {
			x = width / 2 + 100;
		}

		if (first) {
			star(x, 0);
		}

		else {
			int a = (int) starList.get(starList.size() - 1).points[0][1] - 450;
			star(x, a);
		}

	}

	public void paintComponent(Graphics g) {

		Font font = new Font("Verdana", Font.BOLD, 12);
		super.paintComponents(g);
		Graphics2D g2 = (Graphics2D) g;
		g.setColor(Color.gray);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.gray);
		g.fillRect(width / 2 - 150, 0, 300, height);

		for (int i = 0; i < this.treeList.size(); i++) {
			Polygon a = new Polygon(this.treeList.get(i).x, this.treeList.get(i).y, 4);
			Polygon b = new Polygon(this.treeList.get(i).triX, this.treeList.get(i).triY, 3);
			Polygon b1 = new Polygon(this.treeList.get(i).triX1, this.treeList.get(i).triY1, 3);
			Polygon b2 = new Polygon(this.treeList.get(i).triX2, this.treeList.get(i).triY2, 3);
			g.setColor(Color.getHSBColor(0.64f, 0.16f, 0.16f));
			g.fillPolygon(a);
			g.setColor(Color.green);
			g2.fillPolygon(b);
			g2.fillPolygon(b1);
			g2.fillPolygon(b2);
		}
		// road
		g.drawImage(road1, 200, 0, null);
		g.drawImage(road2, 300, 0, null);
		g.drawImage(road3, 400, 0, null);
		GeneralPath star = new GeneralPath();
		// star
		for (int m = 0; m < this.starList.size(); m++) {

			star.moveTo(this.starList.get(m).points[0][0], this.starList.get(m).points[0][1]);
			for (int a = 1; a < 11; a++) {
				star.lineTo(this.starList.get(m).points[a][0], this.starList.get(m).points[a][1]);
			}
			g2.setColor(Color.yellow);
			star.closePath();
			g2.fill(star);
		}

		// car
		g.drawImage(bg, car.x, car.y, null);

		for (Rectangle rect : ocars) {
			g.drawImage(bg1, rect.x, rect.y, null);
		}
		g.setFont(font);
		g.setColor(Color.RED);
		g.drawString("Points: " + this.points, 10, 20);
		g.drawString("Star Points: " + this.StarPoints, 580, 20);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Rectangle rect;
		count++;
		for (int i = 0; i < ocars.size(); i++) {
			rect = ocars.get(i);
			if (count % 1000 == 0) {
				speed++;
				if (move < 50) {
					move += 10;
				}
			}
			rect.y += speed;
		}
		star q;
		for (int j = 0; j < starList.size(); j++) {
			q = starList.get(j);
			q.points[0][1] += speed;
			q.points[1][1] += speed;
			q.points[2][1] += speed;
			q.points[3][1] += speed;
			q.points[4][1] += speed;
			q.points[5][1] += speed;
			q.points[6][1] += speed;
			q.points[7][1] += speed;
			q.points[8][1] += speed;
			q.points[9][1] += speed;
			q.points[10][1] += speed;
		}
		for (Rectangle r : ocars) {
			if (r.intersects(car)) {
				// car.y = r.y+h;
				System.out.println("Crashed!!!");
				this.stopGame = true;
				if (this.stopGame == true) {
					System.out.println("Panele girdi!");
					Panel panel = new Panel();

					JLabel l1 = new JLabel("Game over, you can restart it :)");
					panel.add(l1);

					panel.setBounds(0, 300, 700, 50);
					panel.setBackground(Color.gray);

					Button b1 = new Button("Restart");
					b1.addActionListener(this);
					b1.setBackground(Color.green);
					panel.add(b1);
					add(panel);
				}
				t.stop();
			}
		}

		for (int j = 0; j < starList.size(); j++) {
			q = starList.get(j);
			if (car.intersects(q.points[0][0], q.points[0][1], 1, 1)
					|| car.intersects(q.points[8][0], q.points[8][1], 1, 1)
					|| car.intersects(q.points[6][0], q.points[6][1], 1, 1)) {
				System.out.println("Yýldýza çarptý!");
				this.StarPoints += 1;
				starList.remove(q);
				addstars(false);
			}
		}

		for (int i = 0; i < ocars.size(); i++) {
			rect = ocars.get(i);
			if (rect.y + rect.height > height) {
				ocars.remove(rect);
				addocars(false);
			}
			if (rect.y + rect.height > car.y) {
				this.points += 5;
			}
		}

		for (int i = 0; i < starList.size(); i++) {
			q = starList.get(i);
			if (q.points[0][1] > height) {
				System.out.println("Yeni yýldýz üretildi!");
				starList.remove(q);
				addstars(false);
			}
		}

		if (e.getActionCommand() == "Restart") {

			Window a = SwingUtilities.getWindowAncestor(this);
			a.setVisible(false);

			JFrame app = new JFrame();
			Game w = new Game();
			app.add(w);
			app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			app.setSize(700, 720);
			app.setVisible(true);

		}

		repaint();

	}

	public void moveLeft() {
		if (car.x - move < 200) {

		} else {
			car.x -= move;
		}
	}

	public void moveRight() {
		if (car.x + move > 430) {

		} else {

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
		switch (key) {
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