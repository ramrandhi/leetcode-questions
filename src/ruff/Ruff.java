package ruff;

import java.util.HashMap;
import java.util.Map;

public class Ruff {
    public static void main(String[] args) {
        String[] strs = {"eg","ab"};
        System.out.println(isIsomorphic(strs[0],strs[1]));
    }
    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for(int i = 0;i<s.length();i++) {
            map.put(s.charAt(i), t.charAt(i));
        }
        StringBuilder duplicate = new StringBuilder();
        for(int i=0;i<t.length();i++) {
            duplicate.append(map.get(s.charAt(i)));
        }
        if(duplicate.toString().equals(t)) {
            return true;
        } else {
            return false;
        }

    }
}
