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
    int attack_speed;
    int upgradelevelmeter;
    int range;
    int character_flag;
    
    public ProphetCharacterClass(){

    this.level = 1;
    this.location = 1;//default starting location
    this.attack = 2;
    this.attack_speed = 1;
    this.upgradelevelmeter = 0;
    this.range = 5;
    this.character_flag = 27; //ranges from 27 to 31 depending on range

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

    public void increase_attack(){
        attack+=attack*attack;
    }
    
    public void increase_attack_speed() {
         attack_speed = attack_speed * 2;
    }
    
    public EasterEgg() {
        // Switch Statement of Prophet Sayings
    }

}
