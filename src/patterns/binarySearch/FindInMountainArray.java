package patterns.binarySearch;

public class FindInMountainArray {
    public static void main(String[] args) {
        int[] arr = {3,5,3,2,0};
        int target = 2;
        System.out.println(findInMountainArray(target, arr));
    }

    public static int findInMountainArray(int target, int[] arr) {
        if(arr.length < 3) return -1;
        int peak = findPeak(target, arr);
        int isFirstHalf = searchleftHalf(target, arr, 0, peak);
        if(isFirstHalf != -1) {
            return isFirstHalf;
        }
        return searchRightHalf(target, arr, peak+1, arr.length-1);
    }

    private static int findPeak(int target, int[] arr) {
        int start = 0, end = arr.length-1;
        while(start < end) {
            int mid = start + (end - start)/2;
            if(arr[mid] >= arr[mid+1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private static int searchleftHalf(int target, int[] arr, int start, int end) {
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(target == arr[mid]) {
                return mid;
            } else if(target < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    private static int searchRightHalf(int target, int[] arr, int start, int end) {
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(target == arr[mid]) {
                return mid;
            } else if(target < arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;

            }
        }
        return -1;
    }
}
