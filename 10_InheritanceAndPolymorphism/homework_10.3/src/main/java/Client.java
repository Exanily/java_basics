public abstract class Client {

    private double money;

    private final double commissionTake;
    private final double commissionPut;

    public Client(double commissionTake, double commissionPut) {
        this.commissionTake = commissionTake;
        this.commissionPut = commissionPut;
    }

    public double getAmount() {
        return money;
    }

    public void put(double amountToPut) {
        put(amountToPut, commissionPut);
    }

    public void put(double moneyAmount, double commission) {
        money += moneyAmount - moneyAmount * (commission / 100);
    }

    public void take(double amountToTake) {
        money -= amountToTake + amountToTake * (commissionTake / 100);
    }
}
