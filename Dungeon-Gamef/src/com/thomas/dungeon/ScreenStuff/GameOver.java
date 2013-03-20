/*    */ package com.thomas.dungeon.ScreenStuff;
/*    */ 
/*    */ import com.thomas.dungeon.GameTechnical.Game;
/*    */ import java.awt.Color;
/*    */ import java.awt.Font;
/*    */ import java.awt.FontMetrics;
/*    */ import java.awt.Graphics2D;
/*    */ import java.awt.RenderingHints;
/*    */ import java.awt.image.BufferedImage;
/*    */ import java.util.Random;
/*    */ 
/*    */ public class GameOver
/*    */ {
/* 16 */   public static Font gameOverFont = new Font("Dialog", 1, 30);
/*    */ 
/* 18 */   public static BufferedImage gameOverImage = new BufferedImage(Game.WIDTH, Game.HEIGHT, 2);
/* 19 */   public static Graphics2D g = (Graphics2D)gameOverImage.getGraphics();
/*    */ 
/* 21 */   public static Random rand = new Random();
/*    */ 
/*    */   public static BufferedImage getGameOverImage() {
/* 24 */     if (Screenprinting.MBSSinglePlayer != null) {
/* 25 */       g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
/* 26 */       g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
/* 27 */       g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
/*    */ 
/* 29 */       g.drawImage(Screenprinting.MenuBackground, 0, 0, Game.WIDTH, Game.HEIGHT, null);
/*    */ 
/* 31 */       g.setFont(gameOverFont);
/* 32 */       g.setColor(Color.BLACK);
/* 33 */       drawCenteredString("Game Over, press ESC to start over", Game.WIDTH, Game.HEIGHT, g);
/* 34 */       g.setColor(new Color(59, 11, 11));
/* 35 */       drawCenteredString("Game Over, press ESC to start over", Game.WIDTH + 1, Game.HEIGHT + 1, g);
/*    */     }
/*    */ 
/* 38 */     return gameOverImage;
/*    */   }
/*    */ 
/*    */   public static void drawCenteredString(String s, int w, int h, Graphics2D g)
/*    */   {
/* 43 */     FontMetrics fm = g.getFontMetrics();
/* 44 */     int x = (w - fm.stringWidth(s)) / 2;
/* 45 */     int y = fm.getAscent() + (h - (fm.getAscent() + fm.getDescent())) / 2;
/* 46 */     g.drawString(s, x, y);
/*    */   }
/*    */ }

/* Location:           C:\Users\Thomas\Dropbox\Java source\RPG\RPGGame.jar
 * Qualified Name:     com.thomas.dungeon.ScreenStuff.GameOver
 * JD-Core Version:    0.6.2
 */