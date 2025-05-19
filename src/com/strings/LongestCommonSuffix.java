package com.strings;

public class LongestCommonSuffix {
    public static void main(String[] args) {
        String[] strs = {"flower","florer","fliger"};
        System.out.println(longestCommonSuffixes(strs));
    }
    static String longestCommonSuffixes(String[] strs) {
        if(strs == null && strs.length == 0) {
            return "";
        }
        String suffix = strs[0];
        for(int i=1;i<strs.length;i++) {
            while(!strs[i].endsWith(suffix)) {
                suffix = suffix.substring(1);
                if(suffix.isEmpty()) return "";
            }
        }
        return suffix;
    }
}
