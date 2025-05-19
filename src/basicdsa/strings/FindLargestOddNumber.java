package basicdsa.strings;

public class FindLargestOddNumber {
    public static void main(String[] args) {
        String num = "945484964950";
        System.out.println(findLargestOddNumber(num));
    }
    public static String findLargestOddNumber(String num) {
        for (int i = num.length()-1; i >= 0; i--) {
            if((num.charAt(i) - '0') % 2 == 1) {
                return num.substring(0, i+1);
            }
        }
        return "";
    }
}
