package processor;

import model.ServiceRequest;
import model.ServiceResponse;
import model.data.Account;
import model.data.PoolAccount;
import model.data.TransferResponse;
import service.ServiceDao;

public class AccountTransferHandler extends RequestHandler {

    @Override
    public void processRequest(ServiceRequest request, ServiceResponse response) {
        log.info("<<<<<<<Executing Account Transfer Handler>>>>>>>>");
        try {
            //1. debit source account and credit pool account
            PoolAccount poolAccount = ServiceDao.getPoolAccount();
            Account sourceAcct = ServiceDao.findAccountByAcctNo(request.getTransferRequest().getSourceAccountNo());
            Account destAcct = ServiceDao.findAccountByAcctNo(request.getTransferRequest().getDestinationAccountNo());

            log.info("**************************************");
            log.info("1. POOL_ACCT::::" + poolAccount.toString());
            log.info("**************************************");

            poolAccount.setAmountInTransit(Double.valueOf(request.getTransferRequest().getTransferAmount()));
            ServiceDao.postTransferToPool(poolAccount, sourceAcct, destAcct);

            log.info("++++++++++++++++++++++++++++++++++++++");
            log.info("2. POOL_ACCT::::" + poolAccount.toString());
            log.info("++++++++++++++++++++++++++++++++++++++");

            //2. debit pool account and credit destination account
            ServiceDao.postTransferToDestinationAcct(poolAccount, sourceAcct, destAcct);

            log.info("==========================================");
            log.info("3. POOL_ACCT::::" + poolAccount.toString());
            log.info("==========================================");

            response.getResponseHeader().setResponseCode("000");
            response.getResponseHeader().setResponseMessage("success");
            response.setTransferResponse(new TransferResponse());
            response.getTransferResponse().setMessage("Transferred successfully");
            response.getTransferResponse().setAccountBalance(ServiceDao.findAccountByAcctNo
                    (request.getTransferRequest().getSourceAccountNo()).getAccountBalance());

        } catch (Exception ex) {
            log.error(ex.getLocalizedMessage());
            response.getResponseHeader().setResponseMessage("Error occurred " + ex.getLocalizedMessage());
            response.getResponseHeader().setResponseCode("999");
            response.setTransferResponse(new TransferResponse());
            response.getTransferResponse().setMessage("Transferred failed ");
            response.getTransferResponse().setAccountBalance(ServiceDao.findAccountByAcctNo
                    (request.getTransferRequest().getSourceAccountNo()).getAccountBalance());
        }
    }
}
