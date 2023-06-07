package Application;
import Utilities.WaitElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Checkout extends WaitElement {
    WebDriver driver;
    private WebDriverWait wait;
//    private String lastEnteredEmail;


    public Checkout(WebDriver driver){
        super(driver);
        this.driver = driver;
//        this.lastEnteredEmail = "BEmail";

    }

    public void clickCheckOut(){
        WebElement checkoutButton = driver.findElement(By.linkText("Checkout"));
        checkoutButton.click();

    }
    public  void billing(String BFirstName, String BLastName, String BCompany, String BCountry, String BAddress,
                 String BCity, String BProvince, String BCode, String BPhone, String BEmail) throws InterruptedException {

        clickCheckOut();

//        Fill in personal info
        WebElement firstNameInput = driver.findElement(By.cssSelector("#billing_first_name"));
        firstNameInput.sendKeys(BFirstName);

        WebElement lastNameInput = driver.findElement(By.id("billing_last_name"));
        lastNameInput.sendKeys(BLastName);


        WebElement companyInput = driver.findElement(By.id("billing_company"));
        companyInput.sendKeys(BCompany);


//         Select country
        WebElement  countryDropdown = driver.findElement(By.xpath("/html/body/div[1]/div[2]/main/article/div/div/form[2]/div/div[1]/div[1]/div/p[4]/span/select"));
        Select countrySelect = new Select(countryDropdown);
        countrySelect.selectByVisibleText(BCountry);

//        address
        WebElement addressInput = driver.findElement(By.id("billing_address_1"));
        addressInput.clear();
        addressInput.sendKeys(BAddress);

        WebElement cityInput = driver.findElement(By.id("billing_city"));
        cityInput.clear();
        cityInput.sendKeys(BCity);


        WebElement  provinceDropdown = driver.findElement(By.id("billing_state"));
        Select provinceSelect = new Select(provinceDropdown);
        provinceSelect.selectByVisibleText(BProvince);

        WebElement zipInput = driver.findElement(By.id("billing_postcode"));
        zipInput.clear();
        zipInput.sendKeys(BCode);

        WebElement cellNumberInput = driver.findElement(By.id("billing_phone"));
        cellNumberInput.sendKeys(BPhone);

        WebElement emailInput = driver.findElement(By.id("billing_email"));
        emailInput.clear();
        emailInput.sendKeys(BEmail);


//        if (!BEmail.equals(lastEnteredEmail)) {
//            WebElement emailInput = driver.findElement(By.id("billing_email"));
//            emailInput.sendKeys(BEmail);
//            lastEnteredEmail = BEmail;
        }


    }



