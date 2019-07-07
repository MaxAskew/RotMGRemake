/*    */ package com.askew.Untitled2k14.level.tile;
/*    */ 
/*    */ import com.askew.Untitled2k14.graphics.Screen;
/*    */ import com.askew.Untitled2k14.graphics.Sprite;
/*    */ 
/*    */ public class WaterTile
/*    */   extends Tile
/*    */ {
/*    */   public WaterTile(Sprite sprite)
/*    */   {
/* 11 */     super(sprite);
/*    */   }
/*    */   
/*    */   public void render(int x, int y, Screen screen)
/*    */   {
/* 16 */     screen.renderTile(x << 4, y << 4, this.sprite);
/*    */   }
/*    */   
/*    */   public boolean solid()
/*    */   {
/* 21 */     return false;
/*    */   }
/*    */   
/*    */   public boolean isWater() {
/* 25 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\Downloads\Untitled2k14.jar!\com\askew\Untitled2k14\level\tile\WaterTile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */