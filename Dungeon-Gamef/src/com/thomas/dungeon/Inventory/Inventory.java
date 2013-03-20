/*     */ package com.thomas.dungeon.Inventory;
/*     */ 
/*     */ import com.thomas.dungeon.ScreenStuff.Screenprinting;
/*     */ import java.awt.Image;
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ 
/*     */ public class Inventory
/*     */ {
/*     */   static int AmountOfItems;
/*  31 */   public static ArrayList<SingleItem> inventory = new ArrayList();
/*  32 */   public static ArrayList<String> inventorystring = new ArrayList();
/*     */ 
/*     */   public static void addSingleItem(SingleItem s) {
/*  35 */     inventory.add(s);
/*     */ 
/*  37 */     ((SingleItem)inventory.get(AmountOfItems)).type = AmountOfItems;
/*  38 */     AmountOfItems += 1;
/*     */   }
/*     */ 
/*     */   public static int getStringToAmount(String c) {
/*  42 */     for (SingleItem s : inventory) {
/*  43 */       if (s.name == c) {
/*  44 */         return s.amount;
/*     */       }
/*     */     }
/*  47 */     return 0;
/*     */   }
/*     */ 
/*     */   public static Image getItemImage(int imageType) {
/*  51 */     switch (imageType) {
/*     */     case 0:
/*  53 */       return Screenprinting.Iron;
/*     */     case 1:
/*  55 */       return Screenprinting.Gold;
/*     */     case 2:
/*  57 */       return Screenprinting.Wood;
/*     */     case 3:
/*  59 */       return Screenprinting.Cloth;
/*     */     case 4:
/*  61 */       return Screenprinting.Tooth;
/*     */     case 6:
/*  63 */       return Screenprinting.Bottle;
/*     */     case 7:
/*  65 */       return Screenprinting.Bottlewithwater;
/*     */     case 8:
/*  67 */       return Screenprinting.Glue;
/*     */     case 9:
/*  69 */       return Screenprinting.Glass;
/*     */     case 5:
/*  71 */     }return null;
/*     */   }
/*     */ 
/*     */   public static void resetInventory() {
/*  75 */     AmountOfItems = 0;
/*  76 */     inventory.removeAll(inventory);
/*  77 */     inventorystring.removeAll(inventorystring);
/*  78 */     for (ItemsEnum x : ItemsEnum.values()) {
/*  79 */       addSingleItem(new SingleItem(x.toStringg()));
/*  80 */       inventorystring.add(x.toStringg());
/*     */     }
/*  82 */     Collections.sort(inventory, new Comparator(){
/*     */       public int compare(SingleItem o1, SingleItem o2) {
/*  84 */         SingleItem p1 = o1;
/*  85 */         SingleItem p2 = o2;
/*  86 */         return p1.name.compareToIgnoreCase(p2.name);
/*     */       }
/*     */

@Override
public int compare(Object o1, Object o2) {
	// TODO Auto-generated method stub
	return 0;
}     });
/*  90 */     Collections.sort(inventory, new Comparator() {
/*     */       public int compare(SingleItem o1, SingleItem o2) {
/*  92 */         SingleItem p1 = o1;
/*  93 */         SingleItem p2 = o2;
/*  94 */         return p1.amount < p2.amount ? 1 : -1;
/*     */       }
/*     */

@Override
public int compare(Object o1, Object o2) {
	// TODO Auto-generated method stub
	return 0;
}     });
/*     */   }
/*     */ 
/*     */   public static void removeItem(int itemType, int amount)
/*     */   {
/* 102 */     for (SingleItem s : inventory)
/* 103 */       if (s.type == itemType)
/* 104 */         s.amount -= amount;
/*     */   }
/*     */ 
/*     */   public static boolean getIfNegative()
/*     */   {
/* 110 */     for (SingleItem s : inventory) {
/* 111 */       if (s.amount < 0) {
/* 112 */         return true;
/*     */       }
/*     */     }
/* 115 */     return false;
/*     */   }
/*     */ 
/*     */   public static Image itemImage(int itemType) {
/* 119 */     for (SingleItem s : inventory) {
/* 120 */       if (s.type == itemType) {
/* 121 */         if (s.name.equals("Iron")) {
/* 122 */           return Screenprinting.Iron;
/*     */         }
/* 124 */         if (s.name.equals("Gold")) {
/* 125 */           return Screenprinting.Gold;
/*     */         }
/* 127 */         if (s.name.equals("Wood")) {
/* 128 */           return Screenprinting.Wood;
/*     */         }
/* 130 */         if (s.name.equals("Cloth")) {
/* 131 */           return Screenprinting.Cloth;
/*     */         }
/* 133 */         if (s.name.equals("Tooth")) {
/* 134 */           return Screenprinting.Tooth;
/*     */         }
/* 136 */         if (s.name.equals("Wall")) {
/* 137 */           return Screenprinting.Muur;
/*     */         }
/* 139 */         if (s.name.equals("Bottle")) {
/* 140 */           return Screenprinting.Bottle;
/*     */         }
/* 142 */         if (s.name.equals("Bottle with water")) {
/* 143 */           return Screenprinting.Bottlewithwater;
/*     */         }
/* 145 */         if (s.name.equals("Glue")) {
/* 146 */           return Screenprinting.Glue;
/*     */         }
/* 148 */         if (s.name.equals("Glass")) {
/* 149 */           return Screenprinting.Glass;
/*     */         }
/*     */       }
/*     */     }
/* 153 */     return null;
/*     */   }
/*     */ 
/*     */   public static void addAmountOfItem(int itemType, int amountToAdd) {
/* 157 */     for (SingleItem s : inventory) {
/* 158 */       if (s.type == itemType) {
/* 159 */         s.amount += amountToAdd;
/*     */       }
/*     */     }
/* 162 */     Collections.sort(inventory, new Comparator() {
/*     */       public int compare(SingleItem o1, SingleItem o2) {
/* 164 */         SingleItem p1 = o1;
/* 165 */         SingleItem p2 = o2;
/* 166 */         return p1.name.compareToIgnoreCase(p2.name);
/*     */       }
/*     */

@Override
public int compare(Object o1, Object o2) {
	// TODO Auto-generated method stub
	return 0;
}     });
/* 170 */     Collections.sort(inventory, new Comparator() {
/*     */       public int compare(SingleItem o1, SingleItem o2) {
/* 172 */         SingleItem p1 = o1;
/* 173 */         SingleItem p2 = o2;
/* 174 */         return p1.amount < p2.amount ? 1 : -1;
/*     */       }
/*     */

@Override
public int compare(Object o1, Object o2) {
	// TODO Auto-generated method stub
	return 0;
}     });
/*     */   }
/*     */ 
/*     */   public static void addAmountOfItem(String name, int amountToAdd)
/*     */   {
/* 182 */     for (SingleItem s : inventory) {
/* 183 */       if (s.name == name) {
/* 184 */         s.amount += amountToAdd;
/*     */       }
/*     */     }
/* 187 */     Collections.sort(inventory, new Comparator() {
/*     */       public int compare(SingleItem o1, SingleItem o2) {
/* 189 */         SingleItem p1 = o1;
/* 190 */         SingleItem p2 = o2;
/* 191 */         return p1.name.compareToIgnoreCase(p2.name);
/*     */       }
/*     */

@Override
public int compare(Object o1, Object o2) {
	// TODO Auto-generated method stub
	return 0;
}     });
/* 195 */     Collections.sort(inventory, new Comparator() {
/*     */       public int compare(SingleItem o1, SingleItem o2) {
/* 197 */         SingleItem p1 = o1;
/* 198 */         SingleItem p2 = o2;
/* 199 */         return p1.amount < p2.amount ? 1 : -1;
/*     */       }
/*     */

@Override
public int compare(Object o1, Object o2) {
	// TODO Auto-generated method stub
	return 0;
}     });
/* 203 */     for (SingleItem s : inventory)
/* 204 */       System.out.println(s.name + ", Amount: " + s.amount);
/*     */   }
/*     */ 
/*     */   public static enum ItemsEnum
/*     */   {
/*  12 */     Iron, 
/*  13 */     Gold, 
/*  14 */     Wood, 
/*  15 */     Cloth, 
/*  16 */     Tooth, 
/*  17 */     Wall, 
/*  18 */     Bottle, 
/*  19 */     Bottle_with_water, 
/*  20 */     Glue, 
/*  21 */     Glass;
/*     */ 
/*     */     public String toStringg() {
/*  24 */       return toString().replace('_', ' ');
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Thomas\Dropbox\Java source\RPG\RPGGame.jar
 * Qualified Name:     com.thomas.dungeon.Inventory.Inventory
 * JD-Core Version:    0.6.2
 */