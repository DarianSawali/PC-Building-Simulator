//displays the efefcts of the gas which gets dispensed out of the fire extinguisher
package effects;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

import processing.core.PApplet;
import table.BaseButton;
import util.Util;

import static util.Util.*;
import static main.PanelApp.*;

public class Gas {
	private float xPos, yPos;
	private int width, height;

	private float xstart;
	private float xnoise;
	private float ynoise;
	private PApplet pa;

	public  Gas(float x , float y, int w, int h) {
		xPos = x;
		yPos = y;
		width = w;
		height = h;
		xstart = Util.random(5);
		xnoise = xstart;
		ynoise = Util.random(5);
		pa = new PApplet();
	}

	public void draw(Graphics2D g2) {
		float noiseFactor;
		AffineTransform at = g2.getTransform();
		g2.translate(xPos, yPos);

		for(int y = 0; y <=height; y += 5) {
			ynoise += 0.03;
			xnoise = xstart;
			for(int x= 0; x<=width; x+=5) {
				xnoise+= 0.03;
				noiseFactor = pa.noise(xnoise,ynoise);

				AffineTransform at1 = g2.getTransform();
				g2.translate(x, y);
				g2.rotate(noiseFactor* radians(450));
				float size = noiseFactor * 180;
				int grey = (int) (150 + (noiseFactor*105));
				int alph = (int) (150 + (noiseFactor*105));
				g2.setColor(new Color(grey,grey,grey,alph));
				g2.fill(new Ellipse2D.Float(-size/2, -size/4, size, size/2*noiseFactor));
				g2.setTransform(at1);
			}

		}
		g2.setTransform(at);

	}
	
	

}