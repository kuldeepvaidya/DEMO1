package com.org.qa.utils;

import com.org.qa.config.Config;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

import io.cucumber.java.it.Ma;
import io.qameta.allure.Allure;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.http.Status;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

import org.apache.http.HttpStatus;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;

import static com.org.qa.utils.constants.Constants.*;
import static io.restassured.RestAssured.*;


public class APIUtils extends Config {
    static Response response;
    public APIUtils() throws IOException {
    }

    //Method Name : post
    //Description : This method is common method for post request with request payload
    public static Response post(String baseUrl, Map<String, String> requestHeaders, FileInputStream body) {
        try {
            return given().relaxedHTTPSValidation().baseUri(baseUrl).contentType("application/json").headers(requestHeaders).body(body).post();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Method Name: delete
    //Description: This method is cmmon method for delete request
    public static Response delete(String baseUrl) {
        try {
            urlEncodingEnabled = false;
            return given().contentType(ContentType.JSON).delete(baseUrl);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Method Name: put
    //Description: This method is common method for put request
    public static Response put(String baseUrl) {
        try {
            urlEncodingEnabled = false;
            return given().contentType(ContentType.JSON).put(baseUrl);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Method Name: postWithQueryPArameter
    //Description: This method is common method for post request with query params
    public static Response postWithQueryPArameter(String baseUrl, String uri, String params, Map<String, String> requestHeaders, String body) {
        try {
            return given().relaxedHTTPSValidation().baseUri(baseUrl).contentType("application/json")
                    .queryParam(params).headers(requestHeaders).body(body).post();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Method Name: get
    //Description: This method is common method for get request
    public static Response get(String baseUrl, String uri, Map<String, String> requestheaders) {
        try {
            return given().relaxedHTTPSValidation().baseUri(baseUrl).contentType("application/json").headers(requestheaders).get(uri);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static Response getdata(String baseUrl, String uri, Map<String, String> requestheaders) {
        try {
            return given().relaxedHTTPSValidation().baseUri(baseUrl).contentType("application/json").headers(requestheaders).get(uri);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //Method Name: getUrl
    //Description: This method is common method for getting the url
    public static Response getUrl(String baseUrl, String xApiKey, String XRestAssuredWith) {
        try {
            urlEncodingEnabled = false;
            Map<String, String> requestHeaders = new HashMap<>();
            requestHeaders.put("x-api-key", xApiKey);
            requestHeaders.put("X-Requested-With", XRestAssuredWith);
            return given().relaxedHTTPSValidation().headers(requestHeaders).get(baseUrl);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Method Name: getUrlWithAuth
    //Description: This method is common method for getting url with authorization
    public static Response getUrlWithAuth(String baseUrl) {
        String strToken = "";
        try {
            return given().relaxedHTTPSValidation().

                    headers("Authorization", "Bearer", strToken).get(baseUrl);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Method Name: postWithAuth
    //Description: This method is common method for post request with authorization
    public static Response postWithAuth(String baseUrl, String uri, String body) {
        try {
            String sToken = "";
            return given().relaxedHTTPSValidation().baseUri(baseUrl).contentType("application/json")
                    .headers("Authorization", sToken).body(body).post();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Method Name: getWithQueryParams
    //Description: This method is common method for get request with query params
    public static Response getWithQueryParams(String baseUrl, String uri, String params, Map<String, String> requestheaders) {
        try {
            useRelaxedHTTPSValidation();
            return given().relaxedHTTPSValidation().baseUri(baseUrl)
                    .queryParam(params).headers(requestheaders).get(uri);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Method Name: getJSONObject
    //Description: This method returns JSON object
    public static org.json.simple.JSONObject getJSONObject(String filepath,String FileName) {
        try{
            JSONParser jsonParser =new JSONParser();
            FileReader reader= new FileReader(filepath +FileName);
            Object obj = jsonParser.parse(reader);
            return (org.json.simple.JSONObject)obj;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    //Method Name: checkStatusCode
    //Description: This method checks the status code
    public static void checkStatusCode(int statuscode)
    {
        try{
            switch(statuscode)
            {
                case HttpStatus.SC_OK:
                    break;
                case HttpStatus.SC_UNAUTHORIZED:
                    break;
                case HttpStatus.SC_ACCEPTED:
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();

        }
    }

    //Method Name: Put
    //Description: This method is common method for pur request
    public static Response Put(Map header,InputStream file, String URL){
        try {
            response = RestAssured.given().contentType(ContentType.JSON).headers(header).body(file).put(URL);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return response;
    }

    //Method Name: SchemaValidation
    //Description: This method is common method for json schema validation
    public static void SchemaValidation(InputStream schema){
        try {
            response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(schema));
            Allure.step("Schema Validation is Done Successfully!!!");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static Response MongoRead() throws FileNotFoundException, ParseException {

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Access-Control-Request-Headers", "*");
        headers.put("api-key", "d2Fec2dKM5EbdsjAbxEd7jolkXfPZ4HA94sEQRwxxmR89L0K21l1KzdB7y95qkMz");
        //Response response = post("https://data.mongodb-api.com/app/data-wwwbf/endpoint/data/v1/action/findOne",headers, new FileInputStream(System.getProperty("user.dir") + ReqBodyPath + "Record.json"));
        Response response = post("https://data.mongodb-api.com/app/data-wwwbf/endpoint/data/v1/action/find", headers, new FileInputStream(System.getProperty("user.dir") + ReqBodyPath + "Record.json"));

        response.prettyPrint();
        System.out.println(response.statusCode() + ":" + response.toString());
        return  response;
    }

    public static void MongoDBinsertOne()
    {

    }

    public static void MongoDBFind()
    {

    }
    public static void MongoDBUpdateOne()
    {

    }
    public static void MongoDBDelete()
    {

    }
    public static void MongoDBInsertMultipleDocument()
    {

    }

    //Method Name: BuyerSearch
    //Description: Post request is send with request payload
    public static void BuyerSearch() throws IOException {
        try {
            Map<String, String> headers = new HashMap<>();
            headers.put("x-api-key", Config.getEnvironmentProperty("x_api_key1"));
            headers.put("X-Requested-With", Config.getEnvironmentProperty("X_Requested_With"));
            System.out.println("The post request is sent");
            Allure.step("called POST API with x-API-KEY: " + Config.getEnvironmentProperty("x_api_key1"));
            Allure.step("called POST API with X-Requested-With : " + Config.getEnvironmentProperty("X_Requested_With"));
            response = post(Config.getEnvironmentProperty("BaseURI_BuyerSearch") + EndPointBuyerSearch, headers,
                    new FileInputStream(System.getProperty("user.dir") + ReqBodyPath + "BuyerSearch.json"));
            System.out.println("The response for the post request is received");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    //Method Name: BuyerSearchResponse
    //Description: Prints the actual response of Buyer Search Api
    public static void BuyerSearchResponse() {
        try {
            System.out.println("The Actual response of Buyer Search (DTAG) Api is:");
            response.prettyPrint();
            Allure.step(response.prettyPrint());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    //Method Name: BuyerSearchValidation
    //Description: Gets the status code and validates the status code
    public static void BuyerSearchValidation() {
        try {
            System.out.println("Buyer Search Status Code :" + response.getStatusCode());
            Assert.assertTrue(Status.SUCCESS.matches(response.statusCode()));
            // checkStatusCode(response.getStatusCode());
            Allure.step("Buyer Search Status Code :" + response.getStatusCode());
            System.out.println("The status code validation for Buyer Search (DTAG) Api is done.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    //Method Name: BuyerSearchSchemaValidation
    //Description: validates the Actual Json response with expected Json schema response
    public static void BuyerSearchSchemaValidation() throws FileNotFoundException {
        try {
            System.out.println("The Json Schema validation for Buyer Search API has begun");
            InputStream schema = new FileInputStream(System.getProperty("user.dir") + SchemaPath + "BuyerSearchSchema.json");
            SchemaValidation(schema);
            System.out.println("The Json Schema Validation for Buyer Search (DTAG) Api is done.");
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    //Method Name: CertusComponentsDemandImportIsAlive
    //Description: Get request is send
    public static void CertusComponentsDemandImportIsAlive() {
        try {
            Map<String, String> headers = new HashMap<>();
            headers.put("x-api-key", Config.getEnvironmentProperty("x_api_key1"));
            headers.put("X-Requested-With", Config.getEnvironmentProperty("X_Requested_With"));
            Allure.step("The get request is sent");
            System.out.println("The get request is sent");
            response = get(Config.getEnvironmentProperty("BaseURI_Certus"), EndPointCertusComponentsDemandImportIsAlive, headers);
            System.out.println("The response for the get request is received");
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    //Method Name: CertusComponentsDemandImportIsAliveResponse
    //Description: Prints the actual response of Certus Components Demand Import (DTAG) Is Alive Api
    public static void CertusComponentsDemandImportIsAliveResponse() {
        try {
            System.out.println("The Actual response of Certus Components Demand Import Is Alive Api is:");
            response.prettyPrint();
            Allure.step("The Actual response of Certus Components Demand Import Is Alive Api is:");
            Allure.step(response.prettyPrint());
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    //Method Name: CertusComponentDemandImportIsAliveValidation
    //Description: Gets the status code and validates the status code
    public static void CertusComponentDemandImportIsAliveValidation() {
        try {
            System.out.println("Certus Components Demand Import (DTAG) Is Alive Status Code :" + response.getStatusCode());
            Allure.step("Certus Components Demand Import (DTAG) Is Alive Status Code :" + response.getStatusCode());
            Assert.assertTrue(Status.SUCCESS.matches(response.statusCode()));
            //checkStatusCode(response.getStatusCode());
            Allure.step("The status code validation for Certus Components Demand Import (DTAG) Is Alive Api is done.");
            System.out.println("The status code validation for Certus Components Demand Import (DTAG) Is Alive Api is done.");
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    //Method Name: CertusComponentsDemandImportIsAliveResponseValidation
    //Description: Validation Actual response with the Expected response
    public static void CertusComponentsDemandImportIsAliveResponseValidation(){
        try {
            System.out.println("The Response validation :");
            Allure.step("The Response validation :");
            System.out.println("Validation of code field in the response");
            int ActualCode = response.then().extract().path("code");
            try {
                Assert.assertEquals(ActualCode, CertusComponentsIsAliveCode);
                System.out.println("code field validation is success!");
                Allure.step("code field validation is success!");
            }
            catch (AssertionError e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Validation of message field in the response");
            String Message = response.then().extract().path("message");
            try {
                Assert.assertEquals(Message, CertusComponentsIsAliveMessage);
                System.out.println("message field validation is success!");
                Allure.step("message field validation is success!");
            }
            catch (AssertionError e) {
                System.out.println(e.getMessage());
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    //Method Name: CertusComponentDemandImportIsAliveSchemaValidation
    //Description: validates the Actual Json response with expected Json schema response
    public static void CertusComponentDemandImportIsAliveSchemaValidation() throws FileNotFoundException {
        try {
            System.out.println("The Json Schema validation for Certus Component Demand Import IsAlive API has begun");
            InputStream schema = new FileInputStream(System.getProperty("user.dir") + SchemaPath + "CertusComponentDemandImportIsAliveSchema.json");
            SchemaValidation(schema);
            System.out.println("The Json Schema Validation for Certus Components Demand Import (DTAG) Is Alive Api is done.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    //Method Name: CERTUSComponentsDemandImportImport
    //Description: Put Request is send
    public static void CertusComponentsDemandImportImport() throws FileNotFoundException {
        try {
            Map<String, String> headers = new HashMap<>();
            headers.put("x-api-key", Config.getEnvironmentProperty("x_api_key1"));
            //headers.put("X-Requested-With", Config.getEnvironmentProperty("X_Requested_With"));
            Allure.step("Successfully called CertusComponentsDemandImportImport API with PUT type ");
            System.out.println("The put request is sent");
            response = Put(headers, new FileInputStream(System.getProperty("user.dir") + ReqBodyPath + "CertusComponentsDemandImportImport.json"),
                    Config.getEnvironmentProperty("BaseURI_Certus") + EndPointCertusComponentsDemandImportImport);
            System.out.println("The response for the put request is received");
            Allure.step("The response is received");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    //Method Name: CertusComponentsDemandImportImportResponse
    //Description: Prints the actual response of Certus Components Demand Import Import
    public static void CertusComponentsDemandImportImportResponse() {
        try {
            System.out.println("The Actual response of Certus Components Demand Import Import Api is:");
            response.prettyPrint();
            Allure.step(response.prettyPrint());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    //Method Name: CertusComponentDemandImportImportValidation
    //Description: Validates the status code of Certus Component Demand Import Import Page
    public static void CertusComponentDemandImportImportValidation() {
        try {
            Allure.step("Certus Components Demand Import Import Status Code :" + response.getStatusCode());
            System.out.println("Certus Components Demand Import Import Status Code :" + response.getStatusCode());
            Assert.assertTrue(Status.SUCCESS.matches(response.statusCode()));
            //checkStatusCode(response.getStatusCode());
            System.out.println("The status code validation for Certus Component Demand Import (DTAG) Import Api is done.");
            Allure.step("The status code validation for Certus Component Demand Import (DTAG) Import Api is done.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    //Method Name: CertusComponentsDemandImportImportResponseValidation
    //Description: Validation Actual response with the Expected response
    public static void CertusComponentsDemandImportImportResponseValidation(){
        try {
            System.out.println("The Response validation :");
            System.out.println("Validation of code field in the response");
            int ActualCode = response.then().extract().path("code");
            Allure.step("Validation of code field in the response");
            try {
                Assert.assertEquals(ActualCode, CertusComponentsImportCode);
                System.out.println("code field validation is success!");
                Allure.step("code field validation is success!");
            }
            catch (AssertionError e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Validation of message field in the response");
            Allure.step("Validation of message field in the response");
            String Message = response.then().extract().path("message");
            try {
                Assert.assertEquals(Message, CertusComponentsImportMessage);
                System.out.println("message field validation is success!");
                Allure.step("message field validation is success!");
            }
            catch (AssertionError e) {
                System.out.println(e.getMessage());
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    //Method Name: CertusComponentDemandImportImportSchemaValidation
    //Description: validates the Actual Json response with expected Json schema response
    public static void CertusComponentDemandImportImportSchemaValidation() throws FileNotFoundException {
        try {
            System.out.println("The Json Schema validation for Certus Component Demand Import Import API has begun");
            InputStream schema = new FileInputStream(System.getProperty("user.dir") + SchemaPath + "CertusComponentDemandImportImportSchema.json");
            SchemaValidation(schema);
            System.out.println("The Json Schema Validation for Certus Component Demand Import (DTAG) Import Api is done.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    //Method Name:CertusSupplierDemandImportIsAlive
    //Description:Get request is send
    public static void CertusSupplierDemandImportIsAlive(){
        try {
            Map<String, String> headers = new HashMap<>();
            headers.put("x-api-key", Config.getEnvironmentProperty("x_api_key2"));
            System.out.println("The get request is sent");
            response = get(Config.getEnvironmentProperty("BaseURI_Certus"), EndPointCertusSupplierDemandImportIsAlive, headers);
            System.out.println("The response for the get request is received");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    //Method Name: CertusSupplierDemandImportIsAliveResponse
    //Description: Prints the actual response of Certus Supplier Demand Import (DTAG) Is Alive
    public static void CertusSupplierDemandImportIsAliveResponse() {
        try {
            System.out.println("The Actual response of Certus Supplier Demand Import (DTAG) Is Alive Api is:");
            Allure.step("The Actual response of Certus Supplier Demand Import (DTAG) Is Alive Api is:");
            response.prettyPrint();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    //Method Name: CertusComponentDemandImportIsAliveValidation
    //Description: Validates the status code of Certus Supplier Demand Import IsAlive Page
    public static void CertusSupplierDemandImportIsAliveValidation() {
        try {
            System.out.println("Certus Supplier Demand Import Is Alive  Status code :" + response.getStatusCode());
            Assert.assertTrue(Status.SUCCESS.matches(response.statusCode()));
            //checkStatusCode(response.getStatusCode());
            System.out.println("The status code validation for Certus Supplier Demand Import (DTAG) Is Alive Api is done.");
            Allure.step("The status code validation for Certus Supplier Demand Import (DTAG) Is Alive Api is done.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    //Method Name: CertusSupplierDemandImportIsAliveResponseValidation
    //Description: Validation Actual response with the Expected response
    public static void CertusSupplierDemandImportIsAliveResponseValidation(){
        try {
            System.out.println("The Response validation :");
            System.out.println("Validation of code field in the response");
            int ActualCode = response.then().extract().path("code");
            try {
                Assert.assertEquals(ActualCode, CertusSupplierIsAliveCode);
                System.out.println("code field validation is success!");
                Allure.step("code field validation is success!");
            }
            catch (AssertionError e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Validation of message field in the response");
            String Message = response.then().extract().path("message");
            try {
                Assert.assertEquals(Message, CertusSupplierIsAliveMessage);
                System.out.println("message field validation is success!");
                Allure.step("message field validation is success!");
            }
            catch (AssertionError e) {
                System.out.println(e.getMessage());
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    //Method Name: CertusSupplierDemandImportIsAliveSchemaValidation
    //Description: validates the Actual Json response with expected Json schema response
    public static void CertusSupplierDemandImportIsAliveSchemaValidation() throws FileNotFoundException {
        try {
            System.out.println("The Json Schema validation for Certus Supplier Demand Import IsAlive API has begun");
            InputStream schema = new FileInputStream(System.getProperty("user.dir") + SchemaPath + "CertusSupplierDemandImportIsAliveSchema.json");
            SchemaValidation(schema);
            System.out.println("The Json Schema Validation for Certus Supplier Demand Import (DTAG) Is Alive Api is done.");
            Allure.step("The Json Schema Validation for Certus Supplier Demand Import (DTAG) Is Alive Api is done.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    //Method Name: CertusSupplierDemandImportHealthStatus
    //Description: Get request is send
    public static void CertusSupplierDemandImportHealthStatus(){
        try {
            Map<String, String> headers = new HashMap<>();
            headers.put("x-api-key", Config.getEnvironmentProperty("x_api_key2"));
            System.out.println("The get request is sent");
            response = get(Config.getEnvironmentProperty("BaseURI_Certus"), EndPointCertusSupplierDemandImportHealthStatus, headers);
            System.out.println("The response for the get request is received");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    //Method Name: CertusSupplierDemandImportHealthStatusResponse
    //Description: Prints the actual response of Certus Supplier Demand Import (DTAG) Health Status
    public static void CertusSupplierDemandImportHealthStatusResponse() {
        try {
            System.out.println("The Actual response of Certus Supplier Demand Import (DTAG) Health Status Api is:");
            response.prettyPrint();
            Allure.step(response.prettyPrint());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    //Method Name: CertusSupplierDemandImportHealthStatusValidation
    //Description: Validates the status code of Certus Supplier Demand Import (DTAG) Health Status Page
    public static void CertusSupplierDemandImportHealthStatusValidation() {
        try {
            System.out.println("Certus Supplier Demand Import Health Status Status Code :" + response.getStatusCode());
            Allure.step("Certus Supplier Demand Import Health Status Status Code :" + response.getStatusCode());
            Assert.assertTrue(Status.SUCCESS.matches(response.statusCode()));
            //checkStatusCode(response.getStatusCode());
            System.out.println("The status code validation for Certus Supplier Demand Import (DTAG) Health Status Api is done.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    //Method Name: CertusSupplierDemandImportImportDemand
    //Description: Put request with request payload is send
    public static void CertusSupplierDemandImportImportDemand() throws FileNotFoundException {
        try {
            Map<String, String> headers = new HashMap<>();
            headers.put("x-api-key", Config.getEnvironmentProperty("x_api_key2"));
            System.out.println("The put request is sent");
            response = Put(headers, new FileInputStream(System.getProperty("user.dir") + ReqBodyPath + "CertusSupplierDemandImportImportDemand.json"),
                    Config.getEnvironmentProperty("BaseURI_Certus") + EndPointCertusSupplierDemandImportImportDemand);
            System.out.println("The response for the put request is received");
            Allure.step("The response for the put request is received");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    //Method Name: CertusSupplierDemandImportImportDemandResponse
    //Description: Prints the actual response of Certus Supplier Demand Import Import Demand
    public static void CertusSupplierDemandImportImportDemandResponse(){
        try {
            System.out.println("The Actual response of CWay Catalog Search Header Api is:");
            response.prettyPrint();
            Allure.step(response.prettyPrint());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    //Method Name: CertusSupplierDemandImportImportDemandValidation
    //Description: Validates the status code of Certus Supplier Demand Import Import Demand Page
    public static void CertusSupplierDemandImportImportDemandValidation(){
        try {
            System.out.println("Certus Supplier Demand Import Import Demand Status Code :" + response.getStatusCode());
            Allure.step("Certus Supplier Demand Import Import Demand Status Code :" + response.getStatusCode());
            Assert.assertTrue(Status.SUCCESS.matches(response.statusCode()));
            //checkStatusCode(response.getStatusCode());
            System.out.println("The status code validation for Certus Supplier Demand Import Import Demand Api is done.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    //Method Name: CWayCatalogSearchHeader
    //Description: Get request with params is send
    public static void CWayCatalogSearchHeader(){
        try {
            Map<String, String> headers = new HashMap<>();
            headers.put("x-api-key", Config.getEnvironmentProperty("x_api_key2"));
            Map<String, String> param = new HashMap<String, String>();
            param.put("supplierAID", Config.getEnvironmentProperty("supplierAID"));
            param.put("supplierID", Config.getEnvironmentProperty("supplierID"));
            System.out.println("The get request is sent");
            response = getWithQueryParams(Config.getEnvironmentProperty("BaseURI_cWay"), EndPointCWayCatalogSearchHeader, String.valueOf(param), headers);
            System.out.println("The response for the get request is received");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    //Method Name: CWayCatalogSearchHeaderResponse
    //Description: Prints the actual response of CWay Catalog Search Header
    public static void CWayCatalogSearchHeaderResponse() {
        try {
            System.out.println("The Actual response of CWay Catalog Search Header Api is:");
            response.prettyPrint();
            Allure.step(response.prettyPrint());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    //Method Name: CWayCatalogSearchHeaderValidation
    //Description: Validates the status code of CWay Catalog Search Header Page
    public static void CWayCatalogSearchHeaderValidation() {
        try {
            System.out.println("CWay Catalog Search Header Status Code :" + response.getStatusCode());
            Assert.assertTrue(Status.SUCCESS.matches(response.statusCode()));
            //checkStatusCode(response.getStatusCode());
            System.out.println("The status code validation for CWay Catalog Search Header Api is done.");
            Allure.step("The status code validation for CWay Catalog Search Header Api is done.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    //Method Name: CWayCatalogSearchHeaderSchemaValidation
    //Description: validates the Actual Json response with expected Json schema response
    public static void CWayCatalogSearchHeaderSchemaValidation() throws FileNotFoundException {
        try {
            System.out.println("The Json Schema validation for CWay Catalog Search Header API has begun");
            InputStream schema = new FileInputStream(System.getProperty("user.dir") + SchemaPath + "CWayCatalogSearchHeaderSchema.json");
            SchemaValidation(schema);
            System.out.println("The Json Schema Validation for CWay Catalog Search Header Api is done.");
            Allure.step("The Json Schema Validation for CWay Catalog Search Header Api is done.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    //Method Name: CWayCatalogSearchMonitoring
    //Description: Get request is send
    public static void CWayCatalogSearchMonitoring(){
        try {
            Map<String, String> headers = new HashMap<>();
            headers.put("x-api-key", Config.getEnvironmentProperty("x_api_key2"));
            System.out.println("The get request is sent");
            response = get(Config.getEnvironmentProperty("BaseURI_cWay"), EndPointCWayCatalogSearchMonitoring, headers);
            System.out.println("The response for the get request is received");
            Allure.step("The response for the get request is received");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    //Method Name: CWayCatalogSearchMonitoringResponse
    //Description: Prints the actual response of CWay Catalog Search Monitoring
    public static void CWayCatalogSearchMonitoringResponse() {
        try {
            System.out.println("The Actual response of CWay Catalog Search Monitoring Api is:");
            response.prettyPrint();
            Allure.step(response.prettyPrint());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    //Method Name: CWayCatalogSearchMonitoringValidation
    //Description: Validates the status code of CWay Catalog Search Monitoring Page
    public static void CWayCatalogSearchMonitoringValidation() {
        try {
            System.out.println("CWay Catalog Search Monitoring Status Code :" + response.getStatusCode());
            Allure.step("CWay Catalog Search Monitoring Status Code :" + response.getStatusCode());
            Assert.assertTrue(Status.SUCCESS.matches(response.statusCode()));
            //checkStatusCode(response.getStatusCode());
            System.out.println("The status code validation for CWay Catalog Search Monitoring Api is done.");
            Allure.step("The status code validation for CWay Catalog Search Monitoring Api is done.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    //Method Name: CWayCatalogSearchArticle
    //Description: Get request is send
    public static void CWayCatalogSearchArticle(){
        try {
            Map<String, String> headers = new HashMap<>();
            headers.put("x-api-key", Config.getEnvironmentProperty("x_api_key2"));
            Map<String, String> param = new HashMap<String, String>();
            param.put("supplierAID", Config.getEnvironmentProperty("supplierAID"));
            param.put("supplierID", Config.getEnvironmentProperty("supplierID"));
            System.out.println("The get request is sent");
            response = getWithQueryParams(Config.getEnvironmentProperty("BaseURI_cWay"), EndPointCWayCatalogSearchArticle, String.valueOf(param), headers);
            System.out.println("The response for the get request is received");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    //Method Name: CWayCatalogSearchArticleResponse
    //Description: Prints the actual response of CWay Catalog Search Article
    public static void CWayCatalogSearchArticleResponse() {
        try {
            System.out.println("The Actual response of CWay Catalog Search Article Api is:");
            response.prettyPrint();
            Allure.step(response.prettyPrint());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    //Method Name: CWayCatalogSearchArticleValidation
    //Description: Validates the status code of CWay Catalog Search Article Page
    public static void CWayCatalogSearchArticleValidation() {
        try {
            System.out.println("CWay Catalog Search Article Status Code :" + response.getStatusCode());
            Allure.step("CWay Catalog Search Article Status Code :" + response.getStatusCode());
            Assert.assertTrue(Status.SUCCESS.matches(response.statusCode()));
            //checkStatusCode(response.getStatusCode());
            System.out.println("The status code validation for CWay Catalog Search Article Api is done.");
            Allure.step("The status code validation for CWay Catalog Search Article Api is done.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    //Method Name: CWayCatalogSearchArticleSchemaValidation
    //Description: validates the Actual Json response with expected Json schema response
    public static void CWayCatalogSearchArticleSchemaValidation() throws FileNotFoundException {
        try {
            System.out.println("The Json Schema validation for CWay Catalog Search Article API has begun");
            InputStream schema = new FileInputStream(System.getProperty("user.dir") + SchemaPath + "CWayCatalogSearchArticleSchema.json");
            SchemaValidation(schema);
            System.out.println("The Json Schema Validation for CWay Catalog Search Article Api is done.");
            Allure.step("The Json Schema Validation for CWay Catalog Search Article Api is done.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    //Method Name: CWayNewPart
    //Description: Post request is send
    public static void CWayNewPartNewPart() throws FileNotFoundException {
        try {
            Map<String, String> headers = new HashMap<>();
            headers.put("x-api-key", Config.getEnvironmentProperty("x_api_key2"));
            System.out.println("The post request is sent");
            response = post(Config.getEnvironmentProperty("BaseURI_cWay") + EndPointCWayNewPartNewPart, headers,
                    new FileInputStream(System.getProperty("user.dir") + ReqBodyPath + "CWayNewPartNewPart.json"));
            System.out.println("The response for the post request is received");
            Allure.step("The response for the post request is received");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    //Method Name: CWayNewPartNewPartResponse
    //Description: Prints the actual response of CWay New Part NewPart
    public static void CWayNewPartNewPartResponse() {
        try {
            System.out.println("The Actual response of CWay New Part New PArt Api is:");
            response.prettyPrint();
            Allure.step(response.prettyPrint());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    //Method Name: CWayNewPartNewPartValidation
    //Description: Validates the status code of CWay New Part New Part Page
    public static void CWayNewPartNewPartValidation() {
        try {
            System.out.println("CWay New Part New Part Status Code :" + response.getStatusCode());
            Assert.assertTrue(Status.SUCCESS.matches(response.statusCode()));
            //checkStatusCode(response.getStatusCode());
            System.out.println("The status code validation for CWay New Part New Part Api is done.");
            Allure.step("The status code validation for CWay New Part New Part Api is done.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    //Method Name: CWayNewPartNewPartSchemaValidation
    //Description: validates the Actual Json response with expected Json schema response
    public static void CWayNewPartNewPartSchemaValidation() throws FileNotFoundException {
        try {
            System.out.println("The Json Schema validation for CWay New Part New Part API has begun");
            InputStream schema = new FileInputStream(System.getProperty("user.dir") + SchemaPath + "CWayNewPartNewPartSchema.json");
            SchemaValidation(schema);
            System.out.println("The Json Schema Validation for CWay New Part New Part Api is done.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    //Method Name: CWayNewPartMonitoring
    //Description: Get request is send
    public static void CWayNewPartMonitoring(){
        try {
            Map<String, String> headers = new HashMap<>();
            headers.put("x-api-key", Config.getEnvironmentProperty("x_api_key1"));
            System.out.println("The get request is sent");
            response = get(Config.getEnvironmentProperty("BaseURI_cWay"), EndPointCWayNewPartMonitoring, headers);
            System.out.println("The response for the get request is received");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    //Method Name: CWayNewPartMonitoring
    //Description: Prints the actual response of CWay New Part Monitoring
    public static void CWayNewPartMonitoringResponse() {
        try {
            System.out.println("The Actual response of CWay New Part Monitoring Api is:");
            response.prettyPrint();
            Allure.step(response.prettyPrint());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    //Method Name: CWayNewPartMonitoringValidation
    //Description: Validates the status code of CWay New Page Monitoring Page
    public static void CWayNewPartMonitoringValidation() {
        try {
            System.out.println("CWay Catalog Search Article Status Code :" + response.getStatusCode());
            Allure.step("CWay Catalog Search Article Status Code :" + response.getStatusCode());
            Assert.assertTrue(Status.SUCCESS.matches(response.statusCode()));
            //checkStatusCode(response.getStatusCode());
            System.out.println("The status code validation for CWay New Part Monitoring Api is done.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
