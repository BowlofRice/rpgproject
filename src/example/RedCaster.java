package example;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

/**
 *
 * 
 */
public class RedCaster extends Ally{
    public static final int REDCASTER_FLAG_1 = 17;
    public static final int REDCASTER_FLAG_2 = 18;
    public static final int REDCASTER_FLAG_3 = 19;
    public static final int REDCASTER_FLAG_4 = 20;
    public static final int REDCASTER_FLAG_5 = 21;
    
    Image img17 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char17.gif");
    Image img18 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char18.gif");
    Image img19 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char19.gif");
    Image img20 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char20.gif");
    Image img21 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char21.gif");
    
    int level;
    Point location;//default starting location
    int attack;
    int upgradelevelmeter;
    int range;
    int character_flag;
    int attack_speed;

public RedCaster(int x, int y){
	location.x=x;
	location.y=y;
    level = 1;
    attack = 8;
    attack_speed = 1;
    upgradelevelmeter = 0;
    range = 2;
    character_flag = REDCASTER_FLAG_1; //ranges from 17 to 21 depending on level
}

    public void gainExperience(int upgradelevelmeter)
    {
        upgradelevelmeter += .05;
        if(upgradelevelmeter >= 1 && level<=5)
        {
            increaseLevel();
            upgradelevelmeter = 0;
        }
    }

    public void increaseLevel(){
        increaseAttack();
        increaseAttackSpeed();
        level++;
        character_flag++;
    }
    
    public void increaseAttackSpeed() {
        attack_speed = attack_speed * 2;
    }

    public  void increaseAttack(){
        attack=attack*2;
    }
   
    public void dealDamage() {
        // do damage
        // random number generator
        // if in range of RN, do 0.35 * current attack extra damage
    }

	@Override
	public void drawUnit(Graphics g) {
		// TODO Auto-generated method stub
		switch(character_flag){
		case REDCASTER_FLAG_1:
			g.drawImage(img17, location.x, location.y, null);
			break;
		case REDCASTER_FLAG_2:
			g.drawImage(img18, location.x, location.y, null);
			break;
		case REDCASTER_FLAG_3:
			g.drawImage(img19, location.x, location.y, null);
			break;
		case REDCASTER_FLAG_4:
			g.drawImage(img20, location.x, location.y, null);
			break;
		case REDCASTER_FLAG_5:
			g.drawImage(img21, location.x, location.y, null);
			break;
	}
	}

}
