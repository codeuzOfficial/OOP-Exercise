package code_uz._05_Clinic_Solution_;


public class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;
    private String ssn;

    private Doctor doctor;

    public Person() {

    }

    public Person(String firstName, String lastName, String ssn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
    }

    public String getSSN() {
        return ssn;
    }

    public String getFirst() {
        return firstName;
    }

    public String getLast() {
        return lastName;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    @Override
    public int compareTo(Person o) {
        int result = this.lastName.compareTo(o.lastName);
        if (result == 0) {
            return this.firstName.compareTo(o.firstName);
        }

        return result;
    }
}
