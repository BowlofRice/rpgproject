
package example;


public class MapTwo {


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 *
 */


    public int[][] MapTwo;

    public MapTwo(){

        MapTwo = new int[20][20];
        int i = 0;
        for(i = 0; i < 20; i++)
        {
            for(int j = 0; j < 20; j++)
            {
                MapTwo[i][j] = 0;
            }
        }

        for(i=0;i<6;i++)
        {
         MapTwo[10][i] = 1;
        }

        for(i=2;i<5;i++)
        {
            MapTwo[2][i] = 1;
            MapTwo[4][i] = 1;

        }

        MapTwo[3][2] = 1;
        MapTwo[3][4] = 1;

        for(i = 4; i < 17 ; i++)
        {
            MapTwo[i][5] = 1;

        }

        for(i = 5; i < 17 ; i++)
        {

            MapTwo[16][i] = 1;
        }
        for(i = 7; i < 17 ; i++)
        {

            MapTwo[14][i] = 1;
        }
        for(i = 7; i < 17 ; i++)
        {

            MapTwo[12][i] = 1;
        }
        MapTwo[15][16] = 1;
        MapTwo[13][7] = 1;
        MapTwo[10][12] = 1;
        MapTwo[11][12] = 1;
        MapTwo[10][13] = 1;

        for(i=7;i<13;i++)
        {
            MapTwo[i][9] = 1;
            MapTwo[i][14] = 1;

        }

        for(i=14;i<20;i++)
        {
            MapTwo[7][i] = 1;
        }

        for(i=9;i<15;i++)
        {
            MapTwo[7][i] = 1;
        }


    }
/* This function returns an int value and places a flag number on the space selected.  It will return 1 if there was a sucess in placing, and a 0 if not.  The flag number designates the level and unit*/
    public int placeGoodGuy(int row, int column, int flag){
        if(MapTwo[row][column] == 0){
        MapTwo[row][column] = flag;
        return 1;
        }
        else
            return 0;
    }

    public void printMapTwo(){
        int i, j;
        for(i=0;i<20;i++)
        {
            for(j=0;j<20;j++)
            {

                System.out.print(MapTwo[i][j]+" ");
            }
            System.out.print("\n");


        }
    }

}
