package java8.features;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalExample {
    public static void main(String[] args) {
        // Creating an empty Optional
        Optional<String> emptyOpt = Optional.empty();
//        System.out.println("Empty Optional: " + emptyOpt);

        // Creating an Optional with a non-null value
        Optional<String> nonEmptyOpt = Optional.of("Hello");
//        System.out.println("Non-empty Optional: " + nonEmptyOpt);

        // Creating an Optional with a potentially null value
        String nullableString = null;
        Optional<String> nullableOpt = Optional.ofNullable(nullableString);
//        System.out.println("Nullable Optional: " + nullableOpt);

        Optional<String> opt = Optional.of("Hello");

        // Checking if a value is present
//        opt.ifPresent(s -> System.out.println("Value is present: " + s));
//        opt.ifPresent(s -> System.out.println("Value is present: " + s));
        String value = opt.orElse("Default Value");
//        System.out.println("Value or default: " + value);

        // Using orElseGet with a Supplier
        value = opt.orElseGet(() -> "Default from Supplier");
//        System.out.println("Value or default from Supplier: " + value);

        // Using orElseThrow to throw an exception if value is not present
        value = opt.orElseThrow(() -> new IllegalArgumentException("No value present"));
//        System.out.println("Value or exception: " + value);

        List<String> allNames = Arrays.asList("Alice", "Bob", "Charlie", "David", "Alter");
        Optional<List<String>> result = Optional.of(allNames);
        result.ifPresent(list -> {
           list.forEach(System.out::println);
        });
    }
}
