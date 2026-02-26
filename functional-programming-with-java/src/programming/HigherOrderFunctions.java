package programming;


import java.util.List;
import java.util.function.Predicate;

public class HigherOrderFunctions {
    //Higher Order Function that takes a Predicate as a parameter
    public static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate)
    {
        numbers.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }

    //Higher Order Function that returns a Predicate
    public static Predicate<Integer> isEven()
    {
        return n -> n%2==0;
    }
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        filterAndPrint(numbers, n ->  n % 2 != 0); // Print odd numbers
        filterAndPrint(numbers, isEven()); // Print even numbers
        filterAndPrint(numbers, n -> n % 3 == 0); // Print numbers divisible by 3

        List<Integer> transformedNumbers = numbers.stream()
                .map(n -> n*n)
                .map(n -> n*10)
                .toList();
        System.out.println(transformedNumbers); // Prints the transformed list
    }
}
