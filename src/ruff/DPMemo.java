package ruff;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class DPMemo {
    public static void main(String[] args) {
        System.out.println(fibanocci(5, new HashMap<>()));
    }

    private static int fibanocci(int n, Map<Integer, BigInteger> memo) {
        if(n <= 2) {
            return n;
        }
        BigInteger result = BigInteger.valueOf(fibanocci(n-1, memo) + fibanocci(n-2, memo));
        memo.put(n, result);
        return result.intValue();
    }
}
