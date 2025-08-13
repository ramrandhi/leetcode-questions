package patterns.binarySearch;

// nearest element greater than or equal to the target
public class CeilingOfANumber {
    public static void main(String[] args) {
        int[] arr = {1,5,6,8,9,10};
        System.out.println(ceilingOfANumber(arr, 7));
    }

    private static int ceilingOfANumber(int[] arr, int target) {
        int start = 0, end = arr.length-1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(target == arr[mid]) {
                return mid;
            } else if(target < arr[mid]) {
                end = mid-1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
