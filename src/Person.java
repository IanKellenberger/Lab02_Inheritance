import java.util.Calendar;
import java.util.Objects;

public class Person {
    private String firstName;
    private String lastName;
    private final String ID;  // should never change
    private String title;  // Mr., Mrs., Ms., Prof., Dr., etc.
    private int YOB;  // Year of birth: should be between 1940 and 2010

    /**
     * Constructor for Person
     *
     * @param firstName First Name
     * @param lastName  Last Name
     * @param ID        ID, it cannot be changed after initialization
     * @param title     Title (Mr., Mrs., etc.)
     * @param YOB       Year of Birth (must be between 1940 and 2010)
     */
    public Person(String firstName, String lastName, String ID, String title, int YOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.title = title;
        if (YOB >= 1940 && YOB <= 2010) {
            this.YOB = YOB;
        } else {
            throw new IllegalArgumentException("Year of birth must be between 1940 and 2010.");
        }
    }

    // Getter methods (no setter for ID since it should not change)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYOB() {
        return YOB;
    }

    public void setYOB(int YOB) {
        if (YOB >= 1940 && YOB <= 2010) {
            this.YOB = YOB;
        } else {
            throw new IllegalArgumentException("Year of birth must be between 1940 and 2010.");
        }
    }

    /**
     * Returns the full name (firstName + lastName)
     *
     * @return Full name of the person
     */
    public String fullName() {
        return firstName + " " + lastName;
    }

    /**
     * Returns the formal name (title + fullName)
     *
     * @return Formal name of the person
     */
    public String formalName() {
        return title + " " + fullName();
    }

    /**
     * Calculate the person's current age based on the current year.
     *
     * @return The person's age
     */
    public int getAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return currentYear - YOB;
    }

    /**
     * Calculate the person's age for a specific year.
     *
     * @param year The year to calculate the age for
     * @return The person's age in the specified year
     */
    public int getAge(int year) {
        if (year >= YOB) {
            return year - YOB;
        } else {
            throw new IllegalArgumentException("Year must be greater than or equal to year of birth.");
        }
    }

    /**
     * Converts the Person object to a CSV format
     *
     * @return A CSV string representing the Person object
     */
    public String toCSV() {
        return String.join(",", firstName, lastName, ID, title, Integer.toString(YOB));
    }

    /**
     * Converts the Person object to JSON format
     *
     * @return A JSON string representing the Person object
     */
    public String toJSON() {
        return "{" +
                "\"firstName\":\"" + firstName + "\"," +
                "\"lastName\":\"" + lastName + "\"," +
                "\"ID\":\"" + ID + "\"," +
                "\"title\":\"" + title + "\"," +
                "\"YOB\":" + YOB +
                "}";
    }

    /**
     * Converts the Person object to XML format
     *
     * @return An XML string representing the Person object
     */
    public String toXML() {
        return "<person>" +
                "<firstName>" + firstName + "</firstName>" +
                "<lastName>" + lastName + "</lastName>" +
                "<ID>" + ID + "</ID>" +
                "<title>" + title + "</title>" +
                "<YOB>" + YOB + "</YOB>" +
                "</person>";
    }

    @Override
    public String toString() {
        return formalName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return YOB == person.YOB &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(ID, person.ID) &&
                Objects.equals(title, person.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, ID, title, YOB);
    }
}
