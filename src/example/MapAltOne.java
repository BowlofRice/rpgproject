package example;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

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

    public MapAltOne(){
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
           
        /*BufferedImage image = ImageIO.read(____);
        int type = image.getType();
        if(type!=BufferedImage.TYPE_INT_ARGB)
        {
        	BufferedImage tempImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
        	Graphics g = tempImage.createGraphics();
        	g.drawImage(image, 0, 0, null);
        	g.dispose();
        	image = tempImage;
        }
        
        image.getRaster().getDataElements(0,0,MapOne.length,MapOne[0].length,MapOne); */
    }
/*
This function returns an int value and places a flag number on the space selected.  It will return 1 if there was a sucesss in placing, 
and a 0 if not.  The flag number designates the level and unit
    public int placeGoodGuy(int row, int column, int flag){
        if(MapOne[row][column] == 0){
        MapOne[row][column] = flag;
        return 1;
        }
        else
            return 0;
    } */
    
    public void drawInMapOne(int[][] matrix) {
    	int i = 0;
    	int j = 0;
        Graphics2D g1;
        Graphics2D g2;
        Graphics2D g3;
        Graphics2D g4;
        g1.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g3.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g4.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        // Draw squares.
        g1.setPaint(Color.blue);
        g2.setPaint(Color.red);
        g3.setPaint(Color.green);
        g4.setPaint(Color.pink);
        
    	for(i = 0; i < matrix.length; i++) {
    		for(j = 0; j < matrix[0].length; j++) {
    			if(matrix[i][j] == 0){
    				matrix[i][j].draw(g1);
    			} else if (matrix[i][j] == 1) {
    				matrix[i][j].draw(g2);
    			} else if (matrix[i][j] == 2) {
    				matrix[i][j].draw(g3);
    			} else if (matrix[i][j] == 3) {
    			    matrix[i][j].draw(g4);
    			}
    		}
    			
    	}
    }

    //Altered to fit my new schema
    public void printMapOne(int[][] matrix){
        int i, j;
        for(i = 0; i < matrix.length; i++)
        {
            for(j = 0;j < matrix[0].length;j++)
            {

                System.out.print(MapOne[i][j]+" ");
            }
            System.out.print("\n");


        }
    }
}
