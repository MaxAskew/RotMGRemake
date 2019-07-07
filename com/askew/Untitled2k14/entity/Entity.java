/*    */ package com.askew.Untitled2k14.entity;
/*    */ 
/*    */ import com.askew.Untitled2k14.graphics.Screen;
/*    */ import com.askew.Untitled2k14.level.Level;
/*    */ import java.util.Random;
/*    */ 
/*    */ 
/*    */ public class Entity
/*    */ {
/* 10 */   public int x = 0; public int y = 0;
/* 11 */   private boolean removed = false;
/*    */   
/* 13 */   protected final Random random = new Random();
/*    */   
/*    */   protected Level level;
/*    */   
/*    */ 
/*    */   public void update() {}
/*    */   
/*    */ 
/*    */   public void render(Screen screen) {}
/*    */   
/*    */ 
/*    */   public void remove()
/*    */   {
/* 26 */     this.removed = true;
/*    */   }
/*    */   
/*    */   public boolean isRemoved()
/*    */   {
/* 31 */     return this.removed;
/*    */   }
/*    */   
/*    */   public void init(Level level)
/*    */   {
/* 36 */     this.level = level;
/*    */   }
/*    */ }


/* Location:              D:\Downloads\Untitled2k14.jar!\com\askew\Untitled2k14\entity\Entity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */