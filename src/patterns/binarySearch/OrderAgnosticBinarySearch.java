package patterns.binarySearch;

public class OrderAgnosticBinarySearch {
    public static void main(String[] args) {
//        int[] arr = {1,5,6,8,9,10};
        int[] arr = {10,8,6,5,3,2,1};
        System.out.println(orderAgnosticBinarySearch(arr, 1));
    }

    private static int orderAgnosticBinarySearch(int[] arr, int target) {
        int start = 0, end = arr.length-1;
        boolean isAscending = arr[start] < arr[end] ? true : false;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if(isAscending) {
                if(target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if(target < arr[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
