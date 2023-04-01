package com.org.qa.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.Wait;
//import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.WriteAbortedException;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.function.Function;

public class PageElement extends DriverUtil{
    // static WebDriver driver =null;
    public static String driverType="";
    public static String HomePageHandle="";
    public static String LastPAgeHandle="";
    public static int Counter=0;
    static String service;
    public static int intSyncTime=60;
    public static DateTimeFormatter formater= DateTimeFormatter.ofPattern("dd-mm-yyyyHHmmss");


    public static WebDriver loadDriver()
    {
      driverType ="chrome";
      try {


          switch (driverType) {
              case "chrome":
                  Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
                  Runtime.getRuntime().exec("taskkill /F /IM chromdriver.exe");
                  System.out.println(driver);
                  driver=null;
                  driver = getDriver();
//                  ChromeOptions option = new ChromeOptions();
                  //obj.setUp();
                  //System.getProperty("user.dir")
//                  System.setProperty("webdriver.chrome.driver", "C:\\DEMO\\DEMO_FRM\\HubAnnotator\\src\\test\\java\\com\\dtici\\qa\\classPackage\\chromedriver.exe");
//                  option.addArguments("--headless");
//                  driver = new ChromeDriver(option);
//                  driver = new EdgeDriver();
                  driver.manage().window().maximize();
                  //PageElement.driver.get("chrome://settings/clearBrowserData");
                  driver.get("https://www.saucedemo.com/");
                  break;
          }
      }catch(Exception e)
      {
        System.out.println("Load Driver Exception "+ e.getMessage());
      }
      return driver;
    }

    public static void closeDriver()
    {
        try
        {
            driver.close();
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
public static WebElement getElementForCommonOpps()
{
    WebElement element =null;
    String type =System.getProperty("type");
    String locator=System.getProperty("locator");
    String locatorvalue=System.getProperty("locatorvalue");
    String actValue=System.getProperty("actvalue");
    String name= System.getProperty("label");


    int val=0;

    try {
        switch(locator.toLowerCase())
        {
            case "linktext":
                    element = flntWaitForElement(driver,By.linkText(locatorvalue));
                    break;
            case "name":
                element = flntWaitForElement(driver,By.name(locatorvalue));
                break;
            case "id":
                element = flntWaitForElement(driver,By.id(locatorvalue));
                break;
            case "css":
                element = flntWaitForElement(driver,By.cssSelector(locatorvalue));
                break;
             case "xpath":
                 element = flntWaitForElement(driver,By.xpath(locatorvalue));
                 break;
            case "classname":
                element = flntWaitForElement(driver,By.className(locatorvalue));
                break;
            case "partiallinktext":
                element = flntWaitForElement(driver,By.partialLinkText(locatorvalue));
                break;
            case "tagname":
                element = flntWaitForElement(driver,By.tagName(locatorvalue));
                break;
            default: break;


        }
    }catch(Exception e)
    {
        System.out.println("Fail in getElementForCommonOpps :"+ e.getMessage());
        return null;
    }
    return element;
}


    public static WebElement flntWaitForElement(WebDriver driver,final By locator)
    {
        final int intSyncTime=60;
        try{

            Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(intSyncTime))
                    .pollingEvery(Duration.ofSeconds(3))
                    .ignoring(NoSuchFieldException.class);
            WebElement element = wait1.until(new Function<WebDriver,WebElement>()
                                            {
                                                public WebElement apply(WebDriver driver)
                                                {
                                                    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(intSyncTime));
                                                    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                                                }
                                            }     );
            return element;
        }catch(Exception e)
        {
            return null;
        }
    }

public static String changeFocus(String Page)
{
    try{
        if(HomePageHandle.equalsIgnoreCase("")) HomePageHandle=driver.getWindowHandle();
        if(Page.equalsIgnoreCase("HomePage"))
        {
            if(!(HomePageHandle.equalsIgnoreCase("")))
            {
                driver.switchTo().window(HomePageHandle);
                return "true";
            }else
            {
                return "false";
            }
        }
        LastPAgeHandle=driver.getWindowHandle();
        String pageTitle=Page;
        if(pageTitle.equalsIgnoreCase("")) return "false";
        int pgeFound=0;
        for(int o=0;0<5;o++)
        {
            driver.switchTo().window(HomePageHandle);
            for(String winHandle:driver.getWindowHandles())
            {
                driver.switchTo().window(winHandle);
                driver.manage().window().maximize();
                //PageElement.flntWaitForElement()
                String tempPageTitle=driver.getTitle();
                if(tempPageTitle.startsWith(pageTitle))
                {
                    pgeFound=1;
                    break;
                }
                Thread.sleep(5000);
            }
            if(pgeFound==1){
                return "true";
            } else
            {
            System.out.println("Not able to find page handle");
            return "false";
        }

        }
    }catch(Exception e)
    {
        System.out.println(e.getMessage());
    }
    return "false";
}


}
