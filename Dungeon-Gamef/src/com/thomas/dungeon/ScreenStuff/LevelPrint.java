/*    */ package com.thomas.dungeon.ScreenStuff;
/*    */ 
/*    */ import com.thomas.dungeon.Entities.Player;
/*    */ import com.thomas.dungeon.GameTechnical.Game;
/*    */ import com.thomas.dungeon.GameTechnical.Gamehandler;
/*    */ import java.awt.Color;
/*    */ import java.awt.Dimension;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Graphics2D;
/*    */ import java.awt.RenderingHints;
/*    */ import java.awt.image.BufferedImage;
/*    */ import javax.swing.JPanel;
/*    */ 
/*    */ public class LevelPrint extends JPanel
/*    */   implements Runnable
/*    */ {
/*    */   private static final long serialVersionUID = -5961498593133477762L;
/* 22 */   public static int xWIDTH = Game.WIDTH;
/* 23 */   public static int yHEIGHT = Game.HEIGHT;
/*    */ 
/* 72 */   public Player pla = new Player();
/*    */ 
/*    */   public LevelPrint()
/*    */   {
/* 26 */     Menu menu = new Menu();
/* 27 */     setPreferredSize(new Dimension(menu.getMenuImage().getWidth(), menu.getMenuImage().getHeight()));
/* 28 */     setFocusable(true);
/*    */   }
/*    */ 
/*    */   public void update(Graphics g)
/*    */   {
/* 34 */     Dimension dim = new Dimension(xWIDTH, yHEIGHT);
/* 35 */     Graphics2D g2 = (Graphics2D)g;
/* 36 */     super.paintComponent(g2);
/* 37 */     super.setSize(dim);
/*    */ 
/* 39 */     g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
/* 40 */     g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
/* 41 */     g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
/*    */ 
/* 43 */     g.clearRect(0, 0, xWIDTH, yHEIGHT);
/* 44 */     g.setColor(Color.BLACK);
/* 45 */     g.fillRect(0, 0, xWIDTH, yHEIGHT);
/*    */ 
/* 47 */     if (Gamehandler.menu) {
/* 48 */       Menu menu = new Menu();
/* 49 */       g2.drawImage(menu.getMenuImage(), 0, 0, Game.WIDTH, Game.HEIGHT, null);
/* 50 */     } else if (Gamehandler.singlePlayerGame) {
/* 51 */       InformationPictures infPic = new InformationPictures();
/* 52 */       Screenprinting screp = new Screenprinting();
/* 53 */       g2.drawImage(infPic.getLeftImage(), 0, 0, null);
/* 54 */       g2.drawImage(screp.generateIt(), (xWIDTH - screp.generateIt().getWidth()) / 2, yHEIGHT / 2 - screp.generateIt().getHeight() / 2, null);
/* 55 */     } else if (Gamehandler.gameOver) {
/* 56 */       g2.drawImage(GameOver.getGameOverImage(), 0, 0, Game.WIDTH, Game.HEIGHT, null);
/*    */     }
/* 58 */     if (Gamehandler.inGameMenu) {
/* 59 */       InGameMenu igm = new InGameMenu();
/* 60 */       g2.drawImage(igm.getMenuImage(), xWIDTH / 20, yHEIGHT / 20, null);
/*    */     }
/* 62 */     g.dispose();
/*    */   }
/*    */ 
/*    */   public void paint(Graphics g)
/*    */   {
/* 68 */     update(g);
/*    */   }
/*    */ 
/*    */   public void run()
/*    */   {
/* 77 */     repaint();
/*    */   }
/*    */ }

/* Location:           C:\Users\Thomas\Dropbox\Java source\RPG\RPGGame.jar
 * Qualified Name:     com.thomas.dungeon.ScreenStuff.LevelPrint
 * JD-Core Version:    0.6.2
 */