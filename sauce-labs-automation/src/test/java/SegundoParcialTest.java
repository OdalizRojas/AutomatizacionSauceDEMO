import org.junit.Assert;
import org.junit.Test;
import pages.CartPage;
import pages.Homepage;
import pages.LoginPage;
import utilities.DriverManager;

public class SegundoParcialTest extends BaseTest{

    @Test
    public void VerifyFunctionsOfSauce(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        Homepage homepage= new Homepage(DriverManager.getDriver().driver);
        homepage.clickOnAddBikeLightToCartButton();
        homepage.clickOnAddJacketToCartButton();

        //Verificar que los elementos esten en la pagina del carrito
        CartPage cartPage = new CartPage(DriverManager.getDriver().driver);
        Assert.assertTrue(cartPage.jacketTextIsDisplayed());
        Assert.assertTrue(cartPage.bikeTextIsDisplayed());

        //Verificar los precios
        Assert.assertEquals("49.99",cartPage.getJacketPrice());
        //Assert.assertEquals("$9.99",cartPage.getBikePrice());

        //Verificar que el numero de elementos en el carrito sea 2
        Assert.assertEquals("2",cartPage.getCartNumberText());

        //Remover los items agregados
        cartPage.clickOnRemoveBikeToCart();
        cartPage.clickOnRemoveJacketToCart();

        //Verificar que el numero de elementos en el carrito sea vacio
        Assert.assertEquals("",cartPage.getCartNumberText());


    }

}
