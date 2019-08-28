import model.data.Account;
import model.data.PoolAccount;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Spark;
import util.Constant;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static service.ServiceDao.*;

public class ServiceDaoTest {
    private static Logger log;

    @BeforeClass
    public static void beforeClass() {
        TransactionController.main(null);
        log = LoggerFactory.getLogger(ServiceDaoTest.class);
    }

    @AfterClass
    public static void afterClass() {
        log = null;
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


    @Test
    public void testCreditAndDebitThreadSafety() {
        PoolAccount poolAccount = createPoolAccount();
        Account sourceAccount = createSourceAccount();
        Account destinationAccount = createDestinationAccount();
        PostToPoolAccountThread poolAccountThread = new PostToPoolAccountThread(1000, poolAccount, sourceAccount, destinationAccount);
        PostToDestAccountThread destAccountThread = new PostToDestAccountThread(1000, poolAccount, sourceAccount, destinationAccount);

        for (int i = 0; i < 10; i++) {
            poolAccountThread.run();
            destAccountThread.run();
        }

        assertThat(poolAccount.getAccountBalance(), is(0.0));
        assertThat(sourceAccount.getAccountBalance(), is(10000.0));
        assertThat(destinationAccount.getAccountBalance(), is(30000.0));
    }


    private class PostToPoolAccountThread implements Runnable {
        double amount;
        PoolAccount poolAccount;
        Account sourceAcct;
        Account destAcct;

        public PostToPoolAccountThread(double amount, PoolAccount poolAccount, Account sourceAcct, Account destAcct) {
            this.amount = amount;
            this.poolAccount = poolAccount;
            this.sourceAcct = sourceAcct;
            this.destAcct = destAcct;
            this.poolAccount.setAmountInTransit(amount);
        }

        @Override
        public void run() {
            log.info("PostToPoolAccountThread ID: " + Thread.currentThread().getId());
            try {
                postTransferToPool(poolAccount, sourceAcct, destAcct);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private class PostToDestAccountThread implements Runnable {
        private double amount;
        PoolAccount poolAccount;
        Account sourceAcct;
        Account destAcct;

        public PostToDestAccountThread(double amount, PoolAccount poolAccount, Account sourceAcct, Account destAcct) {
            this.amount = amount;
            this.poolAccount = poolAccount;
            this.sourceAcct = sourceAcct;
            this.destAcct = destAcct;
            this.poolAccount.setAmountInTransit(amount);
        }

        @Override
        public void run() {
            log.info("PostToDestAccountThread ID: " + Thread.currentThread().getId());
            try {
                postTransferToDestinationAcct(poolAccount, sourceAcct, destAcct);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


