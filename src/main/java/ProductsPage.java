import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends BasePage{

    By productsLocator = new By.ByCssSelector("div[class='picture-box']");
    By moreProductButtonLocator = By.className("lazy-load-text");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void scrollToBottom() throws InterruptedException {
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight || document.documentElement.scrollHeight)", "");
        Thread.sleep(2000);
    }

    public void clickMoreButton(){
        clickElement(moreProductButtonLocator);
    }

    public void randomProduct(){
        int count = itemCount(productsLocator)-2;
        int randNumber = (int) Math.round(Math.random() + count);
        List<WebElement> products = findAllElements(productsLocator);
        String option_id = products.get(randNumber).getAttribute("data-optionid");
        clickElement(new By.ByCssSelector("div[data-optionid='"+option_id+"'"));




    }
}
