/*    */ package com.thomas.dungeon.Level;
/*    */ 
/*    */ public class LevelNiveau
/*    */ {
/*    */   public String[][] levelString;
/*    */   public String[][] torches;
/*    */   public String[][] variations;
/*  9 */   public int[][] blockHealth = new int[80][50];
/*    */   public int stairX;
/*    */   public int stairY;
/*    */ 
/*    */   public LevelNiveau(String[][] s)
/*    */   {
/* 14 */     this.levelString = s;
/*    */   }
/*    */ }

/* Location:           C:\Users\Thomas\Dropbox\Java source\RPG\RPGGame.jar
 * Qualified Name:     com.thomas.dungeon.Level.LevelNiveau
 * JD-Core Version:    0.6.2
 */