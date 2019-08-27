package model;

import model.data.TransferRequest;

public class ServiceRequest {

    public ServiceRequest() {
    }

    private RequestHeader requestHeader;private TransferRequest transferRequest;

    public RequestHeader getRequestHeader() {
        return requestHeader;
    }

    public void setRequestHeader(RequestHeader requestHeader) {
        this.requestHeader = requestHeader;
    }




    public TransferRequest getTransferRequest() {
        return transferRequest;
    }

    public void setTransferRequest(TransferRequest transferRequest) {
        this.transferRequest = transferRequest;
    }

    @Override
    public String toString() {
        return "ServiceRequest{" +
                "requestHeader=" + requestHeader +
                ", transferRequest=" + transferRequest +
                '}';
    }
}
