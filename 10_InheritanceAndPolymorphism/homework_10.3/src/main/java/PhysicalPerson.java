public class PhysicalPerson extends Client {

    public PhysicalPerson() {
        super(0, 0);
    }

    public PhysicalPerson(double commissionTake, double commissionPut) {
        super(commissionTake, commissionPut);
    }

    @Override
    public void put(double amountToPut) {
        if (amountToPut > 0) {
            super.put(amountToPut);
        }
    }

    @Override
    public void put(double moneyAmount, double commission) {
        if (moneyAmount > 0) {
            super.put(moneyAmount, commission);
        }
    }

    @Override
    public void take(double amountToTake) {
        if (getAmount() - amountToTake >= 0) {
            super.take(amountToTake);
        }
    }
}
