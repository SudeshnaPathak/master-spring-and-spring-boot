package programming;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DifferentStreamCreationWays {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        int sum = numbers.stream().reduce(0 , Integer::sum); //reduce is used to combine all elements of the stream into a single result, in this case, we are summing all the numbers in the list
        System.out.println(sum);

        //Collections.stream() is used to create a stream from a Map, List, Set etc.
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        courses.stream()
                .map(course -> course.toUpperCase())
                .forEach(System.out::println);

        Map<String , Integer> map = Map.of("Java", 100, "Python", 80, "JavaScript", 95);
        Stream<Integer> values = map.values().stream();
        System.out.println("Values:");
        values.forEach(System.out::println);
        Stream<String> keys = map.keySet().stream();
        System.out.println("Keys:");
        keys.forEach(System.out::println);
        Stream<Map.Entry<String, Integer>> stream = map.entrySet().stream();
        System.out.println("Entries:");
        stream.forEach(System.out::println);

        //Stream.of() is used to create a stream from a sequence of values
        Stream<String> stream1 = Stream.of("Apple", "Banana", "Orange", "Mango", "Pineapple").map(n -> n+" ");
        stream1.forEach(System.out::print);
        System.out.println();

        //Arrays.stream() is used to create a stream from an array
        int[] arr = {1, 2, 3, 4, 5};
        IntStream stream2 = Arrays.stream(arr);
        stream2.forEach((System.out :: print));
        System.out.println();

        //OR

        Stream<Integer> boxedStream = Arrays.stream(arr).filter(n -> n % 2 == 0).boxed(); //boxed is used to convert IntStream to Stream<Integer>
        boxedStream.forEach(System.out::print);
        System.out.println();

        //Builder pattern to manually construct a stream
        Stream.Builder<String> builder = Stream.builder();
        builder.add("Lenovo").add("Dell").add("HP").add("Asus");
        Stream<String> stream3 = builder.build();
        stream3.forEach(System.out::println);

        //Stream.generate() is used to create an infinite stream of random numbers, we can limit it to a certain number of elements using limit()
        Stream<Double> randomNumbers = Stream.generate(Math::random)
                .limit(5)
                .map(n->Math.floor(n*100));
        randomNumbers.forEach(System.out::println);

        //Stream.iterate() is used to create an infinite stream using fixed pattern, we can limit it to a certain number of elements using limit()
        Stream<Integer> evenNumbers = Stream.iterate(0 , n-> n + 2)
                .limit(10);
        evenNumbers.forEach(System.out::println);

        //IntStream.range() is used to create a number range stream, it is exclusive of the upper bound
        Stream<Integer> num = IntStream.range(1 , 5).boxed();
        num.forEach(System.out::print);
        System.out.println();

        //OR

        //IntStream.rangeClosed() is used to create a number range stream, it is inclusive of the upper bound
        IntStream num2 = IntStream.rangeClosed(1 , 5);
        num2.forEach(System.out::print);

        System.out.println();
        Stream<String> fileStream = null;
        try {
            fileStream = Files.lines(Paths.get("file.txt"));
            fileStream.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("No such file exits");
        }

    }
}
