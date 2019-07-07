/*     */ package com.askew.Untitled2k14.entity.mob;
/*     */ 
/*     */ import com.askew.Untitled2k14.Game;
/*     */ import com.askew.Untitled2k14.entity.projectile.Projectile;
/*     */ import com.askew.Untitled2k14.graphics.AnimatedSprite;
/*     */ import com.askew.Untitled2k14.graphics.Font;
/*     */ import com.askew.Untitled2k14.graphics.Screen;
/*     */ import com.askew.Untitled2k14.graphics.Sprite;
/*     */ import com.askew.Untitled2k14.graphics.SpriteSheet;
/*     */ import com.askew.Untitled2k14.input.Keyboard;
/*     */ import com.askew.Untitled2k14.input.Mouse;
/*     */ import com.askew.Untitled2k14.level.Level;
/*     */ import java.util.List;
/*     */ 
/*     */ public class Player extends Mob
/*     */ {
/*     */   private Keyboard input;
/*     */   private Sprite sprite;
/*  19 */   private int anim = 0;
/*  20 */   private boolean walking = false;
/*  21 */   public int firerate = 0;
/*     */   public String username;
/*  23 */   private int fireRate = 0;
/*     */   
/*     */   private Font font;
/*  26 */   private AnimatedSprite down = new AnimatedSprite(SpriteSheet.defaultDown, 32, 32, 3);
/*  27 */   private AnimatedSprite up = new AnimatedSprite(SpriteSheet.defaultUp, 32, 32, 3);
/*  28 */   private AnimatedSprite left = new AnimatedSprite(SpriteSheet.defaultLeft, 32, 32, 3);
/*  29 */   private AnimatedSprite right = new AnimatedSprite(SpriteSheet.defaultRight, 32, 32, 3);
/*  30 */   private AnimatedSprite animSprite = this.down;
/*     */   
/*     */   public Player(Keyboard input)
/*     */   {
/*  34 */     this.input = input;
/*     */   }
/*     */   
/*     */   public Player(int x, int y, Keyboard input, String username)
/*     */   {
/*  39 */     this.font = new Font();
/*  40 */     this.x = x;
/*  41 */     this.y = y;
/*  42 */     this.input = input;
/*  43 */     this.username = username;
/*  44 */     this.sprite = this.down;
/*  45 */     this.animSprite = this.down;
/*  46 */     this.firerate = 23;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void update()
/*     */   {
/*  53 */     if (this.walking) this.animSprite.update(); else
/*  54 */       this.animSprite.SetFrame(0);
/*  55 */     if (this.firerate > 0) this.firerate -= 1;
/*  56 */     int xa = 0;int ya = 0;
/*  57 */     if (this.anim < 7500) { this.anim += 1;
/*     */     } else {
/*  59 */       this.anim = 0;
/*     */     }
/*  61 */     if (this.input.up)
/*     */     {
/*  63 */       this.animSprite = this.up;
/*  64 */       ya--;
/*     */ 
/*     */     }
/*  67 */     else if (this.input.down)
/*     */     {
/*  69 */       this.animSprite = this.down;
/*  70 */       ya++;
/*     */     }
/*     */     
/*  73 */     if (this.input.left)
/*     */     {
/*  75 */       this.animSprite = this.left;
/*  76 */       xa--;
/*     */ 
/*     */     }
/*  79 */     else if (this.input.right)
/*     */     {
/*  81 */       this.animSprite = this.right;
/*  82 */       xa++;
/*     */     }
/*     */     
/*  85 */     if ((xa != 0) || (ya != 0))
/*     */     {
				
/*  87 */       move(xa, ya);
/*  88 */       this.moving = true;
/*     */     }
/*     */     else {
/*  92 */       this.moving = false;
/*     */     }
/*     */     
/*  96 */     clear();
/*  97 */     updateShooting();
/*     */   }
/*     */   
/*     */ 
/*     */   private void clear()
/*     */   {
/* 103 */     for (int i = 0; i < this.level.getProjectiles().size(); i++)
/*     */     {
/* 105 */       Projectile p = (Projectile)this.level.getProjectiles().get(i);
/* 106 */       if (p.isRemoved()) this.level.getProjectiles().remove(i);
/*     */     }
/*     */   }
/*     */   
/*     */   private void updateShooting()
/*     */   {
/* 112 */     if ((Mouse.getButton() == 1) && (this.firerate <= 0))
/*     */     {
/* 114 */       double dx = Mouse.getX() - Game.getWindowWidth() / 2;
/* 115 */       double dy = Mouse.getY() - 20 - Game.getWindowHeight() / 2;
/* 116 */       double mouseDirection = Math.atan2(dy, dx);
/* 117 */       shoot(this.x, this.y, mouseDirection);
/* 118 */       this.firerate = 23;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void render(Screen screen)
/*     */   {
/* 125 */     this.sprite = this.animSprite.getSprite();
/* 126 */     screen.renderMob(this.x - 16, this.y - 16, this.sprite);
/*     */   }
/*     */ }


/* Location:              D:\Downloads\Untitled2k14.jar!\com\askew\Untitled2k14\entity\mob\Player.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */