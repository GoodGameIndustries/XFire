/**
 * 
 */
package com.GGI.objects;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Polygon;

/**
 * @author Emmett Deen
 *
 */
public class Center extends Object{

	private Polygon shape;
	
	public Center(float xPos, float yPos, float xVel, float yVel, float xAcc, float yAcc,float fricConst){
		super(xPos,yPos,xVel,yVel,xAcc,yAcc,2.0,fricConst);
		shape = new Polygon(new float[]{});
	}
	
	public Polygon getShape(){
		return shape;
		
	}
}
