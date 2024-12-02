package com.globant;


import utils.baseTest.BaseTest;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.HomePage;
import pages.ShoppingCartPage;
import pages.LoginPage;
import utils.Listener;


/**
 * Unit test for simple App.
 */
@Listeners(Listener.class)
public class PurchaseItemsTest extends BaseTest {

    @DataProvider
    public Object[][] user(){
        //Main data providers to make each test, and each different test has a different
        //user to make a new test every time the program is executed
        return new Object[][]{
                {"standard_user","secret_sauce",1,"Thank you for your order!"},
                {"locked_out_user","secret_sauce",1,"Thank you for your order!"},
                {"problem_user","secret_sauce",1,"Thank you for your order!"},
                {"performance_glitch_user", "secret_sauce",1,"Thank you for your order!"},
                {"error_user","secret_sauce",1,"Thank you for your order!"},
                {"visual_user","secret_sauce",1,"Thank you for your order!"},
                {"user_user", "secret_sauce", 3, "than you for your order"}
        };

    }
    //Select a random item and purchase it

    @Test(dataProvider = "user", dataProviderClass = PurchaseItemsTest.class)
public void firstTest(String username,String password,int item,String title){
        //All page loads
        LoginPage login = loadFirstPage();
        HomePage home = new HomePage(loadFirstPage().getDriver());
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(loadFirstPage().getDriver());
        CheckoutPage checkout = new CheckoutPage(loadFirstPage().getDriver());
try {

    //Checks if we are on the login page
    Assert.assertTrue(login.isLoginPageTitle());

    //Methods to test
    if ("performance_glitch_user".equals(username)) {
        //Time for testing started
        log.info("Testing with performance_glitch_user. Expecting potential delays.");
        long startTime = System.currentTimeMillis();
        login.login(username, password);

//Total time for this user to finish testing
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        log.info("Time for performance_glitch_user: " + duration + "ms");

    } else {

        //Time for testing started
        log.info("Testing started.");
        long startTime = System.currentTimeMillis();
        login.login(username, password);

        //Total time for this user to finish testing
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        log.info("Time : " + duration + "ms");
    }

    //Checks if we were able to get to the homePage
    Assert.assertTrue(home.isHomePageTitleCorrect());

    //Methods to test
    home.selectItems(item);
    shoppingCartPage.purchaseSelected();
    checkout.checkout();

    //Checks if we successfully purchased an item
    Assert.assertTrue(checkout.isTitleCorrect(title));



}catch (AssertionError ex){
    log.info("Unable to login/purchase product: " + ex.getMessage());
    Assert.fail("Test failed due to an unsuccessful purchase: " +"\n" + ex.getMessage());

}catch (Exception ex) {
    log.info("Unexpected error occurred during the test " +"\n" + ex.getMessage());
    Assert.fail("Test failed due to an unexpected error: " +"\n"+ ex.getMessage());
}


    }


}
