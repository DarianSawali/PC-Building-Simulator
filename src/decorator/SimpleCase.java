//creates the gray case when PC is finished
package decorator;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import main.Panel;
import util.ImageLoader;

import static main.Panel.*;

public class SimpleCase implements Decorate {
	protected BufferedImage img;
	protected float scale = 0.5f;
	
	public SimpleCase(){
		img = ImageLoader.loadImage("assets/case.png");
		
	}
	
	@Override
	public void showCase(Graphics2D g2){
		AffineTransform transform = g2.getTransform();
		g2.translate(Panel.W_WIDTH/2, 4.5*Panel.W_HEIGHT/10);
		g2.scale(scale, scale);

		g2.drawImage(img, -img.getWidth() / 2, -img.getHeight() / 2, null);

		g2.setTransform(transform);
	}

}