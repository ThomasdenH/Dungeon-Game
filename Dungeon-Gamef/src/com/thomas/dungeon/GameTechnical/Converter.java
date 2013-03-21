/*    */ package com.thomas.dungeon.GameTechnical;
/*    */ 
/*    */ public class Converter
/*    */ {
/*    */   public static int convertDirectionToInt(String direction)
/*    */   {
/*  7 */     if (direction.equals("up"))
/*  8 */       return 0;
/*  9 */     if (direction.equals("right"))
/* 10 */       return 1;
/* 11 */     if (direction.equals("down")) {
/* 12 */       return 2;
/*    */     }
/* 14 */     return 3;
/*    */   }
/*    */ 
/*    */   public static String convertDirectionToString(int direction)
/*    */   {
/* 21 */     if (direction == 0)
/* 22 */       return "up";
/* 23 */     if (direction == 1)
/* 24 */       return "right";
/* 25 */     if (direction == 2) {
/* 26 */       return "down";
/*    */     }
/* 28 */     return "left";
/*    */   }
/*    */ 
/*    */   public static int convertYDirectionToDirection(int YDirection)
/*    */   {
/* 35 */     switch (YDirection) {
/*    */     case 1:
/* 37 */       return 2;
/*    */     case -1:
/* 39 */       return 0;
/*    */     case 0:
/* 41 */     }System.out.println("convertYDirectionToDirection(int YDirection) verkeerde direction");
/* 42 */     return 0;
/*    */   }
/*    */ 
/*    */   public static int convertXDirectionToDirection(int XDirection)
/*    */   {
/* 47 */     switch (XDirection) {
/*    */     case 1:
/* 49 */       return 1;
/*    */     case -1:
/* 51 */       return 3;
/*    */     case 0:
/* 53 */     }System.out.println("convertXDirectionToDirection(int XDirection) verkeerde direction");
/* 54 */     return 0;
/*    */   }
/*    */ 
/*    */   public static int convertMobTypeStringToInt(String mobtype)
/*    */   {
/* 59 */     if (mobtype.equals("Trombie")) {
/* 60 */       return 2;
/*    */     }
/* 62 */     if (mobtype.equals("Ghost")) {
/* 63 */       return 3;
/*    */     }
/* 65 */     return 0;
/*    */   }
/*    */ }

/* Location:           C:\Users\Thomas\Dropbox\Java source\RPG\RPGGame.jar
 * Qualified Name:     com.thomas.dungeon.GameTechnical.Converter
 * JD-Core Version:    0.6.2
 */