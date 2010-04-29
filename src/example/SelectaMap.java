package example;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class SelectaMap extends Canvas {
	public SelectaMap() {
		setSize(400, 400);
		setBackground(Color.DARK_GRAY);
	}

	public void paint(Graphics g) {
		g.setColor(Color.ORANGE);
		g.drawString("pick a map to play", 100, 200);
	}
}
