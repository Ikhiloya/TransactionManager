package model.data;

public class AccountBalanceInquiryResponse {
    private String responseCode;
    private String responseMessage;
    private String accountNo;

    private String availableBalance;
    private String currentBalance;


    public AccountBalanceInquiryResponse() {
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }



    public String getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(String availableBalance) {
        this.availableBalance = availableBalance;
    }

    public String getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(String currentBalance) {
        this.currentBalance = currentBalance;
    }



    @Override
    public String toString() {
        return "AccountBalanceInquiryResponse{" +
                "responseCode='" + responseCode + '\'' +
                ", responseMessage='" + responseMessage + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", availableBalance='" + availableBalance + '\'' +
                ", currentBalance='" + currentBalance + '\'' +
                '}';
    }
}
