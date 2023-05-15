//creates the fractal recursion of triangle on the board in the room
package effects;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;

import main.Panel;

public class Triangle {
	private int count;
	
	public Triangle() {

	}

	public void addTriangle(Graphics2D g2) {
		AffineTransform at = g2.getTransform();
		g2.translate(Panel.W_WIDTH/8.5, 0);
		g2.scale(0.9, 0.9);
		if(++count > 8)
			count--;
		
		int width  = 5*Panel.W_WIDTH/10;
		int height = 4*Panel.W_WIDTH/10;
		
		fractal(g2,
				new Point(width / 2, height / 5), 
				new Point(width / 2 - height / 3, height - height / 5), 
				new Point(width / 2 + height / 3, height - height / 5), 
				count - 1);
		
		g2.setTransform(at);
	}
	

	private void fractal(Graphics2D g2, Point p1, Point p2, Point p3, int count) {
		if(count < 1) {
			g2.drawPolygon(new int[] {p1.x, p2.x, p3.x}, new int[] {p1.y, p2.y, p3.y}, 3);
			return;
		}
		
		Point m1 = new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
		Point m2 = new Point((p1.x + p3.x) / 2, (p1.y + p3.y) / 2);
		Point m3 = new Point((p3.x + p2.x) / 2, (p3.y + p2.y) / 2);
		fractal(g2, p1, m1, m2, count - 1);
		fractal(g2, m1, p2, m3, count - 1);
		fractal(g2, m2, m3, p3, count - 1);
	}
	
	
}