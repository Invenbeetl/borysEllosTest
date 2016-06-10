package pages;

import org.eclipse.jetty.util.log.LoggerLog;
import org.openqa.selenium.WebDriver;
import utils.NoSuchLocatorException;
import utils.WebElementsActions;

import java.io.IOException;

/**
 * Created by ViTaLES on 27.05.2016.
 */
public class MainPage {

    WebElementsActions web;
    LoggerLog log = new LoggerLog(MainPage.class);

    public MainPage(WebDriver driver) {
        web = new WebElementsActions(driver);
    }

    public void clickLoginLink() throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException, NoSuchLocatorException {
        web.clickLink("LoginRegistrationLink");
        log.info("Login/Registration link is clicked");
    }

    public boolean isCurrentPageMain() {
        return web.getCurrentURL().equals("http://www.ellos.se")?true:false;
    }

    public void moveToHerrGoodsPage() throws ClassNotFoundException, IOException, InstantiationException, NoSuchLocatorException, IllegalAccessException {
        web.clickLink("HerrSectionLink");
        log.info("\"Herr\" menu section is clicked");
    }
}