package processor;

import model.ServiceRequest;
import model.ServiceResponse;
import model.data.TransferResponse;
import service.ServiceDao;

public class AccountValidationHandler extends RequestHandler {

    @Override
    public void processRequest(ServiceRequest request, ServiceResponse response) {
        log.info("<<<<<<<Executing Account Validation Handler>>>>>>>>");
        String sourceAcctNo = request.getTransferRequest().getSourceAccountNo();
        String destAcctNo = request.getTransferRequest().getDestinationAccountNo();
        double transferAmt = Double.valueOf(request.getTransferRequest().getTransferAmount());
        boolean isSourceAcctValid = ServiceDao.sourceAccountValidation(sourceAcctNo, transferAmt);
        boolean isDestAcctValid = ServiceDao.destAccountValidation(destAcctNo);

        if (isSourceAcctValid && isDestAcctValid) {
            response.getResponseHeader().setResponseCode("000");
        } else if (!isSourceAcctValid) {
            response.getResponseHeader().setResponseMessage("source account is invalid or Insufficient Funds for source account: " +
                    request.getTransferRequest().getSourceAccountNo());
            response.getResponseHeader().setResponseCode("999");
            response.setTransferResponse(new TransferResponse());
            response.getTransferResponse().setMessage("Transferred failed ");
            response.getTransferResponse().setAccountBalance(ServiceDao.findAccountByAcctNo
                    (sourceAcctNo).getAccountBalance());

        } else {
            response.getResponseHeader().setResponseMessage("destination account is invalid");
            response.getResponseHeader().setResponseCode("999");
            response.setTransferResponse(new TransferResponse());
            response.getTransferResponse().setMessage("Transferred failed ");
            response.getTransferResponse().setAccountBalance(ServiceDao.findAccountByAcctNo
                    (sourceAcctNo).getAccountBalance());
        }
    }
}
