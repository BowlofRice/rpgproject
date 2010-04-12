package example;

/**
 *
 * 
 */
public class MeleeCharacterClass {

    int level;
    int location;//default starting location
    int attack;
    int upgradelevelmeter;
    int range ;
    int character_flag;
public MeleeCharacterClass(){
    this.level = 1;
    this.location = 1;//default starting location
    this.attack = 8;
    this.upgradelevelmeter = 0;
    this.range = 1;
    this.character_flag = 22; //ranges from 22 to 26 depending on the level
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
