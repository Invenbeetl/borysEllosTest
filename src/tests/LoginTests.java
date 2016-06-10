package tests;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import pages.ErrorPage;
import pages.LoginPage;
import pages.MainPage;
import utils.NoSuchLocatorException;


public class LoginTests extends Runner {

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
    String baseUrl = "http://www.ellos.se/";


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

        Assert.assertTrue("Logout link not found. Login failed", web.isElementPresent("LogoutLink"));
    }

    @Test
    @Ignore
    public void nonExistUserValidation() throws Exception, NoSuchLocatorException {
        web.openPage(baseUrl);
        web.refreshPage();

        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillLoginForm("invalid@mail.com", "invalidpas");
        loginPage.confirmLoginForm();

        Assert.assertTrue("Non existant user error text incorrect or absent", loginPage.checkNonExistUserErrorText());
    }

    @Test
    @Ignore
    public void emptyEmailValidation() throws Exception, NoSuchLocatorException {
        web.openPage(baseUrl);
        web.refreshPage();

        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginFillPassword("ellostest");
        loginPage.confirmLoginForm();
        loginPage.switchToMainPage();

        Assert.assertTrue("Error about empty email in Login form is incorrect or absent", loginPage.checkEmptyEmailErrorText());
    }

    @Test
    @Ignore
    public void emptyPasswordValidation() throws Exception, NoSuchLocatorException {
        web.openPage(baseUrl);
        web.refreshPage();

        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginFillEmail("ellostest@mailinator.com");
        loginPage.confirmLoginForm();
        loginPage.switchToMainPage();


        Assert.assertTrue("Error about empty password is incorrect or absent", loginPage.checkEmptyPasswordErrorText());
    }

    @Test
    @Ignore
    public void emptyEmailAndPasswordValidation() throws Exception, NoSuchLocatorException {
        web.openPage(baseUrl);
        web.refreshPage();

        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.confirmLoginForm();
        loginPage.switchToMainPage();


        Assert.assertTrue("Error about email and password is incorrect or absent", loginPage.checkEmptyEmailPasswordErrorText());
    }

    //    Check trancate spaces from begin and end of text function in e-mail annd password login input fields
    @Test
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

        Assert.assertTrue("Logout link is absent. Login failed", web.isElementPresent("LogoutLink"));
    }

    @Test
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

        Assert.assertTrue("Logout link is absent. Login failed",web.isElementPresent("LogoutLink"));
    }

    @Test
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
        Assert.assertTrue("Error page is displayed", loginPage.checkCurrentURL());

        ErrorPage errorPage = new ErrorPage(driver);
        errorPage.moveToMainPage();

        /*?????*/
        Assert.assertTrue("Redirection to main page is not performed",mainPage.isCurrentPageMain());

    }


}
