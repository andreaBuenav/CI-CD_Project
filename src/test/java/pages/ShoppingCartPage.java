package pages;

import utils.basePage.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCartPage extends BasePage {
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }


    //Buttons

    @FindBy(id = "shopping_cart_container")
    private WebElement shoppingCart;
    @FindBy(id = "continue-shopping")
    private WebElement back;
    @FindBy(id = "checkout")
    private WebElement checkoutButton;
    @FindBy(id = "react-burger-menu-btn")
    private WebElement menu;
    @FindBy(id = "logout_sidebar_link")
    private WebElement logout;
    @FindBy(css = "error-message-container error")
    private WebElement errorMessage;

    public CheckoutPage purchaseSelected()
    {
        if(shoppingCart.isEnabled() && shoppingCart.isDisplayed()) {
            waitToBeClickable(shoppingCart);
            shoppingCart.click();
            waitToBeClickable(checkoutButton);
            checkoutButton.click();
            return new CheckoutPage(driver);
        }else{
                throw new ElementClickInterceptedException(" Checkout Button unable to be pressed");
            }
    }



    public void removeSelected()
    {
        if(shoppingCart.isEnabled()) {
            waitToBeClickable(shoppingCart);
            shoppingCart.click();
            remove();
        }else {
            throw new ElementNotInteractableException("Cannot click this button");
        }
    }

    //Removes all selected items
    public void remove() {
        List<WebElement> removeButtons = driver.findElements(By.cssSelector(".btn.btn_secondary.btn_small.cart_button"));

        for (WebElement removeButton : removeButtons) {
            if (removeButton.isDisplayed() && removeButton.isEnabled() && removeButton.getText().equals("Remove")) {
                waitToBeClickable(removeButton);
                removeButton.click();
            }

        }
    }




    public boolean isCartEmpty(){
        List<WebElement> removeButtons = driver.findElements(By.cssSelector(".btn.btn_secondary.btn_small.cart_button"));
        return removeButtons.isEmpty();
    }






}
