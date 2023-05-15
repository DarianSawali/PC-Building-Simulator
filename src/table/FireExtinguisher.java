//class that holds the Fire Extinguisher
package table;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import effects.Gas;
import effects.Particle;
import effects.Smoke;
import main.Panel;
import util.ImageLoader;

public class FireExtinguisher extends BaseButton{
	
	private Gas gas;
	private Smoke gases;

	public FireExtinguisher(double x, double y, double s) {
		super(x, y, s);
		img = ImageLoader.loadImage("assets/fireex.png");
		gases = new Smoke((float)xPos, (float)yPos, Panel.W_WIDTH, Panel.W_HEIGHT, 0.05f);
			
	}

	@Override
	public void draw(Graphics2D g2) {
		
		gas = new Gas((float)xPos-220, (float)yPos-70, 90, 90);
		gas.draw(g2);
		AffineTransform transform = g2.getTransform();
		g2.translate(xPos, yPos);
		g2.scale(scale, scale);
		g2.rotate(-Math.PI/5);

		g2.drawImage(img, -img.getWidth() / 2, -img.getHeight() / 2, null);

		g2.setTransform(transform);
		
	}
	
	public boolean hit(BaseButton button) {
		boolean hit = false;

		if (Math.abs(xPos - button.getPosX()-120) < 50 && Math.abs(yPos- button.getPosY()+50) < 30)
			hit = true;
		
		return hit;
	}

}