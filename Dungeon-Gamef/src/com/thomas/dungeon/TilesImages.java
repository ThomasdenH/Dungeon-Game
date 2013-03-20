/*    */ package com.thomas.dungeon;
/*    */ 
/*    */ import java.awt.image.BufferedImage;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import javax.imageio.ImageIO;
/*    */ 
/*    */ public class TilesImages
/*    */ {
/*    */   public BufferedImage getMuurImage()
/*    */   {
/* 11 */     BufferedImage MuurImage = null;
/*    */ 
/* 13 */     File muur = new File("C:\\Users\\Thomas\\workspace\\RPG\\src\\Sprites\\Muur.png");
/*    */     try {
/* 15 */       MuurImage = ImageIO.read(muur);
/*    */     } catch (IOException e) {
/* 17 */       e.printStackTrace();
/*    */     }
/* 19 */     return MuurImage;
/*    */   }
/*    */ }

/* Location:           C:\Users\Thomas\Dropbox\Java source\RPG\RPGGame.jar
 * Qualified Name:     com.thomas.dungeon.TilesImages
 * JD-Core Version:    0.6.2
 */