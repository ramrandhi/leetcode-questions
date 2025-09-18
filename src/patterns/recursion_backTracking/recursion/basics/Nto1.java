package patterns.recursion_backTracking.recursion.basics;

public class Nto1 {
    public static void main(String[] args) {
//        fun(5);
//        funRev(5);
        funBoth(5);
    }

    private static void fun(int n) {
        if(n < 1) return;
        System.out.println(n);
        fun(n-1);
    }

    private static void funRev(int n) {
        if(n < 1) return;
        funRev(n-1);
        System.out.println(n);
    }

    private static void funBoth(int n) {
        if(n < 1) return;
        System.out.println(n);
        funBoth(n-1);
        System.out.println(n);
    }
}
