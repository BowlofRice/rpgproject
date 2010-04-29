package example;

import java.awt.Point;

abstract public class Enemy {
	private Point location=new Point();
	private int range=1;
	abstract public void increaseLevel();
	abstract public void increaseHealth();
	abstract public void increaseAttack();
	abstract public void dealDamage(TroyCastle troy);
	public Point getLocation(){
		return location;
	}
	public void setLocation(int x, int y){
		location.x=x;
		location.y=y;
	}
	public boolean withinRange(TroyCastle troy){
		double dist;
		int dx=troy.getLocation().x-location.x;
		int dy=troy.getLocation().y-location.y;
		dist= Math.sqrt(dx*dx + dy*dy);
		if(dist<=range)
			return true;
		else
			return false;
	}
}
