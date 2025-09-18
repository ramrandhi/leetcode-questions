package patterns.recursion_backTracking.recursion.strings;

public class SkipApple {
    public static void main(String[] args) {
        String s = "bacaappledfsdf";
        System.out.println(skipApple(s));
    }
    static String skipApple(String s) {
        if(s.isEmpty()) return "";
        if(s.startsWith("apple")) {
            return skipApple(s.substring(5));
        }
        return s.charAt(0) + skipApple(s.substring(1));
    }
}
