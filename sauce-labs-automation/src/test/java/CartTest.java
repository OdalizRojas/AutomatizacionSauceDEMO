import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import pages.Homepage;
import pages.LoginPage;
import utilities.DriverManager;
import pages.CartPage;

public class CartTest extends BaseTest{

    @Test
    public void VerifyNumberOfItemsInDetailOfProduct(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        Homepage homepage= new Homepage(DriverManager.getDriver().driver);
        homepage.clickOnAddSauceLabsBackPackToCartButton();
        CartPage cartPage = new CartPage(DriverManager.getDriver().driver);
        Assert.assertTrue(cartPage.priceProductDisplayed());
    }

    @Test @Ignore
    public void VerifyNumberOfItemsForProduct(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        Homepage homepage= new Homepage(DriverManager.getDriver().driver);
        homepage.clickOnAddSauceLabsBackPackToCartButton();
        CartPage cartPage = new CartPage(DriverManager.getDriver().driver);

    }


}
