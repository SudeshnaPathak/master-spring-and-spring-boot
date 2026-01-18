package programming;

import java.util.List;

public class FP01Exercises {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        System.out.println("Exercise 1: Print odd numbers in the list");
        numbers.stream()
                .filter(n -> n % 2 == 1)
                .forEach(System.out::println);

        List<String> Courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");

        System.out.println("Exercise 2: Print all courses");
        Courses.stream()
                .forEach(System.out::println);

        System.out.println("Exercise 3: Print only courses containing 'Spring'");
        Courses.stream()
                .filter(course -> course.contains("Spring"))
                .forEach((System.out::println));

        System.out.println("Exercise 4: Print courses with at least 4 letters");
        Courses.stream()
                .filter(course -> course.length() >= 4)
                .forEach(System.out::println);

        System.out.println("Exercise 5: Print the square of even numbers");
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n) //map is used to transform each element
                .forEach(System.out::println);

        System.out.println("Exercise 6: Print the cube of odd numbers");
        numbers.stream()
                .filter(n -> n % 2 == 1)
                .map(n -> Math.pow(n , 3))
                .forEach(System.out::println);

        System.out.println("Exercise 7: Print the length of each course name");
        Courses.stream()
                .map(course -> course + " " + course.length())
                .forEach(System.out :: println);
    }

}
