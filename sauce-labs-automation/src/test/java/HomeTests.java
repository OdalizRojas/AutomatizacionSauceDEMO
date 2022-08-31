import com.google.common.collect.Ordering;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Homepage;
import pages.LoginPage;
import utilities.DriverManager;

import java.time.Duration;
import java.util.List;

public class HomeTests extends BaseTest {

    //Test: Verificar que una vez agregado un elemento al carrito, este tenga un uno
    @Test @Ignore
    public void loginSuccessTest(){
        WebElement userNameTextBox = new WebDriverWait(DriverManager.getDriver().driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("user-name")));
    }


    @Test @Ignore
    public void verifyCartButtonNumberIsAdded(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        Homepage homepage= new Homepage(DriverManager.getDriver().driver);
        homepage.clickOnAddSauceLabsBackPackToCartButton();
        Assert.assertEquals("1",homepage.getCartIconText());
        homepage.clickOnRemoveSauceLabsBackPackToCartButton();
    }
    //Test: Verificar que una vez agregado un elemento al carrito y luego borrado el carrito no teng nada
    @Test @Ignore
    public void verifyCartButtonNumberIsBlankWhereThereIsNotProductsInTheCart(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        Homepage homepage= new Homepage(DriverManager.getDriver().driver);
        homepage.clickOnAddSauceLabsBackPackToCartButton();
        homepage.clickOnRemoveSauceLabsBackPackToCartButton();
        Assert.assertEquals( "", homepage.getCartIconText());
    }


    @Test @Ignore
    public void orderingFromZtoA(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        Homepage homepage= new Homepage(DriverManager.getDriver().driver);
        homepage.selectObject("Name (Z to A)");
        List<String> items = homepage.getAllItems();
        boolean itemsAreSorted = Ordering.natural().reverse().isOrdered(items);
    }

    @Test @Ignore
    public void orderingFromAtoZ(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        Homepage homepage= new Homepage(DriverManager.getDriver().driver);
        homepage.selectObject("Name (A to Z)");
        List<String> items = homepage.getAllItems();
        boolean itemsAreSorted = Ordering.natural().isOrdered(items);
        Assert.assertTrue(itemsAreSorted);
    }

    @Test @Ignore
    public void verifyLowToHighPriceItems() {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        Homepage homepage= new Homepage(DriverManager.getDriver().driver);
        homepage.selectProductFilter("Price (low to high)");
        List<Double> prices = homepage.getAllItemPrices();
        boolean pricesAreSorted = Ordering.natural().isOrdered(prices);
        Assert.assertTrue(pricesAreSorted);
    }

    @Test
    public void verifyHighToLowPriceItems() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        Homepage homepage= new Homepage(DriverManager.getDriver().driver);
        homepage.selectProductFilter("Price (high to low)");
        List<Double> prices = homepage.getAllItemPrices();
        boolean pricesAreSorted = Ordering.natural().reverse().isOrdered(prices);
        Assert.assertTrue(pricesAreSorted);
        Thread.sleep(5000);
    }
}