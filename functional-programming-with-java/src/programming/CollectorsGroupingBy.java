package programming;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

record Course(String name , String category , int reviewScore , int students) {
}
public class CollectorsGroupingBy {
    public static void main(String[] args) {
        List<Course> courses = List.of(
                new Course("Spring", "Framework", 98, 20000),
                new Course("Spring Boot", "Framework", 95, 18000),
                new Course("API", "Microservices", 97, 22000),
                new Course("Microservices", "Microservices", 96, 25000),
                new Course("AWS", "Cloud", 92, 21000),
                new Course("PCF", "Cloud", 91, 19000),
                new Course("Azure", "Cloud", 93, 23000),
                new Course("Docker", "DevOps", 94, 24000),
                new Course("Kubernetes", "DevOps", 99, 26000)
        );

        Map<String , List<Course>> courseByCategory = courses.stream().collect(Collectors.groupingBy(Course::category));
        System.out.println(courseByCategory);

        Map<String , Long> courseCountByCategory = courses.stream().collect(Collectors.groupingBy(Course::category , Collectors.counting()));
        System.out.println(courseCountByCategory);

        Map<String , Optional<Course>> topCourseByCategory = courses.stream().collect(Collectors.groupingBy(Course::category , Collectors.maxBy(Comparator.comparing(Course::reviewScore))));
        System.out.println(topCourseByCategory);

        Map<String , List<String>> courseNamesByCategory = courses.stream().collect(Collectors.groupingBy(Course:: category , Collectors.mapping(Course:: name , Collectors.toList())));
        System.out.println(courseNamesByCategory);
    }

}
