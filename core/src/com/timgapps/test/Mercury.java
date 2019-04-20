package com.timgapps.test;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Mercury extends Body {
    public Mercury(Body parent, TextureRegion image, Vector2 position, float radius, float angle, float angularVelocity) {
        super(parent, image, position, radius, angle, angularVelocity);
    }
}
