//a class that creates a board in the background of the room
package background;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import util.ImageLoader;

public class Board extends Prop{

	public Board(double x, double y, double s) {
		super(x, y, s);
		img = ImageLoader.loadImage("assets/board.png");
	}

	@Override
	public void display(Graphics2D g2) {
		AffineTransform transform = g2.getTransform();
		g2.translate(x, y);
		g2.scale(s, s);

		g2.drawImage(img, -img.getWidth() / 2, -img.getHeight() / 2, null);

		g2.setTransform(transform);
		
	}

}