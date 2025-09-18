package patterns.recursion_backTracking.permutations;

import java.util.ArrayList;
import java.util.List;

public class PermutationStrings {
    public static void main(String[] args) {
//        permutationString("abc", "");
        System.out.println(permutationString2("abc", ""));
//        System.out.println(countPermutations("abijdfgllc", ""));
    }
    static void permutationString(String unProcessed, String processed) {
        if(unProcessed.isEmpty()) {
            System.out.println(processed);
            return;
        }
        char ch = unProcessed.charAt(0);
        for(int i = 0;i<=processed.length();i++) {
            String first = processed.substring(0, i);
            String second = processed.substring(i, processed.length());
            permutationString(unProcessed.substring(1), first + ch + second);
        }
    }

    static List<String> permutationString2(String unProcessed, String processed) {
        if(unProcessed.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        char ch = unProcessed.charAt(0);
        List<String> listData = new ArrayList<>();
        for(int i= 0;i<= processed.length();i++) {
            String first = processed.substring(0, i);
            String second = processed.substring(i, processed.length());
            listData.addAll(permutationString2(unProcessed.substring(1), first + ch + second));
        }
        return listData;
    }

    static int countPermutations(String unProcessed, String processed) {
        if(unProcessed.isEmpty()) return 1;
        char ch = unProcessed.charAt(0);
        int count = 0;
        for(int i = 0;i<=processed.length();i++) {
            String first = processed.substring(0, i);
            String second = processed.substring(i);
            count = count + countPermutations(unProcessed.substring(1), first + ch + second);
        }
        return count;
    }
}
