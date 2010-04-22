package example;

import java.awt.Point;

/**
 *
 *
 */
 
public class Boss extends Enemy{
    public static final int BOSSCLASS_FLAG_1 = 37;
    Point location;
    int health;
    int speed;
    int attack;
    int character_flag;
    public int level;
    public TroyCastleClass troy;
    	
    
    public Boss(TroyCastleClass troy) {
    	level = 1;
    	attack = 10;
    	speed = 2;
    	character_flag = BOSSCLASS_FLAG_1;
        this.troy = troy;
    	
    }
    
    public void increaseLevel() {
    	increaseAttack();
        increaseHealth();
    	level++;
    	character_flag++;
    }
    
    public void increaseHealth() {
        //Left Blank for now
    }
    
    public void increaseAttack() {
    	attack=attack*attack;
    }
    
    public void dealDamage() {
        troy.health -= this.attack;
    }
    
    
}