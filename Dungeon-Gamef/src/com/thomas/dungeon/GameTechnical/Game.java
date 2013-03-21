/*     */ package com.thomas.dungeon.GameTechnical;
/*     */ 
/*     */ import com.thomas.dungeon.Entities.Actor;
/*     */ import com.thomas.dungeon.Entities.Player;
/*     */ import com.thomas.dungeon.Inventory.Inventory;
/*     */ import com.thomas.dungeon.Level.Deuren;
/*     */ import com.thomas.dungeon.Level.plaatsVoorDeur;
/*     */ import com.thomas.dungeon.ScreenStuff.ContentPane;
/*     */ import com.thomas.dungeon.ScreenStuff.LevelPrint;
/*     */ import com.thomas.dungeon.ScreenStuff.Menu;
/*     */ import com.thomas.dungeon.ScreenStuff.Screenprinting;
/*     */ import com.thomas.dungeon.armrupgrades.ItemLevels;
/*     */ import com.thomas.dungeon.carrying.Crafting;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Canvas;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.KeyListener;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.MouseListener;
/*     */ import java.util.Random;
/*     */ import javax.swing.JFrame;
/*     */ 
/*     */ public class Game extends Canvas
/*     */   implements Runnable
/*     */ {
/*     */   private static final long serialVersionUID = 2159972266342698357L;
/*  33 */   public static final Toolkit tool = Toolkit.getDefaultToolkit();
/*  34 */   public static final Dimension dim = tool.getScreenSize();
/*  35 */   public static final int HEIGHT = dim.height - dim.height / 10;
/*  36 */   public static final int WIDTH = dim.width - dim.width / 10;
/*     */   public static final int framesPerSeconde = 25;
/*  38 */   public Actor pl1 = new Player();
/*  39 */   public static Random rand = new Random();
/*     */ 
/*  41 */   public boolean running = false;
/*     */   public static JFrame frame;
/*  68 */   public static LevelPrint l = new LevelPrint();
/*  69 */   public static ContentPane cp = new ContentPane();
/*     */ 
/*  71 */   public static Menu menu = new Menu();
/*     */ 
/*  73 */   public static Screenprinting scre = new Screenprinting();
/*     */ 
/*  75 */   public static String[][] finalMap = new String[80][50];
/*     */   public static String[][] finalTorches;
/*     */   public static int[][] finalDark;
/*     */   public static String[][] finalVariations;
/*  81 */   public static plaatsVoorDeur[] EntityThings = new plaatsVoorDeur[4080];
/*     */ 
/*  83 */   public static Player pla = Player.getPlayer();
/*     */ 
/*  85 */   public static double FRAMES_PER_SECOND = 25.0D;
/*     */ 
/*  87 */   public static double SKIP_TICKS = 1000.0D / FRAMES_PER_SECOND;
/*     */ 
/*  89 */   public static double sleep_time = 0.0D;
/*     */ 
/*  91 */   public static boolean game_is_running = true;
/*     */   public static double tickbegin;
/*     */   public static double ticknow;
/*     */   public static double next_game_tick;
/*     */   public static int StairLocationX;
/*     */   public static int StairLocationY;
/*     */ 
/*     */   public static void EntitySet()
/*     */   {
/*  99 */     Deuren.DeurenSettings();
/* 100 */     for (int x = 0; x < 80; x++)
/* 101 */       for (int y = 0; y < 50; y++) {
/* 102 */         if (finalMap[x][y] == "D") {
/* 103 */           Deuren.setDoor(x, y, 1);
/*     */         }
/* 105 */         if (finalMap[x][y] == "B")
/* 106 */           Deuren.setDoor(x, y, 2);
/*     */       }
/*     */   }
/*     */ 
/*     */   public static synchronized void Inittialize()
/*     */   {
/* 115 */     cp.setFocusable(true);
/* 116 */     cp.addKeyListener(new KeyListener()
/*     */     {
/*     */       @Override
public void keyPressed(KeyEvent e) {
/* 119 */         if (e.getKeyCode() == 68) {
/* 120 */           if (Gamehandler.menu) {
/* 121 */             Menu.buttonToTheRight();
/* 122 */           } else if (Gamehandler.singlePlayerGame) {
/* 123 */             if (!Gamehandler.inGameMenu) {
/* 124 */               Player.getPlayer().goRight();
/*     */             }
/* 126 */             if (Gamehandler.inGameMenu) {
/* 127 */               Gamehandler.inGameMenuRight();
/*     */             }
/*     */           }
/*     */         }
/*     */ 
/* 132 */         if (e.getKeyCode() == 65) {
/* 133 */           if (Gamehandler.menu) {
/* 134 */             Menu.buttonToTheLeft();
/* 135 */           } else if (Gamehandler.singlePlayerGame) {
/* 136 */             if (!Gamehandler.inGameMenu) {
/* 137 */               Player.getPlayer().goLeft();
/*     */             }
/* 139 */             if (Gamehandler.inGameMenu) {
/* 140 */               Gamehandler.inGameMenuLeft();
/*     */             }
/*     */           }
/*     */         }
/*     */ 
/* 145 */         if ((e.getKeyCode() == 87) && 
/* 146 */           (!Gamehandler.menu))
/*     */         {
/* 148 */           if (Gamehandler.singlePlayerGame) {
/* 149 */             if (!Gamehandler.inGameMenu) {
/* 150 */               Player.getPlayer().goUp();
/*     */             }
/* 152 */             if (Gamehandler.inGameMenu) {
/* 153 */               Gamehandler.inGameMenuUp();
/*     */             }
/*     */           }
/*     */         }
/*     */ 
/* 158 */         if ((e.getKeyCode() == 83) && 
/* 159 */           (!Gamehandler.menu))
/*     */         {
/* 161 */           if (Gamehandler.singlePlayerGame) {
/* 162 */             if (!Gamehandler.inGameMenu) {
/* 163 */               Player.getPlayer().goDown();
/*     */             }
/* 165 */             if (Gamehandler.inGameMenu) {
/* 166 */               Gamehandler.inGameMenuDown();
/*     */             }
/*     */           }
/*     */         }
/*     */ 
/* 171 */         if (e.getKeyCode() == 76) {
/* 172 */           if (Gamehandler.menu) {
/* 173 */             Menu.buttonClicked();
/* 174 */           } else if (Gamehandler.singlePlayerGame) {
/* 175 */             if (!Gamehandler.inGameMenu) {
/* 176 */               Game.pla.interact();
/*     */             }
/* 178 */             if (Gamehandler.inGameMenu) {
/* 179 */               switch (Gamehandler.inventoryType) {
/*     */               case 1:
/* 181 */                 ItemLevels.buyUpgrade();
/* 182 */                 break;
/*     */               case 2:
/* 184 */                 Crafting.buyItems(Gamehandler.crafting + Gamehandler.crafting3);
/*     */               }
/*     */             }
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/* 191 */         if (e.getKeyCode() == 75) {
/* 192 */           if (Gamehandler.menu)
/* 193 */             Menu.buttonClicked();
/* 194 */           else if ((Gamehandler.singlePlayerGame) && 
/* 195 */             (!Gamehandler.inGameMenu)) {
/* 196 */             Game.pla.hit();
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/* 201 */         if ((e.getKeyCode() == 77) && 
/* 202 */           (Gamehandler.inGameMenuAble)) {
/* 203 */           Gamehandler.setInGameMenu(1);
/*     */         }
/*     */ 
/* 207 */         if ((e.getKeyCode() == 73) && 
/* 208 */           (Gamehandler.inGameMenuAble)) {
/* 209 */           Gamehandler.setInGameMenu(2);
/*     */         }
/*     */ 
/* 214 */         if (e.getKeyCode() == 32) {
/* 215 */           Game.pla.skipTurn();
/*     */         }
/* 217 */         if (e.getKeyCode() == 27) {
/* 218 */           Gamehandler.goBackToMenu();
/*     */         }
/* 220 */         if (e.getKeyCode() == 72) {
/* 221 */           Player.getPlayer().Heal(10000000);
/* 222 */           Inventory.addAmountOfItem(Game.rand.nextInt(3), 1);
/*     */         }
/*     */       }
/*     */ 
/*     */       @Override
public void keyReleased(KeyEvent e)
/*     */       {
/*     */       }
/*     */ 
/*     */       @Override
public void keyTyped(KeyEvent e)
/*     */       {
/*     */       }
/*     */     });
/* 234 */     cp.addMouseListener(new MouseListener()
/*     */     {
/*     */       @Override
public void mouseClicked(MouseEvent arg0)
/*     */       {
/*     */       }
/*     */ 
/*     */       @Override
public void mouseEntered(MouseEvent arg0)
/*     */       {
/*     */       }
/*     */ 
/*     */       @Override
public void mouseExited(MouseEvent arg0)
/*     */       {
/*     */       }
/*     */ 
/*     */       @Override
public void mousePressed(MouseEvent arg0)
/*     */       {
/*     */       }
/*     */ 
/*     */       @Override
public void mouseReleased(MouseEvent arg0)
/*     */       {
/*     */       }
/*     */     });
/* 253 */     cp.requestFocus();
/*     */ 
/* 255 */     Gamehandler.updateLevel();
/*     */ 
/* 257 */     pla.loc.setX(39);
/* 258 */     pla.loc.setY(25);
/*     */ 
/* 260 */     scre.printMap();
/*     */ 
/* 262 */     EntitySet();
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 268 */     Game game = new Game();
/*     */ 
/* 270 */     frame = new JFrame("Title");
/* 271 */     frame.setDefaultCloseOperation(3);
/* 272 */     frame.setLayout(new BorderLayout());
/* 273 */     frame.add(cp, "Center");
/* 274 */     frame.setResizable(false);
/* 275 */     frame.pack();
/* 276 */     frame.setVisible(true);
/* 277 */     frame.setLocationRelativeTo(null);
/*     */ 
/* 280 */     Inittialize();
/* 281 */     game.start();
/*     */   }
/*     */ 
/*     */   @Override
public void run()
/*     */   {
/* 290 */     while (this.running) {
/* 291 */       tick();
/* 292 */       runStep();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void runStep()
/*     */   {
/* 301 */     ticknow = System.currentTimeMillis();
/* 302 */     if (ticknow - tickbegin > SKIP_TICKS)
/*     */     {
/* 304 */       cp.repaint();
/* 305 */       tickbegin = System.currentTimeMillis();
/*     */     } else {
/* 307 */       sleep_time = ticknow - tickbegin;
/*     */       try {
/* 309 */         Thread.sleep((long) sleep_time);
/*     */       }
/*     */       catch (InterruptedException e) {
/* 312 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */     try {
/* 316 */       Thread.sleep(20L);
/*     */     }
/*     */     catch (InterruptedException e) {
/* 319 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void start()
/*     */   {
/* 326 */     this.running = true;
/* 327 */     tickbegin = System.currentTimeMillis();
/*     */ 
/* 329 */     new Thread(this).start();
/*     */   }
/*     */ 
/*     */   public void stop() {
/* 333 */     this.running = false;
/*     */   }
/*     */ 
/*     */   public void tick() {
/* 337 */     cp.repaint();
/*     */   }
/*     */ }

/* Location:           C:\Users\Thomas\Dropbox\Java source\RPG\RPGGame.jar
 * Qualified Name:     com.thomas.dungeon.GameTechnical.Game
 * JD-Core Version:    0.6.2
 */