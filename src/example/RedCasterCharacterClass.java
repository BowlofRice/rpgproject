package example;

/**
 *
 * 
 */
public class RedCasterCharacterClass {

    int level;
    int location;//default starting location
    int attack;
    int upgradelevelmeter;
    int range;
    int flag;

public RedCasterCharacterClass(){
    int level = 1;
    int location = 1;//default starting location
    int attack = 8;
    int upgradelevelmeter = 0;
    int range = 2;
    int flag = 17; //ranges from 17 to 21 depending on level
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
        flag++;
    }

    void increase_attack(){
        attack=attack*2;
    }


}
