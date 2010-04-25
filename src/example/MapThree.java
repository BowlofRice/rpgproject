package example;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Vector;

public class MapThree {
	public Vector<Enemy> enemies=new Vector<Enemy>();
	public Vector<Square> squares=new Vector<Square>();
	public TroyCastle troy=new TroyCastle();
	int k=0;//enemy counter
	public int[][] MapThree;
    public int[][] MapThreeCharacters;
    public int[][] mapTraversal;

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

    public MapThree(){
    	//A lengthy predefined map to use
    	//0 -- Sand
    	//1 -- Path
    	//2 -- Different Kind of Sand / Grass
    	//3 -- Castle Walls
        MapThree = new int[][] {
        {0,0,0,0,0,0,0,0,0,2,2,2,2,2,2,2,2,2,2,2},
        {1,1,1,1,0,0,0,0,0,2,2,2,2,2,2,2,2,2,2,2},
        {0,0,0,1,0,0,0,0,0,2,2,2,2,2,2,2,2,2,2,2},
        {0,0,0,1,0,0,0,0,0,2,2,2,2,2,2,2,2,2,2,2},
        {0,0,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2},
        {0,0,0,1,0,1,0,0,0,2,2,2,2,2,2,2,1,2,2,2},
        {0,0,0,1,0,1,0,0,0,2,2,2,2,2,2,2,1,2,3,3},
        {0,0,0,1,0,1,0,0,0,2,2,2,2,2,2,2,1,1,1,1},
        {0,0,0,1,1,1,0,0,0,2,2,2,2,2,2,2,1,2,3,3},
        {0,0,0,0,0,1,0,0,0,2,2,2,2,2,2,2,1,2,2,2},
        {0,0,0,0,0,1,0,0,0,2,2,2,2,2,2,2,1,2,2,2},
        {0,0,0,0,0,1,0,0,0,2,2,2,2,2,2,2,1,2,3,3},
        {0,0,0,1,1,1,0,0,0,2,2,2,2,2,2,2,1,1,1,1},
        {0,0,0,1,0,1,0,0,0,2,2,2,2,2,2,2,1,2,3,3},
        {0,0,0,1,0,1,0,0,0,2,2,2,2,2,2,2,1,2,2,2},
        {0,0,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2},
        {0,0,0,1,0,0,0,0,0,2,2,2,2,2,2,2,2,2,2,2},
        {0,0,0,1,0,0,0,0,0,2,2,2,2,2,2,2,2,2,2,2},
        {1,1,1,1,0,0,0,0,0,2,2,2,2,2,2,2,2,2,2,2},
        {0,0,0,0,0,0,0,0,0,2,2,2,2,2,2,2,2,2,2,2} };

        MapThreeCharacters = new int[][]{
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0},
        {0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0},
        {0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0},
        {0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,1,1,1,1},
        {0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0},
        {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0},
        {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0},
        {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0},
        {0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,1,1,1,1},
        {0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0},
        {0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0},
        {0,0,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0},
        {0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0} };

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
        {   0,   0,   0,   0,   0,1015,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,1033,   0,   0,   0},
        {   0,   0,   0,   0,   0,1015,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,1033,   0,   1,   1},
        {   0,   0,   0,1013,1014,1015,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,1033,1034,1035,1036},
        {   0,   0,   0,1012,   0,1016,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,1031,   0,   1,   1},
        {   0,   0,   0,1011,   0,1017,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,1030,   0,   0,   0},
        {   0,   0,   0,1010,   0,1018,1019,1020,1021,1022,1023,1024,1025,1026,1027,1028,1029,   0,   0,   0},
        {   0,   0,   0,1009,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0},
        {   0,   0,   0,1008,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0},
        {1003,1004,1005,1007,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0},
        {   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0} };
    }
    void moveEnemy(Graphics g, int i, int j){
    	Minion baddie=new Minion(troy);
        enemies.add(baddie);
        enemies.elementAt(k).setLocation(j, i);
    	int c = i;
        int d = j;
        Image img1 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/pathway.gif");
        Image img0 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char1.gif");
        double randomnum = 0;
        int rand = 0;
        while(mapTraversal[i][j] > 0 && j < 19){
        	randomnum = Math.random();
            randomnum = randomnum * 6;
            rand = (int) randomnum;
            if(j==0){
            	g.drawImage(img1, i * mapTraversal.length, j * mapTraversal[0].length, null/*(ImageObserver) this*/);
                g.drawImage(img0, i * mapTraversal.length, (j + 1) * mapTraversal[0].length, null);
                enemies.elementAt(k).setLocation(j, i);
                //mapTraversal[i][j] = mapTraversal[i][j+1];
                c = i;
                d = j;
                j += 1;
            }
            if(j!=0){
            	if(mapTraversal[i][j]<=mapTraversal[i][j+1] && (mapTraversal[i][j]> mapTraversal[i+1][j] && mapTraversal[i][j]> mapTraversal[i-1][j] && mapTraversal[i][j]> mapTraversal[i][j-1])){
            		g.drawImage(img1, i * mapTraversal.length, j * mapTraversal[0].length, null/*(ImageObserver) this*/);
            		g.drawImage(img0, i * mapTraversal.length, (j + 1) * mapTraversal[0].length, null);
            		enemies.elementAt(k).setLocation(j, i);
            		//mapTraversal[i][j] = mapTraversal[i][j+1];
            		c = i;
            		d = j;
            		j += 1;
            	}else if (mapTraversal[i][j]<=mapTraversal[i][j-1] && (mapTraversal[i][j]> mapTraversal[i+1][j] && mapTraversal[i][j]> mapTraversal[i-1][j] && mapTraversal[i][j]> mapTraversal[i][j+1])){
            		g.drawImage(img1, i * mapTraversal.length, j * mapTraversal[0].length, null/*(ImageObserver) this*/);
            		g.drawImage(img0, i * mapTraversal.length, (j - 1) * mapTraversal[0].length, null);
            		enemies.elementAt(k).setLocation(j, i);
            		//mapTraversal[i][j] = mapTraversal[i][j-1];
            		c = i;
            		d = j;
            		j -= 1;
            	}else if(mapTraversal[i][j]<=mapTraversal[i+1][j] && (mapTraversal[i][j]> mapTraversal[i][j-1] && mapTraversal[i][j]> mapTraversal[i-1][j] && mapTraversal[i][j]> mapTraversal[i][j+1])){
            		g.drawImage(img1, i * mapTraversal.length, j * mapTraversal[0].length, null/*(ImageObserver) this*/);
            		g.drawImage(img0, (i + 1) * mapTraversal.length, j * mapTraversal[0].length, null);
            		enemies.elementAt(k).setLocation(j, i);
            		//mapTraversal[i][j] = mapTraversal[i+1][j];
            		c = i;
            		d = j;
            		i += 1;

            	}else if(mapTraversal[i][j]<=mapTraversal[i-1][j] && (mapTraversal[i][j]> mapTraversal[i][j-1] && mapTraversal[i][j]> mapTraversal[i+1][j] && mapTraversal[i][j]> mapTraversal[i][j+1])){
            		g.drawImage(img1, i * mapTraversal.length, j * mapTraversal[0].length, null/*(ImageObserver) this*/);
            		g.drawImage(img0, (i - 1) * mapTraversal.length, j * mapTraversal[0].length, null);
            		enemies.elementAt(k).setLocation(j, i);
            		//mapTraversal[i][j] = mapTraversal[i-1][j];
            		c = i;
            		d = j;
            		i -= 1;
            	}
            if(j<19){
            	if (rand < 2 && mapTraversal[i][j] <= mapTraversal[i][j + 1] && (j+1) != d){
            		g.drawImage(img1, i * mapTraversal.length, j * mapTraversal[0].length, null/*(ImageObserver) this*/);
            		g.drawImage(img0, i * mapTraversal.length, (j + 1) * mapTraversal[0].length, null);
            		enemies.elementAt(k).setLocation(j, i);
            		//mapTraversal[i][j] = mapTraversal[i][j+1];
            		c = i;
            		d = j;
            		j += 1;

            	}else if (2 <= rand && rand <= 3 && mapTraversal[i][j] <= mapTraversal[i][j - 1] && (j-1)!=d){
            		g.drawImage(img1, i * mapTraversal.length, j * mapTraversal[0].length, null/*(ImageObserver) this*/);
            		g.drawImage(img0, i * mapTraversal.length, (j - 1) * mapTraversal[0].length, null);
            		enemies.elementAt(k).setLocation(j, i);
            		//mapTraversal[i][j] = mapTraversal[i][j-1];
            		c = i;
            		d = j;
            		j -= 1;
            	}else if (3 < rand && rand <= 4 && mapTraversal[i][j] <= mapTraversal[i + 1][j] && (i+1)!=c){
            		g.drawImage(img1, i * mapTraversal.length, j * mapTraversal[0].length, null/*(ImageObserver) this*/);
            		g.drawImage(img0, (i + 1) * mapTraversal.length, j * mapTraversal[0].length, null);
            		enemies.elementAt(k).setLocation(j, i);
            		//mapTraversal[i][j] = mapTraversal[i+1][j];
            		c = i;
            		d = j;
            		i += 1;
            	}else if (4 < rand && rand <= 6 && mapTraversal[i][j] <= mapTraversal[i - 1][j] && (i-1)!=c){
            		g.drawImage(img1, i * mapTraversal.length, j * mapTraversal[0].length, null/*(ImageObserver) this*/);
            		g.drawImage(img0, (i - 1) * mapTraversal.length, j * mapTraversal[0].length, null);
            		enemies.elementAt(k).setLocation(j, i);
            		//mapTraversal[i][j] = mapTraversal[i-1][j];
            		c = i;
            		d = j;
            		i -= 1;
            	}else{
            		//System.out.println("While loop will go again\n");
            	}
            }
            }
           try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
    public void paint(Graphics g){   
    	Image img0 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/LARose_sand.gif");
        Image img1 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/pathway.gif");
        Image img2 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/grass.gif");
        Image img3 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/stronghold.gif");
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
        		}else{
        			System.err.println("should never happen!");
        		}
        	}
        }        			
    }
/*
This function returns an int value and places a flag number on the space selected.  It will return 1 if there was a sucesss in placing,
and a 0 if not.  The flag number designates the level and unit
 */
    public int placeGoodGuy(int row, int column, int flag){
        if(MapThreeCharacters[row][column] == 0){
        MapThreeCharacters[row][column] = flag;
        return 1;
        }
        else
            return 0;
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
}
