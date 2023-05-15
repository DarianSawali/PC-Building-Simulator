//a class that creates the fan in the background which moves
package background;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import util.ImageLoader;

public class Fan{
	
	BufferedImage img;
	double x, y, s;
	//field that handles the rotation of fan
	float angle;
	//field that holds the speed of the rotation
	float vel = (float) (Math.PI/10);
	
	public Fan(double x, double y, double s) {
		img = ImageLoader.loadImage("assets/mfan.png");
		this.x = x;
		this.y = y;
		this.s = s;
	}
	
	public void update() {
		angle += vel;
	}

	public void draw(Graphics2D g2) {
		AffineTransform transform = g2.getTransform();
		g2.translate(x, y);
		g2.scale(s, s);
		g2.rotate(angle);
		g2.drawImage(img, -img.getWidth() / 2, -img.getHeight() / 2, null);

		g2.setTransform(transform);
		
	}

}