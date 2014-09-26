/**
 * 
 */
package com.GGI.objects;

import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;

/**
 * @author Emmett Deen
 *
 */
public class Object {

	private Vector2 position =new Vector2();
	private Vector2 velocity =new Vector2();
	private Vector2 acceleration = new Vector2();
	private double mass;
	
	
	public Object(){
		
	}
	
	public Object(float xPos,float yPos, float xVel, float yVel, float xAcc, float yAcc, double mass){
		position.x=xPos;
		position.y=yPos;
		velocity.x=xVel;
		velocity.y=yVel;
		acceleration.x=xAcc;
		acceleration.y=yAcc;
		this.mass=mass;
	}
	
	public void update(float delta){
		position.add(velocity.scl(delta));
		velocity.add(acceleration.scl(delta));
	}
}
