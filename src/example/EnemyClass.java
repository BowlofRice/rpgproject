package example;

/**
 *
 *
 */
 
public class EnemyClass {
    public static final int ENEMYCLASS_FLAG_1 = 32;
    int location;
    int health;
    int speed;
    int attack;
    int character_flag;
    int level;
    public TroyCastleClass troy;
    
    public EnemyClass(TroyCastleClass troy) {
    	this.level = 1;
    	this.location = 1;
    	this.attack = 1;
    	this.speed = 1;
    	this.character_flag = 31; //ranges from 32 to 36
        this.troy = troy;
    }
    
    public void increaselevel() {
    	increase_attack();
        increase_health();
    	level++;
    	character_flag++;
    }
    public void increase_health() {
        //left blank for now until needed.
    }
    public void increase_attack() {
    	attack=attack*2;
    }
    
    public void deal_damage() {
        troy.health -= this.attack; 
    }
    
    
}
