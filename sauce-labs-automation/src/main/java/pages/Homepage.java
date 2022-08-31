package pages;
import com.google.common.collect.Ordering;
import io.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Homepage {
    WebDriver driver;

    @FindBy(className = "app_logo")
    WebElement appLogo;

    @FindBy(className = "shopping_cart_link")
    WebElement cartIcon;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement sauceLabsBackPackAddToCartButton;

    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement sauceLabsBackPackRemoveToCartButton;

    @FindBy(className = "product_sort_container")
    WebElement sauceLabSortDropDow;

    @FindBy(className = "inventory_item_name")
    List<WebElement> products;

    @FindBy(className = "product_sort_container")
    WebElement productFilterDropDown;

    @FindBy(className = "inventory_item_price")
    List<WebElement> itemPricesLebel;

    // ------- Boton "ADD TO CART" de Sauce Labs Bike Light

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement productBikeLight;

    // ------- Boton "ADD TO CART" de Sauce Labs Fleece Jacket

    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    WebElement productJacket;


    public Homepage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public boolean appLogoIsDisplayed() {
        boolean appLogoIsDisplayed = appLogo.isDisplayed();
        return appLogoIsDisplayed;
    }

    public String getCartIconText(){
        String cartatext = cartIcon.getText();
        return cartatext;
    }

    public void clickOnAddSauceLabsBackPackToCartButton(){
        sauceLabsBackPackAddToCartButton.click();
    }

    public void clickOnRemoveSauceLabsBackPackToCartButton(){
        sauceLabsBackPackRemoveToCartButton.click();
    }

    public void clickOnAddBikeLightToCartButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(productBikeLight));
        productBikeLight.click();
    }

    public void clickOnAddJacketToCartButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(productJacket));
        productJacket.click();
    }

    public void selectObject(String element){
        Select select = new Select(sauceLabSortDropDow);
        select.selectByVisibleText(element);
    }

    public List<String> getAllItems(){
        List<String> items = new ArrayList<>();
        for(WebElement item: products){
            String itemText = item.getText();
            StringBuilder sb = new StringBuilder(itemText);
            sb.deleteCharAt(0);
            items.add(sb.toString());
        }
        return items;
    }
    public void selectProductFilter(String element){
        Select selectObject = new Select(productFilterDropDown);
        selectObject.selectByVisibleText(element);
    }
    public List<Double> getAllItemPrices(){
        List<Double> prices = new ArrayList<>();
        for(WebElement itemPrice: itemPricesLebel){
            String itemPriceText = itemPrice.getText();
            StringBuilder sb = new StringBuilder(itemPriceText);
            sb.deleteCharAt(0);
            prices.add(Double.parseDouble(sb.toString()));
        }
        return prices;
    }
}
