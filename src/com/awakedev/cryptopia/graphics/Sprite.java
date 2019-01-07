package com.awakedev.cryptopia.graphics;

public class Sprite {

	public final int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;
	
	
	// Creating new static instance of Sprite class for the grass
	public static Sprite grass = new Sprite(16, 3, 6, SpriteSheet.tiles);
	public static Sprite voidSprite = new Sprite(16, 0xffffff);
	

	
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

	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		pixels = new int [SIZE * SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
		
	}
	
	public Sprite(int size, int colour) {
		SIZE = size;
		pixels = new int [SIZE * SIZE];
		setColour(colour);
		
	}
	
	private void setColour(int colour) {
		for (int i = 0; i < SIZE*SIZE; i++) {
			pixels[i] = colour;	
		}
		
	}

	
	private void load()	{
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				
				pixels[x+y*SIZE] = sheet.pixels[(x + this.x) + (y+this.y) * sheet.SIZE ];
				
				
			}
		}
	}
	
}
