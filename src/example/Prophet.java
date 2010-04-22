package example;

import java.awt.Point;

/**
 *
 * 
 */
public class Prophet extends Ally{
    public static final int PROPHET_FLAG_1 = 27;
    public static final int PROPHET_FLAG_2 = 28;
    public static final int PROPHET_FLAG_3 = 29;
    public static final int PROPHET_FLAG_4 = 30;
    public static final int PROPHET_FLAG_5 = 31;
    int level;
    Point location;//default starting location
    int attack;
    int attack_speed;
    int upgradelevelmeter;
    int range;
    int character_flag;
    
    public Prophet(){

    level = 1;
    attack = 2;
    attack_speed = 1;
    upgradelevelmeter = 0;
    range = 5;
    character_flag = PROPHET_FLAG_1; //ranges from 27 to 31 depending on range

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

    public void increaseAttack(){
        attack+=attack*attack;
    }
    
    public void increaseAttackSpeed() {
         attack_speed = attack_speed * 2;
    }
    public void dealDamage() {
        //deal damage
        // Random Number Generator 
    }
    public void EasterEgg() {
        // Switch Statement of Prophet Sayings
    }

}
