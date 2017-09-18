package Recursion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class RecursiveCircles extends JFrame{
	
	public RecursiveCircles(){
		
		setTitle("Circles");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
		
		public void paint(Graphics g){
			super.paint(g);
			drawCircles(g,245,10,35);
		}
		
		public void drawCircles(Graphics g, int xy, int wh, int num){
			Random r = new Random();
			if(num>0)
			{
				g.setColor(new Color(r.nextInt(256),r.nextInt(256),r.nextInt(255)));
				g.drawOval(xy,xy,wh,wh);
				drawCircles(g,(xy-5),(wh+10),num-1);
			}
		}

	public static void main(String[] args) {
		
		new RecursiveCircles();

	}

}
