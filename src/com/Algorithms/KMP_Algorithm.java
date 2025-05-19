package com.Algorithms;

// Efficient substring search using prefix function.

public class KMP_Algorithm {
    public static void KMPSearch(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();

        int[] lps = computeLPSArray(pat);

        int i = 0; // index for txt
        int j = 0; // index for pat

        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++; j++;
            }
            if (j == M) {
                System.out.println("Pattern found at index " + (i - j));
                j = lps[j - 1];
            } else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }
    }

    public static int[] computeLPSArray(String pat) {
        int M = pat.length();
        int[] lps = new int[M];
        int len = 0;
        int i = 1;

        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0)
                    len = lps[len - 1];
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    public static void main(String[] args) {
        String txt = "abxabcabcaby";
        String pat = "abcaby";
        KMPSearch(pat, txt);
    }
}

