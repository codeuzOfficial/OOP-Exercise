package code_uz._05_Clinic_Solution_;

import java.util.*;

public class Clinic {
    private Map<String, Person> patientMap = new TreeMap<>();
    private Map<Integer, Doctor> doctorMap = new TreeMap<>();

    public void addPatient(String firstName, String lastName, String ssn) {
        Person person = new Person(firstName, lastName, ssn);
        patientMap.put(ssn, person);

    }

    public void addDoctor(String firstName, String lastName, String ssn, int docID, String specialization) {
        Doctor doctor = new Doctor(firstName, lastName, ssn, docID, specialization);

        this.doctorMap.put(docID, doctor);
        this.patientMap.put(ssn, doctor);


    }

    public Person getPatient(String ssn) throws NoSuchPatient {

        Person person = this.patientMap.get(ssn);
        if (person == null) {
            throw new NoSuchPatient();
        }
        return person;
    }

    public Doctor getDoctor(int docID) throws NoSuchDoctor {

        if (doctorMap.containsKey(docID)) {
            return doctorMap.get(docID);
        }
        throw new NoSuchDoctor();

    }

    public void assignPatientToDoctor(String ssn, int docID) throws NoSuchPatient, NoSuchDoctor {

        Person patient = this.getPatient(ssn);
        Doctor doctor = this.getDoctor(docID);

        patient.setDoctor(doctor);
        doctor.addPatient(patient);

    }

    Collection<Doctor> idleDoctors() {

        List<Doctor> doctorList = new LinkedList<>();

        for (Doctor doctor : this.doctorMap.values()) {
            if (doctor.patientCount() == 0) {
                doctorList.add(doctor);
            }
        }

        Collections.sort(doctorList);

        return doctorList;
    }

    Collection<Doctor> busyDoctors() {

        // barcha bemor  100
        // tayinlangan bemorlar  200   200/100
        List<Doctor> doctorList = new LinkedList<>();

        int patientCount = 0;

        for (Doctor doctor : this.doctorMap.values()) {
            patientCount += doctor.patientCount();
        }

        int avr = patientCount / this.patientMap.size();


        for (Doctor doctor : this.doctorMap.values()) {
            if (doctor.patientCount() > avr) {
                doctorList.add(doctor);
            }
        }

        Collections.sort(doctorList);

        return doctorList;
    }

    Collection<String> doctorsByNumPatients() {

        List<Doctor> doctorList = new LinkedList<>();
        for (Doctor doctor : this.doctorMap.values()) {
            doctorList.add(doctor);
        }

        Collections.sort(doctorList, new Comparator<Doctor>() {
            @Override
            public int compare(Doctor d1, Doctor d2) {
                int result = d2.patientCount() - d1.patientCount();
                if (result == 0) {
                    return d1.compareTo(d2);
                }
                return result;
            }
        });

        List<String> stringList = new LinkedList<>();

        for (Doctor doctor : doctorList) {
            String s = doctor.patientCount() + ": " + doctor.getId() + " " + doctor.getLast() + " " + doctor.getFirst();
            stringList.add(s);
        }

        return stringList;
    }

    public Collection<String> countPatientsPerSpecialization() {

        List<PatientCountSpecialization> pcSp = new LinkedList<>();

        for (Doctor doctor : this.doctorMap.values()) {
            pcSp.add(new PatientCountSpecialization(doctor.patientCount(), doctor.getSpecialization()));
        }


        Collections.sort(pcSp);

        List<String> stringList = new LinkedList<>();
        for (PatientCountSpecialization p : pcSp) {
            String s = p.getPatientCount() + " - " + p.getSpName();
            stringList.add(s);
        }

        return stringList;
    }


}
