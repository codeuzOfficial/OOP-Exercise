package code_uz._04_Formula_1;

import java.util.Collection;
import java.util.List;

public class Main {

    private static Championship championship;

    public static void main(String[] args) {
        championship = new Championship();

        // createDriver
      /*  Driver driver_Ali = championship.createDriver("Ali");
        Driver driver_Vali = championship.createDriver("Vali");
        Driver driver_Bob = championship.createDriver("Bob");
        Driver driver_Afandi = championship.createDriver("Afandi"); */

        // getDrivers
       /* Collection<Driver> driverCollection = championship.getDrivers();
        boolean test1 = driverCollection.contains(driver_Ali);
        if (!test1) {
            System.err.println("test1: Haydovchi 'Ali'   topilmadi ERROR");
            System.exit(-1);
        }

        boolean test2 = driverCollection.contains(driver_Bob);
        if (!test2) {
            System.err.println("test2: Haydovchi 'Bob' topilmadi ERROR");
            System.exit(-1);
        }*/

        // getDriver()
       /* Driver test3 = championship.getDriver("Afandi");
        if (test3 == null) {
            System.err.println("test3: Voy  'Afandi' topilmadiyu ERROR");
            System.exit(-1);
        }

        Driver test4 = championship.getDriver("Qorbobo");
        if (test4 != null) {
            System.err.println("test4: Voy  'Qorbobo' qattan keldi ERROR");
            System.exit(-1);
        }

        // defineGrandPrix()
        GP gp_1 = championship.defineGrandPrix("GP1");
        GP gp_2 = championship.defineGrandPrix("GP2");
*/

        //getGrandPrix()
       /* GP test5 = championship.getGrandPrix("GP1");
        if (test5 == null) {
            System.err.println("test5_1: Grand Pri  'GP1' topilmadi ERROR");
            System.exit(-1);
        } else if (test5.getName() == null) {
            System.err.println("test5_2: Grand Pri  'GP1' getName() dan null keldi ERROR");
            System.exit(-1);
        } else if (!test5.getName().equals("GP1")) {
            System.err.println("test5_3: Grand Pri  'GP1' o'rniga nima keldi? ERROR");
            System.exit(-1);
        }
*/
        // setTime()

       /* int hours = 0;
        int min = 50;
        int sec = 10;
        int ms = 33;

        Time gr_1_Ali_time = championship.setTime(gp_1, driver_Ali, hours, min, sec, ms);
        Time gr_1_Bob_time = championship.setTime(gp_1, driver_Bob, hours, min + 1, sec, ms);
        Time gr_1_Vali_time = championship.setTime(gp_1, driver_Vali, hours, min + 1, sec + 30, ms);
        Time gr_1_Afandi_time = championship.setTime(gp_1, driver_Afandi, hours, min - 1, sec + 10, ms); // Winner

        Time gr_2_Ali_time = championship.setTime(gp_2, driver_Ali, hours, min, sec, ms);
        Time gr_2_Bob_time = championship.setTime(gp_2, driver_Bob, hours, min, sec + 15, ms);
        Time gr_2_Vali_time = championship.setTime(gp_2, driver_Vali, hours, min, sec - 10, ms);
        Time gr_2_Afandi_time = championship.setTime(gp_2, driver_Afandi, hours, min, sec + 10, ms);
*/
        //toString()
        /*String test6 = gr_1_Ali_time.toString();
        if (!test6.equals(getTimeString(hours, min, sec, ms))) {
            System.err.println("test6: Vaqt hato keldi ERROR");
            System.exit(-1);
        }

        String test7 = gr_2_Bob_time.toString();
        if (!test7.equals(getTimeString(hours, min, sec + 15, ms))) {
            System.err.println("test7: Vaqt hato keldi ERROR");
            System.exit(-1);
        }
*/
        //getGPRanking()
       /* List<Driver> gp_1_driverList = gp_1.getGPRanking();
        //# test8
        if (!gp_1_driverList.get(0).getName().equals("Afandi")) {
            System.out.println("test8: Grand Pri 'GP_1' 'Afandi' 0 indexda bo'lishi kerak ERROR");
            System.exit(-1);
        }

        //# test9
        if (!gp_1.getGPRanking().get(1).getName().equals("Ali")) {
            System.out.println("test8: Grand Pri 'GP_1' da 'Ali' 1 chi indexda bo'lishi kerak ERROR ");
            System.exit(-1);
        }

        List<Driver> gp_2_driverList = gp_2.getGPRanking();
        //# test9
        if (!gp_2_driverList.get(0).getName().equals("Vali")) {
            System.out.println("test9: Grand Pri 'PG_2' da 'Vali' 0 indexda bo'lishi kerak ERROR");
            System.exit(-1);
        }

        //getPosition()
        int test10 = gp_1.getPosition(driver_Afandi);
        if (test10 != 1) {
            System.out.println("test10: 'Afandi' GP_1 da 1 chi o'rinni olgan ERROR");
            System.exit(-1);
        }

        int test11 = gp_1.getPosition(driver_Ali);
        if (test11 != 2) {
            System.out.println("test11: 'Ali' GP_2 da 2 chi o'rinni olgan ERROR");
            System.exit(-1);
        }*/

        //getRaced()

        /*Collection<GP> gpCollection_Vali = driver_Vali.getRaced();
        //# test12
        if (gpCollection_Vali.size() != 2) {
            System.out.println("test12: 'Vali' 2ta Grand Pri da qatnashgan ERROR");
            System.exit(-1);
        }
        //# test13
        if (!gpCollection_Vali.contains(gp_2)) {
            System.out.println("test13: 'Vali' 'GP_2' da qatnashgan ERROR");
            System.exit(-1);
        }

        Collection<GP> gpCollection_Ali = driver_Ali.getRaced();
        //# test14
        if (gpCollection_Ali.size() != 2) {
            System.out.println("test14: 'Ali' 2ta Grand Pri da qatnashgan ERROR");
            System.exit(-1);
        }
        //# test15
        if (!gpCollection_Ali.contains(gp_1)) {
            System.out.println("test15: 'Ali' 'GP_1' da qatnashgan ERROR");
            System.exit(-1);
        }*/

        //getPoints()
/*

        int test16 = driver_Ali.getPoints();
        if (test16 != 36) {
            System.out.println("test16: 'Ali' jami 36 ball to'plagan (2 ta Grand pridan ham 2-chi o'rinni olgan) ERROR");
            System.exit(-1);
        }

        int test17 = driver_Afandi.getPoints();
        if (test17 != 40) {
            System.out.println("test17: 'Afandi' jami 40 ball to'plagan (1 - (GP_1 da), 3 -(GP_2) o'rinlarni olgan) ERROR");
            System.exit(-1);
        }

        //getChampionshipRanking()
        List<Driver> driverList = championship.getChampionshipRanking();
        //# 18
        if (!driverList.get(0).getName().equals("Afandi")) {
            System.out.println("test18: 'Afandi' jami 40 ball to'plab jahon chempioni bo'ldi ERROR");
            System.exit(-1);
        }
        //# 19
        if (!driverList.get(2).getName().equals("Ali")) {
            System.out.println("test19: 'Ali' jami 36 ball to'plab 3-chi o'rinni oldi ERROR");
            System.exit(-1);
        }
        System.out.println("URA FORMULA 1 TUGADI!!!");
*/


    }

    private static String getTimeString(int hours, int min, int sec, int ms) {
        return hours + ":" + min + ":" + sec + "." + ms;
    }


}
