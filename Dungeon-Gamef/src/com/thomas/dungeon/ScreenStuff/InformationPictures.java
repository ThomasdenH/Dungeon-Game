package com.thomas.dungeon.ScreenStuff;

import com.thomas.dungeon.Entities.Player;
import com.thomas.dungeon.GameTechnical.Game;
import com.thomas.dungeon.armrupgrades.ItemLevels;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class InformationPictures {
	public static Font infoFont = new Font("Dialog", 1, 25);
	public static Font smallFont = new Font("Dialog", 1, 10);

	public BufferedImage leftImage = new BufferedImage(
			(Game.WIDTH - Game.HEIGHT / 9 * 13) / 2, Game.HEIGHT, 2);
	public Graphics2D g = (Graphics2D) this.leftImage.getGraphics();

	public BufferedImage healthImage = new BufferedImage(25, 500, 2);
	public Graphics2D g2 = (Graphics2D) this.healthImage.getGraphics();

	public BufferedImage infoImage = new BufferedImage(200, 200, 2);
	public Graphics2D g3 = (Graphics2D) this.infoImage.getGraphics();

	public Color health1 = new Color(255, 0, 0);
	public Color health2 = new Color(100, 0, 0);
	int healthLeft;

	public BufferedImage XPImage = new BufferedImage(25, 500, 2);
	public Graphics2D g4 = (Graphics2D) this.XPImage.getGraphics();

	public Color XP1 = new Color(100, 100, 255);

	public Color XP2 = new Color(0, 0, 155);
	int XPHave;
	public BufferedImage SimpleMapImage = new BufferedImage(800, 500, 2);
	public Graphics2D g5 = (Graphics2D) this.SimpleMapImage.getGraphics();

	public BufferedImage getHealthImage() {
		/* 46 */Player.getPlayer();
		/* 47 */this.healthLeft = (500 * Player.getPlayer().health / Player
				.getMaxHealth());
		/*     */
		/* 49 */this.g2.setPaint(Color.BLACK);
		/* 50 */this.g2.fillRect(0, 0, this.healthImage.getWidth(),
				this.healthImage.getHeight());
		/*     */
		/* 52 */this.g2.setPaint(new GradientPaint(0.0F, 500 - this.healthLeft,
				this.health1, 0.0F, 500.0F, this.health2));
		/*     */
		/* 54 */this.g2.fillRect(0, 500 - this.healthLeft, 25, this.healthLeft);
		/*     */
		/* 56 */this.g2.dispose();
		/*     */
		/* 58 */return this.healthImage;
		/*     */}

	/*     */
	/*     */public BufferedImage getInfoImage()
	/*     */{
		/* 65 */this.g3.setFont(infoFont);
		/* 66 */this.g3.setColor(Color.WHITE);
		/*     */
		/* 68 */this.g3.drawString("XP: " + Player.getPlayer().XP, 0,
				0 + infoFont.getSize() * 1);
		/* 69 */this.g3.drawString("Lvl: " + Player.getPlayer().Level, 0,
				0 + infoFont.getSize() * 2);
		/*     */
		/* 71 */this.g3.dispose();
		/*     */
		/* 73 */return this.infoImage;
		/*     */}

	public BufferedImage getLeftImage() {
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
				RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		this.g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		this.g.setRenderingHint(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);

		this.g.drawImage(Screenprinting.MenuBackgroundBlur, 0, 0, null);

		/* 84 */this.g.setColor(new Color(0, 0, 0, 150));
		/* 85 */this.g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		/*     */
		/* 87 */this.g.drawRect(0, 0, this.leftImage.getWidth() - 1,
				this.leftImage.getHeight() - 1);
		/*     */
		/* 89 */this.g.drawImage(Screenprinting.SpritePicture,
				this.leftImage.getWidth() / 10,
				this.leftImage.getHeight() / 30,
				this.leftImage.getWidth() * 8 / 10,
				this.leftImage.getWidth() * 8 / 10, null);
		/*     */
		/* 91 */this.g.drawImage(getHealthImage(),
				this.leftImage.getWidth() * 2 / 10,
				this.leftImage.getHeight() * 6 / 30,
				this.leftImage.getWidth() * 5 / 20,
				this.leftImage.getHeight() / 10, null);
		/* 92 */this.g.drawImage(getXPImage(),
				this.leftImage.getWidth() * 11 / 20,
				this.leftImage.getHeight() * 6 / 30,
				this.leftImage.getWidth() * 5 / 20,
				this.leftImage.getHeight() / 10, null);
		/*     */
		/* 94 */this.g.drawImage(getInfoImage(),
				this.leftImage.getWidth() / 10,
				this.leftImage.getHeight() * 19 / 60,
				this.leftImage.getWidth() * 8 / 10,
				this.leftImage.getWidth() * 8 / 10, null);
		/* 95 */this.g.setFont(infoFont);
		/* 96 */this.g.setColor(Color.black);
		/* 97 */this.g.drawString(ItemLevels.currentWeaponLevel + "",
				this.leftImage.getWidth() / 10 * 5,
				this.leftImage.getHeight() * 46 / 100);
		/* 98 */this.g.setColor(Color.white);
		/* 99 */this.g.drawString(ItemLevels.currentWeaponLevel + "",
				this.leftImage.getWidth() / 10 * 5 - 2,
				this.leftImage.getHeight() * 46 / 100 - 2);
		/* 100 */this.g.setColor(Color.black);
		/* 101 */this.g.drawString(ItemLevels.currentArmorLevel + "",
				this.leftImage.getWidth() / 10 * 5,
				this.leftImage.getHeight() * 52 / 100);
		/* 102 */this.g.setColor(Color.white);
		/* 103 */this.g.drawString(ItemLevels.currentArmorLevel + "",
				this.leftImage.getWidth() / 10 * 5 - 2,
				this.leftImage.getHeight() * 52 / 100 - 2);
		/* 104 */this.g.setColor(Color.black);
		/* 105 */this.g.drawString(ItemLevels.currentHealthLevel + "",
				this.leftImage.getWidth() / 10 * 5,
				this.leftImage.getHeight() * 58 / 100);
		/* 106 */this.g.setColor(Color.white);
		/* 107 */this.g.drawString(ItemLevels.currentHealthLevel + "",
				this.leftImage.getWidth() / 10 * 5 - 2,
				this.leftImage.getHeight() * 58 / 100 - 2);
		/*     */
		/* 109 */this.g.drawImage(Screenprinting.Attack,
				this.leftImage.getWidth() / 10,
				this.leftImage.getHeight() * 25 / 60,
				this.leftImage.getWidth() / 3, this.leftImage.getWidth() / 3,
				null);
		/* 110 */this.g.drawImage(Screenprinting.Defence,
				this.leftImage.getWidth() / 10,
				this.leftImage.getHeight() * 29 / 60,
				this.leftImage.getWidth() / 3, this.leftImage.getWidth() / 3,
				null);
		/* 111 */this.g.drawImage(Screenprinting.Health,
				this.leftImage.getWidth() / 10,
				this.leftImage.getHeight() * 33 / 60,
				this.leftImage.getWidth() / 3, this.leftImage.getWidth() / 3,
				null);
		/*     */
		/* 113 */this.g.dispose();
		/*     */
		/* 115 */return this.leftImage;
		/*     */}

	/*     */
	/*     */public BufferedImage getXPImage()
	/*     */{
		/* 120 */this.XPHave = (500 * (Player.getPlayer().XP - Player
				.getPlayer().XPNeededForThisLevel()) / Player.getPlayer()
				.XPNeededForNextLevel());
		/*     */
		/* 122 */this.g4.setPaint(Color.BLACK);
		/* 123 */this.g4.fillRect(0, 0, this.XPImage.getWidth(),
				this.XPImage.getHeight());
		/*     */
		/* 125 */this.g4.setPaint(new GradientPaint(0.0F, this.XPHave,
				this.XP1, 0.0F, 500.0F, this.XP2));
		/*     */
		/* 127 */this.g4.fillRect(0, 500 - this.XPHave, 25, this.XPHave);
		/*     */
		/* 129 */this.g4.dispose();
		/*     */
		/* 131 */return this.XPImage;
		/*     */}

	/*     */
	/*     */public BufferedImage getSimpleMap()
	/*     */{
		/* 138 */for (int x = 0; x < 80; x++) {
			/* 139 */for (int y = 0; y < 50; y++) {
				/* 140 */if (Game.finalMap[x][y].equals("-")) {
					/* 141 */this.g5.setColor(Color.BLACK);
					/* 142 */this.g5.fillRect(x * 10, y * 10, 10, 10);
					/* 143 */} else if (Game.finalMap[x][y].equals("X")) {
					/* 144 */this.g5.setColor(Color.yellow);
					/* 145 */this.g5.fillRect(x * 10, y * 10, 10, 10);
					/*     */}
				/*     */}
			/*     */}
		/*     */
		/* 150 */this.g5.setColor(Color.BLUE);
		/* 151 */this.g5.fillRect(Player.getPlayer().loc.getX() * 10,
				Player.getPlayer().loc.getY() * 10, 10, 10);
		/* 152 */this.g5.dispose();
		/* 153 */return this.SimpleMapImage;
		/*     */}
	/*     */
}
