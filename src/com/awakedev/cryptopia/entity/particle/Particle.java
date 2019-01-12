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
		this.zz = random.nextFloat() + 2.0;
	}
	

	public void update() {
		time++;
		if (time > 5000) time = 0;
		if (time > life) remove();
		za -= 0.1;
		
		if (zz < 0) {
			zz = 0;
			// Reverse direction
			za *= -0.5;
			xa *= 0.4;
			ya *= 0.4;
		}
		
			move(xx + xa, (yy + ya) + (zz +za));
		
	}
	
	private void move(double x, double y) {
		if (collision(x,y)) {
			this.xa *= -0.5;
			this.ya *= -0.5;
			this.za *= -0.5;
		}
		this.zz += za;
		this.yy += ya;
		this.xx += xa;

	}
	

	public boolean collision(double x, double y) {
		boolean solid = false;
		for (int c = 0; c < 4; c++) {
			double xt = (x - c % 2 * 16) / 16;
			double yt = (y - c / 2 * 16) / 16;
			int ix = (int) Math.ceil(xt);
			int iy = (int) Math.ceil(yt);
			if (c % 2 == 0) ix = (int) Math.floor(xt);
			if (c % 2 == 0) iy = (int) Math.floor(yt);
			if (level.getTile(ix, iy).solid()) solid = true;
		}
		return solid;	
	}
	


	public void render(Screen screen) {
		screen.renderSprite((int) xx, (int)yy - (int) zz - 2, sprite, true);
	}
}
