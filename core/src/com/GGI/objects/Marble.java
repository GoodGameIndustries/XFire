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

	private float size = .5f;
	
	public Marble(float xPos, float yPos, float xVel, float yVel, float xAcc, float yAcc){
	super(xPos,yPos,xVel,yVel,xAcc,yAcc,1.0);
	
	
	}
	
	public void update(float delta){
		super.update(delta);
		shape = new Polygon(new float[]{position.x+size,position.y,
				position.x+(.866f*size),position.y+(.5f*size),
				position.x+(.707f*size),position.y+(.707f*size),
				position.x+(.5f*size),position.y+(.866f*size),
				position.x,position.y+size,
				position.x-(.5f*size),position.y+(.866f*size),
				position.x-(.707f*size),position.y+(.707f*size),
				position.x-(.866f*size),position.y+(.5f*size),
				position.x-size,position.y,
				position.x-(.866f*size),position.y-(.5f*size),
				position.x-(.707f*size),position.y-(.707f*size),
				position.x-(.5f*size),position.y-(.866f*size),
				position.x,position.y-size,
				position.x+(.5f*size),position.y-(.866f*size),
				position.x+(.707f*size),position.y-(.707f*size),
				position.x+(.866f*size),position.y-(.5f*size)});
	}
	
	
}
