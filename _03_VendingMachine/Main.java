package code_uz._03_VendingMachine;

public class Main {

    private static VendingMachine vendingMachine;

    public static void main(String[] args) {
        //# addBeverage

       /* vendingMachine = new VendingMachine();

        vendingMachine.addBeverage("Suv", 1000);
        vendingMachine.addBeverage("Gazlangan Suv", 1200);
        vendingMachine.addBeverage("Coca Cola", 3200);
        vendingMachine.addBeverage("Pepsi", 2500);
        vendingMachine.addBeverage("Fanta", 3300);
        vendingMachine.addBeverage("Sharbat", 1500);
        vendingMachine.addBeverage("Ayron", 1100);*/

        //
        // System.out.println("getPriceTest():   VendingMachine.getPrice()  " + getPriceTest());

        //# rechargeCard
       /* vendingMachine.rechargeCard(1, 2000);
        vendingMachine.rechargeCard(2, 15000);
        vendingMachine.rechargeCard(3, 25000);
        vendingMachine.rechargeCard(1, 2500);*/

        //
        //  System.out.println("getCreditTest():   VendingMachine.getCredit()  " + getCreditTest());

       /* vendingMachine.refillColumn(1, "Suv", 5);
        vendingMachine.refillColumn(2, "Coca Cola", 10);
        vendingMachine.refillColumn(3, "Sharbat", 2);
        vendingMachine.refillColumn(4, "Suv", 8);
        */

        //
        // System.out.println("availableCansTest():   VendingMachine.availableCans()  " + availableCansTest());

        //
        // System.out.println("sellTest():   VendingMachine.sell()  " + sellTest());

    }

    private static boolean getPriceTest() {

        double test1 = vendingMachine.getPrice("Suv");
        if (test1 != 1000) {
            System.err.println("getPriceTest: test1 ERROR");
            return false;
        }


        double test2 = vendingMachine.getPrice("Fanta");
        if (test2 != 3300) {
            System.err.println("getPriceTest: test2 ERROR");
            return false;
        }

        double test3 = vendingMachine.getPrice("Ayron");
        if (test3 != 1100) {
            System.err.println("getPriceTest: test3 ERROR");
            return false;
        }


        double test4 = vendingMachine.getPrice("Asal choy");
        if (test4 != -1) {
            System.err.println("getPriceTest: test4 ERROR");
            return false;
        }
        return true;

    }

    private static boolean getCreditTest() {
        double test1 = vendingMachine.getCredit(2);
        if (test1 != 15000) {
            System.err.println("getCreditTest: test1 ERROR ");
            return false;
        }

        double test2 = vendingMachine.getCredit(1);
        if (test2 != 4500) {
            System.err.println("getCreditTest: test2 ERROR");
            return false;
        }

        return true;
    }

    private static boolean availableCansTest() {
        int test1 = vendingMachine.availableCans("Suv");
        if (test1 != 13) {
            System.err.println("availableCansTest: test1 ERROR");
            return false;
        }

        int test2 = vendingMachine.availableCans("Sharbat");
        if (test2 != 2) {
            System.err.println("availableCansTest: test2 ERROR");
            return false;
        }

        return true;
    }

    private static boolean sellTest() {
        int test1 = vendingMachine.sell("Suv", 2);
        if (test1 != 1) {
            System.out.println("sellTest: test1 ERROR");
            return false;
        }

        int test2 = vendingMachine.sell("Coca Cola", 1);
        if (test2 != 2) {
            System.out.println("sellTest: test2 ERROR");
            return false;
        }


        int test3 = vendingMachine.sell("Coca Cola", 1);
        if (test3 != -1) {
            System.out.println("sellTest: test2 ERROR");
            return false;
        }

        int test4 = vendingMachine.sell("Asal choy", 3);
        if (test4 != -1) {
            System.out.println("sellTest: test2 ERROR");
            return false;
        }


        return true;
    }
}
