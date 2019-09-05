package code_uz._05_Clinic_Solution_;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Doctor extends Person {

    private int docID;
    private String specialization;
    private List<Person> personList = new LinkedList<>();

    public Doctor(String firstName, String lastName, String ssn, int docID, String specialization) {
        super(firstName, lastName, ssn);
        this.docID = docID;
        this.specialization = specialization;
    }

    public int getId() {
        return docID;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void addPatient(Person person) {
        this.personList.add(person);
    }

    public Collection<Person> getPatients() {
        return personList;
    }

    public int patientCount() {
        return this.personList.size();
    }


}
