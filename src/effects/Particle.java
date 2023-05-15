//parent class of particle for the smoke effect on the CPU
package effects;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import main.Panel;
import processing.core.PVector;

public abstract class Particle {
    protected PVector pos,vel;
    protected Dimension dim;
    protected float scale;
    protected Area outline;
    protected BufferedImage img;
      
    Particle(float x, float y, int width, int height, float scale){
        this.pos = new PVector(x,y);
        this.dim = new Dimension(width,height);
        this.scale = scale;

    }

    public float getSize() {return scale;}
    public PVector getPos() {return pos;}

    public abstract void draw(Graphics2D g);
    public abstract void update(Graphics2D g, ArrayList<Particle> list);
    public abstract void move();




}
