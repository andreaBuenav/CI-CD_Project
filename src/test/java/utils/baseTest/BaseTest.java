package utils.baseTest;

import mainDriver.MainDriver;
import org.testng.annotations.*;
import pages.LoginPage;

import java.util.logging.Logger;

public class BaseTest {
    public Logger log = Logger.getLogger(String.valueOf(BaseTest.class));
    MainDriver driver;

    @BeforeMethod(alwaysRun = true)
    @Parameters("url")

    public void beforeMethod(String url) {
        driver = new MainDriver();
        driver.getDriver().manage().window().maximize();
        navigateTo(url);
    }

    public void navigateTo(String url) {
        driver.getDriver().get(url);
    }

    public LoginPage loadFirstPage() {
        return new LoginPage(driver.getDriver());
    }

    @AfterMethod
    public void afterMethod() {
        driver.getDriver().close();
    }
}
