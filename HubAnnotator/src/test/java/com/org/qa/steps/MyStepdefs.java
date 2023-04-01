package com.org.qa.steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class MyStepdefs {

    SwaglabsDemo test = new SwaglabsDemo();
    @Given("user should open url")
    public void userShouldOpenUrl() {
        test.urlPage();
    }

    @When("user able to login")
    public void userAbleToLogin() {
        test.login();
    }

    @Given("user choose a product")
    public void userChooseAProduct() {
        test.AddToCart();
        test.Cart();
        test.CheckOut();
    }

    @When("user give the details")
    public void userGiveTheDetails() {
        test.Information();
    }

    @Then("User should overview order")
    public void userShouldOverviewOrder() {
        test.Overview();
    }

    @When("User back to homepage")
    public void userBackToHomepage() throws InterruptedException {
        test.BackToHome();
    }

    @Then("User can logout")
    public void userCanLogout() throws InterruptedException {
        test.Logout();
    }

    @Given("User able to close the browser")
    public void userAbleToCloseTheBrowser() throws InterruptedException {
        test.Quit();
    }
}
