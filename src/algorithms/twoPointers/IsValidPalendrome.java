package algorithms.twoPointers;

public class IsValidPalendrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(validPalendrome(s));
    }
    public static boolean validPalendrome(String s) {
        int start = 0;
        int end = s.length()-1;

        while(start < end) {
            while(start < end && !Character.isLetterOrDigit(s.charAt(start))) start++;
            while(start < end && !Character.isLetterOrDigit(s.charAt(end))) end--;

            if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) return false;
            start++;
            end--;
        }
        return true;
    }
}
