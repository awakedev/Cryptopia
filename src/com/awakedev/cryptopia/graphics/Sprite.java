package com.awakedev.cryptopia.graphics;

public class Sprite {

	public final int SIZE;
	private int x, y;
	private int width, height;
	public int[] pixels;
	private SpriteSheet sheet;
	
	
	// Creating new static instance of Sprite class for the grass
	public static Sprite grass = new Sprite(16, 3, 3, SpriteSheet.tiles);
	public static Sprite flower = new Sprite(16, 3, 11, SpriteSheet.tiles);
	public static Sprite rock = new Sprite(16, 3, 10, SpriteSheet.tiles);
	public static Sprite voidSprite = new Sprite(16, 0x8ed2c9);

	// Spawn level sprites

	public static Sprite spawn_wall = new Sprite(16, 0, 0, SpriteSheet.spawn_level);
	public static Sprite spawn_sand = new Sprite(16, 0, 1, SpriteSheet.spawn_level);
	public static Sprite spawn_grass = new Sprite(16, 0, 2, SpriteSheet.spawn_level);
	
    public static Sprite spawn_wall_d = new Sprite(16, 1, 0, SpriteSheet.spawn_level);
//	public static Sprite spawn_sand_d = new Sprite(16, 1, 1, SpriteSheet.spawn_level);
//	public static Sprite spawn_grass_d = new Sprite(16, 1, 2, SpriteSheet.spawn_level);

	
	// Player sprites

	
	public static Sprite player_f = new Sprite(32, 6, 0, SpriteSheet.tiles);
	public static Sprite player_w = new Sprite(32, 6, 1, SpriteSheet.tiles);
	public static Sprite player_e = new Sprite(32, 6, 2, SpriteSheet.tiles);
	public static Sprite player_b = new Sprite(32, 6, 3, SpriteSheet.tiles);

	public static Sprite player_f_1 = new Sprite(32, 5, 0, SpriteSheet.tiles);
	public static Sprite player_f_2 = new Sprite(32, 7, 0, SpriteSheet.tiles);

	public static Sprite player_w_1 = new Sprite(32, 5, 1, SpriteSheet.tiles);
	public static Sprite player_w_2 = new Sprite(32, 7, 1, SpriteSheet.tiles);

	public static Sprite player_e_1 = new Sprite(32, 5, 2, SpriteSheet.tiles);
	public static Sprite player_e_2 = new Sprite(32, 7, 2, SpriteSheet.tiles);
	
	public static Sprite player_b_1 = new Sprite(32, 5, 3, SpriteSheet.tiles);
	public static Sprite player_b_2 = new Sprite(32, 7, 3, SpriteSheet.tiles);
	
	// Projectile sprites
	
	public static Sprite projectile_wizard = new Sprite(16, 0, 0, SpriteSheet.projectile_wizard);
	
	// Particles
	
	public static Sprite particle_normal = new Sprite(3, 0xfddddd);


	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		this.width = size;
		this.height = size;
		pixels = new int [SIZE * SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
		
	}
	
	public Sprite(int width, int height, int colour) {
		SIZE = -1;
		this.width = width;
		this.height = height;
		pixels = new int [width * height];
		setColour(colour);
	}
	
	public Sprite(int size, int colour) {
		SIZE = size;
		this.width = size;
		this.height = size;
		pixels = new int [SIZE * SIZE];
		setColour(colour);

	}
	
	private void setColour(int colour) {
		for (int i = 0; i < width * height; i++) {
			pixels[i] = colour;	
		}
		
	}
	
	public int getWidth() {
		return width;
		
	}
	
	public int getHeight() {
		return height;
	}

	
	
	private void load()	{
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				
				pixels[x+y*SIZE] = sheet.pixels[(x + this.x) + (y+this.y) * sheet.SIZE ];
				
				
			}
		}
	}
	
}
