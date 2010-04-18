package example;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.lang.Math;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Testing out an idea, I had by using Andrew's Map One as
 * a spring board
 */

public class MapAltTwo {

    public int[][] MapTwo;
    public int[][] MapTwoCharacters;
    public int[][] MapTraversalTwo;

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

    public MapAltTwo(){
    	
        //A lengthy predefined map to use
    	//0 -- Sand
    	//1 -- Path
    	//2 -- Different Kind of Sand / Grass
    	//3 -- Castle Walls
        MapTwo = new int[][] {
        {0,0,0,0,0,0,0,0,0,2,2,2,2,2,2,2,2,2,2,2},
        {0,0,0,0,0,0,0,0,0,2,2,2,2,2,2,2,2,2,3,3},
        {0,0,0,0,0,0,0,0,0,2,2,2,2,2,2,2,1,1,1,1},
        {0,0,0,0,0,0,0,0,0,2,2,2,2,2,2,2,1,2,3,3},
        {0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2},
        {0,0,0,0,0,1,0,0,0,2,2,2,2,2,2,2,1,2,2,2},
        {0,0,0,0,0,1,0,0,0,2,2,2,2,2,2,2,1,2,3,3},
        {0,0,0,0,0,1,0,0,0,2,2,2,2,2,2,2,1,1,1,1},
        {0,0,0,0,0,1,0,0,0,2,2,2,2,2,2,2,2,2,3,3},
        {0,0,0,0,0,1,0,0,0,2,2,2,2,2,2,2,2,2,2,2},
        {0,0,0,0,0,1,0,0,0,2,2,2,2,2,2,2,2,2,2,2},
        {0,0,0,0,1,1,0,0,0,2,2,2,2,2,2,2,2,2,2,2},
        {0,0,0,0,1,0,0,0,0,2,2,2,2,2,2,2,2,2,2,2},
        {0,0,0,0,1,0,0,0,0,2,2,2,2,2,2,2,2,2,2,2},
        {0,0,0,0,1,0,0,0,0,2,2,2,2,2,2,2,2,2,2,2},
        {0,0,0,0,1,0,0,0,0,2,2,2,2,2,2,2,2,2,2,2},
        {0,0,0,0,1,0,0,0,0,2,2,2,2,2,2,2,2,2,2,2},
        {0,0,0,0,1,0,0,0,0,2,2,2,2,2,2,2,2,2,2,2},
        {1,1,1,1,1,0,0,0,0,2,2,2,2,2,2,2,2,2,2,2},
        {0,0,0,0,0,0,0,0,0,2,2,2,2,2,2,2,2,2,2,2} };

        MapTwoCharacters = new int[][]{
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0},
        {0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0},
        {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0},
        {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0},
        {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,1,1,1},
        {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0} };

        MapTraversalTwo = new int[][]{
        {   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0},
        {   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0},
        {   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,2023,2024,2025,2026},
        {   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,2022,   0,   0,   0},
        {   0,   0,   0,   0,   0,2010,2011,2012,2013,2014,2015,2016,2017,2018,2019,2020,2021,   0,   0,   0},
        {   0,   0,   0,   0,   0,2009,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,2022,   0,   0,   0},
        {   0,   0,   0,   0,   0,2008,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,2023,   0,   0,   0},
        {   0,   0,   0,   0,   0,2007,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,2024,2025,2026,2027},
        {   0,   0,   0,   0,   0,2006,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0},
        {   0,   0,   0,   0,   0,2005,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0},
        {   0,   0,   0,   0,   0,2004,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0},
        {   0,   0,   0,   0,2002,2003,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0},
        {   0,   0,   0,   0,2001,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0},
        {   0,   0,   0,   0,2000,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0},
        {   0,   0,   0,   0,1009,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0},
        {   0,   0,   0,   0,1008,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0},
        {   0,   0,   0,   0,1007,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0},
        {   0,   0,   0,   0,1006,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0},
        {1001,1002,1003,1004,1005,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0},
        {   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0} };

        
    }

    /**
     *
     * @param g
     * @param Matrix
     * @param i
     * @param j
     *
     * function which chooses a random number from 0 - 6 and chooses an increment
     * in a matrix which will always choose a higher value from previous position
     */
    void moveEnemy3(Graphics g, int[][] Matrix, int i, int j) {


        int c = i;
        int d = j;
        Image img1 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/pathway.gif");
        Image img0 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char1.gif");
        double randomnum = 0;
        int rand = 0;
        while (Matrix[i][j] > 0 && j < 19) {
            randomnum = Math.random();
            randomnum = randomnum * 6;
            rand = (int) randomnum;
            if (rand < 2 && Matrix[i][j] <= Matrix[i][j + 1] && (j+1) != d) {
                g.drawImage(img1, i * Matrix.length, j * Matrix[0].length, null/*(ImageObserver) this*/);
                g.drawImage(img0, i * Matrix.length, (j + 1) * Matrix[0].length, null);
                //Matrix[i][j] = Matrix[i][j+1];



                c = i;
                d = j;

                j += 1;
            } else if (2 <= rand && rand <= 3 && Matrix[i][j] <= Matrix[i][j - 1] && (j-1)!=d) {
                g.drawImage(img1, i * Matrix.length, j * Matrix[0].length, null/*(ImageObserver) this*/);
                g.drawImage(img0, i * Matrix.length, (j - 1) * Matrix[0].length, null);
                //Matrix[i][j] = Matrix[i][j-1];


                j -= 1;
            } else if (3 < rand && rand <= 4 && Matrix[i][j] <= Matrix[i + 1][j] && (i+1)!=c) {
                g.drawImage(img1, i * Matrix.length, j * Matrix[0].length, null/*(ImageObserver) this*/);
                g.drawImage(img0, (i + 1) * Matrix.length, j * Matrix[0].length, null);
                //Matrix[i][j] = Matrix[i+1][j];

                i += 1;
            } else if (4 < rand && rand <= 6 && Matrix[i][j] <= Matrix[i - 1][j] && (i-1)!=c) {
                g.drawImage(img1, i * Matrix.length, j * Matrix[0].length, null/*(ImageObserver) this*/);
                g.drawImage(img0, (i - 1) * Matrix.length, j * Matrix[0].length, null);
                //Matrix[i][j] = Matrix[i-1][j];


                i -= 1;
            } else {
                System.out.println("While loop will go again\n");
            }
        }}


    
    public void paint(Graphics g)
    {   
    	Image img0 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/LARose_sand.gif");
        Image img1 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/pathway.gif");
        Image img2 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/grass.gif");
        Image img3 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/stronghold.gif");
        for(int i =   0; i < MapTwo.length; i++) {
        	for(int j = 0; j < MapTwo[0].length; j++) {
        		if(MapTwo[i][j] == 0) {
        			g.drawImage(img0, i*MapTwo.length, j*MapTwo[0].length, null);
        		} else if(MapTwo[i][j] == 1) {
        			g.drawImage(img1, i*MapTwo.length, j*MapTwo[0].length, null);
        		} else if(MapTwo[i][j] == 2) {
        			g.drawImage(img2, i*MapTwo.length, j*MapTwo[0].length, null);
        		} else if(MapTwo[i][j] == 3) {
        			g.drawImage(img3, i*MapTwo.length, j*MapTwo[0].length, null);
        		}
                        else{
        			System.err.println("should never happen!");
        		}
        	}
        }        			
    }

     /**
     * paintCharacters
     *
     * @param MapTwo - this method paints the map for the characters placement
     */

    public void paintCharacter(Graphics g, int i, int j, int char_flag)
    {
        //image for the basic bad guy
        Image img1 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char1.gif");

        //images for the different levels of archers
        Image img2 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char2.gif");
        Image img3 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char3.gif");
        Image img4 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char4.gif");
        Image img5 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char5.gif");
        Image img6 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char6.gif");

        //images for the different levels of blue casters
        Image img7 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char7.gif");
        Image img8 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char8.gif");
        Image img9 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char9.gif");
        Image img10 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char10.gif");
        Image img11= Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char11.gif");

        //green casters
        Image img12 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char12.gif");
        Image img13 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char13.gif");
        Image img14 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char14.gif");
        Image img15 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char15.gif");
        Image img16= Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char16.gif");

        //images for different levels of redCaster
        Image img17 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char17.gif");
        Image img18 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char18.gif");
        Image img19 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char19.gif");
        Image img20 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char20.gif");
        Image img21 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char21.gif");

        //images for different levels of melee fighters
        Image img22 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char22.gif");
        Image img23 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char23.gif");
        Image img24 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char24.gif");
        Image img25 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char25.gif");
        Image img26 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char26.gif");

        //images for different levels of prophet
        Image img27 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char27.gif");
        Image img28 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char28.gif");
        Image img29 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char29.gif");
        Image img30 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char30.gif");
        Image img31 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char31.gif");

        		if(char_flag == 1) {
        			g.drawImage(img1, i*MapTwo.length, j*MapTwo[0].length, (ImageObserver) this);
        		}

                        else if(char_flag == 2) {
        			g.drawImage(img2, i*MapTwo.length, j*MapTwo[0].length, (ImageObserver) this);
        		} else if(char_flag == 3) {
        			g.drawImage(img3, i*MapTwo.length, j*MapTwo[0].length, (ImageObserver) this);
                        }
                        else if(char_flag == 4) {
        			g.drawImage(img4, i*MapTwo.length, j*MapTwo[0].length, (ImageObserver) this);
        		} else if(char_flag == 5) {
        			g.drawImage(img5, i*MapTwo.length, j*MapTwo[0].length, (ImageObserver) this);
                        }
                        else if(char_flag == 6) {
        			g.drawImage(img6, i*MapTwo.length, j*MapTwo[0].length, (ImageObserver) this);
        		} else if(char_flag == 7) {
        			g.drawImage(img7, i*MapTwo.length, j*MapTwo[0].length, (ImageObserver) this);
                        }
                        else if(char_flag == 8) {
        			g.drawImage(img8, i*MapTwo.length, j*MapTwo[0].length, (ImageObserver) this);
        		} else if(char_flag == 9) {
        			g.drawImage(img9, i*MapTwo.length, j*MapTwo[0].length, (ImageObserver) this);
                        }
                        else if(char_flag == 10) {
        			g.drawImage(img10, i*MapTwo.length, j*MapTwo[0].length, (ImageObserver) this);
        		} else if(char_flag == 11) {
        			g.drawImage(img11, i*MapTwo.length, j*MapTwo[0].length, (ImageObserver) this);
                        }
                        else if(char_flag == 12) {
        			g.drawImage(img12, i*MapTwo.length, j*MapTwo[0].length, (ImageObserver) this);
        		} else if(char_flag == 13) {
        			g.drawImage(img13, i*MapTwo.length, j*MapTwo[0].length, (ImageObserver) this);
                        }
                        else if(char_flag == 14) {
        			g.drawImage(img14, i*MapTwo.length, j*MapTwo[0].length, (ImageObserver) this);
        		} else if(char_flag == 15) {
        			g.drawImage(img15, i*MapTwo.length, j*MapTwo[0].length, (ImageObserver) this);
                        }
                        else if(char_flag == 16) {
        			g.drawImage(img16, i*MapTwo.length, j*MapTwo[0].length, (ImageObserver) this);
        		} else if(char_flag == 17) {
        			g.drawImage(img17, i*MapTwo.length, j*MapTwo[0].length, (ImageObserver) this);
                        }
                        else if(char_flag == 18) {
        			g.drawImage(img18, i*MapTwo.length, j*MapTwo[0].length, (ImageObserver) this);
        		} else if(char_flag == 19) {
        			g.drawImage(img19, i*MapTwo.length, j*MapTwo[0].length, (ImageObserver) this);
                        }
                        else if(char_flag == 20) {
        			g.drawImage(img20, i*MapTwo.length, j*MapTwo[0].length, (ImageObserver) this);
        		} else if(char_flag == 21) {
        			g.drawImage(img21, i*MapTwo.length, j*MapTwo[0].length, (ImageObserver) this);
                        }
                        else if(char_flag == 22) {
        			g.drawImage(img22, i*MapTwo.length, j*MapTwo[0].length, (ImageObserver) this);
        		} else if(char_flag == 23) {
        			g.drawImage(img23, i*MapTwo.length, j*MapTwo[0].length, (ImageObserver) this);
                        }
                        else if(char_flag == 24) {
        			g.drawImage(img24, i*MapTwo.length, j*MapTwo[0].length, (ImageObserver) this);
        		} else if(char_flag == 25) {
        			g.drawImage(img25, i*MapTwo.length, j*MapTwo[0].length, (ImageObserver) this);
                        }
                        else if(char_flag == 26) {
        			g.drawImage(img26, i*MapTwo.length, j*MapTwo[0].length, (ImageObserver) this);
        		} else if(char_flag == 27) {
        			g.drawImage(img27, i*MapTwo.length, j*MapTwo[0].length, (ImageObserver) this);
                        }
                        else if(char_flag == 28) {
        			g.drawImage(img28, i*MapTwo.length, j*MapTwo[0].length, (ImageObserver) this);
        		} else if(char_flag == 29) {
        			g.drawImage(img29, i*MapTwo.length, j*MapTwo[0].length, (ImageObserver) this);
                        }
                        else if(char_flag == 30) {
        			g.drawImage(img30, i*MapTwo.length, j*MapTwo[0].length, (ImageObserver) this);
        		} else if(char_flag == 31) {
        			g.drawImage(img31, i*MapTwo.length, j*MapTwo[0].length, (ImageObserver) this);
                        }
                        else{
        			System.err.println("should never happen!");
        		}

        	}
 

    
           
/*
This function returns an int value and places a flag number on the space selected.  It will return 1 if there was a sucesss in placing,
and a 0 if not.  The flag number designates the level and unit
 */
    public int placeGoodGuy(int row, int column, int flag){
        if(MapTwoCharacters[row][column] == 0){
        MapTwoCharacters[row][column] = flag;
        return 1;
        }
        else
            return 0;
    }
    

    //Altered to fit my new schema
    public void printMapTwo(){
        int i, j;
        for(i = 0; i < MapTwo.length; i++)
        {
            for(j = 0;j < MapTwo[0].length;j++)
            {

                System.out.print(MapTwo[i][j]+" ");
            }
            System.out.print("\n");


        }
    }
}