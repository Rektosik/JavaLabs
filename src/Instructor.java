public class Instructor {
    private String firstName;
    private String lastName;
    private String expertise;

    public Instructor(String firstName, String lastName, String expertise) {
        setFirstName(firstName);
        setLastName(lastName);
        setExpertise(expertise);
    }

    public static Instructor of(String firstName, String lastName, String expertise) {
        return new Instructor(firstName, lastName, expertise);
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

    public String getExpertise() { return expertise; }
    public void setExpertise(String expertise) {
        if (!ua.util.Utils.isNonEmpty(expertise)) {
            throw new IllegalArgumentException("Expertise cannot be empty");
        }
        this.expertise = expertise;
    }

    @Override
    public String toString() {
        return "Instructor: " + ua.util.Utils.formatName(firstName, lastName)
                + " (Expertise: " + expertise + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Instructor)) return false;
        Instructor other = (Instructor) o;
        return firstName.equals(other.firstName) && lastName.equals(other.lastName);
    }

    @Override
    public int hashCode() {
        return firstName.hashCode() + lastName.hashCode();
    }
}

