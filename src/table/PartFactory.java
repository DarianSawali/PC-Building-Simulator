//Factory of parts that creates the interactable items
package table;

import background.Board;
import background.Pot;
import background.Prop;
import main.Panel;

public class PartFactory extends ButtonFactory {
	
	public BaseButton make(String type) {
		BaseButton part = null;
	
		if (type == "mobo") {
			part = new Motherboard(1.3*Panel.W_WIDTH / 5, Panel.W_HEIGHT / 3 + 100, 0.2);
		}
		else if (type == "cpu") {
			part = new CPU(Panel.W_WIDTH / 2+180, Panel.W_HEIGHT / 2 + 200, 0.15);
		}
		else if (type == "light") {
			part = new Light(7 * Panel.W_WIDTH / 10, Panel.W_HEIGHT/3, 0.4);
		}
		else if (type == "table") {
			part = new Table(Panel.W_WIDTH/2, Panel.W_HEIGHT/2, 0.5);
		}
		else if (type == "gpu") {
			part = new GPU(6*Panel.W_WIDTH / 10, 1*Panel.W_HEIGHT/3, 0.15);
		}
		else if (type == "ram1") {
			part = new RAM(7*Panel.W_WIDTH / 9, 5*Panel.W_HEIGHT/10, 0.1);
		}
		else if (type == "ram2") {
			part = new RAM(6.5*Panel.W_WIDTH / 9, 5.5*Panel.W_HEIGHT/10, 0.1);
		}
		else if (type == "fireex") {
			part = new FireExtinguisher(7*Panel.W_WIDTH / 9, 8*Panel.W_HEIGHT/10, 0.28);
		}
		else if (type == "mobocase") {
			part = new Motherboard(2.1*Panel.W_WIDTH / 5, Panel.W_HEIGHT / 4 + 100, 0.13);
		}
		
		return part;
		
	}
	
}
