import com.fasterxml.jackson.databind.ObjectMapper;
import dao.ServiceDao;
import model.RegisteredService;
import model.RegisteredServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import processor.RequestProcessor;


import static spark.Spark.*;

public class Main {
    private static ObjectMapper om = new ObjectMapper();
    private static final Logger log = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) {
        // Start embedded server at this port
        port(8010);

        loadServiceRegistrations();


        // Get - Get all registered services
        get("/registeredservices", (request, response) -> {
            RegisteredServices registeredServices = loadServiceRegistrations();
            return om.writeValueAsString(registeredServices);
        });

        // POST - generic endpoint
        post("/service/:serviceIdentifier", (request, response) -> {
            String serviceIdentifier = request.params(":serviceIdentifier");
            log.debug("Received request for service on JSON endpoint " + serviceIdentifier);
            return om.writeValueAsString(RequestProcessor.processRequest(serviceIdentifier, request));
        });

    }


    public static RegisteredServices loadServiceRegistrations() {
        RegisteredServices registeredServices = new RegisteredServices();
        for (RegisteredService service : ServiceDao.loadRegisteredServices()) {
            registeredServices.addService(service);
            log.info(service.getServiceIdentifier());
        }
        log.info("Services Loaded....");
        return registeredServices;
    }


}
