/*    */ package com.thomas.dungeon.Entities;
/*    */ 
/*    */ import com.thomas.dungeon.GameTechnical.Gamehandler;
/*    */ 
/*    */ public class MobturnThread
/*    */   implements Runnable
/*    */ {
/*    */   public void run()
/*    */   {
/* 10 */     for (int i = 0; i < 80; i++) {
/* 11 */       for (int j = 0; j < 50; j++) {
/* 12 */         if ((Mobs.mob[(i + j * 80)].isMob) && 
/* 13 */           (!Mobs.mob[(i + j * 80)].alReadyMoved)) {
/* 14 */           Mobs.mobTurn(i, j);
/*    */         }
/*    */       }
/*    */     }
/*    */ 
/* 19 */     Gamehandler.nextTurn();
/* 20 */     for (int i = 0; i < 80; i++)
/* 21 */       for (int j = 0; j < 50; j++)
/* 22 */         Mobs.mob[(i + j * 80)].alReadyMoved = false;
/*    */   }
/*    */ }

/* Location:           C:\Users\Thomas\Dropbox\Java source\RPG\RPGGame.jar
 * Qualified Name:     com.thomas.dungeon.Entities.MobturnThread
 * JD-Core Version:    0.6.2
 */