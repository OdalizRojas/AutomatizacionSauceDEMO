package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    WebDriver driver;

    @FindBy(className = "inventory_item_price")
    WebElement priceProduct;

    public CartPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public boolean priceProductDisplayed() {
        boolean priceProductIsDisplayed = priceProduct.isDisplayed();
        return priceProductIsDisplayed;
    }

}