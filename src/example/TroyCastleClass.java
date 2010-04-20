package example;

/**
 *
 *
 */
 
public class TroyCastleClass {
	public static final int TROYCASTLECLASS_FLAG_1 = 42;
	int location;
	int health;
	int character_flag;

    public TroyCastleClass() {
    	this.location = 1;
    	this.health = 100;
    	this.character_flag = 42;
    }
    
    void increasehealth() {
    	if(this.health != 100)
    		this.health += 15; 
    }
    
    
}