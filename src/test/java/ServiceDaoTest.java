import model.data.Account;
import model.data.PoolAccount;
import org.junit.*;
import spark.Spark;
import util.Constant;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static service.ServiceDao.*;

public class ServiceDaoTest {

    @BeforeClass
    public static void beforeClass() {
        MainController.main(null);

    }

    @AfterClass
    public static void afterClass() {
        Spark.stop();
    }


    @Test
    public void testCreditPoolAcctShouldIncreaseTheAcctBal() {
        PoolAccount poolAccount = createPoolAccount();
        poolAccount.credit(1000);
        assertThat(poolAccount.getAccountNo(), is(Constant.POOL_ACCT_NO));
        assertThat(poolAccount.getAccountBalance(), is(1000.0));
    }


    @Test(expected = Exception.class)
    public void testDebitPoolAcctWhenPoolAcctBalIsZeroShouldThrowException() throws Exception {
        PoolAccount poolAccount = createPoolAccount();
        poolAccount.debit(1000.0);
    }

    @Test
    public void testPostTransferToDestAcctShouldIncreaseDestAcctBal() throws Exception {
        double amountToTransfer = 1000.0;
        PoolAccount poolAccount = createPoolAccount();
        Account destinationAccount = createDestinationAccount();
        Account sourceAccount = createSourceAccount();

        double destAcctBal = destinationAccount.getAccountBalance();
        double sourceAcctBal = sourceAccount.getAccountBalance();

        poolAccount.setSourceAcctNo(sourceAccount.getAccountNo());
        poolAccount.setDestinationAcctNo(destinationAccount.getAccountNo());
        poolAccount.setAmountInTransit(amountToTransfer);

        postTransferToPool(poolAccount, sourceAccount, destinationAccount);

        assertThat(poolAccount.getAccountBalance(), is(amountToTransfer));
        assertThat(sourceAccount.getAccountBalance(), is(sourceAcctBal - amountToTransfer));
        assertThat(poolAccount.getAmountInTransit(), is(amountToTransfer));


        postTransferToDestinationAcct(poolAccount, sourceAccount, destinationAccount);

        assertThat(poolAccount.getAccountBalance(), is(0.0));
        assertThat(destinationAccount.getAccountBalance(), is(Constant.BASIC_ACCT_BAL + amountToTransfer));
    }

    @Test
    public void testPostTransferToPoolAcctShouldDecreaseSourceAcctBal() throws Exception {
        double amountToTransfer = 1000.0;
        PoolAccount poolAccount = createPoolAccount();
        Account destinationAccount = createDestinationAccount();
        Account sourceAccount = createSourceAccount();
        double destAcctBal = destinationAccount.getAccountBalance();
        double sourceAcctBal = sourceAccount.getAccountBalance();

        poolAccount.setSourceAcctNo(sourceAccount.getAccountNo());
        poolAccount.setDestinationAcctNo(destinationAccount.getAccountNo());
        poolAccount.setAmountInTransit(amountToTransfer);
        postTransferToPool(poolAccount, sourceAccount, destinationAccount);

        assertThat(poolAccount.getAccountBalance(), is(amountToTransfer));
        assertThat(sourceAccount.getAccountBalance(), is(sourceAcctBal - amountToTransfer));
    }


}
