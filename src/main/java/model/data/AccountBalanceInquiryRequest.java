package model.data;

public class AccountBalanceInquiryRequest {
    public AccountBalanceInquiryRequest() {
    }

    private String accountNo;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    @Override
    public String toString() {
        return "AccountBalanceInquiryRequest{" +
                "accountNo='" + accountNo + '\'' +
                '}';
    }
}
