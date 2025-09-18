package patterns.recursion_backTracking.recursion.basics;

public class FactorialOfANumber {
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

    private static int factorial(int n) {
        if(n <= 1) return 1;
        return n * factorial(n-1);
    }
}
