package example;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

@SuppressWarnings("serial")
public class Screen3 extends Canvas{
	Random rand=new Random();
	private MapThree map;
	public int playTime=0;
	public int funds=20000;
	public MouseTracer3 mouse;
	public Screen3(MapThree map){
		setSize(400,400);
		setBackground(Color.DARK_GRAY);
		this.map=map;
	}
    public void addMouseTracer(MouseTracer3 mouse){
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
			for(int i=1;i<=3;i++){
				if(rand.nextInt(2)==0)
					map.moveEnemy(g,1, 0);
				else
					map.moveEnemy(g,18, 0);
			}
			break;
		}
	}
}
