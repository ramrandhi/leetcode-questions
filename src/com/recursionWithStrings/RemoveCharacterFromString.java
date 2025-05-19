package com.recursionWithStrings;

public class RemoveCharacterFromString {
    public static void main(String[] args) {
//        System.out.println(removeChracterFromString("baccad"));
        String processed = "";
        String unProcessed = "baccad";
        removeChracterFromString(unProcessed, processed);
    }
    static String removeChracterFromString(String unProcessed) {
        if(unProcessed.isEmpty()) {
            return "";
        }
        char ch = unProcessed.charAt(0);
        if (ch == 'a') {
            return removeChracterFromString(unProcessed.substring(1));
        } else {
            return ch + removeChracterFromString(unProcessed.substring(1));
        }
    }

    static void removeChracterFromString(String unProcessed, String processed) {
        if(unProcessed.isEmpty()) {
            System.out.println(processed);
            return;
        }
        char ch = unProcessed.charAt(0);
        if(ch == 'a') {
            removeChracterFromString(unProcessed.substring(1), processed);
        } else {
            removeChracterFromString(unProcessed.substring(1), processed + ch);
        }
    }
}
