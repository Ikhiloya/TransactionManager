package service;

import model.RegisteredService;
import model.data.Account;
import model.data.AccountFactory;
import model.data.PoolAccount;
import util.Type;

import java.util.ArrayList;
import java.util.List;

import static util.Constant.*;

//todo: add comment
public class ServiceDao {
    private static List<Account> accounts = new ArrayList<>();

    /**
     * @return the list of registered services
     */
    public static List<RegisteredService> loadRegisteredServices() {
        List<RegisteredService> registeredServices = new ArrayList<>();
        RegisteredService service = new RegisteredService();
        service.setServiceIdentifier(("transferservice")); //acctbalservice
        service.setServiceName(("Account Transfer Service"));
        service.setTransformer(("transformer.AccountTransferTransformer"));
        service.setHandlerList(getServiceHandlers((("transferservice"))));
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
        handler.setHandlerImpl(("processor.AccountValidationHandler")); //class name

        RegisteredService.ServiceHandler handler1 = new RegisteredService.ServiceHandler();

        handler1.setPosition(2);
        handler1.setHandlerImpl(("processor.AccountTransferHandler")); //class name

        handlers.add(handler);
        handlers.add(handler1);

        return handlers;
    }


    public static Account createSourceAccount() {
        return AccountFactory.createAccount(Type.BASIC, SOURCE_ACCT_NO, SOURCE_ACCT_NAME, BASIC_ACCT_BAL, true, false);
    }

    public static Account createDestinationAccount() {
        return AccountFactory.createAccount(Type.BASIC, DESTINATION_ACCT_NO, DESTINATION_ACCT_NAME, BASIC_ACCT_BAL, true, false);
    }

    public static PoolAccount createPoolAccount() {
        return (PoolAccount) AccountFactory.createAccount(Type.POOL, POOL_ACCT_NO, POOL_ACCT_NAME, POOL_ACCT_BAL, true, false);
    }

    //1.validation on source and destination acct
    //is acct active, is acct restricted, --> validation handler
    // is amount < current balance for source acct --> balance inquiry handler
    //debit source acct, credit pool acct, debit pool acct, credit destination acct
    //2. transfer funds to pool account

    //isAcctValid()
    //doesAcctHaveSufficientFunds() --> balance inquiry
    //debitAcct(source, dest)
    //creditAcct(source, debit)


    /**
     * @return list of accounts
     */
    public static List<Account> createAccounts() {
        accounts.add(createSourceAccount());
        accounts.add(createDestinationAccount());
        accounts.add(createPoolAccount());

        return accounts;
    }


    public static Account findAccountByAcctNo(String accountNo) {
        return accounts.stream()
                .filter((account -> account.getAccountNo().equals(accountNo)))
                .findFirst().orElse(null);
    }

    public static PoolAccount getPoolAccount() {
        return (PoolAccount) accounts.stream()
                .filter((account -> account.getAccountType().equals(Type.POOL)))
                .findFirst().orElse(null);
    }

    public static void debitAccount(Account account, double amount) throws Exception {
        account.debit(amount);
    }

    public static void creditAccount(Account account, double amount) throws Exception {
        account.credit(amount);
    }


    public static void debitPoolAccount(PoolAccount account,
                                        double amount,
                                        String sourceAcct,
                                        String destAcct) throws Exception {
        account.setSourceAcctNo(sourceAcct);
        account.setDestinationAcctNo(destAcct);
        account.setAmountInTransit(amount);
        account.debit(amount);
    }

    public static void creditPoolAccount(PoolAccount account, double amount,
                                         String sourceAcct, String destAcct) throws Exception {
        account.setSourceAcctNo(sourceAcct);
        account.setDestinationAcctNo(destAcct);
        account.setAmountInTransit(amount);
        account.credit(amount);
    }

    public static boolean sourceAccountValidation(String accountNo, double amount) {
        Account account = findAccountByAcctNo(accountNo);
        if (account != null) {
            if (account.isActive() && account.isRestricted() && account.getAccountBalance() > amount) return true;
        }
        return false;
    }

    public static boolean destAccountValidation(String accountNo) {
        Account account = findAccountByAcctNo(accountNo);
        if (account != null) {
            if (account.isActive() && account.isRestricted()) return true;
        }
        return false;
    }

    public static void reverseTransferToSourceAcct(PoolAccount account) throws Exception {
        debitPoolAccount(account, account.getAmountInTransit(), null, null);
        creditAccount(findAccountByAcctNo(account.getSourceAcctNo()), account.getAmountInTransit());
    }

    public static void postTransferToDestinationAcct(PoolAccount account) throws Exception {
        debitPoolAccount(account, account.getAmountInTransit(), account.getSourceAcctNo(), account.getDestinationAcctNo());
        creditAccount(findAccountByAcctNo(account.getDestinationAcctNo()), account.getAmountInTransit());
    }

    public static void postTransferToPool(PoolAccount account) throws Exception {
        debitAccount(findAccountByAcctNo(account.getSourceAcctNo()), account.getAmountInTransit());
        creditPoolAccount(account, account.getAmountInTransit(), account.getSourceAcctNo(), account.getDestinationAcctNo());
    }


    public static void postTransferToDestinationAcct(PoolAccount account, Account sourceAcct, Account destAcct) throws Exception {
        debitPoolAccount(account, account.getAmountInTransit(), sourceAcct.getAccountNo(), destAcct.getAccountNo());
        creditAccount(destAcct, account.getAmountInTransit());
    }

    public static void postTransferToPool(PoolAccount account, Account sourceAcct, Account destAcct) throws Exception {
        debitAccount(sourceAcct, account.getAmountInTransit());
        creditPoolAccount(account, account.getAmountInTransit(), sourceAcct.getAccountNo(), destAcct.getAccountNo());
    }

}


