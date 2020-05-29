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

public class Tree 
{
	int[] x = new int[4];
	int[] y = new int[4];
	
	int[] triX = new int[3];
	int[] triY = new int[3];
	
	int[] triX1 = new int[3];
	int[] triY1 = new int[3];
	
	int[] triX2 = new int[3];
	int[] triY2 = new int[3];
	
	public Tree( int i,int j)
	{
		this.x[0] = i;
		this.x[1] = i+10;
		this.x[2] = i+10;
		this.x[3] = i;
		
		this.y[0] = j;
		this.y[1] = j;
		this.y[2] = j+20;
		this.y[3] = j+20;
		
		this.triX[0] = i-42;
		this.triX[1] = i+52;
		this.triX[2] = i+5;
		
		this.triY[0] = j;
		this.triY[1] = j;
		this.triY[2] = j-40;
		
		
		this.triX1[0] = i-35;
		this.triX1[1] = i+45;
		this.triX1[2] = i+5;
		
		this.triY1[0] = j-20;
		this.triY1[1] = j-20;
		this.triY1[2] = j-60;
		
		this.triX2[0] = i-25;
		this.triX2[1] = i+35;
		this.triX2[2] = i+5;
		
		this.triY2[0] = j-40;
		this.triY2[1] = j-40;
		this.triY2[2] = j-80;
	     

	}
	
}


