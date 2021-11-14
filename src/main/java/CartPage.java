import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.sql.SQLOutput;

public class CartPage extends BasePage{

    By priceRegularLocator = new By.ByCssSelector("span.price-regular:nth-child(2)");
    By basketDiscountLocator = By.className("basket-discount");
    By goToCartButtonLocator = By.id("spanCart");
    By cartRegularLocator = new By.ByCssSelector("span.rd-cart-item-old-price");
    By cartBasketLocator = new By.ByCssSelector(".rd-cart-item-price.mb-15");
    By basketItemImageLocator = new By.ByCssSelector(".rd-cart-item-image");
    By increaseQuantityButtonLocator = new By.ByCssSelector(".oq-up.plus");
    By quantityInputLocator = new By.ByCssSelector(".item-quantity-input.ignored");
    By cartDeleteButtonLocator = new By.ByCssSelector("a[title='Sil']");
    By popupDeleteButtonLocator = new By.ByCssSelector(".inverted-modal-button.sc-delete.ins-init-condition-tracking");
    By cartEmptyLocater = new By.ByCssSelector(".cart-empty-title");

    //Detail Page prices
    String detailRegularPriceString;
    String detailBasketPriceString;
    //Cart prices
    String cartRegularPrice;
    String cartBasketPrice;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void goToCart(){
        clickElement(goToCartButtonLocator);
    }

    public boolean checkCart(){

        return isOnPage(basketItemImageLocator);
    }

    public boolean checkPrice() throws InterruptedException {
        detailRegularPriceString = findElement(priceRegularLocator).getText();
        detailBasketPriceString  = findAllElements(basketDiscountLocator).get(2).getText();
        goToCart();
        Thread.sleep(3000);
        cartRegularPrice = findElement(cartRegularLocator).getText();
        cartBasketPrice = findElement(cartBasketLocator).getText();

        if(detailBasketPriceString.equals(cartBasketPrice)){
            return true;
        }
            return false;
    }

    public boolean increaseQuantityandCheck() throws InterruptedException {
        clickElement(increaseQuantityButtonLocator);
        Thread.sleep(2000);
        int quantity = Integer.parseInt(findElement(quantityInputLocator).getAttribute("value"));
        if(quantity == 2){ return true;
        }
        return false;

    }

    public boolean deleteItem() throws InterruptedException {
        clickElement(cartDeleteButtonLocator);
        Thread.sleep(2000);
        clickElement(popupDeleteButtonLocator);

        return isOnPage(cartEmptyLocater);

    }


}
