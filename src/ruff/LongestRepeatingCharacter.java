package ruff;

public class LongestRepeatingCharacter {
    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 2));
    }

    public static int characterReplacement(String s, int k) {
        int left = 0, count = 0, longestLength = 0;
        for(int right = 0;right<s.length();right++) {
            if(s.charAt(left) != s.charAt(right)) {
                count++;
            }
            if(s.charAt(left) != s.charAt(right) && count > k) {
                left++;
            }
            if(count <= k) {
                longestLength = Math.max(longestLength, right-left+1);
            }

        }
        return longestLength;
    }
}
