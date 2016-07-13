package pages;

import org.openqa.selenium.WebDriver;
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


    public boolean checkRegisteredEmail(String email) {
        return email.equals(web.getElementText("RegisteredEmailContainer"))?true:false;
    }

    public void logOut() {
        web.clickLink("LogoutLink");
    }
}
