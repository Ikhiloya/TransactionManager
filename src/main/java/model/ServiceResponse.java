package model;

import model.data.AccountBalanceInquiryResponse;

public class ServiceResponse {
    private ResponseHeader responseHeader = new ResponseHeader();

    private AccountBalanceInquiryResponse accountBalanceInquiryResponse;

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

    @Override
    public String toString() {
        return "ServiceResponse{" +
                "responseHeader=" + responseHeader +
                ", accountBalanceInquiryResponse=" + accountBalanceInquiryResponse +
                '}';
    }
}
