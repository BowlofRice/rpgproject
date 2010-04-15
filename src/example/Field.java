package example;


import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

@SuppressWarnings("serial")
public class Field extends Canvas{
	int flag=0;
	int dx;
	int dy;
	int xEnemyCoor=9;//coordinates for an enemy
	int yEnemyCoor=0;
	int xAllyCoor=10;//ally coordinates have to abide to valid location
	int yAllyCoor=10;
	int allyFlag=2;//2~31
	private MapAltOne maptest;
	private MapAltTwo map2test;
	private MapAltThree map3test;
	public Field(MapAltOne maptest, MapAltTwo map2test, MapAltThree map3test){
		setSize(800,600);
		this.maptest=maptest;
		this.map2test=map2test;
		this.map3test=map3test;
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
		Font text=new Font("G.B.BOOT", Font.PLAIN,40);
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
			maptest.paint(g);
			//maptest.paintCharacter(g, xEnemyCoor, yEnemyCoor, 1);//draws enemies
			maptest.moveEnemy(g, maptest.MapTraversalOne, 9, 1);
			maptest.paintCharacter(g, xAllyCoor, yAllyCoor, allyFlag);//draws allies
			break;
		case 3:
			map2test.paint(g);
			break;
		case 4:
			map3test.paint(g);
			break;
	}
		//System.out.println(flag);
	}
	
}