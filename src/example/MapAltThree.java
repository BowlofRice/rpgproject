package example;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Testing out an idea, I had by using Andrew's Map One as
 * a spring board
 */

public class MapAltThree {

    public int[][] MapThree;
    public int[][] MapThreeCharacters;

    public MapAltThree(){
    	
        //A lengthy predefined map to use
    	//0 -- Sand
    	//1 -- Path
    	//2 -- Different Kind of Sand / Grass
    	//3 -- Castle Walls
        MapThree = new int[][] {
        {1,1,1,1,0,0,0,0,0,2,2,2,2,2,2,2,2,2,2,2},
        {0,0,0,1,0,0,0,0,0,2,2,2,2,2,2,2,2,2,2,2},
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
        {0,0,0,1,0,0,0,0,0,2,2,2,2,2,2,2,2,2,2,2},
        {1,1,1,1,0,0,0,0,0,2,2,2,2,2,2,2,2,2,2,2} };

        MapThreeCharacters = new int[][]{
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};

        
    }
    
    public void paint(Graphics g, int[][] matrix)
    {   
    	Image img0 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/LARose_sand.gif");
        Image img1 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/pathway.gif");
        Image img2 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/grass.gif");
        Image img3 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/stronghold.gif");
        for(int i = 0; i < matrix.length; i++) {
        	for(int j = 0; j < matrix[0].length; j++) {
        		if(matrix[i][j] == 0) {
        			g.drawImage(img0, i*matrix.length, j*matrix[0].length, (ImageObserver) this);
        		} else if(matrix[i][j] == 1) {
        			g.drawImage(img1, i*matrix.length, j*matrix[0].length, (ImageObserver) this);
        		} else if(matrix[i][j] == 2) {
        			g.drawImage(img2, i*matrix.length, j*matrix[0].length, (ImageObserver) this);
        		} else if(matrix[i][j] == 3) {
        			g.drawImage(img3, i*matrix.length, j*matrix[0].length, (ImageObserver) this);
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
     * @param matrix - this method paints the map for the characters placement
     */

    public void paintCharacter(Graphics g, int[][] matrix)
    {
        //image for the basic bad guy
        Image img1 = Toolkit.getDefaultToolkit().getImage("");

        //images for the different levels of archers
        Image img2 = Toolkit.getDefaultToolkit().getImage("");
        Image img3 = Toolkit.getDefaultToolkit().getImage("");
        Image img4 = Toolkit.getDefaultToolkit().getImage("");
        Image img5 = Toolkit.getDefaultToolkit().getImage("");
        Image img6 = Toolkit.getDefaultToolkit().getImage("");

        //images for the different levels of blue casters
        Image img7 = Toolkit.getDefaultToolkit().getImage("");
        Image img8 = Toolkit.getDefaultToolkit().getImage("");
        Image img9 = Toolkit.getDefaultToolkit().getImage("");
        Image img10 = Toolkit.getDefaultToolkit().getImage("");
        Image img11= Toolkit.getDefaultToolkit().getImage("");

        //green casters
        Image img12 = Toolkit.getDefaultToolkit().getImage("");
        Image img13 = Toolkit.getDefaultToolkit().getImage("");
        Image img14 = Toolkit.getDefaultToolkit().getImage("");
        Image img15 = Toolkit.getDefaultToolkit().getImage("");
        Image img16= Toolkit.getDefaultToolkit().getImage("");

        //images for different levels of redCaster
        Image img17 = Toolkit.getDefaultToolkit().getImage("");
        Image img18 = Toolkit.getDefaultToolkit().getImage("");
        Image img19 = Toolkit.getDefaultToolkit().getImage("");
        Image img20 = Toolkit.getDefaultToolkit().getImage("");
        Image img21 = Toolkit.getDefaultToolkit().getImage("");

        //images for different levels of melee fighters
        Image img22 = Toolkit.getDefaultToolkit().getImage("");
        Image img23 = Toolkit.getDefaultToolkit().getImage("");
        Image img24 = Toolkit.getDefaultToolkit().getImage("");
        Image img25 = Toolkit.getDefaultToolkit().getImage("");
        Image img26 = Toolkit.getDefaultToolkit().getImage("");

        //images for different levels of prophet
        Image img27 = Toolkit.getDefaultToolkit().getImage("");
        Image img28 = Toolkit.getDefaultToolkit().getImage("");
        Image img29 = Toolkit.getDefaultToolkit().getImage("");
        Image img30 = Toolkit.getDefaultToolkit().getImage("");
        Image img31 = Toolkit.getDefaultToolkit().getImage("");

        for(int i = 0; i < matrix.length; i++) {
        	for(int j = 0; j < matrix[0].length; j++) {
        		if(matrix[i][j] == 1) {
        			g.drawImage(img1, i*matrix.length, j*matrix[0].length, (ImageObserver) this);
        		}

                        else if(matrix[i][j] == 2) {
        			g.drawImage(img2, i*matrix.length, j*matrix[0].length, (ImageObserver) this);
        		} else if(matrix[i][j] == 3) {
        			g.drawImage(img3, i*matrix.length, j*matrix[0].length, (ImageObserver) this);
                        }
                        else if(matrix[i][j] == 4) {
        			g.drawImage(img4, i*matrix.length, j*matrix[0].length, (ImageObserver) this);
        		} else if(matrix[i][j] == 5) {
        			g.drawImage(img5, i*matrix.length, j*matrix[0].length, (ImageObserver) this);
                        }
                        else if(matrix[i][j] == 6) {
        			g.drawImage(img6, i*matrix.length, j*matrix[0].length, (ImageObserver) this);
        		} else if(matrix[i][j] == 7) {
        			g.drawImage(img7, i*matrix.length, j*matrix[0].length, (ImageObserver) this);
                        }
                        else if(matrix[i][j] == 8) {
        			g.drawImage(img8, i*matrix.length, j*matrix[0].length, (ImageObserver) this);
        		} else if(matrix[i][j] == 9) {
        			g.drawImage(img9, i*matrix.length, j*matrix[0].length, (ImageObserver) this);
                        }
                        else if(matrix[i][j] == 10) {
        			g.drawImage(img10, i*matrix.length, j*matrix[0].length, (ImageObserver) this);
        		} else if(matrix[i][j] == 11) {
        			g.drawImage(img11, i*matrix.length, j*matrix[0].length, (ImageObserver) this);
                        }
                        else if(matrix[i][j] == 12) {
        			g.drawImage(img12, i*matrix.length, j*matrix[0].length, (ImageObserver) this);
        		} else if(matrix[i][j] == 13) {
        			g.drawImage(img13, i*matrix.length, j*matrix[0].length, (ImageObserver) this);
                        }
                        else if(matrix[i][j] == 14) {
        			g.drawImage(img14, i*matrix.length, j*matrix[0].length, (ImageObserver) this);
        		} else if(matrix[i][j] == 15) {
        			g.drawImage(img15, i*matrix.length, j*matrix[0].length, (ImageObserver) this);
                        }
                        else if(matrix[i][j] == 16) {
        			g.drawImage(img16, i*matrix.length, j*matrix[0].length, (ImageObserver) this);
        		} else if(matrix[i][j] == 17) {
        			g.drawImage(img17, i*matrix.length, j*matrix[0].length, (ImageObserver) this);
                        }
                        else if(matrix[i][j] == 18) {
        			g.drawImage(img18, i*matrix.length, j*matrix[0].length, (ImageObserver) this);
        		} else if(matrix[i][j] == 19) {
        			g.drawImage(img19, i*matrix.length, j*matrix[0].length, (ImageObserver) this);
                        }
                        else if(matrix[i][j] == 20) {
        			g.drawImage(img20, i*matrix.length, j*matrix[0].length, (ImageObserver) this);
        		} else if(matrix[i][j] == 21) {
        			g.drawImage(img21, i*matrix.length, j*matrix[0].length, (ImageObserver) this);
                        }
                        else if(matrix[i][j] == 22) {
        			g.drawImage(img22, i*matrix.length, j*matrix[0].length, (ImageObserver) this);
        		} else if(matrix[i][j] == 23) {
        			g.drawImage(img23, i*matrix.length, j*matrix[0].length, (ImageObserver) this);
                        }
                        else if(matrix[i][j] == 24) {
        			g.drawImage(img24, i*matrix.length, j*matrix[0].length, (ImageObserver) this);
        		} else if(matrix[i][j] == 25) {
        			g.drawImage(img25, i*matrix.length, j*matrix[0].length, (ImageObserver) this);
                        }
                        else if(matrix[i][j] == 26) {
        			g.drawImage(img26, i*matrix.length, j*matrix[0].length, (ImageObserver) this);
        		} else if(matrix[i][j] == 27) {
        			g.drawImage(img27, i*matrix.length, j*matrix[0].length, (ImageObserver) this);
                        }
                        else if(matrix[i][j] == 28) {
        			g.drawImage(img28, i*matrix.length, j*matrix[0].length, (ImageObserver) this);
        		} else if(matrix[i][j] == 29) {
        			g.drawImage(img29, i*matrix.length, j*matrix[0].length, (ImageObserver) this);
                        }
                        else if(matrix[i][j] == 30) {
        			g.drawImage(img30, i*matrix.length, j*matrix[0].length, (ImageObserver) this);
        		} else if(matrix[i][j] == 31) {
        			g.drawImage(img31, i*matrix.length, j*matrix[0].length, (ImageObserver) this);
                        }
                        else{
        			System.err.println("should never happen!");
        		}

        	}
        }

    }
/*
This function returns an int value and places a flag number on the space selected.  It will return 1 if there was a sucesss in placing, 
and a 0 if not.  The flag number designates the level and unit
    public int placeGoodGuy(int row, int column, int flag){
        if(MapThree[row][column] == 0){
        MapThree[row][column] = flag;
        return 1;
        }
        else
            return 0;
    } */
    

    //Altered to fit my new schema
    public void printMapThree(int[][] matrix){
        int i, j;
        for(i = 0; i < matrix.length; i++)
        {
            for(j = 0;j < matrix[0].length;j++)
            {

                System.out.print(matrix[i][j]+" ");
            }
            System.out.print("\n");


        }
    }
}