package main.java;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();

        for (int i = 1; i <= 100; i++) {
            String s = String.valueOf(i);
            Account account = new Account(s);
            account.setMoney(600000);
            bank.addAccount(s, account);
        }
        System.out.println(bank.getSumAllAccounts());

        int cores = Runtime.getRuntime().availableProcessors();

        for (int i = 0; i < cores; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    String random1 = String.valueOf((int) (Math.random() * 99) + 1);
                    String random2 = String.valueOf((int) (Math.random() * 99) + 1);
                    try {
                        bank.transfer(random1, random2, (int) (Math.random() * 10001 + 1) + 40000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(bank.getSumAllAccounts());
            }).start();
        }
    }
}
