package com.awakedev.cryptopia.entity.projectile;

import com.awakedev.cryptopia.entity.spawner.ParticleSpawner;
import com.awakedev.cryptopia.graphics.Screen;
import com.awakedev.cryptopia.graphics.Sprite;

public class WizardProjectile extends Projectile {

	// Higher number means slower fire rate
	public static final int FIRE_RATE = 10;  
	
	public WizardProjectile(int x, int y, int dir) {
		super(x, y, dir);
		range = random.nextInt(250);
		damage = 20;
		speed = 3;
		sprite = Sprite.projectile_wizard;
		nx = speed * Math.cos(angle);
		ny = speed * Math.sin(angle);
	}

	public void update() {
		if (level.tileCollision((int) (x + nx), (int) (y + ny), 7, 5, 4)) {
			level.add (new ParticleSpawner((int) x, (int) y, 100, 100, level));
			remove();
			}
		move();
	}
	
	protected void move() {
		x += nx;
		y += ny;	
		if (distance() > range) remove();
	}
	
	
	private double distance() {
		double dist = 0;
		dist = Math.sqrt(Math.abs((xOrigin - x) * (xOrigin - x) + (yOrigin - y) * (yOrigin - y)));
		return dist;
	}

	public void render(Screen screen) {
		screen.renderProjectile((int) x - 12, (int) y - 2, this);
	}
	
	
}
