package com.org.qa.utils.constants;
import java.io.File;
import com.org.qa.utils.APIUtils;
//import gherkin.lexer.Fi;

public class Constants {
    public static String configPath= File.separator+"src"+File.separator+"test"+File.separator+"resources";
    public static String envPath=File.separator+"src"+File.separator+"test"+File.separator+"resource" +File.separator +"properties"+ File.separator+ "int.properties";
    public static String envPropertyPath=File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"properties"+File.separator+"environment.properties";
    public static String ReqBodyPath=File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"inputjson"+ File.separator;
    public static String SchemaPath=File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"jsonschema"+File.separator;
    public static String ObjectRepositoryPath=File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"properties"+File.separator+"ObjectRepository.properties";
    public static String testArtifactsPath = configPath+File.separator+"testArtifacts"+File.separator;
    public static String
            EndPointBuyerSearch="/buyersearch_dtag/v3/";
    public static String
            EndPointCertusComponentsDemandImportIsAlive="/certus_components_demand_import/v2/isalive";
    public static String
            EndPointCertusComponentsDemandImportImport="/certus_components_demand_import/v2/import/";
    public static String
            EndPointCertusSupplierDemandImportIsAlive="/certus_supplier_demand_import/v1/is-alive";
    public static String
            EndPointCertusSupplierDemandImportHealthStatus="/certus_supplier_demand_import/v1/health-status";
    public static String
            EndPointCertusSupplierDemandImportImportDemand="/certus_supplier_demand_import/v1/import-demand";
    public static String
            EndPointCWayCatalogSearchHeader="/catalogsearch_dtag/v1/header?supplierAID=SR_20220211_001&supplierID=11901000";
    public static String
            EndPointCWayCatalogSearchMonitoring="/catalogsearch_dtag/v1/monitoring";
    public static String
            EndPointCWayCatalogSearchArticle="/catalogsearch_dtag/v1/article?supplierAID=SR_20220211_001&supplierID=11901000";
    public static String
            EndPointCWayNewPartNewPart="/newpart_dtag/v1/newpart";
    public static String
            EndPointCWayNewPartMonitoring="/newpart_dtag/v1/monitoring";
    public static int CertusComponentsIsAliveCode=20001;
    public static String CertusComponentsIsAliveMessage="Service available";
    public static int CertusComponentsImportCode=20010;
    public static String CertusComponentsImportMessage="Demand has been created";
    public static int CertusSupplierIsAliveCode=20001;
    public static String CertusSupplierIsAliveMessage="Service available";
    //Proplan input text values
    public static String Measure="New Spec Lever Requirement";
    public static String CostReductionValue="123";
    public static String MileStoneNameValue="Test MileStone";
    public static String TaskValue="Test";
    public static String Authentication="Cookie";
    public static String SourcingBundleTitle="Sourcing Bundle Test";
    public static String ExpectedStatus="Active";

    public static String RFQ="RFQ";
    public static String POST_RFQ="POSTRFQ";
    public static String Quote="Quote";
    public static String Awarded="Awarded";
    public static String Approval="In approval";
    public static String Implemented="Implemented";

    public static String Expected_title="DAIMLER TRUCK";
    public static String Expected_field1="Daimler Truck AG";
    public static String Expected_field2="HOMEPAGE";
    public static String Expected_field3="PROCUREMENT";
    public static String Expected_field4="COLLABORATION";
    public static String Expected_field5="SUSTAINABILITY";
    public static String Expected_field6="SUPPORT";
    public static String Procurement_title="Procurement | Daimler Truck Supplier Portal";
    public static String Sustainability_title="Sustainability | Daimler Truck Supplier Portal";
    public static String Collaboration_title="Collaboration | Daimler Truck Supplier Portal";
    public static String Support_title="Support | Daimler Truck Supplier Portal";
    public static String error="Login failed!";
    public static String Actual_Title1="Homepage - Mercedes-Benz Trucks - Trucks you can trust";
    public static String Actual_Title2="Home | Freightliner Trucks";
    public static String Actual_Title3="Homepage | Mitsubishi Fuso Truck and Bus Corporation";
    public static String Actual_Title4="Western Star Trucks - Home";
    public static String Actual_Title5="Thomas Built Buses";
    public static String Actual_Title6="BharatBenz Trucks, Buses, Commercial Vehicle, Heavy Vehicle Manufacturers in India - BharatBenz";
    public static String Actual_Title7="Home – Setra Buses";

    public static String Procurement_Page="Procurement | Daimler Truck Supplier Portal";
    public static String Collaboration_Page="Collaboration | Daimler Truck Supplier Portal";
    public static String Sustainability_Page="Sustainability | Daimler Truck Supplier Portal";
    public static String Help_Page="Support | Daimler Truck Supplier Portal";
    public static String Downloads_Page="";
    public static String siginverify="Welcome";
    public static String logout="Logged off";
    public static String welcometext="Welcome";
}
