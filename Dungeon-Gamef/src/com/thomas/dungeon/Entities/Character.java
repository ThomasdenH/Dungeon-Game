/*    */ package com.thomas.dungeon.Entities;
/*    */ 
/*    */ import com.thomas.dungeon.Inventory.Inventory;

public class Character
{
public static int armorLevel;
public static int weaponLevel;

public static void resetLevels()
/*    */   {
/* 11 */     armorLevel = 1;
/* 12 */     weaponLevel = 1;
/*    */   }
/*    */ 
/*    */   public static void addArmorLevel() {
/* 16 */     armorLevel += 1;
/*    */   }
/*    */ 
/*    */   public static void addWeaponLevel() {
/* 20 */     weaponLevel += 1;
/*    */   }
/*    */ 
/*    */   public static void buyArmorUpgrade() {
/* 24 */     if ((armorLevel == 1) && 
/* 25 */       (Inventory.inventory.get(3).amount > 0)) {
/* 26 */       Inventory.removeItem(2, 1);
/* 27 */       addArmorLevel();
/*    */     }
/*    */ 
/* 30 */     if ((armorLevel == 2) && 
/* 31 */       (Inventory.inventory.get(3).amount > 0)) {
/* 32 */       Inventory.removeItem(2, 2);
/* 33 */       addArmorLevel();
/*    */     }
/*    */   }
/*    */ 
/*    */   public static void buyWeaponUpgrade()
/*    */   {
/* 39 */     if ((weaponLevel == 1) && 
/* 40 */       (Inventory.inventory.get(3).amount > 0)) {
/* 41 */       Inventory.removeItem(2, 1);
/* 42 */       addArmorLevel();
/*    */     }
/*    */ 
/* 45 */     if ((weaponLevel == 2) && 
/* 46 */       (Inventory.inventory.get(3).amount > 0)) {
/* 47 */       Inventory.removeItem(0, 1);
/* 48 */       addArmorLevel();
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Thomas\Dropbox\Java source\RPG\RPGGame.jar
 * Qualified Name:     com.thomas.dungeon.Entities.Character
 * JD-Core Version:    0.6.2
 */