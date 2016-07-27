package pages;

import org.apache.log4j.Logger;
import org.testng.Assert;
import utils.ClassNameUtil;
import utils.WebDriverWrapper;

/**
 * Created by borys on 11.07.2016.
 */
public class BasketPage extends Page {
    public BasketPage(WebDriverWrapper dr) {
        super(dr);
    }
    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    //    Check Direct Order form presence
    public void checkDOFormPresence() {
        if (isArticulFieldPresent() &&
                isSizeFieldPresent() &&
                isAmountFieldPresent() &&
                isConfirmDOButtonPresent()){
            log.info("All elements of direct form are present");
        } else{
            log.error("Presence of articul input field" + isArticulFieldPresent()+
                    "Presence of size input field " + isSizeFieldPresent()+
                    "Presence of amount input field " + isAmountFieldPresent()+
                    "Presence of confirm direct order button "+ isConfirmDOButtonPresent());
            Assert.fail("Presence of articul input field" + isArticulFieldPresent()+
                    "Presence of size input field " + isSizeFieldPresent()+
                    "Presence of amount input field " + isAmountFieldPresent()+
                    "Presence of confirm direct order button "+ isConfirmDOButtonPresent());
        }
    }

    private boolean isArticulFieldPresent() {
        return web.isElementPresent("ArticulInputField");
    }

    private boolean isSizeFieldPresent() {
        return web.isElementPresent("SizeInputField");
    }

    private boolean isAmountFieldPresent() {
        return web.isElementPresent("QuantityInputField");
    }

    private boolean isConfirmDOButtonPresent() {
        return web.isElementPresent("ConfirmDirectOrderButton");
    }



    public void checkProductDetailsPresence() {
        Assert.assertTrue(isImagePresent()&&
                isDetailsPresent()&&
                isArticulPresent()&&
                isPricePresent()&&
                isAmountPresent()&&
                isDeleteButtonPresent()&&
                isSummPresent(), "Some product detail is absent");

    }

    private boolean isImagePresent() { return web.isElementPresent("LastProductSmallImage");    }

    private boolean isDetailsPresent() {
        if (web.isElementPresent("LastProductName")&&
                web.isElementPresent("LastProductColor")&&
                web.isElementPresent("LastProductSize")) return true;
        else return false;
    }

    private boolean isArticulPresent() {return web.isElementPresent("LastProductArticul");    }

    private boolean isPricePresent() {return web.isElementPresent("LastProductPrice");    }

    private boolean isAmountPresent() {
        if (web.isElementPresent("LastProductAmountValue")&&
                web.isElementPresent("LastProductAmountButton")) return true;
        else return false;
    }

    private boolean isDeleteButtonPresent() { return web.isElementPresent("LastProductDeleteButton");    }

    private boolean isSummPresent() { return web.isElementPresent("LastProductSumm");    }


    public void checkTotalBuySectionPresence() {
        Assert.assertTrue(isTotalsummPresent()&&
                isBuyButtonPresent(), "Total amount or Buy button is absent");
    }

    private boolean isTotalsummPresent() {return web.isElementPresent("TotalSumm");    }

    private boolean isBuyButtonPresent() {return web.isElementPresent("BuyButton_BasketPage");    }
}
