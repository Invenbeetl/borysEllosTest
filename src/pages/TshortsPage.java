package pages;

import org.eclipse.jetty.util.log.LoggerLog;
import org.openqa.selenium.WebDriver;
import utils.NoSuchLocatorException;
import utils.WebElementsActions;

import java.io.IOException;

/**
 * Created by borys on 10.06.2016.
 */
public class TshortsPage {
    WebElementsActions web;
    LoggerLog log = new LoggerLog(TshortsPage.class);

    public TshortsPage(WebDriver driver) {
        web = new WebElementsActions(driver);
    }


    //Go to any t-short product page
    public void moveToPDP() throws ClassNotFoundException, IOException, InstantiationException, NoSuchLocatorException, IllegalAccessException {
        web.clickLink("FirstDisplayedTshortLink");
        log.info("First product link is clicked");
    }
}
