package com.globant;

import utils.baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ShoppingCartPage;
import pages.LoginPage;
import utils.Listener;

@Listeners(Listener.class)
public class RemoveItemTest extends BaseTest {
    @DataProvider
    public Object[][] user() {
        return new Object[][]{
                {"standard_user","secret_sauce",3},

        };

    }

    @Test(dataProvider = "user", dataProviderClass = RemoveItemTest.class)
    public void secondTest(String username, String password, int item){
        LoginPage loginPage = loadFirstPage();
        HomePage homePage = new HomePage(loadFirstPage().getDriver());
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(loadFirstPage().getDriver());

try {
    //Checks if we are on the login page
    Assert.assertTrue(loginPage.isLoginPageTitle());
    if ("performance_glitch_user".equals(username)) {
        //Time for testing started
        log.info("Testing with performance_glitch_user. Expecting potential delays.");
        long startTime = System.currentTimeMillis();
        loginPage.login(username, password);

//Total time for this user to finish testing
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        log.info("Time for performance_glitch_user: " + duration + "ms");

    } else {

        //Time for testing started
        log.info("Testing started.");
        long startTime = System.currentTimeMillis();
        loginPage.login(username, password);



        //Total time for this user to finish testing
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        log.info("Time : " + duration + "ms");
    }
    //Checks if we were able to get to the homePage
    Assert.assertTrue(homePage.isHomePageTitleCorrect());

    //Methods to test
    homePage.selectItems(item);
    shoppingCartPage.removeSelected();


    Assert.assertTrue(shoppingCartPage.isCartEmpty(), "Cart is not empty");

}catch (AssertionError ex){
    log.info("Unable to login/remove items: " + ex.getMessage());
    Assert.fail("Test failed due to an error: " + ex.getMessage());

}catch (Exception ex) {
    log.info("Unexpected error occurred during the test." +"\n" + ex.getMessage());
    Assert.fail("Test failed due to an unexpected error: "+"\n" + ex.getMessage());
}


    }
}
