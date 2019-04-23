package code_uz._05_Clinic_Solution_;

public class PatientCountSpecialization implements Comparable<PatientCountSpecialization> {

    private int patientCount;
    private String spName;

    public PatientCountSpecialization(int patientCount, String spName) {
        this.patientCount = patientCount;
        this.spName = spName;
    }

    public int getPatientCount() {
        return patientCount;
    }

    public String getSpName() {
        return spName;
    }

    @Override
    public int compareTo(PatientCountSpecialization o) {
        int result = o.patientCount - this.patientCount;
        if (result == 0) {
            return this.spName.compareTo(o.spName);
        }
        return result;
    }
}
