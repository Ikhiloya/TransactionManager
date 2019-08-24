package processor;

import model.ServiceRequest;
import model.ServiceResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class RequestHandler {
    protected static final Logger log = LoggerFactory.getLogger(RequestHandler.class);

    private int position;

    private RequestHandler nextHandler;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setNextHandler(RequestHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void process(ServiceRequest request, ServiceResponse response) {
        this.processRequest(request, response);
        System.out.println("Response here::::" + response);
        if (response.getResponseHeader().getResponseCode().equals("000") && nextHandler != null)
            nextHandler.process(request, response);
    }

    abstract protected void processRequest(ServiceRequest request, ServiceResponse response);

}
