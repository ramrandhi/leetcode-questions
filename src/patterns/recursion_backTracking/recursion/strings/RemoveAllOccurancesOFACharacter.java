package patterns.recursion_backTracking.recursion.strings;

public class RemoveAllOccurancesOFACharacter {
    public static void main(String[] args) {
        String s = "baccad";
        System.out.println(skip(s));
    }

    static String removeAllOccurancesOFACharacter(String s) {
        if(s.isEmpty()) return "";
        return helper(s, new StringBuilder(), 0);
    }

    static String helper(String s, StringBuilder str, int index) {
        if(index == s.length()) return str.toString();
        if(s.charAt(index) == 'a') {
            return helper(s, str, index + 1);
        }
        return helper(s, str.append(s.charAt(index)), index + 1);
    }

    // another approach

    static String skip(String s) {
        if(s.isEmpty()) return "";
        char ch = s.charAt(0);
        if(ch == 'a') {
            return skip(s.substring(1));
        }
        return ch + skip(s.substring(1));
    }
}
