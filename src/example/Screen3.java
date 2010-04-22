package example;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class Screen3 extends Canvas{
	private MapThree map;
	public int playTime=0;
	public Screen3(MapThree map){
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
