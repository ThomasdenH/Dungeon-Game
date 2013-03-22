/*     */ package com.thomas.dungeon.Items;
/*     */ 
/*     */ import com.thomas.dungeon.Entities.Player;
/*     */ import com.thomas.dungeon.GameTechnical.TileChecker;
/*     */ import com.thomas.dungeon.Inventory.Inventory;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Random;
/*     */ 
/*     */ public class Chests
/*     */ {
/*     */   public static Chest[] chestst;
/*  14 */   public static Random rand = new Random();
/*     */   public static int chestsOnLevel;
/*     */   public static int x;
/*     */   public static int y;
/*     */ 
/*     */   public static void addChestWithRandomItems(int LocX, int LocY)
/*     */   {
/*  23 */     setFilledChest(LocY, LocY, generateItems());
/*     */   }
/*     */ 
/*     */   public static void addItemsToChest(int LocX, int LocY, ArrayList<SingleItemInChest> items) {
/*  27 */     for (SingleItemInChest e : items)
/*  28 */       chestst[(LocX + LocY * 80)].chestItems.add(e);
/*     */   }
/*     */ 
/*     */   public static void checkForNeedToAddChests()
/*     */   {
/*  33 */     if (chestsOnLevel < 10) {
/*  34 */       x = rand.nextInt(80);
/*  35 */       y = rand.nextInt(50);
/*  36 */       if ((com.thomas.dungeon.GameTechnical.Game.finalMap[x][y] == "-") && 
/*  37 */         (TileChecker.amountTileAround(x, y, "B") == 0) && 
/*  38 */         (TileChecker.amountTileAround(x, y, "D") == 0))
/*  39 */         setFilledChest(x, y, generateItems());
/*     */     }
/*     */   }
/*     */ 
/*     */   public static ArrayList<SingleItemInChest> generateItems()
/*     */   {
/*  50 */     ArrayList<SingleItemInChest> items = new ArrayList<SingleItemInChest>();
/*     */ 
/*  52 */     int maxItemsInChest = 1 + Player.getPlayer().Level / 20 + rand.nextInt(3);
/*  53 */     for (int x = 0; x < maxItemsInChest; x++)
/*  54 */       if (Player.getPlayer().Level < 10) {
/*  55 */         int itemToAdd = rand.nextInt(2);
/*  56 */         switch (itemToAdd) {
/*     */         case 0:
/*  58 */           if (rand.nextBoolean())
/*  59 */             items.add(new SingleItemInChest("Iron", Inventory.inventorystring.indexOf("Iron")));
/*     */           else {
/*  61 */             items.add(new SingleItemInChest("Wood", Inventory.inventorystring.indexOf("Wood")));
/*     */           }
/*  63 */           break;
/*     */         case 1:
/*  65 */           items.add(new SingleItemInChest("Glass", Inventory.inventorystring.indexOf("Glass")));
/*     */         default:
/*  67 */           break;
/*     */         } } else if (Player.getPlayer().Level < 20) {
/*  69 */         int itemToAdd = rand.nextInt(3);
/*  70 */         switch (itemToAdd) {
/*     */         case 0:
/*  72 */           if (rand.nextBoolean())
/*  73 */             items.add(new SingleItemInChest("Iron", Inventory.inventorystring.indexOf("Iron")));
/*     */           else {
/*  75 */             items.add(new SingleItemInChest("Wood", Inventory.inventorystring.indexOf("Wood")));
/*     */           }
/*     */ 
/*  78 */           break;
/*     */         case 1:
/*  80 */           items.add(new SingleItemInChest("Glass", Inventory.inventorystring.indexOf("Glass")));
/*  81 */           break;
/*     */         case 2:
/*  84 */           if (rand.nextBoolean())
/*  85 */             items.add(new SingleItemInChest("Gold", Inventory.inventorystring.indexOf("Gold")));
/*     */           else {
/*  87 */             items.add(new SingleItemInChest("Wood", Inventory.inventorystring.indexOf("Wood")));
/*     */           }
/*     */           break;
/*     */         default:
/*  91 */           break;
/*     */         }
/*  93 */       } else if (Player.getPlayer().Level < 30) {
/*  94 */         int itemToAdd = rand.nextInt(3);
/*  95 */         switch (itemToAdd) {
/*     */         case 0:
/*  97 */           if (rand.nextBoolean())
/*  98 */             items.add(new SingleItemInChest("Iron", Inventory.inventorystring.indexOf("Iron")));
/*     */           else {
/* 100 */             items.add(new SingleItemInChest("Wood", Inventory.inventorystring.indexOf("Wood")));
/*     */           }
/*     */ 
/* 103 */           break;
/*     */         case 1:
/* 105 */           if (rand.nextBoolean())
/* 106 */             items.add(new SingleItemInChest("Glass", Inventory.inventorystring.indexOf("Glass")));
/*     */           else {
/* 108 */             items.add(new SingleItemInChest("Gold", Inventory.inventorystring.indexOf("Gold")));
/*     */           }
/*     */ 
/* 111 */           break;
/*     */         case 2:
/* 114 */           if (rand.nextBoolean())
/* 115 */             items.add(new SingleItemInChest("Gold", Inventory.inventorystring.indexOf("Gold")));
/*     */           else {
/* 117 */             items.add(new SingleItemInChest("Wood", Inventory.inventorystring.indexOf("Wood")));
/*     */           }
/*     */           break;
/*     */         default:
/* 121 */           break;
/*     */         }
/* 123 */       } else if (Player.getPlayer().Level >= 40)
/*     */       {
/* 125 */         if (Player.getPlayer().Level >= 50)
/*     */         {
/* 127 */           if (Player.getPlayer().Level >= 60)
/*     */           {
/* 129 */             if (Player.getPlayer().Level >= 70)
/*     */             {
/* 131 */               if (Player.getPlayer().Level >= 80)
/*     */               {
/* 133 */                 if (Player.getPlayer().Level < 90);
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/* 139 */     return items;
/*     */   }
/*     */ 
/*     */   public static void openChest(int LocX, int LocY) {
/* 143 */     chestst[(LocX + LocY * 80)].isChest = false;
/* 144 */     for (SingleItemInChest e : chestst[(LocX + LocY * 80)].chestItems) {
/* 145 */       Items.setItemOnRandomOffSet(LocX, LocY, e.type);
/*     */     }
/* 147 */     chestsOnLevel -= 1;
/*     */   }
/*     */ 
/*     */   public static void setChests() {
/* 151 */     chestst = new Chest[4080];
/* 152 */     for (int x = 0; x < 80; x++)
/* 153 */       for (int y = 0; y < 50; y++)
/* 154 */         chestst[(x + y * 80)] = new Chest();
/*     */   }
/*     */ 
/*     */   public static void setEmptyChest(int LocX, int LocY)
/*     */   {
/* 160 */     chestst[(LocX + LocY * 80)].isChest = true;
/* 161 */     chestsOnLevel += 1;
/*     */   }
/*     */ 
/*     */   public static void setFilledChest(int LocX, int LocY, ArrayList<SingleItemInChest> items) {
/* 165 */     setEmptyChest(LocX, LocY);
/* 166 */     addItemsToChest(LocX, LocY, items);
/*     */   }
/*     */ }

/* Location:           C:\Users\Thomas\Dropbox\Java source\RPG\RPGGame.jar
 * Qualified Name:     com.thomas.dungeon.Items.Chests
 * JD-Core Version:    0.6.2
 */