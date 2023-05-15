//creates the blue background when finished
package table;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import main.Panel;
import util.ImageLoader;

public class Back {
	private BufferedImage img;

	public Back(String file) {
		img = ImageLoader.loadImage(file);
	}

	public void draw(Graphics2D g2) {
		AffineTransform at = g2.getTransform();
		g2.translate(0, 0);
		g2.scale(1, 1);
		g2.drawImage(img, 0, 0, Panel.W_WIDTH, Panel.W_HEIGHT, null);
		
		g2.setTransform(at);
	}

}