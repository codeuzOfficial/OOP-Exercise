package code_uz._08_Taxi_Company_Solution;

import java.util.*;

public class TaxiCompany {

    private Map<String, Taxi> allTaxiMap = new TreeMap<>();
    private LinkedList<Taxi> freeTaxiList = new LinkedList<>();
    private Map<String, DistrictByTripCount> districtByTripCountMap = new TreeMap<>();

    private int lostTrips;

    public void addTaxi(String id) throws InvalidTaxiName {

        if (allTaxiMap.containsKey(id)) {
            throw new InvalidTaxiName();
        }

        Taxi taxi = new Taxi(id);
        this.allTaxiMap.put(id, taxi);
        this.freeTaxiList.add(taxi);


    }

    public Collection<Taxi> getAvailable() {
        return this.freeTaxiList;
    }

    public Taxi callTaxi(Passenger p) {

        Taxi taxi = freeTaxiList.poll();

        if (taxi == null) {
            this.lostTrips++;
            return null;
        }

        taxi.setPassenger(p);
        taxi.setTaxiCompany(this);

        return taxi;

    }

    public void addFreeTaxi(Taxi taxi) {
        this.freeTaxiList.add(taxi);
    }

    public List<Trip> getTrips(String id) throws InvalidTaxiName {
        if (this.allTaxiMap.containsKey(id)) {
            return this.allTaxiMap.get(id).getTripList();
            // return taxi.getTripList();
        }
        throw new InvalidTaxiName();
    }

    public int getLostTrips() {
        return lostTrips;
    }


    public void endTrip(String destricName) {
        if (this.districtByTripCountMap.containsKey(destricName)) {
            DistrictByTripCount dis = this.districtByTripCountMap.get(destricName);
            dis.incrementTripCount();
        } else {
            DistrictByTripCount dis = new DistrictByTripCount(destricName, 1);
            this.districtByTripCountMap.put(destricName, dis);
        }
    }

    public ArrayList<InfoI> statsTaxi() {

        ArrayList<InfoI> taxiList = new ArrayList<>(this.allTaxiMap.values());
        Collections.sort(taxiList);

        return taxiList;
    }

    public ArrayList<InfoI> statsDistricts() {

        ArrayList<InfoI> list = new ArrayList<>(this.districtByTripCountMap.values());
        Collections.sort(list);
        return list;
    }
}
