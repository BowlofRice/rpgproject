package example;

import java.awt.Point;

/**
 *
 *
 */
 
public class Minion extends Enemy{
    public static final int ENEMYCLASS_FLAG_1 = 32;
    Point location;
    int health;
    int speed;
    int attack;
    int character_flag;
    int level;
    public TroyCastleClass troy;
    
    public Minion(TroyCastleClass troy) {
    	level = 1;
    	attack = 1;
    	speed = 1;
    	character_flag = ENEMYCLASS_FLAG_1; //ranges from 32 to 36
        this.troy = troy;
    }
    
    public void increaseLevel() {
    	increaseAttack();
        increaseHealth();
    	level++;
    	character_flag++;
    }
    public void increaseHealth() {
        //left blank for now until needed.
    }
    public void increaseAttack() {
    	attack=attack*2;
    }
    
    public void dealDamage() {
        troy.health -= this.attack; 
    }
    
    
}
