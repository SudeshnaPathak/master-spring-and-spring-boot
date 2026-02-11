package programming;

//Interfaces with only one abstract method are called functional interfaces,
// they can be used as lambda expressions or method references,
// they are annotated with @FunctionalInterface to indicate that they are functional interfaces,
// but it is not mandatory to use the annotation, it is just a good practice to use it to avoid accidental addition of more abstract methods in the interface.

@FunctionalInterface
interface Consumer<T>{
    void accept(T t);
}

@FunctionalInterface
interface Function<T,R>{
    R apply(T t);
}

@FunctionalInterface
interface Predicate<T>{
    boolean test(T t);
}

interface BiFunction<T , U , R>{
    R apply(T t , U u);
}

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Consumer<Integer> printOdd = n -> {
            if(n%2==1){
                System.out.println(n);
            }
        };
        printOdd.accept(3); //prints 3
        printOdd.accept(4); //does not print anything

        Function<Integer, Integer> squared = n -> n*n;
        System.out.println(squared.apply(5)); //prints 25

        Predicate<Integer> isEven = n -> n%2==0;
        System.out.println(isEven.test(4)); //prints true
        System.out.println(isEven.test(5)); //prints false

        BiFunction<Integer , Integer , Integer> maxFunction = (x , y) -> (x > y) ? x : y;
        System.out.println(maxFunction.apply(5, 15));
    }
}
