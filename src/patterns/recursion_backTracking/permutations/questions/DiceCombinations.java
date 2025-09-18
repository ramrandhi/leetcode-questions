package patterns.recursion_backTracking.permutations.questions;

public class DiceCombinations {
    public static void main(String[] args) {
        dice("", 4);
        System.out.println("count is : " + countPossibilitiesOfDice("", 4));
    }
    private static void dice(String processed, int target) {
        if(target == 0) {
            System.out.println(processed);
            return;
        }
        for(int i = 1; i <= 6 && i <= target;i++) {
            dice(processed + i, target - i);
        }
    }

    static int countPossibilitiesOfDice(String processed, int target) {
        int count = 0;
        if(target == 0) {
            count = count + 1;
            return count;
        }
        for(int i = 1; i <= 6 && i <= target;i++) {
            count = count + countPossibilitiesOfDice(processed + i, target - i);
        }
        return count;
    }
}
