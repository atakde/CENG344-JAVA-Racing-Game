package RacingProject;
import java.awt.Color;
import java.awt.Container;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Polygon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.geom.GeneralPath;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class star extends Frame {
	
	 double points[][] = new double[11][2];
	 
	
	public star(int a , int b) {
		
			this.points[0][0] = a;
			this.points[0][1] = b;
			
			this.points[1][0] = a+10;
			this.points[1][1] = b+24;
			
			this.points[2][0] = a+30;
			this.points[2][1] = b+30;
			
			this.points[3][0] = a+10;
			this.points[3][1] = b+42;
			
			this.points[4][0] = a+18;
			this.points[4][1] = b+67;
			
			this.points[5][0] = a-2;
			this.points[5][1] = b+37;
			
			this.points[6][0] = a-27;
			this.points[6][1] = b+64;
			
			this.points[7][0] = a-14;
			this.points[7][1] = b+37;
			
			this.points[8][0] = a-33;
			this.points[8][1] = b+20;
			
			this.points[9][0] = a-10;
			this.points[9][1] = b+22;
			
			this.points[10][0] = a;
			this.points[10][1] = b;
			
		
	
	}

}
