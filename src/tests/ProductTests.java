package tests;

import org.apache.log4j.Logger;
import org.junit.Assert;
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
public class ProductTests extends Runner {
    //Product page tests
    private static final Logger log = Logger.getLogger(RegistrationTests.class);
    String baseUrl = "http://www.ellos.se/";

    @Test
    public void buttonsPresence () throws ClassNotFoundException, NoSuchLocatorException, InstantiationException, IllegalAccessException, IOException {
        web.openPage(baseUrl);
        web.refreshPage();

        MainPage mainPage = new MainPage(driver);
        mainPage.moveToHerrGoodsPage();

        HerrPage herrPage = new HerrPage(driver);
        herrPage.moveToTshortsSection();

        TshortsPage tshortsPage = new TshortsPage(driver);
        tshortsPage.moveToPDP();

        ProductPage productPage = new ProductPage(driver);
        productPage.checkButtonsPresence();
        productPage.checkProductAttributePresence();


    }


}
