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
    
    public EnemyClass() {
    	this.level = 1;
    	this.location = 1;
    	this.attack = 1;
    	this.speed = 1;
    	this.character_flag = 31; //ranges from 32 to 36
    }
    
    void increaselevel() {
    	increase_attack();
    	level++;
    	character_flag++;
    }
    
    void increase_attack() {
    	attack=attack*2;
    }
    
    
}
