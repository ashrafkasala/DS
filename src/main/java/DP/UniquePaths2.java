package DP;

import java.util.Arrays;

public class UniquePaths2 {
    public static void main(String[] args) {
        int[][] obstacleGrid2 = {
                {0, 0, 0},
                {0, 1, 0},
                {0,0,0},
        };
        int[][] obstacleGrid = {
                {0, 1},
                {0, 0}

        };
        System.out.println(uniquePaths2(obstacleGrid));

    }
    public static int uniquePaths2(int[][] obstacleGrid) {

//mark obstacle as -1
        for(int i=0;i<obstacleGrid.length;i++){
            for(int j=0;j<obstacleGrid[i].length;j++){
                if(obstacleGrid[i][j] == 1)
                obstacleGrid[i][j] = -1;
            }
        }

        for(int i=1;i<obstacleGrid.length;i++){
            if(obstacleGrid[i][0] == -1)
                continue;
            if(obstacleGrid[i-1][0] ==-1)
            obstacleGrid[i][0] = -1;
            else
                obstacleGrid[i][0] = 1;


        }
        for(int i=1;i<obstacleGrid[0].length;i++){
            if(obstacleGrid[0][i] == -1)
                continue;
            if(obstacleGrid[0][i-1] ==-1)
                obstacleGrid[0][i] = -1;
            else
                obstacleGrid[0][i] = 1;
        }
        for(int i=1;i<obstacleGrid.length;i++){
            for(int j=1;j<obstacleGrid[i].length;j++){
                //boundary conditions
                if(obstacleGrid[i][j] == -1)
                    continue;
                if(obstacleGrid[i-1][j] != -1)
                obstacleGrid[i][j] += obstacleGrid[i-1][j];
                if(obstacleGrid[i][j-1] != -1)
                obstacleGrid[i][j] += obstacleGrid[i][j-1];
            }
        }
        return obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}
