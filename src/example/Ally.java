package example;

import java.awt.Graphics;
import java.awt.Point;

abstract public class Ally {
	private Point location = new Point();

	abstract public void gainExperience(int i);

	abstract public void increaseLevel();

	abstract public void increaseAttack();

	abstract public void increaseAttackSpeed();

	abstract public void dealDamage(Minion m);

	abstract public boolean withinRange(Minion m);

	abstract public void drawUnit(Graphics g);

	public Point getLocation() {
		return location;
	}

	public void setLocation(int x, int y) {
		location.x = x;
		location.y = y;
	}
}
