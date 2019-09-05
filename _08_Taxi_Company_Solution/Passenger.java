package code_uz._08_Taxi_Company_Solution;

public class Passenger {

    private Place position;
    private Place destination;


    public Passenger(Place position) {
        this.position = position;
    }

    public Place getPlace() {
        return position;
    }

    public void setDestination(Place destination) {
        this.destination = destination;
    }

    public void terminateTrip() {
        this.position = this.destination;
    }

    public Place getPosition() {
        return position;
    }

    public Place getDestination() {
        return destination;
    }
}
