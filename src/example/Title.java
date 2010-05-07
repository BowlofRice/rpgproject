package example;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class Title extends Canvas {
	public Title() {
		setSize(400, 400);
		setBackground(Color.DARK_GRAY);
	}

	public void paint(Graphics g) {
		Image horse = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/thorse.png");
		//g.setColor(Color.ORANGE);
		//g.drawString("Battle for troy", 200, 200);
		g.drawImage(horse, 0, 0, null);
	}
}
