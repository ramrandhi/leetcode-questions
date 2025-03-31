package com.strings;

/*

✅ trim() only removes ASCII spaces (U+0020).
✅ strip() removes most Unicode spaces, but not zero-width spaces (\u200B).
✅ Use regex (\p{Z}|\u200B) to remove all Unicode spaces.

 */

public class TrimVsStrip {
    public static void main(String[] args) {
//        String s = "\u00A0\u3000 Java is fun! \u200B";  // Contains Unicode spaces
//
//        System.out.println("Original: [" + s + "]");
//        System.out.println("trim(): [" + s.trim() + "]");  // May not remove all Unicode spaces
//        System.out.println("strip(): [" + s.strip() + "]"); // Removes all Unicode spaces

        String s = "\u00A0\u3000 Java is fun! \u200B";  // Contains Unicode spaces

        System.out.println("Original: [" + s + "]");
        System.out.println("trim(): [" + s.trim() + "]");
        System.out.println("strip(): [" + s.strip() + "]");

        // Print Unicode codes of each character
        System.out.println("\nUnicode code points:");
        for (char c : s.toCharArray()) {
            System.out.println("Char: [" + c + "] - Unicode: " + Integer.toHexString(c));
        }
    }
}
