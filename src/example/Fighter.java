package example;

import java.awt.Point;

/**
 *
 * 
 */
public class Fighter extends Ally{
    public static final int MELEE_FLAG_1 = 22;
    public static final int MELEE_FLAG_2 = 23;
    public static final int MELEE_FLAG_3 = 24;
    public static final int MELEE_FLAG_4 = 25;
    public static final int MELEE_FLAG_5 = 26;
    int level;
    Point location;//default starting location
    int attack;
    int attack_speed;
    int upgradelevelmeter;
    int range ;
    int character_flag;
    public Fighter(){
    	level = 1;
    	attack = 8;
    	attack_speed = 1;
    	upgradelevelmeter = 0;
    	range = 1;
    	character_flag = MELEE_FLAG_1; //ranges from 22 to 26 depending on the level
    }
    public void gainExperience(int upgradelevelmeter)
    {
        upgradelevelmeter += .05;
        if(upgradelevelmeter >= 1 && level<=5)
        {
            increaseLevel();
            upgradelevelmeter = 0;
        }
    }

    public void increaseLevel(){
        increaseAttackSpeed();
        increaseAttack();
        level++;
        character_flag++;
    }

    public void increaseAttack(){
        attack=attack*2;
    }

    public void increaseAttackSpeed() {
        attack_speed = attack_speed * 2;
    }
    public void dealDamage() {
        //deal damage
        // Random Number Generator 
    }

}
