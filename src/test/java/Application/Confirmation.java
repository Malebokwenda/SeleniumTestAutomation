package Application;

import Utilities.WaitElement;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Confirmation extends WaitElement {
    WebDriver driver;

    public Confirmation(WebDriver driver){
        super(driver);
        this.driver = driver;

    }
    public void placeOrder(){

        //        Click the terms and conditions checkbox

        WebElement termsCheckbox = driver.findElement(By.id("terms"));
        termsCheckbox.click();
//        Click on the 'Place  Order' button
        WebElement completeOrderButton = driver.findElement(By.xpath("(//button[normalize-space()='Place order'])[1]"));
        completeOrderButton.click();

    }
}
