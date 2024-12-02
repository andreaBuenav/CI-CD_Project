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
public class LogoutTest extends BaseTest {

    @DataProvider
    public Object[][] user() {
        //Gives data providers for each test, giving a new user for each test everytime its executed
        return new Object[][]{
                {"standard_user","secret_sauce",4},
                {"locked_out_user","secret_sauce",2},
                {"problem_user","secret_sauce",3},
                {"performance_glitch_user", "secret_sauce",1},
                {"error_user","secret_sauce",2},
                {"visual_user","secret_sauce",1}
        };

    }
    @Test(dataProvider = "user", dataProviderClass = LogoutTest.class)
    public void thirdTest(String username, String password, int item){
        LoginPage loginPage = loadFirstPage();
        HomePage home = new HomePage(loadFirstPage().getDriver());
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
            Assert.assertTrue(home.isHomePageTitleCorrect());

            //Methods to test
            home.selectItems(item);
            home.logOut();
            loginPage.correctPageLogin();

 //Checks  again if we are on the login page
  Assert.assertTrue(loginPage.isLoginPageTitle());

}catch (AssertionError ex){
            //Error message for when the test is unable to be done
            log.info("Error: " + ex.getMessage());
            Assert.fail("Test failed unable to login/logout: " + ex.getMessage());

 }catch (Exception ex) {
            log.info("Unexpected error occurred during the test.");
            Assert.fail("Test failed due to an unexpected error: " + ex.getMessage());
        }

    }
}
