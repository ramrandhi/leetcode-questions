package Formatting;

public class StringFormatting {
    public static void main(String[] args) {
        Double number = 1200.02;
        System.out.println(String.format("%.0f", number));
        Integer intNumber = 1200;
        if(intNumber % 1 == 0) {
            System.out.println(String.format("%d", intNumber));
        }
    }
}
