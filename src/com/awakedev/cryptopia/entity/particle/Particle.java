package com.awakedev.cryptopia.entity.particle;

import com.awakedev.cryptopia.entity.Entity;
import com.awakedev.cryptopia.graphics.Screen;
import com.awakedev.cryptopia.graphics.Sprite;

public class Particle extends Entity {

	private Sprite sprite;
	
	private int life;
	
	private int time = 0;
	
	
	// Amount of pixels particles move on x and y axis
	protected double xa, ya, za;
	protected double xx, yy, zz;
	
	
	public Particle(int x, int y, int life) {
		this.x = x;
		this.y = y;
		this.xx = x;
		this.yy = y;
		this.life = life + (random.nextInt(50) - 20);
		sprite = Sprite.particle_normal;		
		
		// Distributed double values between 0 and 1
		this.xa = random.nextGaussian();
		this.ya = random.nextGaussian();
		this.zz = 2.0;
	}
	

	public void update() {
		time++;
		if (time > 5000) time = 0;
		if (time > life) remove();
		za -= 0.1;
		
		if (zz < 0) {
			zz = 0;
			// Reverse direction
			za *= -0.75;
			xa *= 0.5;
			ya *= 0.5;
		}
			this.xx += xa;
			this.yy += ya;
			this.zz += za;
		
		

	}
	
	public void render(Screen screen) {
		screen.renderSprite((int)xx, (int)yy - (int) zz, sprite, true);
	}
}
