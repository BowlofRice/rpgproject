package example;

/**
 *
 * @author andrew
 */
public class RedCasterCharacterClass {

    int level = 1;
    int location = 1;//default starting location
    int attack = 8;
    int upgradelevelmeter = 0;
    int range = 2;

    void gainexperience(int upgradelevelmeter)
    {
        upgradelevelmeter += .05;
        if(upgradelevelmeter >= 1 && level<=3)
        {
            increaselevel();
            upgradelevelmeter = 0;
        }
    }

    void increaselevel(){
        increase_attack();
        level++;
    }

    void increase_attack(){
        attack=attack*2;
    }


}