/*     */ package com.thomas.dungeon.GameTechnical;
/*     */ import com.thomas.dungeon.Entities.Player;
/*     */ import com.thomas.dungeon.Level.Deuren;
/*     */ import java.util.Random;
/*     */ 
/*     */ public class TileChecker
/*     */ {
/*  12 */   static Random rand = new Random();
/*     */   public static int locRelativeToPlayerX;
/*     */   public static int locRelativeToPlayerY;
/*     */   public static boolean randomMove;
/*     */   public static int direction;
/*     */   public static int XDirection;
/*     */   public static int YDirection;
/*     */   static int amountAround;
/*     */ 
/*     */   public static int directionIfNearPlayer(int LocationX, int LocationY)
/*     */   {
/*  25 */     if (Player.getPlayer().loc.getX() < LocationX)
/*  26 */       XDirection = -1;
/*  27 */     else if (Player.getPlayer().loc.getX() > LocationX)
/*  28 */       XDirection = 1;
/*     */     else {
/*  30 */       XDirection = 0;
/*     */     }
/*     */ 
/*  33 */     if (Player.getPlayer().loc.getY() < LocationY)
/*  34 */       YDirection = -1;
/*  35 */     else if (Player.getPlayer().loc.getY() > LocationY)
/*  36 */       YDirection = 1;
/*     */     else {
/*  38 */       YDirection = 0;
/*     */     }
/*     */ 
/*  41 */     if (XDirection == 0)
/*  42 */       return Converter.convertYDirectionToDirection(YDirection);
/*  43 */     if (YDirection == 0) {
/*  44 */       return Converter.convertXDirectionToDirection(XDirection);
/*     */     }
/*  46 */     if (rand.nextBoolean()) {
/*  47 */       return Converter.convertYDirectionToDirection(YDirection);
/*     */     }
/*  49 */     return Converter.convertXDirectionToDirection(XDirection);
/*     */   }
/*     */ 
/*     */   public static boolean equalsUp(int x, int y)
/*     */   {
/*  56 */     if (Game.finalMap[x][y].equals("X")) {
/*  57 */       return true;
/*     */     }
/*  59 */     if (Game.finalMap[x][y].equals("x")) {
/*  60 */       return true;
/*     */     }
/*  62 */     return false;
/*     */   }
/*     */ 
/*     */   public static boolean isWalkable(int act, int LocX, int LocY) {
/*  66 */     if ((LocX < 0) || (LocX >= 80) || (LocY < 0) || (LocY >= 50)) {
/*  67 */       return false;
/*     */     }
/*     */ 
/*  70 */     switch (act)
/*     */     {
/*     */     case 0:
/*  73 */       break;
/*     */     case 1:
/*  76 */       if (com.thomas.dungeon.Entities.Mobs.mob[(LocX + LocY * 80)].isMob) {
/*  77 */         return false;
/*     */       }
/*  79 */       if (com.thomas.dungeon.Items.Chests.chestst[(LocX + LocY * 80)].isChest) {
/*  80 */         return false;
/*     */       }
/*  82 */       if (Game.finalMap[LocX][LocY] == "-") {
/*  83 */         return true;
/*     */       }
/*  85 */       if (Deuren.getSingleDoor(LocX, LocY).open) {
/*  86 */         return true;
/*     */       }
/*     */ 
/*     */       break;
/*     */     case 2:
/*  93 */       if ((LocX == Player.getPlayer().loc.getX()) && (LocY == Player.getPlayer().loc.getY())) {
/*  94 */         return false;
/*     */       }
/*  96 */       if (com.thomas.dungeon.Entities.Mobs.mob[(LocX + LocY * 80)].isMob) {
/*  97 */         return false;
/*     */       }
/*  99 */       if (com.thomas.dungeon.Items.Chests.chestst[(LocX + LocY * 80)].isChest) {
/* 100 */         return false;
/*     */       }
/* 102 */       if (Game.finalMap[LocX][LocY] == "-") {
/* 103 */         return true;
/*     */       }
/* 105 */       if (Deuren.getSingleDoor(LocX, LocY).open) {
/* 106 */         return true;
/*     */       }
/*     */ 
/*     */       break;
/*     */     case 3:
/* 111 */       if ((LocX == Player.getPlayer().loc.getX()) && (LocY == Player.getPlayer().loc.getY())) {
/* 112 */         return false;
/*     */       }
/* 114 */       if (com.thomas.dungeon.Entities.Mobs.mob[(LocX + LocY * 80)].isMob) {
/* 115 */         return false;
/*     */       }
/* 117 */       if (com.thomas.dungeon.Items.Chests.chestst[(LocX + LocY * 80)].isChest) {
/* 118 */         return false;
/*     */       }
/* 120 */       if (Game.finalMap[LocX][LocY] == "-") {
/* 121 */         return true;
/*     */       }
/* 123 */       if (Deuren.getIfDoor(LocX, LocY)) {
/* 124 */         return true;
/*     */       }
/*     */       break;
/*     */     case 4:
/* 128 */       if ((LocX == Player.getPlayer().loc.getX()) && (LocY == Player.getPlayer().loc.getY())) {
/* 129 */         return false;
/*     */       }
/* 131 */       if (com.thomas.dungeon.Entities.Mobs.mob[(LocX + LocY * 80)].isMob) {
/* 132 */         return false;
/*     */       }
/* 134 */       if (com.thomas.dungeon.Items.Chests.chestst[(LocX + LocY * 80)].isChest) {
/* 135 */         return false;
/*     */       }
/* 137 */       if (Game.finalMap[LocX][LocY] == "-") {
/* 138 */         return true;
/*     */       }
/* 140 */       if (Deuren.getSingleDoor(LocX, LocY).open) {
/* 141 */         return true;
/*     */       }
/*     */       break;
/*     */     case 5:
/* 145 */       if ((LocX == Player.getPlayer().loc.getX()) && (LocY == Player.getPlayer().loc.getY())) {
/* 146 */         return false;
/*     */       }
/* 148 */       if (com.thomas.dungeon.Entities.Mobs.mob[(LocX + LocY * 80)].isMob) {
/* 149 */         return false;
/*     */       }
/* 151 */       if (com.thomas.dungeon.Items.Chests.chestst[(LocX + LocY * 80)].isChest) {
/* 152 */         return false;
/*     */       }
/* 154 */       if (Game.finalMap[LocX][LocY] == "-") {
/* 155 */         return true;
/*     */       }
/* 157 */       if (Deuren.getSingleDoor(LocX, LocY).open) {
/* 158 */         return true;
/*     */       }
/*     */       break;
/*     */     default:
/* 162 */       System.out.println("TileChecker.walkable error");
/*     */     }
/*     */ 
/* 166 */     return false;
/*     */   }
/*     */ 
/*     */   public static boolean isWalkableDirection(int actor, int LocX, int LocY, int direction) {
/* 170 */     switch (direction) {
/*     */     case 0:
/* 172 */       return isWalkable(actor, LocX, LocY - 1);
/*     */     case 1:
/* 174 */       return isWalkable(actor, LocX + 1, LocY);
/*     */     case 2:
/* 176 */       return isWalkable(actor, LocX, LocY + 1);
/*     */     case 3:
/* 178 */       return isWalkable(actor, LocX - 1, LocY);
/*     */     }
/* 180 */     return true;
/*     */   }
/*     */ 
/*     */   public static boolean isNextToPlayer(int LocationX, int LocationY)
/*     */   {
/* 186 */     if ((LocationX + 1 == Player.getPlayer().loc.getX()) && (LocationY == Player.getPlayer().loc.getY())) {
/* 187 */       return true;
/*     */     }
/* 189 */     if ((LocationX - 1 == Player.getPlayer().loc.getX()) && (LocationY == Player.getPlayer().loc.getY())) {
/* 190 */       return true;
/*     */     }
/* 192 */     if ((LocationX == Player.getPlayer().loc.getX()) && (LocationY + 1 == Player.getPlayer().loc.getY())) {
/* 193 */       return true;
/*     */     }
/* 195 */     if ((LocationX == Player.getPlayer().loc.getX()) && (LocationY - 1 == Player.getPlayer().loc.getY())) {
/* 196 */       return true;
/*     */     }
/* 198 */     return false;
/*     */   }
/*     */ 
/*     */   public static boolean tileAround(int LocX, int LocY, String tile, int direction)
/*     */   {
/* 204 */     switch (direction) {
/*     */     case 0:
/*     */       try {
/* 207 */         if (Game.finalMap[LocX][(LocY - 1)].equals(tile))
/* 208 */           return true;
/*     */       }
/*     */       catch (Exception e)
/*     */       {
/* 212 */         return false;
/*     */       }
/*     */     case 1:
/*     */       try {
/* 216 */         if (Game.finalMap[(LocX + 1)][LocY].equals(tile))
/* 217 */           return true;
/*     */       }
/*     */       catch (Exception e)
/*     */       {
/* 221 */         return false;
/*     */       }
/*     */     case 2:
/*     */       try {
/* 225 */         if (Game.finalMap[LocX][(LocY + 1)].equals(tile))
/* 226 */           return true;
/*     */       }
/*     */       catch (Exception e)
/*     */       {
/* 230 */         return false;
/*     */       }
/*     */     case 3:
/*     */       try {
/* 234 */         if (Game.finalMap[(LocX - 1)][LocY].equals(tile))
/* 235 */           return true;
/*     */       }
/*     */       catch (Exception e)
/*     */       {
/* 239 */         return false;
/*     */       }
/*     */     }
/*     */ 
/* 243 */     return false;
/*     */   }
/*     */ 
/*     */   public static int amountTileAround(int LocX, int LocY, String tile)
/*     */   {
/* 249 */     amountAround = 0;
/* 250 */     for (int e = 0; e < 4; e++) {
/* 251 */       if (tileAround(e, e, tile, e)) {
/* 252 */         amountAround += 1;
/*     */       }
/*     */     }
/* 255 */     return amountAround;
/*     */   }
/*     */ 
/*     */   public static boolean tileAround(int LocX, int LocY, String tile, int direction, String[][] map)
/*     */   {
/*     */     try {
/* 261 */       switch (direction) {
/*     */       case 0:
/* 263 */         if (map[LocX][(LocY - 1)].equals(tile)) {
/* 264 */           return true;
/*     */         }
/*     */         break;
/*     */       case 1:
/* 268 */         if (map[(LocX + 1)][LocY].equals(tile)) {
/* 269 */           return true;
/*     */         }
/*     */         break;
/*     */       case 2:
/* 273 */         if (map[LocX][(LocY + 1)].equals(tile)) {
/* 274 */           return true;
/*     */         }
/*     */         break;
/*     */       case 3:
/* 278 */         if (map[(LocX - 1)][LocY].equals(tile)) {
/* 279 */           return true;
/*     */         }
/*     */         break;
/*     */       }
/*     */     }
/*     */     catch (Exception localException)
/*     */     {
/*     */     }
/* 287 */     return false;
/*     */   }
/*     */ 
/*     */   public static int amountTileAround(int LocX, int LocY, String tile, String[][] map) {
/* 291 */     amountAround = 0;
/* 292 */     for (int e = 0; e < 4; e++) {
/* 293 */       if (tileAround(LocX, LocY, tile, e, map)) {
/* 294 */         amountAround += 1;
/*     */       }
/*     */     }
/* 297 */     return amountAround;
/*     */   }
/*     */ }

/* Location:           C:\Users\Thomas\Dropbox\Java source\RPG\RPGGame.jar
 * Qualified Name:     com.thomas.dungeon.GameTechnical.TileChecker
 * JD-Core Version:    0.6.2
 */