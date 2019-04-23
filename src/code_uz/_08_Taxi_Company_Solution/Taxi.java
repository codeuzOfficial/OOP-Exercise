package code_uz._08_Taxi_Company_Solution;

import java.util.LinkedList;
import java.util.List;

public class Taxi implements InfoI {

    private String id;
    private Passenger passenger;
    private TaxiCompany taxiCompany;

    private List<Trip> tripList = new LinkedList<>();

    public Taxi(String id) {
        this.id = id;
    }

    public String toString() {
        return id;
    }

    public void beginTrip(Place dest) {
        this.passenger.setDestination(dest);

    }

    public void terminateTrip() {

        this.tripList.add(new Trip(this.passenger.getPosition(), this.passenger.getDestination()));
        this.taxiCompany.endTrip(this.passenger.getDestination().getDistric());

        this.passenger.terminateTrip();
        this.taxiCompany.addFreeTaxi(this);
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public void setTaxiCompany(TaxiCompany taxiCompany) {
        this.taxiCompany = taxiCompany;
    }

    public List<Trip> getTripList() {
        return tripList;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public int getValue() {
        return this.tripList.size();
    }

    @Override
    public int compareTo(InfoI o) {
        Taxi taxi = (Taxi) o;

        int result = taxi.tripList.size() - this.tripList.size();
        if (result == 0) {
            this.id.compareTo(taxi.id);
        }
        return result;
    }
}
