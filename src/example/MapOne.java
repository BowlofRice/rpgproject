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
        {0,0,0,0,0,0,0,0,0,2,2,2,2,2,2,2,2,2,2,2},
        {0,0,0,0,0,0,0,0,0,2,2,2,2,2,2,2,2,2,2,2},
        {0,0,0,0,0,0,0,0,0,2,2,2,2,2,2,2,2,2,2,2},
        {0,0,0,0,0,0,0,0,0,2,2,2,2,2,2,2,2,2,2,2},
        {0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2},
        {0,0,0,0,0,1,0,0,0,2,2,2,2,2,2,2,1,2,2,2},
        {0,0,0,0,0,1,0,0,0,2,2,2,2,2,2,2,1,2,4,3},
        {0,0,0,0,0,1,0,0,0,2,2,2,2,2,2,2,1,1,1,1},
        {0,0,0,0,0,1,0,0,0,2,2,2,2,2,2,2,1,2,4,3},
        {1,1,1,1,1,1,0,0,0,2,2,2,2,2,2,2,1,2,2,2},
        {0,0,0,0,0,1,0,0,0,2,2,2,2,2,2,2,1,2,2,2},
        {0,0,0,0,0,1,0,0,0,2,2,2,2,2,2,2,1,2,2,2},
        {0,0,0,0,0,1,0,0,0,2,2,2,2,2,2,2,1,2,2,2},
        {0,0,0,0,0,1,0,0,0,2,2,2,2,2,2,2,1,2,2,2},
        {0,0,0,0,0,1,0,0,0,2,2,2,2,2,2,2,1,2,2,2},
        {0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2},
        {0,0,0,0,0,0,0,0,0,2,2,2,2,2,2,2,2,2,2,2},
        {0,0,0,0,0,0,0,0,0,2,2,2,2,2,2,2,2,2,2,2},
        {0,0,0,0,0,0,0,0,0,2,2,2,2,2,2,2,2,2,2,2},
        {0,0,0,0,0,0,0,0,0,2,2,2,2,2,2,2,2,2,2,2} };

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
                		if(enemies.elementAt(k).health<=0)
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
                    		if(enemies.elementAt(k).health<=0)
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
                    		if(enemies.elementAt(k).health<=0)
                    			isitDead=true;
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
                    		if(enemies.elementAt(k).health<=0)
                    			isitDead=true;
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
                    		if(enemies.elementAt(k).health<=0)
                    			isitDead=true;
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
            	        		if(enemies.elementAt(k).health<=0)
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
            	        		if(enemies.elementAt(k).health<=0)
            	        			isitDead=true;
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
            	        		if(enemies.elementAt(k).health<=0)
            	        			isitDead=true;
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
            	        		if(enemies.elementAt(k).health<=0)
            	        			isitDead=true;
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
            	else if (mapTraversal[i][j]<=mapTraversal[i][j-1] && (mapTraversal[i][j]>= mapTraversal[i+1][j] && mapTraversal[i][j]>= mapTraversal[i-1][j] && mapTraversal[i][j]>= mapTraversal[i][j+1])){
            		g.drawImage(img1, i * mapTraversal.length, j * mapTraversal[0].length, null);
            		g.drawImage(img0, i * mapTraversal.length, (j - 1) * mapTraversal[0].length, null);
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
                    		if(bossSpawns.elementAt(h).health<=0)
                    			isitDead=true;
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
                    		if(bossSpawns.elementAt(h).health<=0)
                    			isitDead=true;
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
            		}else if(2 <= rand && rand <= 3 && mapTraversal[i][j] <= mapTraversal[i][j - 1] && (j-1)!=d) {
            			g.drawImage(img1, i * mapTraversal.length, j * mapTraversal[0].length, null);
            			g.drawImage(img0, i * mapTraversal.length, (j - 1) * mapTraversal[0].length, null);
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
            	        		if(bossSpawns.elementAt(h).health<=0)
            	        			isitDead=true;
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
            	        		if(bossSpawns.elementAt(h).health<=0)
            	        			isitDead=true;
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
        Image img2 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/newgrass.png");
        Image img3 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/castlelower.png");
        Image img4 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/castleupper.png");
        for(int i = 0; i < MapOne.length; i++) {	
        	for(int j = 0; j < MapOne[0].length; j++) {
        		if(MapOne[i][j] == 0) {
        			g.drawImage(img0, i*MapOne.length, j*MapOne[0].length, null);
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
        		} else if(MapOne[i][j] == 3) {
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
