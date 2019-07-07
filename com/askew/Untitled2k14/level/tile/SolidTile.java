/*    */ package com.askew.Untitled2k14.level.tile;
/*    */ 
/*    */ import com.askew.Untitled2k14.graphics.Screen;
/*    */ import com.askew.Untitled2k14.graphics.Sprite;
/*    */ 
/*    */ public class SolidTile
/*    */   extends Tile
/*    */ {
/*    */   public SolidTile(Sprite sprite)
/*    */   {
/* 11 */     super(sprite);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void render(int x, int y, Screen screen)
/*    */   {
/* 19 */     screen.renderTile(x << 4, y << 4, this.sprite);
/*    */   }
/*    */   
/*    */   public boolean solid()
/*    */   {
/* 24 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\Downloads\Untitled2k14.jar!\com\askew\Untitled2k14\level\tile\SolidTile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */