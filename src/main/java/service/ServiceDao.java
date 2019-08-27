package service;

import model.RegisteredService;
import model.data.Account;
import model.data.User;

import java.util.ArrayList;
import java.util.List;

//todo: add comment
public class ServiceDao {

    public static List<RegisteredService> loadRegisteredServices() {
        ArrayList<RegisteredService> registeredServices = new ArrayList<>();
        RegisteredService service = new RegisteredService();
        service.setServiceIdentifier(("acctbalservice"));
        service.setServiceName(("Account Balance Inquiry Service"));
        service.setTransformer(("transformer.AccountBalanceInquiryTransformer"));
        service.setHandlerList(getServiceHandlers((("acctbalservice"))));
        registeredServices.add(service);
        return registeredServices;
    }

    /**
     * @param serviceIdentifier identifies the service endpoint
     * @return
     */
    private static List<RegisteredService.ServiceHandler> getServiceHandlers(String serviceIdentifier) {

        ArrayList<RegisteredService.ServiceHandler> handlers = new ArrayList<>();

        RegisteredService.ServiceHandler handler = new RegisteredService.ServiceHandler();
        handler.setPosition(1);
        handler.setHandlerImpl(("processor.MiniStatementHandler")); //class name

        RegisteredService.ServiceHandler handler1 = new RegisteredService.ServiceHandler();

        handler1.setPosition(2);
        handler1.setHandlerImpl(("processor.BalanceCheckHandler")); //class name

        handlers.add(handler);
        handlers.add(handler1);


        return handlers;
    }




}
