package example;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class Screen2 extends Canvas{
	private MapTwo map;
	public int playTime=0;
	public int funds=20000;
	public MouseTracer2 mouse;
	public Screen2(MapTwo map){
		setSize(400,400);
		setBackground(Color.DARK_GRAY);
		this.map=map;
	}
    public void addMouseTracer(MouseTracer2 mouse){
    	this.mouse=mouse;
    }
        
	public void paint(Graphics g){
		switch(playTime){
		case 0:
			map.paint(g);
			break;
		case 1:
			map.paint(g);
			for(int i=0;i<mouse.allies.size();i++)
				mouse.allies.elementAt(i).drawUnit(g);
			for(int i=1;i<=3;i++)
				map.moveEnemy(g,18, 0);
			break;
		}
	}
}