/*     */ package com.askew.Untitled2k14.graphics;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Sprite
/*     */ {
/*   7 */   private int x = 0; private int y = 0;
/*     */   
/*     */ 
/*     */ 
/*  11 */   public static Sprite voidSprite = new Sprite(16, 7, 7, SpriteSheet.tileSheet);
/*     */   
/*     */ 
/*  14 */   public static Sprite Grass = new Sprite(16, 0, 0, SpriteSheet.tileSheet);
/*  15 */   public static Sprite Flowers = new Sprite(16, 1, 0, SpriteSheet.tileSheet);
/*  16 */   public static Sprite Dirt = new Sprite(16, 2, 0, SpriteSheet.tileSheet);
/*  17 */   public static Sprite Sand = new Sprite(16, 3, 0, SpriteSheet.tileSheet);
/*  18 */   public static Sprite MossyBrick = new Sprite(16, 4, 0, SpriteSheet.tileSheet);
/*  19 */   public static Sprite StoneBrick = new Sprite(16, 5, 0, SpriteSheet.tileSheet);
/*  20 */   public static Sprite CompactDirt = new Sprite(16, 6, 0, SpriteSheet.tileSheet);
/*  21 */   public static Sprite StoneSlab = new Sprite(16, 7, 0, SpriteSheet.tileSheet);
/*     */   
/*     */ 
/*  24 */   public static Sprite water_dark = new Sprite(16, 0, 1, SpriteSheet.tileSheet);
/*  25 */   public static Sprite water_light = new Sprite(16, 1, 1, SpriteSheet.tileSheet);
/*  26 */   public static Sprite FancyStone = new Sprite(16, 2, 1, SpriteSheet.tileSheet);
/*  27 */   public static Sprite Wood = new Sprite(16, 3, 1, SpriteSheet.tileSheet);
/*  28 */   public static Sprite HardIce = new Sprite(16, 4, 1, SpriteSheet.tileSheet);
/*  29 */   public static Sprite Ice = new Sprite(16, 5, 1, SpriteSheet.tileSheet);
/*     */   
/*     */ 
/*  32 */   public static Sprite practiseTarget = new Sprite(32, 0, 0, SpriteSheet.staticCharSheet);
/*     */   
/*     */ 
/*  35 */   public static Sprite arrow_wooden = new Sprite(16, 0, 0, SpriteSheet.misc);
/*     */   
/*  37 */   public static Sprite particle_normal = new Sprite(3, 2434341);
/*  38 */   public static Sprite particle_water = new Sprite(3, 1452923);
/*     */   public int SIZE;
/*     */   private static int width;
/*     */   
/*     */   protected Sprite(SpriteSheet sheet, int width, int height) {
/*  43 */     this.SIZE = (width == height ? width : -1);
/*  44 */     width = width;
/*  45 */     height = height;
/*  46 */     this.sheet = sheet;
/*     */   }
/*     */   
/*     */   public Sprite(int size, int x, int y, SpriteSheet sheet)
/*     */   {
/*  51 */     this.SIZE = size;
/*  52 */     width = size;
/*  53 */     height = size;
/*  54 */     this.pixels = new int[this.SIZE * this.SIZE];
/*  55 */     this.x = (x * size);
/*  56 */     this.y = (y * size);
/*  57 */     this.sheet = sheet;
/*  58 */     load();
/*     */   }
/*     */   
/*     */   public Sprite(int width, int height, int colour)
/*     */   {
/*  63 */     this.SIZE = -1;
/*  64 */     width = width;
/*  65 */     height = height;
/*  66 */     this.pixels = new int[width * height];
/*  67 */     setColour(colour);
/*     */   }
/*     */   
/*     */   public Sprite(int size, int colour)
/*     */   {
/*  72 */     width = size;
/*  73 */     height = size;
/*  74 */     this.SIZE = size;
/*  75 */     this.pixels = new int[this.SIZE * this.SIZE];
/*  76 */     setColour(colour);
/*     */   }
/*     */   
/*     */   public Sprite(int[] pixels, int width, int height)
/*     */   {
/*  81 */     this.SIZE = (width == height ? width : -1);
/*  82 */     width = width;
/*  83 */     height = height;
/*  84 */     this.pixels = new int[pixels.length];
/*  85 */     for (int i = 0; i < pixels.length; i++)
/*     */     {
/*  87 */       this.pixels[i] = pixels[i];
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void setColour(int colour)
/*     */   {
/*  94 */     for (int i = 0; i < width * height; i++)
/*     */     {
/*  96 */       this.pixels[i] = colour;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void load()
/*     */   {
/* 103 */     for (int y = 0; y < height; y++)
/*     */     {
/* 105 */       for (int x = 0; x < width; x++)
/*     */       {
/* 107 */         this.pixels[(x + y * width)] = this.sheet.pixels[(this.x + x + (this.y + y) * this.sheet.SPRITE_WIDTH)];
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static Sprite[] split(SpriteSheet sheet)
/*     */   {
/* 114 */     int ammount = sheet.getWidth() * sheet.getHeight() / (sheet.SPRITE_WIDTH * sheet.SPRITE_HEIGHT);
/* 115 */     Sprite[] sprites = new Sprite[ammount];
/* 116 */     int current = 0;
/* 117 */     int[] pixels = new int[sheet.SPRITE_WIDTH * sheet.SPRITE_HEIGHT];
/*     */     
/* 119 */     for (int yp = 0; yp < sheet.getHeight() / sheet.SPRITE_HEIGHT; yp++)
/*     */     {
/* 121 */       for (int xp = 0; xp < sheet.getWidth() / sheet.SPRITE_WIDTH; xp++)
/*     */       {
/* 123 */         for (int y = 0; y < sheet.SPRITE_HEIGHT; y++)
/*     */         {
/* 125 */           for (int x = 0; x < sheet.SPRITE_WIDTH; x++)
/*     */           {
/* 127 */             int xo = x + xp * sheet.SPRITE_WIDTH;
/* 128 */             int yo = y + yp * sheet.SPRITE_HEIGHT;
/* 129 */             pixels[(x + y * sheet.SPRITE_WIDTH)] = sheet.getPixels()[(xo + yo * sheet.getWidth())];
/*     */           }
/*     */         }
/*     */         
/* 133 */         sprites[(current++)] = new Sprite(pixels, sheet.SPRITE_WIDTH, sheet.SPRITE_HEIGHT);
/*     */       }
/*     */     }
/*     */     
/* 137 */     return sprites;
/*     */   }
/*     */   
/*     */   private static int height;
/*     */   public int[] pixels;
/*     */   protected SpriteSheet sheet;
/*     */   public int getWidth() {
/* 144 */     return width;
/*     */   }
/*     */   
/*     */   public int getHeight()
/*     */   {
/* 149 */     return height;
/*     */   }
/*     */ }


/* Location:              D:\Downloads\Untitled2k14.jar!\com\askew\Untitled2k14\graphics\Sprite.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */