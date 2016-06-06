package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.NoSuchLocatorException;
import utils.Randomizer;
import utils.WebElementsActions;

import java.io.IOException;

/**
 * Created by ViTaLES on 27.05.2016.
 */
public class LoginPage {

    WebElementsActions web;
    private static final Logger log = Logger.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver) {
        web = new WebElementsActions(driver);
    }

    public void fillLoginForm(String email, String password) throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException, NoSuchLocatorException {
        web.input("LoginEmailInput", email);
        web.clickElement("LoginPasswordInputClickLocator");
        web.input("LoginPasswordInput", password);
        log.info("Fill login form correct");
    }

    public void confirmLoginForm() throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException, NoSuchLocatorException {
        web.clickButton("LoginConfirmButton");
        log.info("Confim button clicked");
    }

    public void switchToMainPage() throws ClassNotFoundException, IOException, InstantiationException, NoSuchLocatorException, IllegalAccessException {
        web.clickElement("MainPageLogoLink");
    }

    public void confirmForm(String confirmButton) throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException, NoSuchLocatorException {
        web.clickButton(confirmButton);
    }

    public void loginFillEmail(String email) throws ClassNotFoundException, IOException, InstantiationException, NoSuchLocatorException, IllegalAccessException {
        web.input("LoginEmailInput", email);
    }

    public void loginFillPassword(String password) throws ClassNotFoundException, IOException, InstantiationException, NoSuchLocatorException, IllegalAccessException {
        web.clickElement("LoginPasswordInputClickLocator");
        web.input("LoginPasswordInput", password);
    }

    public void loginFillHugePassword() throws ClassNotFoundException, IOException, InstantiationException, NoSuchLocatorException, IllegalAccessException {
        web.clickElement("LoginPasswordInputClickLocator");

        StringBuilder builder = new StringBuilder();
        for (int i=0; i < 3300; i++){
            builder.append("ellostest0123456789E");
        }

        log.info(builder);

        String text = builder.toString();

        web.input("LoginPasswordInput", text);
        web.input("LoginPasswordInput", text);

    }

    public String fillInValidRegistrationData() throws ClassNotFoundException, IOException, InstantiationException, NoSuchLocatorException, IllegalAccessException {
        Randomizer rand = new Randomizer();
/*
        web.input("EmailAddressField", web.generateRandomEmail(email));
        */
        String email = "ellostest".concat(Integer.toString(rand.getRandomInt(9999)).concat("@").concat("mailinator.com"));
        String password = "ellostest";

        web.input("RegEmailInput", email);
        web.input("RegEmailRepeatInput", email);
        web.clickElement("RegPasswordFieldClick");
        web.input("RegPasswordInput", password);
        web.clickElement("RegPasswordFieldRepeatClick");
        web.input("RegPasswordRepeatInput", password);
        log.info("Inputted email "+ email);
        log.info("Inputted password " + password);
        return email;
    }

    public void confirmRegistrationForm() throws ClassNotFoundException, IOException, InstantiationException, NoSuchLocatorException, IllegalAccessException {
        web.clickButton("ConfirmRegistrButton");
        log.info("Confirm registration button clicked");
    }

    public String checkNonExistUserErrorText() throws ClassNotFoundException, IOException, InstantiationException, NoSuchLocatorException, IllegalAccessException {
        String actualError = web.getElementText("LoginErrorTextArea");
        String expectedError = "* Fel e-postadress eller lösenord. Om du har\n"+
                "glömt dina inloggningsuppgifter kan du gå till\n" +
                "glömt lösenord sidan. Kommer du fortfarande inte\n" +
                "in på ditt konto kontakta oss här.";
        log.info("Invalid user error: "+ actualError);

        return expectedError.equals(actualError)?"Error is correct":"Error is incorrect";
    }

    public String checkEmptyEmailErrorText() throws ClassNotFoundException, IOException, InstantiationException, NoSuchLocatorException, IllegalAccessException {
        String actualError = web.getElementText("LoginErrorTextArea");
        String expectedError = "*Måste ange ett användarnamn.";
        return expectedError.equals(actualError)?"Error is correct":"Error is incorrect";
    }

    public String checkEmptyPasswordErrorText() throws ClassNotFoundException, IOException, InstantiationException, NoSuchLocatorException, IllegalAccessException {
        String actualError = web.getElementText("LoginErrorTextArea");
        String expectedError = "*Måste ange ett lösenord.";
        log.info("Displayed error text is: ");
        log.info(actualError);

        return expectedError.equals(actualError)?"Error is correct":"Error is incorrect";
    }

    public boolean checkEmptyEmailPasswordErrorText() throws ClassNotFoundException, IOException, InstantiationException, NoSuchLocatorException, IllegalAccessException {
        String actualError = web.getElementText("LoginErrorTextArea");
        String expectedError = "*Måste ange ett användarnamn.\n"+"*Måste ange ett lösenord.";
        log.info("Displayed error text is: ");
        log.info(actualError);

        return expectedError.equals(actualError)?true:false;
    }

    public void logOut() throws ClassNotFoundException, IOException, InstantiationException, NoSuchLocatorException, IllegalAccessException {
        web.clickLink("LogoutLink");
    }

    public String checkCurrentURL() {
        String expectedURL = "http://www.ellos.se/Error/error.aspx?keyword=errorpage_undefined_error";
        String actualURL = web.getCurrentURL();
        return expectedURL.equals(actualURL) ? "Redirected to error page" : "Not redirected";
    }

    public void regFill1email(String s) throws ClassNotFoundException, IOException, InstantiationException, NoSuchLocatorException, IllegalAccessException {
        web.input("RegEmailInput", s);
    }

    public void regFill2email(String s) throws ClassNotFoundException, IOException, InstantiationException, NoSuchLocatorException, IllegalAccessException {
        web.input("RegEmailRepeatInput", s);
    }

    public void regFill1pass(String ellostest) throws ClassNotFoundException, IOException, InstantiationException, NoSuchLocatorException, IllegalAccessException {
        web.clickElement("RegPasswordFieldClick");
        web.input("RegPasswordInput", ellostest);
    }

    public void regFill2pass(String ellostest) throws ClassNotFoundException, IOException, InstantiationException, NoSuchLocatorException, IllegalAccessException {
        web.clickElement("RegPasswordFieldRepeatClick");
        web.input("RegPasswordRepeatInput", ellostest);
    }

    public void uncheckSubscriptionCheckbox() throws ClassNotFoundException, IOException, InstantiationException, NoSuchLocatorException, IllegalAccessException {

        web.clickElement("EmailSubscriptionCheckbox");
    }

    public String checkIncorrectEmailMaskErrorText() throws ClassNotFoundException, IOException, InstantiationException, NoSuchLocatorException, IllegalAccessException {
        String actualError = web.getElementText("RegistrationServerErrorsContainer");
        String expectedError = "* Felaktig e-postadress";
        log.info("Displayed error text is: ");
        log.info(actualError);

        return expectedError.equals(actualError)?"Error is correct":"Error is incorrect";
    }

    public String checkEmptyEmailPassRegistrationErrorText() throws ClassNotFoundException, IOException, InstantiationException, NoSuchLocatorException, IllegalAccessException {

        String actualError = web.getElementText("RegistrationFrontendErrorsContainer");
        String expectedError = "*Vänligen kontrollera stavningen i din e-postadress och försök igen.\n" +
                                "*Bekräfta e-post\n" +
                                "*Du har inte valt ett lösenord.\n" +
                                "*Bekräfta lösenord";
        log.info("Displayed error text is: ");
        log.info(actualError);

        return expectedError.equals(actualError)?"Error is correct":"Error is incorrect";
    }

    public String checkEmptyEmailRegistrationErrorText() throws ClassNotFoundException, IOException, InstantiationException, NoSuchLocatorException, IllegalAccessException {
        String actualError = web.getElementText("RegistrationFrontendErrorsContainer");
        String expectedError = "*Vänligen kontrollera stavningen i din e-postadress och försök igen.\n" +
                                "*Bekräfta e-post";
        log.info("Displayed error text is: ");
        log.info(actualError);

        return expectedError.equals(actualError)?"Error is correct":"Error is incorrect";
    }

    public String checkEmptyPassRegistrationErrorText() throws ClassNotFoundException, IOException, InstantiationException, NoSuchLocatorException, IllegalAccessException {
        String actualError = web.getElementText("RegistrationFrontendErrorsContainer");
        String expectedError = "*Du har inte valt ett lösenord.\n" +
                                "*Bekräfta lösenord";
        log.info("Displayed error text is: ");
        log.info(actualError);

        return expectedError.equals(actualError)?"Error is correct":"Error is incorrect";
    }

    public String checkDifferentEmailsErrorText() throws ClassNotFoundException, IOException, InstantiationException, NoSuchLocatorException, IllegalAccessException {
        String actualError = web.getElementText("RegistrationServerErrorsContainer");
        String expectedError = "* E-post och bekräfta e-post överensstämmer inte";
        log.info("Displayed error text is: ");
        log.info(actualError);

        return expectedError.equals(actualError)?"Error is correct":"Error is incorrect";
    }

    public String checkDifferentPasswordsErrorText() throws ClassNotFoundException, IOException, InstantiationException, NoSuchLocatorException, IllegalAccessException {
        String actualError = web.getElementText("RegistrationServerErrorsContainer");
        String expectedError = "* Lösenord och bekräfta lösenord överensstämmer inte";
        log.info("Displayed error text is: ");
        log.info(actualError);

        return expectedError.equals(actualError)?"Error is correct":"Error is incorrect";
    }


    public String checkShortPasswordErrorText() throws ClassNotFoundException, IOException, InstantiationException, NoSuchLocatorException, IllegalAccessException {
        String actualError = web.getElementText("RegistrationServerErrorsContainer");
        String expectedError = "* Lösenordet måste innehålla minst 4 tecken.";
        log.info("Displayed error text is: ");
        log.info(actualError);

        return expectedError.equals(actualError)?"Error is correct":"Error is incorrect";
    }

    public String checkAlreadyRegisteredEmailErrorText() throws ClassNotFoundException, IOException, InstantiationException, NoSuchLocatorException, IllegalAccessException {
        String actualError = web.getElementText("RegistrationServerErrorsContainer");
        String expectedError = "* E-postadressen är redan registerad.";
        log.info("Displayed error text is: ");
        log.info(actualError);

        return expectedError.equals(actualError)?"Error is correct":"Error is incorrect";
    }
}

