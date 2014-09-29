/**
 * 
 */
package com.GGI.screens;

import com.GGI.crossfire.Crossfire;
import com.GGI.physics.World;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;


/**
 * @author Emmett Deen
 *
 */
public class GameScreen implements Screen{

	private Crossfire XF;
	private World world;
	private OrthographicCamera cam;
	private float cX = (Gdx.graphics.getWidth()/100)/2, cY=(Gdx.graphics.getHeight()/100)/2;
	private float mX = Gdx.graphics.getWidth()/100,mY=Gdx.graphics.getHeight()/100;

	private ShapeRenderer debug = new ShapeRenderer();
	
	public GameScreen(Crossfire XF){
		this.XF=XF;
		world=new World(cX,cY,mX,mY);
		this.cam = new OrthographicCamera(Gdx.graphics.getWidth()/100, Gdx.graphics.getHeight()/100);
		this.cam.position.set(cX,cY,0);
		this.cam.update();
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(.1f, .1f, .1f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		debug.setProjectionMatrix(cam.combined);
		
		world.update(delta);
		
		debug.begin(ShapeType.Line);
		//debug.setColor(1, 1, 1, 1);
		/*
		for(int i = 0; i < world.objects.size(); i++){
			debug.polygon(world.objects.get(i).getShape().getVertices());
		}
		*/
		
		for(int i = 0; i < world.objects.size(); i++){
			debug.circle(world.objects.get(i).position.x,world.objects.get(i).position.y,world.objects.get(i).size,100);
		}
		debug.end();
		
	//	
		world.checkHit();
		
		
		
		
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
