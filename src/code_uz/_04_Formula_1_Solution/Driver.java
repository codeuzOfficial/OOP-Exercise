package code_uz._04_Formula_1_Solution;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Driver implements Comparable<Driver> {
    private String name;

    private List<Time> timeList = new ArrayList<>();

    private int points[] = {25, 18, 15, 12, 10, 8, 6, 4, 2, 1};

    public Driver(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Collection<GP> getRaced() {
        List<GP> gpList = new ArrayList<>();
        for (Time time : this.timeList) {
            gpList.add(time.getGp());
        }
        return gpList;
    }

    public int getPoints() {
        int sum = 0;
        for (Time time : this.timeList) {
            int position = time.getGp().getPosition(this);
            sum += points[position - 1];
        }
        return sum;
    }


    @Override
    public boolean equals(Object obj) {
        Driver d = (Driver) obj;
        return this.name.equals(d.name);
    }

    public void addTime(Time time) {
        this.timeList.add(time);
    }

    @Override
    public int compareTo(Driver o) {
        return o.getPoints() - this.getPoints();
    }
}
