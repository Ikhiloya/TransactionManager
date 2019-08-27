package model;

import model.data.TransferResponse;

public class ServiceResponse {
    private ResponseHeader responseHeader = new ResponseHeader();

    private TransferResponse transferResponse;

    public ServiceResponse() {
    }

    public ResponseHeader getResponseHeader() {
        return responseHeader;
    }

    public void setResponseHeader(ResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
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
                ", transferResponse=" + transferResponse +
                '}';
    }
}
