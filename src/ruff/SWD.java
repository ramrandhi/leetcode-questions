package ruff;

import java.util.HashMap;
import java.util.Map;

public class SWD {
    public static void main(String[] args) {
        String s = "abba";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int left = 0, windowSize = 0, counter = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(int right=0;right<s.length();right++) {
            if(map.containsKey(s.charAt(right))) {
                left = map.get(s.charAt(right)) + 1;
                while(counter < left) {
                    map.remove(s.charAt(counter));
                    counter++;
                }
            }
            windowSize = Math.max(windowSize, right-left + 1);
            map.put(s.charAt(right), right);
        }
        return windowSize;
    }
}
