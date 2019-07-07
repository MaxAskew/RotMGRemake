/*     */ package com.askew.Untitled2k14.graphics;
/*     */ 
/*     */ import com.askew.Untitled2k14.entity.projectile.Projectile;
/*     */ import java.util.Random;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Screen
/*     */ {
/*     */   public int width;
/*     */   public int height;
/*     */   public int[] pixels;
/*  13 */   public final int MAP_SIZE = 64;
/*  14 */   public final int MAP_SIZE_MASK = 63;
/*     */   
/*     */   public int xOffset;
/*     */   public int yOffset;
/*  18 */   public int[] tiles = new int[MAP_SIZE * MAP_SIZE];
/*  19 */   private Random random = new Random();
/*     */   
/*     */   public Screen(int width, int height)
/*     */   {
/*  23 */     this.width = width;
/*  24 */     this.height = height;
/*  25 */     this.pixels = new int[width * height];
/*     */     
/*  27 */     for (int i = 0; i < 4096; i++)
/*     */     {
/*  29 */       this.tiles[i] = this.random.nextInt(16777215);
/*     */     }
/*     */   }
/*     */   
/*     */   public void clear()
/*     */   {
/*  35 */     for (int i = 0; i < this.pixels.length; i++)
/*     */     {
/*  37 */       this.pixels[i] = 0;
/*     */     }
/*     */   }
/*     */   
/*     */   public void setOffset(int xOffset, int yOffset)
/*     */   {
/*  43 */     this.xOffset = xOffset;
/*  44 */     this.yOffset = yOffset;
/*     */   }
/*     */   
/*     */   public void renderSheet(int xp, int yp, SpriteSheet sheet, boolean fixed)
/*     */   {
/*  49 */     if (fixed)
/*     */     {
/*  51 */       xp -= this.xOffset;
/*  52 */       yp -= this.yOffset;
/*     */     }
/*  54 */     for (int y = 0; y < sheet.SPRITE_WIDTH; y++)
/*     */     {
/*  56 */       int ya = y + yp;
/*  57 */       for (int x = 0; x < sheet.SPRITE_WIDTH; x++)
/*     */       {
/*  59 */         int xa = x + xp;
/*  60 */         if ((xa >= 0) && (xa < this.width) && (ya >= 0) && (ya < this.height)) {
/*  61 */           this.pixels[(xa + ya * this.width)] = sheet.pixels[(x + y * sheet.SPRITE_WIDTH)];
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void renderSprite(int xp, int yp, Sprite sprite, boolean fixed)
/*     */   {
/*  69 */     if (fixed)
/*     */     {
/*  71 */       xp -= this.xOffset;
/*  72 */       yp -= this.yOffset;
/*     */     }
/*  74 */     for (int y = 0; y < sprite.SIZE; y++)
/*     */     {
/*  76 */       int ya = y + yp;
/*  77 */       int ys = y;
/*     */       
/*  79 */       for (int x = 0; x < sprite.SIZE; x++)
/*     */       {
/*  81 */         int xa = x + xp;
/*  82 */         int xs = x;
/*     */         
/*  84 */         if ((xa < -sprite.SIZE) || (xa >= this.width) || (ya < 0) || (ya >= this.height)) {
/*     */           break;
/*     */         }
/*     */         
/*  88 */         if (xa >= 0)
/*     */         {
/*  90 */           int colour = sprite.pixels[(xs + ys * sprite.SIZE)];
/*  91 */           if (colour != -130567) { this.pixels[(xa + ya * this.width)] = colour;
/*     */           }
/*     */         }
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
/*     */   public void renderTile(int xp, int yp, Sprite sprite)
/*     */   {
/* 107 */     xp -= this.xOffset;
/* 108 */     yp -= this.yOffset;
/* 109 */     for (int y = 0; y < sprite.SIZE; y++)
/*     */     {
/* 111 */       int ya = y + yp;
/* 112 */       for (int x = 0; x < sprite.SIZE; x++)
/*     */       {
/* 114 */         int xa = x + xp;
/* 115 */         if ((xa < -sprite.SIZE) || (xa >= this.width) || (ya < 0) || (ya >= this.height)) break;
/* 116 */         if (xa < 0) xa = 0;
/* 117 */         this.pixels[(xa + ya * this.width)] = sprite.pixels[(x + y * sprite.SIZE)];
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void renderProjectile(int xp, int yp, Projectile p)
/*     */   {
/* 126 */     xp -= this.xOffset;
/* 127 */     yp -= this.yOffset;
/* 128 */     for (int y = 0; y < p.getSpriteSize(); y++)
/*     */     {
/* 130 */       int ya = y + yp;
/* 131 */       for (int x = 0; x < p.getSpriteSize(); x++)
/*     */       {
/* 133 */         int xa = x + xp;
/* 134 */         if ((xa < -p.getSpriteSize()) || (xa >= this.width) || (ya < 0) || (ya >= this.height)) break;
/* 135 */         if (xa < 0) xa = 0;
/* 136 */         int colour = p.getSprite().pixels[(x + y * p.getSpriteSize())];
/* 137 */         if (colour != -130567) { this.pixels[(xa + ya * this.width)] = colour;
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void renderMob(int xp, int yp, Sprite sprite)
/*     */   {
/* 146 */     xp -= this.xOffset;
/* 147 */     yp -= this.yOffset;
/* 148 */     for (int y = 0; y < 32; y++)
/*     */     {
/* 150 */       int ya = y + yp;
/* 151 */       for (int x = 0; x < 32; x++)
/*     */       {
/* 153 */         int xa = x + xp;
/* 154 */         if ((xa < -32) || (xa >= this.width) || (ya < 0) || (ya >= this.height)) break;
/* 155 */         if (xa < 0) xa = 0;
/* 156 */         int colour = sprite.pixels[(x + y * 32)];
/*     */         
/*     */ 
/* 159 */         if (colour != -130567) this.pixels[(xa + ya * this.width)] = colour;
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Downloads\Untitled2k14.jar!\com\askew\Untitled2k14\graphics\Screen.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */