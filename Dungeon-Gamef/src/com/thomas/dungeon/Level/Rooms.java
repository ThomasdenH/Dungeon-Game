/*     */ package com.thomas.dungeon.Level;
/*     */ 
/*     */ import com.thomas.dungeon.GameTechnical.TileChecker;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Random;
/*     */ 
/*     */ public class Rooms
/*     */ {
/*   9 */   String vloer = "-";
/*  10 */   String muur = "X";
/*  11 */   String beginpunt = "Y";
/*  12 */   String deurOverX = "D";
/*  13 */   String deurOverY = "B";
/*     */ 
/*  16 */   int doorChange = 2;
/*  17 */   public static Random rand = new Random();
/*     */   int ganglengte;
/*     */   int gangbreedte;
/*     */   static int pilX;
/*     */   static int pilY;
/*     */   int murenOmheen;
/*     */   public static boolean shouldBuildPilar;
/* 788 */   ArrayList<Room> kamers = new ArrayList<Room>();
/*     */ 
/*     */   public String[][] beginningCourse(int locationX, int locationY, String[][] map)
/*     */   {
/*  20 */     if ((locationX + 10 < map.length) && (locationY + 10 < map[0].length))
/*     */     {
/*  23 */       for (int i = 0; i < 9; i++) {
/*  24 */         for (int j = 0; j < 8; j++) {
/*  25 */           map[(locationX + i - 1)][(locationY + j)] = this.vloer;
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*  30 */       for (int i = 0; i < 9; i++) {
/*  31 */         map[(locationX + i - 1)][locationY] = this.muur;
/*     */       }
/*     */ 
/*  34 */       for (int i = 0; i < 9; i++) {
/*  35 */         map[(locationX + i - 1)][(locationY + 8)] = this.muur;
/*     */       }
/*     */ 
/*  38 */       for (int i = 0; i < 7; i++) {
/*  39 */         map[(locationX - 1)][(locationY + i + 1)] = this.muur;
/*     */       }
/*     */ 
/*  42 */       for (int i = 0; i < 7; i++) {
/*  43 */         map[(locationX + 7)][(locationY + i + 1)] = this.muur;
/*     */       }
/*     */ 
/*  46 */       map[(locationX + 3)][(locationY + 4)] = this.vloer;
/*     */ 
/*  48 */       return map;
/*     */     }
/*     */ 
/*  51 */     return map;
/*     */   }
/*     */ 
/*     */   public String[][] gang(int locationX, int locationY, String[][] map, String direction)
/*     */   {
/*  59 */     int ganglengte = rand.nextInt(3) + 4;
/*  60 */     int gangbreedte = rand.nextInt(3) + 4;
/*     */ 
/*  62 */     if (direction.equals("rechts"))
/*     */     {
/*  64 */       boolean shouldBuild = true;
/*  65 */       if ((locationX < 0) || (locationX + ganglengte + 2 > map.length) || (locationY - 1 < 0) || (locationY + gangbreedte + 2 - 1 > map[1].length)) {
/*  66 */         shouldBuild = false;
/*  67 */         return map;
/*     */       }
/*     */ 
/*  70 */       for (int i = 0; i < ganglengte; i++) {
/*  71 */         for (int j = 0; j < gangbreedte; j++) {
/*     */           try {
/*  73 */             if (map[(locationX + i + 1)][(locationY + j)] != "_") {
/*  74 */               shouldBuild = false;
/*     */             }
/*     */           }
/*     */           catch (Exception localException)
/*     */           {
/*     */           }
/*     */         }
/*     */       }
/*  82 */       if (locationX + ganglengte + 1 > map.length) {
/*  83 */         shouldBuild = false;
/*     */       }
/*  85 */       if (locationY + gangbreedte + 1 > map[1].length) {
/*  86 */         shouldBuild = false;
/*     */       }
/*     */ 
/*  91 */       if (shouldBuild)
/*     */       {
/*     */         try {
/*  94 */           for (int i = 0; i < ganglengte + 2; i++) {
/*  95 */             for (int j = 0; j < gangbreedte + 2; j++)
/*     */             {
/* 135 */               if (map[(locationX + i)][(locationY + j - 1)] == this.muur) {
/* 136 */                 if ((map[(locationX + i + 1)][(locationY + j - 1)] == this.vloer) || (map[(locationX + i - 1)][(locationY + j - 1)] == this.vloer))
/*     */                 {
/* 138 */                   map[(locationX + i)][(locationY + j - 1)] = this.deurOverX;
/*     */                 }
/*     */ 
/* 141 */                 if ((map[(locationX + i)][(locationY + j + 1 - 1)] == this.vloer) || (map[(locationX + i)][(locationY + j - 1 - 1)] == this.vloer))
/*     */                 {
/* 143 */                   map[(locationX + i)][(locationY + j - 1)] = this.deurOverY;
/*     */                 }
/*     */               }
/*     */             }
/*     */           }
/*     */ 
/*     */         }
/*     */         catch (Exception localException1)
/*     */         {
/*     */         }
/*     */ 
/* 154 */         for (int i = 0; i < ganglengte + 2; i++) {
/* 155 */           for (int j = 0; j < gangbreedte + 2; j++) {
/* 156 */             if ((map[(locationX + i)][(locationY + j - 1)] != this.deurOverX) && (map[(locationX + i)][(locationY + j - 1)] != this.deurOverY)) {
/* 157 */               map[(locationX + i)][(locationY + j - 1)] = this.muur;
/*     */             }
/*     */           }
/*     */         }
/* 161 */         map[(locationX + 0)][(locationY + 0 - 1)] = this.muur;
/* 162 */         map[(locationX + ganglengte + 1)][(locationY + 0 - 1)] = this.muur;
/* 163 */         map[(locationX + 0)][(locationY + gangbreedte + 1 - 1)] = this.muur;
/* 164 */         map[(locationX + ganglengte + 1)][(locationY + gangbreedte + 1 - 1)] = this.muur;
/*     */ 
/* 166 */         for (int i = 0; i < ganglengte; i++) {
/* 167 */           for (int j = 0; j < gangbreedte; j++) {
/* 168 */             map[(locationX + i + 1)][(locationY + j)] = this.vloer;
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 175 */     if (direction.equals("links"))
/*     */     {
/* 177 */       boolean shouldBuild = true;
/* 178 */       if ((locationX - 1 - ganglengte < 0) || (locationX > map.length) || (locationY + gangbreedte + 2 - 1 < 0) || (locationY + gangbreedte + 2 - 1 > map[1].length)) {
/* 179 */         shouldBuild = false;
/* 180 */         return map;
/*     */       }
/* 182 */       for (int i = 0; i < ganglengte; i++) {
/* 183 */         for (int j = 0; j < gangbreedte; j++) {
/*     */           try {
/* 185 */             if (map[(locationX + i - ganglengte)][(locationY + j)] != "_") {
/* 186 */               shouldBuild = false;
/*     */             }
/*     */           }
/*     */           catch (Exception localException2)
/*     */           {
/*     */           }
/*     */         }
/*     */       }
/* 194 */       if (locationX - 1 < 0) {
/* 195 */         shouldBuild = false;
/*     */       }
/* 197 */       if (locationY - 1 < 0) {
/* 198 */         shouldBuild = false;
/*     */       }
/*     */ 
/* 203 */       if (shouldBuild)
/*     */       {
/*     */         try
/*     */         {
/* 208 */           for (int i = 0; i < ganglengte + 2; i++) {
/* 209 */             for (int j = 0; j < gangbreedte + 2; j++)
/*     */             {
/* 211 */               if (map[(locationX + i - ganglengte - 1)][(locationY + j - 1)] == this.muur) {
/* 212 */                 if ((map[(locationX + i - ganglengte - 1 + 1)][(locationY + j - 1)] == this.vloer) || (map[(locationX + i - ganglengte - 1 - 1)][(locationY + j - 1)] == this.vloer)) {
/* 213 */                   map[(locationX + i - ganglengte - 1)][(locationY + j - 1)] = this.deurOverX;
/*     */                 }
/* 215 */                 if ((map[(locationX + i - ganglengte - 1)][(locationY + j + 1 - 1)] == this.vloer) || (map[(locationX + i - ganglengte - 1)][(locationY + j - 1 - 1)] == this.vloer)) {
/* 216 */                   map[(locationX + i - ganglengte - 1)][(locationY + j - 1)] = this.deurOverY;
/*     */                 }
/*     */               }
/*     */             }
/*     */           }
/*     */ 
/*     */         }
/*     */         catch (Exception localException3)
/*     */         {
/*     */         }
/*     */ 
/* 227 */         for (int i = 0; i < ganglengte + 2; i++) {
/* 228 */           for (int j = 0; j < gangbreedte + 2; j++) {
/* 229 */             if ((map[(locationX + i - ganglengte - 1)][(locationY + j - 1)] != this.deurOverX) && (map[(locationX + i - ganglengte - 1)][(locationY + j - 1)] != this.deurOverY)) {
/* 230 */               map[(locationX + i - ganglengte - 1)][(locationY + j - 1)] = this.muur;
/*     */             }
/*     */           }
/*     */         }
/*     */ 
/* 235 */         map[(locationX + 0 - ganglengte - 1)][(locationY + 0 - 1)] = this.muur;
/* 236 */         map[(locationX + ganglengte - ganglengte + 1 - 1)][(locationY + 0 - 1)] = this.muur;
/* 237 */         map[(locationX + 0 - ganglengte - 1)][(locationY + gangbreedte + 1 - 1)] = this.muur;
/* 238 */         map[(locationX + ganglengte - ganglengte + 1 - 1)][(locationY + gangbreedte + 1 - 1)] = this.muur;
/*     */ 
/* 241 */         for (int i = 0; i < ganglengte; i++) {
/* 242 */           for (int j = 0; j < gangbreedte; j++) {
/* 243 */             map[(locationX + i - ganglengte)][(locationY + j)] = this.vloer;
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 250 */     if (direction.equals("onder")) {
/* 251 */       boolean shouldBuild = true;
/* 252 */       if ((locationX + ganglengte + 2 - 1 < 0) || (locationX + ganglengte + 2 > map.length) || (locationY + 0 + 1 < 0) || (locationY + gangbreedte + 2 > map[1].length)) {
/* 253 */         shouldBuild = false;
/* 254 */         return map;
/*     */       }
/* 256 */       for (int i = 0; i < ganglengte; i++) {
/* 257 */         for (int j = 0; j < gangbreedte; j++)
/*     */         {
/* 259 */           if (map[(locationX + i)][(locationY + j + 1)] != "_") {
/* 260 */             shouldBuild = false;
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/* 265 */       if (locationX + ganglengte + 1 > map.length) {
/* 266 */         shouldBuild = false;
/*     */       }
/* 268 */       if (locationX - 1 < 0) {
/* 269 */         shouldBuild = false;
/*     */       }
/* 271 */       if (locationY + gangbreedte + 1 > map[1].length) {
/* 272 */         shouldBuild = false;
/*     */       }
/*     */ 
/* 277 */       if (shouldBuild)
/*     */       {
/*     */         try {
/* 280 */           for (int i = 0; i < ganglengte + 2; i++) {
/* 281 */             for (int j = 0; j < gangbreedte + 2; j++)
/*     */             {
/* 283 */               if (map[(locationX + i - 1)][(locationY + j)] == this.muur) {
/* 284 */                 if ((map[(locationX + i - 1 + 1)][(locationY + j)] == this.vloer) || (map[(locationX + i - 1 - 1)][(locationY + j)] == this.vloer)) {
/* 285 */                   map[(locationX + i - 1)][(locationY + j)] = this.deurOverX;
/*     */                 }
/* 287 */                 if ((map[(locationX + i - 1)][(locationY + j + 1)] == this.vloer) || (map[(locationX + i - 1)][(locationY + j - 1)] == this.vloer))
/* 288 */                   map[(locationX + i - 1)][(locationY + j)] = this.deurOverY;
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */         catch (Exception localException4)
/*     */         {
/*     */         }
/*     */         try
/*     */         {
/* 298 */           for (int i = 0; i < ganglengte + 2; i++) {
/* 299 */             for (int j = 0; j < gangbreedte + 2; j++) {
/* 300 */               if ((map[(locationX + i - 1)][(locationY + j)] != this.deurOverX) && (map[(locationX + i - 1)][(locationY + j)] != this.deurOverY)) {
/* 301 */                 map[(locationX + i - 1)][(locationY + j)] = this.muur;
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */         catch (Exception localException5)
/*     */         {
/*     */         }
/* 309 */         map[(locationX + 0 - 1)][(locationY + 0)] = this.muur;
/* 310 */         map[(locationX + ganglengte + 1 - 1)][(locationY + 0)] = this.muur;
/* 311 */         map[(locationX + 0 - 1)][(locationY + gangbreedte + 1)] = this.muur;
/* 312 */         map[(locationX + ganglengte + 1 - 1)][(locationY + gangbreedte + 1)] = this.muur;
/*     */ 
/* 314 */         for (int i = 0; i < ganglengte; i++) {
/* 315 */           for (int j = 0; j < gangbreedte; j++) {
/* 316 */             map[(locationX + i)][(locationY + j + 1)] = this.vloer;
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 323 */     if (direction.equals("boven")) {
/* 324 */       boolean shouldBuild = true;
/* 325 */       if ((locationX - 1 - ganglengte < 0) || (locationX + ganglengte + 2 - 1 > map.length) || (locationY + 0 - gangbreedte - 1 < 0) || (locationY + gangbreedte + 2 - 1 > map[1].length)) {
/* 326 */         shouldBuild = false;
/* 327 */         return map;
/*     */       }
/*     */ 
/* 330 */       for (int i = 0; i < ganglengte; i++) {
/* 331 */         for (int j = 0; j < gangbreedte; j++)
/*     */         {
/* 333 */           if (map[(locationX + i)][(locationY + j - gangbreedte)] != "_") {
/* 334 */             shouldBuild = false;
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/* 339 */       if (locationX - ganglengte - 1 < 0) {
/* 340 */         shouldBuild = false;
/*     */       }
/* 342 */       if (locationY + gangbreedte + 1 > map[1].length) {
/* 343 */         shouldBuild = false;
/*     */       }
/*     */ 
/* 348 */       if (shouldBuild)
/*     */       {
/*     */         try {
/* 351 */           for (int i = 0; i < ganglengte + 2; i++) {
/* 352 */             for (int j = 0; j < gangbreedte + 2; j++)
/*     */             {
/* 354 */               if (map[(locationX + i - 1)][(locationY + j - gangbreedte - 1)] == this.muur) {
/* 355 */                 if ((map[(locationX + i - 1 + 1)][(locationY + j - gangbreedte - 1)] == this.vloer) || (map[(locationX + i - 1 - 1)][(locationY + j - gangbreedte - 1)] == this.vloer)) {
/* 356 */                   map[(locationX + i - 1)][(locationY + j - gangbreedte - 1)] = this.deurOverX;
/*     */                 }
/* 358 */                 if ((map[(locationX + i - 1)][(locationY + j - gangbreedte + 1 - 1)] == this.vloer) || (map[(locationX + i - 1)][(locationY + j - gangbreedte - 1 - 1)] == this.vloer)) {
/* 359 */                   map[(locationX + i - 1)][(locationY + j - gangbreedte - 1)] = this.deurOverY;
/*     */                 }
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */         catch (Exception localException6)
/*     */         {
/*     */         }
/*     */ 
/* 369 */         for (int i = 0; i < ganglengte + 2; i++) {
/* 370 */           for (int j = 0; j < gangbreedte + 2; j++) {
/* 371 */             if ((map[(locationX + i - 1)][(locationY + j - gangbreedte - 1)] != this.deurOverX) && (map[(locationX + i - 1)][(locationY + j - gangbreedte - 1)] != this.deurOverY)) {
/* 372 */               map[(locationX + i - 1)][(locationY + j - gangbreedte - 1)] = this.muur;
/*     */             }
/*     */           }
/*     */         }
/*     */ 
/* 377 */         map[(locationX + 0 - 1)][(locationY + 0 - gangbreedte - 1)] = this.muur;
/* 378 */         map[(locationX + ganglengte + 1 - 1)][(locationY + 0 - gangbreedte - 1)] = this.muur;
/* 379 */         map[(locationX + 0 - 1)][(locationY + gangbreedte + 1 - gangbreedte - 1)] = this.muur;
/* 380 */         map[(locationX + ganglengte + 1 - 1)][(locationY + gangbreedte + 1 - gangbreedte - 1)] = this.muur;
/*     */ 
/* 383 */         for (int i = 0; i < ganglengte; i++) {
/* 384 */           for (int j = 0; j < gangbreedte; j++) {
/* 385 */             map[(locationX + i)][(locationY + j - gangbreedte)] = this.vloer;
/*     */           }
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 393 */     return map;
/*     */   }
/*     */ 
/*     */   public String[][] echteGang(int locationX, int locationY, String[][] map, String direction)
/*     */   {
/* 402 */     Random rand = new Random();
/*     */ 
/* 405 */     if (rand.nextBoolean())
/*     */     {
/* 407 */       this.ganglengte = 1;
/* 408 */       this.gangbreedte = (rand.nextInt(3) + 8);
/*     */     } else {
/* 410 */       this.ganglengte = (rand.nextInt(3) + 8);
/* 411 */       this.gangbreedte = 1;
/*     */     }
/*     */ 
/* 414 */     if (direction.equals("rechts"))
/*     */     {
/* 416 */       boolean shouldBuild = true;
/* 417 */       if ((locationX < 0) || (locationX + this.ganglengte + 2 > map.length) || (locationY - 1 < 0) || (locationY + this.gangbreedte + 2 - 1 > map[1].length)) {
/* 418 */         shouldBuild = false;
/* 419 */         return map;
/*     */       }
/*     */ 
/* 422 */       for (int i = 0; i < this.ganglengte; i++) {
/* 423 */         for (int j = 0; j < this.gangbreedte; j++) {
/*     */           try {
/* 425 */             if (map[(locationX + i + 1)][(locationY + j)] != "_") {
/* 426 */               shouldBuild = false;
/*     */             }
/*     */           }
/*     */           catch (Exception localException)
/*     */           {
/*     */           }
/*     */         }
/*     */       }
/* 434 */       if (locationX + this.ganglengte + 1 > map.length) {
/* 435 */         shouldBuild = false;
/*     */       }
/* 437 */       if (locationY + this.gangbreedte + 1 > map[1].length) {
/* 438 */         shouldBuild = false;
/*     */       }
/*     */ 
/* 443 */       if (shouldBuild)
/*     */       {
/* 446 */         for (int i = 0; i < this.ganglengte + 2; i++) {
/* 447 */           for (int j = 0; j < this.gangbreedte + 2; j++)
/*     */           {
/*     */             try
/*     */             {
/* 485 */               if (map[(locationX + i)][(locationY + j - 1)] == this.muur) {
/* 486 */                 if ((map[(locationX + i + 1)][(locationY + j - 1)] == this.vloer) || (map[(locationX + i - 1)][(locationY + j - 1)] == this.vloer))
/*     */                 {
/* 488 */                   map[(locationX + i)][(locationY + j - 1)] = this.deurOverX;
/*     */                 }
/*     */ 
/* 491 */                 if ((map[(locationX + i)][(locationY + j + 1 - 1)] == this.vloer) || (map[(locationX + i)][(locationY + j - 1 - 1)] == this.vloer))
/*     */                 {
/* 493 */                   map[(locationX + i)][(locationY + j - 1)] = this.deurOverY;
/*     */                 }
/*     */               }
/*     */             }
/*     */             catch (Exception localException1)
/*     */             {
/*     */             }
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/* 504 */         for (int i = 0; i < this.ganglengte + 2; i++) {
/* 505 */           for (int j = 0; j < this.gangbreedte + 2; j++) {
/* 506 */             if ((map[(locationX + i)][(locationY + j - 1)] != this.deurOverX) && (map[(locationX + i)][(locationY + j - 1)] != this.deurOverY)) {
/* 507 */               map[(locationX + i)][(locationY + j - 1)] = this.muur;
/*     */             }
/*     */           }
/*     */         }
/* 511 */         map[(locationX + 0)][(locationY + 0 - 1)] = this.muur;
/* 512 */         map[(locationX + this.ganglengte + 1)][(locationY + 0 - 1)] = this.muur;
/* 513 */         map[(locationX + 0)][(locationY + this.gangbreedte + 1 - 1)] = this.muur;
/* 514 */         map[(locationX + this.ganglengte + 1)][(locationY + this.gangbreedte + 1 - 1)] = this.muur;
/*     */ 
/* 516 */         for (int i = 0; i < this.ganglengte; i++) {
/* 517 */           for (int j = 0; j < this.gangbreedte; j++) {
/* 518 */             map[(locationX + i + 1)][(locationY + j)] = this.vloer;
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 525 */     if (direction.equals("links"))
/*     */     {
/* 527 */       boolean shouldBuild = true;
/* 528 */       if ((locationX - 1 - this.ganglengte < 0) || (locationX > map.length) || (locationY + this.gangbreedte + 2 - 1 < 0) || (locationY + this.gangbreedte + 2 - 1 > map[1].length)) {
/* 529 */         shouldBuild = false;
/* 530 */         return map;
/*     */       }
/* 532 */       for (int i = 0; i < this.ganglengte; i++) {
/* 533 */         for (int j = 0; j < this.gangbreedte; j++) {
/*     */           try {
/* 535 */             if (map[(locationX + i - this.ganglengte)][(locationY + j)] != "_") {
/* 536 */               shouldBuild = false;
/*     */             }
/*     */           }
/*     */           catch (Exception localException2)
/*     */           {
/*     */           }
/*     */         }
/*     */       }
/* 544 */       if (locationX - 1 < 0) {
/* 545 */         shouldBuild = false;
/*     */       }
/* 547 */       if (locationY - 1 < 0) {
/* 548 */         shouldBuild = false;
/*     */       }
/*     */ 
/* 553 */       if (shouldBuild)
/*     */       {
/*     */         try
/*     */         {
/* 558 */           for (int i = 0; i < this.ganglengte + 2; i++) {
/* 559 */             for (int j = 0; j < this.gangbreedte + 2; j++)
/*     */             {
/* 561 */               if (map[(locationX + i - this.ganglengte - 1)][(locationY + j - 1)] == this.muur) {
/* 562 */                 if ((map[(locationX + i - this.ganglengte - 1 + 1)][(locationY + j - 1)] == this.vloer) || (map[(locationX + i - this.ganglengte - 1 - 1)][(locationY + j - 1)] == this.vloer)) {
/* 563 */                   map[(locationX + i - this.ganglengte - 1)][(locationY + j - 1)] = this.deurOverX;
/*     */                 }
/* 565 */                 if ((map[(locationX + i - this.ganglengte - 1)][(locationY + j + 1 - 1)] == this.vloer) || (map[(locationX + i - this.ganglengte - 1)][(locationY + j - 1 - 1)] == this.vloer)) {
/* 566 */                   map[(locationX + i - this.ganglengte - 1)][(locationY + j - 1)] = this.deurOverY;
/*     */                 }
/*     */               }
/*     */             }
/*     */           }
/*     */ 
/*     */         }
/*     */         catch (Exception localException3)
/*     */         {
/*     */         }
/*     */ 
/* 577 */         for (int i = 0; i < this.ganglengte + 2; i++) {
/* 578 */           for (int j = 0; j < this.gangbreedte + 2; j++) {
/* 579 */             if ((map[(locationX + i - this.ganglengte - 1)][(locationY + j - 1)] != this.deurOverX) && (map[(locationX + i - this.ganglengte - 1)][(locationY + j - 1)] != this.deurOverY)) {
/* 580 */               map[(locationX + i - this.ganglengte - 1)][(locationY + j - 1)] = this.muur;
/*     */             }
/*     */           }
/*     */         }
/*     */ 
/* 585 */         map[(locationX + 0 - this.ganglengte - 1)][(locationY + 0 - 1)] = this.muur;
/* 586 */         map[(locationX + this.ganglengte - this.ganglengte + 1 - 1)][(locationY + 0 - 1)] = this.muur;
/* 587 */         map[(locationX + 0 - this.ganglengte - 1)][(locationY + this.gangbreedte + 1 - 1)] = this.muur;
/* 588 */         map[(locationX + this.ganglengte - this.ganglengte + 1 - 1)][(locationY + this.gangbreedte + 1 - 1)] = this.muur;
/*     */ 
/* 591 */         for (int i = 0; i < this.ganglengte; i++) {
/* 592 */           for (int j = 0; j < this.gangbreedte; j++) {
/* 593 */             map[(locationX + i - this.ganglengte)][(locationY + j)] = this.vloer;
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 600 */     if (direction.equals("onder")) {
/* 601 */       boolean shouldBuild = true;
/* 602 */       if ((locationX + this.ganglengte + 2 - 1 < 0) || (locationX + this.ganglengte + 2 > map.length) || (locationY + 0 + 1 < 0) || (locationY + this.gangbreedte + 2 > map[1].length)) {
/* 603 */         shouldBuild = false;
/* 604 */         return map;
/*     */       }
/* 606 */       for (int i = 0; i < this.ganglengte; i++) {
/* 607 */         for (int j = 0; j < this.gangbreedte; j++)
/*     */         {
/* 609 */           if (map[(locationX + i)][(locationY + j + 1)] != "_") {
/* 610 */             shouldBuild = false;
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/* 615 */       if (locationX + this.ganglengte + 1 > map.length) {
/* 616 */         shouldBuild = false;
/*     */       }
/* 618 */       if (locationX - 1 < 0) {
/* 619 */         shouldBuild = false;
/*     */       }
/* 621 */       if (locationY + this.gangbreedte + 1 > map[1].length) {
/* 622 */         shouldBuild = false;
/*     */       }
/*     */ 
/* 627 */       if (shouldBuild)
/*     */       {
/*     */         try {
/* 630 */           for (int i = 0; i < this.ganglengte + 2; i++) {
/* 631 */             for (int j = 0; j < this.gangbreedte + 2; j++)
/*     */             {
/* 633 */               if (map[(locationX + i - 1)][(locationY + j)] == this.muur) {
/* 634 */                 if ((map[(locationX + i - 1 + 1)][(locationY + j)] == this.vloer) || (map[(locationX + i - 1 - 1)][(locationY + j)] == this.vloer)) {
/* 635 */                   map[(locationX + i - 1)][(locationY + j)] = this.deurOverX;
/*     */                 }
/* 637 */                 if ((map[(locationX + i - 1)][(locationY + j + 1)] == this.vloer) || (map[(locationX + i - 1)][(locationY + j - 1)] == this.vloer))
/* 638 */                   map[(locationX + i - 1)][(locationY + j)] = this.deurOverY;
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */         catch (Exception localException4)
/*     */         {
/*     */         }
/*     */         try
/*     */         {
/* 648 */           for (int i = 0; i < this.ganglengte + 2; i++) {
/* 649 */             for (int j = 0; j < this.gangbreedte + 2; j++) {
/* 650 */               if ((map[(locationX + i - 1)][(locationY + j)] != this.deurOverX) && (map[(locationX + i - 1)][(locationY + j)] != this.deurOverY)) {
/* 651 */                 map[(locationX + i - 1)][(locationY + j)] = this.muur;
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */         catch (Exception localException5)
/*     */         {
/*     */         }
/* 659 */         map[(locationX + 0 - 1)][(locationY + 0)] = this.muur;
/* 660 */         map[(locationX + this.ganglengte + 1 - 1)][(locationY + 0)] = this.muur;
/* 661 */         map[(locationX + 0 - 1)][(locationY + this.gangbreedte + 1)] = this.muur;
/* 662 */         map[(locationX + this.ganglengte + 1 - 1)][(locationY + this.gangbreedte + 1)] = this.muur;
/*     */ 
/* 664 */         for (int i = 0; i < this.ganglengte; i++) {
/* 665 */           for (int j = 0; j < this.gangbreedte; j++) {
/* 666 */             map[(locationX + i)][(locationY + j + 1)] = this.vloer;
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 673 */     if (direction.equals("boven")) {
/* 674 */       boolean shouldBuild = true;
/* 675 */       if ((locationX - 1 - this.ganglengte < 0) || (locationX + this.ganglengte + 2 - 1 > map.length) || (locationY + 0 - this.gangbreedte - 1 < 0) || (locationY + this.gangbreedte + 2 - 1 > map[1].length)) {
/* 676 */         shouldBuild = false;
/* 677 */         return map;
/*     */       }
/*     */ 
/* 680 */       for (int i = 0; i < this.ganglengte; i++) {
/* 681 */         for (int j = 0; j < this.gangbreedte; j++)
/*     */         {
/* 683 */           if (map[(locationX + i)][(locationY + j - this.gangbreedte)] != "_") {
/* 684 */             shouldBuild = false;
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/* 689 */       if (locationX - this.ganglengte - 1 < 0) {
/* 690 */         shouldBuild = false;
/*     */       }
/* 692 */       if (locationY + this.gangbreedte + 1 > map[1].length) {
/* 693 */         shouldBuild = false;
/*     */       }
/*     */ 
/* 698 */       if (shouldBuild)
/*     */       {
/*     */         try {
/* 701 */           for (int i = 0; i < this.ganglengte + 2; i++) {
/* 702 */             for (int j = 0; j < this.gangbreedte + 2; j++)
/*     */             {
/* 704 */               if (map[(locationX + i - 1)][(locationY + j - this.gangbreedte - 1)] == this.muur) {
/* 705 */                 if ((map[(locationX + i - 1 + 1)][(locationY + j - this.gangbreedte - 1)] == this.vloer) || (map[(locationX + i - 1 - 1)][(locationY + j - this.gangbreedte - 1)] == this.vloer)) {
/* 706 */                   map[(locationX + i - 1)][(locationY + j - this.gangbreedte - 1)] = this.deurOverX;
/*     */                 }
/* 708 */                 if ((map[(locationX + i - 1)][(locationY + j - this.gangbreedte + 1 - 1)] == this.vloer) || (map[(locationX + i - 1)][(locationY + j - this.gangbreedte - 1 - 1)] == this.vloer)) {
/* 709 */                   map[(locationX + i - 1)][(locationY + j - this.gangbreedte - 1)] = this.deurOverY;
/*     */                 }
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */         catch (Exception localException6)
/*     */         {
/*     */         }
/*     */ 
/* 719 */         for (int i = 0; i < this.ganglengte + 2; i++) {
/* 720 */           for (int j = 0; j < this.gangbreedte + 2; j++) {
/* 721 */             if ((map[(locationX + i - 1)][(locationY + j - this.gangbreedte - 1)] != this.deurOverX) && (map[(locationX + i - 1)][(locationY + j - this.gangbreedte - 1)] != this.deurOverY)) {
/* 722 */               map[(locationX + i - 1)][(locationY + j - this.gangbreedte - 1)] = this.muur;
/*     */             }
/*     */           }
/*     */         }
/*     */ 
/* 727 */         map[(locationX + 0 - 1)][(locationY + 0 - this.gangbreedte - 1)] = this.muur;
/* 728 */         map[(locationX + this.ganglengte + 1 - 1)][(locationY + 0 - this.gangbreedte - 1)] = this.muur;
/* 729 */         map[(locationX + 0 - 1)][(locationY + this.gangbreedte + 1 - this.gangbreedte - 1)] = this.muur;
/* 730 */         map[(locationX + this.ganglengte + 1 - 1)][(locationY + this.gangbreedte + 1 - this.gangbreedte - 1)] = this.muur;
/*     */ 
/* 733 */         for (int i = 0; i < this.ganglengte; i++) {
/* 734 */           for (int j = 0; j < this.gangbreedte; j++) {
/* 735 */             map[(locationX + i)][(locationY + j - this.gangbreedte)] = this.vloer;
/*     */           }
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 743 */     return map;
/*     */   }
/*     */ 
/*     */   public static String[][] makePilars(String[][] map)
/*     */   {
/* 753 */     for (int s = 0; s < 20; s++) {
/* 754 */       pilX = rand.nextInt(79);
/* 755 */       pilY = rand.nextInt(49);
/* 756 */       shouldBuildPilar = true;
/*     */ 
/* 758 */       for (int t = 0; t < 2; t++) {
/* 759 */         for (int b = 0; b < 2; b++) {
/* 760 */           if (map[(pilX + t)][(pilY + b)] != "-") {
/* 761 */             shouldBuildPilar = false;
/*     */           }
/* 763 */           if (TileChecker.amountTileAround(pilX + t, pilY + b, "B", map) != 0) {
/* 764 */             shouldBuildPilar = false;
/*     */           }
/* 766 */           if (TileChecker.amountTileAround(pilX + t, pilY + b, "D", map) != 0) {
/* 767 */             shouldBuildPilar = false;
/*     */           }
/* 769 */           if (TileChecker.amountTileAround(pilX + t, pilY + b, "X", map) != 0) {
/* 770 */             shouldBuildPilar = false;
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/* 775 */       if (shouldBuildPilar) {
/* 776 */         for (int t = 0; t < 2; t++) {
/* 777 */           for (int b = 0; b < 2; b++) {
/* 778 */             map[(pilX + t)][(pilY + b)] = "X";
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 785 */     return map;
/*     */   }
/*     */ }

/* Location:           C:\Users\Thomas\Dropbox\Java source\RPG\RPGGame.jar
 * Qualified Name:     com.thomas.dungeon.Level.Rooms
 * JD-Core Version:    0.6.2
 */