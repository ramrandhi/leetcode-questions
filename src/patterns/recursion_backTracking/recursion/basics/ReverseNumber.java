package patterns.recursion_backTracking.recursion.basics;

public class ReverseNumber {
    public static void main(String[] args) {
        System.out.println(reverseNumber2(1235));
    }

    static int sum = 0;

    static int reverseNumber(int num) {
        if (num == 0) return 0;
        int rem = num % 10;
        sum = sum * 10 + rem;
        reverseNumber(num / 10);
        return sum;
    }

    static int reverseNumber2(int num) {
        int digits = (int) (Math.log10(num) + 1);
        return helper(num, digits);
    }

    static int helper(int n, int digits) {
        if(n%10 == n) return n;
        int rem = n % 10;
        return rem * (int)Math.pow(10, digits - 1) + helper(n/10, digits-1);
    }
}
