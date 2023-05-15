//class that holds the GPU
package table;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import util.ImageLoader;

public class GPU extends BaseButton{

	public GPU(double x, double y, double s) {
		super(x, y, s);
		img = ImageLoader.loadImage("assets/gpu.png");
		
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