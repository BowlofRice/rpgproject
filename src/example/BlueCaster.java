package example;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

/**
 *
 * 
 */
public class BlueCaster extends Ally{
    public static final int BLUECASTER_FLAG_1 = 7;
    public static final int BLUECASTER_FLAG_2 = 8;
    public static final int BLUECASTER_FLAG_3 = 9;
    public static final int BLUECASTER_FLAG_4 = 10;
    public static final int BLUECASTER_FLAG_5 = 11;
    
    Image img7 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char7.gif");
    Image img8 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char8.gif");
    Image img9 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char9.gif");
    Image img10 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char10.gif");
    Image img11= Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char11.gif");
    
    int level;
    Point location=new Point() ;
    int attack ;
    int attack_speed;
    int upgradelevelmeter;
    int range ;
    int character_flag;

public BlueCaster(int x, int y){
	location.x=x;
	location.y=y;
    level = 1;
    attack = 8;
    attack_speed = 1;
    upgradelevelmeter = 0;
    range = 2;
    character_flag = BLUECASTER_FLAG_1; // this ranges from 7 - 11 depending on the level
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
    
    public void dealDamage() {
        //deal damage
        // Random Number Generator
        // If in range, do damage and slow enemy by 50% 
    }

	@Override
	public void drawUnit(Graphics g) {
		// TODO Auto-generated method stub
		switch(character_flag){
			case BLUECASTER_FLAG_1:
				g.drawImage(img7, location.x, location.y, null);
				break;
			case BLUECASTER_FLAG_2:
				g.drawImage(img8, location.x, location.y, null);
				break;
			case BLUECASTER_FLAG_3:
				g.drawImage(img9, location.x, location.y, null);
				break;
			case BLUECASTER_FLAG_4:
				g.drawImage(img10, location.x, location.y, null);
				break;
			case BLUECASTER_FLAG_5:
				g.drawImage(img11, location.x, location.y, null);
				break;
		}
	}
}
