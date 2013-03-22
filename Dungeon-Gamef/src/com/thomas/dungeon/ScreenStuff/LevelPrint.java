package com.thomas.dungeon.ScreenStuff;

import com.thomas.dungeon.Entities.Player;
import com.thomas.dungeon.GameTechnical.Game;
import com.thomas.dungeon.GameTechnical.Gamehandler;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class LevelPrint extends JPanel implements Runnable {
	private static final long serialVersionUID = -5961498593133477762L;
	public static int xWIDTH = Game.WIDTH;
	public static int yHEIGHT = Game.HEIGHT;

	public Player pla = new Player();
	private InformationPictures infPic;
	private Menu menu;
	private InGameMenu igm;
	private Screenprinting screp;

	public LevelPrint() {
		menu = new Menu();
		infPic = new InformationPictures();
		igm = new InGameMenu();
		screp = new Screenprinting();
		setPreferredSize(new Dimension(menu.getMenuImage().getWidth(), menu.getMenuImage().getHeight()));
		setFocusable(true);
	}

	@Override
	public void update(Graphics g) {
		Dimension dim = new Dimension(xWIDTH, yHEIGHT);
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g2);
		super.setSize(dim);

		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

		g.clearRect(0, 0, xWIDTH, yHEIGHT);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, xWIDTH, yHEIGHT);

		if (Gamehandler.menu) {
			g2.drawImage(menu.getMenuImage(), 0, 0, Game.WIDTH, Game.HEIGHT, null);
		} else if (Gamehandler.singlePlayerGame) {
			g2.drawImage(infPic.getLeftImage(), 0, 0, null);
			g2.drawImage(screp.generateIt(), (xWIDTH - screp.generateIt().getWidth()) / 2, yHEIGHT / 2 - screp.generateIt().getHeight() / 2, null);
		} else if (Gamehandler.gameOver) {
			g2.drawImage(GameOver.getGameOverImage(), 0, 0, Game.WIDTH, Game.HEIGHT, null);
		}
		if (Gamehandler.inGameMenu) {
			g2.drawImage(igm.getMenuImage(), xWIDTH / 20, yHEIGHT / 20, null);
		}
		g.dispose();
	}

	@Override
	public void paint(Graphics g) {
		/* 68 */update(g);
	}

	@Override
	public void run() {
		/* 77 */repaint();
	}

}