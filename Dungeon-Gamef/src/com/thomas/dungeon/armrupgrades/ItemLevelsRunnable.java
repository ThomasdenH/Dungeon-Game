/*    */ package com.thomas.dungeon.armrupgrades;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class ItemLevelsRunnable
/*    */   implements Runnable
/*    */ {
/*    */   @Override
public void run()
/*    */   {
/* 10 */     ItemLevels.weaponArray = new ArrayList<ItemLevel>();
/* 11 */     ItemLevels.weaponArray.add(new ItemLevel(new int[] { 1 }));
/* 12 */     ItemLevels.weaponArray.add(new ItemLevel(new int[2]));
/* 13 */     ItemLevels.weaponArray.add(new ItemLevel(new int[] { 2, 2 }));
/* 14 */     ItemLevels.weaponArray.add(new ItemLevel(new int[] { 2, 2, 2 }));
/* 15 */     ItemLevels.weaponArray.add(new ItemLevel(new int[] { 0, 2 }));
/* 16 */     ItemLevels.weaponArray.add(new ItemLevel(new int[] { 0, 0, 2 }));
/* 17 */     ItemLevels.weaponArray.add(new ItemLevel(new int[] { 0, 0, 1, 2 }));
/* 18 */     ItemLevels.weaponArray.add(new ItemLevel(new int[2]));
/* 19 */     ItemLevels.weaponArray.add(new ItemLevel(new int[] { 3, 2 }));
/* 20 */     ItemLevels.weaponArray.add(new ItemLevel(new int[2]));
/* 21 */     ItemLevels.maxLevel = ItemLevels.weaponArray.size();
/*    */ 
/* 23 */     ItemLevels.armorArray = new ArrayList<ItemLevel>();
/* 24 */     ItemLevels.armorArray.add(new ItemLevel(new int[] { 1 }));
/* 25 */     ItemLevels.armorArray.add(new ItemLevel(new int[2]));
/* 26 */     ItemLevels.armorArray.add(new ItemLevel(new int[2]));
/* 27 */     ItemLevels.armorArray.add(new ItemLevel(new int[3]));
/* 28 */     ItemLevels.armorArray.add(new ItemLevel(new int[] { 0, 0, 1 }));
/* 29 */     ItemLevels.armorArray.add(new ItemLevel(new int[] { 3 }));
/* 30 */     ItemLevels.armorArray.add(new ItemLevel(new int[] { 3, 3, 3 }));
/* 31 */     ItemLevels.armorArray.add(new ItemLevel(new int[] { 0, 0, 1, 1, 3 }));
/* 32 */     ItemLevels.armorArray.add(new ItemLevel(new int[] { 0, 0, 1, 1, 3 }));
/* 33 */     ItemLevels.armorArray.add(new ItemLevel(new int[] { 3, 3, 3 }));
/* 34 */     ItemLevels.maxLevelarmor = ItemLevels.armorArray.size();
/*    */ 
/* 36 */     ItemLevels.healthArray = new ArrayList<ItemLevel>();
/* 37 */     ItemLevels.healthArray.add(new ItemLevel(new int[] { 1 }));
/* 38 */     ItemLevels.healthArray.add(new ItemLevel(new int[2]));
/* 39 */     ItemLevels.healthArray.add(new ItemLevel(new int[2]));
/* 40 */     ItemLevels.healthArray.add(new ItemLevel(new int[3]));
/* 41 */     ItemLevels.healthArray.add(new ItemLevel(new int[] { 0, 0, 1 }));
/* 42 */     ItemLevels.healthArray.add(new ItemLevel(new int[] { 3 }));
/* 43 */     ItemLevels.healthArray.add(new ItemLevel(new int[] { 3, 3, 3 }));
/* 44 */     ItemLevels.healthArray.add(new ItemLevel(new int[] { 0, 0, 1, 1, 3 }));
/* 45 */     ItemLevels.healthArray.add(new ItemLevel(new int[] { 0, 0, 1, 1, 3 }));
/* 46 */     ItemLevels.healthArray.add(new ItemLevel(new int[] { 3, 3, 3 }));
/* 47 */     ItemLevels.maxLevelhealth = ItemLevels.healthArray.size();
/*    */ 
/* 49 */     ItemLevels.BlockArray = new ArrayList<ItemLevel>();
/* 50 */     ItemLevels.BlockArray.add(new ItemLevel(new int[] { 1 }));
/* 51 */     ItemLevels.BlockArray.add(new ItemLevel(new int[2]));
/* 52 */     ItemLevels.BlockArray.add(new ItemLevel(new int[2]));
/* 53 */     ItemLevels.BlockArray.add(new ItemLevel(new int[3]));
/* 54 */     ItemLevels.BlockArray.add(new ItemLevel(new int[] { 0, 0, 1 }));
/* 55 */     ItemLevels.BlockArray.add(new ItemLevel(new int[] { 3 }));
/* 56 */     ItemLevels.BlockArray.add(new ItemLevel(new int[] { 3, 3, 3 }));
/* 57 */     ItemLevels.BlockArray.add(new ItemLevel(new int[] { 0, 0, 1, 1, 3 }));
/* 58 */     ItemLevels.BlockArray.add(new ItemLevel(new int[] { 0, 0, 1, 1, 3 }));
/* 59 */     ItemLevels.BlockArray.add(new ItemLevel(new int[] { 3, 3, 3 }));
/* 60 */     ItemLevels.maxLevelBlock = ItemLevels.BlockArray.size();
/*    */   }
/*    */ }

/* Location:           C:\Users\Thomas\Dropbox\Java source\RPG\RPGGame.jar
 * Qualified Name:     com.thomas.dungeon.armrupgrades.ItemLevelsRunnable
 * JD-Core Version:    0.6.2
 */