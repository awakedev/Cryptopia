package com.awakedev.cryptopia.entity;

import java.util.Random;

import com.awakedev.cryptopia.graphics.Screen;
import com.awakedev.cryptopia.level.Level;

public class Entity {
	public int x, y;
	private boolean removed = false;
	
	protected Level level;
	protected final Random random = new Random();
	
	public void update() {		
	}
	
	public void render(Screen screen) {		
	}
	
	public void remove() {
		// Remove entity from level
		removed = true;
	}

	public boolean isRemoved() {
		return removed;
	}
	
	
}
