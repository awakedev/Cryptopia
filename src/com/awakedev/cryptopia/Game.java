package com.awakedev.cryptopia;

// Imports
 
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.awakedev.cryptopia.graphics.Screen;
import com.awakedev.cryptopia.input.Keyboard;

// Game inherits Canvas (subclass of Canvas)

public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 1L;
	public static  String title = "Cryptopia";
	// Creating window and defining resolutions & scale.
	
	public static int width = 300;
	public static int height = width / 16 * 9;
	public static int scale = 3;
	
	
	private Thread thread;
	private JFrame frame;
	private boolean running = false;
	private Keyboard key;
	
	private Screen screen;
	
	// Image with Buffer :: Final rendered view
	private BufferedImage image = new BufferedImage(width,height, BufferedImage.TYPE_INT_RGB);
	
	// Accessing image
	private int [] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	
	// Game constructor 
	public Game () {
		Dimension size = new Dimension(width*scale, height*scale);
		setPreferredSize(size);
		screen = new Screen(width,height);
		frame = new JFrame();
		key = new Keyboard();
		
		addKeyListener(key);
	}
	
	

	public synchronized void start() {
		running = true;
		
		thread = new Thread(this, "Display");
		thread.start();
	}
	

	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	// Game loop
	public void run() {
		
		// Ensuring time is precise
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		requestFocus();
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				update();
				updates++;
				delta--;
			}
			render();
			frames++;
			if (System.currentTimeMillis() - timer > 1000)	{
				timer += 1000;	
				System.out.println(updates + " ups, " + frames + " fps");
				frame.setTitle(title + "  |  " + updates + " ups, " + frames + " fps");
				updates = 0;
				frames = 0;
			}
		}	
		stop();
	} 
	
	int x = 0, y = 0;
	public void update() {
		key.update();
		if (key.up) y++;
		if (key.down) y--;
		if (key.right) x--;
		if (key.left) x++;
	
		
	}
	
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			
			// 3 Buffers for speed improvements
			createBufferStrategy(3);
			return;
		}
		
		screen.clear();
		screen.render(x,y);
		
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}
		
		Graphics g = bs.getDrawGraphics();
		{
			
			g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		}
		
		// Removing graphics by disposing
		g.dispose();
		
		bs.show();
	}
	
	
	// Main method (Entry point)
	
	public static void main (String[] args) {
		
		// Object of game with instance
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.setTitle(Game.title);
		
		// Adding game component to window
		game.frame.add(game);
		game.frame.pack();
		
		// End application when exit button clicked
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		game.start();
		
	}
	
	
	
	
	
	
	
}
