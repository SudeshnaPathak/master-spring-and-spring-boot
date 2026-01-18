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
                .forEach(System.out::println); //Method Reference
    }

//    private static boolean isEven(int number) {
//        return number % 2 == 0;
//    }

    private static void printAllEvenNumbersInListFunctional(List<Integer> numbers) {
        //If filter returns true , only then the number is passed to forEach
        numbers.stream()
                .filter(number -> number % 2 == 0) //Lambda Expression
                .forEach(System.out::println);

        //.filter(FP01Functional::isEven) //Filter only even numbers w/o lambda using a static method reference
    }
}

//By default, if we have only one lambda expression, it returns the value