package com.badlogic.drop;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;

import static java.lang.Math.abs;

public class KeyboardAdapter extends InputAdapter {
    private boolean leftPressed;
    private boolean rightPressed;
    private boolean upPressed;
    private boolean downPressed;
    private boolean spacePressed;
    private final Vector2 direction = new Vector2();

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.A) {
            leftPressed = true;
        }
        if (keycode == Input.Keys.D) {
            rightPressed = true;
        }
        if (keycode == Input.Keys.W) {
            upPressed = true;
        }
        if (keycode == Input.Keys.S) {
            downPressed = true;
        }
        if (keycode == Input.Keys.SPACE) {
            spacePressed  = true;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {

        if (keycode == Input.Keys.A) {
            leftPressed = false;
        }
        if (keycode == Input.Keys.D) {
            rightPressed = false;
        }
        if (keycode == Input.Keys.W) {
            upPressed = false;
        }
        if (keycode == Input.Keys.S) {
            downPressed = false;
        }
        if (keycode == Input.Keys.SPACE) {
            spacePressed = false;
        }
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }
    public Vector2 getDirection(float dt) {
        direction.set(0, 0);

        if (leftPressed) {
            direction.add(-dt,0);

        }
        if (rightPressed) {
            direction.add(dt,0);
        }
        if (upPressed) {
            direction.add(0,dt);
        }
        if (downPressed) {
            direction.add(0, -dt);
        }
        Vector2 directionNor = new Vector2(direction).nor();
        direction.scl(abs(directionNor.x),abs(directionNor.y));
        return direction;
    }
    public boolean getShoot() {
        return spacePressed;
    }


}
