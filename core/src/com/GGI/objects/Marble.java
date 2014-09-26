/**
 * 
 */
package com.GGI.objects;


import com.badlogic.gdx.math.Polygon;

/**
 * @author Emmett Deen
 *
 */
public class Marble extends Object{

	
	
	public Marble(float xPos, float yPos, float xVel, float yVel, float xAcc, float yAcc){
	super(xPos,yPos,xVel,yVel,xAcc,yAcc,1.0);
	shape = new Polygon(new float[]{});
	
	}
	
	
}
