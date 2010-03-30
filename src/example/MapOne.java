package example;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andrew
 */
public class MapOne {

    int[][] MapOne;

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

