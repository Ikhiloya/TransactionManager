import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import spark.Spark;

public class MainControllerIntegrationTest {

    @BeforeClass
    public static void beforeClass() {
        MainController.main(null);
    }

    @AfterClass
    public static void afterClass() {
        Spark.stop();
    }


    @Test
    public void  transferFromSourceToDestAcct() {



    }


}
