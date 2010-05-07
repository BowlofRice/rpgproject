package example;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class MapOne {
	public Vector<Minion> enemies=new Vector<Minion>();
	public Vector<Boss> bossSpawns=new Vector<Boss>();
	public Vector<Square> squares=new Vector<Square>();
	public Vector<TroyCastle> castles=new Vector<TroyCastle>();
	public TroyCastle troy=new TroyCastle(6,18);
	public int HP=troy.health;
	public JTextArea troyHP=new JTextArea(HP+"/100");
	int k=0;//enemy counter
	int h=0;//boss counter
	boolean isitDead=false;
	boolean gameOver=false;
	public int[][] MapOne;
    public int[][] mapTraversal;
	private MouseTracer mt;
	private CharSelection cs;

    
    public static final int ARCHER_FLAG_1 = 2;
    public static final int ARCHER_FLAG_2 = 3;
    public static final int ARCHER_FLAG_3 = 4;
    public static final int ARCHER_FLAG_4 = 5;
    public static final int ARCHER_FLAG_5 = 6;
   
    public static final int BLUECASTER_FLAG_1 = 7;
    public static final int BLUECASTER_FLAG_2 = 8;
    public static final int BLUECASTER_FLAG_3 = 9;
    public static final int BLUECASTER_FLAG_4 = 10;
    public static final int BLUECASTER_FLAG_5 = 11;

    public static final int GREENCASTER_FLAG_1 = 12;
    public static final int GREENCASTER_FLAG_2 = 13;
    public static final int GREENCASTER_FLAG_3 = 14;
    public static final int GREENCASTER_FLAG_4 = 15;
    public static final int GREENCASTER_FLAG_5 = 16;

    public static final int REDCASTER_FLAG_1 = 17;
    public static final int REDCASTER_FLAG_2 = 18;
    public static final int REDCASTER_FLAG_3 = 19;
    public static final int REDCASTER_FLAG_4 = 20;
    public static final int REDCASTER_FLAG_5 = 21;

    public static final int FIGHTER_FLAG_1 = 22;
    public static final int FIGHTER_FLAG_2 = 23;
    public static final int FIGHTER_FLAG_3 = 24;
    public static final int FIGHTER_FLAG_4 = 25;
    public static final int FIGHTER_FLAG_5 = 26;

    public static final int PROPHET_FLAG_1 = 27;
    public static final int PROPHET_FLAG_2 = 28;
    public static final int PROPHET_FLAG_3 = 29;
    public static final int PROPHET_FLAG_4 = 30;
    public static final int PROPHET_FLAG_5 = 31;

    public MapOne(CharSelection cs){
    	this.cs=cs;
    	castles.add(troy);
    	//A lengthy predefined map to use
    	//0 -- Sand
    	//1 -- Path
    	//2 -- Different Kind of Sand / Grass
    	//3 -- Castle Walls
        MapOne = new int[][] {
        {0 ,99,0 ,0 ,0 ,0 ,33,35,0 ,5 ,17,29,31,2 ,2 ,2 ,2 ,2 ,2 ,2 },
        {0 ,0 ,0 ,33,35,0 ,34,36,0 ,5 ,16,30,32,2 ,29,31,99,2 ,2 ,2 },
        {0 ,0 ,0 ,34,36,0 ,0 ,0 ,0 ,5 ,15,2 ,2 ,2 ,30,32,2 ,2 ,2 ,2 },
        {33,35,0 ,99,0 ,0 ,0 ,0 ,0 ,22,37,22,2 ,2 ,2 ,2 ,2 ,2 ,29,31},
        {34,36,0 ,0 ,0 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,2 ,30,32},
        {0 ,0 ,99,0 ,0 ,1 ,0 ,0 ,0 ,22,38,22,2 ,2 ,2 ,2 ,1 ,2 ,2 ,2 },
        {0 ,0 ,33,35,0 ,1 ,0 ,0 ,0 ,5 ,17,51,57,64,2 ,2 ,1 ,2 ,4 ,3 },
        {0 ,0 ,34,36,0 ,1 ,0 ,0 ,0 ,5 ,16,2 ,58,65,71,2 ,1 ,1 ,1 ,1 },
        {0 ,0 ,0 ,0 ,0 ,1 ,0 ,0 ,0 ,5 ,15,53,59,66,72,2 ,1 ,2 ,4 ,3 },
        {1 ,1 ,1 ,1 ,1 ,1 ,0 ,0 ,0 ,5 ,16,54,60,67,73,2 ,1 ,2 ,2 ,2 },
        {0 ,0 ,0 ,0 ,0 ,1 ,0 ,0 ,0 ,5 ,15,55,61,68,74,2 ,1 ,2 ,2 ,2 },
        {0 ,33,35,0 ,0 ,1 ,0 ,0 ,0 ,5 ,17,2 ,62,69,2 ,2 ,1 ,2 ,2 ,2 },
        {0 ,34,36,0 ,0 ,1 ,0 ,0 ,0 ,5 ,12,11,2 ,2 ,2 ,2 ,1 ,2 ,2 ,2 },
        {0 ,0 ,0 ,99,0 ,1 ,0 ,0 ,0 ,5 ,99,12,11,2 ,2 ,2 ,1 ,2 ,99,2 },
        {0 ,0 ,0 ,33,35,1 ,0 ,0 ,0 ,5 ,2 ,22,37,22,2 ,2 ,1 ,2 ,2 ,2 },
        {0 ,0 ,0 ,34,36,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,2 ,2 ,2 },
        {0 ,0 ,99,0 ,0 ,0 ,0 ,0 ,0 ,5 ,2 ,22,38,22,2 ,2 ,2 ,2 ,2 ,2 },
        {0 ,33,35,0 ,0 ,0 ,0 ,0 ,0 ,5 ,2 ,2 ,17,29,31,2 ,2 ,99,2 ,2 },
        {0 ,34,36,0 ,0 ,99,33,35,0 ,5 ,29,31,16,30,32,2 ,29,31,2 ,2 },
        {0 ,0 ,0 ,0 ,0 ,0 ,34,36,0 ,5 ,30,32,15,2 ,2 ,2 ,30,32,2 ,2 } };

        mapTraversal = new int[][] {
        		{   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0},        
        		{   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0},        
        		{   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0},       
        		{   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0},      
        		{   0,   0,   0,   0,   0,2200,2300,2400,2500,2600,2700,2800,2900,3000,3100,3200,3300,   0,   0,   0},     
        		{   0,   0,   0,   0,   0,2100,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,3400,   0,   0,   0},     
        		{   0,   0,   0,   0,   0,2000,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,3500,   0,   1,   1},   
        		{   0,   0,   0,   0,   0,1900,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,4000,4100,4200,5000},   
        		{   0,   0,   0,   0,   0,1800,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,3900,   0,   1,   1},     
        		{1000,1100,1200,1300,1400,1500,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,3800,   0,   0,   0},    
        		{   0,   0,   0,   0,   0,1600,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,3700,   0,   0,   0},  
        		{   0,   0,   0,   0,   0,1700,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,3600,   0,   0,   0}, 
        		{   0,   0,   0,   0,   0,1800,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,3500,   0,   0,   0},  
        		{   0,   0,   0,   0,   0,1900,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,3400,   0,   0,   0},   
        		{   0,   0,   0,   0,   0,2000,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,3300,   0,   0,   0},   
        		{   0,   0,   0,   0,   0,2100,2200,2300,2400,2500,2600,2700,2800,2900,3000,3100,3200,   0,   0,   0},  
        		{   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0},    
        		{   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0},       
        		{   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0},        
        		{   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0} };
    }
    void moveEnemy(Graphics g, int i, int j){
    	Minion baddie=new Minion();
        enemies.add(baddie);
        int c = i;
        int d = j;
        Image img1 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/newpath1.png");
        Image img0 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char1.gif");
        double randomnum = 0;
        int rand = 0;
        while (mapTraversal[i][j] > 0 && j < 19) {
            randomnum = Math.random();
            randomnum = randomnum * 6;
            rand = (int) randomnum;
            if(j==0){
            	g.drawImage(img1, i * mapTraversal.length, j * mapTraversal[0].length, null);
                g.drawImage(img0, i * mapTraversal.length, (j + 1) * mapTraversal[0].length, null);
                enemies.elementAt(k).setLocation(i, j);
                for(int b=0;b<mt.allies.size();b++){
                	if(mt.allies.elementAt(b).withinRange(enemies.elementAt(k))){
                		mt.allies.elementAt(b).dealDamage(enemies.elementAt(k));
                		if(enemies.elementAt(k).health<=0){
                			isitDead=true;
                			mt.allies.elementAt(b).gainExperience();
                		}
                	}
                }
                if(isitDead){
                	isitDead=false;           
                	int currFunds=Integer.parseInt(cs.funds.getText());
                	currFunds+=500;
                	cs.funds.setText(""+currFunds);
                	g.drawImage(img1, i * mapTraversal.length, (j + 1) * mapTraversal[0].length, null);
                	break;
                }
                for(int a=0;a<castles.size();a++){
                	if(enemies.elementAt(k).withinRange(castles.elementAt(a))){
                		enemies.elementAt(k).dealDamage(castles.elementAt(a));
                		troyHP.setText(castles.elementAt(a).health+"/100");
                		HP=castles.elementAt(a).health;
                		if(HP<=0)
                			gameOver=true;
                	}
                }
                if(gameOver){
        			JOptionPane.showMessageDialog(cs.charHolder, "FAILURE");
        			System.exit(0);
                }
                c = i;
                d = j;
                j += 1;
            }
            if(j!=0){
            	if(mapTraversal[i][j]<=mapTraversal[i][j+1] && (mapTraversal[i][j]>= mapTraversal[i+1][j] && mapTraversal[i][j]>= mapTraversal[i-1][j] && mapTraversal[i][j]>= mapTraversal[i][j-1])){
            		g.drawImage(img1, i * mapTraversal.length, j * mapTraversal[0].length, null);
            		g.drawImage(img0, i * mapTraversal.length, (j + 1) * mapTraversal[0].length, null);
            		enemies.elementAt(k).setLocation(i, j);
            		for(int b=0;b<mt.allies.size();b++){
                    	if(mt.allies.elementAt(b).withinRange(enemies.elementAt(k))){
                    		mt.allies.elementAt(b).dealDamage(enemies.elementAt(k));
                    		if(enemies.elementAt(k).health<=0){
                    			isitDead=true;
                    			mt.allies.elementAt(b).gainExperience();
                    		}
                    	}
                    }
            		if(isitDead){
                    	isitDead=false;
                    	int currFunds=Integer.parseInt(cs.funds.getText());
                    	currFunds+=500;
                    	cs.funds.setText(""+currFunds);
                    	g.drawImage(img1, i * mapTraversal.length, (j + 1) * mapTraversal[0].length, null);
                    	break;
                    }
            		for(int a=0;a<castles.size();a++){
                    	if(enemies.elementAt(k).withinRange(castles.elementAt(a))){
                    		enemies.elementAt(k).dealDamage(castles.elementAt(a));
                    		troyHP.setText(castles.elementAt(a).health+"/100");
                    		HP=castles.elementAt(a).health;
                    		if(HP<=0)
                    			gameOver=true;
                    	}
                    }
            		if(gameOver){
            			JOptionPane.showMessageDialog(cs.charHolder, "FAILURE");
            			System.exit(0);
                    }
            		c = i;
            		d = j;
            		j += 1;
            	}
            	else if (mapTraversal[i][j]<=mapTraversal[i][j-1] && (mapTraversal[i][j]>= mapTraversal[i+1][j] && mapTraversal[i][j]>= mapTraversal[i-1][j] && mapTraversal[i][j]>= mapTraversal[i][j+1])){
            		g.drawImage(img1, i * mapTraversal.length, j * mapTraversal[0].length, null);
            		g.drawImage(img0, i * mapTraversal.length, (j - 1) * mapTraversal[0].length, null);
            		enemies.elementAt(k).setLocation(i, j);
            		for(int b=0;b<mt.allies.size();b++){
                    	if(mt.allies.elementAt(b).withinRange(enemies.elementAt(k))){
                    		mt.allies.elementAt(b).dealDamage(enemies.elementAt(k));
                    		if(enemies.elementAt(k).health<=0){
                    			isitDead=true;
                    			mt.allies.elementAt(b).gainExperience();
                    		}
                    	}
                    }
            		if(isitDead){
                    	isitDead=false;
                    	int currFunds=Integer.parseInt(cs.funds.getText());
                    	currFunds+=500;
                    	cs.funds.setText(""+currFunds);
                    	g.drawImage(img1, i * mapTraversal.length, (j - 1) * mapTraversal[0].length, null);
                    	break;
                    }
            		for(int a=0;a<castles.size();a++){
                    	if(enemies.elementAt(k).withinRange(castles.elementAt(a))){
                    		enemies.elementAt(k).dealDamage(castles.elementAt(a));
                    		troyHP.setText(castles.elementAt(a).health+"/100");
                    		HP=castles.elementAt(a).health;
                    		if(HP<=0)
                    			gameOver=true;
                    	}
                    }
            		if(gameOver){
            			JOptionPane.showMessageDialog(cs.charHolder, "FAILURE");
            			System.exit(0);
                    }
            		c = i;
            		d = j;
            		j -= 1;
            	}
            	else if(mapTraversal[i][j]<=mapTraversal[i+1][j] && (mapTraversal[i][j]>= mapTraversal[i][j-1] && mapTraversal[i][j]>= mapTraversal[i-1][j] && mapTraversal[i][j]>= mapTraversal[i][j+1])){
            		g.drawImage(img1, i * mapTraversal.length, j * mapTraversal[0].length, null);
            		g.drawImage(img0, (i + 1) * mapTraversal.length, j * mapTraversal[0].length, null);
            		enemies.elementAt(k).setLocation(i, j);
            		for(int b=0;b<mt.allies.size();b++){
                    	if(mt.allies.elementAt(b).withinRange(enemies.elementAt(k))){
                    		mt.allies.elementAt(b).dealDamage(enemies.elementAt(k));
                    		if(enemies.elementAt(k).health<=0){
                    			isitDead=true;
                    			mt.allies.elementAt(b).gainExperience();
                    		}
                    	}
                    }
            		if(isitDead){
                    	isitDead=false;
                    	int currFunds=Integer.parseInt(cs.funds.getText());
                    	currFunds+=500;
                    	cs.funds.setText(""+currFunds);
                    	g.drawImage(img1, (i + 1) * mapTraversal.length, j * mapTraversal[0].length, null);
                    	break;
                    }
            		for(int a=0;a<castles.size();a++){
                    	if(enemies.elementAt(k).withinRange(castles.elementAt(a))){
                    		enemies.elementAt(k).dealDamage(castles.elementAt(a));
                    		troyHP.setText(castles.elementAt(a).health+"/100");
                    		HP=castles.elementAt(a).health;
                    		if(HP<=0)
                    			gameOver=true;
                    	}
                    }
            		if(gameOver){
            			JOptionPane.showMessageDialog(cs.charHolder, "FAILURE");
            			System.exit(0);
                    }
            		c = i;
            		d = j;
            		i += 1;
            	}
            	else if(mapTraversal[i][j]<=mapTraversal[i-1][j] && (mapTraversal[i][j]>= mapTraversal[i][j-1] && mapTraversal[i][j]>= mapTraversal[i+1][j] && mapTraversal[i][j]>= mapTraversal[i][j+1])){
            		g.drawImage(img1, i * mapTraversal.length, j * mapTraversal[0].length, null);
            		g.drawImage(img0, (i - 1) * mapTraversal.length, j * mapTraversal[0].length, null);
            		enemies.elementAt(k).setLocation(i, j);
            		for(int b=0;b<mt.allies.size();b++){
                    	if(mt.allies.elementAt(b).withinRange(enemies.elementAt(k))){
                    		mt.allies.elementAt(b).dealDamage(enemies.elementAt(k));
                    		if(enemies.elementAt(k).health<=0){
                    			isitDead=true;
                    			mt.allies.elementAt(b).gainExperience();
                    		}
                    	}
                    }
            		if(isitDead){
                    	isitDead=false;
                    	int currFunds=Integer.parseInt(cs.funds.getText());
                    	currFunds+=500;
                    	cs.funds.setText(""+currFunds);
                    	g.drawImage(img1, (i - 1) * mapTraversal.length, j * mapTraversal[0].length, null);
                    	break;
                    }
            		for(int a=0;a<castles.size();a++){
                    	if(enemies.elementAt(k).withinRange(castles.elementAt(a))){
                    		enemies.elementAt(k).dealDamage(castles.elementAt(a));
                    		troyHP.setText(castles.elementAt(a).health+"/100");
                    		HP=castles.elementAt(a).health;
                    		if(HP<=0)
                    			gameOver=true;
                    	}
                    }
            		if(gameOver){
            			JOptionPane.showMessageDialog(cs.charHolder, "FAILURE");
            			System.exit(0);
                    }
            		c = i;
            		d = j;
            		i -= 1;
            	}
            	if(j<19){
            		if (rand < 2 && mapTraversal[i][j] <= mapTraversal[i][j + 1] && (j+1) != d) {
            			g.drawImage(img1, i * mapTraversal.length, j * mapTraversal[0].length, null);
            			g.drawImage(img0, i * mapTraversal.length, (j + 1) * mapTraversal[0].length, null);
            			enemies.elementAt(k).setLocation(i, j);
            			for(int b=0;b<mt.allies.size();b++){
            	        	if(mt.allies.elementAt(b).withinRange(enemies.elementAt(k))){
            	        		mt.allies.elementAt(b).dealDamage(enemies.elementAt(k));
            	        		if(enemies.elementAt(k).health<=0){
            	        			isitDead=true;
            	        			mt.allies.elementAt(b).gainExperience();
            	        		}
            	        	}
            	        }
            			if(isitDead){
                        	isitDead=false;
                        	int currFunds=Integer.parseInt(cs.funds.getText());
                        	currFunds+=500;
                        	cs.funds.setText(""+currFunds);
                        	g.drawImage(img1, i * mapTraversal.length, (j + 1) * mapTraversal[0].length, null);
                        	break;
                        }
            			for(int a=0;a<castles.size();a++){
            	        	if(enemies.elementAt(k).withinRange(castles.elementAt(a))){
            	        		enemies.elementAt(k).dealDamage(castles.elementAt(a));
            	        		troyHP.setText(castles.elementAt(a).health+"/100");
            	        		HP=castles.elementAt(a).health;
            	        		if(HP<=0)
            	        			gameOver=true;
            	        	}
            	        }
            			if(gameOver){
                			JOptionPane.showMessageDialog(cs.charHolder, "FAILURE");
                			System.exit(0);
            	        }
            			c = i;
            			d = j;
            			j += 1;
            		}else if(2 <= rand && rand <= 3 && mapTraversal[i][j] <= mapTraversal[i][j - 1] && (j-1)!=d) {
            			g.drawImage(img1, i * mapTraversal.length, j * mapTraversal[0].length, null);
            			g.drawImage(img0, i * mapTraversal.length, (j - 1) * mapTraversal[0].length, null);
            			enemies.elementAt(k).setLocation(i, j);
            			for(int b=0;b<mt.allies.size();b++){
            	        	if(mt.allies.elementAt(b).withinRange(enemies.elementAt(k))){
            	        		mt.allies.elementAt(b).dealDamage(enemies.elementAt(k));
            	        		if(enemies.elementAt(k).health<=0){
            	        			isitDead=true;
            	        			mt.allies.elementAt(b).gainExperience();
            	        		}
            	        	}
            	        }
            			if(isitDead){
                        	isitDead=false;
                        	int currFunds=Integer.parseInt(cs.funds.getText());
                        	currFunds+=500;
                        	cs.funds.setText(""+currFunds);
                        	g.drawImage(img1, i * mapTraversal.length, (j - 1) * mapTraversal[0].length, null);
                        	break;
                        }
            			for(int a=0;a<castles.size();a++){
            	        	if(enemies.elementAt(k).withinRange(castles.elementAt(a))){
            	        		enemies.elementAt(k).dealDamage(castles.elementAt(a));
            	        		troyHP.setText(castles.elementAt(a).health+"/100");
            	        		HP=castles.elementAt(a).health;
            	        		if(HP<=0)
            	        			gameOver=true;
            	        	}
            	        }
            			if(gameOver){
                			JOptionPane.showMessageDialog(cs.charHolder, "FAILURE");
                			System.exit(0);
            	        }
            			c = i;
            			d = j;
            			j -= 1;
            		}else if (3 < rand && rand <= 4 && mapTraversal[i][j] <= mapTraversal[i + 1][j] && (i+1)!=c) {
            			g.drawImage(img1, i * mapTraversal.length, j * mapTraversal[0].length, null);
            			g.drawImage(img0, (i + 1) * mapTraversal.length, j * mapTraversal[0].length, null);
            			enemies.elementAt(k).setLocation(i, j);
            			for(int b=0;b<mt.allies.size();b++){
            	        	if(mt.allies.elementAt(b).withinRange(enemies.elementAt(k))){
            	        		mt.allies.elementAt(b).dealDamage(enemies.elementAt(k));
            	        		if(enemies.elementAt(k).health<=0){
            	        			isitDead=true;
            	        			mt.allies.elementAt(b).gainExperience();
            	        		}
            	        	}
            	        }
            			if(isitDead){
                        	isitDead=false;
                        	int currFunds=Integer.parseInt(cs.funds.getText());
                        	currFunds+=500;
                        	cs.funds.setText(""+currFunds);
                        	g.drawImage(img1, (i + 1) * mapTraversal.length, j * mapTraversal[0].length, null);
                        	break;
                        }
            			for(int a=0;a<castles.size();a++){
            	        	if(enemies.elementAt(k).withinRange(castles.elementAt(a))){
            	        		enemies.elementAt(k).dealDamage(castles.elementAt(a));
            	        		troyHP.setText(castles.elementAt(a).health+"/100");
            	        		HP=castles.elementAt(a).health;
            	        		if(HP<=0)
            	        			gameOver=true;
            	        	}
            	        }
            			if(gameOver){
                			JOptionPane.showMessageDialog(cs.charHolder, "FAILURE");
                			System.exit(0);
            	        }
            			c = i;
            			d = j;
            			i += 1;
            		}else if (4 < rand && rand <= 6 && mapTraversal[i][j] <= mapTraversal[i - 1][j] && (i-1)!=c) {
            			g.drawImage(img1, i * mapTraversal.length, j * mapTraversal[0].length, null);
            			g.drawImage(img0, (i - 1) * mapTraversal.length, j * mapTraversal[0].length, null);
            			enemies.elementAt(k).setLocation(i, j);
            			for(int b=0;b<mt.allies.size();b++){
            	        	if(mt.allies.elementAt(b).withinRange(enemies.elementAt(k))){
            	        		mt.allies.elementAt(b).dealDamage(enemies.elementAt(k));
            	        		if(enemies.elementAt(k).health<=0){
            	        			isitDead=true;
            	        			mt.allies.elementAt(b).gainExperience();
            	        		}
            	        	}
            	        }
            			if(isitDead){
                        	isitDead=false;
                        	int currFunds=Integer.parseInt(cs.funds.getText());
                        	currFunds+=500;
                        	cs.funds.setText(""+currFunds);
                        	g.drawImage(img1, (i - 1) * mapTraversal.length, j * mapTraversal[0].length, null);
                        	break;
                        }
            			for(int a=0;a<castles.size();a++){
            	        	if(enemies.elementAt(k).withinRange(castles.elementAt(a))){
            	        		enemies.elementAt(k).dealDamage(castles.elementAt(a));
            	        		troyHP.setText(castles.elementAt(a).health+"/100");
            	        		HP=castles.elementAt(a).health;
            	        		if(HP<=0)
            	        			gameOver=true;
            	        	}
            	        }
            			if(gameOver){
                			JOptionPane.showMessageDialog(cs.charHolder, "FAILURE");
                			System.exit(0);
            	        }
            			c = i;
            			d = j;
            			i -= 1;
            		}else{}
            	}
            }
            try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        k++;
    }
    void theycallhimBossFight(Graphics g, int i, int j){
    	Boss boss=new Boss();
        bossSpawns.add(boss);
        int c = i;
        int d = j;
        Image img1 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/newpath1.png");
        Image img0 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/boss.png");
        double randomnum = 0;
        int rand = 0;
        while (mapTraversal[i][j] > 0 && j < 19) {
            randomnum = Math.random();
            randomnum = randomnum * 6;
            rand = (int) randomnum;
            if(j==0){
            	g.drawImage(img1, i * mapTraversal.length, j * mapTraversal[0].length, null);
                g.drawImage(img0, i * mapTraversal.length, (j + 1) * mapTraversal[0].length, null);
                bossSpawns.elementAt(h).setLocation(i, j);
                for(int b=0;b<mt.allies.size();b++){
                	if(mt.allies.elementAt(b).withinRange(bossSpawns.elementAt(h))){
                		mt.allies.elementAt(b).dealDamageB(bossSpawns.elementAt(h));
                		if(bossSpawns.elementAt(h).health<=0)
                			isitDead=true;
                	}
                }
                if(isitDead){
                	isitDead=false;
                	int currFunds=Integer.parseInt(cs.funds.getText());
                	currFunds+=500;
                	cs.funds.setText(""+currFunds);
                	g.drawImage(img1, i * mapTraversal.length, (j + 1) * mapTraversal[0].length, null);
                	break;
                }
                for(int a=0;a<castles.size();a++){
                	if(bossSpawns.elementAt(h).withinRange(castles.elementAt(a))){
                		bossSpawns.elementAt(h).dealDamage(castles.elementAt(a));
                		troyHP.setText(castles.elementAt(a).health+"/100");
                		HP=castles.elementAt(a).health;
                		if(HP<=0)
                			gameOver=true;
                	}
                }
                if(gameOver){
        			JOptionPane.showMessageDialog(cs.charHolder, "FAILURE");
        			System.exit(0);
                }
                c = i;
                d = j;
                j += 1;
            }
            if(j!=0){
            	if(mapTraversal[i][j]<=mapTraversal[i][j+1] && (mapTraversal[i][j]>= mapTraversal[i+1][j] && mapTraversal[i][j]>= mapTraversal[i-1][j] && mapTraversal[i][j]>= mapTraversal[i][j-1])){
            		g.drawImage(img1, i * mapTraversal.length, j * mapTraversal[0].length, null);
            		g.drawImage(img0, i * mapTraversal.length, (j + 1) * mapTraversal[0].length, null);
            		bossSpawns.elementAt(h).setLocation(i, j);
            		for(int b=0;b<mt.allies.size();b++){
                    	if(mt.allies.elementAt(b).withinRange(bossSpawns.elementAt(h))){
                    		mt.allies.elementAt(b).dealDamageB(bossSpawns.elementAt(h));
                    		if(bossSpawns.elementAt(h).health<=0){
                    			isitDead=true;
                    			mt.allies.elementAt(b).gainExperience();
                    		}
                    	}
                    }
            		if(isitDead){
                    	isitDead=false;
                    	int currFunds=Integer.parseInt(cs.funds.getText());
                    	currFunds+=500;
                    	cs.funds.setText(""+currFunds);
                    	g.drawImage(img1, i * mapTraversal.length, (j + 1) * mapTraversal[0].length, null);
                    	break;
                    }
            		for(int a=0;a<castles.size();a++){
                    	if(bossSpawns.elementAt(h).withinRange(castles.elementAt(a))){
                    		bossSpawns.elementAt(h).dealDamage(castles.elementAt(a));
                    		troyHP.setText(castles.elementAt(a).health+"/100");
                    		HP=castles.elementAt(a).health;
                    		if(HP<=0)
                    			gameOver=true;
                    	}
                    }
            		if(gameOver){
            			JOptionPane.showMessageDialog(cs.charHolder, "FAILURE");
            			System.exit(0);
                    }
            		c = i;
            		d = j;
            		j += 1;
            	}
            	else if (mapTraversal[i][j]<=mapTraversal[i][j-1] && (mapTraversal[i][j]>= mapTraversal[i+1][j] && mapTraversal[i][j]>= mapTraversal[i-1][j] && mapTraversal[i][j]>= mapTraversal[i][j+1])){
            		g.drawImage(img1, i * mapTraversal.length, j * mapTraversal[0].length, null);
            		g.drawImage(img0, i * mapTraversal.length, (j - 1) * mapTraversal[0].length, null);
            		bossSpawns.elementAt(h).setLocation(i, j);
            		for(int b=0;b<mt.allies.size();b++){
                    	if(mt.allies.elementAt(b).withinRange(bossSpawns.elementAt(h))){
                    		mt.allies.elementAt(b).dealDamageB(bossSpawns.elementAt(h));
                    		if(bossSpawns.elementAt(h).health<=0){
                    			isitDead=true;
                    			mt.allies.elementAt(b).gainExperience();
                    		}
                    	}
                    }
            		if(isitDead){
                    	isitDead=false;
                    	int currFunds=Integer.parseInt(cs.funds.getText());
                    	currFunds+=500;
                    	cs.funds.setText(""+currFunds);
                    	g.drawImage(img1, i * mapTraversal.length, (j - 1) * mapTraversal[0].length, null);
                    	break;
                    }
            		for(int a=0;a<castles.size();a++){
                    	if(bossSpawns.elementAt(h).withinRange(castles.elementAt(a))){
                    		bossSpawns.elementAt(h).dealDamage(castles.elementAt(a));
                    		troyHP.setText(castles.elementAt(a).health+"/100");
                    		HP=castles.elementAt(a).health;
                    		if(HP<=0)
                    			gameOver=true;
                    	}
                    }
            		if(gameOver){
            			JOptionPane.showMessageDialog(cs.charHolder, "FAILURE");
            			System.exit(0);
                    }
            		c = i;
            		d = j;
            		j -= 1;
            	}
            	else if(mapTraversal[i][j]<=mapTraversal[i+1][j] && (mapTraversal[i][j]>= mapTraversal[i][j-1] && mapTraversal[i][j]>= mapTraversal[i-1][j] && mapTraversal[i][j]>= mapTraversal[i][j+1])){
            		g.drawImage(img1, i * mapTraversal.length, j * mapTraversal[0].length, null);
            		g.drawImage(img0, (i + 1) * mapTraversal.length, j * mapTraversal[0].length, null);
            		bossSpawns.elementAt(h).setLocation(i, j);
            		for(int b=0;b<mt.allies.size();b++){
                    	if(mt.allies.elementAt(b).withinRange(bossSpawns.elementAt(h))){
                    		mt.allies.elementAt(b).dealDamageB(bossSpawns.elementAt(h));
                    		if(bossSpawns.elementAt(h).health<=0){
                    			isitDead=true;
                    			mt.allies.elementAt(b).gainExperience();
                    		}
                    	}
                    }
            		if(isitDead){
                    	isitDead=false;
                    	int currFunds=Integer.parseInt(cs.funds.getText());
                    	currFunds+=500;
                    	cs.funds.setText(""+currFunds);
                    	g.drawImage(img1, (i + 1) * mapTraversal.length, j * mapTraversal[0].length, null);
                    	break;
                    }
            		for(int a=0;a<castles.size();a++){
                    	if(bossSpawns.elementAt(h).withinRange(castles.elementAt(a))){
                    		bossSpawns.elementAt(h).dealDamage(castles.elementAt(a));
                    		troyHP.setText(castles.elementAt(a).health+"/100");
                    		HP=castles.elementAt(a).health;
                    		if(HP<=0)
                    			gameOver=true;
                    	}
                    }
            		if(gameOver){
            			JOptionPane.showMessageDialog(cs.charHolder, "FAILURE");
            			System.exit(0);
                    }
            		c = i;
            		d = j;
            		i += 1;
            	}
            	else if(mapTraversal[i][j]<=mapTraversal[i-1][j] && (mapTraversal[i][j]>= mapTraversal[i][j-1] && mapTraversal[i][j]>= mapTraversal[i+1][j] && mapTraversal[i][j]>= mapTraversal[i][j+1])){
            		g.drawImage(img1, i * mapTraversal.length, j * mapTraversal[0].length, null);
            		g.drawImage(img0, (i - 1) * mapTraversal.length, j * mapTraversal[0].length, null);
            		bossSpawns.elementAt(h).setLocation(i, j);
            		for(int b=0;b<mt.allies.size();b++){
                    	if(mt.allies.elementAt(b).withinRange(bossSpawns.elementAt(h))){
                    		mt.allies.elementAt(b).dealDamageB(bossSpawns.elementAt(h));
                    		if(bossSpawns.elementAt(h).health<=0){
                    			isitDead=true;
                    			mt.allies.elementAt(b).gainExperience();
                    		}
                    	}
                    }
            		if(isitDead){
                    	isitDead=false;
                    	int currFunds=Integer.parseInt(cs.funds.getText());
                    	currFunds+=500;
                    	cs.funds.setText(""+currFunds);
                    	g.drawImage(img1, (i - 1) * mapTraversal.length, j * mapTraversal[0].length, null);
                    	break;
                    }
            		for(int a=0;a<castles.size();a++){
                    	if(bossSpawns.elementAt(h).withinRange(castles.elementAt(a))){
                    		bossSpawns.elementAt(h).dealDamage(castles.elementAt(a));
                    		troyHP.setText(castles.elementAt(a).health+"/100");
                    		HP=castles.elementAt(a).health;
                    		if(HP<=0)
                    			gameOver=true;
                    	}
                    }
            		if(gameOver){
            			JOptionPane.showMessageDialog(cs.charHolder, "FAILURE");
            			System.exit(0);
                    }
            		c = i;
            		d = j;
            		i -= 1;
            	}
            	if(j<19){
            		if (rand < 2 && mapTraversal[i][j] <= mapTraversal[i][j + 1] && (j+1) != d) {
            			g.drawImage(img1, i * mapTraversal.length, j * mapTraversal[0].length, null);
            			g.drawImage(img0, i * mapTraversal.length, (j + 1) * mapTraversal[0].length, null);
            			bossSpawns.elementAt(h).setLocation(i, j);
            			for(int b=0;b<mt.allies.size();b++){
            	        	if(mt.allies.elementAt(b).withinRange(bossSpawns.elementAt(h))){
            	        		mt.allies.elementAt(b).dealDamageB(bossSpawns.elementAt(h));
            	        		if(bossSpawns.elementAt(h).health<=0){
            	        			isitDead=true;
            	        			mt.allies.elementAt(b).gainExperience();
            	        		}
            	        	}
            	        }
            			if(isitDead){
                        	isitDead=false;
                        	int currFunds=Integer.parseInt(cs.funds.getText());
                        	currFunds+=500;
                        	cs.funds.setText(""+currFunds);
                        	g.drawImage(img1, i * mapTraversal.length, (j + 1) * mapTraversal[0].length, null);
                        	break;
                        }
            			for(int a=0;a<castles.size();a++){
            	        	if(bossSpawns.elementAt(h).withinRange(castles.elementAt(a))){
            	        		bossSpawns.elementAt(h).dealDamage(castles.elementAt(a));
            	        		troyHP.setText(castles.elementAt(a).health+"/100");
            	        		HP=castles.elementAt(a).health;
            	        		if(HP<=0)
            	        			gameOver=true;
            	        	}
            	        }
            			if(gameOver){
                			JOptionPane.showMessageDialog(cs.charHolder, "FAILURE");
                			System.exit(0);
            	        }
            			c = i;
            			d = j;
            			j += 1;
            		}else if(2 <= rand && rand <= 3 && mapTraversal[i][j] <= mapTraversal[i][j - 1] && (j-1)!=d) {
            			g.drawImage(img1, i * mapTraversal.length, j * mapTraversal[0].length, null);
            			g.drawImage(img0, i * mapTraversal.length, (j - 1) * mapTraversal[0].length, null);
            			bossSpawns.elementAt(h).setLocation(i, j);
            			for(int b=0;b<mt.allies.size();b++){
            	        	if(mt.allies.elementAt(b).withinRange(bossSpawns.elementAt(h))){
            	        		mt.allies.elementAt(b).dealDamageB(bossSpawns.elementAt(h));
            	        		if(bossSpawns.elementAt(h).health<=0){
            	        			isitDead=true;
            	        			mt.allies.elementAt(b).gainExperience();
            	        		}
            	        	}
            	        }
            			if(isitDead){
                        	isitDead=false;
                        	int currFunds=Integer.parseInt(cs.funds.getText());
                        	currFunds+=500;
                        	cs.funds.setText(""+currFunds);
                        	g.drawImage(img1, i * mapTraversal.length, (j - 1) * mapTraversal[0].length, null);
                        	break;
                        }
            			for(int a=0;a<castles.size();a++){
            	        	if(bossSpawns.elementAt(h).withinRange(castles.elementAt(a))){
            	        		bossSpawns.elementAt(h).dealDamage(castles.elementAt(a));
            	        		troyHP.setText(castles.elementAt(a).health+"/100");
            	        		HP=castles.elementAt(a).health;
            	        		if(HP<=0)
            	        			gameOver=true;
            	        	}
            	        }
            			if(gameOver){
                			JOptionPane.showMessageDialog(cs.charHolder, "FAILURE");
                			System.exit(0);
            	        }
            			c = i;
            			d = j;
            			j -= 1;
            		}else if (3 < rand && rand <= 4 && mapTraversal[i][j] <= mapTraversal[i + 1][j] && (i+1)!=c) {
            			g.drawImage(img1, i * mapTraversal.length, j * mapTraversal[0].length, null);
            			g.drawImage(img0, (i + 1) * mapTraversal.length, j * mapTraversal[0].length, null);
            			bossSpawns.elementAt(h).setLocation(i, j);
            			for(int b=0;b<mt.allies.size();b++){
            	        	if(mt.allies.elementAt(b).withinRange(bossSpawns.elementAt(h))){
            	        		mt.allies.elementAt(b).dealDamageB(bossSpawns.elementAt(h));
            	        		if(bossSpawns.elementAt(h).health<=0){
            	        			isitDead=true;
            	        			mt.allies.elementAt(b).gainExperience();
            	        		}
            	        	}
            	        }
            			if(isitDead){
                        	isitDead=false;
                        	int currFunds=Integer.parseInt(cs.funds.getText());
                        	currFunds+=500;
                        	cs.funds.setText(""+currFunds);
                        	g.drawImage(img1, (i + 1) * mapTraversal.length, j * mapTraversal[0].length, null);
                        	break;
                        }
            			for(int a=0;a<castles.size();a++){
            	        	if(bossSpawns.elementAt(h).withinRange(castles.elementAt(a))){
            	        		bossSpawns.elementAt(h).dealDamage(castles.elementAt(a));
            	        		troyHP.setText(castles.elementAt(a).health+"/100");
            	        		HP=castles.elementAt(a).health;
            	        		if(HP<=0)
            	        			gameOver=true;
            	        	}
            	        }
            			if(gameOver){
                			JOptionPane.showMessageDialog(cs.charHolder, "FAILURE");
                			System.exit(0);
            	        }
            			c = i;
            			d = j;
            			i += 1;
            		}else if (4 < rand && rand <= 6 && mapTraversal[i][j] <= mapTraversal[i - 1][j] && (i-1)!=c) {
            			g.drawImage(img1, i * mapTraversal.length, j * mapTraversal[0].length, null);
            			g.drawImage(img0, (i - 1) * mapTraversal.length, j * mapTraversal[0].length, null);
            			bossSpawns.elementAt(h).setLocation(i, j);
            			for(int b=0;b<mt.allies.size();b++){
            	        	if(mt.allies.elementAt(b).withinRange(bossSpawns.elementAt(h))){
            	        		mt.allies.elementAt(b).dealDamageB(bossSpawns.elementAt(h));
            	        		if(bossSpawns.elementAt(h).health<=0){
            	        			isitDead=true;
            	        			mt.allies.elementAt(b).gainExperience();
            	        		}
            	        	}
            	        }
            			if(isitDead){
                        	isitDead=false;
                        	int currFunds=Integer.parseInt(cs.funds.getText());
                        	currFunds+=500;
                        	cs.funds.setText(""+currFunds);
                        	g.drawImage(img1, (i - 1) * mapTraversal.length, j * mapTraversal[0].length, null);
                        	break;
                        }
            			for(int a=0;a<castles.size();a++){
            	        	if(bossSpawns.elementAt(h).withinRange(castles.elementAt(a))){
            	        		bossSpawns.elementAt(h).dealDamage(castles.elementAt(a));
            	        		troyHP.setText(castles.elementAt(a).health+"/100");
            	        		HP=castles.elementAt(a).health;
            	        		if(HP<=0)
            	        			gameOver=true;
            	        	}
            	        }
            			if(gameOver){
                			JOptionPane.showMessageDialog(cs.charHolder, "FAILURE");
                			System.exit(0);
            	        }
            			c = i;
            			d = j;
            			i -= 1;
            		}else{}
            	}
            }
            try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch bloch
				e.printStackTrace();
			}
        }
        h++;
    }
    public void paint(Graphics g){   
        Image img0 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/newsand1.png");
        Image img1 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/newpath1.png");
        Image img2 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/newsand3.png");
        Image img3 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/castlelower.png");
        Image img4 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/castleupper.png");
        Image img5 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/newsand2.png");


         Image img51 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/apolloshrine1.png");
        Image img52 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/apolloshrine2.png");
        Image img53 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/apolloshrine3.png");
        Image img54 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/apolloshrine4.png");
        Image img55 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/apolloshrine5.png");
        Image img56 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/apolloshrin6.png");
        Image img57 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/apolloshrine7.png");
        Image img58 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/apolloshrine8.png");
        Image img59 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/apolloshrine9.png");
        Image img60 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/apolloshrine10.png");
        //not put in for yet
        Image img61 = Toolkit.getDefaultToolkit().getImage("..//rpgproject/src/example/tiles/apolloshrine11.png");
        Image img62 = Toolkit.getDefaultToolkit().getImage("..//rpgproject/src/example/tiles/apolloshrine12.png");
       // Image img13 = Toolkit.getDefaultToolkit().getImage("..//rpgproject/src/example/tiles/riverGorightC.png");
        Image img64 = Toolkit.getDefaultToolkit().getImage("..//rpgproject/src/example/tiles/apolloshrine13.png");

        Image img65 = Toolkit.getDefaultToolkit().getImage("..//rpgproject/src/example/tiles/apolloshrine14.png");
        Image img66 = Toolkit.getDefaultToolkit().getImage("..//rpgproject/src/example/tiles/apolloshrine15.png");
        Image img67 = Toolkit.getDefaultToolkit().getImage("..//rpgproject/src/example/tiles/apolloshrine16.png");

        Image img68 = Toolkit.getDefaultToolkit().getImage("..//rpgproject/src/example/tiles/apolloshrine17.png");
        Image img69 = Toolkit.getDefaultToolkit().getImage("..//rpgproject/src/example/tiles/apolloshrine18.png");
        Image img70 = Toolkit.getDefaultToolkit().getImage("..//rpgproject/src/example/tiles/apolloshrine19.png");
        Image img71 = Toolkit.getDefaultToolkit().getImage("..//rpgproject/src/example/tiles/apolloshrine20.png");


        Image img72 = Toolkit.getDefaultToolkit().getImage("..//rpgproject/src/example/tiles/apolloshrine21.png");

        //hut code good!!!
        Image img73 = Toolkit.getDefaultToolkit().getImage("..//rpgproject/src/example/tiles/apolloshrine22.png");
        Image img99 = Toolkit.getDefaultToolkit().getImage("..//rpgproject/src/example/tiles/littlehut.png");


        Image img74 = Toolkit.getDefaultToolkit().getImage("..//rpgproject/src/example/tiles/apolloshrine23.png");
        Image img75 = Toolkit.getDefaultToolkit().getImage("..//rpgproject/src/example/tiles/apolloshrine24.png");

          Image img29 = Toolkit.getDefaultToolkit().getImage("..//rpgproject/src/example/tiles/treesilly1.png");
        Image img30 = Toolkit.getDefaultToolkit().getImage("..//rpgproject/src/example/tiles/treesilly2.png");
        Image img31 = Toolkit.getDefaultToolkit().getImage("..//rpgproject/src/example/tiles/treesilly3.png");
        Image img32 = Toolkit.getDefaultToolkit().getImage("..//rpgproject/src/example/tiles/treesilly4.png");

        Image img33 = Toolkit.getDefaultToolkit().getImage("..//rpgproject/src/example/tiles/treesand1.png");
        Image img34 = Toolkit.getDefaultToolkit().getImage("..//rpgproject/src/example/tiles/treesand2.png");
        Image img35 = Toolkit.getDefaultToolkit().getImage("..//rpgproject/src/example/tiles/treesand3.png");
        Image img36 = Toolkit.getDefaultToolkit().getImage("..//rpgproject/src/example/tiles/treesand4.png");
        Image img22 = Toolkit.getDefaultToolkit().getImage("..//rpgproject/src/example/tiles/bridge.png");
        Image img15 = Toolkit.getDefaultToolkit().getImage("..//rpgproject/src/example/tiles/river1.png");
        Image img16 = Toolkit.getDefaultToolkit().getImage("..//rpgproject/src/example/tiles/river2.png");
        Image img17 = Toolkit.getDefaultToolkit().getImage("..//rpgproject/src/example/tiles/river3.png");
        Image img11 = Toolkit.getDefaultToolkit().getImage("..//rpgproject/src/example/tiles/rivergorightA.png");
        Image img12 = Toolkit.getDefaultToolkit().getImage("..//rpgproject/src/example/tiles/riverGorightB.png");
        Image img37 = Toolkit.getDefaultToolkit().getImage("..//rpgproject/src/example/tiles/bridgeleft.png");
        Image img38 = Toolkit.getDefaultToolkit().getImage("..//rpgproject/src/example/tiles/bridgeright.png");

        for(int i = 0; i < MapOne.length; i++) {	
        	for(int j = 0; j < MapOne[0].length; j++) {
        		if(MapOne[i][j] == 0) {
        			g.drawImage(img0, i*MapOne.length, j*MapOne[0].length, null);
    				Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		}else if(MapOne[i][j] == 29) {
        			g.drawImage(img29, i*MapOne.length, j*MapOne[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		}else if(MapOne[i][j] == 12) {
        			g.drawImage(img12, i*MapOne.length, j*MapOne[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		}else if(MapOne[i][j] == 11) {
        			g.drawImage(img11, i*MapOne.length, j*MapOne[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		}else if(MapOne[i][j] == 22) {
        			g.drawImage(img22, i*MapOne.length, j*MapOne[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		}else if(MapOne[i][j] == 15) {
        			g.drawImage(img15, i*MapOne.length, j*MapOne[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		}else if(MapOne[i][j] == 37) {
        			g.drawImage(img37, i*MapOne.length, j*MapOne[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		}else if(MapOne[i][j] == 16) {
        			g.drawImage(img16, i*MapOne.length, j*MapOne[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		}else if(MapOne[i][j] == 38) {
        			g.drawImage(img38, i*MapOne.length, j*MapOne[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		}else if(MapOne[i][j] == 17) {
        			g.drawImage(img17, i*MapOne.length, j*MapOne[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		}else if(MapOne[i][j] == 33) {
        			g.drawImage(img33, i*MapOne.length, j*MapOne[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		}else if(MapOne[i][j] == 34) {
        			g.drawImage(img34, i*MapOne.length, j*MapOne[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		}else if(MapOne[i][j] == 35) {
        			g.drawImage(img35, i*MapOne.length, j*MapOne[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		}else if(MapOne[i][j] ==36) {
        			g.drawImage(img36, i*MapOne.length, j*MapOne[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		}else if(MapOne[i][j] == 30) {
        			g.drawImage(img30, i*MapOne.length, j*MapOne[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		}else if(MapOne[i][j] == 31) {
        			g.drawImage(img31, i*MapOne.length, j*MapOne[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		}else if(MapOne[i][j] == 32) {
        			g.drawImage(img32, i*MapOne.length, j*MapOne[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		} else if(MapOne[i][j] == 1) {
        			g.drawImage(img1, i*MapOne.length, j*MapOne[0].length, null);
    				Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		} else if(MapOne[i][j] == 2) {
        			g.drawImage(img2, i*MapOne.length, j*MapOne[0].length, null);
    				Square sq=new Square(j*20,i*20);

        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		}
                        else if(MapOne[i][j] == 5) {
        			g.drawImage(img5, i*MapOne.length, j*MapOne[0].length, null);
    				Square sq=new Square(j*20,i*20);

        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		}else if(MapOne[i][j] == 51) {
        			g.drawImage(img51, i*MapOne.length, j*MapOne[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		}else if(MapOne[i][j] == 52) {
        			g.drawImage(img52, i*MapOne.length, j*MapOne[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		}else if(MapOne[i][j] == 53) {
        			g.drawImage(img53, i*MapOne.length, j*MapOne[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		}else if(MapOne[i][j] == 54) {
        			g.drawImage(img54, i*MapOne.length, j*MapOne[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		}else if(MapOne[i][j] == 55) {
        			g.drawImage(img55, i*MapOne.length, j*MapOne[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		}else if(MapOne[i][j] ==56) {
        			g.drawImage(img56, i*MapOne.length, j*MapOne[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		}else if(MapOne[i][j] ==57) {
        			g.drawImage(img57, i*MapOne.length, j*MapOne[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		}else if(MapOne[i][j] ==58) {
        			g.drawImage(img58, i*MapOne.length, j*MapOne[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		}else if(MapOne[i][j] ==99) {
        			g.drawImage(img99, i*MapOne.length, j*MapOne[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		}else if(MapOne[i][j] == 59) {
        			g.drawImage(img59, i*MapOne.length, j*MapOne[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		}else if(MapOne[i][j] ==60) {
        			g.drawImage(img60, i*MapOne.length, j*MapOne[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		}else if(MapOne[i][j] == 61) {
        			g.drawImage(img61, i*MapOne.length, j*MapOne[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		}else if(MapOne[i][j] == 62) {
        			g.drawImage(img62, i*MapOne.length, j*MapOne[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		}else if(MapOne[i][j] == 64) {
        			g.drawImage(img64, i*MapOne.length, j*MapOne[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		}else if(MapOne[i][j] == 65) {
        			g.drawImage(img65, i*MapOne.length, j*MapOne[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		}else if(MapOne[i][j] == 66) {
        			g.drawImage(img66, i*MapOne.length, j*MapOne[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		}else if(MapOne[i][j] == 67) {
        			g.drawImage(img67, i*MapOne.length, j*MapOne[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		}else if(MapOne[i][j] == 68) {
        			g.drawImage(img68, i*MapOne.length, j*MapOne[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		}else if(MapOne[i][j] ==69) {
        			g.drawImage(img69, i*MapOne.length, j*MapOne[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		}else if(MapOne[i][j] == 70) {
        			g.drawImage(img70, i*MapOne.length, j*MapOne[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		}else if(MapOne[i][j] == 71) {
        			g.drawImage(img71, i*MapOne.length, j*MapOne[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		}else if(MapOne[i][j] == 72) {
        			g.drawImage(img72, i*MapOne.length, j*MapOne[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		}else if(MapOne[i][j] == 73) {
        			g.drawImage(img73, i*MapOne.length, j*MapOne[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		}else if(MapOne[i][j] == 74) {
        			g.drawImage(img74, i*MapOne.length, j*MapOne[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		}else if(MapOne[i][j] == 75) {
        			g.drawImage(img75, i*MapOne.length, j*MapOne[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		}else if(MapOne[i][j] == 3) {
        			g.drawImage(img3, i*MapOne.length, j*MapOne[0].length, null);
    				Square sq=new Square(j*20,i*20);

        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		} else if(MapOne[i][j] == 4) {
        			g.drawImage(img4, i*MapOne.length, j*MapOne[0].length, null);
    				Square sq=new Square(j*20,i*20);

        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		}else{}
        	}
        } 
    }
    //Altered to fit my new schema
    public void printMapOne(){
        int i, j;
        for(i = 0; i < MapOne.length; i++)
        {
            for(j = 0;j < MapOne[0].length;j++)
            {

                System.out.print(MapOne[i][j]+" ");
            }
            System.out.print("\n");


        }
    }
    public void setTracer(MouseTracer mt){
    	this.mt=mt;
    }
}
