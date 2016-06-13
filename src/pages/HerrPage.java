package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.NoSuchLocatorException;
import utils.WebElementsActions;

import java.io.IOException;

/**
 * Created by borys on 10.06.2016.
 */
public class HerrPage {
    WebElementsActions web;
    private static final Logger log =  Logger.getLogger(HerrPage.class);

    public HerrPage(WebDriver driver) {
        web = new WebElementsActions(driver);
    }


    public void moveToTshortsSection() throws ClassNotFoundException, IOException, InstantiationException, NoSuchLocatorException, IllegalAccessException {
        web.clickLink("TshortSectionLink");
        log.info("T-short menu section link is clicked");

    }
}
