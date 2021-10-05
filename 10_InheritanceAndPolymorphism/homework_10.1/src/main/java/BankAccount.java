public class BankAccount {

    private double money = 0;

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
        if (money - amount > 0) {
            take(amount);
            receiver.put(amount);
            return true;
        } else return false;
    }
}


