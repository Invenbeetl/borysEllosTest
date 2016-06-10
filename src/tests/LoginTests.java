package tests;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.*;
import pages.ErrorPage;
import pages.LoginPage;
import pages.MainPage;
import utils.NoSuchLocatorException;


public class LoginTests extends Fixture {

//    Usual goods order flow

//    Tests TBD:
//    Success login                   +
//    Non-exist user login            +
//    Empty Login                     +
//    Empty pass                      +
//    Empty all                       +
//    Spaces in login and password    +
//    Tabs in login and password      +
//    Input 72k symbols in password   +-
//    Incorrect data                  +
//    ...

    private static final Logger log = Logger.getLogger(LoginTests.class);


    @Test
    public void positiveLogin() throws Exception, NoSuchLocatorException {
        web.openPage(baseUrl);
        web.refreshPage();

        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillLoginForm("ellostest@mailinator.com", "ellostest");
        loginPage.confirmLoginForm();
        loginPage.logOut();

        Assert.assertTrue("", web.isElementPresent("LoginRegistrationLink"));
    }

    //@Test
    public void nonExistUserValidation() throws Exception, NoSuchLocatorException {
        web.openPage(baseUrl);
        web.refreshPage();

        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillLoginForm("invalid@mail.com", "invalidpas");
        loginPage.confirmLoginForm();

        System.out.println(loginPage.checkNonExistUserErrorText());
    }

    //@Test
    @Ignore
    public void emptyEmailLoginValidation() throws Exception, NoSuchLocatorException {
        web.openPage(baseUrl);
        web.refreshPage();

        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginFillPassword("ellostest");
        loginPage.confirmLoginForm();
        loginPage.switchToMainPage();

        System.out.println(loginPage.checkEmptyEmailErrorText());
    }

    //@Test
    @Ignore
    public void emptyEmaiPasswordValidation() throws Exception, NoSuchLocatorException {
        web.openPage(baseUrl);
        web.refreshPage();

        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginFillEmail("ellostest@mailinator.com");
        loginPage.confirmLoginForm();
        loginPage.switchToMainPage();


        System.out.println(loginPage.checkEmptyPasswordErrorText());
    }

    //@Test
    @Ignore
    public void emptyEmailAndPasswordValidation() throws Exception, NoSuchLocatorException {
        web.openPage(baseUrl);
        web.refreshPage();

        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.confirmLoginForm();
        loginPage.switchToMainPage();


        System.out.println(loginPage.checkEmptyEmailPasswordErrorText());
    }

    //    Check trancate spaces from begin and end of text function in e-mail annd password login input fields
    //@Test
    @Ignore
    public void spacesTrancateSuccessLogin() throws Exception, NoSuchLocatorException {
        web.openPage(baseUrl);
        web.refreshPage();

        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillLoginForm("  ellostest@mailinator.com  ", "  ellostest  ");
        loginPage.confirmLoginForm();
        loginPage.logOut();

        System.out.println(web.isElementPresent("LogoutLink"));
    }

    //@Test
    @Ignore
    public void tabsTrancateSuccessLogin() throws Exception, NoSuchLocatorException {
        web.openPage(baseUrl);
        web.refreshPage();

        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillLoginForm("   ellostest@mailinator.com\t", "\tellostest   ");
        loginPage.confirmLoginForm();
        loginPage.logOut();

        System.out.println(web.isElementPresent("LogoutLink"));
    }

    //@Test
    @Ignore
    public void excessiveSymbolsInputError() throws Exception, NoSuchLocatorException {
        web.openPage(baseUrl);
        web.refreshPage();

        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginFillEmail("ellostest@mailinator.com");
        loginPage.loginFillHugePassword();
        loginPage.confirmLoginForm();
        System.out.println(loginPage.checkCurrentURL());

        ErrorPage errorPage = new ErrorPage(driver);
        errorPage.moveToMainPage();

        /*?????*/
        System.out.println(web.getCurrentURL());
    }

}
