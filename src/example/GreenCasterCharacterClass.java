package example;

/**
 *
 * 
 */
public class GreenCasterCharacterClass {
    public static final int GREENCASTER_FLAG_1 = 12;
    public static final int GREENCASTER_FLAG_2 = 13;
    public static final int GREENCASTER_FLAG_3 = 14;
    public static final int GREENCASTER_FLAG_4 = 15;
    public static final int GREENCASTER_FLAG_5 = 16;
    int level;
    int location;//default starting location
    int attack;
    int attack_speed;
    int upgradelevelmeter;
    int range;
    int character_flag;

public GreenCasterCharacterClass(){
    this.level = 1;
    this.location = 1;//default starting location
    this.attack = 8;
    this.attack_speed = 1;
    this.upgradelevelmeter = 0;
    this.range = 2;
    this.character_flag = 12; //ranges from 12 to 16 depending on the level
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
        level++;
        character_flag++;
    }

    public void increase_attack_speed() {
        attack_speed = attack_speed * 2;
    }

    public void increase_attack(){
        attack=attack*2;
    }
    
    public attack_enemy(){
      //do damage
      // Random Number Generator to see if poisoned
      // For 8 seconds, take 0.2* current attack extra damage    
    }

}
