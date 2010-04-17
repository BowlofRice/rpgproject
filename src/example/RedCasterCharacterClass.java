package example;

/**
 *
 * 
 */
public class RedCasterCharacterClass {
    public static final int REDCASTER_FLAG_1 = 17;
    public static final int REDCASTER_FLAG_2 = 18;
    public static final int REDCASTER_FLAG_3 = 19;
    public static final int REDCASTER_FLAG_4 = 20;
    public static final int REDCASTER_FLAG_5 = 21;
    int level;
    int location;//default starting location
    int attack;
    int upgradelevelmeter;
    int range;
    int character_flag;

public RedCasterCharacterClass(){

    this.level = 1;
    this.location = 1;//default starting location
    this.attack = 8;
    this.upgradelevelmeter = 0;
    this.range = 2;
    this.character_flag = 17; //ranges from 17 to 21 depending on level
}

    void gainexperience(int upgradelevelmeter)
    {
        upgradelevelmeter += .05;
        if(upgradelevelmeter >= 1 && level<=5)
        {
            increaselevel();
            upgradelevelmeter = 0;
        }
    }

    void increaselevel(){
        increase_attack();
        level++;
        character_flag++;
    }

    void increase_attack(){
        attack=attack*2;
    }


}
