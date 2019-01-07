package com.awakedev.cryptopia.level.tile;

import com.awakedev.cryptopia.graphics.Screen;
import com.awakedev.cryptopia.graphics.Sprite;

public class FlowerTile extends Tile {

	public FlowerTile(Sprite sprite) {
		super(sprite);
	}


	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
			
	}

}
