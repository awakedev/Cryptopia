package com.awakedev.cryptopia.level;

import java.util.ArrayList;
import java.util.List;

import com.awakedev.cryptopia.entity.Entity;
import com.awakedev.cryptopia.entity.particle.Particle;
import com.awakedev.cryptopia.entity.projectile.Projectile;
import com.awakedev.cryptopia.graphics.Screen;
import com.awakedev.cryptopia.level.tile.Tile;

public class Level {
	

	protected int width, height;
	protected int[] tilesInt;
	protected int [] tiles;
	protected int tile_size;
	
	private List<Entity> entities = new ArrayList<Entity>();
	private List<Projectile> projectiles = new ArrayList<Projectile>();
	private List<Particle> particles = new ArrayList<Particle>();

	public static Level spawn = new SpawnLevel ("/levels/spawn.png");
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tilesInt = new int[width * height];
		generateLevel();
	
	}
	
	public Level(String path) {
		loadLevel(path);
		generateLevel();			
	}
	
	protected void generateLevel() {
		for (int y = 0; y < 64; y++) {
			for (int x = 0; x < 64; x++) {
				getTile(x,y);
			}
		}
	}

	protected void loadLevel(String path) {
	
		
	}
	

	public void update() {
		for(int i = 0; i < entities.size(); i++) {
			entities.get(i).update();
			
		}
		for(int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
		}
		for(int i = 0; i < particles.size(); i++) {
			particles.get(i).update();

		}
		remove();
	}
	
	
	public void remove() {
		for(int i = 0; i < entities.size(); i++) {
			if (entities.get(i).isRemoved()) entities.remove(i);
		}
		for(int i = 0; i < projectiles.size(); i++) {
			if (projectiles.get(i).isRemoved()) projectiles.remove(i);


		}
		for(int i = 0; i < particles.size(); i++) {
			if (particles.get(i).isRemoved()) particles.remove(i);

		}
	}
	
	public List<Projectile> getProjectiles(){
		return projectiles;
	}
	
	private void time() {
	
	}
	  

	public boolean tileCollision(int x, int y, int size, int xOffset, int yOffset) {
		boolean solid = false;
		// Corner collision
		for (int c = 0; c < 4; c++) {
			int xt = (x - c % 2 * size + xOffset) >> 4;
			int yt = (y - c / 2 * size + yOffset) >> 4;
			if (getTile(xt, yt).solid()) solid = true;
		}
		return solid;	
	}
	
	
	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;
		
		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);
				
				}
			}
			for(int i = 0; i < entities.size(); i++) {
			entities.get(i).render(screen);
		}
			for(int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).render(screen);

		}
			for(int i = 0; i < particles.size(); i++) {
			particles.get(i).render(screen);


			}
	}
	
	public void add(Entity e) {
		e.init(this);
		
		if (e instanceof Particle) {
			particles.add((Particle) e);
		} else if (e instanceof Projectile) {
			projectiles.add((Projectile) e);
		} else { 		
			entities.add(e);	
		} 	
	}

	
	public void addProjectile(Projectile p) {
		p.init(this);
	}
	
	
	public Tile getTile(int x, int y) {

		if (x < 0 || y < 0 || x >= width || y >= height)  return Tile.voidTile;
		if (tiles[x+y*width] == Tile.col_spawn_grass) return Tile.spawn_grass;
		if (tiles[x+y*width] == Tile.col_spawn_sand) return Tile.spawn_sand;
		if (tiles[x+y*width] == Tile.col_spawn_wall) return Tile.spawn_wall;
		if (tiles[x+y*width] == Tile.col_spawn_wall_d) return Tile.spawn_wall_d;

		return Tile.voidTile;
	}

	
	
}



