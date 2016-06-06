package tests;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.WebElementsActions;

import java.util.concurrent.TimeUnit;

/**
 * Created by ViTaLES on 06.06.2016.
 */
public class Fixture {

    static WebDriver driver;
    String baseUrl = "http://www.ellos.se/";
    static WebElementsActions web;
    private static final Logger log = Logger.getLogger(Fixture.class);

    @BeforeClass
    public static void setUp() throws Exception {
        driver = new FirefoxDriver();
        web = new WebElementsActions(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        log.info("<=== Start Login tests ===>");
    }


    @AfterClass
    public static void tearDown() throws Exception {
        log.info("<=== Finished Login tests ===>");
        log.info("Close Browser!");
        driver.quit();
    }


}
