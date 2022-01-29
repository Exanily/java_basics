package main.java;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class Bank {

    private final Map<String, Account> accounts;
    private final Random random = new Random();
    private Bank bank2;

    public Bank() {
        this.accounts = new HashMap<>();
    }

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    public void transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {
        Account from = accounts.get(toAccountNum);
        Account to = accounts.get(fromAccountNum);
        if (from.isBlocking()) {
            printBlock(fromAccountNum);
            return;
        }
        if (to.isBlocking()) {
            printBlock(fromAccountNum);
            return;
        }
        if (from.getMoney().get() >= amount) {
            if (amount > 50000 && isFraud(fromAccountNum, toAccountNum, amount)) {
                block(fromAccountNum, toAccountNum);
            } else {
                synchronized (from.compareTo(to) > 0 ? to : from) {
                    synchronized (to.compareTo(from) > 0 ? from : to) {
                        from.setMoney(from.getMoney().get() - amount);
                        to.setMoney(to.getMoney().get() + amount);
                        System.out.println("Со счёта " + fromAccountNum + " переведено " + amount + " руб" + " на счёт " + toAccountNum);
                    }
                }
            }
        } else {
            System.out.println("На счету " + from.getAccNumber() + " недостаточно средств");
        }
    }


    public AtomicLong getBalance(String accountNum) {
        return accounts.get(accountNum).getMoney();
    }

    public long getSumAllAccounts() {
        AtomicLong money = new AtomicLong();
        accounts.values().forEach(account -> money.addAndGet(account.getMoney().get()));
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
