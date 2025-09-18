package patterns.recursion_backTracking.recursion.basics;

public class CountNumberOfZeros {
    public static void main(String[] args) {
        int n = 30210004;
        countZeros(n);
        System.out.println(countZeros2(n));
    }
    static int num = 0;
    private static void countZeros(int n) {
        if(n == 0) return;
        int rem = n % 10;
        if(rem == 0) num++;
        countZeros(n/10);
    }

    private static int countZeros2(int n) {
        int count = 0;
        return helper(n, count);
    }

    private static int helper(int n, int count) {
        if(n%10 == n) return count;
        int rem = n % 10;
        if(rem == 0) count+=1;
        return helper(n/10, count);
    }
}
