/*    */ package com.askew.Untitled2k14.level;
/*    */ 
/*    */ public class TileCoordinate {
/*    */   private int x;
/*    */   private int y;
/*  6 */   private final int TILE_SIZE = 16;
/*    */   
/*    */   public TileCoordinate(int x, int y)
/*    */   {
/* 10 */     this.x = (x * 16 - 8);
/* 11 */     this.y = (y * 16);
/*    */   }
/*    */   
/*    */ 
/*    */   public int x()
/*    */   {
/* 17 */     return this.x;
/*    */   }
/*    */   
/*    */   public int y() {
/* 21 */     return this.y;
/*    */   }
/*    */   
/*    */   public int[] xy()
/*    */   {
/* 26 */     int[] result = new int[2];
/* 27 */     result[0] = this.x;
/* 28 */     result[1] = this.y;
/* 29 */     return result;
/*    */   }
/*    */ }


/* Location:              D:\Downloads\Untitled2k14.jar!\com\askew\Untitled2k14\level\TileCoordinate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */