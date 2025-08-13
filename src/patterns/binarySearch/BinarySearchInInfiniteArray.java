package patterns.binarySearch;

public class BinarySearchInInfiniteArray {
    public static void main(String[] args) {
        int[] arr = {
                3, 5, 7, 9, 10, 13, 15, 18, 21, 25,
                28, 31, 35, 39, 42, 45, 48, 52, 56, 60,
                65, 70, 75, 80, 85, 90, 95, 100, 105, 110,
                115, 120, 125, 130, 135, 140, 145, 150, 155, 160,
                165, 170, 175, 180, 185, 190, 195, 200, 210, 220,
                230, 240, 250, 260, 270, 280, 290, 300, 310, 320,
                330, 340, 350, 360, 370, 380, 390, 400, 420, 440,
                460, 480, 500, 520, 540, 560, 580, 600, 650, 700,
                750, 800, 850, 900, 950, 1000, 1100, 1200, 1300, 1400,
                1500, 1600, 1700, 1800, 1900, 2000, 2200, 2400, 2600, 2800,
                3000, 3500, 4000, 4500, 5000
        };
        System.out.println(InfiniteArrayBS(arr, 25));
    }
    private static int InfiniteArrayBS(int[] arr, int target) {
        int start = 0;
        int end = 1;
        while(target > arr[end]) {
            int newStart = end + 1;
            end = end + (end - start + 1) * 2; // => end - (start -1) = end - start + 1;
            start = newStart;
        }
        return binarySearchInRange(arr, target, start, end);
    }
    private static int binarySearchInRange(int[] arr, int target, int start, int end) {
        while(start <= end) {
            int mid = start + (end - start) /2;
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
