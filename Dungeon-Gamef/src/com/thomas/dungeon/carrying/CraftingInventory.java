/*    */ package com.thomas.dungeon.carrying;
/*    */ 
/*    */ import com.thomas.dungeon.ScreenStuff.Screenprinting;
/*    */ import java.awt.Image;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.Comparator;
/*    */ 
/*    */ public class CraftingInventory
/*    */ {
/* 28 */   public static ArrayList<CraftableInv> craftedItems = new ArrayList<CraftableInv>();
/*    */ 
/*    */   public static void resetThisStuffToo() {
/* 31 */     craftedItems = new ArrayList<CraftableInv>();
/*    */ 
/* 33 */     for (craftAbleEnum b : craftAbleEnum.values()) {
/* 34 */       craftedItems.add(new CraftableInv(b.toString()));
/*    */     }
/*    */ 
/* 37 */     sort();
/*    */   }
/*    */ 
/*    */   public static void addItemAmount(int Item, int Amount) {
/* 41 */     craftedItems.get(Item).amountOf += Amount;
/* 42 */     sort();
/*    */   }
/*    */ 
/*    */   public static void addItem(int Item) {
/* 46 */     craftedItems.get(Item).amountOf += 1;
/* 47 */     sort();
/*    */   }
/*    */ 
/*    */   public static void addItem(String Item)
/*    */   {
/* 52 */     for (CraftableInv e : craftedItems) {
/* 53 */       if (e.name.equals(Item)) {
/* 54 */         e.amountOf += 1;
/*    */       }
/*    */     }
/* 57 */     sort();
/*    */   }
/*    */ 
/*    */   public static void sort()
/*    */   {
/* 62 */     Collections.sort(craftedItems, new Comparator<Object>() {
@Override
public int compare(Object arg0, Object arg1) {
	// TODO Auto-generated method stub
	return 0;
}     });
/* 70 */     Collections.sort(craftedItems, new Comparator<Object>() {
@Override
public int compare(Object o1, Object o2) {
	// TODO Auto-generated method stub
	return 0;
}     });
/*    */   }
/*    */ 
/*    */   public static Image getItemImage(int ItemTypeLocation)
/*    */   {
/* 81 */     if (ItemTypeLocation >= craftedItems.size()) {
/* 82 */       return null;
/*    */     }
/* 84 */     if (craftedItems.get(ItemTypeLocation).name.equals("Wall")) {
/* 85 */       return Screenprinting.Muur;
/*    */     }
/* 87 */     return null;
/*    */   }
/*    */ 
/*    */   public static enum craftAbleEnum
/*    */   {
/* 13 */     Wall("Wall"), 
/* 14 */     Explosive("Explosive"), 
/* 15 */     BigExplosive("Big explosive");
/*    */ 
/*    */     private final String displayName;
/*    */ 
/* 19 */     private craftAbleEnum(String s) { this.displayName = s; }
/*    */ 
/*    */ 
/*    */     @Override
public String toString()
/*    */     {
/* 24 */       return this.displayName;
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Thomas\Dropbox\Java source\RPG\RPGGame.jar
 * Qualified Name:     com.thomas.dungeon.carrying.CraftingInventory
 * JD-Core Version:    0.6.2
 */