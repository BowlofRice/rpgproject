package example;

/**
 *
 *
 */
 
public class TroyCastle {
	public static final int TROYCASTLECLASS_FLAG_1 = 42;
	int location;
	int health;
	int character_flag;

    public TroyCastle() {
    	location = 1;
    	health = 100;
    	character_flag = 42;
    }
    
    public void increaseHealth() {
    	if(this.health != 100)
    		this.health += 15; 
    }
    
    
}