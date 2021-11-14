import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{


    By homePageLocator = new By.ByCssSelector("div[class='col-sm-3 col-6 image_Box gender_Box']");
    By cookieButtonLocator = new By.ByCssSelector("p.cookie__button > button");

    SearchBar searchBar;

    public HomePage(WebDriver driver) {
        super(driver);
        searchBar = new SearchBar(driver);
    }

    public SearchBar searchBar(){
        return this.searchBar;
    }

    public boolean isOnHomePage(){
        return itemCount(homePageLocator) > 0;
    }

    public void confirmCookieDialog() throws InterruptedException {
        clickElement(cookieButtonLocator);
        Thread.sleep(2000);
    }


}
