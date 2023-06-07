package Application;

import Reporter.ExtentReport;
import Utilities.Utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.*;

import java.io.IOException;

public class BaseTests {
    private WebDriver driver;
    Utilities excelData;
    Login login;
    private String username;
    private String password;
    private Products product;
    private Login logingOut;
    private Cart addToCart;
    private Checkout checkoutButton;
    private Checkout billInfo;
    private Confirmation confirmOrder;
    private Cart navigatePage3;


    @BeforeSuite
    public void beforeSuite() {
        ExtentReport.initReports();
    }

    @AfterSuite
    public void afterSuite() throws IOException {
        ExtentReport.flushReports();
    }

    @Parameters({"browser", "browserUrl"})
    @BeforeClass
    public void setUp( @Optional String browser, String browserUrl) {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            // Add any specific options for the Edge driver if needed
            driver = new EdgeDriver(options);
            WebDriverManager.chromedriver().setup();
        } else {
            throw new IllegalArgumentException("Invalid browser name: " + browser);
        }

        driver.get("https://shop.demoqa.com/shop/");
        WebElement dismissLink = driver.findElement(By.linkText("Dismiss"));
        dismissLink.click();

        excelData = new Utilities();
        Utilities.setupExcel();
    }



    /*  @Test (priority = 1)
    public void InvalidLogin() throws InterruptedException {
        login = new Login(driver);
        username = Utilities.getCellData(1,1);
        password = Utilities.getCellData(1,2);
//        login.goTo();
//        login.account.click();
        login.invalidLogin(username,password);
        Thread.sleep(2500);
    }
    @Test(priority = 2)
    public void validLogin() throws InterruptedException {
//        Valid Login
        login = new Login(driver);
        username = Utilities.getCellData(2,1);
        password = Utilities.getCellData(2,2);
        login.invalidLogin(username,password);
        Thread.sleep(2500);
        login.goTo();
//        Product selection
        String ProductColor = Utilities.getCellData(2,4);
        String ProductSize = Utilities.getCellData(2,5);

        product = new Products(driver);
        addToCart = new Cart(driver);
        logingOut = new Login(driver);
        product.selectProduct(ProductColor, ProductSize);
        addToCart.addToCart();
        Thread.sleep(2500);
        logingOut.logingOut();

    }

     */
    @Test(priority = 3)
    public void checkOut() throws InterruptedException {
//               Valid Login
        login = new Login(driver);
        username = Utilities.getCellData(3,1);
        password = Utilities.getCellData(3,2);
        login.invalidLogin(username,password);
        Thread.sleep(2500);
        login.goTo();
        navigatePage3 = new Cart(driver);
        navigatePage3.page3Navigate();


        //        Product selection
        String ProductColor = Utilities.getCellData(3,4);
        String ProductSize = Utilities.getCellData(3,5);

        product = new Products(driver);
        addToCart = new Cart(driver);
        logingOut = new Login(driver);
        product.page3Product(ProductColor, ProductSize);
        addToCart.addToCart();
//        proceed to checkout
        checkoutButton = new Checkout(driver);
//        Billing
        String BFirstName = Utilities.getCellData(3,6);
        String BLastName = Utilities.getCellData(3,7);
        String BCompany = Utilities.getCellData(3,9);
        String BCountry = Utilities.getCellData(3,10);
        String BAddress = Utilities.getCellData(3,11);
        String BCity = Utilities.getCellData(3,12);
        String BProvince = Utilities.getCellData(3,13);
        String BCode = String.valueOf(Utilities.getCellInt(3,14));
        String BPhone = String.valueOf(Utilities.getCellInt(3,15));
        String BEmail = Utilities.getCellData(3,8);
        billInfo = new Checkout(driver);
        billInfo.billing(BFirstName, BLastName, BCompany, BCountry, BAddress,
                BCity, BProvince, BCode, BPhone, BEmail);
        Thread.sleep(2500);

    }
    @Test(priority = 4)
    //finish up with confirmation class!!
    public void confirmation(){
        confirmOrder = new Confirmation(driver);
        confirmOrder.placeOrder();
    }

//    @AfterTest
//    public void endTest() {
//        ExtentReport.flush();
//
//    }
}
