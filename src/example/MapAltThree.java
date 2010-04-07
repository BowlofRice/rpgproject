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
        
    }
    
    public void paint(Graphics g, int[][] matrix)
    {   
    	Image img0 = Toolkit.getDefaultToolkit().getImage("http://shop.advanceweb.com/images/swatches/LARose_sand.gif");
        Image img1 = Toolkit.getDefaultToolkit().getImage("http://www.keladimaju.com/App_Themes/green/images/pathway.gif");
        Image img2 = Toolkit.getDefaultToolkit().getImage("http://us.sollitaire.com/gallery/albums/NES-Gifs/grass.gif");
        Image img3 = Toolkit.getDefaultToolkit().getImage("http://www.mtgcardshop.com/mtg-images/Set_icons/stronghold.gif");
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