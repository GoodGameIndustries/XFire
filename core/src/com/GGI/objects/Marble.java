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
public class Marble extends Object{

	public float size = .3f;
	public Circle shape;
	
	public Marble(float xPos, float yPos, float xVel, float yVel, float xAcc, float yAcc,float fricConst){
	super(xPos,yPos,xVel,yVel,xAcc,yAcc,1.0,fricConst);
	
	
	}
	
	public void update(float delta){
		super.update(delta);
		/*shape = new Polygon(new float[]{position.x+size,position.y,
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
	*/
		shape = new Circle(position.x,position.y,size);
	}
	
	public Circle getShape(){
		return shape;
		
	}
}
