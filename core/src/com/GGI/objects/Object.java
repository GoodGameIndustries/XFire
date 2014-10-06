/**
 * 
 */
package com.GGI.objects;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Shape;

/**
 * @author Emmett Deen
 *
 */
public class Object {

	public Vector2 position =new Vector2();
	public Vector2 velocity =new Vector2();
	protected Vector2 acceleration = new Vector2();
	protected double mass;
	protected float fricConst;
	//protected Polygon shape;
	
	
	public Object(){
		
	}
	
	public Object(float xPos,float yPos, float xVel, float yVel, float xAcc, float yAcc, double mass, float fricConst){
		position.x=xPos;
		position.y=yPos;
		velocity.x=xVel;
		velocity.y=yVel;
		acceleration.x=xAcc;
		acceleration.y=yAcc;
		this.mass=mass;
		this.fricConst=fricConst;
	}
	
	public void update(float delta){
		acceleration.x=-fricConst;acceleration.y=-fricConst;
		position.x=position.x+(velocity.x*delta);
		position.y=position.y+(velocity.y*delta);
		velocity.x=(velocity.x>0)?velocity.x+(acceleration.x*delta):0;
		velocity.y=(velocity.y>0)?velocity.y+(acceleration.y*delta):0;
		
	}
	/*
	public Polygon getShape(){
		return shape;
		
	}
	*/
	
	public Vector2 getVelocity(){return velocity;}
	public void setVelocity(Vector2 v){velocity.x=v.x;velocity.y=v.y;}
	public double getMass(){return mass;}
}
