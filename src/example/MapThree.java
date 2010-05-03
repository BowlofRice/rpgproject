package example;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class MapThree {
	public Vector<Minion> enemies=new Vector<Minion>();
	public Vector<Boss> bossSpawns=new Vector<Boss>();
	public Vector<Square> squares=new Vector<Square>();
	public Vector<TroyCastle> castles=new Vector<TroyCastle>();
	public TroyCastle troyA=new TroyCastle(6,18);
	public TroyCastle troyB=new TroyCastle(11,18);
	public int HP=troyA.health+troyB.health;
	public JTextArea troyHP=new JTextArea(HP+"/200");
	int k=0;//enemy counter
	int h=0;//boss counter
	boolean isitDead=false;
	boolean gameOver=false;
	public int[][] MapThree;
    public int[][] mapTraversal;
	private MouseTracer3 mt;
	private CharSelection3 cs;

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

    public static final int MELEE_FLAG_1 = 22;
    public static final int MELEE_FLAG_2 = 23;
    public static final int MELEE_FLAG_3 = 24;
    public static final int MELEE_FLAG_4 = 25;
    public static final int MELEE_FLAG_5 = 26;

    public static final int PROPHET_FLAG_1 = 27;
    public static final int PROPHET_FLAG_2 = 28;
    public static final int PROPHET_FLAG_3 = 29;
    public static final int PROPHET_FLAG_4 = 30;
    public static final int PROPHET_FLAG_5 = 31;

    public MapThree(CharSelection3 cs){
    	this.cs=cs;
    	castles.add(troyA);
    	castles.add(troyB);
    	//A lengthy predefined map to use
    	//0 -- Sand
    	//1 -- Path
    	//2 -- Different Kind of Sand / Grass
    	//3 -- Castle Walls
        MapThree = new int[][] {
        {0 ,0 ,0 ,0 ,0 ,0 ,23,0 ,0 ,2 ,2 ,2 ,2 ,15,2 ,24,26,25,26,24},
        {1 ,1 ,1 ,1 ,0 ,0 ,0 ,0 ,0 ,2 ,2 ,2 ,19,18,2 ,2 ,24,23,24,26},
        {0 ,0 ,0 ,1 ,0 ,0 ,0 ,0 ,0 ,2 ,2 ,19,18,2 ,2 ,24,2 ,24,2 ,25},
        {0 ,0 ,0 ,1 ,0 ,0 ,0 ,0 ,0 ,2 ,2 ,16,2 ,2 ,2 ,2 ,2 ,2 ,26,2},
        {0 ,0 ,0 ,1 ,0 ,1 ,1 ,1 ,1 ,1 ,1 ,22,1 ,1 ,1 ,1 ,1 ,2 ,2 ,2},
        {0 ,23,0 ,1 ,0 ,1 ,0 ,0 ,0 ,2 ,2 ,17,2 ,2 ,2 ,2 ,1 ,2 ,2 ,2},
        {0 ,0 ,0 ,1 ,0 ,1 ,0 ,0 ,0 ,2 ,19,18,2 ,2 ,2 ,2 ,1 ,2 ,4,3},
        {0 ,0 ,0 ,1 ,0 ,1 ,0 ,23,0 ,19,18,2 ,2 ,2 ,2 ,2 ,1 ,1 ,1 ,1},
        {0 ,0 ,0 ,1 ,1 ,1 ,0 ,0 ,0 ,17,2 ,2 ,2 ,2 ,2 ,2 ,1 ,2 ,4,3},
        {0 ,0 ,0 ,0 ,0 ,1 ,0 ,0 ,0 ,12,11,2 ,2 ,2 ,2 ,2 ,1 ,2 ,2 ,2},
        {0 ,0 ,0 ,0 ,0 ,1 ,0 ,0 ,0 ,2 ,12,11,2 ,2 ,2 ,2 ,1 ,2 ,2 ,2},
        {0 ,23,0 ,0 ,0 ,1 ,0 ,0 ,5 ,8 ,2 ,15,2 ,5 ,8 ,2 ,1 ,2 ,4,3},
        {0 ,0 ,0 ,1 ,1 ,1 ,0 ,0 ,6 ,9 ,2 ,16,2 ,6 ,9 ,2 ,1 ,1 ,1 ,1},
        {0 ,23,0 ,1 ,0 ,1 ,0 ,0 ,7 ,10,2 ,17,2 ,7 ,10,2 ,1 ,2 ,4,3},
        {0 ,0 ,0 ,1 ,0 ,1 ,0 ,0 ,0 ,2 ,2 ,15,2 ,2 ,2 ,2 ,1 ,2 ,2 ,2},
        {0 ,0 ,0 ,1 ,0 ,1 ,1 ,1 ,1 ,1 ,1 ,22,1 ,1 ,1 ,1 ,1 ,2 ,24,25},
        {0 ,0 ,0 ,1 ,0 ,0 ,0 ,0 ,0 ,2 ,2 ,16,2 ,2 ,2 ,2 ,2 ,2 ,24,2},
        {0 ,0 ,0 ,1 ,0 ,0 ,0 ,0 ,0 ,2 ,2 ,12,11,2 ,2 ,24,2 ,23,2 ,26},
        {1 ,1 ,1 ,1 ,0 ,0 ,23,0 ,0 ,2 ,2 ,2 ,12,11,2 ,2 ,24,24,24,26},
        {0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,2 ,2 ,2 ,2 ,12,11,24,26,25,26,24} };

        mapTraversal = new int[][]{

        {   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0},
        {1003,1004,1005,1006,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0},
        {   0,   0,   0,1007,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0},
        {   0,   0,   0,1008,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0},
        {   0,   0,   0,1009,   0,1019,1020,1021,1022,1023,1024,1025,1026,1027,1028,1029,1030,   0,   0,   0},
        {   0,   0,   0,1010,   0,1018,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,1031,   0,   0,   0},
        {   0,   0,   0,1011,   0,1017,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,1032,   0,   1,   1},
        {   0,   0,   0,1012,   0,1016,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,1033,1034,1035,1036},
        {   0,   0,   0,1013,1014,1015,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,1033,   0,   1,   1},
        {   0,   0,   0,   0,   0,1015,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,1033,   0,   0,   0},
        {   0,   0,   0,   0,   0,1015,   0,   0,   0,   7,   10,   0,   0,   0,   0,   0,1033,   0,   0,   0},
        {   0,   0,   0,   0,   0,1015,   0,   0,   0,   6,   9,   0,   0,   0,   0,   0,1033,   0,   1,   1},
        {   0,   0,   0,1013,1014,1015,   0,   0,   0,   5,   8,   0,   0,   0,   0,   0,1033,1034,1035,1036},
        {   0,   0,   0,1012,   0,1016,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,1031,   0,   1,   1},
        {   0,   0,   0,1011,   0,1017,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,1030,   0,   0,   0},
        {   0,   0,   0,1010,   0,1018,1019,1020,1021,1022,1023,1024,1025,1026,1027,1028,1029,   0,   0,   0},
        {   0,   0,   0,1009,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0},
        {   0,   0,   0,1008,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0},
        {1003,1004,1005,1007,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0},
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
        while(mapTraversal[i][j] > 0 && j < 19){
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
                		if(enemies.elementAt(k).health<0){
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
                		HP-=enemies.elementAt(k).attack;
                		troyHP.setText(HP+"/200");
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
            	if(mapTraversal[i][j]<=mapTraversal[i][j+1] && (mapTraversal[i][j]> mapTraversal[i+1][j] && mapTraversal[i][j]> mapTraversal[i-1][j] && mapTraversal[i][j]> mapTraversal[i][j-1])){
            		g.drawImage(img1, i * mapTraversal.length, j * mapTraversal[0].length, null);
            		g.drawImage(img0, i * mapTraversal.length, (j + 1) * mapTraversal[0].length, null);
            		enemies.elementAt(k).setLocation(i, j);
            		for(int b=0;b<mt.allies.size();b++){
            			if(mt.allies.elementAt(b).withinRange(enemies.elementAt(k))){
                    		mt.allies.elementAt(b).dealDamage(enemies.elementAt(k));
                    		if(enemies.elementAt(k).health<0){
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
                    		HP-=enemies.elementAt(k).attack;
                    		troyHP.setText(HP+"/200");
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
            	}else if (mapTraversal[i][j]<=mapTraversal[i][j-1] && (mapTraversal[i][j]> mapTraversal[i+1][j] && mapTraversal[i][j]> mapTraversal[i-1][j] && mapTraversal[i][j]> mapTraversal[i][j+1])){
            		g.drawImage(img1, i * mapTraversal.length, j * mapTraversal[0].length, null);
            		g.drawImage(img0, i * mapTraversal.length, (j - 1) * mapTraversal[0].length, null);
            		enemies.elementAt(k).setLocation(i, j);
            		for(int b=0;b<mt.allies.size();b++){
            			if(mt.allies.elementAt(b).withinRange(enemies.elementAt(k))){
                    		mt.allies.elementAt(b).dealDamage(enemies.elementAt(k));
                    		if(enemies.elementAt(k).health<0){
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
                    		HP-=enemies.elementAt(k).attack;
                    		troyHP.setText(HP+"/200");
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
            	}else if(mapTraversal[i][j]<=mapTraversal[i+1][j] && (mapTraversal[i][j]> mapTraversal[i][j-1] && mapTraversal[i][j]> mapTraversal[i-1][j] && mapTraversal[i][j]> mapTraversal[i][j+1])){
            		g.drawImage(img1, i * mapTraversal.length, j * mapTraversal[0].length, null);
            		g.drawImage(img0, (i + 1) * mapTraversal.length, j * mapTraversal[0].length, null);
            		enemies.elementAt(k).setLocation(i, j);
            		for(int b=0;b<mt.allies.size();b++){
            			if(mt.allies.elementAt(b).withinRange(enemies.elementAt(k))){
                    		mt.allies.elementAt(b).dealDamage(enemies.elementAt(k));
                    		if(enemies.elementAt(k).health<0){
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
                    		HP-=enemies.elementAt(k).attack;
                    		troyHP.setText(HP+"/200");
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

            	}else if(mapTraversal[i][j]<=mapTraversal[i-1][j] && (mapTraversal[i][j]> mapTraversal[i][j-1] && mapTraversal[i][j]> mapTraversal[i+1][j] && mapTraversal[i][j]> mapTraversal[i][j+1])){
            		g.drawImage(img1, i * mapTraversal.length, j * mapTraversal[0].length, null);
            		g.drawImage(img0, (i - 1) * mapTraversal.length, j * mapTraversal[0].length, null);
            		enemies.elementAt(k).setLocation(i, j);
            		for(int b=0;b<mt.allies.size();b++){
            			if(mt.allies.elementAt(b).withinRange(enemies.elementAt(k))){
                    		mt.allies.elementAt(b).dealDamage(enemies.elementAt(k));
                    		if(enemies.elementAt(k).health<0){
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
                    		HP-=enemies.elementAt(k).attack;
                    		troyHP.setText(HP+"/200");
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
            	if (rand < 2 && mapTraversal[i][j] <= mapTraversal[i][j + 1] && (j+1) != d){
            		g.drawImage(img1, i * mapTraversal.length, j * mapTraversal[0].length, null);
            		g.drawImage(img0, i * mapTraversal.length, (j + 1) * mapTraversal[0].length, null);
            		enemies.elementAt(k).setLocation(i, j);
            		for(int b=0;b<mt.allies.size();b++){
            			if(mt.allies.elementAt(b).withinRange(enemies.elementAt(k))){
                    		mt.allies.elementAt(b).dealDamage(enemies.elementAt(k));
                    		if(enemies.elementAt(k).health<0){
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
                    		HP-=enemies.elementAt(k).attack;
                    		troyHP.setText(HP+"/200");
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

            	}else if (2 <= rand && rand <= 3 && mapTraversal[i][j] <= mapTraversal[i][j - 1] && (j-1)!=d){
            		g.drawImage(img1, i * mapTraversal.length, j * mapTraversal[0].length, null);
            		g.drawImage(img0, i * mapTraversal.length, (j - 1) * mapTraversal[0].length, null);
            		enemies.elementAt(k).setLocation(i, j);
            		for(int b=0;b<mt.allies.size();b++){
            			if(mt.allies.elementAt(b).withinRange(enemies.elementAt(k))){
                    		mt.allies.elementAt(b).dealDamage(enemies.elementAt(k));
                    		if(enemies.elementAt(k).health<0){
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
                    		HP-=enemies.elementAt(k).attack;
                    		troyHP.setText(HP+"/200");
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
            	}else if (3 < rand && rand <= 4 && mapTraversal[i][j] <= mapTraversal[i + 1][j] && (i+1)!=c){
            		g.drawImage(img1, i * mapTraversal.length, j * mapTraversal[0].length, null);
            		g.drawImage(img0, (i + 1) * mapTraversal.length, j * mapTraversal[0].length, null);
            		enemies.elementAt(k).setLocation(i, j);
            		for(int b=0;b<mt.allies.size();b++){
            			if(mt.allies.elementAt(b).withinRange(enemies.elementAt(k))){
                    		mt.allies.elementAt(b).dealDamage(enemies.elementAt(k));
                    		if(enemies.elementAt(k).health<0){
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
                    		HP-=enemies.elementAt(k).attack;
                    		troyHP.setText(HP+"/200");
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
            	}else if (4 < rand && rand <= 6 && mapTraversal[i][j] <= mapTraversal[i - 1][j] && (i-1)!=c){
            		g.drawImage(img1, i * mapTraversal.length, j * mapTraversal[0].length, null);
            		g.drawImage(img0, (i - 1) * mapTraversal.length, j * mapTraversal[0].length, null);
            		enemies.elementAt(k).setLocation(i, j);
            		for(int b=0;b<mt.allies.size();b++){
            			if(mt.allies.elementAt(b).withinRange(enemies.elementAt(k))){
                    		mt.allies.elementAt(b).dealDamage(enemies.elementAt(k));
                    		if(enemies.elementAt(k).health<0){
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
                    		HP-=enemies.elementAt(k).attack;
                    		troyHP.setText(HP+"/200");
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
        Image img5 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/colo1.png");
        Image img6 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/colo2.png");
        Image img7 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/colo3.png");
        Image img8 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/colo4.png");
        Image img9 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/colo5.png");
        Image img10 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/colo6.png");
        //not put in for yet
        Image img11 = Toolkit.getDefaultToolkit().getImage("..//rpgproject/src/example/tiles/rivergorightA.png");
        Image img12 = Toolkit.getDefaultToolkit().getImage("..//rpgproject/src/example/tiles/riverGorightB.png");
       // Image img13 = Toolkit.getDefaultToolkit().getImage("..//rpgproject/src/example/tiles/riverGorightC.png");
        Image img14 = Toolkit.getDefaultToolkit().getImage("..//rpgproject/src/example/tiles/rivergorightD.png");

        Image img15 = Toolkit.getDefaultToolkit().getImage("..//rpgproject/src/example/tiles/river1.png");
        Image img16 = Toolkit.getDefaultToolkit().getImage("..//rpgproject/src/example/tiles/river2.png");
        Image img17 = Toolkit.getDefaultToolkit().getImage("..//rpgproject/src/example/tiles/river3.png");

        Image img18 = Toolkit.getDefaultToolkit().getImage("..//rpgproject/src/example/tiles/riverGoleftA.png");
        Image img19 = Toolkit.getDefaultToolkit().getImage("..//rpgproject/src/example/tiles/rivergoLeftB.png");
        Image img20 = Toolkit.getDefaultToolkit().getImage("..//rpgproject/src/example/tiles/riverGoLeftC.png");
        Image img21 = Toolkit.getDefaultToolkit().getImage("..//rpgproject/src/example/tiles/riverGoleftD.png");


        Image img22 = Toolkit.getDefaultToolkit().getImage("..//rpgproject/src/example/tiles/bridge.png");
        Image img23 = Toolkit.getDefaultToolkit().getImage("..//rpgproject/src/example/tiles/littlehut.png");
        Image img24 = Toolkit.getDefaultToolkit().getImage("..//rpgproject/src/example/tiles/treelessthick.png");
        Image img25 = Toolkit.getDefaultToolkit().getImage("..//rpgproject/src/example/tiles/treesthick1.png");
        Image img26 = Toolkit.getDefaultToolkit().getImage("..//rpgproject/src/example/tiles/treesthick2.png");

        for(int i = 0; i < MapThree.length; i++) {
        	for(int j = 0; j < MapThree[0].length; j++) {
        		if(MapThree[i][j] == 0) {
        			g.drawImage(img0, i*MapThree.length, j*MapThree[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		} else if(MapThree[i][j] == 1) {
        			g.drawImage(img1, i*MapThree.length, j*MapThree[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		} else if(MapThree[i][j] == 2) {
        			g.drawImage(img2, i*MapThree.length, j*MapThree[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		} else if(MapThree[i][j] == 3) {
        			g.drawImage(img3, i*MapThree.length, j*MapThree[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		} else if(MapThree[i][j] == 4) {
        			g.drawImage(img4, i*MapThree.length, j*MapThree[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
                                } else if(MapThree[i][j] == 5) {
        			g.drawImage(img5, i*MapThree.length, j*MapThree[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
                                } else if(MapThree[i][j] == 6) {
        			g.drawImage(img6, i*MapThree.length, j*MapThree[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
                                } else if(MapThree[i][j] == 7) {
        			g.drawImage(img7, i*MapThree.length, j*MapThree[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
                                } else if(MapThree[i][j] == 8) {
        			g.drawImage(img8, i*MapThree.length, j*MapThree[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
                                } else if(MapThree[i][j] == 9) {
        			g.drawImage(img9, i*MapThree.length, j*MapThree[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
                                } else if(MapThree[i][j] == 10) {
        			g.drawImage(img10, i*MapThree.length, j*MapThree[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}//
                                        		} else if(MapThree[i][j] == 11) {
        			g.drawImage(img11, i*MapThree.length, j*MapThree[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		} else if(MapThree[i][j] == 12) {
        			g.drawImage(img12, i*MapThree.length, j*MapThree[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		} /*else if(MapThree[i][j] == 13) {
        			g.drawImage(img13, i*MapThree.length, j*MapThree[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
        		} */else if(MapThree[i][j] == 14) {
        			g.drawImage(img14, i*MapThree.length, j*MapThree[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
                                } else if(MapThree[i][j] == 15) {
        			g.drawImage(img15, i*MapThree.length, j*MapThree[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
                                } else if(MapThree[i][j] == 16) {
        			g.drawImage(img16, i*MapThree.length, j*MapThree[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
                                } else if(MapThree[i][j] == 17) {
        			g.drawImage(img17, i*MapThree.length, j*MapThree[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
                                } else if(MapThree[i][j] == 18) {
        			g.drawImage(img18, i*MapThree.length, j*MapThree[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
                                } else if(MapThree[i][j] == 19) {
        			g.drawImage(img19, i*MapThree.length, j*MapThree[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
                                } else if(MapThree[i][j] == 20) {
        			g.drawImage(img20, i*MapThree.length, j*MapThree[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
                                                                } else if(MapThree[i][j] == 21) {
        			g.drawImage(img21, i*MapThree.length, j*MapThree[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
                                                                } else if(MapThree[i][j] == 22) {
        			g.drawImage(img22, i*MapThree.length, j*MapThree[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}
                                                                }
                                                               else if(MapThree[i][j] == 23) {
        			g.drawImage(img23, i*MapThree.length, j*MapThree[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}

        		}else if(MapThree[i][j] == 24) {
        			g.drawImage(img24, i*MapThree.length, j*MapThree[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}

        		}else if(MapThree[i][j] == 25) {
        			g.drawImage(img25, i*MapThree.length, j*MapThree[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}

        		}else if(MapThree[i][j] == 26) {
        			g.drawImage(img26, i*MapThree.length, j*MapThree[0].length, null);
        			Square sq=new Square(j*20,i*20);
        			if(squares.size()<400){
        				squares.add(sq);
        			}

        		}else{}
        	}
        }        			
    }
    //Altered to fit my new schema
    public void printMapThree(){
        int i, j;
        for(i = 0; i < MapThree.length; i++)
        {
            for(j = 0;j < MapThree[0].length;j++)
            {

                System.out.print(MapThree[i][j]+" ");
            }
            System.out.print("\n");


        }
    }
    public void setTracer(MouseTracer3 mt){
    	this.mt=mt;
    }
}
