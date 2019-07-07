/*    */ package com.askew.Untitled2k14.entity.mob;
/*    */ 
/*    */ import com.askew.Untitled2k14.entity.Entity;
/*    */ import com.askew.Untitled2k14.entity.projectile.ArcherProjectile;
/*    */ import com.askew.Untitled2k14.entity.projectile.Projectile;
/*    */ import com.askew.Untitled2k14.graphics.Screen;
/*    */ import com.askew.Untitled2k14.graphics.Sprite;
/*    */ import com.askew.Untitled2k14.level.Level;
/*    */ import com.askew.Untitled2k14.level.tile.Tile;
/*    */ 
/*    */ 
/*    */ public abstract class Mob
/*    */   extends Entity
/*    */ {
/*    */   protected Sprite sprite;
/* 16 */   protected int dir = 0;
/* 17 */   protected boolean moving = false;
/*    */   public boolean Colliding;
/*    */   public boolean swimming;
/*    */   double mDirection;
/*    */   
/*    */   public void move(int xa, int ya)
/*    */   {
/* 24 */     if ((xa != 0) && (ya != 0))
/*    */     {
/* 26 */       move(xa, 0);
/* 27 */       move(0, ya);
/*    */     }
/* 29 */     if (xa > 0) this.dir = 1;
/* 30 */     if (xa < 0) this.dir = 2;
/* 31 */     if (ya > 0) this.dir = 3;
/* 32 */     if (ya < 0) { this.dir = 0;
/*    */     }
/*    */     
/* 35 */     if (!collision(xa, ya))
/*    */     {
/* 37 */       this.x += xa;
/* 38 */       this.y += ya;
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void shoot(int x, int y, double mouseDirection)
/*    */   {
/* 46 */     Projectile p = new ArcherProjectile(x, y, mouseDirection);
/* 47 */     this.level.add(p);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   private boolean collision(int xa, int ya)
/*    */   {
/* 55 */     boolean solid = false;
/* 56 */     for (int c = 0; c < 4; c++)
/*    */     {
/*    */ 
/*    */ 
/* 60 */       int xt = (this.x + xa + c % 2 * 10 - 6) / 16;
/* 61 */       int yt = (this.y + ya + c / 2 * 10 + 5) / 16;
/* 62 */       if (this.level.getTile(xt, yt).solid())
/*    */       {
/* 64 */         solid = true;
/* 65 */         this.Colliding = true;
/*    */       }
/* 67 */       if (this.level.getTile(xt, yt).isWater())
/*    */       {
/* 69 */         solid = true;
/* 70 */         this.Colliding = true;
/*    */       }
/*    */     }
/*    */     
/* 74 */     return solid;
/*    */   }
/*    */   
/*    */   public abstract void update();
/*    */   
/*    */   public abstract void render(Screen paramScreen);
/*    */ }


/* Location:              D:\Downloads\Untitled2k14.jar!\com\askew\Untitled2k14\entity\mob\Mob.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */