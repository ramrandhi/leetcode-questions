package java8.features;

import java.util.Arrays;
import java.util.*;
import java.util.stream.Collectors;

public class StreamApis {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1,2,3,4,8,5,66,22,4,5,2,55,55,69,55,4,8,2,5,48,558);
        Integer sum = arr.stream().filter(num -> num%2 != 0).mapToInt(Integer::intValue).sum();
        System.out.println(sum);

        List<String> str = Arrays.asList("Alice", "Bob", "Charlie", "Angular");

//        Streams
//        str.stream().forEach(System.out::println);

//        ForEach
//        for(String s : str) {
//            System.out.println(s);
//        }
//        Iterator
//        Iterator<String> s = str.iterator();
//        while(s.hasNext()){
//            System.out.println(s.next());
//        }

//        Streams using lambda expression

        str.stream().forEach(s -> System.out.println(s));
    }
}
