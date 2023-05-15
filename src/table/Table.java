//class that holds the clickable table
package table;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import util.ImageLoader;

public class Table extends BaseButton{


	public Table(double x, double y, double s) {
		super(x, y, s);
		img = ImageLoader.loadImage("assets/table.png");
		
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
