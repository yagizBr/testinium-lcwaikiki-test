import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    By navLoginButtonLocator = By.xpath("//span[text()='Giriş Yap']");
    By emailInputLocator = By.id("LoginEmail");
    By passwordInputLocator = By.id("Password");
    By loginButtonLocator = By.id("loginLink");
    By loggedLocator = By.xpath("//span[text()='Hesabım']");
    String userEmail = "ygzbarisir@gmail.com";
    String userPassword = "testpassword123";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(){
        clickElement(navLoginButtonLocator);
        typeText(emailInputLocator,userEmail);
        typeText(passwordInputLocator,userPassword);
        clickElement(loginButtonLocator);
    }

    public boolean loggedControl(){
        return isOnPage(loggedLocator);
    }
}
