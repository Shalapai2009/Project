package com.badlogic.drop;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Starter extends ApplicationAdapter {
	SpriteBatch batch;
	private Background background;
	private Player player;
	private KeyboardAdapter inputProcessor = new KeyboardAdapter();
	int k = 0;
	int x = 400;
	int y = 450;
	int speed = 400;
	List<Bullet> bullets = new ArrayList<>();
	List<Asteroid> asteroids = new ArrayList<>();

	@Override
	public void create () {
		Gdx.input.setInputProcessor(inputProcessor);

		batch = new SpriteBatch();
		/*img1 = new Texture("badlogic.jpg");
		textureBaground = new Texture("Labyrinth.png");
		img3 = new Texture("myCreature.png");*/
		player = new Player(speed ,x,y,this);
		background = new Background();
		for (int i = 0; i < 100; i++) {
			bullets.add(new Bullet());
		}
		for (int i = 0; i < 20; i++) {
			asteroids.add(new Asteroid());
		}
	}

	@Override
	public void render () {
		float dt = Gdx.graphics.getDeltaTime();
		player.moveTo(inputProcessor.getDirection(dt));
        ScreenUtils.clear(1, 1, 1, 1);
		batch.begin();
		background.render(batch);
		player.render(batch);
		for (Asteroid asteroid: asteroids) {
			asteroid.render(batch);
		}
		for (Bullet bullet: bullets) {
			if (bullet.alive) {
				bullet.render(batch);
			}
		}
		//player.firei(inputProcessor.getShoot());
		update(dt);

		//batch.draw(img1,x,y);
		batch.end();
	}

	public void update(float dt) {
		background.update(dt);
		player.updateFire(dt);
		for (Asteroid asteroid: asteroids) {
			asteroid.update(dt);
		}
		for (Bullet bullet: bullets) {
			if (bullet.alive) {
				bullet.update(dt);
			}

		}
		checkCollisions();
	}
	public void checkCollisions(){
		for (Bullet bullet: bullets) {
			if (bullet.alive){
				for (Asteroid asteroid: asteroids) {
					if (bullet.position.dst(asteroid.position)<32) {
						bullet.destroy();
						asteroid.takeOneDamage();
						break;
					}
				}
			}
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		player.dispose();
		background.dispose();
	}
}
