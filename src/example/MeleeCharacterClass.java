package example;

/**
 *
 * 
 */
public class MeleeCharacterClass {
    public static final int MELEE_FLAG_1 = 22;
    public static final int MELEE_FLAG_2 = 23;
    public static final int MELEE_FLAG_3 = 24;
    public static final int MELEE_FLAG_4 = 25;
    public static final int MELEE_FLAG_5 = 26;
    int level;
    int location;//default starting location
    int attack;
    int attack_speed;
    int upgradelevelmeter;
    int range ;
    int character_flag;
public MeleeCharacterClass(){
    this.level = 1;
    this.location = 1;//default starting location
    this.attack = 8;
    this.attack_speed = 1;
    this.upgradelevelmeter = 0;
    this.range = 1;
    this.character_flag = 22; //ranges from 22 to 26 depending on the level
}
    public void gainexperience(int upgradelevelmeter)
    {
        upgradelevelmeter += .05;
        if(upgradelevelmeter >= 1 && level<=5)
        {
            increaselevel();
            upgradelevelmeter = 0;
        }
    }

    public void increaselevel(){
        increase_attack_speed();
        increase_attack();
        level++;
        character_flag++;
    }

    public void increase_attack(){
        attack=attack*2;
    }

    public void increase_attack_speed() {
        attack_speed = attack_speed * 2;
    }

}
