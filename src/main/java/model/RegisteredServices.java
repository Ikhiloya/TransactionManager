package model;

import java.util.Map;
import java.util.TreeMap;

public class RegisteredServices {
    public RegisteredServices() {
    }

    private static Map<String, RegisteredService> services = new TreeMap();

    public static RegisteredService getService(String serviceIdentifier) {
        return services.get(serviceIdentifier);
    }

    public void addService(RegisteredService service) {
        services.put(service.getServiceIdentifier(), service);
    }

    public Map<String, RegisteredService> getServices() {
        return services;
    }

    public void setServices(Map<String, RegisteredService> services) {
        RegisteredServices.services = services;
    }
}
