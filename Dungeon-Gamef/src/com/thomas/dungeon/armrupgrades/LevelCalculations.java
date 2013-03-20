/*    */ package com.thomas.dungeon.armrupgrades;
/*    */ 
/*    */ public class LevelCalculations
/*    */ {
/*    */   public static int calculateWeaponDamageRelative()
/*    */   {
/*  7 */     return 10 + ItemLevels.currentWeaponLevel * 1;
/*    */   }
/*    */ 
/*    */   public static int calculateWeaponDamageAmount()
/*    */   {
/* 12 */     return 5 + ItemLevels.currentWeaponLevel / 2;
/*    */   }
/*    */   public static int calculateArmorDefenceAmount() {
/* 15 */     return 100 / ItemLevels.maxLevelarmor * ItemLevels.currentArmorLevel;
/*    */   }
/*    */ }

/* Location:           C:\Users\Thomas\Dropbox\Java source\RPG\RPGGame.jar
 * Qualified Name:     com.thomas.dungeon.armrupgrades.LevelCalculations
 * JD-Core Version:    0.6.2
 */