package com.org.qa.steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwaglabsDemo {
    static WebDriver driver;
String BaseUrl = "https://www.saucedemo.com/";
    public void urlPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\JiraIntegration\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
//        Thread.sleep(3000);
        driver.manage().window().maximize();
        driver.get(BaseUrl);
    }

    public void login() {

        driver.findElement(By.id("user-name")).click();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

    }

    public void AddToCart() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    public void Cart(){
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
    }

    public void CheckOut() {
        driver.findElement(By.id("checkout")).click();
    }

    public void Information() {
        driver.findElement(By.id("first-name")).sendKeys("Surendra");
        driver.findElement(By.id("last-name")).sendKeys("Jupudi");
        driver.findElement(By.id("postal-code")).sendKeys("560037");
        driver.findElement(By.id("continue")).click();
    }

    public void Overview() {
        driver.findElement(By.id("finis")).click();
    }

    public void BackToHome() throws InterruptedException {
        driver.findElement(By.id("back-to-products")).click();

    }

    public void Logout() throws InterruptedException {
        driver.findElement(By.id("react-burger-menu-bt")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("logout_sidebar_link")).click();
    }

    public void Quit() throws InterruptedException {
        driver.quit();
    }
}
