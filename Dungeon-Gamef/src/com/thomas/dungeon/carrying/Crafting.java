/*    */ package com.thomas.dungeon.carrying;
/*    */ 
/*    */ import com.thomas.dungeon.Inventory.Inventory;
/*    */ import com.thomas.dungeon.ScreenStuff.Screenprinting;
/*    */ import java.awt.Image;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Crafting
/*    */ {
/* 12 */   public static ArrayList<Buyable> buyItems = new ArrayList<Buyable>();
/*    */ 
/*    */   public static void resetAllTheLevelsAndStuff() {
/* 15 */     buyItems = new ArrayList<Buyable>();
/*    */ 
/* 17 */     buyItems.add(new Buyable(new int[] { 2, 2, 2, 2 }, "Wall", 0));
/* 18 */     buyItems.add(new Buyable(new int[] { 6, 8 }, "Bottle with water"));
/* 19 */     buyItems.add(new Buyable(new int[] { 8, 9, 9 }, "Bottle"));
/* 20 */     buyItems.add(new Buyable(new int[] { 2, 2, 2, 2 }, "AnotherFakerWall"));
/*    */   }
/*    */ 
/*    */   public static void buyItems(int itemType) {
/* 24 */     for (int x = 0; x < buyItems.get(itemType).items.length; x++) {
/* 25 */       Inventory.removeItem(buyItems.get(itemType).items[x], 1);
/*    */     }
/* 27 */     if (!Inventory.getIfNegative()) {
/* 28 */       buyItems.get(itemType).hasAmountOf += 1;
/* 29 */       Inventory.addAmountOfItem(buyItems.get(itemType).name, 1);
/*    */     } else {
/* 31 */       for (int x = 0; x < buyItems.get(itemType).items.length; x++)
/* 32 */         Inventory.addAmountOfItem(buyItems.get(itemType).items[x], 1);
/*    */     }
/*    */   }
/*    */ 
/*    */   public static Image getItemImage(int ItemTypeLocation)
/*    */   {
/* 38 */     if (ItemTypeLocation >= buyItems.size()) {
/* 39 */       return null;
/*    */     }
/* 41 */     if (buyItems.get(ItemTypeLocation).name.equals("Wall")) {
/* 42 */       return Screenprinting.Muur;
/*    */     }
/* 44 */     if (buyItems.get(ItemTypeLocation).name.equals("Bottle"))
/* 45 */       return Screenprinting.Bottle;
/* 46 */     if (buyItems.get(ItemTypeLocation).name.equals("Bottle with water")) {
/* 47 */       return Screenprinting.Bottlewithwater;
/*    */     }
/* 49 */     return null;
/*    */   }
/*    */ }

/* Location:           C:\Users\Thomas\Dropbox\Java source\RPG\RPGGame.jar
 * Qualified Name:     com.thomas.dungeon.carrying.Crafting
 * JD-Core Version:    0.6.2
 */