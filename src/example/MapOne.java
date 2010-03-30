package example;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * 
 */
public class MapOne {

    public int[][] MapOne;

    public MapOne(){

        MapOne = new int[20][20];
        int i = 0;
        for(i = 0; i < 20; i++)
        {
            for(int j = 0; j < 20; j++)
            {
                MapOne[i][j] = 0;
            }
        }

        for(i=0;i<6;i++)
        {
         MapOne[10][i] = 1;
        }

        for(i = 4; i < 17 ; i++)
        {
            MapOne[i][5] = 1;
            MapOne[i][16] = 1;
        }

        for(i = 5; i < 17 ; i++)
        {
            MapOne[4][i] = 1;
            MapOne[16][i] = 1;
        }

        for(i = 16 ; i < 20 ; i++)
        {
            MapOne[7][i] = 1;
        }




    }
/* This function returns an int value and places a flag number on the space selected.  It will return 1 if there was a sucess in placing, and a 0 if not.  The flag number designates the level and unit*/
    public int placeGoodGuy(int row, int column, int flag){
        if(MapOne[row][column] == 0){
        MapOne[row][column] = flag;
        return 1;
        }
        else
            return 0;
    }

    public void printMapOne(){
        int i, j;
        for(i=0;i<20;i++)
        {
            for(j=0;j<20;j++)
            {

                System.out.print(MapOne[i][j]+" ");
            }
            System.out.print("\n");


        }
    }

}

