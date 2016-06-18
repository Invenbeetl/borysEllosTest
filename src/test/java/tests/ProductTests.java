package tests;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pages.HerrPage;
import pages.MainPage;
import pages.ProductPage;
import pages.TshortsPage;
import utils.NoSuchLocatorException;

import java.io.IOException;

/**
 * Created by borys on 10.06.2016.
 */
public class ProductTests extends Fixture {
    //Product page tests
    private static final Logger log = Logger.getLogger(RegistrationTests.class);

    @Test
    public void buttonsPresence() {
        ellos.productPage.openPage();
        ellos.web.refreshPage();
        ellos.mainPage.moveToHerrGoodsPage();

        ellos.herrPage.moveToTshortsSection();
        ellos.tshortsPage.moveToPDP();
        ellos.productPage.checkButtonsPresence();
        ellos.productPage.switchToMainPage();
    }

    @Test
    public void attributesPresence() {
        ellos.productPage.openPage();
        ellos.web.refreshPage();
        ellos.mainPage.moveToHerrGoodsPage();

        ellos.herrPage.moveToTshortsSection();
        ellos.tshortsPage.moveToPDP();
        ellos.productPage.checkProductAttributePresence();
        ellos.productPage.switchToMainPage();

    }

    @Test
    public void colorDDLfunctionality() {
        ellos.productPage.openPage();
        ellos.web.refreshPage();
        ellos.mainPage.moveToHerrGoodsPage();

        ellos.herrPage.moveToTshortsSection();
        ellos.tshortsPage.moveToPDP();
        ellos.productPage.checkColorDropdownlist();
        ellos.productPage.switchToMainPage();

    }

    @Test
    public void sizeDDLFunctionality() {
        ellos.productPage.openPage();
        ellos.web.refreshPage();

        ellos.mainPage.moveToHerrGoodsPage();
        ellos.herrPage.moveToTshortsSection();
        ellos.tshortsPage.moveToPDP();
        ellos.productPage.checkSizeDropdownlist();
        ellos.productPage.switchToMainPage();

    }

    @Test
    public void addToCartFunctionality() {
        ellos.productPage.openPage();
        ellos.web.refreshPage();

        ellos.mainPage.moveToHerrGoodsPage();
        ellos.herrPage.moveToTshortsSection();
        ellos.tshortsPage.moveToPDP();
        ellos.productPage.checkAddToCartFunctionality();
        ellos.productPage.switchToMainPage();

    }

    @Test
    public void checkProductImage() {
        ellos.productPage.openPage();
        ellos.web.refreshPage();

        ellos.mainPage.moveToHerrGoodsPage();
        ellos.tshortsPage.moveToPDP();
        ellos.productPage.checkProductImage();
        ellos.productPage.switchToMainPage();

    }





}
