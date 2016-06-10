package tests;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by ViTaLES on 08.06.2016.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginTests.class,
        RegistrationTests.class,
        ProductTests.class
})
public class Runner {
        static WebDriver driver;
        private static final Logger log = Logger.getLogger(Fixture.class);

        @BeforeClass
        public static void setUp() throws Exception {
                driver = new FirefoxDriver();
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                driver.manage().window().maximize();
                log.info("<=== Start ?????? tests ===>");
        }

        @AfterClass
        public static void tearDown() throws Exception {
                log.info("<=== Finished ?????? tests ===>");
                log.info("Close Browser!");
                driver.quit();
        }
}
