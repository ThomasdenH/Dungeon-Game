/*    */ package com.thomas.dungeon.Level;
/*    */ 
/*    */ public class Room
/*    */ {
/*    */   int XSize;
/*    */   int YSize;
/*    */   int XLocation;
/*    */   int YLocation;
/*    */ 
/*    */   public Room(int Xsize, int Ysize, int Xlocation, int Ylocation)
/*    */   {
/* 11 */     this.XSize = Xsize;
/* 12 */     this.YSize = Ysize;
/* 13 */     this.XLocation = Xlocation;
/* 14 */     this.YLocation = Ylocation;
/*    */   }
/*    */ 
/*    */   public void setXSize(int Xsize) {
/* 18 */     this.XSize = Xsize;
/*    */   }
/*    */ 
/*    */   public int getXSize() {
/* 22 */     return this.XSize;
/*    */   }
/*    */ 
/*    */   public void setYSize(int Ysize) {
/* 26 */     this.YSize = Ysize;
/*    */   }
/*    */ 
/*    */   public int getYSize() {
/* 30 */     return this.YSize;
/*    */   }
/*    */ 
/*    */   public void setXLocation(int Xlocation) {
/* 34 */     this.XLocation = Xlocation;
/*    */   }
/*    */ 
/*    */   public int getXLocation() {
/* 38 */     return this.XLocation;
/*    */   }
/*    */ 
/*    */   public void setYLocation(int Ylocation) {
/* 42 */     this.YLocation = Ylocation;
/*    */   }
/*    */ 
/*    */   public int getYLocation() {
/* 46 */     return this.YLocation;
/*    */   }
/*    */ }

/* Location:           C:\Users\Thomas\Dropbox\Java source\RPG\RPGGame.jar
 * Qualified Name:     com.thomas.dungeon.Level.Room
 * JD-Core Version:    0.6.2
 */