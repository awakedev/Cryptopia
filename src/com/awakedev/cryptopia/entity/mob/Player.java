package com.awakedev.cryptopia.entity.mob;

import com.awakedev.cryptopia.graphics.Screen;
import com.awakedev.cryptopia.graphics.Sprite;
import com.awakedev.cryptopia.input.Keyboard;

public class Player extends Mob {

	private Keyboard input;
	private Sprite sprite;
	

	
	public Player(Keyboard input) {
		this.input = input;
		sprite = Sprite.player_f;
	}
	
	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
		sprite = Sprite.player_f;
	}
	
	public void update() {
		
		int xa = 0, ya = 0;
		if (input.up) ya--;
		if (input.down) ya++;
		if (input.left) xa--;
		if (input.right) xa++;
		
		if (xa != 0 || ya != 0) move (xa, ya);
	}
	
	public void render(Screen screen) {
		if (dir == 0) sprite = Sprite.player_f;
		if (dir == 1) sprite = Sprite.player_e;
		if (dir == 2) sprite = Sprite.player_w;
		if (dir == 3) sprite = Sprite.player_b;

		screen.renderPlayer(x - 16, y - 16, sprite);

	
	}
	
}
