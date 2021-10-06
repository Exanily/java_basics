public abstract class Client {

    private double money;

    public double getAmount() {
        return money;
    }

    public void put(double amountToPut) {
        money += amountToPut;
    }

    public void take(double amountToTake) {
        money -= amountToTake;
    }
}
