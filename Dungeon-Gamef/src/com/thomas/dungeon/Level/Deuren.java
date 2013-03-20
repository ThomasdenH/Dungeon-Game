/*    */ package com.thomas.dungeon.Level;
/*    */ 
/*    */ public class Deuren
/*    */ {
/*  6 */   private static Deur[] deur = new Deur[4080];
/*    */ 
/*    */   public static void DeurenSettings()
/*    */   {
/* 10 */     for (int i = 0; i < 80; i++) {
/* 11 */       for (int j = 0; j < 50; j++)
/*    */       {
/* 13 */         deur[(i + j * 80)] = new Deur();
/*    */       }
/*    */ 
/*    */     }
/*    */ 
/* 18 */     for (int i = 0; i < 80; i++)
/* 19 */       for (int j = 0; j < 50; j++)
/*    */       {
/* 21 */         deur[(i + j * 80)].locationX = i;
/* 22 */         deur[(i + j * 80)].locationY = j;
/*    */       }
/*    */   }
/*    */ 
/*    */   public static void setDoor(int locationXt, int locationYt, int overX1ofOverY2)
/*    */   {
/* 30 */     deur[(locationXt + locationYt * 80)].setXofY(overX1ofOverY2);
/* 31 */     deur[(locationXt + locationYt * 80)].setDeurOfNiet(true);
/*    */   }
/*    */ 
/*    */   public static void openDoor(int locationXt, int locationYt, boolean igeopendNaar) {
/* 35 */     deur[(locationXt + locationYt * 80)].open = true;
/* 36 */     deur[(locationXt + locationYt * 80)].geopendNaar = igeopendNaar;
/*    */   }
/*    */ 
/*    */   public static Deur[] getDoor() {
/* 40 */     return deur;
/*    */   }
/*    */ 
/*    */   public static Deur getSingleDoor(int locationXx, int locationYy) {
/* 44 */     return deur[(locationXx + locationYy * 80)];
/*    */   }
/*    */ 
/*    */   public static boolean getIfDoor(int locationXx, int locationYy) {
/* 48 */     return deur[(locationXx + locationYy * 80)].deurOfNiet;
/*    */   }
/*    */ 
/*    */   public static boolean getIfDoorIsOpen(int locationXt, int locationYt) {
/* 52 */     return deur[(locationXt + locationYt * 80)].open;
/*    */   }
/*    */ }

/* Location:           C:\Users\Thomas\Dropbox\Java source\RPG\RPGGame.jar
 * Qualified Name:     com.thomas.dungeon.Level.Deuren
 * JD-Core Version:    0.6.2
 */