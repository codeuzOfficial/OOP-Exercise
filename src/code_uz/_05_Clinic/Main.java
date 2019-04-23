package code_uz._05_Clinic;

import javax.print.Doc;
import java.util.Collection;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        //    System.out.println("talab_1() -> :  " + talab_1()); // T1
        //    System.out.println("talab_2() -> :  " + talab_2()); // T2
        //    System.out.println("talab_3() -> :  " + talab_3()); // T3
        //    System.out.println("talab_4() -> :  " + talab_4()); // T4


    }

    private static boolean talab_1() {

        Clinic clinic = new Clinic();

        // addPatient()
        clinic.addPatient("Ali", "Aliyev", "ssn123");
        clinic.addPatient("Vali", "Valiyev", "ssn456");
        clinic.addPatient("Guli", "Gulihon", "789ssn");
        clinic.addPatient("Asal", "Asalhon", "231ssn");

        //getPatient()
        Person person;
        //# test1
        try {
            person = clinic.getPatient("ssn123");
            if (person == null) {
                System.err.println("getPatientTest -> test1: 'ssn123' ssn raqami 'Ali' ga tegishli  ERROR ");
                return false;
            }

            if (!person.getFirst().equals("Ali")) {
                System.err.println("getPatientTest -> test1: 'ssn123' ssn raqami 'Ali' ga tegishli  ERROR ");
                return false;
            }
        } catch (Exception e) {
            System.err.println("getPatientTest -> test1: 'ssn123' ssn raqami 'Ali' ga tegishli  ERROR ");
            return false;
        }

        //# test2
        person = null;
        try {
            person = clinic.getPatient("789ssn");
            if (person == null) {
                System.err.println("getPatientTest -> test1: 'ssn123' ssn raqami 'Guli' ga tegishli  ERROR ");
                return false;
            }

            if (!person.getFirst().equals("Guli")) {
                System.err.println("getPatientTest -> test1: 'ssn123' ssn raqami 'Guli' ga tegishli  ERROR ");
                return false;
            }
        } catch (Exception e) {
            System.err.println("getPatientTest -> test2: '789ssn' ssn raqami 'Guli' ga tegishli ERROR ");
            return false;
        }

        //# test3
        try {
            clinic.getPatient("testSSN");
        } catch (Exception e) {
            if (!(e instanceof NoSuchPatient)) {
                System.err.println("getPatientTest -> test3: 'testSSN' ssn raqami mavjut emas va NoSuchPatient istisnosi tashlanishi kerak ");
                return false;
            }
        }

        return true;

    }

    private static boolean talab_2() {

        //addDoctor()
        Clinic clinic = new Clinic();

        clinic.addDoctor("Bob", "Big Man", "bob123", 123, "Tish shifokori");
        clinic.addDoctor("Nemo", "Kapitan", "nemo123", 245, "Kardiolog");
        clinic.addDoctor("Jumong", "Chang chun", "chang123", 892, "Lo'r");
        clinic.addDoctor("Afandi", "Afandi", "afandi1", 5329, "Travmato'log");

        //getDoctor()
        Doctor doctor;
        //# test1
        try {
            doctor = clinic.getDoctor(123);
            if (doctor == null) {
                System.err.println("getDoctorTest -> test1: '123' idli  shifokor qani? ERROR ");
                return false;
            }

            if (!doctor.getFirst().equals("Bob")) {
                System.err.println("getDoctorTest -> test1: '123' idli  shifokorning ismi 'Bob' ERROR ");
                return false;
            }

        } catch (Exception e) {
            System.err.println("getDoctorTest -> test1: '123' idli  shifokor qani? ERROR ");
            return false;
        }

        //# test2
        try {
            doctor = clinic.getDoctor(892);
            if (doctor == null) {
                System.err.println("getDoctorTest -> test2: idsi '892' bo'lgan  shifokor qani? ERROR ");
                return false;
            }

            if (!doctor.getFirst().equals("Jumong")) {
                System.err.println("getDoctorTest -> test2: idsi '892' bo'lgan  shifokorning ismi 'Jumong' ERROR ");
                return false;
            }

        } catch (Exception e) {
            System.err.println("getDoctorTest -> test2: idsi '892' bo'lgan  shifokor qani? ERROR ");
            return false;
        }

        //#test3
        try {
            clinic.getDoctor(123456);
        } catch (Exception e) {
            if (!(e instanceof NoSuchDoctor)) {
                System.err.println("getDoctorTest -> test3: '123456' idli shifokor mavjut emasku. Demak  NoSuchPatient istisnosi tashlanishi kerak ERROR");
                return false;
            }
        }

        return true;

    }

    private static boolean talab_3() {

        Clinic clinic = new Clinic();

        // addPatient()
        clinic.addPatient("Ali", "Aliyev", "ssn123");
        clinic.addPatient("Vali", "Valiyev", "ssn456");
        clinic.addPatient("Guli", "Gulihon", "789ssn");
        clinic.addPatient("Asal", "Asalhon", "231ssn");

        // addDoctor()
        clinic.addDoctor("Bob", "Big Man", "bob123", 123, "Tish shifokori");
        clinic.addDoctor("Nemo", "Kapitan", "nemo123", 245, "Kardiolog");
        clinic.addDoctor("Jumong", "Chang chun", "chang123", 892, "Lo'r");
        clinic.addDoctor("Afandi", "Afandi", "afandi1", 5329, "Travmato'log");

        //#test1
        try {
            clinic.assignPatientToDoctor("ssn123", 123); // Ali,Bob
        } catch (Exception e) {
            System.err.println("talab_3 -> test1: buyerda xammasi chiroyli bo'lishi kerak edi? ERROR");
            return false;
        }

        //#test2
        try {
            clinic.assignPatientToDoctor("ssn456", 123);// Vali ,Bob
        } catch (Exception e) {
            System.err.println("talab_3 -> test2: buyerda xammasi chiroyli bo'lishi kerak edi? ERROR");
            return false;
        }

        //#test3
        try {
            clinic.assignPatientToDoctor("789ssn", 892); // Guli,Jumong
        } catch (Exception e) {
            System.err.println("talab_3 -> test3: buyerda xammasi chiroyli bo'lishi kerak edi? ERROR ");
            return false;
        }


        //#test4
        try {
            clinic.assignPatientToDoctor("12345678", 892); // ?,Jumong
        } catch (Exception e) {
            if (!(e instanceof NoSuchPatient)) {
                System.err.println("talab_3 -> test4: NoSuchPatient istisnosi tashlanishi kerak ERROR ");
                return false;
            }

        }

        //#test5
        try {
            clinic.assignPatientToDoctor("231ssn", 1234567); // Asal,?
        } catch (Exception e) {
            if (!(e instanceof NoSuchDoctor)) {
                System.err.println("talab_3 -> test4: NoSuchDoctor istisnosi tashlanishi kerak ERROR ");
                return false;
            }

        }

        //#test6  -->  Person.getDoctor()
        try {
            Person person = clinic.getPatient("ssn123");
            Doctor doctor = person.getDoctor(); // Bob
            if (doctor == null) {
                System.err.println("talab_3 -> test6: Person.getDoctor():  Alini davolayotgan  shifokori qani ERROR ");
                return false;
            }

            if (!doctor.getFirst().equals("Bob")) {
                System.err.println("talab_3 -> test6: Person.getDoctor():  Alini  davolayotgan  shifokorning ismi 'Bob' ERROR ");
                return false;
            }

        } catch (Exception e) {
            System.err.println("talab_3 -> test6: Person.getDoctor(): buyerda xammasi chiroyli bo'lishi kerak edi? ERROR");
            return false;
        }


        //#test7  -->  Person.getPatients()
        try {
            Doctor doctor = clinic.getDoctor(123);// Bob
            Collection<Person> bemorList = doctor.getPatients();
            if (bemorList == null) {
                System.err.println("talab_3 -> test7: Doctor.getPatients():  bemorlar ro'yxati qani ERROR ");
                return false;
            }

            if (bemorList.size() != 2) {
                System.err.println("talab_3 -> test7: Doctor.getPatients(): bemorlar ro'yxatida 2 ta bemor bo'lishi kerak ERROR ");
                return false;
            }

        } catch (Exception e) {
            System.err.println("talab_3 -> test7: Doctor.getPatients(): buyerda xammasi chiroyli bo'lishi kerak edi? ERROR");
            return false;
        }


        return true;

    }

    private static boolean talab_4() {

        Clinic clinic = new Clinic();

        // addPatient()
        clinic.addPatient("Ali", "Aliyev", "ssn123");
        clinic.addPatient("Vali", "Valiyev", "ssn456");
        clinic.addPatient("Guli", "Gulihon", "789ssn");
        clinic.addPatient("Asal", "Asalhon", "231ssn");

        // addDoctor()
        clinic.addDoctor("Bob", "Big Man", "bob123", 123, "Tish shifokori");
        clinic.addDoctor("Nemo", "Kapitan", "nemo123", 245, "Kardiolog");
        clinic.addDoctor("Jumong", "Chang chun", "chang123", 892, "Lo'r");
        clinic.addDoctor("Afandi", "Afandi", "afandi1", 5329, "Travmato'log");

        // assignPatientToDoctor()
        try {
            clinic.assignPatientToDoctor("ssn123", 892); // Ali,Jumong
            clinic.assignPatientToDoctor("ssn456", 892); // Vali,Jumong
            clinic.assignPatientToDoctor("789ssn", 245); // Guli,Nemo
        } catch (Exception e) {
            System.err.println("talab_4 ->  buyerda xammasi chiroyli bo'lishi kerak  ERROR");
            return false;
        }
        //idleDoctors()
        //# test1
        Collection<Doctor> idleDoctors = clinic.idleDoctors(); // Afandi,Bob
        if (idleDoctors == null || idleDoctors.size() != 2) {
            System.err.println("talab_4 -> test1:  ro'yhatda 2 ta shifokor bo'lishi kerak  ERROR");
            return false;
        }

        List<Doctor> doctorList = (List<Doctor>) idleDoctors;
        if (!doctorList.get(0).getFirst().equals("Afandi")) {
            System.err.println("talab_4 -> test1:  ro'yhat boshida 'Afandi'  bo'lishi kerak  ERROR");
            return false;
        }

        if (!doctorList.get(1).getFirst().equals("Bob")) {
            System.err.println("talab_4 -> test1:  ro'yhatda ikkinchi 'Bob'  bo'lishi kerak  ERROR");
            return false;
        }

        //busyDoctors
        //#test2
        Collection<Doctor> busyDoctors = clinic.busyDoctors();
        if (busyDoctors == null || busyDoctors.size() != 2) {
            System.err.println("talab_4 -> test2:  ro'yhatda 2 ta shifokor bo'lishi kerak  ERROR");
            return false;
        }
        List<Doctor> busyDoctorList = (List<Doctor>) busyDoctors;
        if (!busyDoctorList.get(0).getFirst().equals("Jumong")) {
            System.err.println("talab_4 -> test1:  ro'yhat boshida 'Jumong'  bo'lishi kerak  ERROR");
            return false;
        }


        //doctorsByNumPatients
        //#test3
        Collection<String> doctorsByNumPatients = clinic.doctorsByNumPatients();
        if (doctorsByNumPatients == null || doctorsByNumPatients.size() != 4) {
            System.err.println("talab_4 -> test2:  ro'yhatda 4 ta shifokor bo'lishi kerak  ERROR");
            return false;
        }

        List<String> doctorsByNumPatientList = (List<String>) doctorsByNumPatients;
        if (!doctorsByNumPatientList.get(0).equals("  2: Jumong Chang chun")) {
            System.err.println("talab_4 -> test3:  ro'yhat boshida '  2: Jumong Chang chun'  bo'lishi kerak  ERROR");
            return false;
        }

        if (!doctorsByNumPatientList.get(2).equals("  0: Afandi Afandi")) {
            System.err.println("talab_4 -> test3:  ro'yhatda 2-chi index da  '  0: Afandi Afandi'  bo'lishi kerak  ERROR");
            return false;
        }

        // countPatientsPerSpecialization
        //#test4
        Collection<String> countPatientsPerSpecializations = clinic.countPatientsPerSpecialization();
        if (countPatientsPerSpecializations == null || countPatientsPerSpecializations.size() != 4) {
            System.err.println("talab_4 -> test2:  ro'yhatda 4 ta shifokor bo'lishi kerak  ERROR");
            return false;
        }

        List<String> countPatientsPerSpecializationList = (List<String>) countPatientsPerSpecializations;
        if (!countPatientsPerSpecializationList.get(0).equals("  2 Lo'r")) {
            System.err.println("talab_4 -> test3:  ro'yhat boshida '  2: Jumong Chang chun'  bo'lishi kerak  ERROR");
            return false;
        }

        if (!countPatientsPerSpecializationList.get(2).equals("  0 Tish shifokori")) {
            System.err.println("talab_4 -> test3:  ro'yhatda 2-chi index da  '  0: Afandi Afandi'  bo'lishi kerak  ERROR");
            return false;
        }

        return true;
    }


}
