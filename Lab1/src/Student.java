import java.time.LocalDate;

public class Student {
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate enrollmentDate;

    public Student(String firstName, String lastName, String email, LocalDate enrollmentDate) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setEnrollmentDate(enrollmentDate);
    }

    public static Student of(String firstName, String lastName, String email, LocalDate date) {
        return new Student(firstName, lastName, email, date);
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) {
        if (!ua.util.Utils.isNonEmpty(firstName)) {
            throw new IllegalArgumentException("First name cannot be empty");
        }
        this.firstName = firstName;
    }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) {
        if (!ua.util.Utils.isNonEmpty(lastName)) {
            throw new IllegalArgumentException("Last name cannot be empty");
        }
        this.lastName = lastName;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) {
        if (!ua.util.Utils.isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email");
        }
        this.email = email;
    }

    public LocalDate getEnrollmentDate() { return enrollmentDate; }
    public void setEnrollmentDate(LocalDate enrollmentDate) {
        if (!ua.util.Utils.isFutureOrToday(enrollmentDate)) {
            throw new IllegalArgumentException("Enrollment date must be today or in the future");
        }
        this.enrollmentDate = enrollmentDate;
    }

    @Override
    public String toString() {
        return "Student: " + ua.util.Utils.formatName(firstName, lastName)
                + " (Email: " + email + ", Date: " + enrollmentDate + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student other = (Student) o;
        return email.equals(other.email);
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }
}
