//decorator class that creates the power supply when build is finished
package decorator;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D.Double;

import main.Panel;
import util.ImageLoader;

public class PowerDecorator extends Casing{
	
	public PowerDecorator(Decorate base, float s) {
		super(base, s);
		img = ImageLoader.loadImage("assets/psu.png");
		
	}
	
	public void showCase(Graphics2D g2) {
		super.showCase(g2);
		addPower(g2);
	}
	
	public void addPower(Graphics2D g2) {
		AffineTransform transform = g2.getTransform();
		g2.translate(4.7*Panel.W_WIDTH/10, 6.5*Panel.W_HEIGHT/10);
		g2.scale(s, s);

		g2.drawImage(img, -img.getWidth() / 2, -img.getHeight() / 2, null);

		g2.setTransform(transform);
	}
}
