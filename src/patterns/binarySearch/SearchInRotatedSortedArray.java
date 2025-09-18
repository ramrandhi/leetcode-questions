package patterns.binarySearch;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {5,1,3};
        int target = 5;
        System.out.println(search(arr, target));
    }

    public static int search(int[] nums, int target) {
        int peak = findPivot(nums);
        if(nums[peak] == target) {
            return peak;
        }
        int isFirstHalf = searchleftHalf(target, nums, 0, peak);
        if(isFirstHalf != -1) {
            return isFirstHalf;
        }
        return searchleftHalf(target, nums, peak+1, nums.length-1);
    }

    private static int findPivot(int[] arr) {
        int start = 0, end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }
            if (arr[mid] <= arr[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    private static int findPivotWithDuplicates(int[] arr) {
        int start = 0, end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Case 1: mid is pivot point
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }

            // Case 2: Duplicates at edges → shrink range
            if (arr[start] == arr[mid] && arr[mid] == arr[end]) {
                // Skip duplicates
                if (start < end && arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;
                if (end > start && arr[end - 1] > arr[end]) {
                    return end - 1;
                }
                end--;
            }
            // Case 3: Left side is unsorted, pivot is there
            else if (arr[start] > arr[mid]) {
                end = mid - 1;
            }
            // Case 4: Right side is unsorted, pivot is there
            else {
                start = mid + 1;
            }
        }
        return -1; // No rotation
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
}
