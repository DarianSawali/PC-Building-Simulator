//abstract parent class of fans and power supply
package decorator;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public abstract class Casing implements Decorate{
	Decorate base;
	protected BufferedImage img;
	protected float s;
	
	public Casing(Decorate base, float s) {
		this.base = base;
		this.s = s;
	}
	
	@Override
	public void showCase(Graphics2D g2) {
			base.showCase(g2);
	
	}
}
