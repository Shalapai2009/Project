package com.badlogic.drop;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.List;

public class Background {
    class Star {
    Vector2 position;
    float speed;
    static final float MIN_VALUE = 10f;
    static final float MAX_VALUE = 65f;
        public Star() {
            position = new Vector2((float) Math.random() * 1200, (float) Math.random() * 800);
            speed = MathUtils.random(MIN_VALUE, MAX_VALUE);
        }
      public void update(float dt) {
            position.x -= speed*dt;
            if (position.x <-50) {
                position.x = 1250;
                position.y = (float) Math.random() * 800;
                speed = MathUtils.random(MIN_VALUE, MAX_VALUE);
            }
        }

    }

    private Texture texture;
    private static Texture starTexture;
    List<Star> stars = new ArrayList<>();


    public Background() {
        texture = new Texture("background1200x800.png");
        if (starTexture == null) {
        starTexture = new Texture("star21x21.png");
        }
        for (int i = 0; i < 500; i++) {
            stars.add(new Star());
        }
    }


    public void render(SpriteBatch batch) {
        batch.draw(texture, 0,0);
        for (Star star:stars) {
            float scale = 0.3f + star.speed / star.MAX_VALUE * 0.4f;
            batch.draw(starTexture,star.position.x-10,star.position.y-10,10,10,21,21,scale,scale,0,0,0,21,21,false,false);
           /* if (Math.random() <0.005f) {
                scale *=1.5f;
                batch.draw(starTexture,star.position.x-8,star.position.y-8,8,8,21,21,scale,scale,0,0,0,21,21,false,false);
            }*/
        }

    }
    public void update (float dt) {
        for (Star star: stars) {
            star.update(dt);
        }
    }
    public void dispose(){
        texture.dispose();
    }
}
