package com.thomas.dungeon.ScreenStuff;

import com.thomas.dungeon.Entities.Mobs;
import com.thomas.dungeon.Entities.Player;
import com.thomas.dungeon.GameTechnical.Game;
import com.thomas.dungeon.GameTechnical.Gamehandler;
import com.thomas.dungeon.GameTechnical.TileChecker;
import com.thomas.dungeon.Inventory.Inventory;
import com.thomas.dungeon.Level.Deuren;
import com.thomas.dungeon.Level.LevelArrayList;
import com.thomas.dungeon.Level.Rooms;
import com.thomas.dungeon.Level.plaatsVoorDeur;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.Random;

public class Screenprinting {
	/* 31 */int mapsizeX = 80;
	/* 32 */int mapsizeY = 50;
	public int nummerX;
	public int nummerY;
	int X;
	int Y;
	int Xprint;
	int Yprint;
	String[][] map = new String[this.mapsizeX][this.mapsizeY];
	Random randomGenerator = new Random();

	String direction = null;

	public int scheurenVerhouding = 20;
	public static int kamerTeBouwen;
	public static Random rand = new Random();
	public int correction = 15;
	public boolean done;

	public static Image Attack = null;
	public static Image Defence = null;
	public static Image Vloer = null;
	public static Image Muur = null;
	public static Image Health = null;
	public static Image MuurOnder = null;
	public static Image Torchrow = null;
	public static Image Torchlow = null;
	public static Image Torchuw = null;
	public static Image Torchaw = null;
	public static Image ScheurVloer = null;
	public static Image ScheurVloer1 = null;
	/* 79 */public static Image PutVloer = null;
	/* 80 */public static Image PatroonVloer = null;

	/* 82 */public static Image DeurOverY = null;
	/* 83 */public static Image DeurOverYOpenBoven = null;
	/* 84 */public static Image DeurOverYOpenOnder = null;
	/* 85 */public static Image DeurOverX = null;
	/* 86 */public static Image DeurOverXOpenBoven = null;
	/* 87 */public static Image DeurOverXOpenOnder = null;
	/* 88 */public static Image Void = null;
	/* 89 */public static Image Rooster = null;
	/* 90 */public static Image Steen = null;
	/* 91 */public static Image Wall_ = null;
	/* 92 */public static Image Wall_Ivy = null;
	/* 93 */public static Image Wall_Ivy2 = null;
	/* 94 */public static Image Wall_Rooster = null;
	/* 95 */public static Image Ivy = null;
	/* 96 */public static Image Chest = null;
	/* 97 */public static Image Iron = null;
	/* 98 */public static Image Gold = null;
	/* 99 */public static Image Wood = null;
	/* 100 */public static Image Heart = null;

	/* 102 */public static Image Cloth = null;
	/* 103 */public static Image Tooth = null;
	/* 104 */public static Image Bottle = null;
	/* 105 */public static Image Bottlewithwater = null;

	/* 107 */public static Image Glue = null;

	/* 109 */public static Image Glass = null;

	/* 111 */public static Image Niks = null;
	/* 112 */public static Image PlayerDown = null;
	/* 113 */public static Image PlayerUp = null;
	/* 114 */public static Image PlayerRight = null;
	/* 115 */public static Image PlayerLeft = null;
	/* 116 */public static Image TrombieLeft = null;
	/* 117 */public static Image Ghost = null;
	/* 118 */public static Image Fly = null;
	/* 119 */public static Image Vampire = null;

	/* 121 */public static Image BorderLinksBoven = null;

	/* 123 */public static Image BorderBoven = null;

	/* 125 */public static Image BorderRechtsBoven = null;
	/* 126 */public static Image BorderRechts = null;
	/* 127 */public static Image BorderRechtsOnder = null;
	/* 128 */public static Image BorderOnder = null;

	/* 130 */public static Image BorderLinksOnder = null;
	/* 131 */public static Image BorderLinks = null;
	/* 132 */public static Image Stairs = null;
	/* 133 */public static Image StairsDown = null;

	/* 135 */public static Image ItemScreen = null;
	/* 136 */public static Image ArmorButton = null;
	/* 137 */public static Image MenuBackgroundRed = null;
	/* 138 */public static Image MenuBackgroundBlur = null;
	/* 139 */public static Image MenuBackground = null;
	/* 140 */public static Image MBSinglePlayer = null;
	/* 141 */public static Image MBSSinglePlayer = null;
	/* 142 */public static Image MBMultiPlayer = null;

	/* 144 */public static Image MBSMultiPlayer = null;
	/* 145 */public static Image MBOptions = null;

	/* 147 */public static Image MBSOptions = null;
	/* 148 */public static Image SpritePicture = null;
	/* 149 */public static Image Hit1 = null;
	/* 150 */public static Image Hit2 = null;

	public Player pla = Player.getPlayer();
	public BufferedImage screenImage = new BufferedImage(Game.HEIGHT / 9 * 13, Game.HEIGHT / 9 * 9, 2);
	public Graphics2D g = (Graphics2D) this.screenImage.getGraphics();

	public static synchronized void loadImages() {
		/* 156 */URL attack = Screenprinting.class.getResource("Sprites/Attack.png");
		/* 157 */URL defence = Screenprinting.class.getResource("Sprites/Defence.png");
		/* 158 */URL health = Screenprinting.class.getResource("Sprites/Health.png");

		/* 160 */URL vloer = Screenprinting.class.getResource("Sprites/Vloer.png");
		/* 161 */URL patroonVloer = Screenprinting.class.getResource("Sprites/Patroon.png");
		/* 162 */URL putVloer = Screenprinting.class.getResource("Sprites/Put.png");
		/* 163 */URL muur = Screenprinting.class.getResource("Sprites/Muur.png");
		/* 164 */URL muurOnder = Screenprinting.class.getResource("Sprites/MuurOnder.png");
		/* 165 */URL torchrow = Screenprinting.class.getResource("Sprites/Torchrow.png");
		/* 166 */URL torchlow = Screenprinting.class.getResource("Sprites/Torchlow.png");
		/* 167 */URL torchuw = Screenprinting.class.getResource("Sprites/Torchuw.png");
		/* 168 */URL torchaw = Screenprinting.class.getResource("Sprites/Torchaw.png");
		/* 169 */URL scheurVloer = Screenprinting.class.getResource("Sprites/ScheurVloer.png");
		/* 170 */URL scheurVloer1 = Screenprinting.class.getResource("Sprites/ScheurVloer2.png");
		/* 171 */URL deurOverX = Screenprinting.class.getResource("Sprites/DeurOverX.png");
		/* 172 */URL deurOverXOpenBoven = Screenprinting.class.getResource("Sprites/DeurOverXBoven.png");
		/* 173 */URL deurOverXOpenOnder = Screenprinting.class.getResource("Sprites/DeurOverXOnder.png");
		/* 174 */URL deurOverY = Screenprinting.class.getResource("Sprites/DeurOverY.png");
		/* 175 */URL deurOverYOpenBoven = Screenprinting.class.getResource("Sprites/DeurOverYBoven.png");
		/* 176 */URL deurOverYOpenOnder = Screenprinting.class.getResource("Sprites/DeurOverYOnder.png");
		/* 177 */URL voidl = Screenprinting.class.getResource("Sprites/void.png");
		/* 178 */URL rooster = Screenprinting.class.getResource("Sprites/Rooster.png");
		/* 179 */URL steen = Screenprinting.class.getResource("Sprites/Steen.png");

		/* 181 */URL ivy = Screenprinting.class.getResource("Sprites/Ivy.png");

		/* 183 */URL wall_ = Screenprinting.class.getResource("Sprites/Wall-.png");
		/* 184 */URL wall_Ivy = Screenprinting.class.getResource("Sprites/Wall-Ivy.png");
		/* 185 */URL wall_Ivy2 = Screenprinting.class.getResource("Sprites/Wall-Ivy2.png");
		/* 186 */URL wall_Rooster = Screenprinting.class.getResource("Sprites/Wall-Rooster.png");

		/* 188 */URL iron = Screenprinting.class.getResource("Items/Iron.png");
		/* 189 */URL gold = Screenprinting.class.getResource("Items/Gold.png");
		/* 190 */URL wood = Screenprinting.class.getResource("Items/Wood.png");
		/* 191 */URL heart = Screenprinting.class.getResource("Items/Heart.png");
		/* 192 */URL cloth = Screenprinting.class.getResource("Items/Cloth.png");
		/* 193 */URL tooth = Screenprinting.class.getResource("Items/Tooth.png");
		/* 194 */URL bottle = Screenprinting.class.getResource("Items/Bottle.png");
		/* 195 */URL bottlewithwater = Screenprinting.class.getResource("Items/Bottle with Water.png");
		/* 196 */URL glue = Screenprinting.class.getResource("Items/Glue.png");
		/* 197 */URL glass = Screenprinting.class.getResource("Items/Glass.png");

		/* 199 */URL chest = Screenprinting.class.getResource("Sprites/Chest.png");

		/* 201 */URL niks = Screenprinting.class.getResource("Sprites/void.png");

		/* 203 */URL stairs = Screenprinting.class.getResource("Sprites/Stairs.png");
		/* 204 */URL stairsDown = Screenprinting.class.getResource("Sprites/StairsDown.png");
		/* 205 */URL playerDown = Screenprinting.class.getResource("Sprites/spritedown.png");
		/* 206 */URL playerUp = Screenprinting.class.getResource("Sprites/spriteup.png");
		/* 207 */URL playerLeft = Screenprinting.class.getResource("Sprites/spriteleft.png");
		/* 208 */URL playerRight = Screenprinting.class.getResource("Sprites/spriteright.png");

		/* 210 */URL trombieLeft = Screenprinting.class.getResource("Sprites/TrombieLeft.png");
		/* 211 */URL ghost = Screenprinting.class.getResource("Sprites/ghost.png");
		/* 212 */URL fly = Screenprinting.class.getResource("Sprites/Fly.png");
		/* 213 */URL vampire = Screenprinting.class.getResource("Sprites/Vampire.png");

		/* 215 */URL borderLinksBoven = Screenprinting.class.getResource("Sprites/BorderLeftBoven.png");
		/* 216 */URL borderBoven = Screenprinting.class.getResource("Sprites/BorderBoven.png");
		/* 217 */URL borderRechtsBoven = Screenprinting.class.getResource("Sprites/BorderRightBoven.png");
		/* 218 */URL borderRechts = Screenprinting.class.getResource("Sprites/BorderRight.png");
		/* 219 */URL borderRechtsOnder = Screenprinting.class.getResource("Sprites/BorderRightUnder.png");
		/* 220 */URL borderOnder = Screenprinting.class.getResource("Sprites/BorderUnder.png");
		/* 221 */URL borderLinksOnder = Screenprinting.class.getResource("Sprites/BorderLeftUnder.png");
		/* 222 */URL borderLinks = Screenprinting.class.getResource("Sprites/BorderLeft.png");

		/* 224 */URL itemScreen = Screenprinting.class.getResource("MenuRes/Itemscreen.png");
		/* 225 */URL armorButton = Screenprinting.class.getResource("MenuRes/ArnorButton.png");
		/* 226 */URL menuBackgroundRed = Screenprinting.class.getResource("Background/BackGroundPerkamentMenu.png");
		/* 227 */URL menuBackgroundBlur = Screenprinting.class.getResource("Background/BackGroundPerkamentBlur.jpg");
		/* 228 */URL menuBackground = Screenprinting.class.getResource("Background/BackGroundPerkament.jpg");
		/* 229 */URL menuButtonSingleplayer = Screenprinting.class.getResource("MenuRes/MenuSingleplayerButton.png");
		/* 230 */URL menuButtonSingleplayerSelected = Screenprinting.class.getResource("MenuRes/MenuSingleplayerButtonSelected.png");
		/* 231 */URL menuButtonMultiplayer = Screenprinting.class.getResource("MenuRes/MenuMultiplayerButton.png");
		/* 232 */URL menuButtonMultiplayerSelected = Screenprinting.class.getResource("MenuRes/MenuMultiplayerButtonSelected.png");
		/* 233 */URL menuButtonOptions = Screenprinting.class.getResource("MenuRes/MenuOptionsButton.png");
		/* 234 */URL menuButtonOptionsSelected = Screenprinting.class.getResource("MenuRes/MenuOptionsButtonSelected.png");

		/* 236 */URL spritePicture = Screenprinting.class.getResource("Sprites/SpritePicture.png");
		/* 237 */URL hit1 = Screenprinting.class.getResource("Sprites/Hit1.png");
		/* 238 */URL hit2 = Screenprinting.class.getResource("Sprites/Hit2.png");
		try {
			/* 242 */Attack = Toolkit.getDefaultToolkit().getImage(attack);
			/* 243 */Defence = Toolkit.getDefaultToolkit().getImage(defence);
			/* 244 */Health = Toolkit.getDefaultToolkit().getImage(health);
			/* 245 */Vloer = Toolkit.getDefaultToolkit().getImage(vloer);
			/* 246 */PutVloer = Toolkit.getDefaultToolkit().getImage(putVloer);
			/* 247 */PatroonVloer = Toolkit.getDefaultToolkit().getImage(patroonVloer);
			/* 248 */Muur = Toolkit.getDefaultToolkit().getImage(muur);
			/* 249 */MuurOnder = Toolkit.getDefaultToolkit().getImage(muurOnder);
			/* 250 */Torchrow = Toolkit.getDefaultToolkit().getImage(torchrow);
			/* 251 */Torchlow = Toolkit.getDefaultToolkit().getImage(torchlow);
			/* 252 */Torchuw = Toolkit.getDefaultToolkit().getImage(torchuw);
			/* 253 */Torchaw = Toolkit.getDefaultToolkit().getImage(torchaw);
			/* 254 */ScheurVloer = Toolkit.getDefaultToolkit().getImage(scheurVloer);
			/* 255 */ScheurVloer1 = Toolkit.getDefaultToolkit().getImage(scheurVloer1);
			/* 256 */DeurOverX = Toolkit.getDefaultToolkit().getImage(deurOverX);
			/* 257 */DeurOverXOpenBoven = Toolkit.getDefaultToolkit().getImage(deurOverXOpenBoven);
			/* 258 */DeurOverXOpenOnder = Toolkit.getDefaultToolkit().getImage(deurOverXOpenOnder);
			/* 259 */DeurOverY = Toolkit.getDefaultToolkit().getImage(deurOverY);
			/* 260 */DeurOverYOpenBoven = Toolkit.getDefaultToolkit().getImage(deurOverYOpenBoven);
			/* 261 */DeurOverYOpenOnder = Toolkit.getDefaultToolkit().getImage(deurOverYOpenOnder);
			/* 262 */Void = Toolkit.getDefaultToolkit().getImage(voidl);
			/* 263 */Rooster = Toolkit.getDefaultToolkit().getImage(rooster);
			/* 264 */Steen = Toolkit.getDefaultToolkit().getImage(steen);

			/* 266 */Ivy = Toolkit.getDefaultToolkit().getImage(ivy);

			/* 268 */Wall_ = Toolkit.getDefaultToolkit().getImage(wall_);
			/* 269 */Wall_Ivy = Toolkit.getDefaultToolkit().getImage(wall_Ivy);
			/* 270 */Wall_Ivy2 = Toolkit.getDefaultToolkit().getImage(wall_Ivy2);
			/* 271 */Wall_Rooster = Toolkit.getDefaultToolkit().getImage(wall_Rooster);

			/* 273 */Stairs = Toolkit.getDefaultToolkit().getImage(stairs);
			/* 274 */StairsDown = Toolkit.getDefaultToolkit().getImage(stairsDown);

			/* 276 */Chest = Toolkit.getDefaultToolkit().getImage(chest);

			/* 278 */Iron = Toolkit.getDefaultToolkit().getImage(iron);
			/* 279 */Gold = Toolkit.getDefaultToolkit().getImage(gold);
			/* 280 */Wood = Toolkit.getDefaultToolkit().getImage(wood);
			/* 281 */Heart = Toolkit.getDefaultToolkit().getImage(heart);
			/* 282 */Cloth = Toolkit.getDefaultToolkit().getImage(cloth);
			/* 283 */Tooth = Toolkit.getDefaultToolkit().getImage(tooth);
			/* 284 */Bottle = Toolkit.getDefaultToolkit().getImage(bottle);
			/* 285 */Bottlewithwater = Toolkit.getDefaultToolkit().getImage(bottlewithwater);
			/* 286 */Glue = Toolkit.getDefaultToolkit().getImage(glue);
			/* 287 */Glass = Toolkit.getDefaultToolkit().getImage(glass);

			/* 289 */Niks = Toolkit.getDefaultToolkit().getImage(niks);

			/* 291 */PlayerDown = Toolkit.getDefaultToolkit().getImage(playerDown);
			/* 292 */PlayerUp = Toolkit.getDefaultToolkit().getImage(playerUp);
			/* 293 */PlayerLeft = Toolkit.getDefaultToolkit().getImage(playerLeft);
			/* 294 */PlayerRight = Toolkit.getDefaultToolkit().getImage(playerRight);

			/* 296 */TrombieLeft = Toolkit.getDefaultToolkit().getImage(trombieLeft);
			/* 297 */Fly = Toolkit.getDefaultToolkit().getImage(fly);
			/* 298 */Ghost = Toolkit.getDefaultToolkit().getImage(ghost);
			/* 299 */Vampire = Toolkit.getDefaultToolkit().getImage(vampire);

			/* 301 */BorderLinksBoven = Toolkit.getDefaultToolkit().getImage(borderLinksBoven);
			/* 302 */BorderBoven = Toolkit.getDefaultToolkit().getImage(borderBoven);
			/* 303 */BorderRechtsBoven = Toolkit.getDefaultToolkit().getImage(borderRechtsBoven);
			/* 304 */BorderRechts = Toolkit.getDefaultToolkit().getImage(borderRechts);
			/* 305 */BorderRechtsOnder = Toolkit.getDefaultToolkit().getImage(borderRechtsOnder);
			/* 306 */BorderOnder = Toolkit.getDefaultToolkit().getImage(borderOnder);
			/* 307 */BorderLinksOnder = Toolkit.getDefaultToolkit().getImage(borderLinksOnder);
			/* 308 */BorderLinks = Toolkit.getDefaultToolkit().getImage(borderLinks);

			/* 310 */ItemScreen = Toolkit.getDefaultToolkit().getImage(itemScreen);
			/* 311 */ArmorButton = Toolkit.getDefaultToolkit().getImage(armorButton);
			/* 312 */MenuBackground = Toolkit.getDefaultToolkit().getImage(menuBackground);
			/* 313 */MenuBackgroundBlur = Toolkit.getDefaultToolkit().getImage(menuBackgroundBlur);
			/* 314 */MenuBackgroundRed = Toolkit.getDefaultToolkit().getImage(menuBackgroundRed);
			/* 315 */MBSinglePlayer = Toolkit.getDefaultToolkit().getImage(menuButtonSingleplayer);
			/* 316 */MBSSinglePlayer = Toolkit.getDefaultToolkit().getImage(menuButtonSingleplayerSelected);
			/* 317 */MBMultiPlayer = Toolkit.getDefaultToolkit().getImage(menuButtonMultiplayer);
			/* 318 */MBSMultiPlayer = Toolkit.getDefaultToolkit().getImage(menuButtonMultiplayerSelected);
			/* 319 */MBOptions = Toolkit.getDefaultToolkit().getImage(menuButtonOptions);
			/* 320 */MBSOptions = Toolkit.getDefaultToolkit().getImage(menuButtonOptionsSelected);

			/* 322 */SpritePicture = Toolkit.getDefaultToolkit().getImage(spritePicture);
			/* 323 */Hit1 = Toolkit.getDefaultToolkit().getImage(hit1);
			/* 324 */Hit2 = Toolkit.getDefaultToolkit().getImage(hit2);
		} catch (Exception e) {
			/* 326 */e.printStackTrace();
		}
	}

	@Deprecated
	public BufferedImage generateIt() {
		/* 345 */this.done = false;
		g.clearRect(0, 0, screenImage.getWidth(), screenImage.getHeight());
		/* 346 */this.g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		/* 347 */this.g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		/* 349 */this.g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		/* 350 */Player.updateOffSet();
		/* 351 */Player.updateHitting();

		/* 353 */int offsetX = Player.getOffSetX();
		int offsetY = Player.getOffSetY();

		/* 359 */int tileSize = Game.HEIGHT / 9;
		int ScrollX;
		int ScrollY;
		/* 361 */if (this.pla.loc.getX() <= 6) {
			/* 362 */ScrollX = 0;
		} else {
			/* 363 */if (this.pla.loc.getX() >= 74)
				/* 364 */ScrollX = 67;
			else
				/* 366 */ScrollX = this.pla.loc.getX() - 6;
		}

		/* 369 */if (this.pla.loc.getY() <= 4) {
			/* 370 */ScrollY = 0;
		} else {
			/* 371 */if (this.pla.loc.getY() > 45)
				/* 372 */ScrollY = 41;
			else
				/* 374 */ScrollY = this.pla.loc.getY() - 4;
		}
		/* 376 */this.g.setColor(Color.BLACK);
		/* 377 */this.g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		/* 378 */if (Game.finalMap != null) {
			/* 380 */for (int xTileOpScherm = 13; xTileOpScherm >= -1; xTileOpScherm--) {
				/* 381 */for (int yTileOpScherm = -1; yTileOpScherm < 10; yTileOpScherm++) {
					try {
						/* 384 */if (Game.finalMap[(ScrollX + xTileOpScherm)][(ScrollY + yTileOpScherm)] == "-") {
							/* 385 */if (Game.finalVariations[(ScrollX + xTileOpScherm)][(ScrollY + yTileOpScherm)].equals("scheur"))
								/* 386 */this.g.drawImage(ScheurVloer, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - offsetY
										* tileSize / Player.timeOneTurn, tileSize, tileSize, null);
							/* 387 */else if (Game.finalVariations[(ScrollX + xTileOpScherm)][(ScrollY + yTileOpScherm)].equals("patroon"))
								/* 388 */this.g.drawImage(PatroonVloer, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - offsetY
										* tileSize / Player.timeOneTurn, tileSize, tileSize, null);
							/* 389 */else if (Game.finalVariations[(ScrollX + xTileOpScherm)][(ScrollY + yTileOpScherm)].equals("put"))
								/* 390 */this.g.drawImage(PutVloer, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - offsetY
										* tileSize / Player.timeOneTurn, tileSize, tileSize, null);
							else
								/* 392 */this.g.drawImage(Vloer, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - offsetY * tileSize
										/ Player.timeOneTurn, tileSize, tileSize, null);
						}
						/* 394 */else if (Game.finalMap[(ScrollX + xTileOpScherm)][(ScrollY + yTileOpScherm)].equals("D")) {
							/* 395 */if (Deuren.getSingleDoor(ScrollX + xTileOpScherm - offsetX * tileSize / Player.timeOneTurn, ScrollY + yTileOpScherm).open) {
								/* 397 */this.g.drawImage(Vloer, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - offsetY * tileSize
										/ Player.timeOneTurn, tileSize, tileSize, null);
							}
							/* 399 */else
								this.g.drawImage(Vloer, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - offsetY * tileSize
										/ Player.timeOneTurn, tileSize, tileSize, null);
						}
						/* 401 */else if (Game.finalMap[(ScrollX + xTileOpScherm)][(ScrollY + yTileOpScherm)].equals("B")) {
							/* 402 */if (Deuren.getSingleDoor(ScrollX + xTileOpScherm, ScrollY + yTileOpScherm).open) {
								/* 404 */this.g.drawImage(Vloer, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - offsetY * tileSize
										/ Player.timeOneTurn, tileSize, tileSize, null);
							}
							/* 406 */else
								this.g.drawImage(Vloer, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - offsetY * tileSize
										/ Player.timeOneTurn, tileSize, tileSize, null);

						}
						/* 411 */else if (Game.finalMap[(ScrollX + xTileOpScherm)][(ScrollY + yTileOpScherm)].equals("_")) {
							/* 413 */this.g.drawImage(Void, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - offsetY * tileSize
									/ Player.timeOneTurn, tileSize, tileSize, null);
						}

						/* 416 */for (int x = 0; x < 20; x++) {
							/* 417 */for (int y = 0; y < 20; y++) {
								/* 418 */if (com.thomas.dungeon.Items.Items.Items[((ScrollX + xTileOpScherm) * 20 + x + ((ScrollY + yTileOpScherm) * 20 + y) * 1620)].isItem) {
									/* 477 */this.g
											.drawImage(
													Inventory
															.itemImage(com.thomas.dungeon.Items.Items.Items[((ScrollX + xTileOpScherm) * 20 + x + ((ScrollY + yTileOpScherm) * 20 + y) * 1620)].itemType),
													xTileOpScherm * tileSize + x * (
													/* 478 */tileSize - tileSize / 3) / 20 - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize + y
															* (tileSize - tileSize / 3) / 20 - offsetY * tileSize / Player.timeOneTurn, tileSize / 3,
													/* 479 */tileSize / 3, null);
								}
							}
						}

						/* 484 */if ((Game.StairLocationX == ScrollX + xTileOpScherm) && (Game.StairLocationY == ScrollY + yTileOpScherm)) {
							/* 486 */this.g.drawImage(Stairs, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - offsetY * tileSize
									/ Player.timeOneTurn, tileSize, tileSize, null);
						}
						/* 488 */if ((Gamehandler.levelLevel != 0) &&
						/* 489 */(ScrollX + xTileOpScherm == LevelArrayList.allLevels.get(Gamehandler.levelLevel - 1).stairX)
								&& (ScrollY + yTileOpScherm == LevelArrayList.allLevels.get(Gamehandler.levelLevel - 1).stairY) && (Gamehandler.levelLevel != 0)) {
							/* 491 */this.g.drawImage(StairsDown, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - offsetY * tileSize
									/ Player.timeOneTurn, tileSize, tileSize, null);
						}

						/* 495 */if (Mobs.mob[(ScrollX + xTileOpScherm + (ScrollY + yTileOpScherm) * 80)].isMob) {
							/* 497 */this.g.drawImage(Mobs.getMobImage(ScrollX + xTileOpScherm, ScrollY + yTileOpScherm), xTileOpScherm * tileSize - offsetX * tileSize
									/ Player.timeOneTurn, yTileOpScherm * tileSize - offsetY * tileSize / Player.timeOneTurn,
							/* 498 */tileSize, tileSize, null);
						}
						/* 500 */if (com.thomas.dungeon.Items.Chests.chestst[(ScrollX + xTileOpScherm + (ScrollY + yTileOpScherm) * 80)].isChest) {
							/* 502 */this.g.drawImage(Chest, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - offsetY * tileSize
									/ Player.timeOneTurn, tileSize, tileSize, null);
						}
					} catch (Exception localException) {
						localException.printStackTrace();
					}

				}

			}

		}

		/* 515 */this.g.drawImage(Player.getPlayer().getPlayerImage(), (this.pla.loc.getX() - ScrollX) * tileSize, (this.pla.loc.getY() - ScrollY) * tileSize, tileSize, tileSize,
				null);
		/* 516 */if (Player.hitting) {
			/* 517 */switch (Player.directionHitting) {
			case 0:
				/* 519 */this.g.drawImage(Player.getHitImage(), (this.pla.loc.getX() - ScrollX) * tileSize, (this.pla.loc.getY() - ScrollY - 1) * tileSize, tileSize, tileSize,
						null);
				/* 520 */break;
			case 1:
				/* 522 */this.g.drawImage(Player.getHitImage(), (this.pla.loc.getX() - ScrollX + 1) * tileSize, (this.pla.loc.getY() - ScrollY) * tileSize, tileSize, tileSize,
						null);
				/* 523 */break;
			case 2:
				/* 525 */this.g.drawImage(Player.getHitImage(), (this.pla.loc.getX() - ScrollX) * tileSize, (this.pla.loc.getY() - ScrollY + 1) * tileSize, tileSize, tileSize,
						null);
				/* 526 */break;
			case 3:
				/* 528 */this.g.drawImage(Player.getHitImage(), (this.pla.loc.getX() - ScrollX - 1) * tileSize, (this.pla.loc.getY() - ScrollY) * tileSize, tileSize, tileSize,
						null);
			}
		}

		/* 532 */if (Player.hittingMob) {
			/* 533 */this.g.drawImage(Player.getHitImageMob(), (this.pla.loc.getX() - ScrollX) * tileSize, (this.pla.loc.getY() - ScrollY) * tileSize, tileSize, tileSize, null);
		}

		/* 536 */for (int xTileOpScherm = 13; xTileOpScherm >= -1; xTileOpScherm--) {
			/* 537 */for (int yTileOpScherm = -1; yTileOpScherm < 11; yTileOpScherm++) {
				try {
					/* 540 */if (Game.finalMap[(ScrollX + xTileOpScherm)][(ScrollY + yTileOpScherm)] == "X") {
						/* 542 */this.g.drawImage(Muur, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - tileSize / 4 - offsetY
								* tileSize / Player.timeOneTurn, tileSize, tileSize, null);
						/* 543 */if (!TileChecker.equalsUp(ScrollX + xTileOpScherm, ScrollY + yTileOpScherm + 1)) {
							/* 545 */this.g.drawImage(Muur, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - tileSize / 4 + tileSize
									- offsetY * tileSize / Player.timeOneTurn, tileSize, tileSize / 4, null);
							/* 546 */if (Game.finalVariations[(ScrollX + xTileOpScherm)][(ScrollY + yTileOpScherm)].equalsIgnoreCase("Ivy")) {
								/* 547 */this.g.drawImage(Ivy, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - tileSize / 4
										+ tileSize - offsetY * tileSize / Player.timeOneTurn, tileSize, tileSize / 4, null);
							}
							/* 549 */GradientPaint redtowhite = new GradientPaint(xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize
									+ tileSize - offsetY * tileSize / Player.timeOneTurn, Color.black,
							/* 550 */xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, tileSize / 4 + yTileOpScherm * tileSize + tileSize - offsetY * tileSize
									/ Player.timeOneTurn, new Color(0, 0, 0, 0));
							/* 551 */this.g.setPaint(redtowhite);
							/* 552 */this.g.fillRect(xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize + tileSize - offsetY * tileSize
									/ Player.timeOneTurn, tileSize, tileSize / 4);
						}
						/* 554 */if (ScrollY + yTileOpScherm >= 80) {
							/* 555 */this.g.drawImage(Muur, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - tileSize / 4 + tileSize
									- offsetY * tileSize / Player.timeOneTurn, tileSize, tileSize / 4, null);

							/* 557 */if (Game.finalVariations[(ScrollX + xTileOpScherm)][(ScrollY + yTileOpScherm)].equalsIgnoreCase("Ivy")) {
								/* 558 */this.g.drawImage(Ivy, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - tileSize / 4
										+ tileSize - offsetY * tileSize / Player.timeOneTurn, tileSize, tileSize / 4, null);
							}
							/* 560 */GradientPaint redtowhite = new GradientPaint(xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize
									+ tileSize - offsetY * tileSize / Player.timeOneTurn, Color.black,
							/* 561 */xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, tileSize / 4 + yTileOpScherm * tileSize + tileSize - offsetY * tileSize
									/ Player.timeOneTurn, new Color(0, 0, 0, 0));
							/* 562 */this.g.setPaint(redtowhite);
							/* 563 */this.g.fillRect(xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize + tileSize - offsetY * tileSize
									/ Player.timeOneTurn, tileSize, tileSize / 4);
						}
					}
					/* 566 */if (Game.finalMap[(ScrollX + xTileOpScherm)][(ScrollY + yTileOpScherm)] == "x") {
						/* 568 */this.g.drawImage(Steen, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - tileSize / 4 - offsetY
								* tileSize / Player.timeOneTurn, tileSize, tileSize, null);
						/* 569 */if (!TileChecker.equalsUp(ScrollX + xTileOpScherm, ScrollY + yTileOpScherm + 1)) {
							/* 571 */this.g.drawImage(Steen, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - tileSize / 4 + tileSize
									- offsetY * tileSize / Player.timeOneTurn, tileSize, tileSize / 4, null);

							/* 573 */GradientPaint redtowhite = new GradientPaint(xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize
									+ tileSize - offsetY * tileSize / Player.timeOneTurn, Color.black,
							/* 574 */xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, tileSize / 4 + yTileOpScherm * tileSize + tileSize - offsetY * tileSize
									/ Player.timeOneTurn, new Color(0, 0, 0, 0));
							/* 575 */this.g.setPaint(redtowhite);
							/* 576 */this.g.fillRect(xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize + tileSize - offsetY * tileSize
									/ Player.timeOneTurn, tileSize, tileSize / 4);
						}
						/* 578 */if (ScrollY + yTileOpScherm >= 80) {
							/* 580 */this.g.drawImage(Steen, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - tileSize / 4 + tileSize
									- offsetY * tileSize / Player.timeOneTurn, tileSize, tileSize / 4, null);

							/* 582 */GradientPaint redtowhite = new GradientPaint(xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize
									+ tileSize - offsetY * tileSize / Player.timeOneTurn, Color.black,
							/* 583 */xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, tileSize / 4 + yTileOpScherm * tileSize + tileSize - offsetY * tileSize
									/ Player.timeOneTurn, new Color(0, 0, 0, 0));
							/* 584 */this.g.setPaint(redtowhite);
							/* 585 */this.g.fillRect(xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize + tileSize - offsetY * tileSize
									/ Player.timeOneTurn, tileSize, tileSize / 4);
						}
					}
				} catch (Exception localException1) {
				}

			}

		}

		/* 597 */for (int xTileOpScherm = -1; xTileOpScherm < 14; xTileOpScherm++) {
			/* 598 */for (int yTileOpScherm = -1; yTileOpScherm < 10; yTileOpScherm++) {
				try {
					/* 600 */if (Game.finalMap[(ScrollX + xTileOpScherm)][(ScrollY + yTileOpScherm)].equals("B")) {
						/* 601 */if (Deuren.getDoor()[(ScrollX + xTileOpScherm + (ScrollY + yTileOpScherm) * 80)].open) {
							/* 602 */if (Deuren.getDoor()[(ScrollX + xTileOpScherm + (ScrollY + yTileOpScherm) * 80)].geopendNaar)
								/* 603 */this.g.drawImage(DeurOverYOpenOnder, xTileOpScherm * tileSize - tileSize / 2 - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm
										* tileSize - tileSize / 2 - offsetY * tileSize / Player.timeOneTurn,
								/* 604 */tileSize * 2, tileSize * 2, null);
							else {
								/* 606 */this.g.drawImage(DeurOverYOpenBoven, xTileOpScherm * tileSize - tileSize / 2 - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm
										* tileSize - tileSize / 2 - offsetY * tileSize / Player.timeOneTurn,
								/* 607 */tileSize * 2, tileSize * 2, null);
							}
						} else {
							/* 611 */this.g.drawImage(DeurOverY, xTileOpScherm * tileSize - tileSize / 2 - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize
									- tileSize / 2 - offsetY * tileSize / Player.timeOneTurn, tileSize * 2,
							/* 612 */tileSize * 2, null);
						}
					}
					/* 615 */if (Game.finalMap[(ScrollX + xTileOpScherm)][(ScrollY + yTileOpScherm)].equals("D")) {
						/* 616 */if (Deuren.getDoor()[(ScrollX + xTileOpScherm + (ScrollY + yTileOpScherm) * 80)].open) {
							/* 617 */if (Deuren.getDoor()[(ScrollX + xTileOpScherm + (ScrollY + yTileOpScherm) * 80)].geopendNaar)
								/* 618 */this.g.drawImage(DeurOverXOpenOnder, xTileOpScherm * tileSize - tileSize / 2 - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm
										* tileSize - tileSize / 2 + tileSize / 4 + tileSize / 14 -
										/* 619 */offsetY * tileSize / Player.timeOneTurn, tileSize * 2, tileSize * 2 * 1 / 4, null);
							else {
								/* 621 */this.g.drawImage(DeurOverXOpenBoven, xTileOpScherm * tileSize - tileSize / 2 - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm
										* tileSize - tileSize / 2 + tileSize / 4 + tileSize / 14 -
										/* 622 */offsetY * tileSize / Player.timeOneTurn, tileSize * 2, tileSize * 2 * 1 / 4, null);
							}
						} else {
							/* 626 */this.g.drawImage(DeurOverX, xTileOpScherm * tileSize - tileSize / 2 - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize
									- tileSize / 2 + 1 - offsetY * tileSize / Player.timeOneTurn, tileSize * 2,
							/* 627 */tileSize * 2, null);
						}
					}
				} catch (Exception localException2) {
				}
			}
		}
		/* 636 */for (int xTileOpScherm = -2; xTileOpScherm < 17; xTileOpScherm++) {
			/* 637 */for (int yTileOpScherm = -2; yTileOpScherm < 13; yTileOpScherm++) {
				/* 638 */Color darkColor = new Color(0, 0, 0, 100);

				/* 640 */if ((ScrollX + xTileOpScherm - 1 >= 0)
						&& (ScrollX + xTileOpScherm - 1 < 80)
						&& (ScrollY + yTileOpScherm - 1 >= 0)
						&& (ScrollY + yTileOpScherm - 1 < 50)
						&& (
						/* 641 */(Game.finalTorches[(ScrollX + xTileOpScherm - 1)][(ScrollY + yTileOpScherm - 1)] == "abovewall")
								|| (Game.finalTorches[(ScrollX + xTileOpScherm - 1)][(ScrollY + yTileOpScherm - 1)] == "underwall") ||
								/* 642 */(Game.finalTorches[(ScrollX + xTileOpScherm - 1)][(ScrollY + yTileOpScherm - 1)] == "leftofwall") || (Game.finalTorches[(ScrollX
								+ xTileOpScherm - 1)][(ScrollY + yTileOpScherm - 1)] == "rightofwall"))) {
					/* 643 */float middle = (float) ((xTileOpScherm + 0.5D - 1.0D) * tileSize - offsetX * tileSize / Player.timeOneTurn);
					/* 644 */float middleY = (float) ((yTileOpScherm + 0.5D - 1.0D) * tileSize - offsetY * tileSize / Player.timeOneTurn);
					/* 645 */Point2D center = new Point2D.Float(middle, middleY);
					/* 646 */float radius = tileSize * 3.0F;
					/* 647 */float[] dist = { 0.0F, 0.1F, 0.5F };
					/* 648 */Color[] colors = { new Color(255, 253, 107, 30), new Color(0, 0, 0, 0), darkColor };
					/* 649 */RadialGradientPaint p = new RadialGradientPaint(center, radius, dist, colors);
					/* 650 */this.g.setPaint(p);

					/* 652 */this.g.fillRect((xTileOpScherm - 2) * tileSize - offsetX * tileSize / Player.timeOneTurn, (yTileOpScherm - 2) * tileSize - offsetY * tileSize
							/ Player.timeOneTurn, tileSize * 3, tileSize * 3);
				}

				try {
					/* 714 */if (Game.finalDark[(ScrollX + xTileOpScherm)][(ScrollY + yTileOpScherm)] != 0) {
						/* 715 */this.g.setColor(darkColor);
						/* 716 */this.g.fillRect(xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - offsetY * tileSize
								/ Player.timeOneTurn, tileSize, tileSize);
					}
				} catch (Exception localException3) {
				}
			}
		}
		/* 724 */for (int xTileOpScherm = -1; xTileOpScherm < 14; xTileOpScherm++) {
			/* 725 */for (int yTileOpScherm = -1; yTileOpScherm < 11; yTileOpScherm++) {
				try {
					/* 727 */if (Game.finalTorches[(ScrollX + xTileOpScherm)][(ScrollY + yTileOpScherm)] == "rightofwall") {
						/* 729 */this.g.drawImage(Torchrow, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - offsetY * tileSize
								/ Player.timeOneTurn, tileSize, tileSize, null);
					}
					/* 731 */if (Game.finalTorches[(ScrollX + xTileOpScherm)][(ScrollY + yTileOpScherm)] == "leftofwall") {
						/* 733 */this.g.drawImage(Torchlow, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - offsetY * tileSize
								/ Player.timeOneTurn, tileSize, tileSize, null);
					}
					/* 735 */if (Game.finalTorches[(ScrollX + xTileOpScherm)][(ScrollY + yTileOpScherm)] == "underwall") {
						/* 737 */this.g.drawImage(Torchuw, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - tileSize / 4 - offsetY
								* tileSize / Player.timeOneTurn, tileSize, tileSize, null);
					}
					/* 739 */if (Game.finalTorches[(ScrollX + xTileOpScherm)][(ScrollY + yTileOpScherm)] == "abovewall") {
						/* 741 */this.g.drawImage(Torchaw, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - tileSize / 4 - offsetY
								* tileSize / Player.timeOneTurn, tileSize, tileSize, null);
					}
					/* 743 */if (com.thomas.dungeon.Fog.Fog.fogpppart[(ScrollX + xTileOpScherm + (ScrollY + yTileOpScherm) * 80)].halffog) {
						/* 744 */this.g.setColor(new Color(0, 0, 0, 100));
						/* 745 */this.g.fillRect(xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - offsetY * tileSize
								/ Player.timeOneTurn, tileSize, tileSize);
						/* 746 */} else if ((com.thomas.dungeon.Fog.Fog.fogpppart[(ScrollX + xTileOpScherm + (ScrollY + yTileOpScherm) * 80)].fog)
							&& (com.thomas.dungeon.Fog.Fog.fogpppart[(ScrollX + xTileOpScherm + (ScrollY + yTileOpScherm) * 80)].wallfog)) {
						/* 747 */this.g.setColor(Color.BLACK);
						/* 748 */this.g.fillRect(xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - offsetY * tileSize
								/ Player.timeOneTurn, tileSize, tileSize);
						/* 749 */} else if (com.thomas.dungeon.Fog.Fog.fogpppart[(ScrollX + xTileOpScherm + (ScrollY + yTileOpScherm) * 80)].wallfog) {
						/* 750 */this.g.setColor(Color.BLACK);
						/* 751 */this.g.fillRect(xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - offsetY * tileSize
								/ Player.timeOneTurn, tileSize, tileSize);
					}
				} catch (Exception localException4) {
				}

			}

		}
		/* 764 */this.done = true;
		/* 765 */return this.screenImage;
	}

	public boolean getDone() {
		/* 770 */return this.done;
	}

	public String[][] getMap() {
		/* 774 */return this.map;
	}

	public synchronized String[][] makeMap() {
		/* 778 */this.map = new String[80][50];
		/* 779 */loadImages();
		/* 780 */for (this.Y = 0; this.Y < this.mapsizeY; this.Y += 1) {
			/* 781 */for (this.X = 0; this.X < this.mapsizeX; this.X += 1) {
				/* 782 */this.map[this.X][this.Y] = "_";
			}
		}
		/* 785 */Rooms ro = new Rooms();

		/* 787 */ro.beginningCourse(this.mapsizeX / 2 - 4, this.mapsizeY / 2 - 4, this.map);

		/* 789 */for (int loop = 0; loop < 400; loop++) {
			/* 791 */kamerTeBouwen = rand.nextInt(10);

			/* 793 */zoekMuur();
			/* 794 */zoekVrijePlaatsNaast();

			/* 796 */switch (kamerTeBouwen) {
			case 1:
				/* 798 */ro.gang(this.nummerX, this.nummerY, this.map, this.direction);
				/* 799 */break;
			case 2:
				/* 801 */ro.echteGang(this.nummerX, this.nummerY, this.map, this.direction);
				/* 802 */break;
			default:
				/* 804 */ro.gang(this.nummerX, this.nummerY, this.map, this.direction);
			}

		}

		/* 809 */replaceDoors();
		/* 810 */Rooms.makePilars(Game.finalMap);

		/* 812 */return this.map;
	}

	public void printMap() {
	}

	public void replaceDoors() {
		/* 821 */for (int i = 0; i < this.mapsizeX; i++)
			/* 822 */for (int j = 0; j < this.mapsizeY; j++)
				/* 823 */if ((Game.finalMap[i][j].equals("D")) || (this.map[i][j].equals("B"))) {
					/* 824 */plaatsVoorDeur plts = new plaatsVoorDeur();
					/* 825 */plts.setX(i);
					/* 826 */plts.setY(j);

					/* 828 */if (Game.finalMap[(i + 1)][j].equals("B")) {
						/* 829 */plts.setRichting(1);
						/* 830 */boolean volgende = true;
						/* 831 */int counter = 1;
						do
							/* 833 */if (Game.finalMap[(i + counter)][j].equals("B")) {
								/* 834 */plts.aantalOpEenRijPlusEen();
								/* 835 */counter++;
							} else {
								/* 838 */volgende = false;
							}
						/* 832 */while (
						/* 840 */volgende);
						/* 841 */if (plts.getAOER() > 0) {
							/* 842 */plts.behoudEenDeur(Game.finalMap);
						}
					}
					/* 845 */if (Game.finalMap[i][(j + 1)].equals("D")) {
						/* 846 */plts.setRichting(2);
						/* 847 */boolean volgendeY = true;
						/* 848 */int counterY = 1;
						do
							/* 850 */if (Game.finalMap[i][(j + counterY)].equals("D")) {
								/* 851 */plts.aantalOpEenRijPlusEen();
								/* 852 */counterY++;
							} else {
								/* 855 */volgendeY = false;
							}
						/* 849 */while (
						/* 857 */volgendeY);
						/* 858 */if (plts.getAOER() > 0)
							/* 859 */plts.behoudEenDeur(Game.finalMap);
					}
				}
	}

	public int[][] setDark() {
		/* 873 */int[][] dark = new int[mapsizeX][mapsizeY];

		/* 875 */for (int xTile = 0; xTile < 80; xTile++) {
			/* 876 */for (int yTile = 0; yTile < 50; yTile++) {
				/* 878 */boolean testdark = true;
				try {
					/* 880 */for (int gf = 0; gf < 3; gf++) {
						/* 881 */for (int gx = 0; gx < 3; gx++) {
							/* 882 */if ((Game.finalTorches[(xTile - 1 + gf)][(yTile - 1 + gx)] == "rightofwall")
									|| (Game.finalTorches[(xTile - 1 + gf)][(yTile - 1 + gx)] == "leftofwall")
									|| (Game.finalTorches[(xTile - 1 + gf)][(yTile - 1 + gx)] == "underwall") ||
									/* 883 */(Game.finalTorches[(xTile - 1 + gf)][(yTile - 1 + gx)] == "abovewall")) {
								/* 884 */testdark = false;
							}
						}
					}
				} catch (Exception localException) {
				}
				/* 892 */if (testdark) {
					/* 893 */dark[xTile][yTile] = 1;
				}

			}

		}

		/* 901 */return dark;
	}

	public String[][] setTorches() {
		/* 906 */String[][] torches = new String[mapsizeX][mapsizeY];

		/* 908 */Random rand = new Random();
		/* 909 */int torchrate = 16;
		/* 910 */int counter = 0;
		/* 911 */for (int i = 0; i < 80; i++) {
			/* 912 */for (int j = 0; j < 50; j++) {
				/* 913 */boolean notATorch = true;

				/* 915 */for (int gf = 0; gf < 5; gf++) {
					/* 916 */for (int gx = 0; gx < 5; gx++) {
						/* 917 */if ((i - 2 + gf < 80)
								&& (j - 2 + gx < 50)
								&& (i - 2 + gf > 0)
								&& (j - 2 + gx > 0)
								&& (
								/* 918 */(torches[(i - 2 + gf)][(j - 2 + gx)] == "rightofwall") || (torches[(i - 2 + gf)][(j - 2 + gx)] == "leftofwall")
										|| (torches[(i - 2 + gf)][(j - 2 + gx)] == "underwall") || (torches[(i - 2 + gf)][(j - 2 + gx)] == "abovewall"))) {
							/* 919 */notATorch = false;
						}

					}

				}

				/* 926 */if ((notATorch) &&
				/* 927 */(Game.finalMap[i][j] == "-")) {
					/* 928 */if (Game.finalMap[(i + 1)][j] == "X") {
						/* 929 */counter++;
						/* 930 */if (rand.nextInt(torchrate - counter) == 0) {
							/* 932 */torches[i][j] = "leftofwall";
						}
					}
					/* 935 */if (Game.finalMap[(i - 1)][j] == "X") {
						/* 937 */if (rand.nextInt(torchrate - counter) == 0) {
							/* 939 */torches[i][j] = "rightofwall";
						}
					}
					/* 942 */if (Game.finalMap[i][(j + 1)] == "X") {
						/* 944 */if (rand.nextInt(torchrate - counter) == 0) {
							/* 946 */torches[i][j] = "abovewall";
						}
					}
					/* 949 */if (Game.finalMap[i][(j - 1)] == "X") {
						/* 951 */if (rand.nextInt(torchrate - counter) == 0) {
							/* 953 */torches[i][j] = "under";
						}
					}
					/* 956 */if (counter == 12) {
						/* 957 */counter = 0;
					}
				}
			}

		}

		/* 964 */return torches;
	}

	public String[][] setVariations() {
		/* 969 */String[][] variatiesInVloer = new String[80][50];
		/* 970 */for (int xi = 0; xi < 80; xi++) {
			/* 971 */for (int yi = 0; yi < 50; yi++) {
				/* 972 */if (Game.finalMap[xi][yi].equals("-")) {
					/* 973 */if (this.randomGenerator.nextInt(this.scheurenVerhouding / 2) == 1) {
						/* 974 */variatiesInVloer[xi][yi] = "scheur";
					} else {
						/* 977 */variatiesInVloer[xi][yi] = "";
					}
				}
			}
		}

		/* 983 */return variatiesInVloer;
	}

	public void zoekMuur() {
		do {
			/* 989 */this.nummerX = this.randomGenerator.nextInt(this.mapsizeX);
			/* 990 */this.nummerY = this.randomGenerator.nextInt(this.mapsizeY);
			/* 991 */} while (Game.finalMap[this.nummerX][this.nummerY] != "X");
	}

	public void zoekVrijePlaatsNaast() {
		try {
			/* 997 */if (Game.finalMap[(this.nummerX + 1)][this.nummerY] == "_")
				/* 998 */this.direction = "rechts";
			/* 999 */else if (Game.finalMap[(this.nummerX - 1)][this.nummerY] == "_")
				/* 1000 */this.direction = "links";
			/* 1001 */else if (Game.finalMap[this.nummerX][(this.nummerY + 1)] == "_")
				/* 1002 */this.direction = "onder";
			/* 1003 */else if (Game.finalMap[this.nummerX][(this.nummerY - 1)] == "_")
				/* 1004 */this.direction = "boven";
			else
				try {
					/* 1007 */zoekMuur();
					/* 1008 */zoekVrijePlaatsNaast();
				} catch (Exception localException) {
				}
		} catch (Exception localException1) {
		}
	}

	public void drawScreen(Graphics2D g2) {
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		Player.updateOffSet();
		Player.updateHitting();

		int offsetX = Player.getOffSetX();
		int offsetY = Player.getOffSetY();

		int tileSize = Game.HEIGHT / 9;
		int ScrollX;
		int ScrollY;
		if (this.pla.loc.getX() <= 6) {
			ScrollX = 0;
		} else {
			if (this.pla.loc.getX() >= 74)
				ScrollX = 67;
			else
				ScrollX = this.pla.loc.getX() - 6;
		}

		if (this.pla.loc.getY() <= 4) {
			ScrollY = 0;
		} else {
			if (this.pla.loc.getY() > 45)
				ScrollY = 41;
			else
				ScrollY = this.pla.loc.getY() - 4;
		}
		g2.setColor(Color.BLACK);
		g2.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		if (Game.finalMap != null) {
			for (int xTileOpScherm = 13; xTileOpScherm >= -1; xTileOpScherm--) {
				for (int yTileOpScherm = -1; yTileOpScherm < 10; yTileOpScherm++) {
					try {
						if (Game.finalMap[(ScrollX + xTileOpScherm)][(ScrollY + yTileOpScherm)] == "-") {
							if (Game.finalVariations[(ScrollX + xTileOpScherm)][(ScrollY + yTileOpScherm)].equals("scheur"))
								g2.drawImage(ScheurVloer, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - offsetY * tileSize
										/ Player.timeOneTurn, tileSize, tileSize, null);
							else if (Game.finalVariations[(ScrollX + xTileOpScherm)][(ScrollY + yTileOpScherm)].equals("patroon"))
								g2.drawImage(PatroonVloer, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - offsetY * tileSize
										/ Player.timeOneTurn, tileSize, tileSize, null);
							else if (Game.finalVariations[(ScrollX + xTileOpScherm)][(ScrollY + yTileOpScherm)].equals("put"))
								g2.drawImage(PutVloer, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - offsetY * tileSize
										/ Player.timeOneTurn, tileSize, tileSize, null);
							else
								g2.drawImage(Vloer, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - offsetY * tileSize
										/ Player.timeOneTurn, tileSize, tileSize, null);
						} else if (Game.finalMap[(ScrollX + xTileOpScherm)][(ScrollY + yTileOpScherm)].equals("D")) {
							if (Deuren.getSingleDoor(ScrollX + xTileOpScherm - offsetX * tileSize / Player.timeOneTurn, ScrollY + yTileOpScherm).open) {
								g2.drawImage(Vloer, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - offsetY * tileSize
										/ Player.timeOneTurn, tileSize, tileSize, null);
							} else
								g2.drawImage(Vloer, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - offsetY * tileSize
										/ Player.timeOneTurn, tileSize, tileSize, null);
						} else if (Game.finalMap[(ScrollX + xTileOpScherm)][(ScrollY + yTileOpScherm)].equals("B")) {
							if (Deuren.getSingleDoor(ScrollX + xTileOpScherm, ScrollY + yTileOpScherm).open) {
								g2.drawImage(Vloer, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - offsetY * tileSize
										/ Player.timeOneTurn, tileSize, tileSize, null);
							} else
								g2.drawImage(Vloer, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - offsetY * tileSize
										/ Player.timeOneTurn, tileSize, tileSize, null);

						} else if (Game.finalMap[(ScrollX + xTileOpScherm)][(ScrollY + yTileOpScherm)].equals("_")) {
							g2.drawImage(Void, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - offsetY * tileSize
									/ Player.timeOneTurn, tileSize, tileSize, null);
						}

						for (int x = 0; x < 20; x++) {
							for (int y = 0; y < 20; y++) {
								if (com.thomas.dungeon.Items.Items.Items[((ScrollX + xTileOpScherm) * 20 + x + ((ScrollY + yTileOpScherm) * 20 + y) * 1620)].isItem) {
									g2.drawImage(
											Inventory
													.itemImage(com.thomas.dungeon.Items.Items.Items[((ScrollX + xTileOpScherm) * 20 + x + ((ScrollY + yTileOpScherm) * 20 + y) * 1620)].itemType),
											xTileOpScherm * tileSize + x * (tileSize - tileSize / 3) / 20 - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize + y
													* (tileSize - tileSize / 3) / 20 - offsetY * tileSize / Player.timeOneTurn, tileSize / 3, tileSize / 3, null);
								}
							}
						}

						if ((Game.StairLocationX == ScrollX + xTileOpScherm) && (Game.StairLocationY == ScrollY + yTileOpScherm)) {
							g2.drawImage(Stairs, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - offsetY * tileSize
									/ Player.timeOneTurn, tileSize, tileSize, null);
						}
						if ((Gamehandler.levelLevel != 0) && (ScrollX + xTileOpScherm == LevelArrayList.allLevels.get(Gamehandler.levelLevel - 1).stairX)
								&& (ScrollY + yTileOpScherm == LevelArrayList.allLevels.get(Gamehandler.levelLevel - 1).stairY) && (Gamehandler.levelLevel != 0)) {
							g2.drawImage(StairsDown, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - offsetY * tileSize
									/ Player.timeOneTurn, tileSize, tileSize, null);
						}

						if (Mobs.mob[(ScrollX + xTileOpScherm + (ScrollY + yTileOpScherm) * 80)].isMob) {
							g2.drawImage(Mobs.getMobImage(ScrollX + xTileOpScherm, ScrollY + yTileOpScherm), xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn,
									yTileOpScherm * tileSize - offsetY * tileSize / Player.timeOneTurn, tileSize, tileSize, null);
						}
						if (com.thomas.dungeon.Items.Chests.chestst[(ScrollX + xTileOpScherm + (ScrollY + yTileOpScherm) * 80)].isChest) {
							g2.drawImage(Chest, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - offsetY * tileSize
									/ Player.timeOneTurn, tileSize, tileSize, null);
						}
					} catch (Exception localException) {
						localException.printStackTrace();
					}

				}

			}

		}

		g2.drawImage(Player.getPlayer().getPlayerImage(), (this.pla.loc.getX() - ScrollX) * tileSize, (this.pla.loc.getY() - ScrollY) * tileSize, tileSize, tileSize, null);
		if (Player.hitting) {
			switch (Player.directionHitting) {
			case 0:
				g2.drawImage(Player.getHitImage(), (this.pla.loc.getX() - ScrollX) * tileSize, (this.pla.loc.getY() - ScrollY - 1) * tileSize, tileSize, tileSize, null);
				break;
			case 1:
				g2.drawImage(Player.getHitImage(), (this.pla.loc.getX() - ScrollX + 1) * tileSize, (this.pla.loc.getY() - ScrollY) * tileSize, tileSize, tileSize, null);
				break;
			case 2:
				g2.drawImage(Player.getHitImage(), (this.pla.loc.getX() - ScrollX) * tileSize, (this.pla.loc.getY() - ScrollY + 1) * tileSize, tileSize, tileSize, null);
				break;
			case 3:
				g2.drawImage(Player.getHitImage(), (this.pla.loc.getX() - ScrollX - 1) * tileSize, (this.pla.loc.getY() - ScrollY) * tileSize, tileSize, tileSize, null);
			}
		}

		if (Player.hittingMob) {
			g2.drawImage(Player.getHitImageMob(), (this.pla.loc.getX() - ScrollX) * tileSize, (this.pla.loc.getY() - ScrollY) * tileSize, tileSize, tileSize, null);
		}
		for (int xTileOpScherm = 13; xTileOpScherm >= -1; xTileOpScherm--) {
			for (int yTileOpScherm = -1; yTileOpScherm < 11; yTileOpScherm++) {
				try {
					if (Game.finalMap[(ScrollX + xTileOpScherm)][(ScrollY + yTileOpScherm)] == "X") {
						g2.drawImage(Muur, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - tileSize / 4 - offsetY * tileSize
								/ Player.timeOneTurn, tileSize, tileSize, null);
						if (!TileChecker.equalsUp(ScrollX + xTileOpScherm, ScrollY + yTileOpScherm + 1)) {
							g2.drawImage(Muur, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - tileSize / 4 + tileSize - offsetY
									* tileSize / Player.timeOneTurn, tileSize, tileSize / 4, null);
							if (Game.finalVariations[(ScrollX + xTileOpScherm)][(ScrollY + yTileOpScherm)].equalsIgnoreCase("Ivy")) {
								g2.drawImage(Ivy, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - tileSize / 4 + tileSize - offsetY
										* tileSize / Player.timeOneTurn, tileSize, tileSize / 4, null);
							}
							GradientPaint redtowhite = new GradientPaint(xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize + tileSize
									- offsetY * tileSize / Player.timeOneTurn, Color.black, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, tileSize / 4
									+ yTileOpScherm * tileSize + tileSize - offsetY * tileSize / Player.timeOneTurn, new Color(0, 0, 0, 0));
							g2.setPaint(redtowhite);
							g2.fillRect(xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize + tileSize - offsetY * tileSize
									/ Player.timeOneTurn, tileSize, tileSize / 4);
						}
						if (ScrollY + yTileOpScherm >= 80) {
							g2.drawImage(Muur, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - tileSize / 4 + tileSize - offsetY
									* tileSize / Player.timeOneTurn, tileSize, tileSize / 4, null);

							if (Game.finalVariations[(ScrollX + xTileOpScherm)][(ScrollY + yTileOpScherm)].equalsIgnoreCase("Ivy")) {
								g2.drawImage(Ivy, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - tileSize / 4 + tileSize - offsetY
										* tileSize / Player.timeOneTurn, tileSize, tileSize / 4, null);
							}
							GradientPaint redtowhite = new GradientPaint(xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize + tileSize
									- offsetY * tileSize / Player.timeOneTurn, Color.black, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, tileSize / 4
									+ yTileOpScherm * tileSize + tileSize - offsetY * tileSize / Player.timeOneTurn, new Color(0, 0, 0, 0));
							g2.setPaint(redtowhite);
							g2.fillRect(xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize + tileSize - offsetY * tileSize
									/ Player.timeOneTurn, tileSize, tileSize / 4);
						}
					}
					if (Game.finalMap[(ScrollX + xTileOpScherm)][(ScrollY + yTileOpScherm)] == "x") {
						g2.drawImage(Steen, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - tileSize / 4 - offsetY * tileSize
								/ Player.timeOneTurn, tileSize, tileSize, null);
						if (!TileChecker.equalsUp(ScrollX + xTileOpScherm, ScrollY + yTileOpScherm + 1)) {
							g2.drawImage(Steen, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - tileSize / 4 + tileSize - offsetY
									* tileSize / Player.timeOneTurn, tileSize, tileSize / 4, null);

							GradientPaint redtowhite = new GradientPaint(xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize + tileSize
									- offsetY * tileSize / Player.timeOneTurn, Color.black, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, tileSize / 4
									+ yTileOpScherm * tileSize + tileSize - offsetY * tileSize / Player.timeOneTurn, new Color(0, 0, 0, 0));
							g2.setPaint(redtowhite);
							g2.fillRect(xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize + tileSize - offsetY * tileSize
									/ Player.timeOneTurn, tileSize, tileSize / 4);
						}
						if (ScrollY + yTileOpScherm >= 80) {
							g2.drawImage(Steen, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - tileSize / 4 + tileSize - offsetY
									* tileSize / Player.timeOneTurn, tileSize, tileSize / 4, null);

							GradientPaint redtowhite = new GradientPaint(xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize + tileSize
									- offsetY * tileSize / Player.timeOneTurn, Color.black, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, tileSize / 4
									+ yTileOpScherm * tileSize + tileSize - offsetY * tileSize / Player.timeOneTurn, new Color(0, 0, 0, 0));
							g2.setPaint(redtowhite);
							g2.fillRect(xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize + tileSize - offsetY * tileSize
									/ Player.timeOneTurn, tileSize, tileSize / 4);
						}
					}
				} catch (Exception localException1) {
					localException1.printStackTrace();
				}
			}
		}

		for (int xTileOpScherm = -1; xTileOpScherm < 14; xTileOpScherm++) {
			for (int yTileOpScherm = -1; yTileOpScherm < 10; yTileOpScherm++) {
				try {
					if (Game.finalMap[(ScrollX + xTileOpScherm)][(ScrollY + yTileOpScherm)].equals("B")) {
						if (Deuren.getDoor()[(ScrollX + xTileOpScherm + (ScrollY + yTileOpScherm) * 80)].open) {
							if (Deuren.getDoor()[(ScrollX + xTileOpScherm + (ScrollY + yTileOpScherm) * 80)].geopendNaar)
								g2.drawImage(DeurOverYOpenOnder, xTileOpScherm * tileSize - tileSize / 2 - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize
										- tileSize / 2 - offsetY * tileSize / Player.timeOneTurn, tileSize * 2, tileSize * 2, null);
							else {
								g2.drawImage(DeurOverYOpenBoven, xTileOpScherm * tileSize - tileSize / 2 - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize
										- tileSize / 2 - offsetY * tileSize / Player.timeOneTurn, tileSize * 2, tileSize * 2, null);
							}
						} else {
							g2.drawImage(DeurOverY, xTileOpScherm * tileSize - tileSize / 2 - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - tileSize / 2
									- offsetY * tileSize / Player.timeOneTurn, tileSize * 2, tileSize * 2, null);
						}
					}
					if (Game.finalMap[(ScrollX + xTileOpScherm)][(ScrollY + yTileOpScherm)].equals("D")) {
						if (Deuren.getDoor()[(ScrollX + xTileOpScherm + (ScrollY + yTileOpScherm) * 80)].open) {
							if (Deuren.getDoor()[(ScrollX + xTileOpScherm + (ScrollY + yTileOpScherm) * 80)].geopendNaar)
								g2.drawImage(DeurOverXOpenOnder, xTileOpScherm * tileSize - tileSize / 2 - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize
										- tileSize / 2 + tileSize / 4 + tileSize / 14 - offsetY * tileSize / Player.timeOneTurn, tileSize * 2, tileSize * 2 * 1 / 4, null);
							else {
								g2.drawImage(DeurOverXOpenBoven, xTileOpScherm * tileSize - tileSize / 2 - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize
										- tileSize / 2 + tileSize / 4 + tileSize / 14 - offsetY * tileSize / Player.timeOneTurn, tileSize * 2, tileSize * 2 * 1 / 4, null);
							}
						} else {
							g2.drawImage(DeurOverX, xTileOpScherm * tileSize - tileSize / 2 - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - tileSize / 2 + 1
									- offsetY * tileSize / Player.timeOneTurn, tileSize * 2, tileSize * 2, null);
						}
					}
				} catch (Exception localException2) {
					localException2.printStackTrace();
				}
			}
		}
		for (int xTileOpScherm = -2; xTileOpScherm < 17; xTileOpScherm++) {
			for (int yTileOpScherm = -2; yTileOpScherm < 13; yTileOpScherm++) {
				Color darkColor = new Color(0, 0, 0, 100);

				if ((ScrollX + xTileOpScherm - 1 >= 0)
						&& (ScrollX + xTileOpScherm - 1 < 80)
						&& (ScrollY + yTileOpScherm - 1 >= 0)
						&& (ScrollY + yTileOpScherm - 1 < 50)
						&& ((Game.finalTorches[(ScrollX + xTileOpScherm - 1)][(ScrollY + yTileOpScherm - 1)] == "abovewall")
								|| (Game.finalTorches[(ScrollX + xTileOpScherm - 1)][(ScrollY + yTileOpScherm - 1)] == "underwall")
								|| (Game.finalTorches[(ScrollX + xTileOpScherm - 1)][(ScrollY + yTileOpScherm - 1)] == "leftofwall") || (Game.finalTorches[(ScrollX + xTileOpScherm - 1)][(ScrollY
								+ yTileOpScherm - 1)] == "rig2htofwall"))) {
					float middle = (float) ((xTileOpScherm + 0.5D - 1.0D) * tileSize - offsetX * tileSize / Player.timeOneTurn);
					float middleY = (float) ((yTileOpScherm + 0.5D - 1.0D) * tileSize - offsetY * tileSize / Player.timeOneTurn);
					Point2D center = new Point2D.Float(middle, middleY);
					float radius = tileSize * 3.0F;
					float[] dist = { 0.0F, 0.1F, 0.5F };
					Color[] colors = { new Color(255, 253, 107, 30), new Color(0, 0, 0, 0), darkColor };
					RadialGradientPaint p = new RadialGradientPaint(center, radius, dist, colors);
					g2.setPaint(p);

					g2.fillRect((xTileOpScherm - 2) * tileSize - offsetX * tileSize / Player.timeOneTurn, (yTileOpScherm - 2) * tileSize - offsetY * tileSize / Player.timeOneTurn,
							tileSize * 3, tileSize * 3);
				}

				try {
					if (Game.finalDark[(ScrollX + xTileOpScherm)][(ScrollY + yTileOpScherm)] != 0) {
						g2.setColor(darkColor);
						g2.fillRect(xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - offsetY * tileSize / Player.timeOneTurn,
								tileSize, tileSize);
					}
				} catch (Exception localException3) {
					localException3.printStackTrace();
				}
			}
		}
		for (int xTileOpScherm = -1; xTileOpScherm < 14; xTileOpScherm++) {
			for (int yTileOpScherm = -1; yTileOpScherm < 11; yTileOpScherm++) {
				try {
					if (Game.finalTorches[(ScrollX + xTileOpScherm)][(ScrollY + yTileOpScherm)] == "rig2htofwall") {
						g2.drawImage(Torchrow, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - offsetY * tileSize
								/ Player.timeOneTurn, tileSize, tileSize, null);
					}
					if (Game.finalTorches[(ScrollX + xTileOpScherm)][(ScrollY + yTileOpScherm)] == "leftofwall") {
						g2.drawImage(Torchlow, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - offsetY * tileSize
								/ Player.timeOneTurn, tileSize, tileSize, null);
					}
					if (Game.finalTorches[(ScrollX + xTileOpScherm)][(ScrollY + yTileOpScherm)] == "underwall") {
						g2.drawImage(Torchuw, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - tileSize / 4 - offsetY * tileSize
								/ Player.timeOneTurn, tileSize, tileSize, null);
					}
					if (Game.finalTorches[(ScrollX + xTileOpScherm)][(ScrollY + yTileOpScherm)] == "abovewall") {
						g2.drawImage(Torchaw, xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - tileSize / 4 - offsetY * tileSize
								/ Player.timeOneTurn, tileSize, tileSize, null);
					}
					if (com.thomas.dungeon.Fog.Fog.fogpppart[(ScrollX + xTileOpScherm + (ScrollY + yTileOpScherm) * 80)].halffog) {
						g2.setColor(new Color(0, 0, 0, 100));
						g2.fillRect(xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - offsetY * tileSize / Player.timeOneTurn,
								tileSize, tileSize);
					} else if ((com.thomas.dungeon.Fog.Fog.fogpppart[(ScrollX + xTileOpScherm + (ScrollY + yTileOpScherm) * 80)].fog)
							&& (com.thomas.dungeon.Fog.Fog.fogpppart[(ScrollX + xTileOpScherm + (ScrollY + yTileOpScherm) * 80)].wallfog)) {
						g2.setColor(Color.BLACK);
						g2.fillRect(xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - offsetY * tileSize / Player.timeOneTurn,
								tileSize, tileSize);
					} else if (com.thomas.dungeon.Fog.Fog.fogpppart[(ScrollX + xTileOpScherm + (ScrollY + yTileOpScherm) * 80)].wallfog) {
						g2.setColor(Color.BLACK);
						g2.fillRect(xTileOpScherm * tileSize - offsetX * tileSize / Player.timeOneTurn, yTileOpScherm * tileSize - offsetY * tileSize / Player.timeOneTurn,
								tileSize, tileSize);
					}
				} catch (Exception localException4) {
					localException4.printStackTrace();
				}

			}
		}
	}
}