package transformer;

import model.ResponseHeader;
import model.ServiceRequest;
import model.ServiceResponse;
import model.data.TransferRequest;
import model.data.TransferResponse;
import spark.Request;

public class AccountTransferTransformer extends BaseTransformer {
    @Override
    public ServiceRequest transformRequest(Request request) throws Exception {
        System.out.println("in Account Transfer Transformer >>>>>.");
        ServiceRequest serviceRequest = new ServiceRequest();
        serviceRequest.setTransferRequest(new TransferRequest());
        serviceRequest.getTransferRequest().setSourceAccountNo(request.queryParams("sourceAccountNo"));
        serviceRequest.getTransferRequest().setDestinationAccountNo(request.queryParams("destinationAccountNo"));
        serviceRequest.getTransferRequest().setAccountName(request.queryParams("accountName"));
        serviceRequest.getTransferRequest().setTransferAmount(request.queryParams("transferAmount"));
        serviceRequest.getTransferRequest().setRemark(request.queryParams("remark"));
        return serviceRequest;
    }


    @Override
    public TransferResponse transformResponse(ServiceResponse serviceResponse) throws Exception {
        TransferResponse response = new TransferResponse();

        response.getResponseHeader().setResponseCode(serviceResponse.getResponseHeader().getResponseCode());
        response.getResponseHeader().setResponseMessage(serviceResponse.getResponseHeader().getResponseMessage());
        response.setMessage(serviceResponse.getTransferResponse().getMessage());
        response.setAccountBalance(serviceResponse.getTransferResponse().getAccountBalance());

        return response;
    }
}
