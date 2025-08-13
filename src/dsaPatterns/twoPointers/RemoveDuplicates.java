package dsaPatterns.twoPointers;

public class RemoveDuplicates {
    public static int removeDuplicates(int[] arr) {
        int slow = 0;
        for(int fast = 1;fast< arr.length;fast++) {
            if(arr[fast] != arr[slow]) {
                slow++;
                arr[slow] = arr[fast];
            }
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,3};
        System.out.println(removeDuplicates(arr));
    }
}
