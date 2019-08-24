package processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import model.RegisteredService;
import model.RegisteredServices;
import model.ServiceRequest;
import model.ServiceResponse;
import transformer.BaseTransformer;

public class RequestProcessor {
    private static final Logger log = LoggerFactory.getLogger(RequestProcessor.class);

    private static ServiceResponse processRequest(RegisteredService registeredService, ServiceRequest request) throws Exception {
        log.info("<<<<<<<Processing Service " + registeredService.getServiceName());
        RequestHandler handler1 = (RequestHandler) Class.forName(registeredService.getHandlerList().get(0).getHandlerImpl()).newInstance();
        handler1.setPosition(registeredService.getHandlerList().get(0).getPosition());

        RequestHandler handler, tempHandler = handler1;
        for (int i = 1; i < registeredService.getHandlerList().size(); i++) {
            handler = (RequestHandler) Class.forName(registeredService.getHandlerList().get(i).getHandlerImpl()).newInstance();
            handler.setPosition(registeredService.getHandlerList().get(i).getPosition());
            tempHandler.setNextHandler(handler);
            tempHandler = handler;
        }

        ServiceResponse response = new ServiceResponse();
        handler1.process(request, response);
        return response;
    }

    public ServiceResponse processRequest(String serviceIdentifier, ServiceRequest request) throws Exception {
        return processRequest(RegisteredServices.getService(serviceIdentifier), request);
    }

    public static Object processRequest(String serviceIdentifier, Request request) throws Exception {
        RegisteredService registeredService = RegisteredServices.getService(serviceIdentifier);
        BaseTransformer transformer = (BaseTransformer) Class.forName(registeredService.getTransformer()).newInstance();
        ServiceRequest serviceRequest = transformer.transformRequest(request);

        ServiceResponse serviceResponse = processRequest(registeredService, serviceRequest);
        return transformer.transformResponse(serviceResponse);
    }

}
