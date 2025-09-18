package patterns.recursion_backTracking.recursion.arrays;

public class CheckIfArrayIsSorted {
    public static void main(String[] args) {
        int[] arr = {1,5,6,8,9};
        System.out.println(isSorted(arr));
    }

    private static boolean isSorted(int[] arr) {
        int count = 1;
        return helper(arr, count-1, count, count);
    }

    private static boolean helper(int[] arr, int start, int end, int count) {
        if(count == arr.length) return true;
        return arr[start] < arr[end] && helper(arr, start + 1, end + 1, count + 1);
    }
}
