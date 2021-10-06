public class LegalPerson extends PhysicalPerson {
    @Override
    public void take(double amountToTake) {
        super.take(amountToTake * 1.01);
    }
}
