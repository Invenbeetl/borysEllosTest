package tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.SuccessRegistrationPage;
import utils.ClassNameUtil;
import utils.NoSuchLocatorException;

/**
 * Created by ViTaLES on 06.06.2016.
 */
public class RegistrationTests extends Fixture {

    //Registration functionality tests
    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    @Test
    public void newUserSuccessRegistration() {
        ellos.mainPage.openPage();
        ellos.web.refreshPage();

        ellos.mainPage.clickLoginLink();

        String email = ellos.loginPage.fillInValidRegistrationData();
        ellos.loginPage.uncheckSubscriptionCheckbox();
        ellos.loginPage.confirmRegistrationForm();

        Assert.assertTrue(ellos.successRegistrationPage.checkRegisteredEmail(email),
                "Displayed e-mail is not one, that was inputted during registration or registration is failed");
        ellos.successRegistrationPage.logOut();

    }

    //@Test
    public void emailMaskRegistarion() {
        ellos.mainPage.openPage();
        ellos.web.refreshPage();

        ellos.mainPage.clickLoginLink();

        ellos.loginPage.regFill1email("ellostest.com");
        ellos.loginPage.regFill2email("ellostest.com");
        ellos.loginPage.regFill1pass("ellostest");
        ellos.loginPage.regFill2pass("ellostest");
        ellos.loginPage.confirmRegistrationForm();

        Assert.assertTrue(ellos.loginPage.checkIncorrectEmailMaskErrorText(), "Icorrect error about incorrect format of email is displayed");
    }

    //@Test
    public void emptyEmailAndPassRegistrationValidation() {
        ellos.mainPage.openPage();
        ellos.web.refreshPage();

        ellos.mainPage.clickLoginLink();

        ellos.loginPage.confirmRegistrationForm();

        Assert.assertTrue(ellos.loginPage.checkEmptyEmailPassRegistrationErrorText(),
                "Error about not filled email and password is incorrect or absent");
    }

    //@Test
    public void emptyEmailRegistrationValidation() {
        ellos.mainPage.openPage();
        ellos.web.refreshPage();

        ellos.mainPage.clickLoginLink();

        ellos.loginPage.regFill1pass("ellostest");
        ellos.loginPage.regFill2pass("ellostest");
        ellos.loginPage.confirmRegistrationForm();

        Assert.assertTrue(ellos.loginPage.checkEmptyEmailRegistrationErrorText(), "Error about not filled email is incorrect or absent");
    }

    //@Test
    public void emptyPassRegistrationValidation() {
        ellos.mainPage.openPage();
        ellos.web.refreshPage();

        ellos.mainPage.clickLoginLink();

        ellos.loginPage.regFill1email("ellostest@mailinator.com");
        ellos.loginPage.regFill2email("ellostest@mailinator.com");
        ellos.loginPage.confirmRegistrationForm();

        Assert.assertTrue(ellos.loginPage.checkEmptyPassRegistrationErrorText(), "Error about not filled password is incorrect or absent");
    }

    //@Test
    public void differentEmailsRegValidation() {
        ellos.mainPage.openPage();
        ellos.web.refreshPage();

        ellos.mainPage.clickLoginLink();

        ellos.loginPage.regFill1email("ellostest@mailinator.com");
        ellos.loginPage.regFill2email("elloste@mailinator.com");
        ellos.loginPage.regFill1pass("ellostest");
        ellos.loginPage.regFill2pass("ellostest");
        ellos.loginPage.confirmRegistrationForm();

        Assert.assertTrue(ellos.loginPage.checkDifferentEmailsErrorText(), "Error about different inputted emails is incorrect or absent");
    }

    //@Test
    public void differentPasswordsRegValidation() {
        ellos.mainPage.openPage();
        ellos.web.refreshPage();

        ellos.mainPage.clickLoginLink();

        ellos.loginPage.regFill1email("ellostest@mailinator.com");
        ellos.loginPage.regFill2email("ellostest@mailinator.com");
        ellos.loginPage.regFill1pass("ellostest");
        ellos.loginPage.regFill2pass("ellost");
        ellos.loginPage.confirmRegistrationForm();

        Assert.assertTrue(ellos.loginPage.checkDifferentPasswordsErrorText(),
                "Error about different inputted passwords is incorrect or absent");
    }

    //@Test
    public void shortPasswordRegValidation() {
        ellos.mainPage.openPage();
        ellos.web.refreshPage();

        ellos.mainPage.clickLoginLink();

        ellos.loginPage.regFill1email("ellostest@mailinator.com");
        ellos.loginPage.regFill2email("ellostest@mailinator.com");
        ellos.loginPage.regFill1pass("@");
        ellos.loginPage.regFill2pass("@");
        ellos.loginPage.confirmRegistrationForm();

        Assert.assertTrue(ellos.loginPage.checkShortPasswordErrorText(), "Error about short inputted password is incorrect or absent");
    }

    //@Test
    public void registeredAccountValidation() {
        ellos.mainPage.openPage();
        ellos.web.refreshPage();

        ellos.mainPage.clickLoginLink();

        ellos.loginPage.regFill1email("ellostest@mailinator.com");
        ellos.loginPage.regFill2email("ellostest@mailinator.com");
        ellos.loginPage.regFill1pass("ellos");
        ellos.loginPage.regFill2pass("ellos");
        ellos.loginPage.confirmRegistrationForm();

        Assert.assertTrue(ellos.loginPage.checkAlreadyRegisteredEmailErrorText(),
                "Error about already registered emails is incorrect or absent");
    }

}
