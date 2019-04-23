package code_uz._06_Flat_Rent_Solution;

import java.util.Collection;

/**
 * OOP
 * _Flat_Rent
 */
public class Main {

    public static void main(String[] args) throws Exception {


        System.out.println("Talab 1:  " + talab_1());
        System.out.println("Talab 2:  " + talab_2());
        System.out.println("Talab 3:  " + talab_3());
        System.out.println("Talab 4:  " + talab_4());

    }


    public static boolean talab_1() {

        Manager manager = new Manager();

        Flat f1 = manager.newFlat("F1", 100);
        Flat f2 = manager.newFlat("F2", 110);


        f1.setTariffs(new double[]{100, 200, 250});

        //# test1
        if (f1 == null || f2 == null) {
            System.err.println("talab_1: test1  null qiymat  ERROR");
            return false;
        }

        //# test2
        if (!f1.getCode().equals("F1")) {
            System.err.println("talab_1: test2 Kvartiraning kodi xato ERROR");
            return false;
        }

        //# test3
        if (!f2.getCode().equals("F2")) {
            System.err.println("talab_1: test3 Kvartiraning kodi xato ERROR");
            return false;
        }

        //# test4
        if (f1.getDimension() != 100) {
            System.err.println("talab_1: test4 Kvartiraning kodi xato ERROR");
            return false;
        }

        //# test5
        if (f1.getTariffs() == null) {
            System.err.println("talab_1: test5 tariflar qani ERROR");
            return false;
        }

        //# test6
        if (f1.getTariffs()[0] != 100) {
            System.err.println("talab_1: test5 bu tarif qayerdan keldi ERROR");
            return false;
        }

        return true;
    }

    public static boolean talab_2() {

        Manager manager = new Manager();

        Client client1 = manager.newClient("Ali", "Aliyev", "id1");
        Client client2 = manager.newClient("Vali", "Valiyev", "id2");

        Client test1 = manager.getClient("id2");

        //# test1
        if (test1 == null) {
            System.err.println("talab_2: test1  Mijoz (Vali) qayerda  ERROR");
            return false;
        }

        //# test2
        if (test1.getID() == null || !test1.getID().equals("id2")) {
            System.err.println("talab_2: test2  Mijozni Idsi qani  ERROR");
            return false;
        }

        Collection<Client> collection = manager.getClients();

        //# test3
        if (collection == null || collection.size() != 2) {
            System.err.println("talab_2: test3  Mijozlar ro'yxati qani  ERROR");
            return false;
        }

        return true;
    }

    public static boolean talab_3() {

        Manager manager = new Manager();

        Flat f1 = manager.newFlat("F1", 100);
        Flat f2 = manager.newFlat("F2", 110);

        f1.setTariffs(new double[]{100, 200, 300});
        f2.setTariffs(new double[]{200, 250, 300});

        Client client1 = manager.newClient("Ali", "Aliyev", "id1");
        Client client2 = manager.newClient("Vali", "Valiyev", "id2");

        Booking booking1 = manager.bookFlat("F1", "id1", 2, 3, 2015, 1);
        Booking booking2 = manager.bookFlat("F2", "id2", 4, 6, 2015, 2);

        //# test1
        if (booking1 == null || booking2 == null) {
            System.err.println("talab_3: test1  null qiymat keldi ERROR");
            return false;
        }

        //# test2
        if (booking1.getClient() == null || !booking1.getClient().getID().equals("id1")) {
            System.err.println("talab_3: test2  buyurtmada mijoz qani  ERROR");
            return false;
        }
        //# test3
        if (booking1.getFlat() == null || !booking1.getFlat().getCode().equals("F1")) {
            System.err.println("talab_3: test3  buyurtmada kvartira qani  ERROR");
            return false;
        }

        double test4 = booking1.getPrice();
        double test5 = booking2.getPrice();

        if (test4 != 100.0) {
            System.err.println("talab_3: test4  birinchi buyurtmani narxi 100 ga teng bo'lishi kerak  ERROR");
            return false;
        }

        if (test5 != 500.0) {
            System.err.println("talab_3: test5 ikkinchi buyurtmani narxi 500 ga teng bo'lishi kerak  ERROR");
            return false;
        }

        return true;
    }

    public static boolean talab_4() {

        Manager manager = new Manager();

        Flat f1 = manager.newFlat("F1", 100);
        Flat f2 = manager.newFlat("F2", 110);

        f1.setTariffs(new double[]{100, 200, 300});
        f2.setTariffs(new double[]{200, 250, 300});

        Client client1 = manager.newClient("Ali", "Aliyev", "id1");
        Client client2 = manager.newClient("Vali", "Valiyev", "id2");

        Booking booking1 = manager.bookFlat("F1", "id1", 2, 3, 2015, 1);
        Booking booking2 = manager.bookFlat("F2", "id2", 4, 6, 2015, 2);


        boolean[] f1FreeWeeks = f1.getAvailability();
        boolean[] f2FreeWeeks = f2.getAvailability();

        //# test1
        if (f1FreeWeeks == null || f1FreeWeeks.length != 52 || f2FreeWeeks == null || f2FreeWeeks.length != 52) {
            System.err.println("talab_4: test1  haftalarni bildiradigan array qani ERROR");
            return false;
        }

        //# test2
        if (f1FreeWeeks[14]) { // 14 index false bo'lishi kerak
            System.err.println("talab_4: test2 kelgan arrayni 14 index da false bo'lishi kerak (shu hafta band degan manoda) ERROR");
            return false;
        }

        //# test3
        if (f2FreeWeeks[27] || f2FreeWeeks[28]) {
            System.err.println("talab_4: test3 kelgan arrayni 25, 26  index da false bo'lishi kerak (shu hafta band degan manoda) ERROR");
            return false;
        }

        return true;
    }
}
