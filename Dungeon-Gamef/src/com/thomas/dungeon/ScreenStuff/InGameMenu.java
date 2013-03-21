/*     */ package com.thomas.dungeon.ScreenStuff;
/*     */ import com.thomas.dungeon.Entities.Player;
/*     */ import com.thomas.dungeon.GameTechnical.Game;
/*     */ import com.thomas.dungeon.GameTechnical.Gamehandler;
/*     */ import com.thomas.dungeon.Inventory.Inventory;
/*     */ import com.thomas.dungeon.armrupgrades.ItemLevels;
/*     */ import com.thomas.dungeon.carrying.Crafting;
/*     */ import java.awt.BasicStroke;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.RenderingHints;
/*     */ import java.awt.image.BufferedImage;
/*     */ 
/*     */ public class InGameMenu
/*     */ {
/*  21 */   public BufferedImage menuImage = new BufferedImage(Game.WIDTH * 9 / 10, Game.HEIGHT * 9 / 10, 2);
/*     */ 
/*  23 */   public Graphics2D g = (Graphics2D)this.menuImage.getGraphics();
/*     */ 
/*  25 */   public BufferedImage inventoryImage = new BufferedImage(2000, 1000, 2);
/*     */ 
/*  27 */   public Graphics2D ginv = (Graphics2D)this.inventoryImage.getGraphics();
/*  28 */   public static int inventoryItems = Inventory.inventory.size();
/*     */ 
/*  30 */   public static int inventoryItemsOnScreen = 5;
/*     */   public static int currentInventoryOnScreen;
/*     */   public static int currentIOS;
/*  33 */   public static Font gameOverFont = new Font("Dialog", 1, 60);
/*     */ 
/*  35 */   public static Font smallerGameOverFont = new Font("Dialog", 1, 35);
/*  36 */   public BufferedImage characterImage = new BufferedImage(2000, 1000, 2);
/*     */ 
/*  38 */   public Graphics2D gcha = (Graphics2D)this.inventoryImage.getGraphics();
/*     */ 
/*  40 */   public BufferedImage mapImage = new BufferedImage(Game.WIDTH * 9 / 10, Game.WIDTH * 9 / 10 / 80 * 50, 2);
/*  41 */   public Graphics2D gmap = (Graphics2D)this.mapImage.getGraphics();
/*     */   public static int tileSizeX;
/*     */   public static int tileSizeY;
/*     */   public static int tileSize;
/*  47 */   public static Color floorColor = Color.gray;
/*  48 */   public static Color wallColor = Color.YELLOW;
/*  49 */   public static Color doorColor = new Color(255, 100, 0);
/*     */ 
/*  51 */   public static Color playerColor = Color.RED;
/*  52 */   public static Color chestColor = Color.RED;
/*     */ 
/*  54 */   public BufferedImage craftingInventoryImage = new BufferedImage(2000, 1000, 2);
/*     */ 
/*  56 */   public Graphics2D gcrin = (Graphics2D)this.craftingInventoryImage.getGraphics();
/*     */ 
/*     */   public BufferedImage getCharacterImage() {
/*  59 */     this.ginv.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
/*  60 */     this.ginv.drawImage(Screenprinting.ArmorButton, 100, 130, 900, 820, null);
/*  61 */     this.ginv.setFont(gameOverFont);
/*     */ 
/*  63 */     this.ginv.drawImage(Screenprinting.MenuBackgroundBlur, 1100, 130, 900, 100, null);
/*  64 */     this.ginv.drawImage(Screenprinting.MenuBackgroundBlur, 1100, 240, 900, 100, null);
/*  65 */     this.ginv.drawImage(Screenprinting.MenuBackgroundBlur, 1100, 350, 900, 100, null);
/*  66 */     switch (Gamehandler.armorTypeSelected) {
/*     */     case 0:
/*  68 */       this.ginv.setColor(Color.black);
/*  69 */       this.ginv.drawString("Armor", 1203, 203);
/*  70 */       this.ginv.setColor(Color.yellow);
/*  71 */       this.ginv.drawString("Armor", 1200, 200);
/*     */ 
/*  73 */       this.ginv.setColor(Color.black);
/*  74 */       this.ginv.drawString("Weapon", 1203, 313);
/*  75 */       this.ginv.setColor(Color.white);
/*  76 */       this.ginv.drawString("Weapon", 1200, 310);
/*  77 */       this.ginv.setColor(Color.black);
/*     */ 
/*  79 */       this.ginv.setColor(Color.black);
/*  80 */       this.ginv.drawString("Health", 1203, 423);
/*  81 */       this.ginv.setColor(Color.white);
/*  82 */       this.ginv.drawString("Health", 1200, 420);
/*     */ 
/*  84 */       this.ginv.drawImage(Screenprinting.ArmorButton, 100, 850, 900, 100, null);
/*  85 */       this.ginv.setColor(new Color(0, 50, 50, 50));
/*  86 */       this.ginv.fillRect(100, 850, 900, 100);
/*  87 */       this.ginv.setColor(new Color(40, 0, 0, 200));
/*  88 */       this.ginv.setStroke(new BasicStroke(5.0F, 0, 2));
/*  89 */       this.ginv.drawRect(100, 850, 900, 100);
/*  90 */       if (ItemLevels.currentArmorLevel + 1 < ItemLevels.maxLevelarmor) {
/*  91 */         for (int x = 0; x < ItemLevels.armorArray.get(ItemLevels.currentArmorLevel + 1).items.length; x++) {
/*  92 */           this.ginv.drawImage(Screenprinting.ArmorButton, 150 + x * 100, 850, 100, 100, null);
/*  93 */           this.ginv.drawImage(Inventory.getItemImage(ItemLevels.armorArray.get(ItemLevels.currentArmorLevel + 1).items[x]), 150 + x * 100, 850, 100, 100, null);
/*     */         }
/*     */       } else {
/*  96 */         this.ginv.setColor(Color.black);
/*  97 */         this.ginv.drawString("MAX LEVEL", 123, 923);
/*  98 */         this.ginv.setColor(Color.red);
/*  99 */         this.ginv.drawString("MAX LEVEL", 120, 920);
/*     */       }
/*     */ 
/* 103 */       this.ginv.setColor(Color.black);
/* 104 */       this.ginv.drawString(ItemLevels.currentArmorLevel + " ", 903, 923);
/* 105 */       this.ginv.setColor(Color.white);
/* 106 */       this.ginv.drawString(ItemLevels.currentArmorLevel + " ", 900, 920);
/*     */ 
/* 108 */       break;
/*     */     case 1:
/* 110 */       this.ginv.setColor(Color.black);
/* 111 */       this.ginv.drawString("Armor", 1203, 203);
/* 112 */       this.ginv.setColor(Color.white);
/* 113 */       this.ginv.drawString("Armor", 1200, 200);
/*     */ 
/* 115 */       this.ginv.setColor(Color.black);
/* 116 */       this.ginv.drawString("Weapon", 1203, 313);
/* 117 */       this.ginv.setColor(Color.yellow);
/* 118 */       this.ginv.drawString("Weapon", 1200, 310);
/*     */ 
/* 120 */       this.ginv.setColor(Color.black);
/* 121 */       this.ginv.drawString("Health", 1203, 423);
/* 122 */       this.ginv.setColor(Color.white);
/* 123 */       this.ginv.drawString("Health", 1200, 420);
/*     */ 
/* 125 */       this.ginv.drawImage(Screenprinting.ArmorButton, 100, 850, 900, 100, null);
/* 126 */       this.ginv.setColor(new Color(0, 50, 50, 50));
/* 127 */       this.ginv.fillRect(100, 850, 900, 100);
/* 128 */       this.ginv.setColor(new Color(40, 0, 0, 200));
/* 129 */       this.ginv.setStroke(new BasicStroke(5.0F, 0, 2));
/* 130 */       this.ginv.drawRect(100, 850, 900, 100);
/* 131 */       if (ItemLevels.currentWeaponLevel + 1 < ItemLevels.maxLevel) {
/* 132 */         for (int x = 0; x < ItemLevels.weaponArray.get(ItemLevels.currentWeaponLevel + 1).items.length; x++) {
/* 133 */           this.ginv.drawImage(Screenprinting.ArmorButton, 150 + x * 100, 850, 100, 100, null);
/* 134 */           this.ginv.drawImage(Inventory.getItemImage(ItemLevels.weaponArray.get(ItemLevels.currentWeaponLevel + 1).items[x]), 150 + x * 100, 850, 100, 100, null);
/*     */         }
/*     */       } else {
/* 137 */         this.ginv.setColor(Color.black);
/* 138 */         this.ginv.drawString("MAX LEVEL", 123, 923);
/* 139 */         this.ginv.setColor(Color.red);
/* 140 */         this.ginv.drawString("MAX LEVEL", 120, 920);
/*     */       }
/*     */ 
/* 143 */       this.ginv.setColor(Color.black);
/* 144 */       this.ginv.drawString(ItemLevels.currentWeaponLevel + " ", 903, 923);
/* 145 */       this.ginv.setColor(Color.white);
/* 146 */       this.ginv.drawString(ItemLevels.currentWeaponLevel + " ", 900, 920);
/*     */ 
/* 148 */       break;
/*     */     case 2:
/* 150 */       this.ginv.setColor(Color.black);
/* 151 */       this.ginv.drawString("Armor", 1203, 203);
/* 152 */       this.ginv.setColor(Color.white);
/* 153 */       this.ginv.drawString("Armor", 1200, 200);
/*     */ 
/* 155 */       this.ginv.setColor(Color.black);
/* 156 */       this.ginv.drawString("Weapon", 1203, 313);
/* 157 */       this.ginv.setColor(Color.white);
/* 158 */       this.ginv.drawString("Weapon", 1200, 310);
/*     */ 
/* 160 */       this.ginv.setColor(Color.black);
/* 161 */       this.ginv.drawString("Health", 1203, 423);
/* 162 */       this.ginv.setColor(Color.yellow);
/* 163 */       this.ginv.drawString("Health", 1200, 420);
/*     */ 
/* 165 */       this.ginv.drawImage(Screenprinting.ArmorButton, 100, 850, 900, 100, null);
/* 166 */       this.ginv.setColor(new Color(0, 50, 50, 50));
/* 167 */       this.ginv.fillRect(100, 850, 900, 100);
/* 168 */       this.ginv.setColor(new Color(40, 0, 0, 200));
/* 169 */       this.ginv.setStroke(new BasicStroke(5.0F, 0, 2));
/* 170 */       this.ginv.drawRect(100, 850, 900, 100);
/* 171 */       if (ItemLevels.currentHealthLevel + 1 < ItemLevels.maxLevelhealth) {
/* 172 */         for (int x = 0; x < ItemLevels.healthArray.get(ItemLevels.currentHealthLevel + 1).items.length; x++) {
/* 173 */           this.ginv.drawImage(Screenprinting.ArmorButton, 150 + x * 100, 850, 100, 100, null);
/* 174 */           this.ginv.drawImage(Inventory.getItemImage(ItemLevels.healthArray.get(ItemLevels.currentHealthLevel + 1).items[x]), 150 + x * 100, 850, 100, 100, null);
/*     */         }
/*     */       } else {
/* 177 */         this.ginv.setColor(Color.black);
/* 178 */         this.ginv.drawString("MAX LEVEL", 123, 923);
/* 179 */         this.ginv.setColor(Color.red);
/* 180 */         this.ginv.drawString("MAX LEVEL", 120, 920);
/*     */       }
/*     */ 
/* 183 */       this.ginv.setColor(Color.black);
/* 184 */       this.ginv.drawString(ItemLevels.currentHealthLevel + " ", 903, 923);
/* 185 */       this.ginv.setColor(Color.white);
/* 186 */       this.ginv.drawString(ItemLevels.currentHealthLevel + " ", 900, 920);
/*     */     }
/*     */ 
/* 192 */     this.ginv.drawImage(Screenprinting.MenuBackgroundRed, 0, 0, 400, 100, null);
/* 193 */     this.ginv.setFont(gameOverFont);
/* 194 */     this.ginv.setColor(Color.black);
/* 195 */     this.ginv.drawString("Materials", 73, 73);
/* 196 */     this.ginv.setColor(Color.white);
/* 197 */     this.ginv.drawString("Materials", 70, 70);
/* 198 */     this.ginv.drawImage(Screenprinting.MenuBackgroundRed, 400, 0, 400, 100, null);
/* 199 */     this.ginv.setFont(gameOverFont);
/* 200 */     this.ginv.setColor(Color.black);
/* 201 */     this.ginv.drawString("Character", 473, 73);
/* 202 */     this.ginv.setColor(Color.yellow);
/* 203 */     this.ginv.drawString("Character", 470, 70);
/*     */ 
/* 205 */     this.ginv.drawImage(Screenprinting.MenuBackgroundRed, 800, 0, 400, 100, null);
/* 206 */     this.ginv.setFont(gameOverFont);
/* 207 */     this.ginv.setColor(Color.black);
/* 208 */     this.ginv.drawString("Crafting", 873, 73);
/* 209 */     this.ginv.setColor(Color.white);
/* 210 */     this.ginv.drawString("Crafting", 870, 70);
/*     */ 
/* 212 */     this.ginv.dispose();
/* 213 */     return this.inventoryImage;
/*     */   }
/*     */ 
/*     */   public BufferedImage getCraftingImage()
/*     */   {
/* 218 */     this.ginv.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
/* 219 */     this.ginv.drawImage(Screenprinting.ItemScreen, 0, 100, 1990, 300, null);
/* 220 */     this.ginv.drawImage(Screenprinting.ItemScreen, 0, 400, 1990, 300, null);
/* 221 */     this.ginv.drawImage(Screenprinting.ItemScreen, 0, 700, 1990, 300, null);
/*     */ 
/* 223 */     this.ginv.drawImage(Crafting.getItemImage(Gamehandler.crafting), 145, 150, null);
/* 224 */     this.ginv.drawImage(Crafting.getItemImage(Gamehandler.crafting + 1), 145, 450, null);
/* 225 */     this.ginv.drawImage(Crafting.getItemImage(Gamehandler.crafting + 2), 145, 750, null);
/* 226 */     this.ginv.setFont(gameOverFont);
/* 227 */     this.ginv.setColor(Color.BLACK);
/* 228 */     this.ginv.drawString(Crafting.buyItems.get(Gamehandler.crafting).name, 553, 183);
/* 229 */     this.ginv.drawString(Crafting.buyItems.get(Gamehandler.crafting + 1).name, 553, 483);
/* 230 */     this.ginv.drawString(Crafting.buyItems.get(Gamehandler.crafting + 2).name, 553, 783);
/* 231 */     this.ginv.setColor(Color.WHITE);
/* 232 */     this.ginv.drawString(Crafting.buyItems.get(Gamehandler.crafting).name, 550, 180);
/* 233 */     this.ginv.drawString(Crafting.buyItems.get(Gamehandler.crafting + 1).name, 550, 480);
/* 234 */     this.ginv.drawString(Crafting.buyItems.get(Gamehandler.crafting + 2).name, 550, 780);
/*     */ 
/* 236 */     for (int x = 0; x < Crafting.buyItems.get(Gamehandler.crafting).items.length; x++) {
/* 237 */       this.ginv.drawImage(Screenprinting.ArmorButton, 550 + x * 100, 280, 100, 100, null);
/* 238 */       this.ginv.drawImage(Inventory.itemImage(Crafting.buyItems.get(Gamehandler.crafting).items[x]), 550 + x * 100, 280, 100, 100, null);
/*     */     }
/* 240 */     for (int x = 0; x < Crafting.buyItems.get(Gamehandler.crafting + 1).items.length; x++) {
/* 241 */       this.ginv.drawImage(Screenprinting.ArmorButton, 550 + x * 100, 580, 100, 100, null);
/* 242 */       this.ginv.drawImage(Inventory.itemImage(Crafting.buyItems.get(Gamehandler.crafting + 1).items[x]), 550 + x * 100, 580, 100, 100, null);
/*     */     }
/* 244 */     for (int x = 0; x < Crafting.buyItems.get(Gamehandler.crafting + 2).items.length; x++) {
/* 245 */       this.ginv.drawImage(Screenprinting.ArmorButton, 550 + x * 100, 880, 100, 100, null);
/* 246 */       this.ginv.drawImage(Inventory.itemImage(Crafting.buyItems.get(Gamehandler.crafting + 2).items[x]), 550 + x * 100, 880, 100, 100, null);
/*     */     }
/*     */ 
/* 249 */     this.ginv.setColor(Color.BLACK);
/* 250 */     this.ginv.drawString("Amount: " + Inventory.getStringToAmount(Crafting.buyItems.get(Gamehandler.crafting).name), 560, 238);
/* 251 */     this.ginv.drawString("Amount: " + Inventory.getStringToAmount(new StringBuilder(String.valueOf(Crafting.buyItems.get(Gamehandler.crafting).name)).append(1).toString()), 560, 538);
/* 252 */     this.ginv.drawString("Amount: " + Inventory.getStringToAmount(new StringBuilder(String.valueOf(Crafting.buyItems.get(Gamehandler.crafting).name)).append(2).toString()), 560, 838);
/*     */ 
/* 254 */     this.ginv.setColor(Color.WHITE);
/* 255 */     this.ginv.drawString("Amount: " + Inventory.getStringToAmount(Crafting.buyItems.get(Gamehandler.crafting).name), 557, 235);
/* 256 */     this.ginv.drawString("Amount: " + Inventory.getStringToAmount(new StringBuilder(String.valueOf(Crafting.buyItems.get(Gamehandler.crafting).name)).append(1).toString()), 557, 535);
/* 257 */     this.ginv.drawString("Amount: " + Inventory.getStringToAmount(new StringBuilder(String.valueOf(Crafting.buyItems.get(Gamehandler.crafting).name)).append(2).toString()), 557, 835);
/*     */ 
/* 259 */     this.ginv.setColor(new Color(200, 200, 100, 150));
/* 260 */     this.ginv.setStroke(new BasicStroke(20.0F));
/* 261 */     this.ginv.drawRect(0, 100 + Gamehandler.crafting3 * 300, 1990, 300);
/*     */ 
/* 263 */     this.ginv.setColor(new Color(30, 30, 30));
/* 264 */     this.ginv.fillRect(1990, 100 + 900 / Inventory.inventory.size() * currentInventoryOnScreen, 10, 3000 / Inventory.inventory.size());
/*     */ 
/* 266 */     this.ginv.drawImage(Screenprinting.MenuBackgroundRed, 0, 0, 400, 100, null);
/* 267 */     this.ginv.setFont(gameOverFont);
/* 268 */     this.ginv.setColor(Color.black);
/* 269 */     this.ginv.drawString("Materials", 73, 73);
/* 270 */     this.ginv.setColor(Color.white);
/* 271 */     this.ginv.drawString("Materials", 70, 70);
/*     */ 
/* 273 */     this.ginv.drawImage(Screenprinting.MenuBackgroundRed, 400, 0, 400, 100, null);
/* 274 */     this.ginv.setFont(gameOverFont);
/* 275 */     this.ginv.setColor(Color.black);
/* 276 */     this.ginv.drawString("Character", 473, 73);
/* 277 */     this.ginv.setColor(Color.white);
/* 278 */     this.ginv.drawString("Character", 470, 70);
/*     */ 
/* 280 */     this.ginv.drawImage(Screenprinting.MenuBackgroundRed, 800, 0, 400, 100, null);
/* 281 */     this.ginv.setFont(gameOverFont);
/* 282 */     this.ginv.setColor(Color.black);
/* 283 */     this.ginv.drawString("Crafting", 873, 73);
/* 284 */     this.ginv.setColor(Color.yellow);
/* 285 */     this.ginv.drawString("Crafting", 870, 70);
/*     */ 
/* 287 */     this.ginv.dispose();
/*     */ 
/* 289 */     return this.inventoryImage;
/*     */   }
/*     */ 
/*     */   public BufferedImage getInventoryImage()
/*     */   {
/* 294 */     if (Screenprinting.ItemScreen != null) {
/* 295 */       this.ginv.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
/* 296 */       this.ginv.drawImage(Screenprinting.ItemScreen, 0, 100, 1990, 166, null);
/* 297 */       this.ginv.drawImage(Screenprinting.ItemScreen, 0, 266, 1990, 166, null);
/* 298 */       this.ginv.drawImage(Screenprinting.ItemScreen, 0, 432, 1990, 166, null);
/* 299 */       this.ginv.drawImage(Screenprinting.ItemScreen, 0, 598, 1990, 166, null);
/* 300 */       this.ginv.drawImage(Screenprinting.ItemScreen, 0, 764, 1990, 166, null);
/*     */ 
/* 302 */       this.ginv.drawImage(Inventory.itemImage(Inventory.inventory.get(currentInventoryOnScreen).type), 160, 105, 155, 155, null);
/* 303 */       this.ginv.drawImage(Inventory.itemImage(Inventory.inventory.get(currentInventoryOnScreen + 1).type), 160, 271, 155, 155, null);
/* 304 */       this.ginv.drawImage(Inventory.itemImage(Inventory.inventory.get(currentInventoryOnScreen + 2).type), 160, 437, 155, 155, null);
/* 305 */       this.ginv.drawImage(Inventory.itemImage(Inventory.inventory.get(currentInventoryOnScreen + 3).type), 160, 603, 155, 155, null);
/* 306 */       this.ginv.drawImage(Inventory.itemImage(Inventory.inventory.get(currentInventoryOnScreen + 4).type), 160, 769, 155, 155, null);
/* 307 */       this.ginv.setFont(gameOverFont);
/* 308 */       this.ginv.setColor(Color.BLACK);
/* 309 */       this.ginv.drawString(Inventory.inventory.get(currentInventoryOnScreen).name, 553, 183);
/* 310 */       this.ginv.drawString(Inventory.inventory.get(currentInventoryOnScreen + 1).name, 553, 349);
/* 311 */       this.ginv.drawString(Inventory.inventory.get(currentInventoryOnScreen + 2).name, 553, 515);
/* 312 */       this.ginv.drawString(Inventory.inventory.get(currentInventoryOnScreen + 3).name, 553, 681);
/* 313 */       this.ginv.drawString(Inventory.inventory.get(currentInventoryOnScreen + 4).name, 553, 847);
/* 314 */       this.ginv.setColor(Color.WHITE);
/* 315 */       this.ginv.drawString(Inventory.inventory.get(currentInventoryOnScreen).name, 550, 180);
/* 316 */       this.ginv.drawString(Inventory.inventory.get(currentInventoryOnScreen + 1).name, 550, 346);
/* 317 */       this.ginv.drawString(Inventory.inventory.get(currentInventoryOnScreen + 2).name, 550, 512);
/* 318 */       this.ginv.drawString(Inventory.inventory.get(currentInventoryOnScreen + 3).name, 550, 678);
/* 319 */       this.ginv.drawString(Inventory.inventory.get(currentInventoryOnScreen + 4).name, 550, 844);
/*     */ 
/* 321 */       this.ginv.setFont(smallerGameOverFont);
/* 322 */       this.ginv.setColor(Color.BLACK);
/* 323 */       this.ginv.drawString("Amount: " + Inventory.inventory.get(currentInventoryOnScreen).amount, 553, 238);
/* 324 */       this.ginv.drawString("Amount: " + Inventory.inventory.get(currentInventoryOnScreen + 1).amount, 553, 404);
/* 325 */       this.ginv.drawString("Amount: " + Inventory.inventory.get(currentInventoryOnScreen + 2).amount, 553, 570);
/* 326 */       this.ginv.drawString("Amount: " + Inventory.inventory.get(currentInventoryOnScreen + 3).amount, 553, 736);
/* 327 */       this.ginv.drawString("Amount: " + Inventory.inventory.get(currentInventoryOnScreen + 4).amount, 553, 902);
/* 328 */       this.ginv.setColor(Color.WHITE);
/* 329 */       this.ginv.drawString("Amount: " + Inventory.inventory.get(currentInventoryOnScreen).amount, 550, 235);
/* 330 */       this.ginv.drawString("Amount: " + Inventory.inventory.get(currentInventoryOnScreen + 1).amount, 550, 401);
/* 331 */       this.ginv.drawString("Amount: " + Inventory.inventory.get(currentInventoryOnScreen + 2).amount, 550, 567);
/* 332 */       this.ginv.drawString("Amount: " + Inventory.inventory.get(currentInventoryOnScreen + 3).amount, 550, 733);
/* 333 */       this.ginv.drawString("Amount: " + Inventory.inventory.get(currentInventoryOnScreen + 4).amount, 550, 899);
/*     */ 
/* 335 */       this.ginv.setColor(new Color(30, 30, 30));
/* 336 */       this.ginv.fillRect(1990, 100 + 900 / Inventory.inventory.size() * currentInventoryOnScreen, 10, 4150 / Inventory.inventory.size());
/*     */ 
/* 338 */       this.ginv.drawImage(Screenprinting.MenuBackgroundRed, 0, 0, 400, 100, null);
/* 339 */       this.ginv.setFont(gameOverFont);
/* 340 */       this.ginv.setColor(Color.black);
/* 341 */       this.ginv.drawString("Materials", 73, 73);
/* 342 */       this.ginv.setColor(Color.yellow);
/* 343 */       this.ginv.drawString("Materials", 70, 70);
/* 344 */       this.ginv.drawImage(Screenprinting.MenuBackgroundRed, 400, 0, 400, 100, null);
/* 345 */       this.ginv.setFont(gameOverFont);
/* 346 */       this.ginv.setColor(Color.black);
/* 347 */       this.ginv.drawString("Character", 473, 73);
/* 348 */       this.ginv.setColor(Color.white);
/* 349 */       this.ginv.drawString("Character", 470, 70);
/*     */ 
/* 351 */       this.ginv.drawImage(Screenprinting.MenuBackgroundRed, 800, 0, 400, 100, null);
/* 352 */       this.ginv.setFont(gameOverFont);
/* 353 */       this.ginv.setColor(Color.black);
/* 354 */       this.ginv.drawString("Crafting", 873, 73);
/* 355 */       this.ginv.setColor(Color.white);
/* 356 */       this.ginv.drawString("Crafting", 870, 70);
/*     */ 
/* 358 */       this.ginv.setColor(new Color(200, 200, 100, 150));
/* 359 */       this.ginv.setStroke(new BasicStroke(20.0F));
/* 360 */       this.ginv.drawRect(0, 100 + currentIOS * 166, 1990, 166);
/*     */ 
/* 362 */       this.ginv.dispose();
/*     */ 
/* 364 */       return this.inventoryImage;
/*     */     }
/* 366 */     return null;
/*     */   }
/*     */ 
/*     */   public BufferedImage getMapImage() {
/* 370 */     tileSizeX = this.mapImage.getWidth() / 80;
/* 371 */     tileSizeY = this.mapImage.getHeight() / 50;
/* 372 */     if (tileSizeX > tileSizeY)
/* 373 */       tileSize = tileSizeY;
/*     */     else {
/* 375 */       tileSize = tileSizeX;
/*     */     }
/* 377 */     for (int x = 0; x < 80; x++) {
/* 378 */       for (int y = 0; y < 50; y++) {
/* 379 */         if (Game.finalMap[x][y].equals("X")) {
/* 380 */           this.gmap.setColor(wallColor);
/* 381 */           this.gmap.fillRect(x * tileSize, y * tileSize, tileSize, tileSize);
/* 382 */         } else if (Game.finalMap[x][y].equals("-")) {
/* 383 */           this.gmap.setColor(floorColor);
/* 384 */           this.gmap.fillRect(x * tileSize, y * tileSize, tileSize, tileSize);
/* 385 */         } else if (Game.finalMap[x][y].equals("B")) {
/* 386 */           this.gmap.setColor(doorColor);
/* 387 */           this.gmap.fillRect(x * tileSize, y * tileSize, tileSize, tileSize);
/* 388 */         } else if (Game.finalMap[x][y].equals("D")) {
/* 389 */           this.gmap.setColor(doorColor);
/* 390 */           this.gmap.fillRect(x * tileSize, y * tileSize, tileSize, tileSize);
/* 391 */         } else if (Game.finalMap[x][y].equals("Y")) {
/* 392 */           this.gmap.setColor(floorColor);
/* 393 */           this.gmap.fillRect(x * tileSize, y * tileSize, tileSize, tileSize);
/*     */         }
/* 395 */         if (com.thomas.dungeon.Items.Chests.chestst[(x + y * 80)].isChest) {
/* 396 */           this.gmap.setColor(chestColor);
/* 397 */           this.gmap.fillRect(x * tileSize, y * tileSize, tileSize, tileSize);
/*     */         }
/* 399 */         if ((com.thomas.dungeon.Fog.Fog.fogpppart[(x + y * 80)].fog) && (com.thomas.dungeon.Fog.Fog.fogpppart[(x + y * 80)].wallfog)) {
/* 400 */           this.gmap.setColor(Color.BLACK);
/* 401 */           this.gmap.fillRect(x * tileSize, y * tileSize, tileSize, tileSize);
/*     */         }
/* 403 */         this.gmap.setColor(playerColor);
/* 404 */         this.gmap.fillRect(Player.getPlayer().loc.getX() * tileSize, Player.getPlayer().loc.getY() * tileSize, tileSize, tileSize);
/*     */       }
/*     */     }
/* 407 */     this.gmap.dispose();
/* 408 */     return this.mapImage;
/*     */   }
/*     */ 
/*     */   public BufferedImage getMenuImage() {
/* 412 */     if (Gamehandler.inGameMenu) {
/* 413 */       if (this.menuImage == null) {
/* 414 */         this.menuImage = new BufferedImage(Game.WIDTH * 9 / 10, Game.HEIGHT * 9 / 10, 2);
/*     */       }
/* 416 */       this.g.drawImage(Screenprinting.MenuBackgroundRed, 0, 0, this.menuImage.getWidth(), this.menuImage.getHeight(), null);
/* 417 */       switch (Gamehandler.inGameMenuType) {
/*     */       case 1:
/* 419 */         this.g.drawImage(getMapImage(), 0 + this.menuImage.getWidth() / 16, 0 + this.menuImage.getHeight() / 16, this.menuImage.getWidth() - this.menuImage.getWidth() / 8, this.menuImage.getHeight() - this.menuImage.getHeight() / 8, null);
/* 420 */         break;
/*     */       case 2:
/* 423 */         switch (Gamehandler.inventoryType) {
/*     */         case 0:
/* 425 */           this.g.drawImage(getInventoryImage(), 0 + this.menuImage.getWidth() / 16, 0 + this.menuImage.getHeight() / 16, this.menuImage.getWidth() - this.menuImage.getWidth() / 8, this.menuImage.getHeight() - this.menuImage.getHeight() / 8, null);
/* 426 */           break;
/*     */         case 1:
/* 429 */           this.g.drawImage(getCharacterImage(), 0 + this.menuImage.getWidth() / 16, 0 + this.menuImage.getHeight() / 16, this.menuImage.getWidth() - this.menuImage.getWidth() / 8, this.menuImage.getHeight() - this.menuImage.getHeight() / 8, null);
/* 430 */           break;
/*     */         case 2:
/* 433 */           this.g.drawImage(getCraftingImage(), 0 + this.menuImage.getWidth() / 16, 0 + this.menuImage.getHeight() / 16, this.menuImage.getWidth() - this.menuImage.getWidth() / 8, this.menuImage.getHeight() - this.menuImage.getHeight() / 8, null);
/*     */         }
/*     */         break;
/*     */       }
/* 437 */       this.g.dispose();
/* 438 */       return this.menuImage;
/*     */     }
/* 440 */     this.menuImage = null;
/* 441 */     return null;
/*     */   }
/*     */ }

/* Location:           C:\Users\Thomas\Dropbox\Java source\RPG\RPGGame.jar
 * Qualified Name:     com.thomas.dungeon.ScreenStuff.InGameMenu
 * JD-Core Version:    0.6.2
 */