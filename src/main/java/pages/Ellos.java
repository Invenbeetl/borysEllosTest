package pages;

import utils.ScreenShotMaker;
import utils.WebDriverWrapper;
import utils.WebElementsActions;

/**
 * Created by borys on 17.06.2016.
 */
public class Ellos {
    public WebElementsActions web;
    public ErrorPage errorPage;
    public MainPage mainPage;
    public HerrPage herrPage;
    public LoginPage loginPage;
    public SuccessRegistrationPage successRegistrationPage;
    public ProductPage productPage;
    public CheckoutPage checkoutPage;
    public TshortsPage tshortsPage;
    public ScreenShotMaker screenShotMaker;

    public Ellos(WebDriverWrapper driver) {
        web  = new WebElementsActions(driver);

        errorPage = new ErrorPage(driver);
        mainPage = new MainPage(driver);
        herrPage = new HerrPage(driver);
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        checkoutPage = new CheckoutPage(driver);
        successRegistrationPage = new SuccessRegistrationPage(driver);
        tshortsPage = new TshortsPage(driver);
        screenShotMaker = new ScreenShotMaker(driver);
    }

}
