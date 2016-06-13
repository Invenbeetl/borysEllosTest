package pages;

import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.NoSuchLocatorException;
import utils.WebElementsActions;

import java.io.IOException;

/**
 * Created by ViTaLES on 27.05.2016.
 */
public class ProductPage {

    WebElementsActions web;
    private static final Logger log = Logger.getLogger(LoginPage.class);

    public ProductPage(WebDriver driver) {
        web = new WebElementsActions(driver);

    }

    public void openStandartProduct() {
        //TODO
    }

    public void chooseColor() {

    }

    public void selectSize() {

    }

    public void addToBasket() {

    }

    public void swithcToCheckoutPage() {

    }

    public void checkButtonsPresence() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchLocatorException, IOException {
        if (isAddToBusketButtonPresent()&& isAddedToBusketGoodsButtonPresent() && isEllosMainButtonPresent()){
            log.info("All buttons are present");
        } else {
            log.error("is add to busket button present -" + isAddToBusketButtonPresent()+ "\n" + "is added to busket goods button present -" +
            isAddedToBusketGoodsButtonPresent()+ "\n" + "is Ellos main button present -" + isEllosMainButtonPresent());
            Assert.fail("is buy button present -" + isAddToBusketButtonPresent()+ "\n" + "is added to busket goods button present -" +
                    isAddedToBusketGoodsButtonPresent()+ "\n" + "is Ellos main button present -" + isEllosMainButtonPresent());

        }


    }

    private boolean isEllosMainButtonPresent() throws ClassNotFoundException, IOException, InstantiationException, NoSuchLocatorException, IllegalAccessException {
        return web.isElementPresent("EllosMainButton");
    }

    private boolean isAddedToBusketGoodsButtonPresent() throws ClassNotFoundException, IOException, InstantiationException, NoSuchLocatorException, IllegalAccessException {
        return web.isElementPresent("AddedToBusketGoodsButton");
    }

    private boolean isAddToBusketButtonPresent() throws ClassNotFoundException, IOException, InstantiationException, NoSuchLocatorException, IllegalAccessException {
        return web.getElementText("AddToBasketButton").equals("Lägg i varukorgen")?true:false;
    }

    public void checkProductAttributePresence() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchLocatorException, IOException {
        if (isColorDropdownListPresent() && isSizeDropdownListPresent() && isPricePresent() && isNamePresent()){
            log.info("All product attributes are present");
        } else {
            log.error("is color drop-down list present -"+isColorDropdownListPresent()+"\n"+
                    "is size drop-down list present -"+isSizeDropdownListPresent()+"\n"+
                    "is price present -"+isPricePresent()+"\n"+
                    "is product name present -"+isNamePresent());
            Assert.fail("is color drop-down list present -"+isColorDropdownListPresent()+"\n"+
                    "is size drop-down list present -"+isSizeDropdownListPresent()+"\n"+
                    "is price present -"+isPricePresent()+"\n"+
                    "is product name present -"+isNamePresent());

        }

    }

    private boolean isColorDropdownListPresent() throws ClassNotFoundException, IOException, InstantiationException, NoSuchLocatorException, IllegalAccessException {
        return web.isElementPresent("ColorDropdownList");
    }

    private boolean isSizeDropdownListPresent() throws ClassNotFoundException, IOException, InstantiationException, NoSuchLocatorException, IllegalAccessException {
        return web.isElementPresent("SizeDropdownList");
    }

    private boolean isPricePresent() throws ClassNotFoundException, IOException, InstantiationException, NoSuchLocatorException, IllegalAccessException {
        return web.isElementPresent("PriceText");
    }

    private boolean isNamePresent() throws ClassNotFoundException, IOException, InstantiationException, NoSuchLocatorException, IllegalAccessException {
        return web.isElementPresent("NameText");
    }

    public void checkColorDropdownlist() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchLocatorException, IOException {
        if (isFirstElementSelected()){
            log.info("First element of color DDL successfully selected");
        } else {
            log.error("is first element of color DDL selected - " + isFirstElementSelected());
            Assert.fail("is first element of color DDL selected - " + isFirstElementSelected());
        }
    }

    private boolean isFirstElementSelected() throws ClassNotFoundException, IOException, InstantiationException, NoSuchLocatorException, IllegalAccessException {
        web.selectFirstFromList("ColorDropdownList");
        return web.getElementText("ColorDDLtextContainer").equals(web.getElementText("FirstElementOfColorDDL"))?true:false;
    }

    public void switchToMainPage() throws ClassNotFoundException, IOException, InstantiationException, NoSuchLocatorException, IllegalAccessException {
        web.clickLink("MainPageLogoLink");
        log.info("Logo link is clicked");
    }

    public void checkAddToCartFunctionality() throws ClassNotFoundException, IOException, InstantiationException, NoSuchLocatorException, IllegalAccessException {
        if (isAddedToCartIsCorrect()){
            log.info("Product added to cart is correct");
        } else {
            log.error("Is added to cart product is correct - " + isAddedToCartIsCorrect());
        }
    }

    private boolean isAddedToCartIsCorrect() throws ClassNotFoundException, IOException, InstantiationException, NoSuchLocatorException, IllegalAccessException {
        web.selectFirstFromList("ColorDropdownList");
        web.selectFirstFromList("SizeDropdownList");
        web.clickButton("AddToBasketButton");


        String selectedSize = web.getElementText("SizeDDLtextContainer");
        String selectedPrice = web.getElementText("PriceText");

        web.clickElement("CartPanelLink");

        String cartSize = web.getElementText("ProductSizeOnMiniCart_SP");
        String cartPrice = web.getElementText("ProductPriceOnMiniCart_SP");

        if (!web.getElementText("ProductAmountOnMiniCart_SP").equals(null)
                && selectedSize.equals(cartSize)
                && selectedPrice.equals(cartPrice)
                && !web.getElementText("ProductNameOnMiniCart_SP").equals(null)){
            return true;
        } else {
            return false;
        }



    }
}
