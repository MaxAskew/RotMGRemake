/*    */ package com.askew.Untitled2k14.level.tile;
/*    */ 
/*    */ import com.askew.Untitled2k14.graphics.Screen;
/*    */ import com.askew.Untitled2k14.graphics.Sprite;
/*    */ 
/*    */ 
/*    */ public class Tile
/*    */ {
/*    */   public int x;
/*    */   public int y;
/*    */   public Sprite sprite;
/* 12 */   public static Tile voidTile = new VoidTile(Sprite.voidSprite);
/*    */   
/*    */ 
/* 15 */   public static Tile GrassTile = new NonSolidTile(Sprite.Grass);
/* 16 */   public static Tile FlowersTile = new NonSolidTile(Sprite.Flowers);
/* 17 */   public static Tile DirtTile = new NonSolidTile(Sprite.Dirt);
/* 18 */   public static Tile SandTile = new NonSolidTile(Sprite.Sand);
/* 19 */   public static Tile MossyBrickTile = new SolidTile(Sprite.MossyBrick);
/* 20 */   public static Tile StoneBrickTile = new SolidTile(Sprite.StoneBrick);
/* 21 */   public static Tile CompactDirtTile = new NonSolidTile(Sprite.CompactDirt);
/* 22 */   public static Tile StoneSlabTile = new NonSolidTile(Sprite.StoneSlab);
/*    */   
/* 24 */   public static Tile DarkWaterTile = new WaterTile(Sprite.water_dark);
/* 25 */   public static Tile LightWaterTile = new NonSolidTile(Sprite.water_light);
/* 26 */   public static Tile FancyStoneTile = new NonSolidTile(Sprite.FancyStone);
/* 27 */   public static Tile WoodPlanksTile = new NonSolidTile(Sprite.Wood);
/* 28 */   public static Tile HardIceTile = new SolidTile(Sprite.HardIce);
/* 29 */   public static Tile IceTile = new NonSolidTile(Sprite.Ice);
/*    */   
/*    */   public Tile(Sprite sprite)
/*    */   {
/* 33 */     this.sprite = sprite;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void render(int x, int y, Screen screen)
/*    */   {
/* 40 */     screen.renderTile(x << 4, y << 4, this.sprite);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean solid()
/*    */   {
/* 46 */     return false;
/*    */   }
/*    */   
/*    */   public boolean isWater()
/*    */   {
/* 51 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\Downloads\Untitled2k14.jar!\com\askew\Untitled2k14\level\tile\Tile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */