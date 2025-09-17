import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Course {
    private String title;
    private String description;
    private int credits;
    private LocalDate startDate;
    protected Instructor instructor; // protected
    private List<Student> students = new ArrayList<>();

    public Course(String title, String description, int credits, LocalDate startDate, Instructor instructor) {
        setTitle(title);
        setDescription(description);
        setCredits(credits);
        setStartDate(startDate);
        this.instructor = instructor;
    }

    public static Course of(String title, String description, int credits, LocalDate startDate, Instructor instructor) {
        return new Course(title, description, credits, startDate, instructor);
    }

    public String getTitle() { return title; }
    public void setTitle(String title) {
        if (!ua.util.Utils.isNonEmpty(title)) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        this.title = title;
    }

    public String getDescription() { return description; }
    public void setDescription(String description) {
        if (!ua.util.Utils.isNonEmpty(description)) {
            throw new IllegalArgumentException("Description cannot be empty");
        }
        this.description = description;
    }

    public int getCredits() { return credits; }
    public void setCredits(int credits) {
        if (!ua.util.Utils.isPositive(credits)) {
            throw new IllegalArgumentException("Credits must be positive");
        }
        this.credits = credits;
    }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) {
        if (!ua.util.Utils.isFutureOrToday(startDate)) {
            throw new IllegalArgumentException("Start date must be today or in the future");
        }
        this.startDate = startDate;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public String toString() {
        return "Course: " + title + " (" + credits + " credits, start: " + startDate + ")\n"
                + "Instructor: " + instructor + "\n"
                + "Students enrolled: " + students.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course other = (Course) o;
        return title.equals(other.title) && startDate.equals(other.startDate);
    }

    @Override
    public int hashCode() {
        return title.hashCode() + startDate.hashCode();
    }
}
