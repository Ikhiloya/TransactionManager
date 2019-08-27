package model.data;

import util.Type;

public class Account {
    private String accountNo;
    private String accountName;
    private double accountBalance;
    private boolean isActive;
    private boolean isRestricted;
    private Type accountType;
    //other details

    public Account(String accountNo, String accountName, double accountBalance, boolean isActive,
                   boolean isRestricted, Type accountType) {
        this.accountNo = accountNo;
        this.accountName = accountName;
        this.accountBalance = accountBalance;
        this.isActive = isActive;
        this.isRestricted = isRestricted;
        this.accountType = accountType;
    }


    //todo: use a factory to create  lien, normal accounts...use  enums
    //todo: validate account no
    //todo: acct inquiry

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isRestricted() {
        return !isRestricted;
    }

    public void setRestricted(boolean restricted) {
        isRestricted = restricted;
    }

    public Type getAccountType() {
        return accountType;
    }

    public void setAccountType(Type accountType) {
        this.accountType = accountType;
    }


    public synchronized void debit(double amount) throws Exception {
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        accountBalance = accountBalance - amount;
    }


    public synchronized void credit(double amount) {
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        accountBalance = accountBalance + amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNo=" + accountNo +
                ", accountName='" + accountName + '\'' +
                ", accountBalance=" + accountBalance +
                ", isActive=" + isActive +
                ", isRestricted=" + isRestricted +
                ", accountType='" + accountType + '\'' +
                '}';
    }

}

