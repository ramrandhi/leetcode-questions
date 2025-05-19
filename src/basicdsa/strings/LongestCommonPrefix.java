package basicdsa.strings;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(findLongestCommonPrefix(strs));
    }
    public static String findLongestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return ""; // Edge case: Empty array

        String prefix = strs[0]; // Start with the first string as the initial prefix

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1); // Reduce the prefix
                if (prefix.isEmpty()) return ""; // No common prefix found
            }
        }
        return prefix;
    }
}
