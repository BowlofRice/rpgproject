package example;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class Title extends Canvas{
	public Title(){
		setSize(400,400);
		setBackground(Color.DARK_GRAY);
	}
	public void paint(Graphics g){
		g.setColor(Color.ORANGE);
		g.drawString("Battle for troy", 200, 200);
	}
}
