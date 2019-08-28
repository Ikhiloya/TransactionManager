package model.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import processor.RequestHandler;
import util.Type;

public class Account {
    protected static final Logger log = LoggerFactory.getLogger(Account.class);

    private final Object lock = new Object();

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


    public void debit(double amount) throws Exception {
        synchronized (lock) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            accountBalance = accountBalance - amount;
        }
        log.info(Thread.currentThread().getName() + " successfully withdrawn the amount : " + amount + " balance left =  " + getAccountBalance());
    }


    public void credit(double amount) {
        synchronized (lock) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            accountBalance = accountBalance + amount;
            log.info(Thread.currentThread().getName() + " depositing the amount " + amount + " updated balance =  " + getAccountBalance());

        }
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

