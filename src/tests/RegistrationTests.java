package tests;

import org.apache.log4j.Logger;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.SuccessRegistrationPage;
import utils.NoSuchLocatorException;

/**
 * Created by ViTaLES on 06.06.2016.
 */
public class RegistrationTests extends Fixture {

    //Registration functionality tests
    private static final Logger log = Logger.getLogger(RegistrationTests.class);
    String baseUrl = "http://www.ellos.se/";

    @Test
    public void newUserSuccessRegistration() throws Exception, NoSuchLocatorException {
        web.openPage(baseUrl);
        web.refreshPage();

        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginLink();

        LoginPage loginPage = new LoginPage(driver);
        String email = loginPage.fillInValidRegistrationData();
        loginPage.uncheckSubscriptionCheckbox();
        loginPage.confirmRegistrationForm();

        SuccessRegistrationPage successRegistrationPage = new SuccessRegistrationPage(driver);
        System.out.println(successRegistrationPage.checkRegisteredEmail(email));
        successRegistrationPage.logOut();

    }

    //@Test
    public void emailMaskRegistarion() throws Exception, NoSuchLocatorException {
        web.openPage(baseUrl);
        web.refreshPage();

        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.regFill1email("ellostest.com");
        loginPage.regFill2email("ellostest.com");
        loginPage.regFill1pass("ellostest");
        loginPage.regFill2pass("ellostest");
        loginPage.confirmRegistrationForm();

        System.out.println(loginPage.checkIncorrectEmailMaskErrorText());
    }

    //@Test
    public void emptyEmailAndPassRegistrationValidation() throws Exception, NoSuchLocatorException {
        web.openPage(baseUrl);
        web.refreshPage();

        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.confirmRegistrationForm();

        System.out.println(loginPage.checkEmptyEmailPassRegistrationErrorText());
    }

    //@Test
    public void emptyEmailRegistrationValidation() throws Exception, NoSuchLocatorException {
        web.openPage(baseUrl);
        web.refreshPage();

        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.regFill1pass("ellostest");
        loginPage.regFill2pass("ellostest");
        loginPage.confirmRegistrationForm();

        System.out.println(loginPage.checkEmptyEmailRegistrationErrorText());
    }

    //@Test
    public void emptyPassRegistrationValidation() throws Exception, NoSuchLocatorException {
        web.openPage(baseUrl);
        web.refreshPage();

        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.regFill1email("ellostest@mailinator.com");
        loginPage.regFill2email("ellostest@mailinator.com");
        loginPage.confirmRegistrationForm();

        System.out.println(loginPage.checkEmptyPassRegistrationErrorText());
    }

    //@Test
    public void differentEmailsRegValidation() throws Exception, NoSuchLocatorException {
        web.openPage(baseUrl);
        web.refreshPage();

        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.regFill1email("ellostest@mailinator.com");
        loginPage.regFill2email("elloste@mailinator.com");
        loginPage.regFill1pass("ellostest");
        loginPage.regFill2pass("ellostest");
        loginPage.confirmRegistrationForm();

        System.out.println(loginPage.checkDifferentEmailsErrorText());
    }

    //@Test
    public void differentPasswordsRegValidation() throws Exception, NoSuchLocatorException {
        web.openPage(baseUrl);
        web.refreshPage();

        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.regFill1email("ellostest@mailinator.com");
        loginPage.regFill2email("ellostest@mailinator.com");
        loginPage.regFill1pass("ellostest");
        loginPage.regFill2pass("ellost");
        loginPage.confirmRegistrationForm();

        System.out.println(loginPage.checkDifferentPasswordsErrorText());
    }

    //@Test
    public void shortPasswordRegValidation() throws Exception, NoSuchLocatorException {
        web.openPage(baseUrl);
        web.refreshPage();

        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.regFill1email("ellostest@mailinator.com");
        loginPage.regFill2email("ellostest@mailinator.com");
        loginPage.regFill1pass("@");
        loginPage.regFill2pass("@");
        loginPage.confirmRegistrationForm();

        System.out.println(loginPage.checkShortPasswordErrorText());
    }

    //@Test
    public void registeredAccountValidation() throws Exception, NoSuchLocatorException {
        web.openPage(baseUrl);
        web.refreshPage();

        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.regFill1email("ellostest@mailinator.com");
        loginPage.regFill2email("ellostest@mailinator.com");
        loginPage.regFill1pass("ellos");
        loginPage.regFill2pass("ellos");
        loginPage.confirmRegistrationForm();

        System.out.println(loginPage.checkAlreadyRegisteredEmailErrorText());
    }

}
