import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(TestLogger.class)
public class BaseTest {

    static WebDriver driver;

    @BeforeAll
    public void startUp(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.lcwaikiki.com/tr-TR/TR");
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterAll
    public void tearDown(){
        driver.quit();
    }
}
