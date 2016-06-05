package utils;

import org.apache.jasper.tagplugins.jstl.core.Catch;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.internal.Executable;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by ViTaLES on 30.05.2016.
 */
/*
 *  That class provides static methods for getting values from Config and UI mapping files
 *  UIMapping.properties
 */
public class ExtractDataFromFile {
    public static String uiMappingFile="src/UIMapping.properties";
    private static final Logger log = Logger.getLogger(ExtractDataFromFile.class);

    /*
     *  Return value from .properties file
     */
    public static String getValueFromFile(String key, String fileName) throws IOException {
        Properties p = new Properties();
        // Create stream for reading from file
        FileInputStream cfg = new FileInputStream(fileName);
        // Load Properties from input stream
        p.load(cfg);
        cfg.close();

        // Return value for the property
        return(p.getProperty(key));
    }


    /*
     *  Return By class with finding method and target for WebElement from UI mapping file
     */


    public static By ui(String key) throws IOException, NoSuchLocatorException {
        // Get WebElement's locator from UI mapping file and divide it to finding method and target
        String[] partsOfLocator = getValueFromFile(key, uiMappingFile).split("\"");
        String findMethod = partsOfLocator[0];
        String target = partsOfLocator[1];

        log.info("after parsing:");
        log.info(partsOfLocator[0]);
        log.info(partsOfLocator[1]);
        log.info(findMethod);
        log.info(target);


        switch (findMethod) {
            case "xpath":
                return By.xpath(target);
            case "cssSelector":
                return By.cssSelector(target);
            case "name":
                return By.name(target);
            case "class":
                return By.className(target);
            default:
                throw new NoSuchLocatorException("Locator not found");
        }

    }
}