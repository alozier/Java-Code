package mousing;

import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
import java.awt.*;
import java.util.Random;

public class MouseClicks extends JFrame{
	private int x;
	private int y;
	private boolean firstTime = true;
	
	public MouseClicks(){
		
		setTitle("Mouse Clicking");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addMouseListener(new MouseEventListener());
		
		setVisible(true);
		
	}
	
	public void paint(Graphics g){
		
		Random r = new Random();
		if(!firstTime)
		{
		g.setColor(new Color(r.nextInt(256),r.nextInt(256),r.nextInt(255)));  //RGB code for color
		g.fillRect(x,y,r.nextInt(50),r.nextInt(50));
		}
		else{
			super.paint(g);
			firstTime=false;
		}
	}
	
	private class MouseEventListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
			//System.out.println("mouse clicked");
			x = arg0.getX();
			y = arg0.getY();
			
			repaint();
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			//System.out.println("mouse entered");
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			//System.out.println("mouse exited");
			firstTime=true;
			repaint();
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			//System.out.println("mouse pressed");
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			//System.out.println("mouse released");
		}
		
		
	}
	
	public static void main(String[] args) {
		
		new MouseClicks();
	}

}
