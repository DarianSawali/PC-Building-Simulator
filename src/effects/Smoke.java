//class that creates the smoke effect on the CPU
package effects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.color.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D.Double;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;
import table.BaseButton;
import util.Util;

public class Smoke extends Particle{
	PVector vel;
	float start = 0;
	float tran = 100;
	PApplet pa = new PApplet();
	
	public Smoke (float x, float y, int width, int height, float scale) {
		super(x, y, width, height, scale);
		this.vel = new PVector(0, 0);
	}

	@Override
	public void draw(Graphics2D g2) {
		this.tran -= 0.9; 
		g2.setColor(new Color(150, 150, 150, (int)tran));
		AffineTransform at = g2.getTransform();
		g2.translate(pos.x, pos.y);
		g2.scale(scale, scale);
		g2.fill(new Ellipse2D.Double(-dim.width/2, -dim.height/2, dim.width, dim.height));
		g2.setTransform(at);
	}

	@Override
	public void update(Graphics2D g2, ArrayList<Particle> list) {
		draw(g2);
		move();
		removeParticle(list);
	}

	@Override
	public void move() {
		for(float i = 0; i < 100; i += 10f) {
			float xPos = Util.remapValue((float)Math.cos(Math.toRadians(i)), -1, 1, 0, 3);
			float yPos = Util.remapValue((float)Math.cos(Math.toRadians(i)), -1, 1, 0, 3);
			
			float noise = pa.noise(xPos + start, yPos + start);
			float randNum = Util.random(0, 180);
			
			float width = Util.remapValue(noise, 0, 1, 0f, 180f);
			float height = Util.remapValue(noise, 0, 1, -2, -1);
			
			this.vel = PVector.fromAngle((float)Math.toRadians(-width));
			
			
		}
		
		pos.add(vel);
		start += 1f;
		
	}
	
	public boolean hit(BaseButton button) {
		boolean hit = false;

		if (Math.abs(pos.x - button.getPosX()) < 50 && Math.abs(pos.y- button.getPosY()) < 30)
			hit = true;
		
		return hit;
	}
	
	private void removeParticle(ArrayList<Particle> list){
		if(this.tran < 5) 
			list.remove(this);
	}
	
	
}