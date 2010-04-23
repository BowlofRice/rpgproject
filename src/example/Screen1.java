package example;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class Screen1 extends Canvas{
	private MapOne map;
	public int playTime=0;
	public int funds=20000;
	public Screen1(MapOne map){
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
			for(int i=1;i<=3;i++)
				map.moveEnemy(g,9, 0);
			break;
		}
	}
}
