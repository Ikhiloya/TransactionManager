package transformer;

import spark.Request;
import model.ServiceRequest;
import model.ServiceResponse;

public abstract class BaseTransformer {
    public abstract ServiceRequest transformRequest(Request request) throws Exception;

    public abstract Object transformResponse(ServiceResponse serviceResponse) throws Exception;

}
