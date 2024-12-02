package pages;

import utils.basePage.BasePage;
import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;


public class CheckoutPage extends BasePage {

    Faker faker = new Faker();
    private String name = faker.name().firstName();
    private String lastName= faker.name().lastName();
    private String zip = faker.number().digits(4);

    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.name = name;
        this.lastName = lastName;
        this.zip = zip;
    }



    //Buttons

    @FindBy(id = "continue")
    private WebElement continueButton;
    @FindBy(id = "cancel")
    private WebElement backButton;
    @FindBy(id= "finish")
    private WebElement finishButton;
    @FindBy(id = "back-to-products")
    private WebElement backToHomeButton;
    @FindBy(id = "react-burger-menu-btn")
    private WebElement menu;
    @FindBy(id = "logout_sidebar_link")
    private WebElement logout;






    //Inputs
    @FindBy(id = "first-name")
    private WebElement nameInput;
    @FindBy(id = "last-name")
    private WebElement lastNameInput;
    @FindBy(id = "postal-code")
    private WebElement zipInput;



    //Page title
    @FindBy(className = "complete-header")
    private WebElement pageTitle;


    public void checkout(){
        try {
            nameInput.sendKeys(name);
            lastNameInput.sendKeys(lastName);
            zipInput.sendKeys(zip);
            waitToBeVisible(continueButton);
            waitToBeClickable(continueButton);
            continueButton.click();
            waitToBeVisible(finishButton);
            finishButton.isEnabled();
            finishButton.click();
        }catch (Exception ex){
            log.info("Error purchase interrupted due to a button or field disabled " + ex.getMessage());
        }

    }


    public boolean isTitleCorrect(String title){
        waitToBeVisible(pageTitle);
        return pageTitle.isDisplayed() && pageTitle.getText().equals(title);
    }


}
