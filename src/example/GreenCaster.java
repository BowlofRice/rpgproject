package example;

import java.awt.Point;

/**
 *
 * 
 */
public class GreenCaster extends Ally{
    public static final int GREENCASTER_FLAG_1 = 12;
    public static final int GREENCASTER_FLAG_2 = 13;
    public static final int GREENCASTER_FLAG_3 = 14;
    public static final int GREENCASTER_FLAG_4 = 15;
    public static final int GREENCASTER_FLAG_5 = 16;
    int level;
    Point location;//default starting location
    int attack;
    int attack_speed;
    int upgradelevelmeter;
    int range;
    int character_flag;

    public GreenCaster(){
    	level = 1;
    	attack = 8;
    	attack_speed = 1;
    	upgradelevelmeter = 0;
    	range = 2;
    	character_flag = GREENCASTER_FLAG_1; //ranges from 12 to 16 depending on the level
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
        increaseAttack();
        increaseAttackSpeed();
        level++;
        character_flag++;
    }

    public void increaseAttackSpeed() {
        attack_speed = attack_speed * 2;
    }

    public void increaseAttack(){
        attack=attack*2;
    }
    
    public void dealDamage(){
      //do damage
      // Random Number Generator to see if poisoned
      // For 8 seconds, take 0.2* current attack extra damage    
    }

}
