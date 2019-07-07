/*    */ package com.askew.Untitled2k14.graphics;
/*    */ 
/*    */ public class Font
/*    */ {
/*  5 */   public static SpriteSheet fontSheet = new SpriteSheet("/fonts/fontSheet.png", 8);
/*  6 */   public static Sprite[] character = Sprite.split(fontSheet);
/*    */   
/*  8 */   private static String charIndex = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.,:;\"!?$%()-=+/";
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void render(int x, int y, String text, Screen screen)
/*    */   {
/* 18 */     render(x, y, 0, text, screen);
/*    */   }
/*    */   
/*    */ 
/*    */   public void render(int x, int y, int spacing, String text, Screen screen)
/*    */   {
/* 24 */     int line = 0;
/* 25 */     int xOffset = 0;
/* 26 */     String upperText = text.toUpperCase();
/* 27 */     for (int i = 0; i < upperText.length(); i++)
/*    */     {
/* 29 */       xOffset += 8 + spacing;
/* 30 */       char currentChar = upperText.charAt(i);
/* 31 */       if (currentChar == '\n')
/*    */       {
/* 33 */         xOffset = 0;
/* 34 */         line++;
/*    */       }
/* 36 */       int index = charIndex.indexOf(currentChar);
/* 37 */       if (index != -1) {
/* 38 */         screen.renderSprite(x + xOffset, y + line * 10, character[index], false);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\Downloads\Untitled2k14.jar!\com\askew\Untitled2k14\graphics\Font.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */