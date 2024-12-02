package utils.baseTest;

import io.qameta.allure.Step;
import mainDriver.MainDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.LoginPage;

import java.util.logging.Logger;

public class BaseTest {
   public Logger log = Logger.getLogger(String.valueOf(BaseTest.class));

//Method to open the browser and go to the page we want to test
    MainDriver driver;
    @BeforeMethod(alwaysRun = true)
    @Step("Opening the Website")
    @Parameters({"url"})
    public void beforeMethod(String url){
        driver = new MainDriver();
        driver.getDriver().manage().window().maximize();
        navigateTo(url);
    }

    public void navigateTo(String url){
        driver.getDriver().get(url);
    }




    //loads all the pages

    public LoginPage loadFirstPage(){
        return new LoginPage(driver.getDriver());
    }



    @AfterMethod
    public void afterMethod(){
        driver.getDriver().close();
    }


}
