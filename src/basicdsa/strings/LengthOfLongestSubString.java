package basicdsa.strings;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubString {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int left = 0;
        int maxLength = 0;
        Set<Character> set = new HashSet<>();
        for(int right=0; right<s.length();right++) {
            while(set.contains(s.charAt(right))) {
                set.remove(s.charAt(right));
                left++;
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        System.out.println(maxLength);
        System.out.println(set);
    }
}
