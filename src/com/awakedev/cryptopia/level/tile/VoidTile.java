package com.awakedev.cryptopia.level.tile;

import com.awakedev.cryptopia.graphics.Screen;
import com.awakedev.cryptopia.graphics.Sprite;

public class VoidTile extends Tile {

	public VoidTile(Sprite sprite) {
		super(sprite);
	}


	public void render(int x, int y, Screen screen) {
		screen.renderTile(x, y, this);
			
	}

	
}
