/*     */ package com.thomas.dungeon.armrupgrades;
/*     */ 
/*     */ import com.thomas.dungeon.GameTechnical.Gamehandler;
/*     */ import com.thomas.dungeon.Inventory.Inventory;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ public class ItemLevels
/*     */ {
/*     */   public static ArrayList<ItemLevel> weaponArray;
/*     */   public static ArrayList<ItemLevel> armorArray;
/*     */   public static ArrayList<ItemLevel> healthArray;
/*     */   public static ArrayList<ItemLevel> BlockArray;
/*  15 */   public static int currentWeaponLevel = 1;
/*     */ 
/*  17 */   public static int currentArmorLevel = 1;
/*  18 */   public static int currentHealthLevel = 1;
/*  19 */   public static int currentBlockLevel = 1;
/*     */   public static int maxLevel;
/*     */   public static int maxLevelarmor;
/*     */   public static int maxLevelhealth;
/*     */   public static int maxLevelBlock;
/*     */ 
/*     */   public static void buyArmorUpgrade()
/*     */   {
/*  27 */     if (currentArmorLevel + 1 < maxLevelarmor) {
/*  28 */       for (int item : ((ItemLevel)armorArray.get(currentArmorLevel + 1)).items) {
/*  29 */         Inventory.removeItem(item, 1);
/*     */       }
/*  31 */       if (!Inventory.getIfNegative())
/*  32 */         currentArmorLevel += 1;
/*     */       else
/*  34 */         for (int item : ((ItemLevel)armorArray.get(currentArmorLevel + 1)).items)
/*  35 */           Inventory.addAmountOfItem(item, 1);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void buyBlockUpgrade()
/*     */   {
/*  42 */     if (currentBlockLevel + 1 < maxLevelBlock) {
/*  43 */       for (int item : ((ItemLevel)BlockArray.get(currentBlockLevel + 1)).items) {
/*  44 */         Inventory.removeItem(item, 1);
/*     */       }
/*  46 */       if (!Inventory.getIfNegative())
/*  47 */         currentBlockLevel += 1;
/*     */       else
/*  49 */         for (int item : ((ItemLevel)BlockArray.get(currentBlockLevel + 1)).items)
/*  50 */           Inventory.addAmountOfItem(item, 1);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void buyHealthUpgrade()
/*     */   {
/*  58 */     if (currentHealthLevel + 1 < maxLevel) {
/*  59 */       for (int item : ((ItemLevel)healthArray.get(currentHealthLevel + 1)).items) {
/*  60 */         Inventory.removeItem(item, 1);
/*     */       }
/*  62 */       if (!Inventory.getIfNegative())
/*  63 */         currentHealthLevel += 1;
/*     */       else
/*  65 */         for (int item : ((ItemLevel)healthArray.get(currentHealthLevel + 1)).items)
/*  66 */           Inventory.addAmountOfItem(item, 1);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void buyUpgrade()
/*     */   {
/*  74 */     switch (Gamehandler.armorTypeSelected) {
/*     */     case 0:
/*  76 */       buyArmorUpgrade();
/*  77 */       break;
/*     */     case 1:
/*  79 */       buyWeaponUpgrade();
/*  80 */       break;
/*     */     case 2:
/*  82 */       buyHealthUpgrade();
/*  83 */       break;
/*     */     case 3:
/*  85 */       buyBlockUpgrade();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void buyWeaponUpgrade()
/*     */   {
/*  93 */     if (currentWeaponLevel + 1 < maxLevel) {
/*  94 */       for (int item : ((ItemLevel)weaponArray.get(currentWeaponLevel + 1)).items) {
/*  95 */         Inventory.removeItem(item, 1);
/*     */       }
/*  97 */       if (!Inventory.getIfNegative())
/*  98 */         currentWeaponLevel += 1;
/*     */       else
/* 100 */         for (int item : ((ItemLevel)weaponArray.get(currentWeaponLevel + 1)).items)
/* 101 */           Inventory.addAmountOfItem(item, 1);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void resetAllTheLevelsAndStuff()
/*     */   {
/* 109 */     Thread x = new Thread(new ItemLevelsRunnable());
/* 110 */     x.start();
/*     */   }
/*     */ }

/* Location:           C:\Users\Thomas\Dropbox\Java source\RPG\RPGGame.jar
 * Qualified Name:     com.thomas.dungeon.armrupgrades.ItemLevels
 * JD-Core Version:    0.6.2
 */