package ruff;

public class CircularArrayLoop {
    public static boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) continue;

            int slow = i, fast = i;
            boolean isForward = nums[i] > 0;

            while (true) {
                slow = nextIndex(nums, isForward, slow);
                fast = nextIndex(nums, isForward, fast);
                if (fast != -1) {
                    fast = nextIndex(nums, isForward, fast);
                }

                if (slow == -1 || fast == -1 || slow == fast) break;
            }

            if (slow != -1 && slow == fast) return true;

            // Mark this path as visited (carefully)
            int index = i;
            boolean currentDir = nums[index] > 0;
            while (nums[index] != 0 && (nums[index] > 0) == currentDir) {
                int next = ((index + nums[index]) % n + n) % n;
                nums[index] = 0;
                if (next == index) break; // 1-length loop
                index = next;
            }
        }

        return false;
    }

    private static int nextIndex(int[] nums, boolean isForward, int index) {
        boolean direction = nums[index] > 0;
        if (direction != isForward) return -1;

        int n = nums.length;
        int next = ((index + nums[index]) % n + n) % n;

        if (next == index) return -1; // self-loop
        return next;
    }
}
