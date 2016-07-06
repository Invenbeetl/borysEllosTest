package tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ErrorPage;
import pages.LoginPage;
import pages.MainPage;
import utils.ClassNameUtil;
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

    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());



    @Test
    public void positiveLogin()  {
        ellos.mainPage.openPage();
        ellos.screenShotMaker.takeScreenShot(ClassNameUtil.getCurrentClassName());

        ellos.web.refreshPage();

        ellos.mainPage.clickLoginLink();

        ellos.loginPage.fillLoginForm("ellostest@mailinator.com", "ellostest");
        ellos.loginPage.confirmLoginForm();
        ellos.loginPage.logOut();

        Assert.assertTrue(ellos.web.isElementPresent("LoginRegistrationLink"), "Logout link not found. Login failed");

    }

    @Test
    public void nonExistUserValidation()  {
        ellos.mainPage.openPage();
        ellos.web.refreshPage();

        ellos.mainPage.clickLoginLink();

        ellos.loginPage.fillLoginForm("invalid@mail.com", "invalidpas");
        ellos.loginPage.confirmLoginForm();

        Assert.assertTrue(ellos.loginPage.checkNonExistUserErrorText(), "Non existant user error text incorrect or absent");
    }

    @Test
    public void emptyEmailValidation()  {
        ellos.mainPage.openPage();
        ellos.web.refreshPage();

        ellos.mainPage.clickLoginLink();

        ellos.loginPage.loginFillPassword("ellostest");
        ellos.loginPage.confirmLoginForm();
        ellos.loginPage.switchToMainPage();

        Assert.assertTrue(ellos.loginPage.checkEmptyEmailErrorText(), "Error about empty email in Login form is incorrect or absent");
    }

    @Test
    public void emptyPasswordValidation()  {
        ellos.mainPage.openPage();
        ellos.web.refreshPage();

        ellos.mainPage.clickLoginLink();

        ellos.loginPage.loginFillEmail("ellostest@mailinator.com");
        ellos.loginPage.confirmLoginForm();
        ellos.loginPage.switchToMainPage();


        Assert.assertTrue(ellos.loginPage.checkEmptyPasswordErrorText(), "Error about empty password is incorrect or absent");
    }

    @Test
    public void emptyEmailAndPasswordValidation()  {
        ellos.mainPage.openPage();
        ellos.web.refreshPage();

        ellos.mainPage.clickLoginLink();

        ellos.loginPage.confirmLoginForm();
        ellos.loginPage.switchToMainPage();


        Assert.assertTrue(ellos.loginPage.checkEmptyEmailPasswordErrorText(), "Error about email and password is incorrect or absent");
    }

    //    Check trancate spaces from begin and end of text function in e-mail annd password login input fields
    //@Test
    public void spacesTrancateSuccessLogin()  {
        ellos.mainPage.openPage();
        ellos.web.refreshPage();

        ellos.mainPage.clickLoginLink();

        ellos.loginPage.fillLoginForm("  ellostest@mailinator.com  ", "  ellostest  ");
        ellos.loginPage.confirmLoginForm();
        ellos.loginPage.logOut();

        Assert.assertTrue( ellos.web.isElementPresent("LogoutLink"), "Logout link is absent. Login failed");
    }

    //@Test
    public void tabsTrancateSuccessLogin()  {
        ellos.mainPage.openPage();
        ellos.web.refreshPage();

        ellos.mainPage.clickLoginLink();

        ellos.loginPage.fillLoginForm("   ellostest@mailinator.com\t", "\tellostest   ");
        ellos.loginPage.confirmLoginForm();
        ellos.loginPage.logOut();

        Assert.assertTrue(ellos.web.isElementPresent("LogoutLink"), "Logout link is absent. Login failed");
    }

    //@Test
    public void excessiveSymbolsInputError()  {
        ellos.mainPage.openPage();
        ellos.web.refreshPage();

        ellos.mainPage.clickLoginLink();

        ellos.loginPage.loginFillEmail("ellostest@mailinator.com");
        ellos.loginPage.loginFillHugePassword();
        ellos.loginPage.confirmLoginForm();
        Assert.assertTrue(ellos.loginPage.checkCurrentURL(), "Error page is displayed");

        ellos.errorPage.moveToMainPage();

        /*?????*/
        Assert.assertTrue(ellos.mainPage.isCurrentPageMain(), "Redirection to main page is not performed");

    }


}
