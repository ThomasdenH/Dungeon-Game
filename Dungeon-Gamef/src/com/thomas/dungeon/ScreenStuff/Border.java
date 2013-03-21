/*    */ package com.thomas.dungeon.ScreenStuff;
/*    */ 
/*    */ import java.awt.Graphics2D;
/*    */ import java.awt.image.BufferedImage;
/*    */ 
/*    */ public class Border
/*    */ {
/*    */   public BufferedImage borderImage;
/*    */ 
/*    */   public BufferedImage getBorder(int SizeX, int SizeY)
/*    */   {
/* 11 */     this.borderImage = new BufferedImage(SizeX, SizeY, 2);
/* 12 */     Graphics2D g = (Graphics2D)this.borderImage.getGraphics();
/* 13 */     g.drawImage(Screenprinting.BorderLinksBoven, 0, 0, null);
/* 14 */     g.drawImage(Screenprinting.BorderBoven, Screenprinting.BorderBoven.getWidth(null), 0, SizeX - Screenprinting.BorderBoven.getWidth(null) * 2, 0, null);
/* 15 */     g.drawImage(Screenprinting.BorderRechtsBoven, SizeX - Screenprinting.BorderBoven.getWidth(null), 0, null);
/* 16 */     g.drawImage(Screenprinting.BorderRechts, SizeX - Screenprinting.BorderRechts.getWidth(null), SizeY - Screenprinting.BorderRechts.getHeight(null), Screenprinting.BorderRechts.getWidth(null), 
/* 17 */       SizeX - Screenprinting.BorderRechts.getHeight(null) * 2, null);
/* 18 */     g.drawImage(Screenprinting.BorderRechtsOnder, SizeX - Screenprinting.BorderRechts.getWidth(null), SizeY - Screenprinting.BorderRechts.getHeight(null), null);
/*    */ 
/* 20 */     g.dispose();
/* 21 */     return this.borderImage;
/*    */   }
/*    */ }

/* Location:           C:\Users\Thomas\Dropbox\Java source\RPG\RPGGame.jar
 * Qualified Name:     com.thomas.dungeon.ScreenStuff.Border
 * JD-Core Version:    0.6.2
 */