package tests;

import org.apache.log4j.Logger;
import org.testng.annotations.*;
import pages.Ellos;
import utils.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by ViTaLES on 06.06.2016.
 */
public class Fixture {

    public static Ellos ellos;
    static WebDriverWrapper driver;
    private static final String IMPLICIT_WAIT = PropertyLoader.loadProperty("wait.timeout");
    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    @BeforeSuite
    public static void setUp() {
        UIMappingSingleton.getInstance();

        driver = WebDriverFactory.getInstance();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(IMPLICIT_WAIT), TimeUnit.SECONDS);
        ellos = new Ellos(driver);
        log.info("<=== Start test class - ===>");
    }

    /*@BeforeMethod
    public static void beforeMethod(ITestResult testResult) {
        log.info("<=== Start test - " + testResult.getTestName() + " ===>");
    }

    @AfterMethod
    public static void afterMethod(ITestResult testResult) {
        if (testResult.isSuccess()) {
            log.info("<=== Test - " + testResult.getTestName() + " is " + testResult.getStatus() + " ===>");
        } else {
            log.error("<=== Test - " + testResult.getTestName() + " is " + testResult.getStatus() + " ===>");
            ellos.screenShotMaker.takeScreenShot(testResult.getTestName());
        }
        log.info("<=== End test - " + testResult.getTestName() + " ===>");
    }*/

    @AfterSuite
    public static void tearDown() {
        log.info("<=== Finished ?????? tests ===>");
        log.info("Close Browser!");
        driver.quit();
    }
}
