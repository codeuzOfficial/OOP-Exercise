package code_uz._06_Flat_Rent_Solution;

import java.util.*;

public class Manager {

    private Map<String, Flat> flatMap = new TreeMap<>();
    private Map<String, Client> clientMap = new TreeMap<>();
    private List<Booking> bookingList = new LinkedList<>();

    public Flat newFlat(String code, int smq) {
        Flat flat = new Flat(code, smq);

        this.flatMap.put(code, flat);

        return flat;
    }

    public Collection<Flat> getFlats() {
        return null;
    }

    public Client newClient(String name, String surname, String ID) {
        Client client = new Client(name, surname, ID);

        this.clientMap.put(ID, client);

        return client;
    }

    public Client getClient(String ID) {
        return this.clientMap.get(ID);
    }

    public Collection<Client> getClients() {
        return this.clientMap.values();

    }

    public Booking bookFlat(String code, String ID, int day, int month, int year, int week) {

        Flat flat = this.flatMap.get(code);
        Client client = this.clientMap.get(ID);


        Booking booking = new Booking(flat, client, day, month, year, week);

        bookingList.add(booking);


        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        int weekNum = calendar.get(Calendar.WEEK_OF_YEAR);

        flat.setAvailability(weekNum, week);
        client.addWeeksNumber(week);


        return booking;
    }

}
