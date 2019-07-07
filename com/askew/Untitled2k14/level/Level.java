/*     */ package com.askew.Untitled2k14.level;
/*     */ 
/*     */ import com.askew.Untitled2k14.entity.Entity;
/*     */ import com.askew.Untitled2k14.entity.mob.Player;
/*     */ import com.askew.Untitled2k14.entity.particle.Particle;
/*     */ import com.askew.Untitled2k14.entity.projectile.Projectile;
/*     */ import com.askew.Untitled2k14.graphics.Screen;
/*     */ import com.askew.Untitled2k14.level.tile.Tile;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ public class Level
/*     */ {
/*     */   protected int width;
/*     */   protected int height;
/*     */   protected int[] tilesInt;
/*     */   protected int[] tiles;
/*  18 */   public boolean swimming = false;
/*  19 */   private List<Entity> entities = new ArrayList();
/*  20 */   private List<Projectile> projectiles = new ArrayList();
/*  21 */   private List<Particle> particles = new ArrayList();
/*  22 */   public static Level CoreLevel = new CoreLevel("/levels/CoreLevel.png");
/*  23 */   public static Level UmairLevel = new CoreLevel("/levels/UmairLevel.png");
/*     */   private Player player;
/*     */   
/*     */   public Level(int width, int height)
/*     */   {
/*  28 */     this.width = width;
/*  29 */     this.height = height;
/*  30 */     this.tilesInt = new int[width * height];
/*  31 */     generateLevel();
/*     */   }
/*     */   
/*     */ 
/*     */   public Level(String path)
/*     */   {
/*  37 */     loadLevel(path);
/*  38 */     generateLevel();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Projectile> getProjectiles()
/*     */   {
/*  45 */     return this.projectiles;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void generateLevel() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void loadLevel(String path) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void update()
/*     */   {
/*  62 */     for (int i = 0; i < this.entities.size(); i++)
/*     */     {
/*     */ 
/*  65 */       if (((Entity)this.entities.get(i)).isRemoved()) { this.entities.remove(i);
/*     */       }
/*     */       else {
/*  68 */         ((Entity)this.entities.get(i)).update();
/*     */       }
/*     */     }
/*  71 */     for (int i = 0; i < this.projectiles.size(); i++)
/*     */     {
/*  73 */       if (((Projectile)this.projectiles.get(i)).isRemoved()) { this.projectiles.remove(i);
/*     */       } else
/*  75 */         ((Projectile)this.projectiles.get(i)).update();
/*     */     }
/*  77 */     for (int i = 0; i < this.particles.size(); i++)
/*     */     {
/*  79 */       if (((Particle)this.particles.get(i)).isRemoved()) { this.particles.remove(i);
/*     */       } else {
/*  81 */         ((Particle)this.particles.get(i)).update();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void time() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean tileCollision(int x, int y, int size, int xOffset, int yOffset)
/*     */   {
/*  94 */     boolean collidable = false;
/*  95 */     for (int c = 0; c < 4; c++)
/*     */     {
/*     */ 
/*  98 */       int xt = x - c % 2 * size + xOffset >> 4;
/*  99 */       int yt = y - c / 2 * size + yOffset >> 4;
/*     */       
/* 101 */       if (getTile(xt, yt).solid())
/*     */       {
/* 103 */         collidable = true;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 108 */     return collidable;
/*     */   }
/*     */   
/*     */   public boolean tileWaterCollision(int x, int y, int size, int xOffset, int yOffset) {
/* 112 */     boolean collidable = false;
/* 113 */     for (int c = 0; c < 4; c++)
/*     */     {
/*     */ 
/* 116 */       int xt = x - c % 2 * size + xOffset >> 4;
/* 117 */       int yt = y - c / 2 * size + yOffset >> 4;
/*     */       
/* 119 */       if (getTile(xt, yt).isWater())
/*     */       {
/* 121 */         collidable = true;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 126 */     return collidable;
/*     */   }
/*     */   
/*     */   public void render(int xScroll, int yScroll, Screen screen)
/*     */   {
/* 131 */     screen.setOffset(xScroll, yScroll);
/*     */     
/* 133 */     int x0 = xScroll >> 4;
/* 134 */     int x1 = xScroll + screen.width + 16 >> 4;
/* 135 */     int y0 = yScroll >> 4;
/* 136 */     int y1 = yScroll + screen.height + 16 >> 4;
/*     */     
/* 138 */     for (int y = y0; y < y1; y++)
/*     */     {
/* 140 */       for (int x = x0; x < x1; x++)
/*     */       {
/* 142 */         getTile(x, y).render(x, y, screen);
/*     */       }
/*     */     }
/*     */     
/* 146 */     for (int i = 0; i < this.entities.size(); i++)
/*     */     {
/* 148 */       ((Entity)this.entities.get(i)).render(screen);
/*     */     }
/* 150 */     for (int i = 0; i < this.projectiles.size(); i++)
/*     */     {
/* 152 */       ((Projectile)this.projectiles.get(i)).render(screen);
/*     */     }
/* 154 */     for (int i = 0; i < this.particles.size(); i++)
/*     */     {
/*     */ 
/* 157 */       ((Particle)this.particles.get(i)).render(screen);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void add(Entity e)
/*     */   {
/* 164 */     e.init(this);
/* 165 */     if ((e instanceof Particle))
/*     */     {
/* 167 */       this.particles.add((Particle)e);
/*     */ 
/*     */     }
/* 170 */     else if ((e instanceof Projectile))
/*     */     {
/* 172 */       e.init(this);
/* 173 */       this.projectiles.add((Projectile)e);
/*     */     }
/*     */     else
/*     */     {
/* 177 */       this.entities.add(e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Tile getTile(int x, int y)
/*     */   {
/* 185 */     if ((x < 0) || (x >= this.width) || (y < 0) || (y >= this.height)) { return Tile.voidTile;
/*     */     }
/* 187 */     if (this.tiles[(x + y * this.width)] == -14640349) return Tile.GrassTile;
/* 188 */     if (this.tiles[(x + y * this.width)] == -3348181) return Tile.FlowersTile;
/* 189 */     if (this.tiles[(x + y * this.width)] == -9878762) return Tile.DirtTile;
/* 190 */     if (this.tiles[(x + y * this.width)] == -196864) return Tile.SandTile;
/* 191 */     if (this.tiles[(x + y * this.width)] == -15387382) return Tile.MossyBrickTile;
/* 192 */     if (this.tiles[(x + y * this.width)] == -14540254) return Tile.StoneBrickTile;
/* 193 */     if (this.tiles[(x + y * this.width)] == -15003386) return Tile.CompactDirtTile;
/* 194 */     if (this.tiles[(x + y * this.width)] == -3487030) { return Tile.StoneSlabTile;
/*     */     }
/* 196 */     if (this.tiles[(x + y * this.width)] == -13600607) return Tile.DarkWaterTile;
/* 197 */     if (this.tiles[(x + y * this.width)] == -11163947) return Tile.LightWaterTile;
/* 198 */     if (this.tiles[(x + y * this.width)] == -11905701) return Tile.FancyStoneTile;
/* 199 */     if (this.tiles[(x + y * this.width)] == -11784177) return Tile.WoodPlanksTile;
/* 200 */     if (this.tiles[(x + y * this.width)] == -15911511) return Tile.HardIceTile;
/* 201 */     if (this.tiles[(x + y * this.width)] == -13150544) { return Tile.IceTile;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 206 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\Downloads\Untitled2k14.jar!\com\askew\Untitled2k14\level\Level.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */