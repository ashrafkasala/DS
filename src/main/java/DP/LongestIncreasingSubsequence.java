package DP;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {3,4,-1,0,6,2,3};
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[j] < nums[i])
                    dp[i] = Math.max(dp[i],1+dp[j]);
            }
        }
        int max =Integer.MIN_VALUE;

        for(int i=0;i<dp.length;i++){
            max= Math.max(max,dp[i]);
        }
        return max;
    }
}
