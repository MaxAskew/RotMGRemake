/*    */ package com.askew.Untitled2k14.graphics;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ 
/*  5 */ public class AnimatedSprite extends Sprite { private int frame = 0;
/*    */   private Sprite sprite;
/*  7 */   private int rate = 5;
/*  8 */   private int length = -1;
/*  9 */   private int time = 0;
/*    */   
/*    */   public AnimatedSprite(SpriteSheet sheet, int width, int height, int length)
/*    */   {
/* 13 */     super(sheet, width, height);
/* 14 */     this.length = length;
/*    */     
/* 16 */     this.sprite = sheet.getSprite()[0];
/* 17 */     if (length > sheet.getSprite().length) System.err.println("Length of animation is too long!");
/*    */   }
/*    */   
/*    */   public void update()
/*    */   {
/* 22 */     this.time += 1;
/* 23 */     if (this.time % this.rate == 0)
/*    */     {
/* 25 */       if (this.frame >= this.length - 1) this.frame = 0; else
/* 26 */         this.frame += 1;
/* 27 */       this.sprite = this.sheet.getSprite()[this.frame];
/*    */     }
/*    */   }
/*    */   
/*    */   public Sprite getSprite()
/*    */   {
/* 33 */     return this.sprite;
/*    */   }
/*    */   
/*    */   public void SetFrameRate(int frames)
/*    */   {
/* 38 */     this.rate = frames;
/*    */   }
/*    */   
/*    */   public void SetFrame(int index)
/*    */   {
/* 43 */     if (index > this.sheet.getSprite().length - 1)
/*    */     {
/* 45 */       System.err.println("Index out of bounds in " + this);
/* 46 */       return;
/*    */     }
/* 48 */     this.sprite = this.sheet.getSprite()[index];
/*    */   }
/*    */ }


/* Location:              D:\Downloads\Untitled2k14.jar!\com\askew\Untitled2k14\graphics\AnimatedSprite.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */