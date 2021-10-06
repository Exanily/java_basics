public class IndividualBusinessman extends PhysicalPerson {
    @Override
    public void put(double amountToPut) {
        if (amountToPut < 1000) {
            super.put(amountToPut * 0.99);
        }
        if (amountToPut >= 1000) {
            super.put(amountToPut * 0.995);
        }
    }
}
