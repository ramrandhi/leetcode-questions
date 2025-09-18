package patterns.recursion_backTracking.subSets_subSequence.subsequence;

import java.util.ArrayList;
import java.util.List;

public class SubSeqWIthAscii {
    public static void main(String[] args) {
        System.out.println(subSequenceWithAscii("ab", "", new ArrayList<>()));
    }

    static List<String> subSequenceWithAscii(String unProcessed, String processed, List<String> list) {
        if(unProcessed.isEmpty()) {
            list.add(processed);
            return list;
        }
        char ch = unProcessed.charAt(0);
        subSequenceWithAscii(unProcessed.substring(1), processed + ch, list);
        subSequenceWithAscii(unProcessed.substring(1), processed, list);
        subSequenceWithAscii(unProcessed.substring(1), processed + (int) ch, list);
        return list;
    }
}
