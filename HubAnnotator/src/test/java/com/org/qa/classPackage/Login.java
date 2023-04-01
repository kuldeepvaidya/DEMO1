package com.org.qa.classPackage;
import com.org.qa.utils.DriverUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.sql.Driver;
import java.util.Collections;
import java.util.concurrent.TimeUnit;



public class Login extends DriverUtil {
//    static WebDriver driver =null;

//    public void openBrowser(){
////        ChromeOptions option = new ChromeOptions();
////            //obj.setUp();
////        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"\\src\\test\\java\\com\\dtici\\qa\\classPackage\\chromedriver.exe");
////       // option.addArguments("--headless");
////        //driver = new ChromeDriver(option);
////        driver = new ChromeDriver();
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//    }
//        @Before
        public void openUrl(String url) {
            driver =getDriver();
            driver.get(url);
            driver.manage().window().maximize();
        }

        public void loginpage(String username, String pswd) {
            System.out.println(driver.getTitle());

             driver.findElement(By.id("user-name")).sendKeys(username);
             driver.findElement(By.id("password")).sendKeys(pswd);

        }

        public void clickLogin() {

             driver.findElement(By.id("login-button")).click();
        }

        public void addToCart() {
             driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
             driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
        public void icon(){
             driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();

        }

        public void continueShop(){
             driver.findElement(By.xpath("(//button[@id='continue-shopping'])")).click();

        }
        public void addNewItem() {
             driver.findElement(By.xpath("(//button[@id='add-to-cart-sauce-labs-bolt-t-shirt'])")).click();
             driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
             driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();

        }
        public void removeItem(){
             driver.findElement(By.xpath("(//button[@id='cancel'])")).click();
             driver.findElement(By.xpath("(//button[@id='remove-sauce-labs-backpack'])")).click();

        }
        public void checkOut() {
             driver.findElement(By.id("checkout")).click();
        }

        public void addressInfo() {
             driver.findElement(By.id("first-name")).sendKeys("Aaron");
             driver.findElement(By.id("last-name")).sendKeys("Tim C");
             driver.findElement(By.id("postal-code")).sendKeys("632101");
           // boolean cont = driver.findElement(By.id("continue")).isSelected();

            driver.findElement(By.id("continue")).click();
        }

        public void finishbutton() {
             driver.findElement(By.id("finish")).click();
//            boolean cont = driver.findElement(By.id("finish")).isSelected();
//            Assert.assertEquals(cont,"fish");
             driver.findElement(By.id("back-to-products")).click();
        }

        public void logOut() {
             driver.findElement(By.xpath("(//button[contains(text(),'Open Menu')])")).click();
             driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }

        public void clickLogout() {

            if( driver.findElement(By.id("logout_sidebar_link")).isEnabled()){
                 driver.findElement(By.xpath("(//a[@id='logout_sidebar_link'])")).click();

            }else {
                System.out.println("You need to logout now!!!");
            }
        }
        public void close(){
            driver.quit();
        }

}
