/*    */ package com.thomas.dungeon.Items;
/*    */ 
/*    */ import com.thomas.dungeon.Entities.Location;
/*    */ import com.thomas.dungeon.Entities.Player;
/*    */ import com.thomas.dungeon.Inventory.Inventory;
/*    */ import com.thomas.dungeon.Inventory.SingleItem;
/*    */ import java.util.Random;
/*    */ 
/*    */ public class Items
/*    */ {
/* 11 */   public static Random rand = new Random();
/* 12 */   public static LayingItem[] Items = new LayingItem[1654020];
/*    */   public static int set;
/*    */   public static boolean done;
/*    */ 
/*    */   public static void resetItems()
/*    */   {
/* 15 */     for (int i = 0; i < 80; i++)
/* 16 */       for (int j = 0; j < 50; j++)
/* 17 */         for (int x = 0; x < 20; x++)
/* 18 */           for (int y = 0; y < 20; y++)
/* 19 */             Items[(i * 20 + x + (j * 20 + y) * 1620)] = new LayingItem();
/*    */   }
/*    */ 
/*    */   public static void setItem(int LocX, int LocY, int offSetX, int offSetY, int Item)
/*    */   {
/* 27 */     Items[(LocX * 20 + offSetX + (LocY * 20 + offSetY) * 1620)].itemType = Item;
/* 28 */     Items[(LocX * 20 + offSetX + (LocY * 20 + offSetY) * 1620)].isItem = true;
/*    */   }
/*    */ 
/*    */   public static void setItem(int LocX, int LocY, int offSetX, int offSetY, SingleItem Item) {
/* 32 */     Items[(LocX * 20 + offSetX + (LocY * 20 + offSetY) * 1620)].itemType = Item.type;
/* 33 */     Items[(LocX * 20 + offSetX + (LocY * 20 + offSetY) * 1620)].isItem = true;
/*    */   }
/*    */ 
/*    */   public static void setItemOnRandomOffSet(int LocX, int LocY, int Item)
/*    */   {
/* 40 */     set = 0;
/* 41 */     done = false;
/*    */     do
/*    */     {
/* 44 */       int Xoffset = rand.nextInt(20);
/* 45 */       int Yoffset = rand.nextInt(20);
/* 46 */       if (!Items[(LocX * 20 + Xoffset + (LocY * 20 + Yoffset) * 1620)].isItem) {
/* 47 */         setItem(LocX, LocY, Xoffset, Yoffset, Item);
/* 48 */         done = true;
/*    */       } else {
/* 50 */         set += 1;
/* 51 */         done = false;
/*    */       }
/*    */     }
/* 53 */     while ((done == false) && (set < 200));
/*    */   }
/*    */ 
/*    */   public static void checkForNeedToPickupItem()
/*    */   {
/* 58 */     for (int offSetX = 0; offSetX < 20; offSetX++)
/* 59 */       for (int offSetY = 0; offSetY < 20; offSetY++)
/* 60 */         if (Items[(Player.getPlayer().loc.getX() * 20 + offSetX + (Player.getPlayer().loc.getY() * 20 + offSetY) * 1620)].isItem)
/* 61 */           pickupItem(Player.getPlayer().loc.getX(), Player.getPlayer().loc.getY(), offSetX, offSetY);
/*    */   }
/*    */ 
/*    */   public static void pickupItem(int LocX, int LocY, int offSetX, int offSetY)
/*    */   {
/* 69 */     Items[(LocX * 20 + offSetX + (LocY * 20 + offSetY) * 1620)].isItem = false;
/* 70 */     if (Items[(LocX * 20 + offSetX + (LocY * 20 + offSetY) * 1620)].itemType == -100)
/* 71 */       Player.getPlayer().Heal(33 + rand.nextInt(10));
/*    */     else
/* 73 */       Inventory.addAmountOfItem(Items[(LocX * 20 + offSetX + (LocY * 20 + offSetY) * 1620)].itemType, 1);
/*    */   }
/*    */ }

/* Location:           C:\Users\Thomas\Dropbox\Java source\RPG\RPGGame.jar
 * Qualified Name:     com.thomas.dungeon.Items.Items
 * JD-Core Version:    0.6.2
 */