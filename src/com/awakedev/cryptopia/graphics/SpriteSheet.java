package com.awakedev.cryptopia.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

	
	// Contains path to spritesheet
	private String path; 
	public final int SIZE;
	public int[] pixels;
	
	
	// Constructor
	public SpriteSheet(String path, int size)	{
		this.path = path;
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		load();
	}
	
	// Load SpriteSheet
	private void load() {
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
