package example;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

/**
 *
 * 
 */
public class Archer extends Ally{
    public static final int ARCHER_FLAG_1 = 2;
    public static final int ARCHER_FLAG_2 = 3;
    public static final int ARCHER_FLAG_3 = 4;
    public static final int ARCHER_FLAG_4 = 5;
    public static final int ARCHER_FLAG_5 = 6;
    
    Image img2 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char2.gif");
    Image img3 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char3.gif");
    Image img4 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char4.gif");
    Image img5 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char5.gif");
    Image img6 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char6.gif");
    
    int level;
    Point location=new Point();
    float attack;
    int attack_speed;
    int upgradelevelmeter;
    int range;
    int character_flag;

    public Archer(int x, int y){
    character_flag = ARCHER_FLAG_1; //this ranges from 2 to 6 depending on level
    level = 1;
    location.x=x;
    location.y=y;
    attack = 8;
    attack_speed = 1;
    upgradelevelmeter = 0;
    range = 3;
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
        increaseRange();
        level++;
        character_flag++;
    }

    public void increaseAttack(){
        attack=attack*2;
    }
   
    public void increaseAttackSpeed() {
        attack_speed = attack_speed * 2;
    }
    public void dealDamage(Minion m) {
         m.health -= attack; 
    }
    public void increaseRange() {
        range *= range;
    }

	@Override
	public void drawUnit(Graphics g) {
		// TODO Auto-generated method stub
		switch(character_flag){
			case ARCHER_FLAG_1:
				g.drawImage(img2, location.x, location.y, null);
				break;
			case ARCHER_FLAG_2:
				g.drawImage(img3, location.x, location.y, null);
				break;
			case ARCHER_FLAG_3:
				g.drawImage(img4, location.x, location.y, null);
				break;
			case ARCHER_FLAG_4:
				g.drawImage(img5, location.x, location.y, null);
				break;
			case ARCHER_FLAG_5:
				g.drawImage(img6, location.x, location.y, null);
				break;
		}
	}

	@Override
	public boolean withinRange(Minion m) {
		// TODO Auto-generated method stub
		double dist;
		int dx=m.getLocation().x-location.x/20;
		int dy=m.getLocation().y-location.y/20;
		dist= Math.sqrt(dx*dx + dy*dy);
		if(dist<=range)
			return true;
		else
			return false;
	}
}
