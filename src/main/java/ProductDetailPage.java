import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BasePage{

    By sizesLocator = new By.ByCssSelector("div.option-sizes:nth-child(1) > div:nth-child(3)>a");
    By heightsLocator = new By.ByCssSelector("div.option-sizes:nth-child(3) > div:nth-child(3)>a");
    By addCartButtonLocator = By.id("pd_add_to_cart");

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }



    public void addCart() throws InterruptedException {
        chooseSizeandHeight();
        Thread.sleep(2000);
        clickElement(addCartButtonLocator);
        Thread.sleep(1000);
    }

    public void chooseSizeandHeight(){
        int sizesCount = itemCount(sizesLocator);
        int heightsCount = itemCount(heightsLocator);

        //ürünün sayfada tükenmemiş bedeni bulunuyor
        if(sizesCount > 0){
            for(int i=0;i<sizesCount;i++){
                if( findAllElements(sizesLocator).get(i).getAttribute("class") == ""){
                    findAllElements(sizesLocator).get(i).click();
                    break;
                }
            }
        }
       //ürünün sayfada ki tükenmemiş boyu bulunuyor
        else if(heightsCount > 0){
            for(int i=0;i<heightsCount;i++){
                if(findAllElements(heightsLocator).get(i).getAttribute("class") == ""){
                    findAllElements(heightsLocator).get(i).click();
                    break;
                }
            }
        }


    }




}
