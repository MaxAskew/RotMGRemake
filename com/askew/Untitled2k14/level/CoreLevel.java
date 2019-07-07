/*    */ package com.askew.Untitled2k14.level;
/*    */ 
/*    */ import com.askew.Untitled2k14.entity.mob.MobPractiseTarget;
/*    */ import java.awt.image.BufferedImage;
/*    */ import java.io.IOException;
/*    */ import java.io.PrintStream;
/*    */ import javax.imageio.ImageIO;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CoreLevel
/*    */   extends Level
/*    */ {
/*    */   public CoreLevel(String path)
/*    */   {
/* 17 */     super(path);
/*    */   }
/*    */   
/*    */ 
/*    */   protected void loadLevel(String path)
/*    */   {
/*    */     try
/*    */     {
/* 25 */       BufferedImage image = ImageIO.read(CoreLevel.class.getResource(path));
/* 26 */       int w = this.width = image.getWidth();
/* 27 */       int h = this.height = image.getHeight();
/* 28 */       this.tiles = new int[w * h];
/* 29 */       image.getRGB(0, 0, w, h, this.tiles, 0, w);
/*    */     }
/*    */     catch (IOException e)
/*    */     {
/* 33 */       e.printStackTrace();
/* 34 */       System.err.println("Exeption! Could not load level file");
/*    */     }
/* 36 */     add(new MobPractiseTarget(30, 57));
/* 37 */     add(new MobPractiseTarget(48, 57));
/*    */   }
/*    */   
/*    */   protected void generateLevel() {}
/*    */ }


/* Location:              D:\Downloads\Untitled2k14.jar!\com\askew\Untitled2k14\level\CoreLevel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */