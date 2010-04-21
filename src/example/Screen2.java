package example;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class Screen2 extends Canvas{
	private MapTwo map;
	public Screen2(MapTwo map){
		setSize(400,400);
		setBackground(Color.DARK_GRAY);
		this.map=map;
	}
	public void paint(Graphics g){
		map.paint(g);
		map.moveEnemy(g,18, 0);
	}
}
