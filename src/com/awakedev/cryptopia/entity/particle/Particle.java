package com.awakedev.cryptopia.entity.particle;

import com.awakedev.cryptopia.entity.Entity;
import com.awakedev.cryptopia.graphics.Screen;
import com.awakedev.cryptopia.graphics.Sprite;

public class Particle extends Entity {

	private Sprite sprite;
	
	private int life;
	
	
	// Amount of pixels particles move on x and y axis
	protected double xa, ya, xx, yy;
	
	
	public Particle(int x, int y, int life) {
		this.x = x;
		this.y = y;
		this.xx = x;
		this.yy = y;
		this.life = life;
		sprite = Sprite.particle_normal;
		
		// Distributed double values between 0 and 1
		this.xa = random.nextGaussian();
		this.ya = random.nextGaussian();
	}
	
	

	
	public void update() {
		this.xx += xa;
		this.yy += ya;
	}
	
	public void render(Screen screen) {
		screen.renderSprite((int)xx, (int)yy, sprite, true);
	}
}
