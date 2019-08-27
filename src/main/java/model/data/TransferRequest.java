package model.data;

import javax.swing.text.Style;

//todo: validate the source Acct no and receive account no, amount , balance, receive acct status, send acct status
public class TransferRequest {
    private String sourceAccountNo;
    private String destinationAccountNo;
    private String accountName;
    private String transferAmount;
    private String remark;

    public TransferRequest() {
    }

    public String getSourceAccountNo() {
        return sourceAccountNo;
    }

    public void setSourceAccountNo(String sourceAccountNo) {
        this.sourceAccountNo = sourceAccountNo;
    }

    public String getDestinationAccountNo() {
        return destinationAccountNo;
    }

    public void setDestinationAccountNo(String destinationAccountNo) {
        this.destinationAccountNo = destinationAccountNo;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(String transferAmount) {
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
