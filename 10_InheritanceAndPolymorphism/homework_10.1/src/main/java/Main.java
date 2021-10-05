public class Main {
    public static void main(String[] args) {
        BankAccount sashaAccount = new BankAccount();
        BankAccount account = new BankAccount();
        sashaAccount.put(1000);
        account.put(500);
        sashaAccount.send(account, 300);
        System.out.println(sashaAccount.getAmount());
        System.out.println(account.getAmount());
    }
}
