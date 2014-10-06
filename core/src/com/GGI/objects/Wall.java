/**
 * 
 */
package com.GGI.objects;

import com.badlogic.gdx.math.Rectangle;

/**
 * @author Euler Einstein
 *
 */
public class Wall extends Object{
	private Rectangle shape;
	public Wall(float x,float y){
		super(.3f,.3f,0,0,0,0,0,0);
		shape = new Rectangle();
		shape.x=x-.3f;
		shape.y=y-.3f;
	}
	
	public Rectangle getShape(){
		return shape;
	}
}
