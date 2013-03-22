package com.thomas.dungeon.Entities;

import com.thomas.dungeon.GameTechnical.Converter;
import com.thomas.dungeon.GameTechnical.Gamehandler;
import com.thomas.dungeon.GameTechnical.TileChecker;
import com.thomas.dungeon.Items.Items;
import com.thomas.dungeon.ScreenStuff.Screenprinting;
import java.awt.Image;
import java.util.Random;

/*     */public class Mobs
/*     */{
public static Mob[] mob;
	/* 17 */public static Random rand = new Random();
static int localDirection;
static int mobType;
private static boolean moved;
public static int timesTried;
public static int mobsOnLevel;
public static long startTime;
public static long thisTime;
	/* 31 */public static int turnTime = 1000;
public static int ghostOnLevel;
public static boolean spawndone;
public static int spawntries;
public static boolean walking;


public static void allMobsTurn()
{
		for (int i = 0; i < 80; i++) {
			for (int j = 0; j < 50; j++) {
				if ((Mobs.mob[(i + j * 80)].isMob) && (!Mobs.mob[(i + j * 80)].alReadyMoved)) {
					Mobs.mobTurn(i, j);
				}
			}
		}

		Gamehandler.nextTurn();
		for (int i = 0; i < 80; i++) {
			for (int j = 0; j < 50; j++) {
				Mobs.mob[(i + j * 80)].alReadyMoved = false;
			}
		}
	}


public static void startWalking()
{
		/* 45 */if (!walking) {
			/* 46 */startTime = System.currentTimeMillis();
			/* 47 */walking = true;
			/* 48 */for (int x = 0; x < 80; x++)
				/* 49 */for (int y = 0; y < 50; y++) {
					/* 50 */mob[(x + y * 80)].offSetX = 0;
					/* 51 */mob[(x + y * 80)].offSetY = 0;
				}
		}
	}


public static void stopWalking()
{
		/* 59 */walking = false;
		/* 60 */startTime = System.currentTimeMillis();
		/* 61 */for (int x = 0; x < 80; x++) {
			/* 62 */for (int y = 0; y < 50; y++) {
				/* 63 */mob[(x + y * 80)].offSetX = 0;
				/* 64 */mob[(x + y * 80)].offSetY = 0;
			}
		}
		/* 67 */Gamehandler.nextTurn();
	}


public static void checkForNeedToSpawnMob() {
		/* 71 */for (int i = 0; i < 2; i++) {
			/* 72 */if (mobsOnLevel < 40 + Player.getPlayer().Level) {
				/* 73 */spawndone = false;
				/* 74 */spawntries = 0;
			do {
					/* 76 */if (rand.nextInt(2) == 0) {
						/* 77 */spawnMob(2, rand.nextInt(80), rand.nextInt(50));
						/* 78 */spawndone = true;
					}
					/* 80 */if (rand.nextInt(6) == 0) {
						/* 81 */spawnMob(3, rand.nextInt(80), rand.nextInt(50));
						/* 82 */spawndone = true;
					}
					/* 84 */if (rand.nextInt(4) == 0) {
						/* 85 */spawnMob(4, rand.nextInt(80), rand.nextInt(50));
						/* 86 */spawndone = true;
					}
					/* 88 */if (rand.nextInt(5) == 0) {
						/* 89 */spawnMob(5, rand.nextInt(80), rand.nextInt(50));
						/* 90 */spawndone = true;
					}
					/* 92 */spawntries += 1;
					/* 93 */} while ((!spawndone) && (spawntries < 400));
			}
		
			/* 96 */if (ghostOnLevel < 5)
		{
				/* 98 */spawnMob(3, rand.nextInt(80), rand.nextInt(50));
			}
		}
	}


public static void despawnDied()
{
		/* 108 */for (int i = 0; i < 80; i++)
			/* 109 */for (int j = 0; j < 50; j++)
				/* 110 */if ((mob[(i + j * 80)].isMob) &&
				/* 111 */(mob[(i + j * 80)].health <= 0)) {
					/* 112 */despawnMob(i, j);
					/* 113 */switch (mob[(i + j * 80)].latestHitBy) {
				case 1:
						/* 115 */returnXP(mob[(i + j * 80)].Mobtype, 1);
						/* 116 */break;
				}
				
					/* 121 */Items.setItemOnRandomOffSet(i, j, getDrop(mob[(i + j * 80)].Mobtype));
				}
	}


private static int getDrop(String mobtype2)
{
		/* 130 */if (mobtype2.equals("Trombie")) {
			/* 131 */return 2;
		}
		/* 133 */if (mobtype2.equals("Fly")) {
			/* 134 */return 8;
		}
		/* 136 */if (mobtype2.equals("Ghost")) {
			/* 137 */return 3;
		}
		/* 139 */if (mobtype2.equals("Vampire")) {
			/* 140 */return 4;
		}
		/* 142 */return 0;
	}


private static void despawnMob(int i, int j) {
		/* 146 */mob[(i + j * 80)].isMob = false;
		/* 147 */mobsOnLevel -= 1;
	}


public static Image getMobImage(int locationX, int locationY)
{
		/* 153 */if (mob[(locationX + locationY * 80)].Mobtype.equals("Trombie")) {
			/* 154 */switch (mob[(locationX + locationY * 80)].direction) {
		case 0:
				/* 156 */return Screenprinting.TrombieLeft;
			case 1:
				/* 158 */return Screenprinting.TrombieLeft;
			case 2:
				/* 160 */return Screenprinting.TrombieLeft;
			case 3:
				/* 162 */return Screenprinting.TrombieLeft;
			}
		}
		/* 165 */if (mob[(locationX + locationY * 80)].Mobtype.equals("Ghost")) {
			/* 166 */switch (mob[(locationX + locationY * 80)].direction) {
		case 0:
				/* 168 */return Screenprinting.Ghost;
			case 1:
				/* 170 */return Screenprinting.Ghost;
			case 2:
				/* 172 */return Screenprinting.Ghost;
			case 3:
				/* 174 */return Screenprinting.Ghost;
			}
		}
		/* 177 */if (mob[(locationX + locationY * 80)].Mobtype.equals("Fly")) {
			/* 178 */switch (mob[(locationX + locationY * 80)].direction) {
		case 0:
				/* 180 */return Screenprinting.Fly;
			case 1:
				/* 182 */return Screenprinting.Fly;
			case 2:
				/* 184 */return Screenprinting.Fly;
			case 3:
				/* 186 */return Screenprinting.Fly;
			}
		}
		/* 189 */if (mob[(locationX + locationY * 80)].Mobtype.equals("Vampire")) {
			/* 190 */switch (mob[(locationX + locationY * 80)].direction) {
		case 0:
				/* 192 */return Screenprinting.Vampire;
			case 1:
				/* 194 */return Screenprinting.Vampire;
			case 2:
				/* 196 */return Screenprinting.Vampire;
			case 3:
				/* 198 */return Screenprinting.Vampire;
			}
		}
	
		/* 202 */return Screenprinting.Steen;
	}


public static void hurt(int locationX, int locationY, int amountOfHurt, int hurtByPlayer)
{
		/* 207 */mob[(locationX + locationY * 80)].latestHitBy = hurtByPlayer;
		/* 208 */mob[(locationX + locationY * 80)].health -= amountOfHurt;
	}


public static void returnXP(String Mobtype, int player)
{
		/* 213 */if (Mobtype.equals("Trombie")) {
			/* 214 */Player.getPlayer().addToXP(50);
		}
		/* 216 */if (Mobtype.equals("Ghost")) {
			/* 217 */Player.getPlayer().addToXP(153);
		}
		/* 219 */if (Mobtype.equals("Fly")) {
			/* 220 */Player.getPlayer().addToXP(15);
		}
		/* 222 */if (Mobtype.equals("Fly"))
			/* 223 */Player.getPlayer().addToXP(60);
	}


public static void mobTurn(int LocationX, int LocationY)
{
		/* 230 */if (mob[(LocationX + LocationY * 80)].Mobtype.equals("Trombie")) {
			/* 231 */mobType = 2;
		}
		/* 233 */if (mob[(LocationX + LocationY * 80)].Mobtype.equals("Ghost")) {
			/* 234 */mobType = 3;
		}
		/* 236 */if (mob[(LocationX + LocationY * 80)].Mobtype.equals("Fly")) {
			/* 237 */mobType = 4;
		}
		/* 239 */if (mob[(LocationX + LocationY * 80)].Mobtype.equals("Vampire")) {
			/* 240 */mobType = 5;
		}
		/* 242 */switch (mobType) {
	case 2:
			/* 244 */if (TileChecker.isNextToPlayer(LocationX, LocationY))
		{
				/* 246 */Player.hurtPlayer(14 + rand.nextInt(2));
				/* 247 */Player.startHittingMob(4);
			}
		else {
				/* 250 */timesTried = 0;
			do
			{
					/* 255 */if (com.thomas.dungeon.Fog.Fog.fogpppart[(LocationX + LocationY * 80)].fog)
						/* 256 */localDirection = rand.nextInt(4);
				else {
						/* 258 */localDirection = TileChecker.directionIfNearPlayer(LocationX, LocationY);
					}
				
					/* 261 */if (timesTried > 5) {
						/* 262 */localDirection = rand.nextInt(4);
					}
				
					/* 265 */if (TileChecker.isWalkableDirection(mobType, LocationX, LocationY, localDirection))
				{
						/* 267 */moveMob(LocationX, LocationY, localDirection);
						/* 268 */moved = true;
					} else {
						/* 270 */moved = false;
						/* 271 */timesTried += 1;
					}
				
					/* 274 */if (moved)
						break;
				} while (timesTried < 20);
			}
			/* 276 */break;
	case 3:
			/* 278 */if (TileChecker.isNextToPlayer(LocationX, LocationY))
		{
				/* 280 */Player.hurtPlayer(15 + rand.nextInt(2));
				/* 281 */Player.startHittingMob(4);
			}
		else {
				/* 284 */timesTried = 0;
			do
			{
					/* 289 */if (com.thomas.dungeon.Fog.Fog.fogpppart[(LocationX + LocationY * 80)].fog)
						/* 290 */localDirection = rand.nextInt(4);
				else {
						/* 292 */localDirection = TileChecker.directionIfNearPlayer(LocationX, LocationY);
					}
				
					/* 295 */if (timesTried > 5) {
						/* 296 */localDirection = rand.nextInt(4);
					}
				
					/* 299 */if (TileChecker.isWalkableDirection(mobType, LocationX, LocationY, localDirection))
				{
						/* 301 */moveMob(LocationX, LocationY, localDirection);
						/* 302 */moved = true;
					} else {
						/* 304 */moved = false;
						/* 305 */timesTried += 1;
					}
				
					/* 308 */if (moved)
						break;
				} while (timesTried < 20);
			}
			/* 310 */break;
	case 4:
			/* 312 */if (TileChecker.isNextToPlayer(LocationX, LocationY))
		{
				/* 314 */Player.hurtPlayer(5);
				/* 315 */Player.startHittingMob(4);
			}
		else {
				/* 318 */timesTried = 0;
			do
			{
					/* 324 */if (com.thomas.dungeon.Fog.Fog.fogpppart[(LocationX + LocationY * 80)].fog)
				{
						/* 326 */localDirection = rand.nextInt(4);
					}
					/* 328 */else
						localDirection = TileChecker.directionIfNearPlayer(LocationX, LocationY);
				
					/* 331 */if (timesTried > 5) {
						/* 332 */localDirection = rand.nextInt(4);
					}
				
					/* 335 */if (TileChecker.isWalkableDirection(mobType, LocationX, LocationY, localDirection))
				{
						/* 337 */moveMob(LocationX, LocationY, localDirection);
						/* 338 */moved = true;
					} else {
						/* 340 */moved = false;
						/* 341 */timesTried += 1;
					}
				
					/* 344 */if (moved)
						break;
				} while (timesTried < 20);
			}
			/* 346 */break;
	case 5:
			/* 350 */if (TileChecker.isNextToPlayer(LocationX, LocationY))
		{
				/* 352 */Player.hurtPlayer(16);
				/* 353 */Player.startHittingMob(4);
			}
		else {
				/* 356 */timesTried = 0;
			do
			{
					/* 362 */if (com.thomas.dungeon.Fog.Fog.fogpppart[(LocationX + LocationY * 80)].fog)
				{
						/* 364 */localDirection = rand.nextInt(4);
					}
					/* 366 */else
						localDirection = TileChecker.directionIfNearPlayer(LocationX, LocationY);
				
					/* 369 */if (timesTried > 5) {
						/* 370 */localDirection = rand.nextInt(4);
					}
				
					/* 373 */if (TileChecker.isWalkableDirection(mobType, LocationX, LocationY, localDirection))
				{
						/* 375 */moveMob(LocationX, LocationY, localDirection);
						/* 376 */moved = true;
					} else {
						/* 378 */moved = false;
						/* 379 */timesTried += 1;
					}
				}
				/* 382 */while ((!moved) && (timesTried < 20));
			}
		break;
	}
	}


public static void moveMob(int oldLocationX, int oldLocationY, int direction)
{
		/* 392 */switch (direction) {
	case 0:
			/* 394 */mob[(oldLocationX + oldLocationY * 80)].direction = 0;
			/* 395 */moveMobToAnyPosition(oldLocationX, oldLocationY, oldLocationX, oldLocationY - 1);
			/* 396 */break;
	case 1:
			/* 398 */mob[(oldLocationX + oldLocationY * 80)].direction = 1;
			/* 399 */moveMobToAnyPosition(oldLocationX, oldLocationY, oldLocationX + 1, oldLocationY);
			/* 400 */break;
	case 2:
			/* 402 */mob[(oldLocationX + oldLocationY * 80)].direction = 2;
			/* 403 */moveMobToAnyPosition(oldLocationX, oldLocationY, oldLocationX, oldLocationY + 1);
			/* 404 */break;
	case 3:
			/* 406 */mob[(oldLocationX + oldLocationY * 80)].direction = 3;
			/* 407 */moveMobToAnyPosition(oldLocationX, oldLocationY, oldLocationX - 1, oldLocationY);
		}
	}


public static void moveMobToAnyPosition(int oldLocationX, int oldLocationY, int newLocationX, int newLocationY)
{
		/* 414 */if (!mob[(oldLocationX + oldLocationY * 80)].alReadyMoved) {
			/* 415 */mob[(oldLocationX + oldLocationY * 80)].isMob = false;
		
			/* 417 */mob[(newLocationX + newLocationY * 80)].Mobtype = mob[(oldLocationX + oldLocationY * 80)].Mobtype;
			/* 418 */mob[(newLocationX + newLocationY * 80)].direction = mob[(oldLocationX + oldLocationY * 80)].direction;
			/* 419 */mob[(newLocationX + newLocationY * 80)].health = mob[(oldLocationX + oldLocationY * 80)].health;
			/* 420 */mob[(newLocationX + newLocationY * 80)].isMob = true;
		
			/* 422 */mob[(newLocationX + newLocationY * 80)].alReadyMoved = true;
		}
	}


public static void settings() {
		/* 427 */mob = new Mob[4080];
		/* 428 */for (int i = 0; i < 80; i++)
			/* 429 */for (int j = 0; j < 50; j++) {
				/* 430 */mob[(i + j * 80)] = new Mob();
				/* 431 */mob[(i + j * 80)].isMob = false;
				/* 432 */mob[(i + j * 80)].health = 0;
			}
	}


public static void spawnMob(int mobType, int locationX, int locationY)
{
		/* 441 */if (TileChecker.isWalkable(mobType, locationX, locationY)) {
			/* 442 */mobsOnLevel += 1;
			/* 443 */switch (mobType) {
		case 2:
				/* 445 */mob[(locationX + locationY * 80)].Mobtype = "Trombie";
				/* 446 */mob[(locationX + locationY * 80)].health = 140;
				/* 447 */mob[(locationX + locationY * 80)].isMob = true;
				/* 448 */mobsOnLevel += 1;
				/* 449 */break;
		case 3:
				/* 451 */mob[(locationX + locationY * 80)].Mobtype = "Ghost";
				/* 452 */mob[(locationX + locationY * 80)].health = 200;
				/* 453 */mob[(locationX + locationY * 80)].isMob = true;
				/* 454 */ghostOnLevel += 1;
				/* 455 */break;
		case 4:
				/* 457 */mob[(locationX + locationY * 80)].Mobtype = "Fly";
				/* 458 */mob[(locationX + locationY * 80)].health = 80;
				/* 459 */mob[(locationX + locationY * 80)].isMob = true;
				/* 460 */mobsOnLevel += 1;
				/* 461 */break;
		case 5:
				/* 463 */mob[(locationX + locationY * 80)].Mobtype = "Vampire";
				/* 464 */mob[(locationX + locationY * 80)].health = 110;
				/* 465 */mob[(locationX + locationY * 80)].isMob = true;
				/* 466 */mobsOnLevel += 1;
				/* 467 */break;
		default:
				/* 469 */System.out.println("Wrong mobType in Mobs.spawnMob()");
			}
		
			/* 473 */mob[(locationX + locationY * 80)].health += Gamehandler.levelLevel;
		}
	}


public static void teleportMobRandom(int oldlocationX, int oldlocationY)
{
		/* 480 */int TimesTriedd = 0;
		/* 481 */boolean movedd = false;
		/* 482 */int mobtyppe = Converter.convertMobTypeStringToInt(mob[(oldlocationX + oldlocationY * 80)].Mobtype);
	do
	{
			/* 485 */int locationX = rand.nextInt(80);
			/* 486 */int locationY = rand.nextInt(50);
			/* 487 */if (TileChecker.isWalkable(mobtyppe, locationX, locationY)) {
				/* 488 */moveMobToAnyPosition(oldlocationX, oldlocationY, locationX, locationY);
				/* 489 */movedd = true;
			}
		else {
				/* 492 */TimesTriedd++;
				/* 493 */movedd = false;
			}
		}
		/* 495 */while ((!movedd) && (TimesTriedd < 20));
	}

}