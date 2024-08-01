package java8.features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaExpressions {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(6,1, 2, 3, 4, 5));
//        arr.sort(arr);
        List<String> names = new ArrayList<> (Arrays.asList("Alice", "Bob", "Charlie", "Angular"));
//        names.forEach(name -> System.out.println(name.toUpperCase()));
//        names.replaceAll(String::toUpperCase);
//        names.forEach(System.out::println);
        names.stream().filter(name -> name.startsWith("A")).forEach(System.out::println);
    }
}
