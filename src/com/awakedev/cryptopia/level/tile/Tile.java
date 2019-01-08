package com.awakedev.cryptopia.level.tile;

import com.awakedev.cryptopia.graphics.Screen;
import com.awakedev.cryptopia.graphics.Sprite;
import com.awakedev.cryptopia.level.tile.spawn_level.SpawnGrassTile;
import com.awakedev.cryptopia.level.tile.spawn_level.SpawnSandTile;
import com.awakedev.cryptopia.level.tile.spawn_level.SpawnWallTile;

public class Tile {
	
	public int x,y;
	public Sprite sprite;
	
	
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	public static Tile flower = new FlowerTile(Sprite.flower);
	public static Tile rock = new RockTile(Sprite.rock);

	
	// Spawn tiles
	
	public static Tile spawn_grass = new SpawnGrassTile(Sprite.spawn_grass);
	public static Tile spawn_sand = new SpawnSandTile(Sprite.spawn_sand);
	public static Tile spawn_wall = new SpawnWallTile(Sprite.spawn_wall);

	public static Tile spawn_grass_d = new SpawnGrassTile(Sprite.spawn_grass);
	public static Tile spawn_sand_d = new SpawnSandTile(Sprite.spawn_sand);
	public static Tile spawn_wall_d = new SpawnWallTile(Sprite.spawn_wall);

	public static final int col_spawn_grass = 0xff0ed145;
	public static final int col_spawn_sand = 0xffb97a56;
	public static final int col_spawn_wall = 0xffc3c3c3;
	public static final int col_spawn_wall_d = 0xff585858;

	

			// Grass = 0xff0ed145
			// Flower = 0xfffff200
			// Rock = 0xffb97a56
			
	
	public Tile(Sprite sprite) {
		this.sprite = sprite;

	}
	
	public void render(int x, int y, Screen screen) {
		
	}
	
	public boolean solid() {
		return false;
		
	}
}
