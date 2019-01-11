package com.awakedev.cryptopia.entity.spawner;

import com.awakedev.cryptopia.entity.particle.Particle;
import com.awakedev.cryptopia.level.Level;

public class ParticleSpawner extends Spawner {
	
	private int life;
	private int time = 0;

	public ParticleSpawner(int x, int y, int life, int amount, Level level) {
		super(x, y, Type.PARTICLE, amount, level);
		this.life = life;

		for (int i = 0; i < amount; i++) {
				 level.add(new Particle(x, y, life));
				
		}
	}
	
	
	public void update() {
		time++;
		if (time > this.life) remove();


	}	

	
}
