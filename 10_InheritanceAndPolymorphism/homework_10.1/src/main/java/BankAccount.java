public class BankAccount {

    public double money = 0;

    public double getAmount() {
        return money;
    }

    public void put(double amountToPut) {
        if (amountToPut > 0) {
            money += amountToPut;
        }
    }

    public void take(double amountToTake) {
        if (money - amountToTake > 0) {
            money -= amountToTake;
        }
    }

    public boolean send(BankAccount receiver, double amount) {
        return money - amount > 0;
    }

    public void sendAccount(BankAccount receiver, double amount) {
        if (send(receiver, amount)) {
            take(amount);
            receiver.put(amount);
        }
    }
}
