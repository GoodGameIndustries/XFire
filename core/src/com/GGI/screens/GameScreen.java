/**
 * 
 */
package com.GGI.screens;

import java.util.ArrayList;

import com.GGI.crossfire.Crossfire;
import com.GGI.objects.Marble;
import com.GGI.objects.Wall;
import com.GGI.physics.World;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;


/**
 * @author Emmett Deen
 *
 */
public class GameScreen implements Screen,InputProcessor{

	private Crossfire XF;
	private World world;
	private OrthographicCamera cam;
	private float cX = (Gdx.graphics.getWidth()/100)/2, cY=(Gdx.graphics.getHeight()/100)/2;
	private float mX = Gdx.graphics.getWidth()/100,mY=Gdx.graphics.getHeight()/100;
	private float fricConst;
	private int w=Gdx.graphics.getWidth(),h=Gdx.graphics.getHeight();
	private Wall wall;
	
	private ShapeRenderer debug = new ShapeRenderer();
	private SpriteBatch pic = new SpriteBatch();
	private Texture marble = new Texture(Gdx.files.internal("Marble.png"));
	private ArrayList<Marble> added=new ArrayList<Marble>();
	private int count;
	public GameScreen(Crossfire XF){
		this.XF=XF;
		world=new World(cX,cY,mX,mY);
		fricConst=world.getFricConst();
		this.cam = new OrthographicCamera(Gdx.graphics.getWidth()/100, Gdx.graphics.getHeight()/100);
		this.cam.position.set(cX,cY,0);
		this.cam.update();
		wall=world.wall;
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(.1f, .1f, .1f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		debug.setProjectionMatrix(cam.combined);
		
		world.update(delta);
		
		debug.begin(ShapeType.Line);
		pic.begin();
		for(int i = 0; i < world.objects.size(); i++){
			debug.circle(world.objects.get(i).position.x,world.objects.get(i).position.y,world.objects.get(i).size,10);
			//pic.draw(marble,(world.objects.get(i).position.x-(world.objects.get(i).size/2))*108,((world.objects.get(i).position.y-(world.objects.get(i).size/2)))*118,world.objects.get(i).size*108,world.objects.get(i).size*108);
		}
		    debug.rect(wall.position.x,wall.position.y,wall.getShape().x,wall.getShape().y);
		pic.end();
		debug.end();
		
	
		world.checkHit(delta);
		
		for(Marble marble:added){world.addObjects(marble);}
		count=world.getCount();
		added.clear();System.out.println(count);
		count=count+1;count=(count>20)?20:count;
		world.setCount(count);
		
		
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(this);
		
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

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		screenY = h-screenY;
		
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		screenY = h-screenY;
		float x = screenX/100;
		float y = screenY/100;
		if(y>1f&&y<cY){
		added.add(new Marble(cX,1f,(x-cX),5f,0,0,fricConst));
		//world.objects.add(new Marble(cX,1f,(x-cX),5f,0,0,fricConst));
		}
		return true;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
