package com.timgapps.test;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Body extends Actor {
    private TextureRegion image;
    private Vector2 position;
    private double angle;
    private float radius;
    private Body parent;
    private float angularVelocity;

    public Body(Body parent, TextureRegion image, Vector2 position, float radius, float angle, float angularVelocity) {

        this.parent = parent;
        this.image = image;
        this.position = position;
        this.radius = radius;
        this.angle = angle;
        this.angularVelocity = angularVelocity;

        if (parent == null) {
            setX(position.x);
            setY(position.y);
        } else {
            setX(position.x + (float) (radius * Math.cos(Math.toRadians(angle))));
            setY(position.y + (float) (radius * Math.sin(Math.toRadians(angle))));
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(image, getX() - image.getRegionWidth() / 2, getY() - image.getRegionHeight() / 2);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        angle += angularVelocity;
        if (parent != null) {
            if (angle == 360) {
                angle -= 360;
            }
            position.x = (float) (radius * Math.cos(Math.toRadians(angle)));
            position.y = (float) (radius * Math.sin(Math.toRadians(angle)));
            setX(position.x + parent.getX());
            setY(position.y + parent.getY());
        }
    }


}
