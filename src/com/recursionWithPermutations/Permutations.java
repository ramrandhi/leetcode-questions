package com.recursionWithPermutations;

public class Permutations {
    public static void main(String[] args) {
        permute("","abc");
    }
    static void permute(String processed, String unProcessed) {
        if(unProcessed.isEmpty()) {
            System.out.println(processed);
            return;
        }
        char ch = unProcessed.charAt(0);
        for(int i=0;i<= processed.length(); i++) {
            String first = processed.substring(0,i);
            String second = processed.substring(i);
            permute(first+ch+second, unProcessed.substring(1));
        }
    }

//    permute("", "abc")
//|
//        └── permute("a", "bc")
//            |
//            ├── permute("ba", "c")
//            |   |
//            |   ├── permute("cba", "") → print "cba"
//            |   ├── permute("bca", "") → print "bca"
//            |   └── permute("bac", "") → print "bac"
//            |
//            └── permute("ab", "c")
//                |
//                ├── permute("cab", "") → print "cab"
//                ├── permute("acb", "") → print "acb"
//                └── permute("abc", "") → print "abc"

}
