/**
 * 
 */
package com.GGI.physics;

import java.util.ArrayList;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Polygon;
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
	public ArrayList<Center> centers = new ArrayList<Center>();
	
	private int Ms;//static friction
	private float cX,cY,mX,mY;
	private final float fricConst=(float) 1;
	private int count=0;
	public Wall wall;
	public World(float cX, float cY, float mX, float mY){
		this.cX=cX;
		this.cY=cY;
		this.mX=mX;
		this.mY=mY;
		wall=new Wall(mX,mY);
		populate();
	}
	
	private void populate() {
		objects.add(new Marble(cX-4f,cY,0f,0f,0f,0f,fricConst));
		objects.add(new Marble(cX-2f,cY,0f,0f,0f,0f,fricConst));
		objects.add(new Marble(cX,cY,0f,0f,0f,0f,fricConst));
		objects.add(new Marble(cX+2f,cY,0f,0f,0f,0f,fricConst));
		objects.add(new Marble(cX+4f,cY,0f,0f,0f,0f,fricConst));
	}

	public void checkHit(float delta){//hit detection
		
		/**Checks hit between marbles*/
		for(int i = 0; i < objects.size();i++){
			for(int j = i; j < objects.size();j++){
				if(i==j){}
				else if(Intersector.overlaps(objects.get(i).getShape(),objects.get(j).getShape())){
					collide(objects.get(i),objects.get(j));	
				}
			}
		}
		
		/**Checks hit between marbles and center peices*/
		for(int i = 0;i<objects.size();i++){
			for(int j = 0; j < centers.size();j++){
				if(overlaps(centers.get(j).getShape(),objects.get(i).getShape())){
					objects.get(i).position.x=objects.get(i).position.x-(objects.get(i).velocity.x*delta);
					objects.get(i).position.y=objects.get(i).position.y-(objects.get(i).velocity.y*delta);
					
					objects.get(j).position.x=objects.get(j).position.x-(objects.get(j).velocity.x*delta);
					objects.get(j).position.y=objects.get(j).position.y-(objects.get(j).velocity.y*delta);
					
					collide(objects.get(i),centers.get(j));
				}
			}
		}
		
		/**Checks hit etween marbles and wall*/
		for(int i = 0; i < objects.size();i++){
			
				if(Intersector.overlaps(objects.get(i).getShape(), wall.getShape())){
				//do nothing	
				}
				else{
					collide(objects.get(i));
			}
		}
	}
	
	public void update(float delta){
		for(int i = 0; i < objects.size();i++){
			objects.get(i).update(delta);
		}
	}
	
	public void collide(Marble obj1,Marble obj2){//calculate velocities from collision for marbles only
		Vector2 v1=obj1.getVelocity(); Vector2 v2=obj2.getVelocity();
		double m1=obj1.getMass(); double m2=obj2.getMass();
		float v1x, v1y, v2x, v2y;
		if(v1.x==0 && v2.x!=0){
			v1x=(float) ((((double)(2*m2))/((double)(m1+m2)))*v2.x);//p.238 physics C textbook
			v2x=(float) (((double)(m2-m1)/(double)(m1+m2))*v2.x);
		}
		else if(v1.x!=0 && v2.x==0){
			v1x=(float) ((double)(m1-m2)/(double)(m1+m2))*v1.x;
			v2x=(float) ((double)(2*m1)/(double)(m1+m2))*v1.x;
		}
		else{
			 v1x=(float) (((double)((m1-m2)/(m1+m2)))*v1.x)+(float)((double)(2*m2/((double)m1+m2)))*v2.x;//physics c textbook p.239
		 	 v2x=(float) (((double)((m2-m1)/(m2+m1)))*v2.x)+(float)((double)(2*m1/((double)m2+m1)))*v1.x;//v1f=((m1-m2)/(m1+m2))*v1+(2m2/(m1+m2))*v2
		}
		if(v1.y==0 && v2.y!=0){
			v1y=(float) ((((double)(2*m2))/((double)(m1+m2)))*v2.y);
			v2y=(float) (((double)(m2-m1)/(double)(m1+m2))*v2.y);
		}
		else if(v1.y!=0 && v2.y==0){
			v1y=(float) ((double)(m1-m2)/(double)(m1+m2))*v1.y;
			v2y=(float) ((double)(2*m1)/(double)(m1+m2))*v1.y;
		}
		else{
			v1y=(float) (((double)((m1-m2)/(m1+m2)))*v1.y)+(float)((double)(2*m2/((double)m1+m2)))*v2.y;
			v2y=(float) (((double)((m2-m1)/(m2+m1)))*v2.y)+(float)((double)(2*m1/((double)m2+m1)))*v1.y;
		}
		obj1.setVelocity(new Vector2(v1x,v1y));obj2.setVelocity(new Vector2(v2x,v2y));
	}
	
	public void collide(Marble m, Center c){//calculate velocities for center and marble collision
		
	}
	
	public void collide(Marble obj){//calculate velocity for wall collision for marble
		
	}
	
	public void collide(Center obj){//calculate velocity for wall collision for center
		
	}
	
	public boolean overlaps(Polygon polygon, Circle circle) {//overlap method for circle and polygon;
	    float []vertices=polygon.getTransformedVertices();
	    Vector2 center=new Vector2(circle.x, circle.y);
	    float squareRadius=circle.radius*circle.radius;
	    for (int i=0;i<vertices.length;i+=2){
	        if (i==0){
	            if (Intersector.intersectSegmentCircle(new Vector2(vertices[vertices.length-2], vertices[vertices.length-1]), new Vector2(vertices[i], vertices[i+1]), center, squareRadius))
	                return true;
	        } else {
	            if (Intersector.intersectSegmentCircle(new Vector2(vertices[i-2], vertices[i-1]), new Vector2(vertices[i], vertices[i+1]), center, squareRadius))
	                return true;
	        }
	    }
	    return false;
	}
	
	public float getFricConst(){return fricConst;}
	
	public void addObjects(Marble marble){
		if(count!=100){return;}
		else{objects.add(marble);count=0;}
	}
	
	public int getCount(){return count;}
	public void setCount(int count){this.count=count;}
	
}
