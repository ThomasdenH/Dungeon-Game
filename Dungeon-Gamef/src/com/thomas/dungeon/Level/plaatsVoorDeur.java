/*    */ package com.thomas.dungeon.Level;
/*    */ 
/*    */ import java.util.Random;
/*    */ 
/*    */ public class plaatsVoorDeur
/*    */ {
/* 26 */   Random rand = new Random();
/*    */   int LocatieX;
/*    */   int LocatieY;
/*    */   int richting;
/*    */   int aantalOpEenRij;
/*    */ 
/*    */   public void setX(int x)
/*    */   {
/* 34 */     this.aantalOpEenRij = 0;
/* 35 */     this.LocatieX = x;
/*    */   }
/*    */ 
/*    */   public void setY(int y)
/*    */   {
/* 40 */     this.LocatieY = y;
/*    */   }
/*    */ 
/*    */   public void setRichting(int richting)
/*    */   {
/* 45 */     this.richting = richting;
/*    */   }
/*    */ 
/*    */   public void aantalOpEenRijPlusEen() {
/* 49 */     this.aantalOpEenRij += 1;
/*    */   }
/*    */ 
/*    */   public void behoudEenDeur(String[][] map)
/*    */   {
/* 54 */     int deurTeBehouden = this.rand.nextInt(this.aantalOpEenRij);
/*    */ 
/* 56 */     if (this.richting == 1) {
/* 57 */       for (int deuren = 0; deuren <= this.aantalOpEenRij; deuren++) {
/* 58 */         map[(this.LocatieX + deuren)][this.LocatieY] = "X";
/*    */       }
/*    */ 
/* 61 */       map[(this.LocatieX + deurTeBehouden)][this.LocatieY] = "B";
/*    */     }
/*    */ 
/* 65 */     if (this.richting == 2) {
/* 66 */       for (int deuren = 0; deuren <= this.aantalOpEenRij; deuren++) {
/* 67 */         map[this.LocatieX][(this.LocatieY + deuren)] = "X";
/*    */       }
/*    */ 
/* 70 */       map[this.LocatieX][(this.LocatieY + deurTeBehouden)] = "D";
/*    */     }
/*    */   }
/*    */ 
/*    */   public int getAOER()
/*    */   {
/* 77 */     return this.aantalOpEenRij;
/*    */   }
/*    */ }

/* Location:           C:\Users\Thomas\Dropbox\Java source\RPG\RPGGame.jar
 * Qualified Name:     com.thomas.dungeon.Level.plaatsVoorDeur
 * JD-Core Version:    0.6.2
 */