package com.thomas.dungeon.GameTechnical;

import com.thomas.dungeon.Entities.Mobs;
import com.thomas.dungeon.Entities.Player;
import com.thomas.dungeon.Fog.Fog;
import com.thomas.dungeon.Inventory.Inventory;
import com.thomas.dungeon.Items.Chests;
import com.thomas.dungeon.Items.Items;
import com.thomas.dungeon.Level.LevelArrayList;
import com.thomas.dungeon.ScreenStuff.InGameMenu;
import com.thomas.dungeon.ScreenStuff.Screenprinting;
import com.thomas.dungeon.armrupgrades.ItemLevels;
import com.thomas.dungeon.carrying.Crafting;
import com.thomas.dungeon.carrying.CraftingInventory;

public class Gamehandler {
	public static boolean menu = true;
	public static boolean singlePlayerGame = false;
	public static boolean gameOver = false;
	public static int totalTurns;
	private static int hasTurn = 0;

	public static boolean inGameMenuAble = false;
	public static boolean inGameMenu = false;
	public static int levelLevel;
	public static int inGameMenuType;
	public static int inventoryType;
	public static Screenprinting scre = new Screenprinting();
	public static int levelType;
	public static int crafting3;
	public static int crafting;
	public static int armorTypeSelected;
	public static int buyableSelected;

	public static void checkIfMobsHaveTurn() {
		if (hasTurn == 1) {
			Mobs.allMobsTurn();
		}
	}

	public static void configureSinglePlayerGame() {
		LevelArrayList.resetLevel();
		updateLevel();

		Player.getPlayer().health = Player.getMaxHealth();
		Player.getPlayer().XP = 0;
		Player.getPlayer().Level = 1;
		Player.getPlayer().direction = "down";

		Mobs.settings();
		totalTurns = 1;
		hasTurn = 0;

		Game.pla.loc.setX(39);
		Game.pla.loc.setY(25);

		scre.printMap();

		Game.EntitySet();

		Mobs.mobsOnLevel = 0;
		Inventory.resetInventory();
		inGameMenuAble = true;
		Items.resetItems();
		Chests.setChests();
		ItemLevels.resetAllTheLevelsAndStuff();

		Fog.resetFog();
		Fog.fogChange();
		Fog.removeFogOnScreen();

		setLevelType(0);
		InGameMenu.inventoryItems = Inventory.inventory.size();
		Crafting.resetAllTheLevelsAndStuff();
		CraftingInventory.resetThisStuffToo();

		resetAfterNextLevel();
	}

	public static int getHasTurn() {
		return hasTurn;
	}

	public static int getTotalTurns() {
		return totalTurns;
	}

	public static void goBackToMenu() {
		if (gameOver) {
			gameOver = false;
			singlePlayerGame = false;
			menu = true;
			inGameMenuAble = false;
		}
		if ((singlePlayerGame) && (!inGameMenu)) {
			/* 113 */gameOver = false;
			/* 114 */singlePlayerGame = false;
			/* 115 */menu = true;
			/* 116 */inGameMenuAble = false;
		}
		/* 118 */if (inGameMenu)
			/* 119 */inGameMenu = false;
	}

	public static void inGameMenuDown() {
		/* 125 */if (inventoryType == 0) {
			/* 126 */if (InGameMenu.currentIOS < 4) {
				/* 127 */InGameMenu.currentIOS += 1;
			}
			/* 129 */else if (InGameMenu.currentInventoryOnScreen < InGameMenu.inventoryItems - InGameMenu.inventoryItemsOnScreen) {
				/* 130 */InGameMenu.currentInventoryOnScreen += 1;
			}
		}

		/* 134 */if ((inventoryType == 1) &&
		/* 135 */(armorTypeSelected < 3)) {
			/* 136 */armorTypeSelected += 1;
		}

		/* 140 */if (inventoryType == 2)
			/* 141 */if (crafting3 < 2) {
				/* 142 */crafting3 += 1;
			}
			/* 144 */else if (crafting < Crafting.buyItems.size() - 3)
				/* 145 */crafting += 1;
	}

	public static void inGameMenuLeft() {
		/* 152 */if (inventoryType > 0)
			/* 153 */inventoryType -= 1;
	}

	public static void inGameMenuRight() {
		/* 158 */if (inventoryType < 2)
			/* 159 */inventoryType += 1;
	}

	public static void inGameMenuUp() {
		/* 164 */if (inventoryType == 0) {
			/* 165 */if (InGameMenu.currentIOS > 0) {
				/* 166 */InGameMenu.currentIOS -= 1;
			}
			/* 168 */else if (InGameMenu.currentInventoryOnScreen > 0) {
				/* 169 */InGameMenu.currentInventoryOnScreen -= 1;
			}
		}

		/* 173 */if ((inventoryType == 1) &&
		/* 174 */(armorTypeSelected > 0)) {
			/* 175 */armorTypeSelected -= 1;
		}

		/* 179 */if (inventoryType == 2)
			/* 180 */if (crafting3 > 0) {
				/* 181 */crafting3 -= 1;
			}
			/* 183 */else if (crafting > 0)
				/* 184 */crafting -= 1;
	}

	public static void nextTurn() {
		if (hasTurn >= totalTurns)
			hasTurn = 0;
		else {
			hasTurn += 1;
		}
		Player.getPlayer().checkLevel();
		Mobs.checkForNeedToSpawnMob();
		Mobs.despawnDied();
		Items.checkForNeedToPickupItem();
		Gamehandler.checkIfMobsHaveTurn();
		Chests.checkForNeedToAddChests();
		Fog.fogChange();
		Fog.removeFogOnScreen();
	}

	public static void resetAfterNextLevel() {
		Mobs.settings();

		Game.finalTorches = LevelArrayList.setTorches();
		Game.finalDark = LevelArrayList.setDark();
		Game.finalVariations = LevelArrayList.setVariations();

		Game.EntitySet();

		Mobs.mobsOnLevel = 0;

		Fog.resetFog();
		Fog.fogChange();
		Fog.removeFogOnScreen();

		Chests.setChests();
		LevelArrayList.resetBlockHealth();
	}

	public static void setGameOver() {
		/* 226 */gameOver = true;
		/* 227 */singlePlayerGame = false;
		/* 228 */menu = false;
		/* 229 */inGameMenuAble = false;
		/* 230 */inGameMenu = false;
	}

	public static void setHasTurn(int hassTurn) {
		/* 235 */hasTurn = hassTurn;
		/* 236 */checkIfMobsHaveTurn();
		/* 237 */Player.getPlayer().checkLevel();
		/* 238 */Items.checkForNeedToPickupItem();
	}

	public static void setInGameMenu(int type) {
		/* 242 */inGameMenu = true;
		/* 243 */inGameMenuType = type;
	}

	public static void setLevelType(int LevelType) {
		/* 248 */levelType = LevelType;
	}

	public static void setTotalTurns(int totallTurns) {
		/* 252 */totalTurns = totallTurns;
	}

	public static void updateLevel() {
		Game.finalMap = LevelArrayList.getLevel();
		Game.StairLocationX = LevelArrayList.getStairIntX();
		Game.StairLocationY = LevelArrayList.getStairIntY();
		System.out.println(levelLevel);
	}

	public Gamehandler() {
		menu = true;
	}

}

/*
 * Location: C:\Users\Thomas\Dropbox\Java source\RPG\RPGGame.jar Qualified Name:
 * com.thomas.dungeon.GameTechnical.Gamehandler JD-Core Version: 0.6.2
 */