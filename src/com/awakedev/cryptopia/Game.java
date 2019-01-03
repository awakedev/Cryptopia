package com.awakedev.cryptopia;

// Imports
 
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

// Game inherits Canvas (subclass of Canvas)

public class Game extends Canvas implements Runnable {
	
	// Creating window and defining resolutions & scale.
	
	public static int width = 300;
	public static int height = width / 16 * 9;
	public static int scale = 3;
	
	
	private Thread thread;
	private JFrame frame;
	private boolean running = false;
	
	
	// Game constructor 
	
	public Game () {
		Dimension size = new Dimension(width*scale, height*scale);
		setPreferredSize(size);
		
		frame = new JFrame();
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
		while (running = true) {
			
		}	
	} 
	
	// Main method (Entry point)
	
	public static void main (String[] args) {
		
		// Object of game with instance
		
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.setTitle("Cryptopia");
		
		// Adding game component to window
		game.frame.add(game);
		
		game.frame.pack();
		
		// End application when exit button clicked
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
	
	
}
