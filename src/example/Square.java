package example;

import java.awt.Graphics;
import java.awt.Point;

public class Square{
	private int y;
	private int x;
	int centerX;
	int centerY;

	public Square(int x, int y){
		this.x=x;
		this.y=y;
	}


	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawRect(x, y, 20, 20);
	}
	public Point getPoint(){
		return new Point(x,y);
	}
	public boolean isInside(int x, int y) {
		// TODO Auto-generated method stub
		centerX=this.x+(18/2);
		centerY=this.y+(18/2);
		return ((centerX - x)*(centerX - x) + (centerY -y)*(centerY -y)) < (18*18);
	}

}
