package processor;

import model.ServiceRequest;
import model.ServiceResponse;
import model.data.AccountBalanceInquiryResponse;

public class MiniStatementHandler extends RequestHandler {
    @Override
    protected void processRequest(ServiceRequest request, ServiceResponse response) {
        log.info("<<<<<<<Executing Mini Statement Handler>>>>>>>>");
        response.setAccountBalanceInquiryResponse(new AccountBalanceInquiryResponse());
        response.getAccountBalanceInquiryResponse().setCurrentBalance("10000");
        response.getAccountBalanceInquiryResponse().setAvailableBalance("9000");
        response.getAccountBalanceInquiryResponse().setAccountNo(request.getAccountBalanceInquiryRequest().getAccountNo());
        response.getResponseHeader().setResponseCode("000");
    }
}
