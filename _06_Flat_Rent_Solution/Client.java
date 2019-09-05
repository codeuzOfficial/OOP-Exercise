package code_uz._06_Flat_Rent_Solution;

public class Client {

    private String name;
    private String surname;
    private String ID;

    private int weeksNumber;

    public Client(String name, String surname, String ID) {
        this.name = name;
        this.surname = surname;
        this.ID = ID;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getID() {
        return ID;
    }

    public int getWeeksNumber() {
        return weeksNumber;
    }

    public void addWeeksNumber(int weeksNumber) {
        this.weeksNumber += weeksNumber;
    }

}
