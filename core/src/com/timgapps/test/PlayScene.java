package com.timgapps.test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class PlayScene implements Screen {

    private Stage stage;

    private Test test;

    private Sun sun;
    private Earth earth;
    private Satellite satellite;
    private Mercury mercury;

    private Button button;

    private boolean IS_PLAY = false;

    public PlayScene(Test test) {
        this.test = test;
        stage = new Stage();

        sun = new Sun(null, new TextureRegion(test.atlas.findRegion("sun")),
                new Vector2(stage.getWidth() / 2, stage.getHeight() / 2), 0, 0, 0);

        earth = new Earth(sun, new TextureRegion(test.atlas.findRegion("earth")),
                new Vector2(sun.getX(), sun.getY()), 280, 0, 1);

        mercury = new Mercury(sun, new TextureRegion(test.atlas.findRegion("mercury")),
                new Vector2(sun.getX(), sun.getY()), 120, 90, 3);

        satellite = new Satellite(earth, new TextureRegion(test.atlas.findRegion("satellite")),
                new Vector2(earth.getX(), earth.getY()), 90, 30, 2);

        stage.addActor(sun);
        stage.addActor(earth);
        stage.addActor(mercury);
        stage.addActor(satellite);

        button = new Button();
        stage.addActor(button);
        button.setPosition(100, 100);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        IS_PLAY = button.getIsPlay();
        if (IS_PLAY) {
            stage.act(delta);
        }
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
