package code_uz._04_Formula_1_Solution;


public class Time implements Comparable<Time> {

    private GP gp;
    private Driver driver;

    private int hours;
    private int min;
    private int sec;
    private int ms;

    public Time(GP gp, Driver driver, int hours, int min, int sec, int ms) {
        this.gp = gp;
        this.driver = driver;
        this.hours = hours;
        this.min = min;
        this.sec = sec;
        this.ms = ms;
    }

    public Driver getDriver() {
        return driver;
    }

    @Override
    public String toString() {
        return hours + ":" + min + ":" + sec + "." + ms;
    }

    public GP getGp() {
        return gp;
    }

    @Override
    public int compareTo(Time o) {
        int result = this.hours - o.hours;
        if (result == 0) {
            result = this.min - o.min;
            if (result == 0) {
                result = this.sec - o.sec;
                if (result == 0) {
                    return this.ms - o.ms;
                }
            }
        }

        return result;
    }
}
