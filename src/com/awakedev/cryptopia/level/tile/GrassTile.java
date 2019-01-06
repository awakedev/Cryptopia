package com.awakedev.cryptopia.level.tile;

import com.awakedev.cryptopia.graphics.Screen;
import com.awakedev.cryptopia.graphics.Sprite;

public class GrassTile extends Tile {

	public GrassTile(Sprite sprite) {
		super(sprite);
	}
	
	

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
			
	}

	
	
	
}
