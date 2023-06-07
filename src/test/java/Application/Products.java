package Application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Products  extends  BaseTests{
    WebDriver driver;
    private WebElement sizeDropdown;

    public Products(WebDriver driver){
        this.driver = driver;
    }

    public void selectProduct(String productColor, String productSize){

        // Find item to add to cart
        WebElement item = driver.findElement(By.xpath("(//img[@class='product-one-thumb'])[1]"));
        item.click();

        // Select color from dropdown
        WebElement colorDropdown = driver.findElement(By.id("pa_color"));
        Select colorSelect = new Select(colorDropdown);
        colorSelect.selectByVisibleText(productColor);

        // Select size from dropdown
        WebElement sizeDropdown = driver.findElement(By.id("pa_size"));
        Select sizeSelect = new Select(sizeDropdown);
        sizeSelect.selectByVisibleText(productSize);

    }
    public void page3Product(String productColor, String productSize){
//        Find item to add to cart
        WebElement item = driver.findElement(By.cssSelector(".noo-product-inner"));
        item.click();

//            Select color from dropdown
        WebElement  colorDropdown = driver.findElement(By.id("pa_color"));
        Select colorSelect = new Select(colorDropdown);
        colorSelect.selectByVisibleText(productColor);

//            Select size from dropdown
        WebElement sizeDropdown = driver.findElement(By.id("pa_size"));
        Select sizeSelect = new Select(sizeDropdown);
        sizeSelect.selectByVisibleText(productSize);
    }


//    public void page3product(String ProdName, String ProdColor, String ProdSize){
//        nextPage.click();
//        prodPage3.click();
//        prodColor.click();
//        prodSize.click();
//        addCartButton.click();
//    }

}
//
//
//    @FindBy(css = "div[class='noo-product-item one noo-product-sm-4 not_featured post-1162 product type-product status-publish has-post-thumbnail product_cat-dress product_cat-maxi-dresses product_tag-dress product_tag-maxi product_tag-women has-featured first instock sale shipping-taxable purchasable product-type-variable'] div[class='owl-item active'] img[class='product-one-thumb']")
//    WebElement products;
//    @FindBy(css = "option[value='black']")
//    WebElement drops;
//    @FindBy(css = "option[value='medium']")
//    WebElement size;
//    @FindBy(css = "button[class='single_add_to_cart_button button alt wp-element-button']")
//    WebElement addCartButton;
//    @FindBy(linkText = "3")
//    WebElement nextPage;
//    @FindBy(css = ".product-one-thumb[width='300'][height='300'][src='https://shop.demoqa.com/wp-content/uploads/2019/04/yellow-tie-dye-bardot-bodycon-mini-dress-300x300.jpg']")
//    WebElement prodPage3;
//    @FindBy(css = "option[value='orange']")
//    WebElement prodColor;
//    @FindBy(css = "option[value='medium']")
//    WebElement prodSize;
