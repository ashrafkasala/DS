package DP;

import java.util.Stack;

public class longestvalidParanthesis {
    public static void main(String ...args){

       String s = "()(()";
       int len = s.length();
       int longest = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0;i<s.length();i++){
         //open
            if(s.charAt(i) == '('){
                stack.push(i);
            } else if(s.charAt(i) == ')'){
                if(!stack.empty()) {
                    if (s.charAt(stack.peek()) == '(') {
                        stack.pop();
                    } else {
                        stack.push(i);
                    }
                } else {
                    stack.push(i);
                }
            }
        }

        if(stack.isEmpty())
            longest= len;
        else {
            int previndex = len;
            int currIndex = 0;
            while (!stack.isEmpty()){
                currIndex = stack.pop();
                longest =Math.max(longest,previndex-currIndex-1);
                previndex = currIndex;
            }
            longest =Math.max(longest,previndex);
        }


        System.out.println(longest);


    }

}
