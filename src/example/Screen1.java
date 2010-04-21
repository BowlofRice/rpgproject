package example;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class Screen1 extends Canvas{
	private MapOne map;
	public Screen1(MapOne map){
		setSize(400,400);
		setBackground(Color.DARK_GRAY);
		this.map=map;
	}
	public void paint(Graphics g){
		map.paint(g);
		map.moveEnemy(g,9, 0);
	}
}
