package model.data;
//todo: validate the source Acct no and receive account no, amount , balance, receive acct status, send acct status
public class TransferRequest {
    private int sourceAccountNo;
    private int destinationAccountNo;
    private String accountName;
    private int transferAmount;
    private String remark;

    public TransferRequest() {
    }

    public int getSourceAccountNo() {
        return sourceAccountNo;
    }

    public void setSourceAccountNo(int sourceAccountNo) {
        this.sourceAccountNo = sourceAccountNo;
    }

    public int getDestinationAccountNo() {
        return destinationAccountNo;
    }

    public void setDestinationAccountNo(int destinationAccountNo) {
        this.destinationAccountNo = destinationAccountNo;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public int getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(int transferAmount) {
        this.transferAmount = transferAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    @Override
    public String toString() {
        return "TransferRequest{" +
                "sourceAccountNo=" + sourceAccountNo +
                ", destinationAccountNo=" + destinationAccountNo +
                ", accountName='" + accountName + '\'' +
                ", transferAmount=" + transferAmount +
                ", remark='" + remark + '\'' +
                '}';
    }
}
