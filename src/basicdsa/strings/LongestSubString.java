package basicdsa.strings;

public class LongestSubString {

    public static void main(String[] args) {
        String s = "aabbac";
        System.out.println(longestSubstring(s, 2));
    }

    public static int longestSubstring(String s, int k) {
        int maxLen = 0;

        for (int t = 1; t <= 26; t++) {
            int[] freq = new int[26];
            int start = 0, end = 0;
            int unique = 0, countAtLeastK = 0;

            while (end < s.length()) {
                if (unique <= t) {
                    int idx = s.charAt(end) - 'a';
                    if (freq[idx] == 0) unique++;
                    freq[idx]++;
                    if (freq[idx] == k) countAtLeastK++;
                    end++;
                } else {
                    int idx = s.charAt(start) - 'a';
                    if (freq[idx] == k) countAtLeastK--;
                    freq[idx]--;
                    if (freq[idx] == 0) unique--;
                    start++;
                }

                if (unique == t && unique == countAtLeastK) {
                    maxLen = Math.max(maxLen, end - start);
                }
            }
        }

        return maxLen;
    }

}
