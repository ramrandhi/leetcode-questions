package basicdsa.arrays;
public class Ruff {
    public static void main(String[] args) {
        String s = "52";
        System.out.println(largestOddNumber(s));
    }
    public static String largestOddNumber(String num) {
        int largest = 0;
        int temp = 0;
        for(char c: num.toCharArray()) {
            temp = c - '0';
            if(temp % 2 == 1 && temp > largest) {
                largest = temp;
            }
        }
        if(largest > 0) {
            return largest+"";
        }
        return "";
    }
}
