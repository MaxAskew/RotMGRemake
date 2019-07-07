/*    */ package com.askew.Untitled2k14.input;
/*    */ 
/*    */ import java.awt.event.KeyEvent;
/*    */ import java.awt.event.KeyListener;
/*    */ 
/*    */ public class Keyboard
/*    */   implements KeyListener
/*    */ {
/*  9 */   public boolean[] keys = new boolean[120];
/*    */   public boolean up;
/*    */   public boolean down;
/*    */   
/*    */   public void update() {
	up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
	down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
	left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
	right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
}
/*    */   
/*    */   public boolean left;
/*    */   public boolean right;
/*    */   public void keyPressed(KeyEvent e) {
/* 23 */     this.keys[e.getKeyCode()] = true;
/*    */   }
/*    */   
/*    */ 
/*    */   public void keyReleased(KeyEvent e)
/*    */   {
/* 29 */     this.keys[e.getKeyCode()] = false;
/*    */   }
/*    */   
/*    */   public void keyTyped(KeyEvent e)
/*    */   {
/* 34 */     this.keys[e.getKeyCode()] = true;
/*    */   }
/*    */ }


/* Location:              D:\Downloads\Untitled2k14.jar!\com\askew\Untitled2k14\input\Keyboard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */