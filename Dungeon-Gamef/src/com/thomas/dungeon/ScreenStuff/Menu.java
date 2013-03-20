/*    */ package com.thomas.dungeon.ScreenStuff;
/*    */ 
/*    */ import com.thomas.dungeon.GameTechnical.Game;
/*    */ import com.thomas.dungeon.GameTechnical.Gamehandler;
/*    */ import java.awt.Color;
/*    */ import java.awt.Graphics2D;
/*    */ import java.awt.Image;
/*    */ import java.awt.RenderingHints;
/*    */ import java.awt.image.BufferedImage;
/*    */ import java.util.Random;
/*    */ 
/*    */ public class Menu
/*    */ {
/* 14 */   public static int buttonSelected = 0;
/* 15 */   public static int aantalButtons = 3;
/*    */ 
/* 17 */   public Random rand = new Random();
/*    */ 
/* 19 */   public static BufferedImage menuImage = new BufferedImage(Game.WIDTH, Game.HEIGHT, 2);
/*    */ 
/* 48 */   public Graphics2D g = (Graphics2D)menuImage.getGraphics();
/*    */ 
/* 54 */   public Border border = new Border();
/*    */ 
/*    */   public static void buttonClicked()
/*    */   {
/* 22 */     switch (buttonSelected) {
/*    */     case 0:
/* 24 */       Gamehandler.menu = false;
/* 25 */       Gamehandler.singlePlayerGame = true;
/* 26 */       Gamehandler.configureSinglePlayerGame();
/*    */     }
/*    */   }
/*    */ 
/*    */   public static void buttonToTheLeft()
/*    */   {
/* 33 */     if (buttonSelected == 0)
/* 34 */       buttonSelected = aantalButtons - 1;
/*    */     else
/* 36 */       buttonSelected -= 1;
/*    */   }
/*    */ 
/*    */   public static void buttonToTheRight()
/*    */   {
/* 41 */     if (buttonSelected == aantalButtons - 1)
/* 42 */       buttonSelected = 0;
/*    */     else
/* 44 */       buttonSelected += 1;
/*    */   }
/*    */ 
/*    */   public BufferedImage getMenuImage()
/*    */   {
/* 57 */     if (Screenprinting.MBSSinglePlayer != null) {
/* 58 */       this.g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
/* 59 */       this.g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
/* 60 */       this.g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
/*    */ 
/* 62 */       this.g.drawImage(Screenprinting.MenuBackground, 0, 0, Game.WIDTH, Game.HEIGHT, null);
/*    */ 
/* 64 */       double imageScale = 1.333333333333333D;
/* 65 */       int absoluteImageScaleX = (int)(Screenprinting.MBSSinglePlayer.getWidth(null) / imageScale);
/* 66 */       int absoluteImageScaleY = (int)(Screenprinting.MBSSinglePlayer.getHeight(null) / imageScale);
/* 67 */       int YLocation = Game.HEIGHT / 5 * 4;
/* 68 */       int XLocation = Game.WIDTH / aantalButtons + (Game.WIDTH - (Game.WIDTH / 3 * 2 + absoluteImageScaleX)) / 2;
/*    */ 
/* 70 */       switch (buttonSelected)
/*    */       {
/*    */       case 0:
/* 73 */         this.g.drawImage(Screenprinting.MBSSinglePlayer, XLocation * 0, YLocation, absoluteImageScaleX, absoluteImageScaleY, null);
/* 74 */         this.g.drawImage(Screenprinting.MBMultiPlayer, XLocation * 1, YLocation, absoluteImageScaleX, absoluteImageScaleY, null);
/* 75 */         this.g.drawImage(Screenprinting.MBOptions, XLocation * 2, YLocation, absoluteImageScaleX, absoluteImageScaleY, null);
/*    */ 
/* 77 */         break;
/*    */       case 1:
/* 79 */         this.g.drawImage(Screenprinting.MBSinglePlayer, XLocation * 0 * 0, YLocation, absoluteImageScaleX, absoluteImageScaleY, null);
/* 80 */         this.g.drawImage(Screenprinting.MBSMultiPlayer, XLocation * 1, YLocation, absoluteImageScaleX, absoluteImageScaleY, null);
/* 81 */         this.g.drawImage(Screenprinting.MBOptions, XLocation * 2, YLocation, absoluteImageScaleX, absoluteImageScaleY, null);
/*    */ 
/* 83 */         break;
/*    */       case 2:
/* 85 */         this.g.drawImage(Screenprinting.MBSinglePlayer, XLocation * 0, YLocation, absoluteImageScaleX, absoluteImageScaleY, null);
/* 86 */         this.g.drawImage(Screenprinting.MBMultiPlayer, XLocation * 1, YLocation, absoluteImageScaleX, absoluteImageScaleY, null);
/* 87 */         this.g.drawImage(Screenprinting.MBSOptions, XLocation * 2, YLocation, absoluteImageScaleX, absoluteImageScaleY, null);
/*    */       }
/*    */ 
/* 92 */       if (Screenprinting.MenuBackground == null) {
/* 93 */         this.g.setColor(Color.BLUE);
/* 94 */         this.g.fillRect(0, 0, 200, 200);
/*    */       }
/*    */     }
/*    */ 
/* 98 */     return menuImage;
/*    */   }
/*    */ }

/* Location:           C:\Users\Thomas\Dropbox\Java source\RPG\RPGGame.jar
 * Qualified Name:     com.thomas.dungeon.ScreenStuff.Menu
 * JD-Core Version:    0.6.2
 */