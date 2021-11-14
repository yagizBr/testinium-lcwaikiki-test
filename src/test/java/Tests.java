import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class Tests extends BaseTest{


    LoginPage loginPage;
    HomePage homePage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;

    @Test
    @Order(1)
    public void isOnMainPage() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.confirmCookieDialog();
        Assertions.assertTrue(homePage.isOnHomePage(),"Anasayfa acilamadi!");

    }
    @Test
    @Order(2)
    public void loginAccount(){
        loginPage = new LoginPage(driver);
        loginPage.login();
        Assertions.assertTrue(loginPage.loggedControl(),"Oturum acilamadi.");
    }

    @Test
    @Order(3)
    public void searchProducts(){
        homePage.searchBar().search("pantolon");
//        Assertions.assertTrue(pantolonkotrolet,"urnuler bulunamadi");
    }

    @Test
    @Order(4)
    public void scrollProductsPage() throws InterruptedException {
        productsPage = new ProductsPage(driver);
        productsPage.scrollToBottom();
    }

    @Test
    @Order(5)
    public void showMoreProducts(){
        productsPage.clickMoreButton();
    }

    @Test
    @Order(6)
    public void chooseProduct(){
        productsPage.randomProduct();
    }

    @Test
    @Order(8)
    public void addToCartandCheck() throws InterruptedException {
        productDetailPage = new ProductDetailPage(driver);
        cartPage = new CartPage(driver);
        productDetailPage.addCart();
        Assertions.assertTrue(cartPage.checkPrice(),"Ürün sayfası ve sepet fiyatları farklı");
        Assertions.assertTrue(cartPage.checkCart(),"Sepete Eklenemedi");//iki farkli testte yapilsa daha dogru olur gibi
    }

    @Test
    @Order(9)
    public void checkQuantityIncreasement() throws InterruptedException {
        Assertions.assertTrue(cartPage.increaseQuantityandCheck(),"Miktar arttırılamıyor!");
    }

    @Test
    @Order(10)
    public void deleteItemFromCartandCheck() throws InterruptedException { //try-catch gerekli mi??

        Assertions.assertTrue(cartPage.deleteItem(),"Ürün sepetten silinemedi.");

    }



}
