package com.org.qa.testrunnner;

//import com.cucumber.listener.Reporter;
//import com.org.qa.config.Config;
//import com.org.qa.classPackage.RestApi;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;


import java.io.File;
import java.io.IOException;


@RunWith(Cucumber.class)
@CucumberOptions(features=("src/test/resources/features"),glue={"com.org.qa.steps"},
        tags="@Swag",
        plugin={"pretty","json:target/cucumber-report/report.json",
                "html:target/cucumber-report/report.html",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"})
public class TestRunner {
    @AfterClass
    public static void writeExtentReport() throws IOException {
    RestApi o= new RestApi();
    o.sendReq();
    }
}
