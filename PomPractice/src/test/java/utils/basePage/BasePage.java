package utils.basePage;

import utils.baseTest.BaseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.logging.Logger;


public class BasePage {
    protected WebDriver driver;
    protected  WebDriverWait wait;
    public Logger log = Logger.getLogger(String.valueOf(BaseTest.class));
    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public WebDriverWait getWait() {
        return this.wait;
    }
    public void waitToBeClickable(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitToBeVisible(WebElement element){
        getWait().until(ExpectedConditions.visibilityOf(element));

    }














}









