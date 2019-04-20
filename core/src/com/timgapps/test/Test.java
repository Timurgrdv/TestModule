package com.timgapps.test;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Test extends Game {

    public static TextureAtlas atlas;
    public static SpriteBatch batch;

    private Screen scene;

    public static final int V_WIDTH = 1280;
    public static final int V_HEIGHT = 720;

    public Test() {
    }

    @Override
    public void create() {
        batch = new SpriteBatch();
        atlas = new TextureAtlas("images/pack.atlas");
        showScene();
    }

    public void showScene() {
        scene = new PlayScene(this);
        setScreen(scene);
    }

    @Override
    public void dispose() {
        super.dispose();
        atlas.dispose();
    }
}