/**
 * 
 */
package com.GGI.objects;

import com.badlogic.gdx.math.Ellipse;

/**
 * @author Emmett Deen
 *
 */
public class Marble extends Object{

	private Ellipse shape;
	
	public Marble(float xPos, float yPos, float xVel, float yVel, float xAcc, float yAcc){
	super(xPos,yPos,xVel,yVel,xAcc,yAcc,1.0);
	shape = new Ellipse(xPos,yPos,1f,1f);
	}
	
	
}
