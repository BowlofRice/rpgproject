package example;

/**
 *
 * 
 */
public class BlueCasterCharacterClass {

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
