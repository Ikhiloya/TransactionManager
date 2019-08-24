package transformer;

import model.data.AccountBalanceInquiryRequest;
import model.data.AccountBalanceInquiryResponse;
import spark.Request;
import model.ServiceRequest;
import model.ServiceResponse;

public class AccountBalanceInquiryTransformer extends BaseTransformer {


    @Override
    public ServiceRequest transformRequest(Request request) throws Exception {
        System.out.println("in Account Balance inquiry Transformer, account no: >>>>>." + request.queryParams("accountNo"));
        ServiceRequest serviceRequest = new ServiceRequest();
        serviceRequest.setAccountBalanceInquiryRequest(new AccountBalanceInquiryRequest());
        serviceRequest.getAccountBalanceInquiryRequest().setAccountNo(request.queryParams("accountNo"));

        return serviceRequest;
    }

    @Override
    public AccountBalanceInquiryResponse transformResponse(ServiceResponse serviceResponse) throws Exception {
        AccountBalanceInquiryResponse response = new AccountBalanceInquiryResponse();

        response.setAccountNo(serviceResponse.getAccountBalanceInquiryResponse().getAccountNo());
        response.setAvailableBalance(serviceResponse.getAccountBalanceInquiryResponse().getAvailableBalance());
        response.setCurrentBalance(serviceResponse.getAccountBalanceInquiryResponse().getCurrentBalance());

        return response;
    }

}


