//decorator class that creates the fans in the end when finished
package decorator;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D.Double;

import main.Panel;
import util.ImageLoader;

public class FanDecorator extends Casing{
	
	public FanDecorator(Decorate base, float s) {
		super(base, s);
		img = ImageLoader.loadImage("assets/fan.png");
	}
	
	public void showCase(Graphics2D g2) {
		super.showCase(g2);
		addFans(g2);
	}
	
	public void addFans(Graphics2D g2) {
		AffineTransform transform = g2.getTransform();
		g2.translate(2*Panel.W_WIDTH/3, 4.5*Panel.W_HEIGHT/10);
		g2.scale(s, s);
		g2.drawImage(img, -img.getWidth() / 2, -img.getHeight() / 2, null);
		
		g2.translate(0, 280);
		g2.drawImage(img, -img.getWidth() / 2, -img.getHeight() / 2, null);
		
		g2.translate(0, -560);
		g2.drawImage(img, -img.getWidth() / 2, -img.getHeight() / 2, null);

		g2.setTransform(transform);
	}
}
