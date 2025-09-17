import ua.util.Utils;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Utils.printSeparator();

        Instructor inst = Instructor.of("John", "Doe", "Computer Science");
        System.out.println(inst);

        Student st1 = Student.of("Alice", "Smith", "alice@gmail.com", LocalDate.now());
        System.out.println(st1);

        try {
            Student st2 = Student.of("Bob", "Brown", "wrong_email", LocalDate.now());
            System.out.println(st2);
        } catch (IllegalArgumentException e) {
            System.out.println("Validation failed: " + e.getMessage());
        }

        Utils.printSeparator();

        Course course = Course.of("Java Basics", "Intro to Java", 5, LocalDate.now().plusDays(1), inst);
        course.addStudent(st1);
        System.out.println(course);

        Utils.printSeparator();
    }
}
