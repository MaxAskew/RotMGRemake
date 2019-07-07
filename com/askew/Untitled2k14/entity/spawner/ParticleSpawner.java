/*    */ package com.askew.Untitled2k14.entity.spawner;
/*    */ 
/*    */ import com.askew.Untitled2k14.entity.particle.Particle;
/*    */ import com.askew.Untitled2k14.graphics.Sprite;
/*    */ import com.askew.Untitled2k14.level.Level;
/*    */ 
/*    */ public class ParticleSpawner extends Spawner
/*    */ {
/*    */   private int life;
/*    */   
/*    */   public ParticleSpawner(int x, int y, int life, int ammount, Level level, Sprite particleTypeSprite)
/*    */   {
/* 13 */     super(x, y, Spawner.Type.PARTICLE, ammount, level);
/* 14 */     this.life = life;
/*    */     
/* 16 */     for (int i = 0; i < ammount; i++)
/*    */     {
/*    */ 
/* 19 */       level.add(new Particle(x + 5, y + 20, life, particleTypeSprite));
/*    */     }
/*    */   }
/*    */   
/*    */   public void update() {}
/*    */ }


/* Location:              D:\Downloads\Untitled2k14.jar!\com\askew\Untitled2k14\entity\spawner\ParticleSpawner.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */