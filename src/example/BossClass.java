package example;

/**
 *
 *
 */
 
public class BossClass {
    public static final int BOSSCLASS_FLAG_1 = 37;
    int location;
    int health;
    int speed;
    int attack;
    int character_flag;
    private int level;
    	
    public BossClass() {
    	this.level = 1;
    	this.location = 1;
    	this.attack = 10;
    	this.speed = 2;
    	this.character_flag = 37;
    	
    }
    
    void increaselevel() {
    	increase_attack();
    	level++;
    	character_flag++;
    }
    
    void increase_attack() {
    	attack=attack*attack;
    }
    
    
}
