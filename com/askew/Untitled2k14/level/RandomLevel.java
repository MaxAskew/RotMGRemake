/*    */ package com.askew.Untitled2k14.level;
/*    */ 
/*    */ import java.util.Random;
/*    */ 
/*    */ public class RandomLevel extends Level
/*    */ {
/*  7 */   private static final Random random = new Random();
/*    */   
/*    */ 
/*    */   public RandomLevel(int width, int height)
/*    */   {
/* 12 */     super(width, height);
/*    */   }
/*    */   
/*    */ 
/*    */   protected void generateLevel()
/*    */   {
/* 18 */     for (int y = 0; y < this.height; y++)
/*    */     {
/* 20 */       for (int x = 0; x < this.width; x++)
/*    */       {
/*    */ 
/* 23 */         this.tilesInt[(x + y * this.width)] = random.nextInt(4);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\Downloads\Untitled2k14.jar!\com\askew\Untitled2k14\level\RandomLevel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */