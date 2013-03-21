/*     */ package com.thomas.dungeon.Entities;
/*     */ 
/*     */ import com.thomas.dungeon.BlockDestroy.BlockDestroy;
/*     */ import com.thomas.dungeon.GameTechnical.Converter;
/*     */ import com.thomas.dungeon.GameTechnical.Game;
/*     */ import com.thomas.dungeon.GameTechnical.Gamehandler;
/*     */ import com.thomas.dungeon.GameTechnical.TileChecker;
/*     */ import com.thomas.dungeon.Items.Chests;
/*     */ import com.thomas.dungeon.Level.Deuren;
/*     */ import com.thomas.dungeon.Level.LevelArrayList;
/*     */ import com.thomas.dungeon.ScreenStuff.Screenprinting;
/*     */ import com.thomas.dungeon.armrupgrades.LevelCalculations;
/*     */ import java.awt.Image;
/*     */ import java.util.Random;
/*     */ 
/*     */ public class Player extends Actor
/*     */ {
/*     */   public static int playerHurtAmount;
/*     */   public static boolean isNextMove;
/*     */   public static int nextMoveDirection;
/*     */   public static long startTime;
/*     */   public static long thisTime;
/*     */   public static double offSetX;
/*     */   public static double offSetY;
/*     */   public static double offSetXoffPlayer;
/*     */   public static double offSetYoffPlayer;
/*     */   public static int directionWalking;
/*     */   public static boolean running;
/*  41 */   public static int timeOneTurn = 150;
/*  42 */   public static int timeOneHit = 100;
/*     */   public static long hittingstartTime;
/*     */   public static long hittingthisTime;
/*     */   public static int directionHitting;
/*     */   public static boolean hitting;
/*  52 */   public static int timeOneHitMob = 100;
/*     */   public static long hittingstartTimeMob;
/*     */   public static long hittingthisTimeMob;
/*     */   public static int directionHittingMob;
/*     */   public static boolean hittingMob;
/*  62 */   public static Random rand = new Random();
/*     */ 
/* 288 */   public Location loc = new Location();
/*     */   private static Player play;
/*     */   public String direction;
/*     */   public boolean isMoving;
/* 295 */   TileChecker chec = new TileChecker();
/* 296 */   public int actortype = 1;
/*     */   public boolean isCarrying;
/*     */   public int isCarryingint;
/*     */   public int health;
/*     */   public int Level;
/*     */   public int XP;
/*     */   public static int hitImage;
/*     */   public static int hitImageMob;
/*     */ 
/*     */   public static void checkForNeedToChangeLevel()
/*     */   {
/*  66 */     if ((getPlayer().loc.getX() == Game.StairLocationX) && (getPlayer().loc.getY() == Game.StairLocationY)) {
/*  67 */       goUpLevel();
/*     */     }
/*  69 */     else if ((Gamehandler.levelLevel != 0) && 
/*  70 */       (getPlayer().loc.getX() == LevelArrayList.allLevels.get(Gamehandler.levelLevel - 1).stairX) && (getPlayer().loc.getY() == LevelArrayList.allLevels.get(Gamehandler.levelLevel - 1).stairY))
/*  71 */       goDownLevel();
/*     */   }
/*     */ 
/*     */   public static Image getHitImageMob()
/*     */   {
/*  77 */     switch (hitImageMob) {
/*     */     case 0:
/*  79 */       return Screenprinting.Hit2;
/*     */     case 1:
/*  81 */       return Screenprinting.Hit1;
/*     */     }
/*  83 */     return Screenprinting.Hit1;
/*     */   }
/*     */ 
/*     */   public static int getMaxHealth()
/*     */   {
/*  88 */     return 200 + getPlayer().Level * (getPlayer().Level - 1) * 20;
/*     */   }
/*     */ 
/*     */   public static int getOffSetX()
/*     */   {
/*  93 */     return (int)offSetX;
/*     */   }
/*     */ 
/*     */   public static int getOffSetY()
/*     */   {
/*  98 */     return (int)offSetY;
/*     */   }
/*     */ 
/*     */   public static Player getPlayer() {
/* 102 */     if (play == null) {
/* 103 */       play = new Player();
/*     */     }
/* 105 */     return play;
/*     */   }
/*     */ 
/*     */   public static void goDownLevel()
/*     */   {
/* 111 */     if (Gamehandler.levelLevel > 0) {
/* 112 */       Gamehandler.levelLevel -= 1;
/* 113 */       Gamehandler.updateLevel();
/* 114 */       Gamehandler.resetAfterNextLevel();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void goUpLevel()
/*     */   {
/* 121 */     Gamehandler.levelLevel += 1;
/* 122 */     Gamehandler.updateLevel();
/* 123 */     Gamehandler.resetAfterNextLevel();
/*     */ 
/* 125 */     System.out.println("Ble");
/*     */   }
/*     */ 
/*     */   public static void hurtPlayer(int amountOfHurt)
/*     */   {
/* 130 */     getPlayer().health -= amountOfHurt;
/* 131 */     System.out.println("Player health: " + getPlayer().health);
/* 132 */     if (getPlayer().health <= 0)
/* 133 */       Gamehandler.setGameOver();
/*     */   }
/*     */ 
/*     */   public static boolean isDoingAnything()
/*     */   {
/* 138 */     if (hitting) {
/* 139 */       return true;
/*     */     }
/* 141 */     if (running) {
/* 142 */       return true;
/*     */     }
/* 144 */     return false;
/*     */   }
/*     */ 
/*     */   public static void makeMoveIfMoveNeedsToBeMade() {
/* 148 */     if (isNextMove)
/*     */     {
/* 150 */       switch (nextMoveDirection) {
/*     */       case 0:
/* 152 */         getPlayer().goUp();
/*     */ 
/* 154 */         break;
/*     */       case 1:
/* 156 */         getPlayer().goRight();
/*     */ 
/* 158 */         break;
/*     */       case 2:
/* 160 */         getPlayer().goDown();
/*     */ 
/* 162 */         break;
/*     */       case 3:
/* 164 */         getPlayer().goLeft();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void removeDirection()
/*     */   {
/* 172 */     isNextMove = false;
/*     */   }
/*     */ 
/*     */   public static void startHitting(int directionv)
/*     */   {
/* 177 */     if (!hitting) {
/* 178 */       hittingstartTime = System.currentTimeMillis();
/* 179 */       directionHitting = directionv;
/* 180 */       hitting = true;
/* 181 */       hitImage = rand.nextInt(2);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void startHittingMob(int directionv)
/*     */   {
/* 189 */     if (!hittingMob) {
/* 190 */       hittingstartTimeMob = System.currentTimeMillis();
/* 191 */       directionHittingMob = directionv;
/* 192 */       hittingMob = true;
/* 193 */       hitImageMob = rand.nextInt(2);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void startWalking(int directionv)
/*     */   {
/* 200 */     if (!running) {
/* 201 */       startTime = System.currentTimeMillis();
/* 202 */       directionWalking = directionv;
/* 203 */       running = true;
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void stopHitting()
/*     */   {
/* 210 */     Gamehandler.nextTurn();
/* 211 */     hittingstartTime = System.currentTimeMillis();
/* 212 */     directionHitting = 0;
/* 213 */     hitting = false;
/*     */   }
/*     */ 
/*     */   public static void stopHittingMob() {
/* 217 */     hittingstartTimeMob = System.currentTimeMillis();
/* 218 */     directionHittingMob = 0;
/* 219 */     hittingMob = false;
/*     */   }
/*     */ 
/*     */   public static void stopWalking() {
/* 223 */     Gamehandler.nextTurn();
/* 224 */     startTime = System.currentTimeMillis();
/* 225 */     directionWalking = 0;
/* 226 */     offSetX = 0.0D;
/* 227 */     offSetY = 0.0D;
/*     */ 
/* 229 */     running = false;
/* 230 */     checkForNeedToChangeLevel();
/*     */   }
/*     */ 
/*     */   public static void updateHitting()
/*     */   {
/* 235 */     if (hitting) {
/* 236 */       hittingthisTime = System.currentTimeMillis() - hittingstartTime;
/* 237 */       if (hittingthisTime >= timeOneHit) {
/* 238 */         stopHitting();
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 245 */     if (hittingMob) {
/* 246 */       hittingthisTimeMob = System.currentTimeMillis() - hittingstartTimeMob;
/* 247 */       if (hittingthisTimeMob >= timeOneHitMob)
/* 248 */         stopHittingMob();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void updateOffSet()
/*     */   {
/* 259 */     if (running) {
/* 260 */       thisTime = System.currentTimeMillis() - startTime;
/* 261 */       if (thisTime >= timeOneTurn)
/* 262 */         stopWalking();
/*     */       else
/* 264 */         switch (directionWalking) {
/*     */         case 0:
/* 266 */           offSetY = timeOneTurn - thisTime;
/* 267 */           break;
/*     */         case 1:
/* 269 */           offSetX = -timeOneTurn + thisTime;
/* 270 */           break;
/*     */         case 2:
/* 273 */           offSetY = -timeOneTurn + thisTime;
/* 274 */           break;
/*     */         case 3:
/* 276 */           offSetX = timeOneTurn - thisTime;
/*     */         default:
/* 278 */           break;
/*     */         }
/*     */     }
/*     */     else {
/* 282 */       offSetY = 0.0D;
/* 283 */       offSetX = 0.0D;
/*     */     }
/*     */   }
/*     */ 
/*     */   public static Image getHitImage()
/*     */   {
/* 309 */     switch (hitImage) {
/*     */     case 0:
/* 311 */       return Screenprinting.Hit2;
/*     */     case 1:
/* 313 */       return Screenprinting.Hit1;
/*     */     }
/* 315 */     return Screenprinting.Hit1;
/*     */   }
/*     */ 
/*     */   public void addDirection(int direction)
/*     */   {
/* 324 */     isNextMove = true;
/* 325 */     nextMoveDirection = direction;
/*     */ 
/* 327 */     if (!running) {
/* 328 */       startWalking(direction);
/* 329 */       System.out.print("Ja.");
/*     */     }
/*     */   }
/*     */ 
/*     */   public void addToXP(int XPtoAdd) {
/* 334 */     getPlayer().XP += XPtoAdd;
/*     */   }
/*     */ 
/*     */   public void carry(int carrying) {
/* 338 */     this.isCarryingint = carrying;
/* 339 */     this.isCarrying = true;
/*     */   }
/*     */ 
/*     */   public void checkLevel() {
/* 343 */     if (XPNeededForLevel(getPlayer().Level + 1) <= getPlayer().XP) {
/* 344 */       getPlayer().Level += 1;
/*     */     }
/* 346 */     playerHurtAmount = LevelCalculations.calculateWeaponDamageAmount() * 10;
/*     */   }
/*     */ 
/*     */   public Image getPlayerImage() {
/* 350 */     if (this.direction != null) {
/* 351 */       if (this.direction.equals("down"))
/* 352 */         return Screenprinting.PlayerDown;
/* 353 */       if (this.direction.equals("up"))
/* 354 */         return Screenprinting.PlayerUp;
/* 355 */       if (this.direction.equals("left")) {
/* 356 */         return Screenprinting.PlayerLeft;
/*     */       }
/* 358 */       return Screenprinting.PlayerRight;
/*     */     }
/*     */ 
/* 361 */     return Screenprinting.PlayerDown;
/*     */   }
/*     */ 
/*     */   public void goDown()
/*     */   {
/* 367 */     if (Gamehandler.getHasTurn() == 0)
/*     */     {
/* 369 */       if ((!isDoingAnything()) && 
/* 370 */         (this.loc.getY() + 1 < 49)) {
/* 371 */         if (TileChecker.isWalkable(this.actortype, this.loc.getX(), this.loc.getY() + 1)) {
/* 372 */           this.loc.setY(this.loc.getY() + 1);
/* 373 */           startWalking(2);
/*     */         }
/*     */ 
/* 376 */         this.direction = "down";
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void goLeft()
/*     */   {
/* 384 */     if ((Gamehandler.getHasTurn() == 0) && 
/* 385 */       (!isDoingAnything()) && 
/* 386 */       (this.loc.getX() - 1 > 0)) {
/* 387 */       if (TileChecker.isWalkable(this.actortype, this.loc.getX() - 1, this.loc.getY())) {
/* 388 */         this.loc.setX(this.loc.getX() - 1);
/* 389 */         startWalking(3);
/*     */       }
/*     */ 
/* 392 */       this.direction = "left";
/*     */     }
/*     */   }
/*     */ 
/*     */   public void goRight()
/*     */   {
/* 400 */     if ((Gamehandler.getHasTurn() == 0) && 
/* 401 */       (!isDoingAnything()) && 
/* 402 */       (this.loc.getX() + 1 < 79)) {
/* 403 */       if (TileChecker.isWalkable(this.actortype, this.loc.getX() + 1, this.loc.getY())) {
/* 404 */         this.loc.setX(this.loc.getX() + 1);
/* 405 */         startWalking(1);
/*     */       }
/*     */ 
/* 408 */       this.direction = "right";
/*     */     }
/*     */   }
/*     */ 
/*     */   public void goUp()
/*     */   {
/* 417 */     if ((Gamehandler.getHasTurn() == 0) && 
/* 418 */       (!isDoingAnything()))
/*     */     {
/* 420 */       if (this.loc.getY() - 1 > 0) {
/* 421 */         if (TileChecker.isWalkable(this.actortype, this.loc.getX(), this.loc.getY() - 1)) {
/* 422 */           this.loc.setY(this.loc.getY() - 1);
/* 423 */           startWalking(0);
/*     */         }
/*     */ 
/* 426 */         this.direction = "up";
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void Heal(int amountToHeal)
/*     */   {
/* 436 */     getPlayer().health += amountToHeal;
/* 437 */     getPlayer();
/* 438 */     if (getPlayer().health > getMaxHealth())
/* 439 */       getPlayer().health = getMaxHealth();
/*     */   }
/*     */ 
/*     */   public void hit()
/*     */   {
/* 444 */     if ((Gamehandler.getHasTurn() == 0) && 
/* 445 */       (!isDoingAnything()))
/* 446 */       switch (Converter.convertDirectionToInt(this.direction)) {
/*     */       case 0:
/* 448 */         if (Mobs.mob[(this.loc.getX() + (this.loc.getY() - 1) * 80)].isMob) {
/* 449 */           Mobs.hurt(this.loc.getX(), this.loc.getY() - 1, playerHurtAmount, 1);
/* 450 */           startHitting(Converter.convertDirectionToInt(this.direction));
/*     */         } else {
/* 452 */           BlockDestroy.hitBlock(this.loc.getX(), this.loc.getY() - 1);
/*     */         }
/*     */ 
/* 456 */         break;
/*     */       case 1:
/* 458 */         if (Mobs.mob[(this.loc.getX() + 1 + this.loc.getY() * 80)].isMob) {
/* 459 */           Mobs.hurt(this.loc.getX() + 1, this.loc.getY(), playerHurtAmount, 1);
/* 460 */           startHitting(Converter.convertDirectionToInt(this.direction));
/*     */         } else {
/* 462 */           BlockDestroy.hitBlock(this.loc.getX() + 1, this.loc.getY());
/*     */         }
/*     */ 
/* 466 */         break;
/*     */       case 2:
/* 468 */         if (Mobs.mob[(this.loc.getX() + (this.loc.getY() + 1) * 80)].isMob) {
/* 469 */           Mobs.hurt(this.loc.getX(), this.loc.getY() + 1, playerHurtAmount, 1);
/* 470 */           startHitting(Converter.convertDirectionToInt(this.direction));
/*     */         } else {
/* 472 */           BlockDestroy.hitBlock(this.loc.getX(), this.loc.getY() + 1);
/*     */         }
/*     */ 
/* 477 */         break;
/*     */       case 3:
/* 479 */         if (Mobs.mob[(this.loc.getX() - 1 + this.loc.getY() * 80)].isMob) {
/* 480 */           Mobs.hurt(this.loc.getX() - 1, this.loc.getY(), playerHurtAmount, 1);
/* 481 */           startHitting(Converter.convertDirectionToInt(this.direction));
/*     */         } else {
/* 483 */           BlockDestroy.hitBlock(this.loc.getX() - 1, this.loc.getY());
/*     */         }
/*     */         break;
/*     */       }
/*     */   }
/*     */ 
/*     */   public void interact()
/*     */   {
/* 495 */     if ((Gamehandler.getHasTurn() == 0) && 
/* 496 */       (!running)) {
/* 497 */       if (this.direction.equals("up")) {
/* 498 */         if (Deuren.getIfDoor(this.loc.getX(), this.loc.getY() - 1)) {
/* 499 */           Deuren.openDoor(this.loc.getX(), this.loc.getY() - 1, false);
/* 500 */           Gamehandler.nextTurn();
/*     */         }
/* 502 */         if (Chests.chestst[(this.loc.getX() + (this.loc.getY() - 1) * 80)].isChest) {
/* 503 */           Chests.openChest(this.loc.getX(), this.loc.getY() - 1);
/* 504 */           Gamehandler.nextTurn();
/*     */         }
/*     */       }
/* 507 */       if (this.direction.equals("down")) {
/* 508 */         if (Deuren.getIfDoor(this.loc.getX(), this.loc.getY() + 1)) {
/* 509 */           Deuren.openDoor(this.loc.getX(), this.loc.getY() + 1, true);
/* 510 */           Gamehandler.nextTurn();
/*     */         }
/* 512 */         if (Chests.chestst[(this.loc.getX() + (this.loc.getY() + 1) * 80)].isChest) {
/* 513 */           Chests.openChest(this.loc.getX(), this.loc.getY() + 1);
/* 514 */           Gamehandler.nextTurn();
/*     */         }
/*     */       }
/* 517 */       if (this.direction.equals("left")) {
/* 518 */         if (Deuren.getIfDoor(this.loc.getX() - 1, this.loc.getY())) {
/* 519 */           Deuren.openDoor(this.loc.getX() - 1, this.loc.getY(), false);
/* 520 */           Gamehandler.nextTurn();
/*     */         }
/* 522 */         if (Chests.chestst[(this.loc.getX() - 1 + this.loc.getY() * 80)].isChest) {
/* 523 */           Chests.openChest(this.loc.getX() - 1, this.loc.getY());
/* 524 */           Gamehandler.nextTurn();
/*     */         }
/*     */       }
/* 527 */       if (this.direction.equals("right")) {
/* 528 */         if (Deuren.getIfDoor(this.loc.getX() + 1, this.loc.getY())) {
/* 529 */           Deuren.openDoor(this.loc.getX() + 1, this.loc.getY(), true);
/* 530 */           Gamehandler.nextTurn();
/*     */         }
/* 532 */         if (Chests.chestst[(this.loc.getX() + 1 + this.loc.getY() * 80)].isChest) {
/* 533 */           Chests.openChest(this.loc.getX() + 1, this.loc.getY());
/* 534 */           Gamehandler.nextTurn();
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void skipTurn()
/*     */   {
/* 542 */     if ((Gamehandler.getHasTurn() == 0) && 
/* 543 */       (!running))
/* 544 */       Gamehandler.nextTurn();
/*     */   }
/*     */ 
/*     */   public void stopCarrying()
/*     */   {
/* 551 */     this.isCarrying = false;
/*     */   }
/*     */ 
/*     */   public int XPNeededForLevel(int level) {
/* 555 */     return level * (level - 1) * 500;
/*     */   }
/*     */ 
/*     */   public int XPNeededForNextLevel() {
/* 559 */     return XPNeededForLevel(getPlayer().Level + 1);
/*     */   }
/*     */ 
/*     */   public int XPNeededForThisLevel() {
/* 563 */     return XPNeededForLevel(getPlayer().Level);
/*     */   }
/*     */ }

/* Location:           C:\Users\Thomas\Dropbox\Java source\RPG\RPGGame.jar
 * Qualified Name:     com.thomas.dungeon.Entities.Player
 * JD-Core Version:    0.6.2
 */