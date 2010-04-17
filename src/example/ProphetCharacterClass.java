package example;

/**
 *
 * 
 */
public class ProphetCharacterClass {
    public static final int PROPHET_FLAG_1 = 27;
    public static final int PROPHET_FLAG_2 = 28;
    public static final int PROPHET_FLAG_3 = 29;
    public static final int PROPHET_FLAG_4 = 30;
    public static final int PROPHET_FLAG_5 = 31;
    int level;
    int location;//default starting location
    int attack;
    int upgradelevelmeter;
    int range;
    int character_flag;
    
    public ProphetCharacterClass(){

    this.level = 1;
    this.location = 1;//default starting location
    this.attack = 2;
    this.upgradelevelmeter = 0;
    this.range = 5;
    this.character_flag = 27; //ranges from 27 to 31 depending on range

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
        attack+=attack*attack;
    }


}
