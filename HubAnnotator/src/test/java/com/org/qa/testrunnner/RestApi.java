package com.org.qa.testrunnner;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.parser.JSONParser;

import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class RestApi {

    private static final String client_id = "05DF0F5C191A42BB85F6987503A1C1FD";
    private static final String client_secret = "b2c394016641d436962b19e121073c2c60fb5ca3a525a7da7a3d7be9715159ae";
    //    private static final String base_url  = "https://xray.cloud.getxray.app/api/v1";
   // private static final String token_value = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0ZW5hbnQiOiI5Y2ZiYjExMi03OTU4LTNlN2MtOWQwMy0xYzQyZDUzNTgwOTYiLCJhY2NvdW50SWQiOiI1YjZjOTZhZTg1ZWU0ZDNkOTU4NjBhNzMiLCJpc1hlYSI6ZmFsc2UsImlhdCI6MTY3MjM4MjIwOCwiZXhwIjoxNjcyNDY4NjA4LCJhdWQiOiIwNURGMEY1QzE5MUE0MkJCODVGNjk4NzUwM0ExQzFGRCIsImlzcyI6ImNvbS54cGFuZGl0LnBsdWdpbnMueHJheSIsInN1YiI6IjA1REYwRjVDMTkxQTQyQkI4NUY2OTg3NTAzQTFDMUZEIn0.opocf73LrSDMlF3tIgHFXSlmdR2JWs7yR1WhnziyHVw";
    private static final String token_value = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0ZW5hbnQiOiI5Y2ZiYjExMi03OTU4LTNlN2MtOWQwMy0xYzQyZDUzNTgwOTYiLCJhY2NvdW50SWQiOiI1YjZjOTZhZTg1ZWU0ZDNkOTU4NjBhNzMiLCJpc1hlYSI6ZmFsc2UsImlhdCI6MTY3MjkxODQxNiwiZXhwIjoxNjczMDA0ODE2LCJhdWQiOiIwNURGMEY1QzE5MUE0MkJCODVGNjk4NzUwM0ExQzFGRCIsImlzcyI6ImNvbS54cGFuZGl0LnBsdWdpbnMueHJheSIsInN1YiI6IjA1REYwRjVDMTkxQTQyQkI4NUY2OTg3NTAzQTFDMUZEIn0.UyAL4PGb-V7Lkefpi_soY6Y5nCkURnM4ApsW7Qoussc";
    private static Response response;
    private static JsonPath token ;
    private static String jsonString;

    //    Generating 24hr token

    public void postRes(){

        RequestSpecification request = given();
        request.header("Content-Type", "application/json");
        response = request.body("{ \"client_id\":\"" + client_id + "\", \"client_secret\":\"" + client_secret + "\"}")
                .post("https://xray.cloud.getxray.app/api/v1/authenticate");
        System.out.println(response.asString());

        jsonString = response.asString();

        String jsonString = response.asString();
        token = JsonPath.from(jsonString);


    }



    public void sendReq(){
        //REad JSON file
        JSONParser parser = new JSONParser();
        try{


           // Object obj = parser.parse(new FileReader(System.getProperty("user.dir") + "\\target\\cucumber-report\\report.json"));
            String file = System.getProperty("user.dir") +"\\target\\cucumber-report\\report.json";
          //  Thread.sleep(20000);
            String json1 =   new String(Files.readAllBytes(Paths.get(file)));
            System.out.println(json1.toString());

            //CODE TO CALL API
            RequestSpecification request = given();

            request.
                    header("Authorization","Bearer " + token_value).
                    header("Content-Type","application/json");
            //response = request.body("[{\"line\":1,\"elements\":[{\"start_timestamp\":\"2022-12-28T13:26:01.969Z\",\"line\":3,\"name\":\"Update Jira\",\"description\":\"\",\"id\":\"swaglabs-website1;update-jira\",\"after\":[{\"result\":{\"duration\":2320500,\"status\":\"passed\"},\"match\":{\"location\":\"com.org.qa.steps.SwagStepDef.tearDown(io.cucumber.java.Scenario)\"}}],\"type\":\"scenario\",\"keyword\":\"Scenario\",\"steps\":[{\"result\":{\"duration\":6687332600,\"status\":\"passed\"},\"line\":4,\"name\":\"Token is Available\",\"match\":{\"location\":\"com.org.qa.steps.SwagStepDef.tokenIsAvailable()\"},\"keyword\":\"Given \"}],\"tags\":[{\"name\":\"@TEST_DS-6\"},{\"name\":\"@TESTSET_DS-7\"}]}],\"name\":\"Swaglabs Website1\",\"description\":\"\",\"id\":\"swaglabs-website1\",\"keyword\":\"Feature\",\"uri\":\"file:src/test/resources/features/Jira.feature\",\"tags\":[]},{\"line\":2,\"elements\":[{\"start_timestamp\":\"2022-12-28T13:26:08.841Z\",\"line\":12,\"name\":\"login page\",\"description\":\"\",\"id\":\"swaglabs-website;login-page;;2\",\"after\":[{\"result\":{\"status\":\"passed\"},\"match\":{\"location\":\"com.org.qa.steps.SwagStepDef.tearDown(io.cucumber.java.Scenario)\"}}],\"type\":\"scenario\",\"keyword\":\"Scenario Outline\",\"steps\":[{\"result\":{\"duration\":1803420300,\"status\":\"passed\"},\"line\":5,\"name\":\"i am an existing user\",\"match\":{\"location\":\"com.org.qa.steps.SwagStepDef.iAmAnExistingUser()\"},\"keyword\":\"Given \"},{\"result\":{\"duration\":351013300,\"status\":\"passed\"},\"line\":6,\"name\":\"i open browser to \\\"https://www.saucedemo.com/\\\": www.saucedemo.com\",\"match\":{\"arguments\":[{\"val\":\"\\\"https://www.saucedemo.com/\\\"\",\"offset\":18}],\"location\":\"com.org.qa.steps.SwagStepDef.iOpenBrowserToWwwSaucedemoCom(java.lang.String)\"},\"keyword\":\"When \"},{\"result\":{\"duration\":170334200,\"status\":\"passed\"},\"line\":7,\"name\":\"fill correct username as \\\"standard_user\\\" and password as \\\"secret_sauce\\\"\",\"match\":{\"arguments\":[{\"val\":\"\\\"standard_user\\\"\",\"offset\":25},{\"val\":\"\\\"secret_sauce\\\"\",\"offset\":57}],\"location\":\"com.org.qa.steps.SwagStepDef.fillCorrectUsernameAsAndPasswordAs(java.lang.String,java.lang.String)\"},\"keyword\":\"And \"},{\"result\":{\"duration\":90816800,\"status\":\"passed\"},\"line\":8,\"name\":\"press login button\",\"match\":{\"location\":\"com.org.qa.steps.SwagStepDef.pressLoginButton()\"},\"keyword\":\"And \"},{\"result\":{\"duration\":995900,\"status\":\"passed\"},\"line\":9,\"name\":\"i see my application dashboard\",\"match\":{\"location\":\"com.org.qa.steps.SwagStepDef.iSeeMyApplicationDashboard()\"},\"keyword\":\"Then \"}],\"tags\":[{\"name\":\"@DS-8\"},{\"name\":\"@TEST_DS-1\"},{\"name\":\"@TESTSET_DS-7\"}]},{\"start_timestamp\":\"2022-12-28T13:26:11.302Z\",\"line\":14,\"name\":\"Verify Shopping cart\",\"description\":\"\",\"id\":\"swaglabs-website;verify-shopping-cart\",\"after\":[{\"result\":{\"status\":\"passed\"},\"match\":{\"location\":\"com.org.qa.steps.SwagStepDef.tearDown(io.cucumber.java.Scenario)\"}}],\"type\":\"scenario\",\"keyword\":\"Scenario\",\"steps\":[{\"result\":{\"duration\":638300,\"status\":\"passed\"},\"line\":15,\"name\":\"Check all the products\",\"match\":{\"location\":\"com.org.qa.steps.SwagStepDef.checkAllTheProducts()\"},\"keyword\":\"Given \"},{\"result\":{\"status\":\"passed\"},\"line\":16,\"name\":\"Select the product that you want to order\",\"match\":{\"location\":\"com.org.qa.steps.SwagStepDef.selectTheProductThatYouWantToOrder()\"},\"keyword\":\"And \"},{\"result\":{\"duration\":58410200,\"status\":\"passed\"},\"line\":17,\"name\":\"Click on Add to cart\",\"match\":{\"location\":\"com.org.qa.steps.SwagStepDef.clickOnAddToCart()\"},\"keyword\":\"When \"},{\"result\":{\"status\":\"passed\"},\"line\":18,\"name\":\"it will add all your products in shopping cart\",\"match\":{\"location\":\"com.org.qa.steps.SwagStepDef.itWillAddAllYourProductsInShoppingCart()\"},\"keyword\":\"And \"},{\"result\":{\"duration\":175958900,\"status\":\"passed\"},\"line\":19,\"name\":\"Click on shopping cart icon\",\"match\":{\"location\":\"com.org.qa.steps.SwagStepDef.clickOnShoppingCartIcon()\"},\"keyword\":\"Then \"}],\"tags\":[{\"name\":\"@DS-8\"},{\"name\":\"@TEST_DS-2\"},{\"name\":\"@TESTSET_DS-7\"}]},{\"start_timestamp\":\"2022-12-28T13:26:11.587Z\",\"line\":21,\"name\":\"Continue Shopping\",\"description\":\"\",\"id\":\"swaglabs-website;continue-shopping\",\"after\":[{\"result\":{\"status\":\"passed\"},\"match\":{\"location\":\"com.org.qa.steps.SwagStepDef.tearDown(io.cucumber.java.Scenario)\"}}],\"type\":\"scenario\",\"keyword\":\"Scenario\",\"steps\":[{\"result\":{\"duration\":122353100,\"status\":\"passed\"},\"line\":22,\"name\":\"Add another item\",\"match\":{\"location\":\"com.org.qa.steps.SwagStepDef.addAnotherItem()\"},\"keyword\":\"Given \"},{\"result\":{\"duration\":98438000,\"status\":\"passed\"},\"line\":23,\"name\":\"Checkout the product\",\"match\":{\"location\":\"com.org.qa.steps.SwagStepDef.checkout_the_product()\"},\"keyword\":\"Then \"},{\"result\":{\"duration\":213165500,\"status\":\"passed\"},\"line\":24,\"name\":\"remove Item from cart\",\"match\":{\"location\":\"com.org.qa.steps.SwagStepDef.removeItemFromCart()\"},\"keyword\":\"And \"}],\"tags\":[{\"name\":\"@DS-8\"},{\"name\":\"@TEST_DS-3\"},{\"name\":\"@TESTSET_DS-7\"}]},{\"start_timestamp\":\"2022-12-28T13:26:12.047Z\",\"line\":26,\"name\":\"Finishing order process\",\"description\":\"\",\"id\":\"swaglabs-website;finishing-order-process\",\"after\":[{\"result\":{\"duration\":131240700,\"status\":\"passed\"},\"match\":{\"location\":\"com.org.qa.steps.SwagStepDef.tearDown(io.cucumber.java.Scenario)\"}}],\"type\":\"scenario\",\"keyword\":\"Scenario\",\"steps\":[{\"result\":{\"error_message\":\"java.lang.AssertionError: expected [continu] but found [false]\\r\\n\\tat org.testng.Assert.fail(Assert.java:110)\\r\\n\\tat org.testng.Assert.failNotEquals(Assert.java:1413)\\r\\n\\tat org.testng.Assert.assertEqualsImpl(Assert.java:149)\\r\\n\\tat org.testng.Assert.assertEquals(Assert.java:131)\\r\\n\\tat org.testng.Assert.assertEquals(Assert.java:643)\\r\\n\\tat com.org.qa.classPackage.Login.addressInfo(Login.java:75)\\r\\n\\tat com.org.qa.steps.SwagStepDef.enter_address_information(SwagStepDef.java:116)\\r\\n\\tat ✽.Enter address information(file:///C:/DEMO/DEMO_FRM/HubAnnotator/src/test/resources/features/TestRun.feature:27)\\r\\n\",\"duration\":235876800,\"status\":\"failed\"},\"line\":27,\"name\":\"Enter address information\",\"match\":{\"location\":\"com.org.qa.steps.SwagStepDef.enter_address_information()\"},\"keyword\":\"Given \"},{\"result\":{\"status\":\"skipped\"},\"line\":28,\"name\":\"Click Finish\",\"match\":{\"location\":\"com.org.qa.steps.SwagStepDef.click_finish()\"},\"keyword\":\"Then \"}],\"tags\":[{\"name\":\"@DS-8\"},{\"name\":\"@TEST_DS-4\"},{\"name\":\"@TESTSET_DS-7\"}]},{\"start_timestamp\":\"2022-12-28T13:26:12.441Z\",\"line\":30,\"name\":\"Logout from page\",\"description\":\"\",\"id\":\"swaglabs-website;logout-from-page\",\"after\":[{\"result\":{\"duration\":760200,\"status\":\"passed\"},\"match\":{\"location\":\"com.org.qa.steps.SwagStepDef.tearDown(io.cucumber.java.Scenario)\"}}],\"type\":\"scenario\",\"keyword\":\"Scenario\",\"steps\":[{\"result\":{\"duration\":72613700,\"status\":\"passed\"},\"line\":31,\"name\":\"goto react button\",\"match\":{\"location\":\"com.org.qa.steps.SwagStepDef.goto_react_button()\"},\"keyword\":\"Given \"},{\"result\":{\"duration\":111992100,\"status\":\"passed\"},\"line\":32,\"name\":\"click logout\",\"match\":{\"location\":\"com.org.qa.steps.SwagStepDef.click_logout()\"},\"keyword\":\"Then \"},{\"result\":{\"duration\":332501200,\"status\":\"passed\"},\"line\":33,\"name\":\"Close Browser\",\"match\":{\"location\":\"com.org.qa.steps.SwagStepDef.closeBrowser()\"},\"keyword\":\"And \"}],\"tags\":[{\"name\":\"@DS-8\"},{\"name\":\"@TEST_DS-5\"},{\"name\":\"@TESTSET_DS-7\"}]},{\"start_timestamp\":\"2022-12-28T13:26:12.979Z\",\"line\":35,\"name\":\"Update Jira\",\"description\":\"\",\"id\":\"swaglabs-website;update-jira\",\"after\":[{\"result\":{\"status\":\"passed\"},\"match\":{\"location\":\"com.org.qa.steps.SwagStepDef.tearDown(io.cucumber.java.Scenario)\"}}],\"type\":\"scenario\",\"keyword\":\"Scenario\",\"steps\":[{\"result\":{\"duration\":5240876300,\"status\":\"passed\"},\"line\":36,\"name\":\"Token is Available\",\"match\":{\"location\":\"com.org.qa.steps.SwagStepDef.tokenIsAvailable()\"},\"keyword\":\"Given \"}],\"tags\":[{\"name\":\"@DS-8\"},{\"name\":\"@TEST_DS-6\"},{\"name\":\"@TESTSET_DS-7\"}]}],\"name\":\"Swaglabs Website\",\"description\":\"\",\"id\":\"swaglabs-website\",\"keyword\":\"Feature\",\"uri\":\"file:src/test/resources/features/TestRun.feature\",\"tags\":[{\"name\":\"@DS-8\",\"type\":\"Tag\",\"location\":{\"line\":1,\"column\":1}}]}]")

            response = request.body(json1)
                    .post("https://xray.cloud.getxray.app/api/v1/import/execution/cucumber?projectKey=DS");
            System.out.println(response.getStatusCode());


            System.out.println(response.body().asString());
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

    }


}

