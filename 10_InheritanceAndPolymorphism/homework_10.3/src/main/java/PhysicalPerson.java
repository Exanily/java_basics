public class PhysicalPerson extends Client {
    @Override
    public void put(double amountToPut) {
        if (amountToPut > 0) {
            super.put(amountToPut);
        }
    }

    @Override
    public void take(double amountToTake) {
        if (getAmount() - amountToTake >= 0) {
            super.take(amountToTake);
        }
    }
}
