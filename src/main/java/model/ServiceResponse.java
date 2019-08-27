package model;

import model.data.TransferResponse;

public class ServiceResponse {
    private ResponseHeader responseHeader = new ResponseHeader();

    private AccountBalanceInquiryResponse accountBalanceInquiryResponse;
    private TransferResponse transferResponse;

    public ServiceResponse() {
    }

    public ResponseHeader getResponseHeader() {
        return responseHeader;
    }

    public void setResponseHeader(ResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }

    public AccountBalanceInquiryResponse getAccountBalanceInquiryResponse() {
        return accountBalanceInquiryResponse;
    }

    public void setAccountBalanceInquiryResponse(AccountBalanceInquiryResponse accountBalanceInquiryResponse) {
        this.accountBalanceInquiryResponse = accountBalanceInquiryResponse;
    }

    public TransferResponse getTransferResponse() {
        return transferResponse;
    }

    public void setTransferResponse(TransferResponse transferResponse) {
        this.transferResponse = transferResponse;
    }


    @Override
    public String toString() {
        return "ServiceResponse{" +
                "responseHeader=" + responseHeader +
                ", accountBalanceInquiryResponse=" + accountBalanceInquiryResponse +
                ", transferResponse=" + transferResponse +
                '}';
    }
}
