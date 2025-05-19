package ruff;

import java.util.Arrays;

public class AnagramStrings {
    public static void main(String[] args) {
        String ag = "anagram";
        String gaa = "margaan";
        char[] ct = ag.toCharArray();
        char[] ca = gaa.toCharArray();
        Arrays.sort(ct);
        Arrays.sort(ca);
        System.out.println(Arrays.equals(ct, ca));
    }
}