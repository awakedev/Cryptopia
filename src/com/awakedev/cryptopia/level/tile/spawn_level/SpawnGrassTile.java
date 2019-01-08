package com.awakedev.cryptopia.level.tile.spawn_level;

import com.awakedev.cryptopia.graphics.Screen;
import com.awakedev.cryptopia.graphics.Sprite;
import com.awakedev.cryptopia.level.tile.Tile;

public class SpawnGrassTile extends Tile {

	public SpawnGrassTile(Sprite sprite) {
		super(sprite);
		// TODO Auto-generated constructor stub
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
			
	}

	

}
