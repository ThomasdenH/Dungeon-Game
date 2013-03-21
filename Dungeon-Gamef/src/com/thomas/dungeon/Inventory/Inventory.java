package com.thomas.dungeon.Inventory;

import com.thomas.dungeon.ScreenStuff.Screenprinting;

import java.awt.Image;

import java.util.ArrayList;

import java.util.Collections;

import java.util.Comparator;

public class Inventory {
	static int AmountOfItems;
	public static ArrayList<SingleItem> inventory = new ArrayList<SingleItem>();
	public static ArrayList<String> inventorystring = new ArrayList<String>();

	public static void addSingleItem(SingleItem s) {
		inventory.add(s);

		inventory.get(AmountOfItems).type = AmountOfItems;
		AmountOfItems += 1;
	}

	public static int getStringToAmount(String c) {
		for (SingleItem s : inventory) {
			if (s.name == c) {
				return s.amount;
			}
		}
		return 0;
	}

	public static Image getItemImage(int imageType) {
		switch (imageType) {
		case 0:
			return Screenprinting.Iron;
		case 1:
			return Screenprinting.Gold;
		case 2:
			return Screenprinting.Wood;
		case 3:
			return Screenprinting.Cloth;
		case 4:
			return Screenprinting.Tooth;
		case 6:
			return Screenprinting.Bottle;
		case 7:
			return Screenprinting.Bottlewithwater;
		case 8:
			return Screenprinting.Glue;
		case 9:
			return Screenprinting.Glass;
		case 5:
		}
		return null;
	}

	public static void resetInventory() {
		AmountOfItems = 0;
		inventory.removeAll(inventory);
		inventorystring.removeAll(inventorystring);
		for (ItemsEnum x : ItemsEnum.values()) {
			addSingleItem(new SingleItem(x.toStringg()));
			inventorystring.add(x.toStringg());
		}
		Collections.sort(inventory, new Comparator<SingleItem>() {
			@Override
			public int compare(SingleItem o1, SingleItem o2) {
				SingleItem p1 = o1;
				SingleItem p2 = o2;
				return p1.name.compareToIgnoreCase(p2.name);
			}

		});
		Collections.sort(inventory, new Comparator<SingleItem>() {
			@Override
			public int compare(SingleItem o1, SingleItem o2) {
				SingleItem p1 = o1;
				SingleItem p2 = o2;
				return p1.amount < p2.amount ? 1 : -1;
			}

		});
	}

	public static void removeItem(int itemType, int amount) {
		for (SingleItem s : inventory)
			if (s.type == itemType)
				s.amount -= amount;
	}

	public static boolean getIfNegative() {
		for (SingleItem s : inventory) {
			if (s.amount < 0) {
				return true;
			}
		}
		return false;
	}

	public static Image itemImage(int itemType) {
		for (SingleItem s : inventory) {
			if (s.type == itemType) {
				if (s.name.equals("Iron")) {
					return Screenprinting.Iron;
				}
				if (s.name.equals("Gold")) {
					return Screenprinting.Gold;
				}
				if (s.name.equals("Wood")) {
					return Screenprinting.Wood;
				}
				if (s.name.equals("Cloth")) {
					return Screenprinting.Cloth;
				}
				if (s.name.equals("Tooth")) {
					return Screenprinting.Tooth;
				}
				if (s.name.equals("Wall")) {
					return Screenprinting.Muur;
				}
				if (s.name.equals("Bottle")) {
					return Screenprinting.Bottle;
				}
				if (s.name.equals("Bottle with water")) {
					return Screenprinting.Bottlewithwater;
				}
				if (s.name.equals("Glue")) {
					return Screenprinting.Glue;
				}
				if (s.name.equals("Glass")) {
					return Screenprinting.Glass;
				}
			}
		}
		return null;
	}

	public static void addAmountOfItem(int itemType, int amountToAdd) {
		for (SingleItem s : inventory) {
			if (s.type == itemType) {
				s.amount += amountToAdd;
			}
		}
		Collections.sort(inventory, new Comparator<SingleItem>() {
			public int compare(SingleItem o1, SingleItem o2) {
				SingleItem p1 = o1;
				SingleItem p2 = o2;
				return p1.name.compareToIgnoreCase(p2.name);
			}
		});
		Collections.sort(inventory, new Comparator<SingleItem>() {
			public int compare(SingleItem o1, SingleItem o2) {
				SingleItem p1 = o1;
				SingleItem p2 = o2;
				return p1.amount < p2.amount ? 1 : -1;
			}
		});
	}

	public static void addAmountOfItem(String name, int amountToAdd) {
		for (SingleItem s : inventory) {
			if (s.name == name) {
				s.amount += amountToAdd;
			}
		}
		Collections.sort(inventory, new Comparator<SingleItem>() {
			public int compare(SingleItem o1, SingleItem o2) {
				SingleItem p1 = o1;
				SingleItem p2 = o2;
				return p1.name.compareToIgnoreCase(p2.name);
			}
		});
		Collections.sort(inventory, new Comparator<SingleItem>() {
			public int compare(SingleItem o1, SingleItem o2) {
				SingleItem p1 = o1;
				SingleItem p2 = o2;
				return p1.amount < p2.amount ? 1 : -1;
			}
		});
		for (SingleItem s : inventory)
			System.out.println(s.name + ", Amount: " + s.amount);
	}

	public static enum ItemsEnum {
		Iron, Gold, Wood, Cloth, Tooth, Wall, Bottle, Bottle_with_water, Glue, Glass;

		public String toStringg() {
			return toString().replace('_', ' ');
		}

	}

}
