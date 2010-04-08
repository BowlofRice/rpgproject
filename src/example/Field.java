package example;


import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Field extends Canvas{
	int flag=0;
	int dx;
	int dy;
	private MapAltOne maptest;
	Image img0 = Toolkit.getDefaultToolkit().getImage("http://shop.advanceweb.com/images/swatches/LARose_sand.gif");
	public Field(MapAltOne maptest){
		setSize(800,600);
		this.maptest=maptest;
	}
	public void update(Graphics g){
		Image os = createImage(getWidth(), getHeight());
		paint(os.getGraphics());
		g.drawImage(os,0,0,this);
	}
	public void timestep(){
		if(flag==0){
			switch(KeyListen.keycode){
			case 10://corresponds to pressing enter at title screen: go to map screen
				flag=1;
				break;
			}
		}
		if(flag==1){
			switch(KeyListen.keycode){
			case 32://corresponds to pressing the space bar at the map screen: select a map
				if(dx==0 && dy==0)
					flag=2;//map 1
				if(dx==110)
					flag=3;//map 2
				if(dy==-110)
					flag=4;//map 3
				break;
			case 27://corresponds to pressing esc at map screen: back to title screen
				flag=0;
				break;
			case 37://corresponds to pressing left key at map screen: move curson left
				if(dx==110)
					dx-=110;
				break;
			case 38://corresponds to pressing up key at map screen: move curson left
				if(dx==0)
					dy=-110;
				break;
			case 39://corresponds to pressing right key at map screen: move cursor right
				dx=110;
				break;
			case 40://corresponds to pressing down key at map screen: move curson left
				if(dy==-110)
					dy=0;
				break;
			}
			
		}
		if(flag==2){
			switch(KeyListen.keycode){
			case 66://corresponds to pressing b key: go back to map selection screen
				flag=1;
				break;
			}
		}
		if(flag==3){
			switch(KeyListen.keycode){
			case 66://corresponds to pressing b key: go back to map selection screen
				flag=1;
				break;
			}
		}
		if(flag==4){
			switch(KeyListen.keycode){
			case 66://corresponds to pressing b key: go back to map selection screen
				flag=1;
				break;
			}
		}
	}
	public void paint(Graphics g){
		Font ff=new Font("Final Fantasy", Font.PLAIN,100);
		Font text=new Font("G.B.BOOT", Font.PLAIN,40);
		Font text2=new Font("G.B.BOOT", Font.PLAIN,10);
		setBackground(Color.BLACK);
		g.setFont(text);
		switch(flag){
		case 0:
			g.drawString("BATTLE FOR TROY", 100, getHeight()/2);
			g.drawString("push enter", 600, 550);
			break;
		case 1:
			g.drawString("prepare for combat...", 0, 200);
			g.drawString("...choose your battlefield...", 300, 300);
			g.drawString("space bar to select", 450, 550);
			g.drawRect(211, 438, 100, 100);
			g.drawString("1", 250, 495);
			g.drawRect(321, 438, 100, 100);
			g.drawString("2", 360, 495);
			g.drawRect(211, 328, 100, 100);
			g.drawString("3", 250, 385);
			g.setColor(Color.GREEN);
			g.drawRect(211+dx, 438+dy, 100, 100);
			break;
		case 2://map 1
			maptest.paint(g, maptest.MapOne);
			break;
		case 3:
			g.drawString("battlefield 2 goes here...", 100, 100);
			g.drawString("b to go back", 10, 300);
			break;
		case 4:
			g.drawString("battlefield 3 goes here...", 100, 100);
			g.drawString("b to go back", 10, 300);
			break;
	}
		//System.out.println(flag);
	}
	
}