package Application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart extends BaseTests{
    WebDriver driver;
    public Cart(WebDriver driver){
        this.driver = driver;
    }

    public void addToCart(){
        WebElement addToCartButton = driver.findElement(By.xpath("(//button[normalize-space()='Add to cart'])[1]"));
        addToCartButton.click();

    }
    public void page3Navigate(){
        WebElement page3Link = driver.findElement(By.linkText("3"));
        page3Link.click();
    }


//    @FindBy(id = "nav-menu-item-cart")
//    WebElement cartPopUp;
//    @FindBy (xpath = "//a[normalize-space()='Proceed to checkout']")
//    WebElement checkOut;
//
//
//        cartPopUp.click();
//        checkOut.click();
//    }
}
