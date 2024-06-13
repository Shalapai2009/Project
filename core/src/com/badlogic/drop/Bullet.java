package com.badlogic.drop;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public class Bullet {
     Vector2 position;
     float speed;

    static Texture texture;
    boolean alive;

    public Bullet () {
        if (texture == null) {
            texture = new Texture("bullet40x15.png");
        }
        position = new Vector2(0, 0);
        speed = 400f;
        alive = false;
    }

    public void render(Batch batch) {
        batch.draw(texture, position.x - 40, position.y - 15);
    }

    public void update(float dt) {
        position.x += speed * dt;
        if (position.x > 1250) {
            alive = false;
        }
    }
    public void setup(Vector2 position) {
        this.position.set(position).add(70,40);
        alive = true;
    }
    public void destroy(){
        alive = false;
    }
}
