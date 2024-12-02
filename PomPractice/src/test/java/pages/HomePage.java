package pages;

import utils.basePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }


    //To know if we are on the home page...
    @FindBy(id = "inventory_container")
    private WebElement inventory;
//Buttons
    @FindBy(id = "add-to-cart")
   private WebElement addToCart;
    @FindBy(id = "back-to-products")
    private WebElement back;
    @FindBy(id = "react-burger-menu-btn")
    private WebElement menu;
    @FindBy(id = "logout_sidebar_link")
    private WebElement logout;




    //Method to select random items
    public ShoppingCartPage selectItems(int itemsToSelect) {
        //Starts a list to save all the items the users want to purchase
        Set<Integer> selectedItems = new HashSet<>();
        //Selects a random item from the home page
        Random random = new Random();
        while (selectedItems.size() < itemsToSelect) {
            int randomIndex = random.nextInt(6);
            if (selectedItems.add(randomIndex)) {
                String index = Integer.toString(randomIndex);
                String itemId = "item_" + index + "_title_link";
                WebElement item = driver.findElement(By.id(itemId));
                waitToBeClickable(item);
                if (item.isDisplayed() && item.isEnabled()) {
                    item.click();
                    addToCart.click();
                    back.click();
                }else {
                    throw new NoSuchElementException(" Item not available");
                }
            }

        }

        return new ShoppingCartPage(driver);
    }

    //Method to know if we are on the HomePage
    public boolean isHomePageTitleCorrect(){
        waitToBeVisible(inventory);
        return inventory.isDisplayed();
    }
    public LoginPage logOut(){
        waitToBeVisible(menu);
        menu.click();
        waitToBeVisible(logout);
        waitToBeClickable(logout);
        logout.click();
        return new LoginPage(driver);
    }


    }



