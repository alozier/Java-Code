package FinalExam;

import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
import java.awt.*;

public class FinalExam extends JFrame{

	private int currentX=0;
	private int currentY=0;
	
	
	public FinalExam(){
		

		// set JFrame defaults
		setTitle("An Interactive House");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addMouseListener(new myMouseListener());
		
		// make window visible
		setVisible(true);
		
	}
	
	public void paint(Graphics g){
		
		int[] x = {25, 250, 475};
		int[] y = {200, 50, 200};
		g.drawPolygon(x, y, 3);
		
		g.drawRect(75, 200, 350, 250);
		
		g.fillRect(200, 300, 110, 150);
		
		if(currentX>=200 && currentX<=310){
			if(currentY>=300 && currentY<=450){
				Random r = new Random();
					Color color1=g.getColor();
					Color color2= new Color(255,255,255);
					g.setColor(new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)));  //RGB code for color
					
					while((g.getColor()==color1) || g.getColor()==color2){
						g.setColor(new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)));  //RGB code for color
					}
				}
			
			g.fillRect(200, 300, 110, 150);
		
		}
		
		
		g.setColor(Color.WHITE);
		g.fillOval(285, 375, 10, 10);
	}
	private class myMouseListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
			//System.out.println("mouse clicked");
			
			currentX=arg0.getX();
			currentY=arg0.getY();
			
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
			
			new FinalExam();
		}

}
	
