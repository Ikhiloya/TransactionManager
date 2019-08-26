package model.data;

import model.ResponseHeader;

public class TransferReponse {
    private ResponseHeader responseHeader;
    private String message;
    private int accountBalance;

    public TransferReponse() {
    }

    public ResponseHeader getResponseHeader() {
        return responseHeader;
    }

    public void setResponseHeader(ResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return "TransferReponse{" +
                "responseHeader=" + responseHeader +
                ", message='" + message + '\'' +
                ", accountBalance=" + accountBalance +
                '}';
    }
}
