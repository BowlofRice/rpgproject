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
    int attack_speed;
    int upgradelevelmeter;
    int range ;
    int character_flag;

public BlueCasterCharacterClass(){
    this.level = 1;
    this.location = 1;//default starting location
    this.attack = 8;
    this.attack_speed = 1;
    this.upgradelevelmeter = 0;
    this.range = 2;
    this.character_flag = 7; // this ranges from 7 - 11 depending on the level
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
    
    public deal_damage() {
        //deal damage
        // Random Number Generator
        // If in range, do damage and slow enemy by 50% 
    }
}
