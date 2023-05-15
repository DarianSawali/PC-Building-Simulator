//a factory which creates the board and pot in the background
package background;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

import main.Panel;

public class ConcreteFactory extends Factory{

	@Override
	public Prop create(String type) {
		Prop prop = null;
	
		if (type == "board") {
			prop = new Board(Panel.W_WIDTH /3, Panel.W_HEIGHT/3, 0.5);
		}
		else if (type == "pot") {
			prop = new Pot(9 * Panel.W_WIDTH /10, 9.2 * Panel.W_HEIGHT/10, 0.4);
		}
		return prop;
		
	}
}
