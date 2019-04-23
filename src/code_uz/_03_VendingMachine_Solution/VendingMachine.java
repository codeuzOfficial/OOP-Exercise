package code_uz._03_VendingMachine_Solution;

import java.util.LinkedList;
import java.util.List;

public class VendingMachine {

    private List<Beverage> beverageList;
    private List<Card> cardList;
    private List<MachineColumn> machineColumnList;

    public VendingMachine() {
        beverageList = new LinkedList<>();
        cardList = new LinkedList<>();
        machineColumnList = new LinkedList<>();
    }

    public void addBeverage(String name, double price) {
        // Beverage beverage = new Beverage(name, price);
        beverageList.add(new Beverage(name, price));
    }

    public double getPrice(String beverageName) {

        for (Beverage beverage : beverageList) {
            if (beverage.getName().equals(beverageName)) {
                return beverage.getPrice();
            }
        }
        return -1;
    }

    public void rechargeCard(int cardId, double credit) {

        for (Card card : cardList) {
            if (card.getCardId() == cardId) {
                card.addCredit(credit);
                return;
            }
        }
        cardList.add(new Card(cardId, credit));

    }

    public double getCredit(int cardId) {
        for (Card card : cardList) {
            if (card.getCardId() == cardId) {
                return card.getCredit();
            }
        }
        return -1;
    }

    public void refillColumn(int column, String beverageName, int cans) {
        Beverage beverage = getBeverage(beverageName);
        if (beverage != null) {
            MachineColumn machineColumn = new MachineColumn();
            machineColumn.setBeverage(beverage);
            machineColumn.setCans(cans);
            machineColumn.setColumn(column);

            machineColumnList.add(machineColumn);
        }

    }

    public int availableCans(String beverageName) {
        int count = 0;
        for (MachineColumn machineColumn : machineColumnList) {
            if (machineColumn.getBeverage().getName().equals(beverageName)) {
                count += machineColumn.getCans();
            }
        }
        return count;
    }

    public int sell(String beverageName, int cardId) {
        MachineColumn machineColumn = getMachineColumn(beverageName);
        Card card = getCard(cardId);
        if (machineColumn != null && card != null && machineColumn.getCans() > 0 && card.getCredit() >= machineColumn.getBeverage().getPrice()) {
            Beverage beverage = machineColumn.getBeverage();

            card.sell(beverage.getPrice());
            machineColumn.sell();

            return machineColumn.getColumn();
        }
        return -1;
    }


    private Beverage getBeverage(String beverageName) {
        for (Beverage beverage : beverageList) {
            if (beverage.getName().equals(beverageName)) {
                return beverage;
            }
        }
        return null;
    }

    private MachineColumn getMachineColumn(String beverageName) {
        for (MachineColumn machineColumn : machineColumnList) {
            if (machineColumn.getBeverage().getName().equals(beverageName)) {
                return machineColumn;
            }
        }

        return null;
    }

    private Card getCard(int cardId) {
        for (Card card : cardList) {
            if (card.getCardId() == cardId) {
                return card;
            }
        }
        return null;
    }
}
