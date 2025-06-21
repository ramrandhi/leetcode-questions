package ruff;

public class Ruff1 {
    public static void main(String[] args) {
        int[] arr = {0,0,0,0,0,1,1,1,1,1,1,1,1,1};
        System.out.println(findIndexOfFirstOne(arr, 1));
    }

    private static int findIndexOfFirstOne(int[] arr, int num) {
        int start = 0;
        int end = arr.length-1;
        int result = 0;
        while(start <= end) {
            int mid = start + (end-start)/2;;
            if(arr[mid] == num) {
                result = mid;
                end = mid -1;
            } else {
                start = mid + 1;
            }
        }
        return result;

    }
}
