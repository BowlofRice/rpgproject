package example;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.Random;

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
    Point location=new Point();//default starting location
    float attack;
    double expPoints;
    int range;
    int character_flag;
    int attack_speed;

    public RedCaster(int x, int y){
    	location.x=x;
    	location.y=y;
    	level = 1;
    	attack = 3;
    	attack_speed = 1;
    	expPoints = 0;
    	range = 2;
    	character_flag = REDCASTER_FLAG_1; //ranges from 17 to 21 depending on level
    }

    public void gainExperience()
    {
    	if(level<5)
    		expPoints += .2;
        if(expPoints >= 1 && level<=5)
        {
            increaseLevel();
            expPoints = 0;
        }
        System.out.println(expPoints);
    }

    public void increaseLevel(){
    	System.out.println("red level up!");
        increaseAttack();
        increaseAttackSpeed();
        level++;
        //character_flag++;
    }
    
    public void increaseAttackSpeed() {
        attack_speed = attack_speed * 2;
    }

    public  void increaseAttack(){
        attack=attack*2;
    }
   
    public void dealDamage(Minion m) {
        m.health -= attack;
        Random r = new Random();
        int randNum = r.nextInt(100) + 1;
        if(randNum % 2 == 0) {
            // Enemy is Burned (Extra 35% damage)
            while(m.health > 0) {
                m.health -= 0.35 * attack;
            }
        }   
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

	@Override
	public void dealDamageB(Boss b) {
		// TODO Auto-generated method stub
		b.health -= attack;
        Random r = new Random();
        int randNum = r.nextInt(100) + 1;
        if(randNum % 2 == 0) {
            // Enemy is Burned (Extra 35% damage)
            while(b.health > 0) {
                b.health -= 0.35 * attack;
            }
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

	

}
