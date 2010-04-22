package example;

import java.awt.Point;

/**
 *
 * 
 */
public class Archer extends Ally{
    public static final int ARCHER_FLAG_1 = 2;
    public static final int ARCHER_FLAG_2 = 3;
    public static final int ARCHER_FLAG_3 = 4;
    public static final int ARCHER_FLAG_4 = 5;
    public static final int ARCHER_FLAG_5 = 6;
    int level;
    Point location;
    int attack;
    int attack_speed;
    int upgradelevelmeter;
    int range;
    int character_flag;

    public Archer(){
    character_flag = ARCHER_FLAG_1; //this ranges from 2 to 6 depending on level
    level = 1;
    attack = 8;
    attack_speed = 1;
    upgradelevelmeter = 0;
    range = 3;
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
        increaseRange();
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
    public void increaseRange() {
        range *= range;
    }
}
