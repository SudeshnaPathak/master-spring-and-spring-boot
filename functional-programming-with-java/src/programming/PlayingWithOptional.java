package programming;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class PlayingWithOptional {
    public static void main(String[] args) {

        //Optional Class is Java8 feature to handle null values gracefully

        List<String> fruits = List.of("Apple", "Banana", "Orange", "Mango", "Pineapple");
        Predicate<? super String> predicate = fruit -> fruit.startsWith("B"); //Predicate to check if fruit starts with B
        Optional<String> optional = fruits.stream().filter(predicate).findFirst(); //findFirst returns an Optional, which may or may not contain a value

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
