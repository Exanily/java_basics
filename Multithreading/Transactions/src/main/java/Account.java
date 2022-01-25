package main.java;

public class Account {

    private long money;
    private String accNumber;
    private boolean blocking = false;

    public Account(String accNumber) {
        this.accNumber = accNumber;
        this.money = 0;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
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
}
