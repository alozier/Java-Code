package FollowMe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FollowMe extends JFrame{

	private int x=250;
	private int y=250;
	private boolean firstTime=true;
	
	public FollowMe(){
		
		setTitle("Follow Me");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addMouseMotionListener(new FollowMouseMotionListener());
		
		setVisible(true);
	}
	
	public void paint(Graphics g){
		super.paint(g);
		g.drawString("Hello", x, y);
	}
	
	private class FollowMouseMotionListener implements MouseMotionListener{

		@Override
		public void mouseDragged(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			if(!firstTime){
				x = arg0.getX();
				y = arg0.getY();
			
				repaint();
			}
			firstTime = false;
		}
		
	}
	
	public static void main(String[] args) {
		
		new FollowMe();

	}

}
