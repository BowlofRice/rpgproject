package example;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

/**
 *
 * 
 */
public class Prophet extends Ally{
    public static final int PROPHET_FLAG_1 = 27;
    public static final int PROPHET_FLAG_2 = 28;
    public static final int PROPHET_FLAG_3 = 29;
    public static final int PROPHET_FLAG_4 = 30;
    public static final int PROPHET_FLAG_5 = 31;
    
    Image img27 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char27.gif");
    Image img28 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char28.gif");
    Image img29 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char29.gif");
    Image img30 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char30.gif");
    Image img31 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char31.gif");
    
    int level;
    Point location=new Point();//default starting location
    float attack;
    int attack_speed;
    double expPoints;
    int range;
    int character_flag;
    
    public Prophet(int x, int y){
    location.x=x;
    location.y=y;
    level = 1;
    attack = (float) 1.5;
    attack_speed = 1;
    expPoints = 0;
    range = 6;
    character_flag = PROPHET_FLAG_1; //ranges from 27 to 31 depending on range

    }

    public void gainExperience()
    {
    	if(level<5)
    		expPoints += .1;
        if(expPoints >= 1 && level<=5)
        {
            increaseLevel();
            expPoints = 0;
        }
        System.out.println(expPoints);
    }

    public void increaseLevel(){
    	System.out.println("prophet level up!");
        increaseAttack();
        increaseAttackSpeed();
        level++;
        //character_flag++;
    }

    public void increaseAttack(){
        attack+=attack*attack;
    }
    
    public void increaseAttackSpeed() {
         attack_speed = attack_speed * 2;
    }
    public void dealDamage(Minion m) {
         m.health -= attack; 
    }
    public void EasterEgg() {
        
    }

	@Override
	public void drawUnit(Graphics g) {
		// TODO Auto-generated method stub
		switch(character_flag){
			case PROPHET_FLAG_1:
				g.drawImage(img27, location.x, location.y, null);
				break;
			case PROPHET_FLAG_2:
				g.drawImage(img28, location.x, location.y, null);
				break;
			case PROPHET_FLAG_3:
				g.drawImage(img29, location.x, location.y, null);
				break;
			case PROPHET_FLAG_4:
				g.drawImage(img30, location.x, location.y, null);
				break;
			case PROPHET_FLAG_5:
				g.drawImage(img31, location.x, location.y, null);
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

    @Override
    public String getJob() {
        return "Prophet";
    }

}
