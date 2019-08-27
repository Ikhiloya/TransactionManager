package model.data;

import util.Type;

public class AccountFactory {
    public static Account createAccount(Type type, String accountNo, String accountName,
                                        double accountBalance, boolean isActive,
                                        boolean isRestricted) {
        switch (type) {
            case BASIC:
                return new Account(accountNo, accountName, accountBalance, isActive, isRestricted, Type.BASIC);
            case POOL:
                return new PoolAccount(accountNo, accountName, accountBalance, isActive, isRestricted, Type.POOL);
            default:
                return null;
        }
    }
}
