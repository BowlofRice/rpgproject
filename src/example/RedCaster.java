package example;

import java.awt.Point;

/**
 *
 * 
 */
public class RedCaster extends Ally{
    public static final int REDCASTER_FLAG_1 = 17;
    public static final int REDCASTER_FLAG_2 = 18;
    public static final int REDCASTER_FLAG_3 = 19;
    public static final int REDCASTER_FLAG_4 = 20;
    public static final int REDCASTER_FLAG_5 = 21;
    int level;
    Point location;//default starting location
    int attack;
    int upgradelevelmeter;
    int range;
    int character_flag;
    int attack_speed;

public RedCaster(){

    level = 1;
    attack = 8;
    attack_speed = 1;
    upgradelevelmeter = 0;
    range = 2;
    character_flag = REDCASTER_FLAG_1; //ranges from 17 to 21 depending on level
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

    public  void increaseAttack(){
        attack=attack*2;
    }
   
    public void dealDamage() {
        // do damage
        // random number generator
        // if in range of RN, do 0.35 * current attack extra damage
    }

}
