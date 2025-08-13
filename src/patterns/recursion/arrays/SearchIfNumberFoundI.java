package patterns.recursion.arrays;

public class SearchIfNumberFoundI {
    public static void main(String[] args) {
        System.out.println(isNumberPresent(new int[] {1,2,3,456,89,18,26,69,180},18));
    }
    static boolean isNumberPresent(int[] arr, int target) {
        return helper(arr, target, 0);
    }

    static boolean helper(int[] arr, int target, int index) {
        if(index == arr.length) return false;
        if(arr[index] == target) return true;
        return helper(arr, target, index + 1);
    }
}
