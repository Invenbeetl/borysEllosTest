package tests;

import org.openqa.selenium.WebDriver;
import utils.WebElementsActions;

/**
 * Created by ViTaLES on 06.06.2016.
 */
public class Fixture {

    WebDriver driver = Runner.driver;
    WebElementsActions web = new WebElementsActions(driver);
    String baseUrl = "http://www.ellos.se/";

}
