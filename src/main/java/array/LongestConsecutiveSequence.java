package array;


import java.util.HashSet;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] nums = {100,200,1,2,3,4 ,43,1312,7,232,5,423,6};
        longestConsecutive(nums);
    }


    public static void longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums)
            set.add(num);


        int longestsequence = Integer.MIN_VALUE;
        int currCount = 1;

        for(int ele : set){

            if(!set.contains(ele -1)){//finding start of sequence
                while (set.contains(ele + 1)){
                    currCount++;
                    ele++;
                }

            }
            longestsequence = Math.max(longestsequence,currCount);
            currCount = 1;

        }

        System.out.println(longestsequence);

    }
}
