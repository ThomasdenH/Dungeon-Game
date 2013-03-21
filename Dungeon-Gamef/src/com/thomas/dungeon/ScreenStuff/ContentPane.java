/*    */ package com.thomas.dungeon.ScreenStuff;
/*    */ 
/*    */ import java.awt.BorderLayout;
/*    */ import java.awt.Dimension;
/*    */ import javax.swing.JPanel;
/*    */ 
/*    */ public class ContentPane extends JPanel
/*    */ {
/*    */   private static final long serialVersionUID = -3166411575530412438L;
/* 16 */   public LevelPrint l = new LevelPrint();
/*    */ 
/*    */   public ContentPane() {
/* 19 */     Menu menu = new Menu();
/* 20 */     setPreferredSize(new Dimension(menu.getMenuImage().getWidth(), menu.getMenuImage().getHeight()));
/* 21 */     setLayout(new BorderLayout());
/* 22 */     add(this.l, "Center");
/*    */   }
/*    */ 
/*    */   public void reepaint()
/*    */   {
/* 27 */     this.l.requestFocus();
/* 28 */     this.l.repaint();
/* 29 */     Thread thread = new Thread(new LevelPrint());
/*    */   }
/*    */ }
