package code_uz._08_Taxi_Company_Solution;

public class Trip {

    private Place from;
    private Place to;

    public Trip(Place from, Place to) {
        this.from = from;
        this.to = to;
    }

    public String toString() {
        return this.from + " , " + this.to;
    }

}
