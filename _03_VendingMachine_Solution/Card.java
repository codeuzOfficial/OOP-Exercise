package code_uz._03_VendingMachine_Solution;

public class Card {

    private int cardId;
    private double credit;

    public Card(int cardId, double credit) {
        this.cardId = cardId;
        this.credit = credit;
    }

    public int getCardId() {
        return cardId;
    }

    public double getCredit() {
        return credit;
    }

    public void addCredit(double credit) {
        this.credit += credit;
    }

    public void sell(double price) {
        this.credit -= price;
    }
}
