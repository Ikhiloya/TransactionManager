package processor;

import model.ServiceRequest;
import model.ServiceResponse;
import model.data.TransferResponse;
import service.ServiceDao;


/**
 * A Handler that reverses transactions should the need arise
 */
public class ReversalHandler extends RequestHandler {
    @Override
    protected void processRequest(ServiceRequest request, ServiceResponse response) {
        log.info("<<<<<<<Executing Reversal Handler >>>>>>>>");
        try {
            ServiceDao.reverseTransferToSourceAcct(ServiceDao.getPoolAccount());
        } catch (Exception ex) {
            log.error(ex.getLocalizedMessage());
            response.getResponseHeader().setResponseMessage("Error occurred " + ex.getLocalizedMessage());
            response.getResponseHeader().setResponseCode("999");
            response.setTransferResponse(new TransferResponse());
            response.getTransferResponse().setMessage("Transferred failed ");
        }
    }
}
