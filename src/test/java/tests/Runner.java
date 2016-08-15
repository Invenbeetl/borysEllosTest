package tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

/**
 * Created by ViTaLES on 08.06.2016.
 */
public class  Runner {
        static WebDriver driver;
        private static final Logger log = Logger.getLogger(Fixture.class);

        @BeforeSuite
        public static void setUp() throws Exception {
                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                driver.manage().window().maximize();
                log.info("<=== Start ?????? tests ===>");
        }

        @AfterSuite
        public static void tearDown() throws Exception {
                log.info("<=== Finished ?????? tests ===>");
                log.info("Close Browser!");
                driver.quit();
        }
}
