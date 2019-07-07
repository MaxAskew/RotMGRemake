/*    */ package com.askew.Untitled2k14.entity.mob;
/*    */ 
/*    */ import com.askew.Untitled2k14.graphics.Screen;
/*    */ import com.askew.Untitled2k14.graphics.Sprite;
/*    */ 
/*    */ public class MobPractiseTarget
/*    */   extends Mob
/*    */ {
/*    */   public MobPractiseTarget(int x, int y)
/*    */   {
/* 11 */     this.x = (x << 4);
/* 12 */     this.y = (y << 4);
/* 13 */     this.sprite = Sprite.practiseTarget;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void update() {}
/*    */   
/*    */ 
/*    */ 
/*    */   public void render(Screen screen)
/*    */   {
/* 25 */     screen.renderMob(this.x, this.y, this.sprite);
/*    */   }
/*    */ }


/* Location:              D:\Downloads\Untitled2k14.jar!\com\askew\Untitled2k14\entity\mob\MobPractiseTarget.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */