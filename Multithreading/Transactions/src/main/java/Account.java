package main.java;

import java.util.concurrent.atomic.AtomicLong;

public class Account implements Comparable<Account> {

    private final AtomicLong money = new AtomicLong();
    private String accNumber;
    private boolean blocking = false;

    public Account(String accNumber) {
        this.accNumber = accNumber;
    }

    public AtomicLong getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money.set(money);
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public boolean isBlocking() {
        return blocking;
    }

    public void setBlocking(boolean blocking) {
        this.blocking = blocking;
    }

    @Override
    public int compareTo(Account o) {
        return this.getAccNumber().compareTo(o.accNumber);
    }
}
