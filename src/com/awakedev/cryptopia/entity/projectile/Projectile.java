package com.awakedev.cryptopia.entity.projectile;

import com.awakedev.cryptopia.entity.Entity;
import com.awakedev.cryptopia.graphics.Sprite;

public abstract class Projectile extends Entity {

	protected final int xOrigin, yOrigin; 
	protected double angle;
	protected Sprite sprite;
	protected double nx, ny;
	protected double speed, rateOfFire, range, damage;
	
	public Projectile(int x, int y, int dir) {
		xOrigin = x;
		yOrigin = y;
		angle = dir;
	}
}
