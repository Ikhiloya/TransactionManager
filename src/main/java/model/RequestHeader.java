package model;

public class RequestHeader {
    private String sourceCode;
    private String requestId;
    private String requestToken;
    private String requestType;
    private String sourceChannelId;


    public RequestHeader(String sourceCode, String requestId, String requestToken, String requestType, String sourceChannelId) {
        this.sourceCode = sourceCode;
        this.requestId = requestId;
        this.requestToken = requestToken;
        this.requestType = requestType;
        this.sourceChannelId = sourceChannelId;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getRequestToken() {
        return requestToken;
    }

    public void setRequestToken(String requestToken) {
        this.requestToken = requestToken;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getSourceChannelId() {
        return sourceChannelId;
    }

    public void setSourceChannelId(String sourceChannelId) {
        this.sourceChannelId = sourceChannelId;
    }

    @Override
    public String toString() {
        return "RequestHeader{" +
                "sourceCode='" + sourceCode + '\'' +
                ", requestId='" + requestId + '\'' +
                ", requestToken='" + requestToken + '\'' +
                ", requestType='" + requestType + '\'' +
                ", sourceChannelId='" + sourceChannelId + '\'' +
                '}';
    }
}
