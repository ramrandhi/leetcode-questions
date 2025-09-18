package patterns.recursion_backTracking.recursion.basics;

public class SumOfDigits {
    public static void main(String[] args) {
        System.out.println(sumOfDigits(1342));
    }

    private static int sumOfDigits(int n) {
        if(n == 1) return 1;
        int rem = n % 10;
        return rem + sumOfDigits(n/10);
    }
}
