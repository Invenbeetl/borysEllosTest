package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.ClassNameUtil;
import utils.NoSuchLocatorException;
import utils.WebDriverWrapper;
import utils.WebElementsActions;

import java.io.IOException;

/**
 * Created by borys on 05.06.2016.
 */
public class ErrorPage extends Page {

    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    public ErrorPage(WebDriverWrapper dr) {
        super(dr);
    }


    public void moveToMainPage() {
        web.clickButton("MainPageButton");
        log.info("Link to main page is clicked");
    }
}
