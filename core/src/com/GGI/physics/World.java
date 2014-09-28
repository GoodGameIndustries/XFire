/**
 * 
 */
package com.GGI.physics;

import java.util.ArrayList;
import com.badlogic.gdx.math.Vector2;
import com.GGI.objects.*;
import com.GGI.objects.Object;
import com.badlogic.gdx.math.Intersector;

/**
 * @author Emmett Deen
 *
 */
public class World {
	public ArrayList<Marble> objects = new ArrayList<Marble>();
	
	private int Ms;//static friction
	
	
	public World(){
		populate();
	}
	
	private void populate() {
		objects.add(new Marble(1f,1f,1f,1f,0,0));
		
	}

	public void checkHit(){//hit detection
		for(int i = 0; i < objects.size();i++){
			for(int j = 0; j < objects.size();j++){
				if(Intersector.overlapConvexPolygons(objects.get(i).getShape(),objects.get(j).getShape())){
					collide(objects.get(i),objects.get(j));
				}
			}
		}
	}
	
	public void update(float delta){
		for(int i = 0; i < objects.size();i++){
			objects.get(i).update(delta);
		}
	}
	
	public void collide(Object obj1,Object obj2){//calculate velocities from collision
		Vector2 v1=obj1.getVelocity(); Vector2 v2=obj2.getVelocity();
		double m1=obj1.getMass(); double m2=obj2.getMass();
		float v1x=(float) (((double)((m1-m2)/(m1+m2)))*v1.x)+(float)((double)(2*m2/((double)m1+m2)))*v2.x;//physics c textbook p.239
		float v2x=(float) (((double)((m2-m1)/(m2+m1)))*v2.x)+(float)((double)(2*m1/((double)m2+m1)))*v1.x;//v1f=((m1-m2)/(m1+m2))*v1+(2m2/(m1+m2))*v2
		float v1y=(float) (((double)((m1-m2)/(m1+m2)))*v1.y)+(float)((double)(2*m2/((double)m1+m2)))*v2.y;
		float v2y=(float) (((double)((m2-m1)/(m2+m1)))*v2.y)+(float)((double)(2*m1/((double)m2+m1)))*v1.y;
		obj1.setVelocity(new Vector2(v1x,v1y));obj2.setVelocity(new Vector2(v2x,v2y));
	}
	
	public void collideWall(Object obj){//calculate velocity for wall collision
		
	}
}
