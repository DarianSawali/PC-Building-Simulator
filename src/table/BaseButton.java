//parent class that handles the interactions of items such as dragging and hit detection
package table;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import util.ImageLoader;

public abstract class BaseButton implements Display {
	protected double xPos;
	protected double yPos;
	protected double scale;
	private boolean lightOn = false;
	protected BufferedImage img;
	

	// constructor
	public BaseButton(double x, double y,  double s) {
		xPos = x;
		yPos = y;
		scale = s;
		this.img = img;
	}
	
	public double getPosX(){
		return xPos;
	}
	
	public double getPosY(){
		return yPos;
	}
	
	public boolean hit(BaseButton button) {
		boolean hit = false;

		if (Math.abs(xPos - button.getPosX()) < 50 && Math.abs(yPos- button.getPosY()) < 30)
			hit = true;
		
		return hit;
	}
	
	public boolean clicked(double x, double y){
		boolean clicked = false;
		
		if (x > (xPos - ((double) img.getWidth()) / 2 * scale) && x < (xPos + ((double) img.getWidth())/2*scale) && y > (yPos - ((double) img.getHeight())/2*scale) && y < (yPos + ((double) img.getHeight())/2*scale)) 
			clicked = true;
		
		return clicked;
	}
	
	public void setLocX(double x) {
		xPos = x;
	}
	
	public void setLocY(double y) {
		yPos = y;
	}
	
	public void setLightOn(boolean on){
		lightOn = on;
	}
	
	public void setMobo(int moboState) {
		if(moboState == 0)
			img = ImageLoader.loadImage("assets/mobo.png");
		else if(moboState == 1)
			img = ImageLoader.loadImage("assets/mobo_cpu.png");
		else if(moboState == 2)
			img = ImageLoader.loadImage("assets/mobo_ram1.png");
		else if(moboState == 3)
			img = ImageLoader.loadImage("assets/mobo_ram2.png");
		else if(moboState == 4)
			img = ImageLoader.loadImage("assets/mobo_gpu.png");
	}
}





