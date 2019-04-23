package code_uz._04_Formula_1_Solution;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class GP {
    private String name;
    private List<Time> timeList = new LinkedList<>();

    public GP(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addTime(Time time) {
        this.timeList.add(time);
    }

    public List<Driver> getGPRanking() {

        Collections.sort(timeList);

        List<Driver> driverList = new LinkedList<>();
        for (Time time : timeList) {
            driverList.add(time.getDriver());
        }

        return driverList;
    }


    public int getPosition(Driver driver) {
        Collections.sort(timeList);
        int count = 1;
        for (Time time : timeList) {
            if (time.getDriver().equals(driver)) {
                return count;
            }
            count++;
        }
        return 0;
    }

}
