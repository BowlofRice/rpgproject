package example;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class Screen2 extends Canvas{
	private MapTwo map;
	public int playTime=0;
	public Screen2(MapTwo map){
		setSize(400,400);
		setBackground(Color.DARK_GRAY);
		this.map=map;
	}
	public void paint(Graphics g){
		switch(playTime){
		case 0:
			map.paint(g);
			break;
		case 1:
			map.paint(g);
			map.moveEnemy(g,18, 0);
			break;
		}
	}
}
