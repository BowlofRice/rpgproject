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
    public int level;
    public TroyCastleClass troy;
    	
    
    public BossClass(TroyCastleClass troy) {
    	this.level = 1;
    	this.location = 1;
    	this.attack = 10;
    	this.speed = 2;
    	this.character_flag = 37;
        this.troy = troy;
    	
    }
    
    public void increaselevel() {
    	increase_attack();
        increase_health();
    	level++;
    	character_flag++;
    }
    
    public void increase_health() {
        //Left Blank for now
    }
    
    public void increase_attack() {
    	attack=attack*attack;
    }
    
    public void deal_damage() {
        troy.health -= this.attack;
    }
    
    
}