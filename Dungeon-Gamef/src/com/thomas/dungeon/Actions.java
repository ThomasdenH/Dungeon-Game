/*    */ package com.thomas.dungeon;
/*    */ 
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import java.awt.event.KeyEvent;
/*    */ 
/*    */ public class Actions
/*    */   implements ActionListener
/*    */ {
/*    */   public boolean moving;
/*    */   public String direction;
/*    */ 
/*    */   public void keyPressed(KeyEvent e)
/*    */   {
/* 13 */     if (e.getKeyCode() == 65) {
/* 14 */       this.moving = true;
/* 15 */       this.direction = "left";
/*    */     }
/* 17 */     if (e.getKeyCode() == 87) {
/* 18 */       this.moving = true;
/* 19 */       this.direction = "up";
/*    */     }
/* 21 */     if (e.getKeyCode() == 68) {
/* 22 */       this.moving = true;
/* 23 */       this.direction = "right";
/*    */     }
/* 25 */     if (e.getKeyCode() == 83) {
/* 26 */       this.moving = true;
/* 27 */       this.direction = "down";
/*    */     }
/*    */   }
/*    */ 
/*    */   public void keyReleased(KeyEvent ev) {
/* 32 */     if (ev.getKeyCode() == 65) {
/* 33 */       this.moving = false;
/*    */     }
/*    */ 
/* 36 */     if (ev.getKeyCode() == 87) {
/* 37 */       this.moving = false;
/*    */     }
/*    */ 
/* 40 */     if (ev.getKeyCode() == 68) {
/* 41 */       this.moving = false;
/*    */     }
/* 43 */     if (ev.getKeyCode() == 83)
/* 44 */       this.moving = false;
/*    */   }
/*    */ 
/*    */   public boolean getMoving()
/*    */   {
/* 50 */     return this.moving;
/*    */   }
/*    */ 
/*    */   public String getDirection() {
/* 54 */     return this.direction;
/*    */   }
/*    */ 
/*    */   @Override
public void actionPerformed(ActionEvent arg0)
/*    */   {
/*    */   }
/*    */ }

/* Location:           C:\Users\Thomas\Dropbox\Java source\RPG\RPGGame.jar
 * Qualified Name:     com.thomas.dungeon.Actions
 * JD-Core Version:    0.6.2
 */