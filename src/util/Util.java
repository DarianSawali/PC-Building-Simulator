//utility class which holds different utility methods
package util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Util {
	
	
	public static double random(double low, double high){
		return low + Math.random() * (high - low);
		}
	
	public static double dist(double x1, double y1, double x2, double y2){
		double distance = Math.abs(x1-x2)+Math.abs(y1-y2)-Math.min(Math.abs(x1-x2), Math.abs(y1-y2));
		return distance;
	}
	
	public static float random(float low, float high) {
		return low + (float) Math.random() * (high - low);
	}
	
	
	public static float random(float high) {
		return (float) Math.random() * high;
	}

	
	public static double radians(double angle){
		return angle/180*Math.PI;		
	}
	
	
	public static float radians(float angle){
		return angle/180*(float)Math.PI;		
	}
	
	public static float remapValue(float value, float low1,float high1,float low2,float high2) {
        return low2 + (value - low1) * (high2 - low2) / (high1 - low1);

    }
	
}
