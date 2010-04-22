package example;

import java.awt.Point;

/**
 *
 * 
 */
public class BlueCaster extends Ally{
    public static final int BLUECASTER_FLAG_1 = 7;
    public static final int BLUECASTER_FLAG_2 = 8;
    public static final int BLUECASTER_FLAG_3 = 9;
    public static final int BLUECASTER_FLAG_4 = 10;
    public static final int BLUECASTER_FLAG_5 = 11;
    int level;
    Point location ;
    int attack ;
    int attack_speed;
    int upgradelevelmeter;
    int range ;
    int character_flag;

public BlueCaster(){
    level = 1;
    attack = 8;
    attack_speed = 1;
    upgradelevelmeter = 0;
    range = 2;
    character_flag = BLUECASTER_FLAG_1; // this ranges from 7 - 11 depending on the level
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
    
    public void dealDamage() {
        //deal damage
        // Random Number Generator
        // If in range, do damage and slow enemy by 50% 
    }
}
