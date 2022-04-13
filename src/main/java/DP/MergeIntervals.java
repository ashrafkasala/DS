package DP;

import java.util.Arrays;

public class MergeIntervals {
    public static void main(String[] args) {

    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        // Sort by ascending starting point
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        return  null;
    }


    public static int[][] merge2(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        // Sort by ascending starting point
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        return null;
    }
}
