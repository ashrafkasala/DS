package array;

import java.math.BigDecimal;
import java.util.Arrays;

public class Stringremove {
    public static void main(String[] args) {




            // create a BigDecimal object
            BigDecimal bg;

            // create a String object
            String sr;

            bg = new BigDecimal("1E+4");

            // assign the string value of bg to s
            sr = bg.toString();

            String str = "12123.0";

            // print s value
            System.out.println(String.valueOf(Double.parseDouble("1e+5")) );
        System.out.println(str.replaceAll(".0","") );


        String s = "aaabbbcccdddeerrr";
        int[] freq = new int[26];
        Arrays.fill(freq, 0);
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        int current;
        int invalidCount = 0;
        Arrays.sort(freq);
        int prev=-1;
        int misFreqElement = -1;
        int prevCount=0,currentCount = 0;
        boolean invalid = false;
        for (int i = 0; i < freq.length; i++) {
            current = freq[i];
            if (freq[i] == 0) {
                prev = freq[i + 1];
                continue;
            }

            if (Math.abs(current - prev) > 1 || invalidCount > 1) {
                System.out.println("Invalid String");
                invalid = true;
                break;
            }
            if (current != prev) {
                prevCount = currentCount;
                if(prevCount > 1 && i+1<freq.length && current == freq[i+1]){
                    System.out.println("Invalid String");
                    invalid = true;
                    break;
                }
                currentCount = 0;
                invalidCount++;
            }
            currentCount++;
            prev = current;
        }

//        if (invalidCount > 1 && misFreqElement == 1) {
//            System.out.println("valid String");
//        } else if (invalidCount ) {
//            System.out.println("valid String");
//        }

        if (!invalid ) {
            System.out.println("valid String");
        }
    }
}
