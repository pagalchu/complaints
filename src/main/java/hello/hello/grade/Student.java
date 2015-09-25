package hello.hello.grade;

/**
 * Created by vle on 9/24/2015.
 */
public class Student {
    private String lastName;
    private String firstName;
    private String gradeLvl;
    private Grade grade;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGradeLvl() {
        return gradeLvl;
    }

    public void setGradeLvl(String gradeLvl) {
        this.gradeLvl = gradeLvl;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", gradeLvl='" + gradeLvl + '\'' +
                ", grade=" + grade +
                '}';
    }
}
