package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.NoSuchLocatorException;
import utils.WebElementsActions;

import java.io.IOException;

/**
 * Created by borys on 05.06.2016.
 */
public class ErrorPage {

    WebElementsActions web;
    private static final Logger log = Logger.getLogger(LoginPage.class);


    public ErrorPage(WebDriver driver) {
        web = new WebElementsActions(driver);
    }

    public void moveToMainPage() throws ClassNotFoundException, IOException, InstantiationException, NoSuchLocatorException, IllegalAccessException {
        web.clickButton("MainPageButton");
    }
}
