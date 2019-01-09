package com.awakedev.cryptopia.entity.projectile;

public class WizardProjectile extends Projectile {

	public WizardProjectile(int x, int y, int dir) {
		super(x, y, dir);
		range = 200;
		damage = 20;
		rateOfFire = 15;
		speed = 4;

		nx = speed * Math.cos(angle);
		ny = speed * Math.sin(angle);
	}

	public void update() {
		
	}
}
