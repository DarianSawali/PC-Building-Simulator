//abstract class for props in the background
package background;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public abstract class Prop {
	protected double x, y, s;
	protected BufferedImage img;
	
	public Prop(double x, double y, double s) {
		this.x = x;
		this.y = y;
		this.s = s;
		this.img = img;
	}
	
	public abstract void display(Graphics2D g2);
}
