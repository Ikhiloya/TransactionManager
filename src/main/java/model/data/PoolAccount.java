package model.data;

import util.Type;

public class PoolAccount extends Account {
    private String sourceAcctNo;
    private String destinationAcctNo;
    private double amountInTransit;


    public PoolAccount(String accountNo, String accountName, double accountBalance, boolean isActive, boolean isRestricted, Type accountType) {
        super(accountNo, accountName, accountBalance, isActive, isRestricted, accountType);
    }

    public String getSourceAcctNo() {
        return sourceAcctNo;
    }

    public void setSourceAcctNo(String sourceAcctNo) {
        this.sourceAcctNo = sourceAcctNo;
    }

    public String getDestinationAcctNo() {
        return destinationAcctNo;
    }

    public void setDestinationAcctNo(String destinationAcctNo) {
        this.destinationAcctNo = destinationAcctNo;
    }

    public double getAmountInTransit() {
        return amountInTransit;
    }

    public void setAmountInTransit(double amountInTransit) {
        this.amountInTransit = amountInTransit;
    }

    @Override
    public synchronized void debit(double amount) throws Exception {
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(getAccountBalance() < amount) throw new Exception("Transfer failed as Pool Account has not been credited");
            setAccountBalance(getAccountBalance() - amount);
    }

    @Override
    public String toString() {
        return "PoolAccount{" +
                "sourceAcctNo='" + sourceAcctNo + '\'' +
                ", destinationAcctNo='" + destinationAcctNo + '\'' +
                ", amountInTransit=" + amountInTransit +
                ", accountBalance=" + getAccountBalance() +
                ", accountNo=" + getAccountNo() +
                '}';
    }


}
