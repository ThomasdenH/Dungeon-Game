/*    */ package com.thomas.dungeon.Level;
/*    */ 
/*    */ public class Deur
/*    */ {
/*    */   public int locationX;
/*    */   public int locationY;
/*    */   public int XofY;
/*    */   public boolean deurOfNiet;
/*    */   public boolean open;
/*    */   public boolean geopendNaar;
/*    */ 
/*    */   public int getLocationX()
/*    */   {
/*  9 */     return this.locationX;
/*    */   }
/*    */ 
/*    */   public void setLocationX(int locationX) {
/* 13 */     this.locationX = locationX;
/*    */   }
/*    */ 
/*    */   public int getLocationY() {
/* 17 */     return this.locationY;
/*    */   }
/*    */ 
/*    */   public void setLocationY(int locationY) {
/* 21 */     this.locationY = locationY;
/*    */   }
/*    */ 
/*    */   public int getXofY() {
/* 25 */     return this.XofY;
/*    */   }
/*    */ 
/*    */   public void setXofY(int xofY) {
/* 29 */     this.XofY = xofY;
/*    */   }
/*    */ 
/*    */   public boolean isDeurOfNiet() {
/* 33 */     return this.deurOfNiet;
/*    */   }
/*    */ 
/*    */   public void setDeurOfNiet(boolean deurOfNiet) {
/* 37 */     this.deurOfNiet = deurOfNiet;
/*    */   }
/*    */ 
/*    */   public boolean isOpen() {
/* 41 */     return this.open;
/*    */   }
/*    */ 
/*    */   public void setOpen(boolean open, boolean geopendNaar) {
/* 45 */     this.open = open;
/* 46 */     this.geopendNaar = geopendNaar;
/*    */   }
/*    */ }

/* Location:           C:\Users\Thomas\Dropbox\Java source\RPG\RPGGame.jar
 * Qualified Name:     com.thomas.dungeon.Level.Deur
 * JD-Core Version:    0.6.2
 */