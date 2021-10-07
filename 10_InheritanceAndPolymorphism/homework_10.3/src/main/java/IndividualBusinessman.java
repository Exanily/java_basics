public class IndividualBusinessman extends PhysicalPerson {
    public IndividualBusinessman() {
        super(1,0.5);
    }

    @Override
    public void put(double amountToPut) {
        if (amountToPut < 1000) {
            super.put(amountToPut,1);
        }
        if (amountToPut >= 1000) {
            super.put(amountToPut);
        }
    }
}
