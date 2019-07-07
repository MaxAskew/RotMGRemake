/*    */ package com.askew.Untitled2k14.entity.particle;
/*    */ 
/*    */ import com.askew.Untitled2k14.entity.Entity;
/*    */ import com.askew.Untitled2k14.graphics.Screen;
/*    */ import com.askew.Untitled2k14.graphics.Sprite;
/*    */ import com.askew.Untitled2k14.level.Level;
/*    */ import java.util.Random;
/*    */ 
/*    */ public class Particle extends Entity
/*    */ {
/*    */   private Sprite sprite;
/*    */   private int life;
/* 13 */   private int time = 0;
/*    */   protected double xa;
/*    */   protected double ya;
/*    */   protected double za;
/*    */   
/*    */   public Particle(int x, int y, int life, Sprite sprite)
/*    */   {
/* 20 */     this.x = x;
/* 21 */     this.y = y;
/*    */     
/* 23 */     this.xx = x;
/* 24 */     this.yy = y;
/*    */     
/* 26 */     this.life = (life + (this.random.nextInt(30) - 15));
/* 27 */     this.sprite = sprite;
/*    */     
/* 29 */     this.xa = this.random.nextGaussian();
/* 30 */     this.ya = this.random.nextGaussian();
/* 31 */     this.zz = (this.random.nextFloat() + 2.0D);
/*    */   }
/*    */   
/*    */   public void update()
/*    */   {
/* 36 */     this.time += 1;
/* 37 */     if (this.time >= 7399) { this.time = 0;
/*    */     }
/* 39 */     if (this.time > this.life) remove();
/* 40 */     this.za -= 0.1D;
/*    */     
/* 42 */     if (this.zz < 0.0D)
/*    */     {
/* 44 */       this.zz = 0.0D;
/* 45 */       this.za *= -0.5D;
/* 46 */       this.xa *= 0.3D;
/* 47 */       this.ya *= 0.3D;
/*    */     }
/* 49 */     move(this.xx + this.xa, this.yy + this.ya + (this.zz + this.za));
/*    */   }
/*    */   
/*    */   protected double xx;
/*    */   protected double yy;
/*    */   protected double zz;
/*    */   private void move(double x, double y) {
/* 56 */     if (collision(x, y))
/*    */     {
/* 58 */       this.xa *= 0.5D;
/* 59 */       this.ya *= 0.5D;
/* 60 */       this.za *= 0.5D;
/*    */     }
/* 62 */     this.xx += this.xa;
/* 63 */     this.yy += this.ya;
/* 64 */     this.zz += this.za;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean collision(double x, double y)
/*    */   {
/* 70 */     boolean solid = false;
/* 71 */     for (int c = 0; c < 4; c++)
/*    */     {
/*    */ 
/* 74 */       double xt = (x - c % 2 * 16) / 16.0D;
/* 75 */       double yt = (y - c / 2 * 16 - 16.0D) / 16.0D;
/* 76 */       int ix = (int)Math.ceil(xt);
/* 77 */       int iy = (int)Math.ceil(yt);
/*    */       
/* 79 */       if (c % 2 == 0) ix = (int)Math.floor(xt);
/* 80 */       if (c / 2 == 0) { iy = (int)Math.floor(yt);
/*    */       }
/* 82 */       if (this.level.getTile(ix, iy).solid()) { solid = true;
/*    */       }
/*    */     }
/*    */     
/* 86 */     return solid;
/*    */   }
/*    */   
/*    */   public void render(Screen screen)
/*    */   {
/* 91 */     screen.renderSprite((int)this.xx - 4, (int)this.yy - (int)this.zz - 12, this.sprite, true);
/*    */   }
/*    */ }


/* Location:              D:\Downloads\Untitled2k14.jar!\com\askew\Untitled2k14\entity\particle\Particle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */