package example;

/**
 *
 * 
 */
public class ArcherCharacterClass {

    int level;
    int location;//default starting location
    int attack;
    int upgradelevelmeter;
    int range;
    int flag;

    public ArcherCharacterClass(){
    this.flag = 2; //this ranges from 2 to 6 depending on level
    this.level = 1;
    this.location = 1;//default starting location
    this.attack = 8;
    this.upgradelevelmeter = 0;
    this.range = 3;
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
