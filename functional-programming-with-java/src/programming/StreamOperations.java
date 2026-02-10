package programming;

import java.util.List;
import java.util.stream.Stream;

public class StreamOperations {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(2 , 3 , 4 , 5 , 2 , 3 , 11 , 11);

        //Intermediate operations
        numbers.stream()
                .filter(n->n%2==1) //filters a stream to include only odd numbers
                .map(n->n*n) //maps each number to its square
                .distinct() //removes duplicate elements from the stream
                .sorted() //sorts the elements of the stream
                .skip(1) //skips the first element of the stream
                .forEach(System.out::println);

        //Terminal operations
        List<Integer> squared = numbers.stream()
                .map(n -> n*n)
                .toList(); //collects the squared numbers stream into a List
        System.out.println(squared);

        int sum = squared.stream()
                .reduce(0 , Integer::sum);
        System.out.println("Sum: " + sum);

        int cnt = (int) squared.stream().filter(n->n%2==0).count();
        System.out.println("Count of even numbers: " + cnt);

        int first = squared.stream().findFirst().orElse(-1);
        System.out.println("First element: " + first);

        int any = squared.stream().findAny().get();
        System.out.println("Any element: " + any);

        System.out.println("Is all even: " + squared.stream().allMatch(n->n%2==0));
        System.out.println("Is any greater than 50: " + squared.stream().anyMatch(n->n>50));
        System.out.println("Is none greater than 100: " + squared.stream().noneMatch(n->n>100));

        List<Integer> l = List.of(1, 2, 3, 4, 5);
        Stream<Integer> s = l.stream();
        s.forEach(System.out::print); //Works fine
        System.out.println();
        try{
                s.forEach(System.out::print); //Throws IllegalStateException: stream has already been operated upon or closed,
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
//Streams do not store data, they are not a data structure, they are a sequence of elements that can be processed in parallel or sequentially.
//They are lazy, meaning that they do not perform any operations until a terminal operation like forEach, collect, reduce etc. is called.
//Streams are immutable, the intermediate operations like filter, map, distinct, sorted etc. return a new stream and do not modify the original list.
//Streams can only be consumed once, after a terminal operation is called, the stream is closed and cannot be used again, hence we get IllegalStateException if we try to use the same stream again.


