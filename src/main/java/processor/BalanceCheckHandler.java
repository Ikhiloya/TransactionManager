package processor;

import model.ServiceRequest;
import model.ServiceResponse;

public class BalanceCheckHandler extends RequestHandler{

    @Override
    public void processRequest(ServiceRequest request, ServiceResponse response) {
        log.info("<<<<<<<Executing Account Balance Handler>>>>>>>>");
//        response.setAccountInfo(serviceDAO.getAccountBalance(request.getAccountInfo().getAccountNo()));
        response.getResponseHeader().setResponseCode("000");
//        response.getResponseHeader().setResponseMessage("SUCCESS");
//        response.setCustomerInfo(new CustomerInfo());
//        response.getCustomerInfo().setCustomerRef("09399329");
    }

}
