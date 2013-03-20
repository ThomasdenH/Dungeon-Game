/*    */ package com.thomas.dungeon.BlockDestroy;
/*    */ 
/*    */ import com.thomas.dungeon.Entities.Player;
/*    */ import com.thomas.dungeon.GameTechnical.Converter;
/*    */ import com.thomas.dungeon.Items.Items;
/*    */ import com.thomas.dungeon.armrupgrades.ItemLevels;
/*    */ 
/*    */ public class BlockDestroy
/*    */ {
/*    */   public static void DestroyBlock(int x, int y)
/*    */   {
/* 13 */     if (((com.thomas.dungeon.Level.LevelNiveau)com.thomas.dungeon.Level.LevelArrayList.allLevels.get(com.thomas.dungeon.GameTechnical.Gamehandler.levelLevel)).levelString[x][y].equals("X")) {
/* 14 */       Items.setItemOnRandomOffSet(x, y, 5);
/*    */     }
/* 16 */     if (((com.thomas.dungeon.Level.LevelNiveau)com.thomas.dungeon.Level.LevelArrayList.allLevels.get(com.thomas.dungeon.GameTechnical.Gamehandler.levelLevel)).levelString[x][y].equals("x")) {
/* 17 */       Items.setItemOnRandomOffSet(x, y, 1);
/*    */     }
/* 19 */     ((com.thomas.dungeon.Level.LevelNiveau)com.thomas.dungeon.Level.LevelArrayList.allLevels.get(com.thomas.dungeon.GameTechnical.Gamehandler.levelLevel)).levelString[x][y] = "-";
/*    */   }
/*    */ 
/*    */   public static void hitBlock(int x, int y)
/*    */   {
/* 24 */     if (((com.thomas.dungeon.Level.LevelNiveau)com.thomas.dungeon.Level.LevelArrayList.allLevels.get(com.thomas.dungeon.GameTechnical.Gamehandler.levelLevel)).levelString[x][y] != "-")
/* 25 */       Player.startHitting(Converter.convertDirectionToInt(Player.getPlayer().direction));
/* 26 */     ((com.thomas.dungeon.Level.LevelNiveau)com.thomas.dungeon.Level.LevelArrayList.allLevels.get(com.thomas.dungeon.GameTechnical.Gamehandler.levelLevel)).blockHealth[x][y] -= ItemLevels.currentBlockLevel * 2;
/* 27 */     if (((com.thomas.dungeon.Level.LevelNiveau)com.thomas.dungeon.Level.LevelArrayList.allLevels.get(com.thomas.dungeon.GameTechnical.Gamehandler.levelLevel)).blockHealth[x][y] <= 0)
/* 28 */       DestroyBlock(x, y);
/*    */   }
/*    */ }

/* Location:           C:\Users\Thomas\Dropbox\Java source\RPG\RPGGame.jar
 * Qualified Name:     com.thomas.dungeon.BlockDestroy.BlockDestroy
 * JD-Core Version:    0.6.2
 */