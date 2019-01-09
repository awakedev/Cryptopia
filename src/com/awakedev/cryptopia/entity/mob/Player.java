package com.awakedev.cryptopia.entity.mob;

import com.awakedev.cryptopia.Game;
import com.awakedev.cryptopia.graphics.Screen;
import com.awakedev.cryptopia.graphics.Sprite;
import com.awakedev.cryptopia.input.Keyboard;
import com.awakedev.cryptopia.input.Mouse;

public class Player extends Mob {

	private Keyboard input;
	private Sprite sprite;
	private int anim = 0;
	private boolean walking = false;
	
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
		if (anim < 7500) anim++ ; 
		else anim = 0;
		if (input.up) ya--;
		if (input.down) ya++;
		if (input.left) xa--;
		if (input.right) xa++;
		if (xa != 0 || ya != 0) {
			move (xa, ya);
			walking = true; 
		} else { 
			walking = false;
		}
		
		updateShooting();
	}
	
	
	private void updateShooting() {
	
		
		if (Mouse.getButton() == 1) {
			double dx = Mouse.getX() - Game.getWindowWidth() / 2;
			double dy = Mouse.getY() -  Game.getWindowHeight() / 2;
			double dir = Math.atan2(dy, dx);
			shoot(x, y, dir);
		}		
	}
	
	

	public void render(Screen screen) {
		if (dir == 3) {
			sprite = Sprite.player_b;
		
		if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.player_b_1;
				} else {
					sprite = Sprite.player_b_2;
				}
			}
		
		}
		
		if (dir == 1) {
			sprite = Sprite.player_e;
		
		if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.player_e_1;
				} else {
					sprite = Sprite.player_e_2;
				}
			}
		
		}
		
		if (dir == 2) {
			sprite = Sprite.player_w;
		
		if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.player_w_1;
				} else {
					sprite = Sprite.player_w_2;
				}
			}
		
		}
		
		if (dir == 0) {
			sprite = Sprite.player_f;
		
		if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.player_f_1;
				} else {
					sprite = Sprite.player_f_2;
				}
			}
		
		}
		

		screen.renderPlayer(x - 16, y - 16, sprite);

	
	}
	
}
