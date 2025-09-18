package patterns.recursion_backTracking.subSets_subSequence.subsequence;

import java.util.ArrayList;
import java.util.List;

public class subSeq1 {
    public static void main(String[] args) {
//        System.out.println(subSeq("", "abc", new ArrayList<>()));
        System.out.println(subSeq2("", "abc"));
    }

    // recursion #1
    private static List<String> subSeq(String processed, String unProcessed, List<String> subseq) {
        if(unProcessed.isEmpty()) {
            subseq.add(processed);
            return subseq;
        }
        char ch = unProcessed.charAt(0);
        subSeq(processed + ch, unProcessed.substring(1), subseq);
        subSeq(processed, unProcessed.substring(1), subseq);
        return subseq;
    }

    // recursion #2
    static List<String> subSeq2(String processed, String unProcessed) {

        if(unProcessed.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        char ch = unProcessed.charAt(0);
        List<String> left = subSeq2(processed + ch, unProcessed.substring(1));
        List<String> right = subSeq2(processed, unProcessed.substring(1));
        left.addAll(right);
        return left;
    }
}
