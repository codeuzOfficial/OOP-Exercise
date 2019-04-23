package code_uz._04_Formula_1_Solution;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Championship {

    private List<Driver> driverList = new LinkedList<>();
    private List<GP> gpList = new LinkedList<>();
    private List<Time> timeList = new LinkedList<>();

    public Driver createDriver(String name) {
        Driver driver = new Driver(name);
        driverList.add(driver);

        return driver;
    }

    public Collection<Driver> getDrivers() {
        return driverList;
    }


    public Driver getDriver(String name) {
        for (Driver driver : driverList) {
            if (driver.getName().equals(name)) {
                return driver;
            }
        }
        return null;
    }


    public GP defineGrandPrix(String name) {
        GP gp = new GP(name);
        this.gpList.add(gp);
        return gp;
    }

    public GP getGrandPrix(String name) {
        for (GP gp : gpList) {
            if (gp.getName().equals(name)) {
                return gp;
            }
        }
        return null;
    }

    public Time setTime(GP gp, Driver driver, int hours, int min, int sec, int ms) {
        Time time = new Time(gp, driver, hours, min, sec, ms);
        this.timeList.add(time);

        gp.addTime(time);
        driver.addTime(time);

        return time;
    }


    public List<Driver> getChampionshipRanking() {
        Collections.sort(this.driverList);
        return driverList;
    }

}
