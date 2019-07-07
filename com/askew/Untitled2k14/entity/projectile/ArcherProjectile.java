/*    */ package com.askew.Untitled2k14.entity.projectile;
/*    */ 
/*    */ import com.askew.Untitled2k14.entity.spawner.ParticleSpawner;
/*    */ import com.askew.Untitled2k14.graphics.Screen;
/*    */ import com.askew.Untitled2k14.graphics.Sprite;
/*    */ import com.askew.Untitled2k14.level.Level;
/*    */ import java.util.Random;
/*    */ 
/*    */ public class ArcherProjectile
/*    */   extends Projectile
/*    */ {
/*    */   public static final int FIRE_RATE = 23;
/* 13 */   int ParticleLife = 50;
/* 14 */   int ParticleAmmount = 10;
/* 15 */   int damage = 50;
/* 16 */   int speed = 3;
/* 17 */   int range = this.random.nextInt(5) + 100;
/*    */   
/*    */   Sprite particleTypeSprite;
/*    */   
/*    */   public ArcherProjectile(int x, int y, double mouseDirection)
/*    */   {
/* 23 */     super(x, y, mouseDirection);
/* 24 */     this.sprite = Sprite.arrow_wooden;
/* 25 */     this.nx = (this.speed * Math.cos(this.angle));
/* 26 */     this.ny = (this.speed * Math.sin(this.angle));
/*    */   }
/*    */   
/*    */   public void update()
/*    */   {
/* 31 */     if (this.level.tileCollision((int)(this.x + this.nx), (int)(this.y + this.ny), 8, 4, 12))
/*    */     {
/* 33 */       this.particleTypeSprite = Sprite.particle_normal;
/*    */       
/* 35 */       this.level.add(new ParticleSpawner((int)this.x, (int)this.y, this.ParticleLife, this.ParticleAmmount, this.level, this.particleTypeSprite));
/* 36 */       remove();
/*    */     }
/*    */     
/* 39 */     if (this.level.tileWaterCollision((int)(this.x + this.nx), (int)(this.y + this.ny), 8, 4, 12))
/*    */     {
/*    */ 
/* 42 */       this.particleTypeSprite = Sprite.particle_water;
/* 43 */       this.level.add(new ParticleSpawner((int)this.x, (int)this.y, this.ParticleLife, this.ParticleAmmount, this.level, this.particleTypeSprite));
/*    */       
/* 45 */       remove();
/*    */     }
/* 47 */     move();
/*    */   }
/*    */   
/*    */   protected void move()
/*    */   {
/* 52 */     this.x += this.nx;
/* 53 */     this.y += this.ny;
/*    */     
/* 55 */     if (distance() > this.range) remove();
/*    */   }
/*    */   
/*    */   private double distance()
/*    */   {
/* 60 */     double distance = 0.0D;
/*    */     
/* 62 */     distance = Math.sqrt(Math.abs((this.xOrigin - this.x) * (this.xOrigin - this.x) + (this.yOrigin - this.y) * (this.yOrigin - this.y)));
/* 63 */     return distance;
/*    */   }
/*    */   
/*    */   public void render(Screen screen)
/*    */   {
/* 68 */     screen.renderProjectile((int)this.x - 6, (int)this.y, this);
/*    */   }
/*    */ }


/* Location:              D:\Downloads\Untitled2k14.jar!\com\askew\Untitled2k14\entity\projectile\ArcherProjectile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */