package com.awakedev.cryptopia.entity.projectile;

import java.util.Random;

import com.awakedev.cryptopia.entity.Entity;
import com.awakedev.cryptopia.graphics.Sprite;

public abstract class Projectile extends Entity {

	protected final int xOrigin, yOrigin; 
	protected double angle;
	protected Sprite sprite;
	protected double nx, ny;
	protected double x, y;
	protected double distance;
	protected double speed, range, damage;
	
	protected final Random random = new Random();
	
	public Projectile(int x, int y, int dir) {
		xOrigin = x;
		yOrigin = y;
		angle = dir;
		this.x = x;
		this.y = y;
	}
	
	public Sprite getSprite() {
		return sprite;
		
	}
	
	public int getSpriteSize() {
		return sprite.SIZE;
	}
}
