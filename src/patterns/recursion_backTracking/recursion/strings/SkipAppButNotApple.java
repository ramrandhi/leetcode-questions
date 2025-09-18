package patterns.recursion_backTracking.recursion.strings;

public class SkipAppButNotApple {
    public static void main(String[] args) {
        String s = "asgdsgjappsdfjsdapplesfjdsofsd";
        System.out.println(skipAppButNotApple(s));
    }
    static String skipAppButNotApple(String s) {
        if(s.isEmpty()) return "";
        if(s.startsWith("app") && !(s.startsWith("apple"))) {
            return skipAppButNotApple(s.substring(3));
        }
        return s.charAt(0) + skipAppButNotApple(s.substring(1));
    }
}
