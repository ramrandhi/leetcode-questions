package collections.List.LinkedList.problems.cll;

public class IsHappy {
    public static void main(String[] args) {
        System.out.println(isHappy(3));
    }
    public static boolean isHappy(int n) {
        if(n <= 0) {
            return false;
        }
        int slow = n;
        int fast = n;
        do {
            slow = getSquare(slow);
            fast = getSquare(getSquare(fast));
        } while(slow != fast);
        return slow == 1;
    }

    private static int getSquare(int number) {
        int ans = 0;
        while(number > 0) {
            int rem = number % 10;
            ans = ans + rem * rem;
            number = number / 10;
        }
        return ans;
    }
}
