package example;

/**
 *
 * 
 */
public class ProphetCharacterClass {

    int level;
    int location;//default starting location
    int attack;
    int upgradelevelmeter;
    int range;
    int flag;
    
    public ProphetCharacterClass(){

    this.level = 1;
    this.location = 1;//default starting location
    this.attack = 2;
    this.upgradelevelmeter = 0;
    this.range = 5;
    this.flag = 27; //ranges from 27 to 31 depending on range

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
    }

    void increase_attack(){
        attack+=attack^2;
    }


}
