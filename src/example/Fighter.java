package example;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

/**
 *
 * 
 */
public class Fighter extends Ally{
    public static final int FIGHTER_FLAG_1 = 22;
    public static final int FIGHTER_FLAG_2 = 23;
    public static final int FIGHTER_FLAG_3 = 24;
    public static final int FIGHTER_FLAG_4 = 25;
    public static final int FIGHTER_FLAG_5 = 26;
    
    Image img22 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char22.gif");
    Image img23 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char23.gif");
    Image img24 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char24.gif");
    Image img25 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char25.gif");
    Image img26 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char26.gif");
    
    int level;
    Point location=new Point();//default starting location
    float attack;
    int attack_speed;
    double expPoints;
    int range ;
    int character_flag;
    public Fighter(int x, int y){
    	location.x=x;
    	location.y=y;
    	level = 1;
    	attack = 8;
    	attack_speed = 1;
    	expPoints = 0;
    	range = 1;
    	character_flag = FIGHTER_FLAG_1; //ranges from 22 to 26 depending on the level
    }
    public void gainExperience()
    {
        expPoints += .2;
        if(expPoints >= 1 && level<=5)
        {
            increaseLevel();
            expPoints = 0;
        }
        System.out.println(expPoints);
    }

    public void increaseLevel(){
    	System.out.println("fighter level up!");
        increaseAttackSpeed();
        increaseAttack();
        level++;
        //character_flag++;
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
	@Override
	public void drawUnit(Graphics g) {
		// TODO Auto-generated method stub
		switch(character_flag){
			case FIGHTER_FLAG_1:
				g.drawImage(img22, location.x, location.y, null);
				break;
			case FIGHTER_FLAG_2:
				g.drawImage(img23, location.x, location.y, null);
				break;
			case FIGHTER_FLAG_3:
				g.drawImage(img24, location.x, location.y, null);
				break;
			case FIGHTER_FLAG_4:
				g.drawImage(img25, location.x, location.y, null);
				break;
			case FIGHTER_FLAG_5:
				g.drawImage(img26, location.x, location.y, null);
				break;
		}
	}
	@Override
	public boolean withinRange(Enemy e) {
		// TODO Auto-generated method stub
		double dist;
		int dx=e.getLocation().x-location.x/20;
		int dy=e.getLocation().y-location.y/20;
		dist= Math.sqrt(dx*dx + dy*dy);
		if(dist<=range)
			return true;
		else
			return false;
	}
	@Override
	public void dealDamageB(Boss b) {
		// TODO Auto-generated method stub
		 b.health -= attack; 
	}

}
