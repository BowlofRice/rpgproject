package example;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

/**
 *
 * 
 */
public class GreenCaster extends Ally{
    public static final int GREENCASTER_FLAG_1 = 12;
    public static final int GREENCASTER_FLAG_2 = 13;
    public static final int GREENCASTER_FLAG_3 = 14;
    public static final int GREENCASTER_FLAG_4 = 15;
    public static final int GREENCASTER_FLAG_5 = 16;
    
    Image img12 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char12.gif");
    Image img13 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char13.gif");
    Image img14 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char14.gif");
    Image img15 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char15.gif");
    Image img16= Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char16.gif");
    
    int level;
    Point location=new Point();//default starting location
    int attack;
    int attack_speed;
    int upgradelevelmeter;
    int range;
    int character_flag;

    public GreenCaster(int x, int y){
    	location.x=x;
    	location.y=y;
    	level = 1;
    	attack = 8;
    	attack_speed = 1;
    	upgradelevelmeter = 0;
    	range = 2;
    	character_flag = GREENCASTER_FLAG_1; //ranges from 12 to 16 depending on the level
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

    public void increaseAttack(){
        attack=attack*2;
    }
    
    public void dealDamage(){
      //do damage
      // Random Number Generator to see if poisoned
      // For 8 seconds, take 0.2* current attack extra damage    
    }

	@Override
	public void drawUnit(Graphics g) {
		// TODO Auto-generated method stub
		switch(character_flag){
			case GREENCASTER_FLAG_1:
				g.drawImage(img12, location.x, location.y, null);
				break;
			case GREENCASTER_FLAG_2:
				g.drawImage(img13, location.x, location.y, null);
				break;
			case GREENCASTER_FLAG_3:
				g.drawImage(img14, location.x, location.y, null);
				break;
			case GREENCASTER_FLAG_4:
				g.drawImage(img15, location.x, location.y, null);
				break;
			case GREENCASTER_FLAG_5:
				g.drawImage(img16, location.x, location.y, null);
				break;
		}
	}

}
