import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SearchBar extends BasePage{

    By searchBarLocator = By.id("search_input");
    By searchBarButton = By.xpath("//button[text()='Ara']");

    public SearchBar(WebDriver driver) {
        super(driver);
    }

    public void search(String text){
        clickElement(searchBarLocator);
        findElement(searchBarLocator).clear();
        typeText(searchBarLocator,text);
        clickElement(searchBarButton);
    }

}
