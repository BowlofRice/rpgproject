package example;

/**
 *
 *
 */
 
public class Boss extends Enemy{
    public static final int BOSSCLASS_FLAG_1 = 37;
    float health;
    float speed;
    int attack;
    int character_flag;
    public int level;
    	
    
    public Boss() {
    	level = 1;
    	attack = 40;
    	health=40;
    	speed = 2;
    	character_flag = BOSSCLASS_FLAG_1;
    	
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
    
    public void dealDamage(TroyCastle troy) {
        troy.health -= this.attack;
    }
    
}
