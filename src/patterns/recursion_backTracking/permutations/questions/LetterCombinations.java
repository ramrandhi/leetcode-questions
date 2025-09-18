package patterns.recursion_backTracking.permutations.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    static Map<Character, String> staticMap = new HashMap<>();
    static {
        staticMap.put('2', "abc");
        staticMap.put('3', "def");
        staticMap.put('4', "ghi");
        staticMap.put('5', "jkl");
        staticMap.put('6', "mno");
        staticMap.put('7', "pqrs");
        staticMap.put('8', "tuv");
        staticMap.put('9', "wxyz");
    }
    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if(digits.isEmpty()) return list;
        helper("", digits, list);
        return list;
    }

    private static void helper(String processed, String unProcessed, List<String> result) {
        if(unProcessed.isEmpty()) {
            result.add(processed);
            return;
        }
        char ch = unProcessed.charAt(0);
        String s = staticMap.get(ch);
        for(char c: s.toCharArray()) {
            helper(processed + c, unProcessed.substring(1), result);
        }
    }
}
