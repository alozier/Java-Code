package TimerObjects;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class BouncingBall extends JFrame{
	
	private int y =400;
	
	private Timer timer;	//timer object
	
	private boolean goingUp=true;
	
	public BouncingBall(){
		//set JFrame defaults
		setTitle("Bouncing Ball");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//create timer obj
		timer = new Timer(30, new TimerActionListener());
		
		timer.start();
		
		setVisible(true);
	}
	
	public void paint(Graphics g){
		
		super.paint(g);
		
		//set color
		g.setColor(new Color(246,141,36));
		
		//draw a ball
		g.fillOval(100, y, 40, 40);
		
	}	
	
	private class TimerActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(goingUp)
			if(y > 100)
				y -= 20;
			else
				goingUp=false;
		else 
			if(y<400)
			y += 20;
			else
				goingUp=true;
			
		repaint();		
		
	}
}
	
	public static void main(String[] args) {
		
		new BouncingBall();

	}

}
