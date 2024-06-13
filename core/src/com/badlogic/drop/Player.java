package com.badlogic.drop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public class Player {
    Starter game;
    private final Vector2 position = new Vector2();
    private float speed;
    private Texture texture;
    float fireTime;
    float fireRate;

    public Player(float speed, float x, float y, Starter game) {
        texture = new Texture("fighter80x65.png");
        position.set(x, y);
        this.speed = speed;
        this.game = game;
        fireRate = 0.2f;
    }

    public void render(Batch batch) {
        batch.draw(texture, position.x, position.y);
    }

    public void updateFire(float dt) {
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            fireTime += dt;
            if (fireTime > fireRate) {
                fireTime -= fireRate;
                fire();
            }
        }
    }

    public void dispose() {
        texture.dispose();
    }

    public void moveTo(Vector2 direction) {
       /* if (direction.equals(new Vector2(0,0))){
            texture = new Texture("myCreature2.png");
        }
        if (direction.equals(new Vector2(-5,0))){
            texture = new Texture("leftPlayer.png");
        }
        if (direction.equals(new Vector2(5,0))){
            texture = new Texture("rightPlayer.png");
        }
        if (direction.equals(new Vector2(0,5))){
            texture = new Texture("downPlayer.png");
        }
        if (direction.equals(new Vector2(0,-5))) {
            texture = new Texture("myCreature2.png");
        }*/
        position.add(direction.scl(speed));
    }


    public void fire(/*boolean shoot*/) {
        for (Bullet bullet : game.bullets) {
            if (!bullet.alive /*& shoot*/) {
                bullet.setup(position);
                return;
            }
        }

    }
    public void firei(boolean shoot) {
        for (Bullet bullet : game.bullets) {
            if (!bullet.alive & shoot) {
                bullet.setup(position);
                return;
            }
        }

    }
}
