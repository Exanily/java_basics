import java.time.LocalDate;

public class DepositAccount extends BankAccount {
    private LocalDate lastIncome;

    @Override
    public void take(double amountToTake) {
        LocalDate date = lastIncome.plusMonths(1);
        if (LocalDate.now().isAfter(date)) {
            super.take(amountToTake);
        }
    }

    @Override
    public void put(double amountToPut) {
        super.put(amountToPut);
        lastIncome = LocalDate.now();
    }
}
