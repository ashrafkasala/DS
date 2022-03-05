package DP;

import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3,2));
    }

    public static int uniquePaths(int m, int n) {

        int[][] uniuepathsArr = new int[m][n];

        for (int[] row: uniuepathsArr)
            Arrays.fill(row, 0);

        //initailize first row and first column with 1

        for(int i=0;i<uniuepathsArr.length;i++){
            uniuepathsArr[i][0] = 1;
        }
        for(int i=0;i<uniuepathsArr[0].length;i++){
            uniuepathsArr[0][i] = 1;
        }
        for(int i=1;i<uniuepathsArr.length;i++){
            for(int j=1;j<uniuepathsArr[i].length;j++){
                //boundary conditions
                    uniuepathsArr[i][j] += uniuepathsArr[i-1][j];
                    uniuepathsArr[i][j] += uniuepathsArr[i][j-1];
            }
        }
        return uniuepathsArr[m-1][n-1];
    }
}
