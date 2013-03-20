/*    */ package com.thomas.dungeon.carrying;
/*    */ 
/*    */ public class Buyable
/*    */ {
/*    */   public int[] items;
/*    */   public int hasAmountOf;
/*    */   public String name;
/*    */   public int ItemType;
/*    */ 
/*    */   public Buyable(int[] g, String named)
/*    */   {
/* 12 */     this.items = g;
/* 13 */     this.name = named;
/*    */   }
/*    */ 
/*    */   public Buyable(int[] g, String named, int i) {
/* 17 */     this.items = g;
/* 18 */     this.name = named;
/*    */   }
/*    */ }

/* Location:           C:\Users\Thomas\Dropbox\Java source\RPG\RPGGame.jar
 * Qualified Name:     com.thomas.dungeon.carrying.Buyable
 * JD-Core Version:    0.6.2
 */