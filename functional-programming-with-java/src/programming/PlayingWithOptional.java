package programming;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class PlayingWithOptional {
    public static void main(String[] args) {

        //Optional Class is Java8 feature to handle null values gracefully
        //Optional is a container that may or may not contain a non-null value. It provides methods to check if a value is present, retrieve the value, or provide a default value if the value is not present. This helps to avoid NullPointerExceptions.

        List<String> fruits = List.of("Apple", "Banana", "Orange", "Mango", "Pineapple");
        Predicate<? super String> predicate = fruit -> fruit.startsWith("B"); //Predicate to check if fruit starts with B
        Optional<String> optional = fruits.stream().filter(predicate).findFirst(); //findFirst returns an Optional, which may or may not contain a value
        optional.ifPresent(System.out::println); //ifPresent executes the given action if a value is present, otherwise does nothing
        String f = optional.orElse("No fruit found"); //orElse returns the value if present, otherwise returns the default value
        System.out.println(f);


        System.out.println(optional);
        System.out.println(optional.isEmpty());
        System.out.println(optional.isPresent());
        System.out.println(optional.get()); //Throws NoSuchElementException if value is not present, hence check isPresent() before calling get()

        fruits.stream()
                .filter(fruit -> fruit.startsWith("B"))
                        .findFirst()
                                .ifPresent(System.out::println);


    }
}
