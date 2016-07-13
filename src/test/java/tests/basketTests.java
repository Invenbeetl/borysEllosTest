package tests;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ClassNameUtil;

/**
 * Created by borys on 10.07.2016.
 */
public class basketTests extends Fixture {
    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    @BeforeClass
    private void precondition(){
        ellos.productPage.openPage();
        ellos.web.refreshPage();

        ellos.mainPage.moveToHerrGoodsPage();
        ellos.herrPage.moveToTshortsSection();
        ellos.tshortsPage.moveToPDP();
        ellos.productPage.chooseColor();
        ellos.productPage.selectSize();
        ellos.productPage.addToBasket();
        ellos.productPage.goToBasketPage();

    }

    @Test
    public void directOrderFormPresence(){
        ellos.basketPage.checkDOFormPresence();
    }

}
