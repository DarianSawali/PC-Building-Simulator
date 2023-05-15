//class that holds the start button
package table;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import util.ImageLoader;

public class Start extends BaseButton{

	public Start(double x, double y, double s) {
		super(x, y, s);
		img = ImageLoader.loadImage("assets/start.png");
		
	}
	
	@Override
	public void draw(Graphics2D g2) {
		AffineTransform transform = g2.getTransform();
		g2.translate(xPos, yPos);
		g2.scale(scale, scale);

		g2.drawImage(img, -img.getWidth() / 2, -img.getHeight() / 2, null);

		g2.setTransform(transform);
		
	}

}