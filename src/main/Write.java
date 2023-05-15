//class that creates the text on the display
package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class Write {
	double x, y;
	Write(){
		
		
	}
	
	public void write(Graphics2D g2, String dialog, String dialog2) {
		AffineTransform at = g2.getTransform();
		g2.translate(0, 5.6*Panel.W_HEIGHT/7);
		g2.setColor(new Color(255, 255, 255, 60));
		g2.fillRect(0, 0, Panel.W_WIDTH, Panel.W_WIDTH/6);
		g2.setColor(Color.black);
		g2.drawRect(0, 0, Panel.W_WIDTH, Panel.W_WIDTH/6);
		
		
		
		Font f = new Font("Courier", Font.BOLD, 36);
		g2.setFont(f);
		
		g2.drawString(dialog, 45, 45);
		g2.drawString(dialog2, 45, 100);
		g2.setTransform(at);
	}
	
	public boolean clicked(double x, double y){
		boolean clicked = false;
		if (x > (0 - ((double)Panel.W_WIDTH)) && x < (0 + ((double)Panel.W_WIDTH)) && y > (0 - ((double) Panel.W_WIDTH)) && y < (0 + ((double)Panel.W_WIDTH))) 
			clicked = true;
		return clicked;
	}
}
