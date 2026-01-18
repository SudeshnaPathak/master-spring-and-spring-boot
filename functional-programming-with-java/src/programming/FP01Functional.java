package programming;

import java.util.List;

public class FP01Functional {
    public static void main(String[] args){
        printAllNumbersInListFunctional(List.of(12 , 9 , 13, 4 , 6 , 2 , 4 , 12 , 15));
    }

    private static void print(int num){
        System.out.println(num);
    }
    private static void printAllNumbersInListFunctional(List<Integer> numbers) {
        //Convert the list into a stream of numbers
        //Functional Approach : What to do with each number?
        numbers.stream()
                .forEach(FP01Functional::print); //Method Reference
    }
}
