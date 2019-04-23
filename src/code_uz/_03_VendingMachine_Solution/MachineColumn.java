package code_uz._03_VendingMachine_Solution;

public class MachineColumn {

    private int column;
    private Beverage beverage;
    private int cans;


    public MachineColumn() {

    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setBeverage(Beverage beverage) {
        this.beverage = beverage;
    }

    public void setCans(int cans) {
        this.cans = cans;
    }

    public int getColumn() {
        return column;
    }

    public Beverage getBeverage() {
        return beverage;
    }

    public int getCans() {
        return cans;
    }

    public void sell() {
        this.cans--;
    }
}
