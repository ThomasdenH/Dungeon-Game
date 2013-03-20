/*     */ package com.thomas.dungeon.GameTechnical;
/*     */ 
/*     */ import com.thomas.dungeon.Entities.Location;
/*     */ import com.thomas.dungeon.Entities.Mobs;
/*     */ import com.thomas.dungeon.Entities.Player;
/*     */ import com.thomas.dungeon.Entities.nextTurnThread;
/*     */ import com.thomas.dungeon.Fog.Fog;
/*     */ import com.thomas.dungeon.Inventory.Inventory;
/*     */ import com.thomas.dungeon.Items.Chests;
/*     */ import com.thomas.dungeon.Items.Items;
/*     */ import com.thomas.dungeon.Level.LevelArrayList;
/*     */ import com.thomas.dungeon.ScreenStuff.InGameMenu;
/*     */ import com.thomas.dungeon.ScreenStuff.Screenprinting;
/*     */ import com.thomas.dungeon.armrupgrades.ItemLevels;
/*     */ import com.thomas.dungeon.carrying.Crafting;
/*     */ import com.thomas.dungeon.carrying.CraftingInventory;
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ public class Gamehandler
/*     */ {
/*  19 */   public static boolean menu = true;
/*  20 */   public static boolean singlePlayerGame = false;
/*  21 */   public static boolean gameOver = false;
/*     */   public static int totalTurns;
/*  24 */   public static int hasTurn = 0;
/*     */ 
/*  26 */   public static boolean inGameMenuAble = false;
/*  27 */   public static boolean inGameMenu = false;
/*     */   public static int levelLevel;
/*     */   public static int inGameMenuType;
/*     */   public static int inventoryType;
/*  38 */   public static Screenprinting scre = new Screenprinting();
/*     */   public static int levelType;
/*     */   public static int crafting3;
/*     */   public static int crafting;
/*     */   public static int armorTypeSelected;
/*     */   public static int buyableSelected;
/*     */ 
/*     */   public static void checkIfMobsHaveTurn()
/*     */   {
/*  51 */     if (hasTurn == 1)
/*     */     {
/*  53 */       Mobs.allMobsTurn();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void configureSinglePlayerGame() {
/*  58 */     LevelArrayList.resetLevel();
/*  59 */     updateLevel();
/*     */ 
/*  61 */     Player.getPlayer().health = Player.getMaxHealth();
/*  62 */     Player.getPlayer().XP = 0;
/*  63 */     Player.getPlayer().Level = 1;
/*  64 */     Player.getPlayer().direction = "down";
/*     */ 
/*  66 */     Mobs.settings();
/*  67 */     totalTurns = 1;
/*  68 */     hasTurn = 0;
/*     */ 
/*  70 */     Game.pla.loc.setX(39);
/*  71 */     Game.pla.loc.setY(25);
/*     */ 
/*  73 */     scre.printMap();
/*     */ 
/*  75 */     Game.EntitySet();
/*     */ 
/*  77 */     Mobs.mobsOnLevel = 0;
/*  78 */     Inventory.resetInventory();
/*  79 */     inGameMenuAble = true;
/*  80 */     Items.resetItems();
/*  81 */     Chests.setChests();
/*  82 */     ItemLevels.resetAllTheLevelsAndStuff();
/*     */ 
/*  84 */     Fog.resetFog();
/*  85 */     Fog.fogChange();
/*  86 */     Fog.removeFogOnScreen();
/*     */ 
/*  88 */     setLevelType(0);
/*  89 */     InGameMenu.inventoryItems = Inventory.inventory.size();
/*  90 */     Crafting.resetAllTheLevelsAndStuff();
/*  91 */     CraftingInventory.resetThisStuffToo();
/*     */ 
/*  93 */     resetAfterNextLevel();
/*     */   }
/*     */ 
/*     */   public static int getHasTurn()
/*     */   {
/*  98 */     return hasTurn;
/*     */   }
/*     */ 
/*     */   public static int getTotalTurns() {
/* 102 */     return totalTurns;
/*     */   }
/*     */ 
/*     */   public static void goBackToMenu() {
/* 106 */     if (gameOver) {
/* 107 */       gameOver = false;
/* 108 */       singlePlayerGame = false;
/* 109 */       menu = true;
/* 110 */       inGameMenuAble = false;
/*     */     }
/* 112 */     if ((singlePlayerGame) && (!inGameMenu)) {
/* 113 */       gameOver = false;
/* 114 */       singlePlayerGame = false;
/* 115 */       menu = true;
/* 116 */       inGameMenuAble = false;
/*     */     }
/* 118 */     if (inGameMenu)
/* 119 */       inGameMenu = false;
/*     */   }
/*     */ 
/*     */   public static void inGameMenuDown()
/*     */   {
/* 125 */     if (inventoryType == 0) {
/* 126 */       if (InGameMenu.currentIOS < 4) {
/* 127 */         InGameMenu.currentIOS += 1;
/*     */       }
/* 129 */       else if (InGameMenu.currentInventoryOnScreen < InGameMenu.inventoryItems - InGameMenu.inventoryItemsOnScreen) {
/* 130 */         InGameMenu.currentInventoryOnScreen += 1;
/*     */       }
/*     */     }
/*     */ 
/* 134 */     if ((inventoryType == 1) && 
/* 135 */       (armorTypeSelected < 3)) {
/* 136 */       armorTypeSelected += 1;
/*     */     }
/*     */ 
/* 140 */     if (inventoryType == 2)
/* 141 */       if (crafting3 < 2) {
/* 142 */         crafting3 += 1;
/*     */       }
/* 144 */       else if (crafting < Crafting.buyItems.size() - 3)
/* 145 */         crafting += 1;
/*     */   }
/*     */ 
/*     */   public static void inGameMenuLeft()
/*     */   {
/* 152 */     if (inventoryType > 0)
/* 153 */       inventoryType -= 1;
/*     */   }
/*     */ 
/*     */   public static void inGameMenuRight()
/*     */   {
/* 158 */     if (inventoryType < 2)
/* 159 */       inventoryType += 1;
/*     */   }
/*     */ 
/*     */   public static void inGameMenuUp()
/*     */   {
/* 164 */     if (inventoryType == 0) {
/* 165 */       if (InGameMenu.currentIOS > 0) {
/* 166 */         InGameMenu.currentIOS -= 1;
/*     */       }
/* 168 */       else if (InGameMenu.currentInventoryOnScreen > 0) {
/* 169 */         InGameMenu.currentInventoryOnScreen -= 1;
/*     */       }
/*     */     }
/*     */ 
/* 173 */     if ((inventoryType == 1) && 
/* 174 */       (armorTypeSelected > 0)) {
/* 175 */       armorTypeSelected -= 1;
/*     */     }
/*     */ 
/* 179 */     if (inventoryType == 2)
/* 180 */       if (crafting3 > 0) {
/* 181 */         crafting3 -= 1;
/*     */       }
/* 183 */       else if (crafting > 0)
/* 184 */         crafting -= 1;
/*     */   }
/*     */ 
/*     */   public static void nextTurn()
/*     */   {
/* 192 */     if (hasTurn >= totalTurns)
/* 193 */       hasTurn = 0;
/*     */     else {
/* 195 */       hasTurn += 1;
/*     */     }
/* 197 */     Runnable runnable = new nextTurnThread();
/* 198 */     Thread thread = new Thread(runnable);
/* 199 */     thread.start();
/* 200 */     Fog.fogChange();
/* 201 */     Fog.removeFogOnScreen();
/*     */   }
/*     */ 
/*     */   public static void resetAfterNextLevel()
/*     */   {
/* 206 */     Mobs.settings();
/*     */ 
/* 208 */     Game.finalTorches = LevelArrayList.setTorches();
/* 209 */     Game.finalDark = LevelArrayList.setDark();
/* 210 */     Game.finalVariations = LevelArrayList.setVariations();
/*     */ 
/* 212 */     Game.EntitySet();
/*     */ 
/* 214 */     Mobs.mobsOnLevel = 0;
/*     */ 
/* 216 */     Fog.resetFog();
/* 217 */     Fog.fogChange();
/* 218 */     Fog.removeFogOnScreen();
/*     */ 
/* 220 */     Chests.setChests();
/* 221 */     LevelArrayList.resetBlockHealth();
/*     */   }
/*     */ 
/*     */   public static void setGameOver()
/*     */   {
/* 226 */     gameOver = true;
/* 227 */     singlePlayerGame = false;
/* 228 */     menu = false;
/* 229 */     inGameMenuAble = false;
/* 230 */     inGameMenu = false;
/*     */   }
/*     */ 
/*     */   public static void setHasTurn(int hasTurn)
/*     */   {
/* 235 */     hasTurn = hasTurn;
/* 236 */     checkIfMobsHaveTurn();
/* 237 */     Player.getPlayer().checkLevel();
/* 238 */     Items.checkForNeedToPickupItem();
/*     */   }
/*     */ 
/*     */   public static void setInGameMenu(int type) {
/* 242 */     inGameMenu = true;
/* 243 */     inGameMenuType = type;
/*     */   }
/*     */ 
/*     */   public static void setLevelType(int LevelType)
/*     */   {
/* 248 */     levelType = LevelType;
/*     */   }
/*     */ 
/*     */   public static void setTotalTurns(int totalTurns) {
/* 252 */     totalTurns = totalTurns;
/*     */   }
/*     */ 
/*     */   public static void updateLevel() {
/* 256 */     Game.finalMap = LevelArrayList.getLevel();
/* 257 */     Game.StairLocationX = LevelArrayList.getStairIntX();
/* 258 */     Game.StairLocationY = LevelArrayList.getStairIntY();
/* 259 */     System.out.println(levelLevel);
/*     */   }
/*     */ 
/*     */   public Gamehandler()
/*     */   {
/* 264 */     menu = true;
/*     */   }
/*     */ }

/* Location:           C:\Users\Thomas\Dropbox\Java source\RPG\RPGGame.jar
 * Qualified Name:     com.thomas.dungeon.GameTechnical.Gamehandler
 * JD-Core Version:    0.6.2
 */