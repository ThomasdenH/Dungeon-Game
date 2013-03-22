package com.thomas.dungeon.Level;

import com.thomas.dungeon.GameTechnical.Gamehandler;
import com.thomas.dungeon.ScreenStuff.Screenprinting;
import java.util.ArrayList;
import java.util.Random;

public class LevelArrayList {
	/* 12 */public static ArrayList<LevelNiveau> allLevels = new ArrayList<LevelNiveau>();

	/* 14 */static Random rand = new Random();

	/* 16 */static String direction = null;

	/* 18 */public static int scheurenVerhouding = 20;
	public static int kamerTeBouwen;
	public static int nummerX;
	public static int nummerY;
	public static boolean torchesDone;
	/* 382 */public int correction = 15;
	public boolean done;

	public static void addLevel(int level) {
		try {
			/* 30 */allLevels.get(level);
		} catch (IndexOutOfBoundsException e) {
			/* 32 */allLevels.add(level, new LevelNiveau(makeMap()));
		}
	}

	public static String[][] getLevel() {
		/* 38 */if (Gamehandler.levelLevel >= allLevels.size()) {
			/* 39 */allLevels.add(Gamehandler.levelLevel, new LevelNiveau(makeMap()));
		}

		/* 42 */return allLevels.get(Gamehandler.levelLevel).levelString;
	}

	public static int getStairIntX() {
		/* 46 */if (allLevels.get(Gamehandler.levelLevel).stairX == 0) {
			/* 47 */boolean doneeeve = false;
			/* 48 */int tried = 0;
			do {
				/* 50 */allLevels.get(Gamehandler.levelLevel).stairX = rand.nextInt(80);
				/* 51 */allLevels.get(Gamehandler.levelLevel).stairY = rand.nextInt(50);
				/* 52 */if (allLevels.get(Gamehandler.levelLevel).levelString[allLevels.get(Gamehandler.levelLevel).stairX][allLevels.get(Gamehandler.levelLevel).stairY]
						.equals("-"))
					/* 53 */doneeeve = true;
				else
					/* 55 */tried++;
			}
			/* 57 */while ((!doneeeve) && (tried < 20000));
		}
		/* 59 */return allLevels.get(Gamehandler.levelLevel).stairX;
	}

	public static int getStairIntY() {
		/* 63 */return allLevels.get(Gamehandler.levelLevel).stairY;
	}

	public static synchronized String[][] makeMap() {
		/* 67 */allLevels.add(Gamehandler.levelLevel, new LevelNiveau(new String[80][50]));
		/* 68 */Screenprinting.loadImages();
		/* 69 */for (int x = 0; x < 80; x++) {
			/* 70 */for (int y = 0; y < 50; y++) {
				/* 71 */allLevels.get(Gamehandler.levelLevel).levelString[x][y] = new String();
			}
		}
		/* 74 */for (int Y = 0; Y < 50; Y++) {
			/* 75 */for (int X = 0; X < 80; X++) {
				/* 76 */allLevels.get(Gamehandler.levelLevel).levelString[X][Y] = "_";
			}
		}
		/* 79 */Rooms ro = new Rooms();

		/* 81 */ro.beginningCourse(36, 21, allLevels.get(Gamehandler.levelLevel).levelString);

		/* 83 */for (int loop = 0; loop < 400; loop++) {
			/* 85 */kamerTeBouwen = rand.nextInt(3);

			/* 87 */zoekMuur();
			/* 88 */zoekVrijePlaatsNaast();

			/* 90 */switch (kamerTeBouwen) {
			case 1:
				/* 92 */ro.gang(nummerX, nummerY, allLevels.get(Gamehandler.levelLevel).levelString, direction);
				/* 93 */break;
			case 2:
				/* 95 */ro.echteGang(nummerX, nummerY, allLevels.get(Gamehandler.levelLevel).levelString, direction);
				/* 96 */break;
			default:
				/* 98 */ro.gang(nummerX, nummerY, allLevels.get(Gamehandler.levelLevel).levelString, direction);
			}

		}

		/* 103 */replaceDoors();
		/* 104 */Rooms.makePilars(allLevels.get(Gamehandler.levelLevel).levelString);
		/* 105 */allLevels.get(0).levelString[39][25] = "-";

		/* 107 */for (int x = 0; x < 80; x++) {
			/* 108 */for (int y = 0; y < 50; y++) {
				/* 109 */if (allLevels.get(Gamehandler.levelLevel).levelString[x][y] == "_") {
					/* 110 */allLevels.get(Gamehandler.levelLevel).levelString[x][y] = "x";
				}
			}
		}
		/* 114 */getStairIntX();
		/* 115 */resetBlockHealth();

		/* 117 */return allLevels.get(Gamehandler.levelLevel).levelString;
	}

	public static void replaceDoors() {
		/* 122 */for (int i = 0; i < 80; i++)
			/* 123 */for (int j = 0; j < 50; j++)
				/* 124 */if ((allLevels.get(Gamehandler.levelLevel).levelString[i][j].equals("D")) || (allLevels.get(Gamehandler.levelLevel).levelString[i][j].equals("B"))) {
					/* 125 */plaatsVoorDeur plts = new plaatsVoorDeur();
					/* 126 */plts.setX(i);
					/* 127 */plts.setY(j);

					/* 129 */if (allLevels.get(Gamehandler.levelLevel).levelString[(i + 1)][j].equals("B")) {
						/* 130 */plts.setRichting(1);
						/* 131 */boolean volgende = true;
						/* 132 */int counter = 1;
						do
							/* 134 */if (allLevels.get(Gamehandler.levelLevel).levelString[(i + counter)][j].equals("B")) {
								/* 135 */plts.aantalOpEenRijPlusEen();
								/* 136 */counter++;
							} else {
								/* 139 */volgende = false;
							}
						/* 133 */while (
						/* 141 */volgende);
						/* 142 */if (plts.getAOER() > 0) {
							/* 143 */plts.behoudEenDeur(allLevels.get(Gamehandler.levelLevel).levelString);
						}
					}
					/* 146 */if (allLevels.get(Gamehandler.levelLevel).levelString[i][(j + 1)].equals("D")) {
						/* 147 */plts.setRichting(2);
						/* 148 */boolean volgendeY = true;
						/* 149 */int counterY = 1;
						do
							/* 151 */if (allLevels.get(Gamehandler.levelLevel).levelString[i][(j + counterY)].equals("D")) {
								/* 152 */plts.aantalOpEenRijPlusEen();
								/* 153 */counterY++;
							} else {
								/* 156 */volgendeY = false;
							}
						/* 150 */while (
						/* 158 */volgendeY);
						/* 159 */if (plts.getAOER() > 0)
							/* 160 */plts.behoudEenDeur(allLevels.get(Gamehandler.levelLevel).levelString);
					}
				}
	}

	public static void reset() {
		/* 173 */allLevels = new ArrayList<LevelNiveau>();
	}

	public static void resetBlockHealth() {
		/* 177 */allLevels.get(Gamehandler.levelLevel).levelString[allLevels.get(Gamehandler.levelLevel).stairX][allLevels.get(Gamehandler.levelLevel).stairY] = "-";

		/* 179 */for (int x = 0; x < 80; x++) {
			/* 180 */for (int y = 0; y < 50; y++) {
				/* 181 */allLevels.get(Gamehandler.levelLevel).blockHealth[x][y] = 0;
			}
		}
		/* 184 */for (int x = 0; x < 80; x++) {
			/* 185 */for (int y = 0; y < 50; y++) {
				/* 186 */if (allLevels.get(Gamehandler.levelLevel).levelString[x][y] == "X")
					/* 187 */allLevels.get(Gamehandler.levelLevel).blockHealth[x][y] = 20;
				/* 188 */else if (allLevels.get(Gamehandler.levelLevel).levelString[x][y] == "x")
					/* 189 */allLevels.get(Gamehandler.levelLevel).blockHealth[x][y] = 18;
				/* 190 */else if (allLevels.get(Gamehandler.levelLevel).levelString[x][y] == "D")
					/* 191 */allLevels.get(Gamehandler.levelLevel).blockHealth[x][y] = 10;
				/* 192 */else if (allLevels.get(Gamehandler.levelLevel).levelString[x][y] == "B")
					/* 193 */allLevels.get(Gamehandler.levelLevel).blockHealth[x][y] = 10;
				else {
					/* 195 */allLevels.get(Gamehandler.levelLevel).blockHealth[x][y] = 10;
				}
			}
		}

		/* 200 */for (int x = 0; x < 80; x++) {
			/* 201 */for (int y = 0; y < 50; y++) {
				/* 202 */System.out.print(allLevels.get(Gamehandler.levelLevel).blockHealth[x][y]);
			}
			/* 204 */System.out.println();
		}
	}

	public static void resetLevel() {
		/* 209 */allLevels = new ArrayList<LevelNiveau>();
		/* 210 */Gamehandler.levelLevel = 0;
	}

	public static int[][] setDark() {
		/* 215 */int[][] dark = new int[80][50];

		/* 217 */for (int xTile = 0; xTile < 80; xTile++) {
			/* 218 */for (int yTile = 0; yTile < 50; yTile++) {
				/* 220 */boolean testdark = true;
				try {
					/* 222 */for (int gf = 0; gf < 3; gf++) {
						/* 223 */for (int gx = 0; gx < 3; gx++) {
							/* 224 */if ((com.thomas.dungeon.GameTechnical.Game.finalTorches[(xTile - 1 + gf)][(yTile - 1 + gx)] == "rightofwall")
									|| (com.thomas.dungeon.GameTechnical.Game.finalTorches[(xTile - 1 + gf)][(yTile - 1 + gx)] == "leftofwall")
									|| (com.thomas.dungeon.GameTechnical.Game.finalTorches[(xTile - 1 + gf)][(yTile - 1 + gx)] == "underwall") ||
									/* 225 */(com.thomas.dungeon.GameTechnical.Game.finalTorches[(xTile - 1 + gf)][(yTile - 1 + gx)] == "abovewall")) {
								/* 226 */testdark = false;
							}
						}
					}
				} catch (Exception localException) {
				}
				/* 234 */if (testdark) {
					/* 235 */dark[xTile][yTile] = 1;
				}

			}

		}

		/* 243 */return dark;
	}

	public static String[][] setTorches() {
		/* 247 */torchesDone = false;
		/* 248 */if (allLevels.get(Gamehandler.levelLevel).torches == null) {
			/* 250 */String[][] torches = new String[80][50];

			/* 252 */Random rand = new Random();
			/* 253 */int torchrate = 16;
			/* 254 */int counter = 0;
			/* 255 */for (int i = 0; i < 80; i++) {
				/* 256 */for (int j = 0; j < 50; j++) {
					/* 257 */boolean notATorch = true;

					/* 259 */for (int gf = 0; gf < 5; gf++) {
						/* 260 */for (int gx = 0; gx < 5; gx++) {
							/* 261 */if ((i - 2 + gf < 80)
									&& (j - 2 + gx < 50)
									&& (i - 2 + gf > 0)
									&& (j - 2 + gx > 0)
									&& (
									/* 262 */(torches[(i - 2 + gf)][(j - 2 + gx)] == "rightofwall") || (torches[(i - 2 + gf)][(j - 2 + gx)] == "leftofwall")
											|| (torches[(i - 2 + gf)][(j - 2 + gx)] == "underwall") || (torches[(i - 2 + gf)][(j - 2 + gx)] == "abovewall"))) {
								/* 263 */notATorch = false;
							}

						}

					}

					/* 270 */if ((notATorch) &&
					/* 271 */(allLevels.get(Gamehandler.levelLevel).levelString[i][j] == "-")) {
						/* 272 */if (allLevels.get(Gamehandler.levelLevel).levelString[(i + 1)][j] == "X") {
							/* 273 */counter++;
							/* 274 */if (rand.nextInt(torchrate - counter) == 0) {
								/* 276 */torches[i][j] = "leftofwall";
							}
						}
						/* 279 */if (allLevels.get(Gamehandler.levelLevel).levelString[(i - 1)][j] == "X") {
							/* 281 */if (rand.nextInt(torchrate - counter) == 0) {
								/* 283 */torches[i][j] = "rightofwall";
							}
						}
						/* 286 */if (allLevels.get(Gamehandler.levelLevel).levelString[i][(j + 1)] == "X") {
							/* 288 */if (rand.nextInt(torchrate - counter) == 0) {
								/* 290 */torches[i][j] = "abovewall";
							}
						}
						/* 293 */if (allLevels.get(Gamehandler.levelLevel).levelString[i][(j - 1)] == "X") {
							/* 295 */if (rand.nextInt(torchrate - counter) == 0) {
								/* 297 */torches[i][j] = "under";
							}
						}
						/* 300 */if (counter == 12) {
							/* 301 */counter = 0;
						}
					}
				}
			}

			/* 307 */allLevels.get(Gamehandler.levelLevel).torches = torches;
			/* 308 */torchesDone = true;
		}

		/* 312 */return allLevels.get(Gamehandler.levelLevel).torches;
	}

	public static String[][] setVariations() {
		/* 316 */if (allLevels.get(Gamehandler.levelLevel).variations == null) {
			/* 317 */String[][] variatiesInVloer = new String[80][50];
			/* 318 */for (int xi = 0; xi < 80; xi++) {
				/* 319 */for (int yi = 0; yi < 50; yi++) {
					/* 320 */variatiesInVloer[xi][yi] = new String();
				}
			}
			/* 323 */for (int xi = 0; xi < 80; xi++) {
				/* 324 */for (int yi = 0; yi < 50; yi++) {
					/* 325 */if (allLevels.get(Gamehandler.levelLevel).levelString[xi][yi].equals("-")) {
						/* 326 */if (rand.nextInt(scheurenVerhouding / 2) == 0) {
							/* 327 */variatiesInVloer[xi][yi] = "scheur";
						}
						/* 329 */else if (rand.nextInt(scheurenVerhouding) == 0) {
							/* 330 */variatiesInVloer[xi][yi] = "patroon";
						}
						/* 332 */else if (rand.nextInt(scheurenVerhouding * 4) == 0) {
							/* 333 */variatiesInVloer[xi][yi] = "put";
						} else {
							/* 336 */variatiesInVloer[xi][yi] = "";
						}
					}
				}
			}

			/* 342 */allLevels.get(Gamehandler.levelLevel).variations = variatiesInVloer;
		}

		/* 345 */return allLevels.get(Gamehandler.levelLevel).variations;
	}

	public static void zoekMuur() {
		do {
			/* 352 */nummerX = rand.nextInt(80);
			/* 353 */nummerY = rand.nextInt(50);
			/* 354 */} while (allLevels.get(Gamehandler.levelLevel).levelString[nummerX][nummerY] != "X");
	}

	public static void zoekVrijePlaatsNaast() {
		try {
			/* 360 */if (allLevels.get(Gamehandler.levelLevel).levelString[(nummerX + 1)][nummerY] == "_")
				/* 361 */direction = "rechts";
			/* 362 */else if (allLevels.get(Gamehandler.levelLevel).levelString[(nummerX - 1)][nummerY] == "_")
				/* 363 */direction = "links";
			/* 364 */else if (allLevels.get(Gamehandler.levelLevel).levelString[nummerX][(nummerY + 1)] == "_")
				/* 365 */direction = "onder";
			/* 366 */else if (allLevels.get(Gamehandler.levelLevel).levelString[nummerX][(nummerY - 1)] == "_")
				/* 367 */direction = "boven";
			else
				try {
					/* 370 */zoekMuur();
					/* 371 */zoekVrijePlaatsNaast();
				} catch (Exception localException1) {
				}
		} catch (Exception localException2) {
		}
	}

	public boolean getDone() {
		/* 387 */return this.done;
	}

	public String[][] getMap() {
		/* 391 */return allLevels.get(Gamehandler.levelLevel).levelString;
	}

	public void printMap() {
	}
}

/*
 * Location: C:\Users\Thomas\Dropbox\Java source\RPG\RPGGame.jar Qualified Name:
 * com.thomas.dungeon.Level.LevelArrayList JD-Core Version: 0.6.2
 */