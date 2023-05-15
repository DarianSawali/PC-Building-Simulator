//class that holds the Light switch on the wall
package table;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import util.ImageLoader;

public class Light extends BaseButton{
	
	private boolean lightOn = false;
	
	public Light(double x, double y, double s) {
		super(x, y, s);
		img = ImageLoader.loadImage("assets/light.png");
	}
	
	

	@Override
	public void draw(Graphics2D g2) {
		AffineTransform transform = g2.getTransform(); // save(x~y)
		g2.translate(xPos, yPos);
		g2.scale(scale, scale);
		g2.drawImage(img, -img.getWidth()/2, -img.getHeight()/2, null);
		
		if (!lightOn){ 
			g2.setColor(new Color(250, 250, 250));
		}
		g2.setTransform(transform);
		
	}
	
	public void setLightOn(boolean on){
		lightOn = on;
	}

}
