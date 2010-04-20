package example;

/**
 *
 * 
 */
public class ArcherCharacterClass {
    public static final int ARCHER_FLAG_1 = 2;
    public static final int ARCHER_FLAG_2 = 3;
    public static final int ARCHER_FLAG_3 = 4;
    public static final int ARCHER_FLAG_4 = 5;
    public static final int ARCHER_FLAG_5 = 6;
    int level;
    int location;//default starting location
    int attack;
    int attack_speed;
    int upgradelevelmeter;
    int range;
    int character_flag;

    public ArcherCharacterClass(){
    this.character_flag = 2; //this ranges from 2 to 6 depending on level
    this.level = 1;
    this.location = 1;//default starting location
    this.attack = 8;
    this.attack_speed = 1;
    this.upgradelevelmeter = 0;
    this.range = 3;
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
        increase_attack();
        increase_attack_speed();
        increase_range();
        level++;
        character_flag++;
    }

    public void increase_attack(){
        attack=attack*2;
    }
   
    public void increase_attack_speed() {
        attack_speed = attack_speed * 2;
    }

    public void increase_range() {
        range *= range;
    }
}
