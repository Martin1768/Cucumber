package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class CommonMethods extends PageInitializer {
    public static WebDriver driver;

    public static void openBrowser() {
        String browser = ConfigReader.read("browser");
        switch (browser) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                // options.addArguments("--headless"); // nezobrazí okno prohlížeče
                options.addArguments("--disable-gpu"); // Volitelné pro lepší výkon
                options.addArguments("--no-sandbox"); // Rychlejší start
                options.addArguments("--disable-dev-shm-usage"); // Lepší práce s pamětí
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser name: " + browser);
        }

        driver.manage().window().maximize();
        driver.get(ConfigReader.read("hrms.url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        initPageObjects();
    }

    public static void closeBrowser() {
        if (driver != null) {
            driver.close();
        }
    }

    //    make a method for declaration of explicit wait
    public static WebDriverWait getWait() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait;
    }

    public static void waitForElementToBeClickable(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForElementToBeVisible(WebElement element) {
        getWait().until(ExpectedConditions.visibilityOf(element));
    }

    public static void clickOnElement(WebElement element) {
        waitForElementToBeClickable(element);
        element.click();
    }

    public static void sendText(String text, WebElement element) {
        waitForElementToBeVisible(element);
        element.clear();
        element.sendKeys(text);
    }

    public static void selectFromDropDown(WebElement element, int index) {
        Select sel = new Select(element);
        sel.selectByIndex(index);
    }

    public static void selectFromDropDown(WebElement element, String value) {
        Select sel = new Select(element);
        sel.selectByValue(value);
    }

    public static void selectFromDropDown(String text, WebElement element) {
        Select sel = new Select(element);
        sel.selectByVisibleText(text);
    }

    public static byte[] takeScreenshot(String fileName) {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        byte[] screenshotData = screenshot.getScreenshotAs(OutputType.BYTES);

        File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile,
                    new File(Constants.SCREENSHOTS_PATH + fileName +
                            getTimeStamp() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshotData;
    }

    public static String getTimeStamp() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        return now.format(formatter);
    }
    public static String getTimeStamp(String pattern){

        Date date = new Date();
        //yyyy-MM-dd-hh-mm-ss
        //dd-MM-yyyy-mm-hh-ss
        //to get the date in my acceptable format, i need to format it
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

        return sdf.format(date);
    }
}
