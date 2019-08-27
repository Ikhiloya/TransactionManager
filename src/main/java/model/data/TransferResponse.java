package model.data;

import model.ResponseHeader;

public class TransferResponse {
    private ResponseHeader responseHeader = new ResponseHeader();
    private String message;
    private double accountBalance;

    public TransferResponse() {
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

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return "TransferResponse{" +
                "responseHeader=" + responseHeader +
                ", message='" + message + '\'' +
                ", accountBalance=" + accountBalance +
                '}';
    }
}
