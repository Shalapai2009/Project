package com.badlogic.drop;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Asteroid {
     Vector2 position;
     int hp;
     float speed;

    static Texture texture;
    float rotation;
    float scale;
    final float MIN_SPEED = 100f;
    final float MAX_SPEED = 300f;
    private float cscale;

    public Asteroid() {
        if (texture == null) {
            texture = new Texture("asteroid64.png");
        }
        position = new Vector2(MathUtils.random(1500f,2500f), MathUtils.random(0f,800f));
        speed = MathUtils.random(MIN_SPEED,MAX_SPEED);
        rotation = MathUtils.random(0f,360f);
        scale = MathUtils.random(0.8f,1.6f);
        hp = MathUtils.random(3,5);
    }

    public void render(Batch batch) {
        float cscale = 0.8f + hp * 0.1f;
        batch.draw(texture, position.x - 32, position.y - 32,32,32,64,64,cscale,cscale,rotation,0,0,64,64,false,false);
    }

    public void update(float dt) {
        position.x -= speed * dt;
        rotation += speed * dt / 20f;
        if (position.x <-300) {
            recreate();
        }
    }
    public void recreate() {
        position.set(MathUtils.random(1500f,2500f), MathUtils.random(0f,800f));
        speed = MathUtils.random(MIN_SPEED,MAX_SPEED);
        scale = MathUtils.random(0.8f,1.6f);
        hp = MathUtils.random(3,5);
        cscale = 0.8f + hp * 0.1f;

    }
    public void takeOneDamage(){
        hp-=1;
        if (hp<0){
            recreate();
        }
    }
}
