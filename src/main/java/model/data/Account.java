package model.data;

public class Account {
    private String accountNo;
    private String accountName;
    private double accountBalance;
    private boolean isActive;
    private boolean isRestricted;
    private String accountType;
    //other details


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
        return isRestricted;
    }

    public void setRestricted(boolean restricted) {
        isRestricted = restricted;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
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
