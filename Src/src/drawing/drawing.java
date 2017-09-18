package drawing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class drawing extends JFrame {
	
	public drawing()
	{
		// set JFrame defaults
		setTitle("Drawing Example");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// set background color
		getContentPane().setBackground(new Color(135, 206, 250));
		// make window visible
		setVisible(true);
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		
		//g.drawLine(50, 50, 100, 100);
		//g.drawRect(100, 100, 75, 75);
		//g.setColor(Color.GREEN);
		//g.fillRect(300, 300, 50, 50);
		//g.fillOval(75, 400, 10, 10);
		
		// snowman body
		g.setColor(Color.WHITE);
		g.fillOval(215, 130, 70, 70);
		g.fillOval(200, 200, 100, 100);
		g.fillOval(175, 300, 150, 150);
		
		// snowman buttons
		g.setColor(Color.BLACK);
		g.fillOval(245, 225, 10, 10);
		g.fillOval(245, 245, 10, 10);
		g.fillOval(245, 265, 10, 10);
		
		// snowman eyes
		g.fillOval(235, 150, 10, 10);
		g.fillOval(255, 150, 10, 10);
		
		// snowman mouth
		g.fillOval(230, 178, 8, 8);
		g.fillOval(240, 182, 8, 8);
		g.fillOval(250, 182, 8, 8);
		g.fillOval(260, 178, 8, 8);
		
		// snowman hat
		g.drawLine(215, 130, 285, 130);
		g.fillRect(230, 100, 40, 30);
		
		// snowman nose
		g.setColor(Color.ORANGE);
		int[] x = {250, 250, 270};
		int[] y = {170, 176, 173};
		g.fillPolygon(x, y, 3);
		
		// snowman scarf
		g.setColor(Color.RED);
		g.fillRect(238, 200, 25, 5);
		int[] a = {263, 303, 293, 263};
		int[] b = {200, 160, 185, 205};
		g.fillPolygon(a, b, 4);
		
	}

	public static void main(String[] args) {

		new drawing();

	}

}
