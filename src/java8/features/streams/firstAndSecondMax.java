package java8.features.streams;

import java.util.Arrays;

public class firstAndSecondMax {
    public static void main(String[] args) {
        int[] arr = {5,6,8,5,6,5,6,6,5,85,9};
        int max = Integer.MIN_VALUE;
        Integer maxValue = Arrays.stream(arr).max().getAsInt();
        System.out.println(maxValue);

        Integer secondMax = Arrays.stream(arr)
                .distinct()
                .boxed()
                .sorted((a,b) -> b - a)
                .skip(1)
                .findFirst()
                .orElse(null);
        System.out.println(secondMax);
    }
}
