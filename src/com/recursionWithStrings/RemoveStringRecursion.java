package com.recursionWithStrings;

public class RemoveStringRecursion {
    public static void main(String[] args) {
        String unprocessed = "iloveapplesinmyapplestore";
        // skip if apple
//        removeString(unprocessed, "", "apple");
        // only skip the app if there is only app but if apple not skip
        removeAppString(unprocessed, "", "app");
    }
    static void removeString(String unProcessed, String processed, String removedString) {
        if(unProcessed.isEmpty()) {
            System.out.println(processed);
            return;
        }
        if(unProcessed.startsWith(removedString)) {
            removeString(unProcessed.substring(removedString.length()), processed, removedString);
        } else {
            removeString(unProcessed.substring(1), processed+unProcessed.charAt(0), removedString);
        }
    }

    static void removeAppString(String up, String processed, String removingString) {
        if(up.isEmpty()) {
            System.out.println(processed);
            return;
        }
        if(up.startsWith(removingString) && !up.startsWith("apple")) {
            removeAppString(up.substring(3), processed, removingString);
        } else {
            removeAppString(up.substring(1), processed + up.charAt(0), removingString);
        }
    }
}
