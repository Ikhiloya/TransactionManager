import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import spark.Spark;
import spark.utils.IOUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TransactionControllerIntegrationTest {

    @BeforeClass
    public static void beforeClass() {
        TransactionController.main(null);
    }

    @AfterClass
    public static void afterClass() {
        Spark.stop();
    }

    @Test
    public void testTransferServiceEndPoint() {
        try {
            URL url = new URL("http://localhost:8010/service/transferservice?sourceAccountNo=20191452501&destinationAccountNo=20191239484&accountName=Ikhiloya&transferAmount=15000&remark=from");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.connect();
            String body = IOUtils.toString(connection.getInputStream());
            assertTrue(body.length() > 0);
            assertEquals(200, connection.getResponseCode());
        } catch (IOException e) {
            e.printStackTrace();
            fail("Sending request failed: " + e.getMessage());
        }
    }

}
