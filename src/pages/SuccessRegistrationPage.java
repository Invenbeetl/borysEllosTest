package pages;

import org.openqa.selenium.WebDriver;
import utils.NoSuchLocatorException;
import utils.WebElementsActions;

import java.io.IOException;

/**
 * Created by borys on 03.06.2016.
 */
public class SuccessRegistrationPage {
    WebElementsActions web;

    public SuccessRegistrationPage(WebDriver driver){
        web = new WebElementsActions(driver);
    }

    public boolean checkRegisteredEmail(String email) throws ClassNotFoundException, IOException, InstantiationException, NoSuchLocatorException, IllegalAccessException {
        return email.equals(web.getElementText("RegisteredEmailContainer"))?true:false;
    }

    public void logOut() throws ClassNotFoundException, IOException, InstantiationException, NoSuchLocatorException, IllegalAccessException {
        web.clickLink("LogoutLink");
    }
}
