/**Map Stuff.java
 *
 *
 * @author 
 * @version 1.00 2010/4/13
 */
import.java.util.Random;


public class Map Stuff {

    public Map Stuff() {
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
    		
    	MapTraversalOne = new int[][] {
    		{   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0},        
    		{   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0},        
    		{   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0},       
    		{   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0},      
    		{   0,   0,   0,   0,   0,2200,2300,2400,2500,2600,2700,2800,2900,3000,3100,3200,3300,   0,   0,   0},     
    		{   0,   0,   0,   0,   0,2100,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,3400,   0,   0,   0},     
    		{   0,   0,   0,   0,   0,2000,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,3500,   0,   0,   0},   
    		{   0,   0,   0,   0,   0,1900,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,4000,4100,4200,5000},   
    		{   0,   0,   0,   0,   0,1800,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,3900,   0,   0,   0},     
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
    	}}
    		
    	//place enemy units to begin at arr[i][j] = 1000 ****starting position****
    	/* check arr[i][j--], arr[i][j++], arr[i--][j], arr[i--][j++], arr[i--][j--], arr[i++][j], arr[i++][j--], arr[i++][j++]
    	   for a value greater than arr[i][j] */
    	// If multiple values are greater than current position value, use a randomizer to decide pathway
    	//remove units that arrive at arr[i][j] = 5000 ****goal****
    	
   
    	void moveEnemy(Graphics g, Matrix[i][j])
    	{
    	   Image img1 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/pathway.gif");
    	   Image img0 = Toolkit.getDefaultToolkit().getImage("../rpgproject/src/example/tiles/char1.gif");
    	   while(Matrix[i][j]>0)
    	   {   
    		    if(Matrix[i][j] < Matrix[i][j+1])
    		    {
    		        g.drawImage(img1, i*matrix.length, j*matrix[0].length, null/*(ImageObserver) this*/);
    		        g.drawImage(img0, i*matrix.length, (j+1)*matrix[0].length, null);
                    Matrix[i][j] = Matrix[i][j+1];
    		    } else if(Matrix[i][j] < Matrix[i+1][j]) {
                	g.drawImage(img1, i*matrix.length, j*matrix[0].length, null/*(ImageObserver) this*/);
                	g.drawImage(img0, (i+1)*matrix.length, j*matrix[0].length, null);
                    Matrix[i][j] = Matrix[i+1][j];
    		    } else if(Matrix[i][j] < Matrix[i][j-1]) {
                	g.drawImage(img1, i*matrix.length, j*matrix[0].length, null/*(ImageObserver) this*/);
                	g.drawImage(img0, i*matrix.length, (j-1)*matrix[0].length, null);
                    Matrix[i][j] = Matrix[i][j-1];
    		    } else if(Matrix[i][j] < Matrix[i-1][j]) {
                	g.drawImage(img1, i*matrix.length, j*matrix[0].length, null/*(ImageObserver) this*/);
                	g.drawImage(img0, (i-1)*matrix.length, j*matrix[0].length, null);
                    Matrix[i][j] = Matrix[i-1][j];
    		    } else if(Matrix[i][j] < Matrix[i][j+1] && Matrix[i][j] < Matrix[i+1][j]) {
                	Random r = new Random();
                	int randNum = r.nextInt(10);
                	if(0 <= randNum <= 5) {
                	       g.drawImage(img1, i*matrix.length, j*matrix[0].length, null/*(ImageObserver) this*/);
                	       g.drawImage(img0, i*matrix.length, (j+1)*matrix[0].length, null);
                           Matrix[i][j] = Matrix[i][j+1];
                	} else {
                           g.drawImage(img1, i*matrix.length, j*matrix[0].length, null/*(ImageObserver) this*/);
                           g.drawImage(img0, (i+1)*matrix.length, j*matrix[0].length, null);
                           Matrix[i][j] = Matrix[i+1][j]; }
    		    } else if(Matrix[i][j] < Matrix[i][j+1] && Matrix[i][j] < Matrix[i][j-1]) {
                	Random r = new Random();
                	int randNum = r.nextInt(10);
                	if(0 <= randNum <= 5) {
                	       g.drawImage(img1, i*matrix.length, j*matrix[0].length, null/*(ImageObserver) this*/);
                	       g.drawImage(img0, i*matrix.length, (j+1)*matrix[0].length, null);
                           Matrix[i][j] = Matrix[i][j+1];
                	} else {
                        	g.drawImage(img1, i*matrix.length, j*matrix[0].length, null/*(ImageObserver) this*/);
                        	g.drawImage(img0, i*matrix.length, (j-1)*matrix[0].length, null);
                            Matrix[i][j] = Matrix[i][j-1]; }
    		    } else if(Matrix[i][j] < Matrix[i][j+1] && Matrix[i][j] < Matrix[i-1][j]) {
                	Random r = new Random();
                	int randNum = r.nextInt(10);
                	if(0 <= randNum <= 5) {
                	       g.drawImage(img1, i*matrix.length, j*matrix[0].length, null/*(ImageObserver) this*/);
                	       g.drawImage(img0, i*matrix.length, (j+1)*matrix[0].length, null);
                           Matrix[i][j] = Matrix[i][j+1];
                	} else {
                        	g.drawImage(img1, i*matrix.length, j*matrix[0].length, null/*(ImageObserver) this*/);
                        	g.drawImage(img0, (i-1)*matrix.length, j*matrix[0].length, null);
                            Matrix[i][j] = Matrix[i-1][j]; }
    		    } else if(Matrix[i][j] < Matrix[i+1][j] && Matrix[i][j] < Matrix[i][j-1]) {
                	Random r = new Random();
                	int randNum = r.nextInt(10);
                	if(0 <= randNum <= 5) {
                	       g.drawImage(img1, i*matrix.length, j*matrix[0].length, null/*(ImageObserver) this*/);
                	       g.drawImage(img0, (i+1)*matrix.length, j*matrix[0].length, null);
                           Matrix[i][j] = Matrix[i+1][j];
                	} else {
                        	g.drawImage(img1, i*matrix.length, j*matrix[0].length, null/*(ImageObserver) this*/);
                        	g.drawImage(img0, i*matrix.length, (j-1)*matrix[0].length, null);
                            Matrix[i][j] = Matrix[i][j-1]; }
    		    } else if(Matrix[i][j] < Matrix[i+1][j] && Matrix[i][j] < Matrix[i-1][j]) {
                	Random r = new Random();
                	int randNum = r.nextInt(10);
                	if(0 <= randNum <= 5) {
                	       g.drawImage(img1, i*matrix.length, j*matrix[0].length, null/*(ImageObserver) this*/);
                	       g.drawImage(img0, (i+1)*matrix.length, j*matrix[0].length, null);
                           Matrix[i][j] = Matrix[i+1][j];
                	} else {
                        	g.drawImage(img1, i*matrix.length, j*matrix[0].length, null/*(ImageObserver) this*/);
                        	g.drawImage(img0, (i-1)*matrix.length, j*matrix[0].length, null);
                            Matrix[i][j] = Matrix[i-1][j]; }
    		    } else if(Matrix[i][j] < Matrix[i][j-1] && Matrix[i][j] < Matrix[i-1][j]) {
                	Random r = new Random();
                	int randNum = r.nextInt(10);
                	if(0 <= randNum <= 5) {
                	       g.drawImage(img1, i*matrix.length, j*matrix[0].length, null/*(ImageObserver) this*/);
                	       g.drawImage(img0, i*matrix.length, (j-1)*matrix[0].length, null);
                           Matrix[i][j] = Matrix[i][j-1];
                	} else {
                        	g.drawImage(img1, i*matrix.length, j*matrix[0].length, null/*(ImageObserver) this*/);
                        	g.drawImage(img0, (i-1)*matrix.length, j*matrix[0].length, null);
                            Matrix[i][j] = Matrix[i-1][j];
                }} else {
                	System.out.println("Oh, snap, we stuck!"); 	
                }
    	}
               
    }
  
