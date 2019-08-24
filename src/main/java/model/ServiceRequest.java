package model;

import model.data.AccountBalanceInquiryRequest;

public class ServiceRequest {

    public ServiceRequest() {
    }

    private RequestHeader requestHeader;
    private AccountBalanceInquiryRequest accountBalanceInquiryRequest;

    public RequestHeader getRequestHeader() {
        return requestHeader;
    }

    public void setRequestHeader(RequestHeader requestHeader) {
        this.requestHeader = requestHeader;
    }

    public AccountBalanceInquiryRequest getAccountBalanceInquiryRequest() {
        return accountBalanceInquiryRequest;
    }

    public void setAccountBalanceInquiryRequest(AccountBalanceInquiryRequest accountBalanceInquiryRequest) {
        this.accountBalanceInquiryRequest = accountBalanceInquiryRequest;
    }

    @Override
    public String toString() {
        return "ServiceRequest{" +
                "requestHeader=" + requestHeader +
                ", accountBalanceInquiryRequest=" + accountBalanceInquiryRequest +
                '}';
    }
}
