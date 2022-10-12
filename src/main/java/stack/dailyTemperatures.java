package stack;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class dailyTemperatures {

    public static void main(String[] args) {
        dailyTemperatures dailyTemperatures = new dailyTemperatures();
        int[]  temperatures = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures.dailyTemperatures(temperatures)));
    }

    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> stack = new Stack<>();
        int[] res =new int[temperatures.length];
        for(int i=0 ;i<temperatures.length;i++){

            while (!stack.isEmpty() && temperatures[i] >temperatures[stack.peek()]){
                int index =  stack.pop();
                res[index] = i-index;
            }
            stack.push(i);

        }
        return res;

    }
}
