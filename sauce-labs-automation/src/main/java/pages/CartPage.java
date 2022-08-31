package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CartPage {

    WebDriver driver;

    @FindBy(className = "inventory_item_price")
    WebElement priceProduct;

    @FindBy(xpath = "//*[@id=\"item_5_title_link\"]/div")
    WebElement textJacket;

    @FindBy(xpath = "//*[@id=\"item_0_title_link\"]/div")
    WebElement textBike;

    @FindBy(xpath = "//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/div")
    WebElement bikePrice;

    @FindBy(xpath = "//*[@id=\"cart_contents_container\"]/div/div[1]/div[4]/div[2]/div[2]/div")
    WebElement jacketPrice;

    @FindBy(className = "shopping_cart_badge")
    WebElement cartIconNumber;

    @FindBy(id = "remove-sauce-labs-bike-light")
    WebElement removeButtonBike;

    @FindBy(id = "remove-sauce-labs-fleece-jacket")
    WebElement removeButtonJacket;

    @FindBy(className = "inventory_item_price")
    List<WebElement> itemPrices;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean priceProductDisplayed() {
        boolean priceProductIsDisplayed = priceProduct.isDisplayed();
        return priceProductIsDisplayed;
    }

    public boolean jacketTextIsDisplayed() {
        boolean jacketLogoIsDisplayed = textJacket.isDisplayed();
        return jacketLogoIsDisplayed;
    }

    public boolean bikeTextIsDisplayed() {
        boolean bikeLogoIsDisplayed = textBike.isDisplayed();
        return bikeLogoIsDisplayed;
    }

    public Double getBikePrice() {
        Double bikePrice = Double.parseDouble(textBike.getText());
        return bikePrice;
    }

    public Double getJacketPrice() {
        System.out.println(jacketPrice.getText());
        Double jacket = Double.parseDouble(jacketPrice.getText());
        return jacket;
    }

    public String getCartNumberText() {
        String cartNumberText = cartIconNumber.getText();
        return cartNumberText;
    }

    public void clickOnRemoveBikeToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(removeButtonBike));
        removeButtonBike.click();
    }

    public void clickOnRemoveJacketToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(removeButtonJacket));
        removeButtonJacket.click();
    }

    public List<Double> getItemPrices() {
        List<Double> prices = new ArrayList<>();
        for (WebElement itemPrice : itemPrices) {
            String itemPriceText = itemPrice.getText();
            StringBuilder sb = new StringBuilder(itemPriceText);
            sb.deleteCharAt(3);
            System.out.println(sb.toString());
            prices.add(Double.parseDouble(sb.toString()));
        }
        return prices;
    }

}
