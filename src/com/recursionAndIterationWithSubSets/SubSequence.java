package com.recursionAndIterationWithSubSets;

// we call sub sequence for string and subsets for arrays

public class SubSequence {
    public static void main(String[] args) {
        subSeq("", "abc");

//        sub sequene with ascii
//        subSeqWithAscii("", "abc");
    }
    static void subSeq(String processed, String unProcessed) {
        if(unProcessed.isEmpty()) {
            System.out.println(processed);
            return;
        }
        char ch = unProcessed.charAt(0);
        subSeq(processed + ch, unProcessed.substring(1));
        subSeq(processed, unProcessed.substring(1));
    }

    static void subSeqWithAscii(String processed, String unProcessed) {
        if(unProcessed.isEmpty()) {
            System.out.println(processed);
            return;
        }

        char ch = unProcessed.charAt(0);
        subSeqWithAscii(processed + ch, unProcessed.substring(1));
        subSeqWithAscii(processed, unProcessed.substring(1));
        subSeqWithAscii(processed + (ch+0), unProcessed.substring(1));
    }
}
