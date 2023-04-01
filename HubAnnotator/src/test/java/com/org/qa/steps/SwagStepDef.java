package com.org.qa.steps;
import com.org.qa.classPackage.Login;
//import com.org.qa.classPackage.RestApi;
import com.org.qa.utils.APIUtils;
import com.org.qa.utils.DriverUtil;
import com.org.qa.utils.PageElement;
import com.org.qa.utils.XMLParser;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;


//import static SwagLabs.classPackage.Login.driver;

public class SwagStepDef extends DriverUtil{
    Login obj = new Login();
    XMLParser obj1=new XMLParser();
    //RestApi oRestAPI = new RestApi();

    //    @Given("Username and Password")
//    public void username_and_password() {
//    }
    @Given("i am an existing user")
    public void iAmAnExistingUser() {

//        obj.openBrowser();
//        initiliseDriver();

    }
    @Given("User Login to application")
    public void user_login_to_application() throws FileNotFoundException, ParseException {


        Response data=APIUtils.MongoRead();
        //JSONObject obj=(JSON)data;
     //   System.out.println(obj.get("userid"));
     //   System.out.println(obj.get("password"));



        PageElement.loadDriver();
        obj1.FillDetails("Login");

    }
    @When("i open browser to {string}: www.saucedemo.com")
    public void iOpenBrowserToWwwSaucedemoCom(String url) {
        obj.openUrl(url);
    }

    @And("fill correct username as {string} and password as {string}")
    public void fillCorrectUsernameAsAndPasswordAs(String username, String pswd) {
        obj.loginpage(username, pswd);
    }

    @And("press login button")
    public void pressLoginButton() {
        obj.clickLogin();
    }

    @Then("i see my application dashboard")
    public void iSeeMyApplicationDashboard() {
    }


    @Given("Check all the products")
    public void checkAllTheProducts() {

    }

    @And("Select the product that you want to order")
    public void selectTheProductThatYouWantToOrder() {
    }

    @When("Click on Add to cart")
    public void clickOnAddToCart() {
        obj.addToCart();

    }

    @And("it will add all your products in shopping cart")
    public void itWillAddAllYourProductsInShoppingCart() {

    }

    @Then("Click on shopping cart icon")
    public void clickOnShoppingCartIcon() {
        obj.icon();
        obj.continueShop();
    }

//    @Given("Open website")
//    public void openWebsite() {
//        obj.openUrl();
//    }
//    @Then("user enters {string} and password {string}")
//    public void userEntersAndPassword(String username, String pswd) {
//        obj.loginpage(username, pswd);
//    }
//
//    @When("login to the website")
//    public void login_to_the_website() {
//        obj.clickLogin();
//    }

//    @Given("Add product to the cart")
//    public void add_product_to_the_cart() {
//        obj.addToCart();
//    }
//
//    @Then("Click on continue")
//    public void clickOnContinue() {
//        obj.continueShop();
//    }

    @Given("Add another item")
    public void addAnotherItem()  {
        obj.addNewItem();
    }
    @Then("Checkout the product")
    public void checkout_the_product() {
        obj.checkOut();
    }

    @Given("Enter address information")
    public void enter_address_information() {
        obj.addressInfo();
    }

    @Then("Click Finish")
    public void click_finish() {
        obj.finishbutton();
    }

    @Given("goto react button")
    public void goto_react_button()  {
        obj.logOut();
    }

    @Then("click logout")
    public void click_logout() {
        obj.clickLogout();
    }


    @And("Close Browser")
    public void closeBrowser() {
        obj.close();
    }

    @And("remove Item from cart")
    public void removeItemFromCart() {
        obj.removeItem();
        obj.checkOut();
    }

    @After
    public void tearDown(Scenario scenario){
       // driver.quit();
//        if(scenario.isFailed()){
//            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
//            Allure.addAttachment("Failed screenshot",new ByteArrayInputStream(screenshot));
//        }
    }

    @When("User is navigated to Swag Labs")
    public void userIsNavigatedToSwagLabs() {
        String s=PageElement.changeFocus("Swag Labs");
        System.out.println("SWITCH+"+s);


    }

    @Then("Add product")
    public void addProduct() throws InterruptedException {
        obj1.FillDetails("product");
        Thread.sleep(5000);
    }

    @Then("Logout")
    public void logout() throws InterruptedException {
        obj1.FillDetails("Logout");
        Thread.sleep(5000);
    }

    @Then("Remove Product")
    public void removeProduct() throws InterruptedException {
        obj1.FillDetails("RemoveOneProduct");   Thread.sleep(5000);
    }

    @Then("Navigate to Cart")
    public void navigateToCart() {

        obj1.FillDetails("GotoCart");
    }


//    @Given("Token is Available")
//    public void tokenIsAvailable() {
//        oRestAPI.sendReq();
//    }
}
