package Application;

import Utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends  BaseTests{
    WebDriver driver;
    Utilities excelData;
    public Login(WebDriver driver){
        this.driver = driver;
    }
    public void invalidLogin(String username, String password){
        driver.findElement(By.xpath("//*[@id='noo-site']/header/div[1]/div/ul[2]/li[2]/a")).click();
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.name("login")).click();
        System.out.println("ERROR: The username or password you entered is incorrect. Lost your password?");
    }
    public void validLogin(String username, String password){
        driver.findElement(By.xpath("//*[@id='noo-site']/header/div[1]/div/ul[2]/li[2]/a")).click();
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.name("login")).click();

    }
    public void logingOut(){
        driver.findElement(By.xpath("//*[@id='noo-site']/header/div[1]/div/ul[2]/li[2]/a")).click();
        driver.findElement(By.linkText("Logout")).click();
    }
    public void goTo(){
        driver.get("https://shop.demoqa.com/shop/");
    }


//
//    @FindBy(id = "username")
//    WebElement usernames;
//    @FindBy(id = "password")
//    WebElement passwords;
//    @FindBy(css = "button[value='Log in'")
//    WebElement submit;
//    @FindBy(linkText = "Dismiss")
//    WebElement link;
//    @FindBy(linkText = "My Account")
//    WebElement account;
//    @FindBy(linkText = "Downloads")
//    WebElement download;
//    @FindBy(linkText = "Browse products")
//    WebElement browseButton;
//    @FindBy(linkText = "Logout")
//    WebElement logoutButton;
//
//    public void invalidLogin(String username, String password){
////        link.click();
//        account.click();
//        usernames.sendKeys(username);
//        passwords.sendKeys(password);
//        submit.click();
//    }
//
//    public void validLogInOut(String username, String password) {
//        //account.click();
//        usernames.clear();
//        passwords.clear();
//        usernames.sendKeys(username);
//        passwords.sendKeys(password);
//        submit.click();
//        download.click();
//        browseButton.click();
//    }
//    public void logOutStep(){
//        account.click();
//        logoutButton.click();
//
//    }
//    public void validLogin(String username, String password){
//        //account.click();
//        usernames.clear();
//        passwords.clear();
//        usernames.sendKeys(username);
//        passwords.sendKeys(password);
//        submit.click();
//        download.click();
//        browseButton.click();
//
//    }
//
//
}

