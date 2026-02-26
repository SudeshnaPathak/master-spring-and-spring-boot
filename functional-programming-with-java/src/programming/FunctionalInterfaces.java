package programming;

//Interfaces with only one abstract method are called functional interfaces,
// they can be used as lambda expressions or method references,
// they are annotated with @FunctionalInterface to indicate that they are functional interfaces,
// but it is not mandatory to use the annotation, it is just a good practice to use it to avoid accidental addition of more abstract methods in the interface.

import java.util.Random;
import java.util.function.Predicate;

@FunctionalInterface
interface Consumer<T>{
    void accept(T t);
}

@FunctionalInterface
interface Function<T,R>{
    R apply(T t);
}

@FunctionalInterface
interface BiFunction<T , U , R>{
    R apply(T t , U u);
}

@FunctionalInterface
interface Supplier<T>{
    T get();
}

@FunctionalInterface
interface UnaryOperator<T>{
    T apply(T t);
}

@FunctionalInterface
interface BinaryOperator<T>{
    T apply(T t1 , T t2);
}

@FunctionalInterface
interface BiPredicate<T , U>{
    boolean test(T t , U u);
}

@FunctionalInterface
interface BiConsumer<T , U>{
    void accept(T t , U u);
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

        BiFunction<Integer , Integer , Integer> sumFunction = Integer::sum;
        System.out.println(sumFunction.apply(5, 15));

        BiFunction<String , String , String> concatFunction = String::concat;
        System.out.println(concatFunction.apply("Hello ", "World!")); //prints "Hello

        Supplier<Integer> supplier = () -> new Random().nextInt(100);
        System.out.println(supplier.get()); //prints a random number between 0 and 99

        UnaryOperator<Integer> tripleOperator = n -> n*3;
        System.out.println(tripleOperator.apply(8)); //prints 24

        BinaryOperator<Integer> multiplyOperator = (x , y) -> x*y;
        System.out.println(multiplyOperator.apply(5, 10)); //prints 50

        BiPredicate<Integer, Integer> equalsFunction = (x, y) -> x.equals(y);
        System.out.println(equalsFunction.test(5, 5)); //prints true
        System.out.println(equalsFunction.test(5, 10)); //prints false

        BiConsumer<String , Integer> printNameAndAge = (name , age) -> System.out.println(name + " is " + age + " years old.");
        printNameAndAge.accept("Sudeshna" , 22); //prints "Sudeshna is 22 years old."
    }
}

//Why were Primitive Functional Interfaces introduced in Java8?
//Use IntBinaryOperator instead of BinaryOperator<Integer> to avoid autoboxing and unboxing overhead when working with primitive types like int, long, double etc.
//IntBinaryOperator sum = (x , y)->(x + y);

//Special Functional interfaces for primitive types like int, long, double etc exist in java.util.function package since Java8 to avoid autoboxing and unboxing overhead,
//they are IntConsumer, LongConsumer, DoubleConsumer,
//IntFunction, LongFunction, DoubleFunction,
//IntPredicate, LongPredicate, DoublePredicate,
//IntUnaryOperator, LongUnaryOperator, DoubleUnaryOperator,
//IntBinaryOperator, LongBinaryOperator, DoubleBinaryOperator etc.

//How do Primitive Functional Interfaces work?
//No need to wrap/Unwrap primitive types
//No object creation overhead, as it's not creating Integer, Long, Double objects, it is directly working with primitive types.
//Clean and efficient code, as it avoids unnecessary boxing and unboxing operations, which can lead to better performance, especially in scenarios where there are a large number of operations on primitive types.