/*    */ package com.thomas.dungeon.Entities;
/*    */ 
/*    */ import com.thomas.dungeon.Fog.Fog;
/*    */ import com.thomas.dungeon.GameTechnical.Gamehandler;
/*    */ import com.thomas.dungeon.Items.Chests;
/*    */ import com.thomas.dungeon.Items.Items;
/*    */ 
/*    */ public class nextTurnThread
/*    */   implements Runnable
/*    */ {
/*    */   @Override
public void run()
/*    */   {
/* 14 */     Player.getPlayer().checkLevel();
/* 15 */     Mobs.checkForNeedToSpawnMob();
/* 16 */     Mobs.despawnDied();
/* 17 */     Items.checkForNeedToPickupItem();
/* 18 */     Gamehandler.checkIfMobsHaveTurn();
/* 19 */     Chests.checkForNeedToAddChests();
/* 20 */     Fog.fogChange();
/*    */   }
/*    */ }

/* Location:           C:\Users\Thomas\Dropbox\Java source\RPG\RPGGame.jar
 * Qualified Name:     com.thomas.dungeon.Entities.nextTurnThread
 * JD-Core Version:    0.6.2
 */