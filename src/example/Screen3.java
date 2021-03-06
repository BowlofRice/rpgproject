package example;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class Screen3 extends Canvas{
	Random rand=new Random();
	private MapThree map;
	public int playTime=0;
	public int round=1;
	public JTextArea roundDisp=new JTextArea(""+round);
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
			switch(round){
				case 1:
					for(int i=1;i<=3;i++){
						if(rand.nextInt(2)==0)
							map.moveEnemy(g,1, 0);
						else
							map.moveEnemy(g,18, 0);
						if(rand.nextInt(20)<2){
							if(rand.nextInt(2)==0)
								map.theycallhimBossFight(g, 1, 0);
							else
								map.theycallhimBossFight(g, 18, 0);
						}
					}
					round=2;
					break;
				case 2:
					for(int i=1;i<=5;i++){
						if(rand.nextInt(2)==0)
							map.moveEnemy(g,1, 0);
						else
							map.moveEnemy(g,18, 0);
						if(rand.nextInt(20)<3){
							if(rand.nextInt(2)==0)
								map.theycallhimBossFight(g, 1, 0);
							else
								map.theycallhimBossFight(g, 18, 0);
						}
					}
					round=3;
					break;
				case 3:
					for(int i=1;i<=7;i++){
						if(rand.nextInt(2)==0)
							map.moveEnemy(g,1, 0);
						else
							map.moveEnemy(g,18, 0);
						if(rand.nextInt(20)<4){
							if(rand.nextInt(2)==0)
								map.theycallhimBossFight(g, 1, 0);
							else
								map.theycallhimBossFight(g, 18, 0);
						}
					}
					round=4;
					break;
				case 4:
					for(int i=1;i<=9;i++){
						if(rand.nextInt(2)==0)
							map.moveEnemy(g,1, 0);
						else
							map.moveEnemy(g,18, 0);
						if(rand.nextInt(20)<5){
							if(rand.nextInt(2)==0)
								map.theycallhimBossFight(g, 1, 0);
							else
								map.theycallhimBossFight(g, 18, 0);
						}
					}
					round=1;
					mouse.allies.removeAllElements();
					playTime=2;
					break;
			}
			break;
		case 2:
			g.setColor(Color.ORANGE);
			g.drawString("You beat this map. Way to go.", 120, 200);
			g.drawString("Press quit to play another map", 120, 220);
			g.drawString("Thanks for playing!", 150, 390);
			break;
		}
	}
}