package pages;

import org.eclipse.jetty.util.log.LoggerLog;
import org.openqa.selenium.WebDriver;
import utils.NoSuchLocatorException;
import utils.WebElementsActions;

import java.io.IOException;

/**
 * Created by borys on 10.06.2016.
 */
public class HerrPage {
    WebElementsActions web;
    LoggerLog log = new LoggerLog(HerrPage.class);

    public HerrPage(WebDriver driver) {
        web = new WebElementsActions(driver);
    }


    public void moveToTshortsSection() throws ClassNotFoundException, IOException, InstantiationException, NoSuchLocatorException, IllegalAccessException {
        web.clickLink("TshortSectionLink");
        log.info("T-short menu section link is clicked");

    }
}
