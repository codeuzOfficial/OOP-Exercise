package code_uz._08_Taxi_Company_Solution;

import java.util.ArrayList;
import java.util.Collection;

/**
 * OOP
 * _Taxi_Company
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("talab_1: " + talab_1());
        System.out.println("talab_2: " + talab_2());
        System.out.println("talab_3: " + talab_3());
        System.out.println("talab_4: " + talab_4());
        System.out.println("talab_5: " + talab_5());
    }

    public static boolean talab_1() {

        TaxiCompany taxiCompany = new TaxiCompany();

        //# test1
        try {
            taxiCompany.addTaxi("t1");
            taxiCompany.addTaxi("t2");

        } catch (InvalidTaxiName invalidTaxiName) {
            System.err.println("talab_1: test1  taksi normal holatta qo'shilishi kerak edi ERROR");
            return false;
        }

        //# test2
        try {
            taxiCompany.addTaxi("t1");
            System.err.println("talab_1: test2   't1' idli taksi ro'yhatta borku. InvalidTaxiName istisnosi tashlanishi kerak edi ERROR");
            return false;
        } catch (InvalidTaxiName invalidTaxiName) {

        }

        //# test3
        Collection<Taxi> taxiCollection = taxiCompany.getAvailable();
        if (taxiCollection == null) {
            System.err.println("talab_1: test3  bo'sh taksilar ro'yhati qani ERROR");
            return false;
        }

        //# test4
        if (taxiCollection.size() != 2) {
            System.err.println("talab_1: test4  bo'sh taksilar ro'yhatida 2ta taksi bo'lishi kerak ERROR");
            return false;
        }

        return true;
    }

    public static boolean talab_2() {

        TaxiCompany taxiCompany = new TaxiCompany();

        Place place1 = new Place("address1", "Mirobod");
        Place place2 = new Place("address2", "Yunusobod");

        //# test1
        if (place1 == null || place2 == null) {
            System.err.println("talab_2: test1  null qiymat keldi ERROR");
            return false;
        }

        //# test2
        if (!place1.toString().equals("address1")) {
            System.err.println("talab_2: test2  address qani ERROR");
            return false;
        }


        Passenger passenger = new Passenger(place1);
        //# test3
        if (passenger.getPlace() == null) {
            System.err.println("talab_2: test3  Passenger da Place qani ERROR");
            return false;
        }

        //# test4
        if (!passenger.getPlace().toString().equals(place1.toString())) {
            System.err.println("talab_2: test4  voy nito address keldi ERROR");
            return false;
        }

        return true;
    }

    public static boolean talab_3() {

        TaxiCompany taxiCompany = new TaxiCompany();

        try {
            taxiCompany.addTaxi("t1");
            taxiCompany.addTaxi("t2");

        } catch (InvalidTaxiName invalidTaxiName) {
            invalidTaxiName.printStackTrace();
        }

        Place place1 = new Place("address1", "Mirobod");
        Place place2 = new Place("address2", "Yunusobod");

        Passenger passenger1 = new Passenger(place1);
        Passenger passenger2 = new Passenger(place2);


        Taxi taxi1 = taxiCompany.callTaxi(passenger1);

        //# test1
        if (taxi1 == null) {
            System.err.println("talab_3: test1  Voy bosh taksi qani ERROR");
            return false;
        }

        //# test2
        if (!taxi1.toString().equals("t1")) {
            System.err.println("talab_3: test2 idsi 't1' ga teng bo'lgan taksi navbatta birinchi bo'lishi kerak edi ERROR");
            return false;
        }

        Taxi taxi2 = taxiCompany.callTaxi(passenger2);

        Taxi taxi3 = taxiCompany.callTaxi(passenger1);

        //# test3
        if (taxi3 != null) {
            System.err.println("talab_3: test3 bosh taksi qolmagan edi bu qayerdan keldi edi ERROR");
            return false;
        }

        int lostCallNumber = taxiCompany.getLostTrips();
        //# test4
        if (lostCallNumber != 1) {
            System.err.println("talab_3: test4 bekor qilingan chaqiruvlar soni 1ga teng bo'lishi kerak ERROR");
            return false;
        }


        taxi1.beginTrip(new Place("address1_1", "Nazarbek"));
        taxi2.beginTrip(new Place("address2_2", "Chilonzor"));

        taxi1.terminateTrip();
        taxi2.terminateTrip();

        //# test5
        if (!passenger1.getPlace().toString().equals("address1_1")) {
            System.err.println("talab_3: test5 yo'lovchi manzilga borgandan keyin uning joyi o'zgarishi kerak ERROR");
            return false;
        }

        Collection<Taxi> taxiCollection = taxiCompany.getAvailable();
        //# test6
        if (taxiCollection == null) {
            System.err.println("talab_3: test6 bosh taksilar ro'yhati qani ERROR");
            return false;
        }

        //# test7
        if (taxiCollection.size() != 2) {
            System.err.println("talab_3: test7 bosh taksilar ro'yhatida 2ta taksi bo'lishi kerakku ular 'boshagan edi' ERROR");
            return false;
        }

        return true;

    }

    public static boolean talab_4() {
        TaxiCompany taxiCompany = new TaxiCompany();

        try {
            taxiCompany.addTaxi("t1");
            taxiCompany.addTaxi("t2");

        } catch (InvalidTaxiName invalidTaxiName) {
            invalidTaxiName.printStackTrace();
        }

        Place place1 = new Place("address1", "Mirobod");
        Place place2 = new Place("address2", "Yunusobod");

        Passenger passenger1 = new Passenger(place1);
        Passenger passenger2 = new Passenger(place2);

        Taxi taxi1_1 = taxiCompany.callTaxi(passenger1);
        Taxi taxi2 = taxiCompany.callTaxi(passenger2);

        taxi1_1.beginTrip(new Place("address1_1", "Nazarbek"));
        taxi2.beginTrip(new Place("address2_2", "Chilonzor"));

        taxi1_1.terminateTrip();
        taxi2.terminateTrip();

        Taxi taxi1_2 = taxiCompany.callTaxi(passenger2);
        taxi1_2.beginTrip(new Place("address1_2", "Qoraqamish"));

        taxi1_2.terminateTrip();

        Collection<Trip> tripCollection;
        //# test1
        try {
            tripCollection = taxiCompany.getTrips("t1");
        } catch (InvalidTaxiName invalidTaxiName) {
            System.err.println("talab_4: test1  't1' taksi topilmadimi   ERROR");
            return false;
        }

        //# test2
        if (tripCollection == null) {
            System.err.println("talab_4: test2  't1' taksining sayyohatlar ro'yhati qani ERROR");
            return false;
        }

        //# test3
        if (tripCollection.size() != 2) {
            System.err.println("talab_4: test3  't1' taksining sayyohatlar ro'yhatida ikkita sayyohat bo'lishi kerak ERROR");
            return false;
        }


        return true;
    }

    public static boolean talab_5() {

        TaxiCompany taxiCompany = new TaxiCompany();

        try {
            taxiCompany.addTaxi("t1");
            taxiCompany.addTaxi("t2");

        } catch (InvalidTaxiName invalidTaxiName) {
            invalidTaxiName.printStackTrace();
        }

        Place place1 = new Place("address1", "Mirobod");
        Place place2 = new Place("address2", "Yunusobod");

        Passenger passenger1 = new Passenger(place1);
        Passenger passenger2 = new Passenger(place2);

        Taxi taxi1_1 = taxiCompany.callTaxi(passenger1);
        Taxi taxi2_1 = taxiCompany.callTaxi(passenger2);

        taxi1_1.beginTrip(new Place("address1_1", "Nazarbek"));
        taxi2_1.beginTrip(new Place("address2_2", "Chilonzor"));

        taxi1_1.terminateTrip();
        taxi2_1.terminateTrip();


        Taxi taxi1_2 = taxiCompany.callTaxi(passenger2);
        taxi1_2.beginTrip(new Place("address2_2", "Nazarbek"));

        taxi1_2.terminateTrip();

        ArrayList<InfoI> taxiTripList = taxiCompany.statsTaxi();

        //# test1
        if (taxiTripList == null) {
            System.err.println("talab_5: test1 voy  tugatilgan sayyohatlar ro'yhati qani ERROR");
            return false;
        }

        //# test2
        if (taxiTripList.size() != 2) {
            System.err.println("talab_5: test2  tugatilgan sayyohatlar ro'yhat soni xato ERROR");
            return false;
        }

        //# test3
        if (!taxiTripList.get(0).getId().equals("t1")) {
            System.err.println("talab_5: test3  tugatilgan sayyohatlar ro'yhat hato tuzilgan  ERROR");
            return false;
        }

        ArrayList<InfoI> districtStat = taxiCompany.statsDistricts();

        //# test4
        if (districtStat == null) {
            System.err.println("talab_5: test4  tuman/mahalla ro'yhat qani  ERROR");
            return false;
        }

        //# test5
        if (districtStat.size() != 2) {
            System.err.println("talab_5: test5  tuman/mahalla ro'yhati soni hato keldi  ERROR");
            return false;
        }

        //# test6
        if (!districtStat.get(0).getId().equals("Nazarbek")) {
            System.err.println("talab_5: test6  tuman/mahalla ro'yhati hato tuzilgan  ERROR");
            return false;
        }

        return true;
    }
}
