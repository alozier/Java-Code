package mousemotion;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class MouseDrags extends JFrame{
	
	private int x1;
	private int x2;
	private int y1;
	private int y2;
	
	public MouseDrags(){
		//setJFrame defaults
		setTitle("Mouse Drags");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//add mouse listener
		addMouseListener(new MyMouseListener());
		
		//add mouse motion listener
		addMouseMotionListener(new MyMouseMotionListener());
		
		
		//display window
		setVisible(true);	
		
	}
	
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(Color.MAGENTA);
		g.fillRect(x1, y1, (x2-x1), (y2-y1));
	}
	
	private class MyMouseListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			x1 = arg0.getX();
			y1 = arg0.getY();
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private class MyMouseMotionListener implements MouseMotionListener{
		@Override
		public void mouseDragged(MouseEvent e) {
			x2 = e.getX();
			y2 = e.getY();
			
			repaint();
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}


	}
	
	public static void main(String[] args) {
		
		new MouseDrags();
	}

}
