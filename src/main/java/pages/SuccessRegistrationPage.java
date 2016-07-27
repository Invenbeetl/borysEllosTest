package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.ClassNameUtil;
import utils.NoSuchLocatorException;
import utils.WebDriverWrapper;
import utils.WebElementsActions;

import java.io.IOException;

/**
 * Created by borys on 03.06.2016.
 */
public class SuccessRegistrationPage extends Page {

    public SuccessRegistrationPage(WebDriverWrapper dr) {
        super(dr);
    }

    private final static Logger log=Logger.getLogger(ClassNameUtil.getCurrentClassName());


    public boolean checkRegisteredEmail(String email) {
        return email.equals(web.getElementText("RegisteredEmailContainer"));
    }

    public void logOut() {
        web.clickLink("LogoutLink");
        log.info("Logout link is clicked");
    }
}
