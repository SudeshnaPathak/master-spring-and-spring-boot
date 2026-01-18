package programming;

import java.util.List;

public class FP01Functional {
    public static void main(String[] args){
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        printAllNumbersInListFunctional(numbers);
        printAllEvenNumbersInListFunctional(numbers);
    }

    private static void printAllNumbersInListFunctional(List<Integer> numbers) {
        //Convert the list into a stream of numbers
        //Functional Approach : What to do with each number?
        //We are not calling the method here, we are just passing it as a reference to be used later
        numbers.stream()
                .forEach(System.out::println); //Method Reference to call static method println of System.out
    }

//    private static boolean isEven(int number) {
//        return number % 2 == 0;
//    }

    private static void printAllEvenNumbersInListFunctional(List<Integer> numbers) {
        //filter is a higher order function that takes a predicate (a function that returns a boolean) as an argument
        //If filter returns true, the number is included in the stream, otherwise it is excluded
        numbers.stream()
                .filter(number -> number % 2 == 0) //Lambda Expression
                .forEach(System.out::println);

        //.filter(FP01Functional::isEven) //Filter only even numbers w/o lambda using a static method reference
    }
}

//By default, if we have only one lambda expression, it returns the value