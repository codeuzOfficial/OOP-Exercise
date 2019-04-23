package code_uz._03_VendingMachine_Solution;

public class Beverage { // ichimlik

    private String name;
    private double price;


    public Beverage() {

    }

    public Beverage(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
