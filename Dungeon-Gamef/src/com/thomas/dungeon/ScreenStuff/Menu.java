package com.thomas.dungeon.ScreenStuff;

import com.thomas.dungeon.GameTechnical.Game;
import com.thomas.dungeon.GameTechnical.Gamehandler;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Menu {
	public static int buttonSelected = 0;
	public static int aantalButtons = 3;

	public Random rand = new Random();

	public static BufferedImage menuImage = new BufferedImage(Game.WIDTH,
			Game.HEIGHT, 2);

	public Graphics2D g = (Graphics2D) menuImage.getGraphics();
	public Border border = new Border();

	public static void buttonClicked() {
		switch (buttonSelected) {
		case 0:
			Gamehandler.menu = false;
			Gamehandler.singlePlayerGame = true;
			Gamehandler.configureSinglePlayerGame();
		}
	}

	public static void buttonToTheLeft() {
		/* 33 */if (buttonSelected == 0)
			/* 34 */buttonSelected = aantalButtons - 1;
		else
			/* 36 */buttonSelected -= 1;
	}

	public static void buttonToTheRight() {
		/* 41 */if (buttonSelected == aantalButtons - 1)
			/* 42 */buttonSelected = 0;
		else
			/* 44 */buttonSelected += 1;
	}

	public BufferedImage getMenuImage() {
		if (Screenprinting.MBSSinglePlayer != null) {
			this.g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
					RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			this.g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			this.g.setRenderingHint(RenderingHints.KEY_RENDERING,
					RenderingHints.VALUE_RENDER_QUALITY);
			this.g.drawImage(Screenprinting.MenuBackground, 0, 0, Game.WIDTH,
					Game.HEIGHT, null);

			double imageScale = 1.333333333333333D;
			int absoluteImageScaleX = (int) (Screenprinting.MBSSinglePlayer
					.getWidth(null) / imageScale);
			int absoluteImageScaleY = (int) (Screenprinting.MBSSinglePlayer
					.getHeight(null) / imageScale);
			int YLocation = Game.HEIGHT / 5 * 4;
			int XLocation = Game.WIDTH / aantalButtons
					+ (Game.WIDTH - (Game.WIDTH / 3 * 2 + absoluteImageScaleX))
					/ 2;

			switch (buttonSelected) {
			case 0:
				this.g.drawImage(Screenprinting.MBSSinglePlayer, XLocation * 0,
						YLocation, absoluteImageScaleX, absoluteImageScaleY,
						null);
				this.g.drawImage(Screenprinting.MBMultiPlayer, XLocation * 1,
						YLocation, absoluteImageScaleX, absoluteImageScaleY,
						null);
				this.g.drawImage(Screenprinting.MBOptions, XLocation * 2,
						YLocation, absoluteImageScaleX, absoluteImageScaleY,
						null);

				break;
			case 1:
				/* 79 */this.g.drawImage(Screenprinting.MBSinglePlayer,
						XLocation * 0 * 0, YLocation, absoluteImageScaleX,
						absoluteImageScaleY, null);
				/* 80 */this.g.drawImage(Screenprinting.MBSMultiPlayer,
						XLocation * 1, YLocation, absoluteImageScaleX,
						absoluteImageScaleY, null);
				/* 81 */this.g.drawImage(Screenprinting.MBOptions,
						XLocation * 2, YLocation, absoluteImageScaleX,
						absoluteImageScaleY, null);

				/* 83 */break;
			case 2:
				/* 85 */this.g.drawImage(Screenprinting.MBSinglePlayer,
						XLocation * 0, YLocation, absoluteImageScaleX,
						absoluteImageScaleY, null);
				/* 86 */this.g.drawImage(Screenprinting.MBMultiPlayer,
						XLocation * 1, YLocation, absoluteImageScaleX,
						absoluteImageScaleY, null);
				/* 87 */this.g.drawImage(Screenprinting.MBSOptions,
						XLocation * 2, YLocation, absoluteImageScaleX,
						absoluteImageScaleY, null);
			}

			/* 92 */if (Screenprinting.MenuBackground == null) {
				/* 93 */this.g.setColor(Color.BLUE);
				/* 94 */this.g.fillRect(0, 0, 200, 200);
			}
		}

		/* 98 */return menuImage;
	}
}