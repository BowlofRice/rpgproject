package example;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class Field extends Canvas{
	public int flag=0;
	public Field(){
		setSize(800,600);
	}
	public void paint(Graphics g){
		Font ff=new Font("Final Fantasy", Font.PLAIN,100);
		Font text=new Font("G.B.BOOT", Font.PLAIN,40);
		g.setFont(ff);
		g.setColor(Color.WHITE);
		g.drawString("TITLE SCREEN", 200, 300);
		if(flag==0){
			g.setFont(text);
			g.drawString("New Game", 410, 500);
			g.drawString("Continue", 200, 500);
			//g.fillOval(x, y, width, height)
			
		}
	}
	public void update(){
		
	}

}
