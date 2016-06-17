package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.NoSuchLocatorException;
import utils.WebElementsActions;

import java.io.IOException;

/**
 * Created by ViTaLES on 27.05.2016.
 */
public class MainPage {

    WebElementsActions web;
    private static final Logger log = Logger.getLogger(LoginPage.class);

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