package code_uz._05_Clinic;

import java.io.IOException;
import java.util.Collection;

public class Clinic {

	public void addPatient(String firstName, String lastName, String ssn) {

	}

	public void addDoctor(String firstName, String lastName, String ssn, int docID, String specialization) {

	}

	public Person getPatient(String ssn) throws NoSuchPatient {
		return null;
	}

	public Doctor getDoctor(int docID) throws NoSuchDoctor {
		return null;
	}
	
	public void assignPatientToDoctor(String ssn, int docID) throws NoSuchPatient, NoSuchDoctor {

	}

	Collection<Doctor> idleDoctors(){
		return null;
	}

	Collection<Doctor> busyDoctors(){
		return null;
	}

	Collection<String> doctorsByNumPatients(){
		return null;
	}

	public Collection<String> countPatientsPerSpecialization(){
		return null;
	}
	
	public void loadData(String path) throws IOException {
		
	}


}
