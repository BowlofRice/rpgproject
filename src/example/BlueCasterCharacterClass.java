package example;

/**
 *
 * 
 */
public class BlueCasterCharacterClass {
    public static final int BLUECASTER_FLAG_1 = 7;
    public static final int BLUECASTER_FLAG_2 = 8;
    public static final int BLUECASTER_FLAG_3 = 9;
    public static final int BLUECASTER_FLAG_4 = 10;
    public static final int BLUECASTER_FLAG_5 = 11;
    int level;
    int location ;//default starting location
    int attack ;
    int upgradelevelmeter;
    int range ;
    int character_flag;

public BlueCasterCharacterClass(){
    this.level = 1;
    this.location = 1;//default starting location
    this.attack = 8;
    this.upgradelevelmeter = 0;
    this.range = 2;
    this.character_flag = 7; // this ranges from 7 - 11 depending on the level
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
