//class that creates the title in the title screen
package background;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import main.Panel;
import util.ImageLoader;

public class Title{
	
	BufferedImage img;
	double s;
	
	public Title() {
		img = ImageLoader.loadImage("assets/title.png");
		s = 0.4f;
		
	}
	
	public void draw(Graphics2D g2) {
		AffineTransform transform = g2.getTransform();
		g2.translate(Panel.W_WIDTH/2, Panel.W_HEIGHT/3);
		g2.scale(s, s);
		g2.drawImage(img, -img.getWidth() / 2, -img.getHeight() / 2, null);

		g2.setTransform(transform);
		
	}

}