package example;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Testing out an idea, I had by using Andrew's Map One as
 * a spring board
 */

public class MapAltOne {

    public int[][] MapOne;
    public int[][] MapOneCharacters;

    public MapAltOne(){
    //EVENTUALLY ADD FINAL INT VARS FOR CHARACTERS
    //eg: public static final BLUECAST4 =10;
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
        {0,0,0,0,0,1,0,0,0,2,2,2,2,2,2,2,1,2,3,3},
        {0,0,0,0,0,1,0,0,0,2,2,2,2,2,2,2,1,1,1,1},
        {0,0,0,0,0,1,0,0,0,2,2,2,2,2,2,2,1,2,3,3},
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

        /**
         * The following is a map for the characters;
         */
        MapOneCharacters = new int[][]{
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0},
        {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0},
        {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0},
        {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,1,1,1},
        {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0},
        {1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0},
        {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0},
        {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0},
        {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0},
        {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0},
        {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0},
        {0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0} };

        
    }
    
    public void paint(Graphics g)
    {   
        Image img0 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/LARose_sand.gif");//http://shop.advanceweb.com/images/swatches/LARose_sand.gif
        Image img1 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/pathway.gif");//http://www.keladimaju.com/App_Themes/green/images/pathway.gif
        Image img2 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/grass.gif");//http://us.sollitaire.com/gallery/albums/NES-Gifs/grass.gif
        Image img3 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/stronghold.gif");//http://www.mtgcardshop.com/mtg-images/Set_icons/stronghold.gif
        for(int i = 0; i < MapOne.length; i++) {	
        	for(int j = 0; j < MapOne[0].length; j++) {
        		if(MapOne[i][j] == 0) {
        			g.drawImage(img0, i*MapOne.length, j*MapOne[0].length, null);
        		} else if(MapOne[i][j] == 1) {
        			g.drawImage(img1, i*MapOne.length, j*MapOne[0].length, null);
        		} else if(MapOne[i][j] == 2) {
        			g.drawImage(img2, i*MapOne.length, j*MapOne[0].length, null);
        		} else if(MapOne[i][j] == 3) {
        			g.drawImage(img3, i*MapOne.length, j*MapOne[0].length, null);
        		}else{
        			System.err.println("should never happen!");
        		}
        	}
        }        			
    }

     /**
     * paintCharacters
     *
     * @param MapOne - this method paints the map for the characters placement
     */
    
    public void paintCharacter(Graphics g, int i, int j, int char_flag)
    {
        //image for the basic bad guy char_flag=1
        Image img1 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char1.gif");

        //images for the different levels of archers char_flag=2 ~ 6
        Image img2 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char2.gif");
        Image img3 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char3.gif");
        Image img4 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char4.gif");
        Image img5 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char5.gif");
        Image img6 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char6.gif");

        //images for the different levels of blue casters char_flag=7 ~ 11
        Image img7 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char7.gif");
        Image img8 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char8.gif");
        Image img9 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char9.gif");
        Image img10 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char10.gif");
        Image img11= Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char11.gif");

        //green casters char_flag=12 ~ 16
        Image img12 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char12.gif");
        Image img13 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char13.gif");
        Image img14 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char14.gif");
        Image img15 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char15.gif");
        Image img16= Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char16.gif");

        //images for different levels of redCaster char_flag=17 ~ 21
        Image img17 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char17.gif");
        Image img18 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char18.gif");
        Image img19 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char19.gif");
        Image img20 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char20.gif");
        Image img21 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char21.gif");

        //images for different levels of melee fighters char_flag=22 ~ 26
        Image img22 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char22.gif");
        Image img23 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char23.gif");
        Image img24 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char24.gif");
        Image img25 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char25.gif");
        Image img26 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char26.gif");

        //images for different levels of prophet char_flag=27 ~ 31
        Image img27 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char27.gif");
        Image img28 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char28.gif");
        Image img29 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char29.gif");
        Image img30 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char30.gif");
        Image img31 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char31.gif");

       
        		if(char_flag == 1) {
        			if(MapOne[i][j]==1)
        				g.drawImage(img1, i*MapOne.length, j*MapOne[0].length, null);
        		}

                  else if(char_flag == 2) {
                	if(MapOne[i][j]!=1)
                		g.drawImage(img2, i*MapOne.length, j*MapOne[0].length, null);
        		} else if(char_flag == 3) {
        			g.drawImage(img3, i*MapOne.length, j*MapOne[0].length, null);
                        }
                        else if(char_flag == 4) {
        			g.drawImage(img4, i*MapOne.length, j*MapOne[0].length, null);
        		} else if(char_flag == 5) {
        			g.drawImage(img5, i*MapOne.length, j*MapOne[0].length, null);
                        }
                        else if(char_flag == 6) {
        			g.drawImage(img6, i*MapOne.length, j*MapOne[0].length, null);
        		} else if(char_flag == 7) {
        			g.drawImage(img7, i*MapOne.length, j*MapOne[0].length, null);
                        }
                        else if(char_flag == 8) {
        			g.drawImage(img8, i*MapOne.length, j*MapOne[0].length, null);
        		} else if(char_flag == 9) {
        			g.drawImage(img9, i*MapOne.length, j*MapOne[0].length, null);
                        }
                        else if(char_flag == 10) {
        			g.drawImage(img10, i*MapOne.length, j*MapOne[0].length, null);
        		} else if(char_flag == 11) {
        			g.drawImage(img11, i*MapOne.length, j*MapOne[0].length, null);
                        }
                        else if(char_flag == 12) {
        			g.drawImage(img12, i*MapOne.length, j*MapOne[0].length, null);
        		} else if(char_flag == 13) {
        			g.drawImage(img13, i*MapOne.length, j*MapOne[0].length, null);
                        }
                        else if(char_flag == 14) {
        			g.drawImage(img14, i*MapOne.length, j*MapOne[0].length, null);
        		} else if(char_flag == 15) {
        			g.drawImage(img15, i*MapOne.length, j*MapOne[0].length, null);
                        }
                        else if(char_flag == 16) {
        			g.drawImage(img16, i*MapOne.length, j*MapOne[0].length, null);
        		} else if(char_flag == 17) {
        			g.drawImage(img17, i*MapOne.length, j*MapOne[0].length, null);
                        }
                        else if(char_flag == 18) {
        			g.drawImage(img18, i*MapOne.length, j*MapOne[0].length, null);
        		} else if(char_flag == 19) {
        			g.drawImage(img19, i*MapOne.length, j*MapOne[0].length, null);
                        }
                        else if(char_flag == 20) {
        			g.drawImage(img20, i*MapOne.length, j*MapOne[0].length, null);
        		} else if(char_flag == 21) {
        			g.drawImage(img21, i*MapOne.length, j*MapOne[0].length, null);
                        }
                        else if(char_flag == 22) {
        			g.drawImage(img22, i*MapOne.length, j*MapOne[0].length, null);
        		} else if(char_flag == 23) {
        			g.drawImage(img23, i*MapOne.length, j*MapOne[0].length, null);
                        }
                        else if(char_flag == 24) {
        			g.drawImage(img24, i*MapOne.length, j*MapOne[0].length, null);
        		} else if(char_flag == 25) {
        			g.drawImage(img25, i*MapOne.length, j*MapOne[0].length, null);
                        }
                        else if(char_flag == 26) {
        			g.drawImage(img26, i*MapOne.length, j*MapOne[0].length, null);
        		} else if(char_flag == 27) {
        			g.drawImage(img27, i*MapOne.length, j*MapOne[0].length, null);
                        }
                        else if(char_flag == 28) {
        			g.drawImage(img28, i*MapOne.length, j*MapOne[0].length, null);
        		} else if(char_flag == 29) {
        			g.drawImage(img29, i*MapOne.length, j*MapOne[0].length, null);
                        }
                        else if(char_flag == 30) {
        			g.drawImage(img30, i*MapOne.length, j*MapOne[0].length, null);
        		} else if(char_flag == 31) {
        			g.drawImage(img31, i*MapOne.length, j*MapOne[0].length, null);
                        }
                        else{
        			System.err.println("should never happen at characters!");
        		}

        	
        

    }
           
/*
This function returns an int value and places a flag number on the space selected.  It will return 1 if there was a sucesss in placing, 
and a 0 if not.  The flag number designates the level and unit
 */
    public int placeGoodGuy(int row, int column, int flag){
        if(MapOneCharacters[row][column] == 0){
        MapOneCharacters[row][column] = flag;
        return 1;
        }
        else
            return 0;
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
}
