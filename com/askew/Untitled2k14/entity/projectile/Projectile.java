/*    */ package com.askew.Untitled2k14.entity.projectile;
/*    */ 
/*    */ import com.askew.Untitled2k14.graphics.Sprite;
/*    */ 
/*    */ public abstract class Projectile extends com.askew.Untitled2k14.entity.Entity { protected double x;
/*    */   protected double y;
/*    */   protected final int xOrigin;
/*    */   protected final int yOrigin;
/*    */   protected double angle;
/*    */   protected Sprite sprite;
/*    */   protected double nx;
/*    */   protected double ny;
/*    */   protected double speed;
/*    */   protected double range;
/*    */   protected double damage;
/*    */   protected double distance;
/* 17 */   protected final java.util.Random random = new java.util.Random();
/*    */   
/*    */   public Projectile(int x, int y, double mouseDirection)
/*    */   {
/* 21 */     this.xOrigin = x;
/* 22 */     this.yOrigin = y;
/* 23 */     this.angle = mouseDirection;
/* 24 */     this.x = x;
/* 25 */     this.y = y;
/*    */   }
/*    */   
/*    */   public Sprite getSprite()
/*    */   {
/* 30 */     return this.sprite;
/*    */   }
/*    */   
/*    */   public int getSpriteSize() {
/* 34 */     return this.sprite.SIZE;
/*    */   }
/*    */   
/*    */   protected void move() {}
/*    */ }


/* Location:              D:\Downloads\Untitled2k14.jar!\com\askew\Untitled2k14\entity\projectile\Projectile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */