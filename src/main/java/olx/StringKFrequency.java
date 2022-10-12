package olx;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.PriorityQueue;

public class StringKFrequency {
    public static void main(String[] args) {
        String s= "aabbccdd";
//        String s = "dwd";
        System.out.println(getMinSteps(s));
    }

    public static int getMinSteps(String s) {
        if (StringUtils.isEmpty(s)) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (char c : map.keySet()) {
            queue.offer(map.get(c));
        }

        int minDeletes = 0;
        int prev = -1;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == prev) {
                minDeletes++;
                if (current - 1 != 0)
                queue.offer(current - 1);
            }
            prev = current;
        }
        return minDeletes;
    }
}
