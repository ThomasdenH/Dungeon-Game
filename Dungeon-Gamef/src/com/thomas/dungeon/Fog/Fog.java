/*     */ package com.thomas.dungeon.Fog;
/*     */ 
/*     */ import com.thomas.dungeon.Entities.Location;
/*     */ import com.thomas.dungeon.Entities.Player;
/*     */ import com.thomas.dungeon.Level.Deuren;
/*     */ 
/*     */ public class Fog
/*     */ {
/*   9 */   public static Fogpart[] fogpppart = new Fogpart[4080];
/*     */ 
/*     */   public static void resetFog() {
/*  12 */     for (int x = 0; x < 80; x++)
/*  13 */       for (int y = 0; y < 50; y++) {
/*  14 */         fogpppart[(x + y * 80)] = new Fogpart();
/*  15 */         fogpppart[(x + y * 80)].fog = true;
/*  16 */         fogpppart[(x + y * 80)].halffog = false;
/*  17 */         fogpppart[(x + y * 80)].wallfog = true;
/*     */       }
/*     */   }
/*     */ 
/*     */   public static void removeOneTileFog(int LocX, int LocY)
/*     */   {
/*  25 */     fogpppart[(LocX + LocY * 80)].fog = false;
/*  26 */     setHalfFog();
/*     */   }
/*     */ 
/*     */   public static void setHalfFog() {
/*  30 */     for (int x = 0; x < 80; x++)
/*  31 */       for (int y = 0; y < 50; y++) {
/*  32 */         if (!fogpppart[(x + y * 80)].fog) {
/*  33 */           fogpppart[(x + y * 80)].wallfog = false;
/*     */         }
/*  35 */         fogpppart[(x + y * 80)].halffog = false;
/*  36 */         if ((fogpppart[(x + y * 80)].fog) || (fogpppart[(x + y * 80)].wallfog))
/*     */           try {
/*  38 */             if (!fogpppart[(x - 1 + y * 80)].fog)
/*  39 */               fogpppart[(x + y * 80)].halffog = true;
/*  40 */             else if (!fogpppart[(x + 1 + y * 80)].fog)
/*  41 */               fogpppart[(x + y * 80)].halffog = true;
/*  42 */             else if (!fogpppart[(x + (y - 1) * 80)].fog)
/*  43 */               fogpppart[(x + y * 80)].halffog = true;
/*  44 */             else if (!fogpppart[(x + (y + 1) * 80)].fog) {
/*  45 */               fogpppart[(x + y * 80)].halffog = true;
/*     */             }
/*  47 */             if (!fogpppart[(x - 1 + y * 80)].wallfog)
/*  48 */               fogpppart[(x + y * 80)].halffog = true;
/*  49 */             else if (!fogpppart[(x + 1 + y * 80)].wallfog)
/*  50 */               fogpppart[(x + y * 80)].halffog = true;
/*  51 */             else if (!fogpppart[(x + (y - 1) * 80)].wallfog)
/*  52 */               fogpppart[(x + y * 80)].halffog = true;
/*  53 */             else if (!fogpppart[(x + (y + 1) * 80)].wallfog) {
/*  54 */               fogpppart[(x + y * 80)].halffog = true;
/*     */             }
/*  56 */             if ((fogpppart[(x + y * 80)].halffog) && 
/*  57 */               (Deuren.getIfDoorIsOpen(x, y)))
/*  58 */               fogpppart[(x + y * 80)].halffog = false;
/*     */           }
/*     */           catch (Exception localException)
/*     */           {
/*     */           }
/*     */       }
/*     */   }
/*     */ 
/*     */   public static void removeFogOnScreen()
/*     */   {
/*     */     try
/*     */     {
/*  71 */       removeOneTileFog(Player.getPlayer().loc.getX(), Player.getPlayer().loc.getY());
/*  72 */       for (int b = 0; b < 200; b++)
/*  73 */         for (int x = 0; x < 80; x++)
/*  74 */           for (int y = 0; y < 50; y++)
/*  75 */             if (!fogpppart[(x + y * 80)].fog)
/*  76 */               for (int n = 0; n < 3; n++)
/*  77 */                 for (int m = 0; m < 3; m++) {
/*  78 */                   if (com.thomas.dungeon.GameTechnical.Game.finalMap[(x - 1 + n)][(y - 1 + m)].equals("X")) {
/*  79 */                     fogpppart[(x - 1 + n + (y - 1 + m) * 80)].wallfog = false;
/*  80 */                     fogpppart[(x - 1 + n + (y - 1 + m) * 80)].halffog = false;
/*     */                   }
/*  82 */                   if ((com.thomas.dungeon.GameTechnical.Game.finalMap[(x - 1 + n)][(y - 1 + m)].equals("B")) && 
/*  83 */                     (!Deuren.getIfDoorIsOpen(x - 1 + n, y - 1 + m))) {
/*  84 */                     fogpppart[(x - 1 + n + (y - 1 + m) * 80)].wallfog = false;
/*  85 */                     fogpppart[(x - 1 + n + (y - 1 + m) * 80)].halffog = false;
/*     */                   }
/*     */ 
/*  88 */                   if ((com.thomas.dungeon.GameTechnical.Game.finalMap[(x - 1 + n)][(y - 1 + m)].equals("D")) && 
/*  89 */                     (!Deuren.getIfDoorIsOpen(x - 1 + n, y - 1 + m))) {
/*  90 */                     fogpppart[(x - 1 + n + (y - 1 + m) * 80)].wallfog = false;
/*  91 */                     fogpppart[(x - 1 + n + (y - 1 + m) * 80)].halffog = false;
/*     */                   }
/*     */ 
/*  94 */                   if (com.thomas.dungeon.GameTechnical.Game.finalMap[(x - 1 + n)][(y - 1 + m)].equals("-")) {
/*  95 */                     fogpppart[(x - 1 + n + (y - 1 + m) * 80)].fog = false;
/*  96 */                     fogpppart[(x - 1 + n + (y - 1 + m) * 80)].wallfog = false;
/*     */                   }
/*     */                 }
/*     */     }
/*     */     catch (Exception localException)
/*     */     {
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void fogChange()
/*     */   {
/* 113 */     removeFogOnScreen();
/*     */   }
/*     */ 
/*     */   public static boolean isNoFogNextTo(int LocX, int LocY)
/*     */   {
/* 118 */     if (LocX == 0) {
/* 119 */       return false;
/*     */     }
/* 121 */     if (LocX == 79) {
/* 122 */       return false;
/*     */     }
/* 124 */     if (LocY == 0) {
/* 125 */       return false;
/*     */     }
/* 127 */     if (LocY == 49) {
/* 128 */       return false;
/*     */     }
/* 130 */     if (!fogpppart[(LocX - 1 + LocY * 80)].fog)
/* 131 */       return true;
/* 132 */     if (!fogpppart[(LocX + 1 + LocY * 80)].fog)
/* 133 */       return true;
/* 134 */     if (!fogpppart[(LocX + (LocY - 1) * 80)].fog)
/* 135 */       return true;
/* 136 */     if (!fogpppart[(LocX + (LocY + 1) * 80)].fog) {
/* 137 */       return true;
/*     */     }
/* 139 */     return false;
/*     */   }
/*     */ }

/* Location:           C:\Users\Thomas\Dropbox\Java source\RPG\RPGGame.jar
 * Qualified Name:     com.thomas.dungeon.Fog.Fog
 * JD-Core Version:    0.6.2
 */