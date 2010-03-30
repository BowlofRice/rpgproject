package example;

public class MapThree {
    public int[][] MapThree;

    public MapThree(){

        MapThree = new int[20][20];
        int i;
        for(i = 0;i<7;i++)
        {
            MapThree[0][i] = 1;
        }

        for(i=0;i<20;i++)
        {
            MapThree[i][6]=1;
        }

        for(i=3;i<9;i++)
        {
            MapThree[i][8] =1;
        }
        MapThree[3][16] =1;
        MapThree[3][17] =1;
        MapThree[3][18] =1;
        MapThree[3][19] =1;
        MapThree[5][16]=1;
        MapThree[5][17]=1;
        MapThree[5][18]=1;
        MapThree[6][18]=1;
        MapThree[6][19]=1;

        for(i=6;i<16;i++)
        {
            MapThree[19][i] = 1;
            MapThree[16][i] =1;
            MapThree[13][i] =1;
        }

        for(i=15;i<20;i++)
        {
            MapThree[15][i] = 1;
            MapThree[18][i] =1;
        }

        for(i=8;i<20;i++)
        {
            MapThree[i][15]=1;
        }

        for(i=8;i<16;i++)
        {
            MapThree[8][i] = 1;
            MapThree[5][i] = 1;
            MapThree[3][i] =1;
        }







    }
/* This function returns an int value and places a flag number on the space selected.  It will return 1 if there was a sucess in placing, and a 0 if not.  The flag number designates the level and unit*/
    public int placeGoodGuy(int row, int column, int flag){
        if(MapThree[row][column] == 0){
        MapThree[row][column] = flag;
        return 1;
        }
        else
            return 0;
    }

    public void printMapThree(){
        int i, j;
        for(i=0;i<20;i++)
        {
            for(j=0;j<20;j++)
            {

                System.out.print(MapThree[i][j]+" ");
            }
            System.out.print("\n");


        }
    }

}
