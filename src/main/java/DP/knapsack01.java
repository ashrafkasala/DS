package DP;

import java.util.Arrays;

public class knapsack01 {

    public static void main(String[] args) {
        knapsack01 knapsack01 = new knapsack01();
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;//find max profit with threshold weight W
        int n = val.length;
        System.out.println(knapsack01.findMaxProfit(wt,val,W));
    }

     int findMaxProfit(int wt[],int val[], int W){
        int n = val.length;
        int dp[][] = new int[n+1][W+1];
        int include[] = new int[n];
        Arrays.fill(include,0);
         for (int[] row : dp)
             Arrays.fill(row, 0);
        for(int i=1;i<dp.length;i++){
            for(int j=1;j < dp[0].length;j++){
                if(j < wt[i-1]){
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],val[i-1] + dp[i-1][j-wt[i-1]]);
                }
            }
        }

        int n1 = n;
        int W1 = W;
        while(n1 >0 && W1 > 0){
            if(dp[n1][W1] == dp[n1-1][W1]){
                n1 = n1-1;
            } else {
                include[n1-1] = 1;
                W1 = W1 - wt[n1-1];
                n1 = n1-1;
            }
        }
        System.out.println(Arrays.toString(include));
        return dp[n][W];
     }

}
