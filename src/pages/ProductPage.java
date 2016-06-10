package pages;

import junit.framework.Assert;
import org.eclipse.jetty.util.log.LoggerLog;
import org.openqa.selenium.WebDriver;
import utils.NoSuchLocatorException;
import utils.WebElementsActions;

import java.io.IOException;

/**
 * Created by ViTaLES on 27.05.2016.
 */
public class ProductPage {

    WebElementsActions web;
    LoggerLog log = new LoggerLog(ProductPage.class);

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
            log.warn("is add to busket button present -" + isAddToBusketButtonPresent()+ "\n" + "is added to busket goods button present -" +
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
        return web.getElementText("AddToBusketButton").equals("Lägg i varukorgen")?true:false;
    }

    public void checkProductAttributePresence() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchLocatorException, IOException {
        if (isColorDropdownListPresent() && isSizeDropdownListPresent() && isPricePresent() && isNamePresent()){
            log.info("All product attributes are present");
        } else {
            log.warn("is color drop-down list present -"+isColorDropdownListPresent()+"\n"+
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
}
