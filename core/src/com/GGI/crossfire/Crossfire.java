package com.GGI.crossfire;

import com.GGI.screens.GameScreen;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Crossfire extends Game {
	
	
	@Override
	public void create () {
		this.setScreen(new GameScreen(this));
	}

	
}
