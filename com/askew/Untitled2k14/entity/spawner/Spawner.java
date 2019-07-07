/*    */ package com.askew.Untitled2k14.entity.spawner;
/*    */ 
/*    */ import com.askew.Untitled2k14.level.Level;
/*    */ 
/*    */ public abstract class Spawner extends com.askew.Untitled2k14.entity.Entity
/*    */ {
/*    */   private Type type;
/*    */   
/*    */   public static enum Type {
/* 10 */     MOB,  PARTICLE;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public Spawner(int x, int y, Type type, int ammount, Level level)
/*    */   {
/* 17 */     this.x = x;
/* 18 */     this.y = y;
/* 19 */     this.type = type;
/*    */   }
/*    */ }


/* Location:              D:\Downloads\Untitled2k14.jar!\com\askew\Untitled2k14\entity\spawner\Spawner.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */