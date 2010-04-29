package example;

import java.awt.Point;

/**
 *
 *
 */
 
public class TroyCastle {
	public static final int TROYCASTLECLASS_FLAG_1 = 42;
	private Point location=new Point();
	int health;
	int character_flag;

    public TroyCastle(int x, int y) {
    	location.x=x;
    	location.y=y;
    	health = 100;
    	character_flag = 42;
    }
    
    public void increaseHealth() {
    	if(this.health != 100)
    		this.health += 15; 
    }
    public Point getLocation(){
    	return location;
    }
    
}