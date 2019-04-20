package com.timgapps.test;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Button extends Group {

    private Image startImage, stopImage;
    private boolean isPlay = false;

    public Button() {
        startImage = new Image(Test.atlas.findRegion("start"));
        stopImage = new Image(Test.atlas.findRegion("stop"));

        addActor(startImage);
        addActor(stopImage);
        stopImage.setVisible(false);

        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                setIsPlay();
            }
        });
    }


    public void setIsPlay() {
        if (!isPlay) {
            isPlay = true;
            startImage.setVisible(false);
            stopImage.setVisible(true);
        } else {
            isPlay = false;
            startImage.setVisible(true);
            stopImage.setVisible(false);
        }
    }

    public boolean getIsPlay() {
        return isPlay;
    }
}
