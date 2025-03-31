package ruff;

public class Ruff {
    public static void main(String[] args) {
        int[] arr = {13817, 15695, 4474, 8356, 12695, 24341, 8839, 28059, 8337, 3532};
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for(int a: arr) {
            if(a > largest) {
                secondLargest = largest;
                largest = a;
            }
            if (a < largest && a > secondLargest) {
                secondLargest = a;
            }
        }
        if(secondLargest != largest) {
             System.out.println(-1);
        }
        System.out.println(secondLargest);
    }
}
