/*     */ package com.askew.Untitled2k14.graphics;
/*     */ 
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import javax.imageio.ImageIO;
/*     */ 
/*     */ public class SpriteSheet
/*     */ {
/*     */   private String path;
/*     */   public final int SIZE;
/*     */   public int[] pixels;
/*     */   public final int SPRITE_WIDTH;
/*     */   public final int SPRITE_HEIGHT;
/*     */   private int width;
/*     */   private int height;
/*     */   private Sprite[] sprites;
/*  18 */   public static SpriteSheet tileSheet = new SpriteSheet("/textures/tileSheet.png", 128);
/*     */   
/*  20 */   public static SpriteSheet misc = new SpriteSheet("/textures/miscSheet.png", 64);
/*     */   
/*     */ 
/*     */ 
/*  24 */   public static SpriteSheet staticCharSheet = new SpriteSheet("/textures/staticCharSheet.png", 128, 96);
/*     */   
/*  26 */   public static SpriteSheet defaultPlayerSheet = new SpriteSheet("/textures/playerSheet.png", 128, 96);
/*  27 */   public static SpriteSheet defaultUp = new SpriteSheet(defaultPlayerSheet, 0, 0, 1, 3, 32);
/*  28 */   public static SpriteSheet defaultLeft = new SpriteSheet(defaultPlayerSheet, 1, 0, 1, 3, 32);
/*  29 */   public static SpriteSheet defaultDown = new SpriteSheet(defaultPlayerSheet, 2, 0, 1, 3, 32);
/*  30 */   public static SpriteSheet defaultRight = new SpriteSheet(defaultPlayerSheet, 3, 0, 1, 3, 32);
/*     */   
/*     */   public SpriteSheet(SpriteSheet sheet, int x, int y, int width, int height, int spriteSize)
/*     */   {
/*  34 */     int xx = x * spriteSize;
/*  35 */     int yy = y * spriteSize;
/*  36 */     int w = width * spriteSize;
/*  37 */     int h = height * spriteSize;
/*  38 */     if (width == height) this.SIZE = width; else
/*  39 */       this.SIZE = -1;
/*  40 */     this.SPRITE_WIDTH = w;
/*  41 */     this.SPRITE_HEIGHT = h;
/*  42 */     this.pixels = new int[w * h];
/*     */     
/*     */ 
/*     */ 
/*  46 */     for (int yi = 0; yi < h; yi++) {
/*  47 */       int yp = yy + yi;
/*  48 */       for (int xi = 0; xi < w; xi++) {
/*  49 */         int xp = xx + xi;
/*  50 */         this.pixels[(xi + yi * w)] = sheet.pixels[(xp + yp * sheet.SPRITE_WIDTH)];
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  55 */     int frame = 0;
/*  56 */     this.sprites = new Sprite[height * width];
/*  57 */     for (int ya = 0; ya < height; ya++) {
/*  58 */       for (int xa = 0; xa < width; xa++) {
/*  59 */         int[] spritePixels = new int[spriteSize * spriteSize];
/*     */         
/*     */ 
/*  62 */         for (int yi = 0; yi < spriteSize; yi++) {
/*  63 */           for (int xi = 0; xi < spriteSize; xi++) {
/*  64 */             spritePixels[(xi + yi * spriteSize)] = this.pixels[(xi + xa * spriteSize + (yi + ya * spriteSize) * this.SPRITE_WIDTH)];
/*     */           }
/*     */         }
/*  67 */         Sprite sprite = new Sprite(spritePixels, spriteSize, spriteSize);
/*  68 */         this.sprites[(frame++)] = sprite;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SpriteSheet(String path, int size)
/*     */   {
/* 120 */     this.path = path;
/* 121 */     this.SIZE = size;
/* 122 */     this.SPRITE_WIDTH = size;
/* 123 */     this.SPRITE_HEIGHT = size;
/* 124 */     this.pixels = new int[this.SIZE * this.SIZE];
/* 125 */     load();
/*     */   }
/*     */   
/*     */   public SpriteSheet(String path, int width, int height) {
/* 129 */     this.path = path;
/* 130 */     this.SPRITE_WIDTH = width;
/* 131 */     this.SPRITE_HEIGHT = height;
/* 132 */     this.pixels = new int[this.SPRITE_WIDTH * this.SPRITE_HEIGHT];
/* 133 */     this.SIZE = -1;
/* 134 */     load();
/*     */   }
/*     */   
/*     */ 
/*     */   public Sprite[] getSprite()
/*     */   {
/* 140 */     return this.sprites;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getWidth()
/*     */   {
/* 146 */     return this.width;
/*     */   }
/*     */   
/*     */   public int getHeight()
/*     */   {
/* 151 */     return this.height;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/* 156 */   public int[] getPixels() { return this.pixels; }
/*     */   
/*     */   private void load() {
/*     */     try {
/* 160 */       System.out.println("Loading file : " + this.path + "...");
/* 161 */       BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(this.path));
/* 162 */       System.out.println(" Succeeded Loading!");
/* 163 */       this.width = image.getWidth();
/* 164 */       this.height = image.getHeight();
/* 165 */       this.pixels = new int[this.width * this.height];
/* 166 */       image.getRGB(0, 0, this.width, this.height, this.pixels, 0, this.width);
/*     */     }
/*     */     catch (IOException e) {
/* 169 */       e.printStackTrace();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 173 */       System.err.println(" Failed Loading!");
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Downloads\Untitled2k14.jar!\com\askew\Untitled2k14\graphics\SpriteSheet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */