package main.java;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class Bank {

    private final Map<String, Account> accounts;
    private final Random random = new Random();

    public Bank() {
        this.accounts = new HashMap<>();
    }

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    public void transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {
        Account fromAccount = accounts.get(fromAccountNum);
        Account toAccount = accounts.get(toAccountNum);
        if (fromAccount.isBlocking()) {
            printBlock(fromAccountNum);
            return;
        }
        if (toAccount.isBlocking()) {
            printBlock(fromAccountNum);
            return;
        }
        if (accounts.get(fromAccountNum).getMoney() >= amount) {
            if (amount > 50000 && isFraud(fromAccountNum, toAccountNum, amount)) {
                block(fromAccountNum, toAccountNum);
            } else {
                fromAccount.setMoney(fromAccount.getMoney() - amount);
                toAccount.setMoney(toAccount.getMoney() + amount);
                System.out.println("Со счёта " + fromAccountNum + " переведено " + amount + " руб" + " на счёт " + toAccountNum);
            }
        } else {
            System.out.println("Недостаточно средств");
        }

    }

    public long getBalance(String accountNum) {
        return accounts.get(accountNum).getMoney();
    }

    public long getSumAllAccounts() {
        AtomicLong money = new AtomicLong();
        accounts.values().forEach(account -> money.addAndGet(account.getMoney()));
        return money.get();
    }

    private void block(String fromAccountNum, String toAccountNum) {
        setBlock(fromAccountNum);
        setBlock(toAccountNum);
    }

    private void setBlock(String accountNum) {
        accounts.get(accountNum).setBlocking(true);
        printBlock(accountNum);
    }

    private void printBlock(String accountNum) {
        System.out.println("Счёт " + accountNum + " заблокирован");
    }

    public void addAccount(String key, Account account) {
        accounts.put(key, account);
    }

    public Account getAccount(String number) {
        return accounts.get(number);
    }
}
