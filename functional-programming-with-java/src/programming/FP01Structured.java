package programming;

import java.util.List;

public class FP01Structured {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        printAllNumbersInListStructured(numbers);
        printAllEvenNumbersInListStructured(numbers);
    }

    private static void printAllNumbersInListStructured(List<Integer> numbers) {
        //Traditional Approach : How to loop the numbers?
        for(int n : numbers){
            System.out.println(n);
        }
    }

    private static void printAllEvenNumbersInListStructured(List<Integer> numbers) {
        //Traditional Approach : How to loop the numbers?
        for(int n : numbers){
            if(n % 2 == 0)
                System.out.println(n);
        }
    }
}
