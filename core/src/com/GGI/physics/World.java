/**
 * 
 */
package com.GGI.physics;

import java.util.ArrayList;

import com.GGI.objects.*;
import com.GGI.objects.Object;
import com.badlogic.gdx.math.Intersector;

/**
 * @author Emmett Deen
 *
 */
public class World {
	public ArrayList<Object> objects = new ArrayList<Object>();
	
	private int Ms;//static friction
	
	
	public World(){
		
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
		
	}
	
	public void collideWall(Object obj){//calculate velocity for wall collision
		
	}
}
