package example;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

@SuppressWarnings("serial")
public class Field extends Canvas{
	public int dx=0;//dx for main screen
	public int dy=0;//dy for map selection screen
	public int dxl=0;//dx for map selection screen
	public int flag=0;//for selecting what to show
	public int counter=0;//to make the cursor bigger
	public int counter2=0;//to make the cursor smaller
	
	public Field(){
		setSize(800,600);
	}
	public void timestep(){
		if(KeyListen.keycode==39 && flag==0){
			dx=220;
		}
		if(KeyListen.keycode==37 && 180+dx==400 && flag==0){
			dx=0;
		}
		if(KeyListen.keycode==10 && 180+dx==400 && flag==0){
			flag=1;
		}//new game option
		if(KeyListen.keycode==10 && 180+dx==180 && flag==0){
			flag=2;
		}//continue option
		if(KeyListen.keycode==27 && flag==2){
			flag=0;
		}//return to main option
		//code for blue screen below
		if(KeyListen.keycode==40 && flag==1){
			if(counter==0){
				counter++;
			}
			if(counter==1){
				dxl=50;
			}
			dy=100;
		}
		if(KeyListen.keycode==38 && 60+dy==160 && flag==1){
			dxl=0;
			dy=0;
		}
		if(KeyListen.keycode==38 && 60+dy==260 && flag==1){
			dxl=0;
			dy=0;
		}
		if(KeyListen.keycode==27 && flag==1){
			flag=0;
		}//return to main option
	}
	public void update(Graphics g)
	{
	Image os = createImage(getWidth(), getHeight());
	paint(os.getGraphics());
	g.drawImage(os,0,0,this);
	}
	public void paint(Graphics g){
		Graphics2D g2d= (Graphics2D) g;
		Font ff=new Font("Final Fantasy", Font.PLAIN,100);
		Font text=new Font("G.B.BOOT", Font.PLAIN,40);
		g.setFont(ff);
		g.setColor(Color.WHITE);
		if(flag==0){
			setBackground(Color.BLACK);
			g.drawString("TITLE SCREEN", 200, 300);
			g.setFont(text);
			g.drawString("New Game", 410, 500);
			g.drawString("Continue", 200, 500);
			g2d.setStroke(new BasicStroke(5));
			g.drawRoundRect(180+dx, 460, 200, 50, 30, 30);
		}
		if(flag==1){
			setBackground(Color.BLUE);
			g.setFont(text);
			g2d.setStroke(new BasicStroke(5));
			g.setColor(Color.WHITE);
			g.drawRoundRect(10, 10, getWidth()-20, getHeight()-20, 30, 30);
			g.drawString("First Board", 100, 100);
			g.drawString("Second Board", 100, 200);
			g.drawString("Third Board", 100, 300);
			g.drawRoundRect(90, 60+dy, 205+dxl, 50, 30, 30);
		}
		if(flag==2){
			setBackground(Color.RED);
			g.setFont(text);
			g.drawString("Loading has not been implemented", 100, getHeight()/2);
		}
		//System.out.println(60+dy);
	}
	

}
