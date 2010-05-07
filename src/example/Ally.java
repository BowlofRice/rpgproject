package example;

import java.awt.Graphics;
import java.awt.Point;

abstract public class Ally {
	private Point location = new Point();
	private int sellworth=0;
	abstract public void gainExperience();
	abstract public void increaseLevel();
	abstract public void increaseAttack();
	abstract public void increaseAttackSpeed();
	abstract public void dealDamage(Minion m);
	abstract public void dealDamageB(Boss b);
	abstract public boolean withinRange(Enemy e);
	abstract public void drawUnit(Graphics g);
    abstract public String getJob();
    abstract public int getLevel();

	public Point getLocation() {
		return location;
	}
	public void setSellWorth(int worth){
		sellworth=worth;
	}
	public int getSellWorth(){
		return sellworth;
	}
	public void setLocation(int x, int y) {
		location.x = x;
		location.y = y;
	}
}
