package model;

import java.util.List;

public class RegisteredService {
    private String serviceIdentifier;
    private String serviceName;
    private List<ServiceHandler> handlerList;
    private String transformer;

    public String getTransformer() {
        return transformer;
    }

    public void setTransformer(String transformer) {
        this.transformer = transformer;
    }

    public String getServiceIdentifier() {
        return serviceIdentifier;
    }

    public void setServiceIdentifier(String serviceIdentifier) {
        this.serviceIdentifier = serviceIdentifier;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public List<ServiceHandler> getHandlerList() {
        return handlerList;
    }

    public void setHandlerList(List<ServiceHandler> handlerList) {
        this.handlerList = handlerList;
    }

    public static class ServiceHandler {
        private String handlerImpl;
        private Integer position;

        public String getHandlerImpl() {
            return handlerImpl;
        }

        public void setHandlerImpl(String handlerImpl) {
            this.handlerImpl = handlerImpl;
        }

        public Integer getPosition() {
            return position;
        }

        public void setPosition(Integer position) {
            this.position = position;
        }

    }

}
