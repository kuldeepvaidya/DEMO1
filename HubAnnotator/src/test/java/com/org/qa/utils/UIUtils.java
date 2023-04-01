package com.org.qa.utils;

import com.org.qa.pages.common.CommonPage;
import com.org.qa.utils.constants.Constants;
import io.qameta.allure.model.Status;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static com.org.qa.pages.common.CommonPage.*;
import static com.org.qa.utils.constants.Constants.*;

import io.qameta.allure.Allure;


public class UIUtils extends DriverUtil {
    static WebDriver driver = getDriver();
    static String GeneratedId;

    //Method Name: login
    //Description: This method is used for logging into the application
    public static void login(String sFileName, String sFileNo) {
        try {
            JSONObject data = FileUtil.getDataFromJsonFile(sFileName, sFileNo);
            System.out.println("Buyer navigates to proPlan url");
            Allure.step("Buyer navigates to proPlan url");
            String proPlanLoginid = (String) data.get("loginId");
            String proPlanPwd = (String) data.get("Password");
            String proPlanurl = (String) data.get("url");
            Launch(proPlanurl);
            System.out.println("Buyer logs into the proPlan");
            Allure.step("Buyer logs into the proPlan");
            WebClick("ProPlanLoginsso");
            //UerId id entered
            WebSend("ProPlanUserID", proPlanLoginid);
            WebClick("IDNextButton");
            //Password is entered
            WaitForPresenceOfElementLocated("ProPlanPassword");
            //Thread.sleep(2000);
            WebSend("ProPlanPassword", proPlanPwd);
            WebClick("LoginSubmit");
            System.out.println("Login Successful");
            Allure.step("Successfully logged in!");
            //Successfully Logged in
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Method Name : SupplierSet
    //Description : Common method for Supplier Set tab
    public static void SupplierSet() {
        try {
            //WaitForElementTovisibile("SupplierSet");
            WebClick("SupplierSet");
            //until New supplier is located
            WaitForPresenceOfElementLocated("NewSupplierButton");
            WebClick("NewSupplierButton");
            System.out.println("Entering Details of New supplier");
            Allure.step("Entering Details of New supplier");
            //until title text "provide details for the new supplier" is located
            WaitForPresenceOfElementLocated("NewSupplierPopupTitleText");
            // System.out.println("The supplier field is clicked");
            // WebClick("SupplierField");
            //Thread.sleep(2000);
            WaitForElementTovisibile("SupplierFieldDropdown");
            //System.out.println("The dropdown is selected");
            //click on the "DUPLA LOGISTICS"
            WebClick("SupplierFieldDropdown");
            //Thread.sleep(2000);
            System.out.println("The button is clicked");
            WaitForElementTovisibile("CreateSupplierButton");
            //click on create supplier
            WebClick("CreateSupplierButton");
            WaitForElementTovisibile("NewSupplierButton");
            //Thread.sleep(1000);
            System.out.println("New supplier is created");
            Allure.step("New Supplier is created");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Method Name : StatusCheckBox
    //Description : Checks the check box in supplier status
    public static void StatusCheckBox(String quote) throws InterruptedException {
        //WaitForElementTovisibile("SupplierSet");
        WebClick("SupplierSet");
        //until New supplier is located
        Wait1();
        MouseHover(quote);
        Wait1();
        MouseHover("QuoteEditIcon");
        WebClick("QuoteEditIcon");
        Wait2();
        WebClick("QuoteCheckbox");
        Wait1();
        WebClick("QuoteSave");
        Wait2();
    }

    //Method Name : Awarded
    //Description : Check the awarded check box
    public static void Awarded() throws InterruptedException {
        WaitForElementTovisibile("SupplierSet");
        WebClick("SupplierSet");
        //until New supplier is located
        Wait1();
        MouseHover("Awarded");
        Wait1();
        MouseHover("AwardedEditIcon");
        WebClick("AwardedEditIcon");
        Wait2();
        WebClick("AwardedCheckBox");
        Wait1();
        WebClick("AwardedSave");
        Wait2();
    }

    //Method Name : StatusDropDown
    //Description : Selects the status from drop down
    public static void StatusDropDown(String Status) throws InterruptedException {
        //until supplier set overview table is located
        WaitForPresenceOfElementLocated("SupplierSetOverview");
        //click on spec levers
        WebClick("SpecLeversTab");
        driver.navigate().refresh();
        // wait until new spec lever button is located
        WaitForPresenceOfElementLocated("NewSpecLeverButton");
        Wait2();
        MouseHover("Status");
        Wait1();
        MouseHover("StatusEditIcon");
        Wait1();
        WebClick("StatusEditIcon");
        Wait1();
        Select SpecLeverStatus = new Select(GetWebElement("PhaseDropDown"));
        SpecLeverStatus.selectByVisibleText(Status);
        //WebClick("StatusDropdown");
        Wait1();
        // WebClick(Status);
        Wait1();
        WebClick("StatusSave");
        Wait2();
    }

    //Method Name : Phase
    //Description : changes the phase in spec lever
    public static void Phase(String Quote_Phase) throws InterruptedException {
        System.out.println("Entered phase function");
        //until supplier set overview table is located
        WaitForPresenceOfElementLocated("SupplierSetOverview");
        //click on spec levers
        WebClick("SpecLeversTab");
        driver.navigate().refresh();
        // wait until new spec lever button is located
        WaitForPresenceOfElementLocated("NewSpecLeverButton");
        Wait2();
        MouseHover("SpecLeverPhase");
        Wait1();
        MouseHover("PhaseEditIcon");
        Wait1();
        WebClick("PhaseEditIcon");
        Wait1();
        //Select RFQ phase from dropdown list
        Select PhaseSelect = new Select(GetWebElement("PhaseDropDown"));
        System.out.println("select rfq");
        PhaseSelect.selectByVisibleText(Quote_Phase);
        System.out.println("selected rfq");
        Wait2();
        System.out.println("Click on save");
        //MouseHover("PhaseSave");
        Wait2();
        WebElement e = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div/div/div/div[2]/div/section/div/article/div[2]/div/div/cf-cplace-layout-tabs-widget/div[2]/div/div/section/div/article/div/div/div[3]/div/div/div[2]/div[2]/table/tbody/tr/td[3]/div/div/div/cplace-control-component-select/div/button"));
        System.out.println("e = " + e.isDisplayed());
        Thread.sleep(5000);
        e.sendKeys(Keys.TAB);
//        e.sendKeys(Keys.TAB);
        e.sendKeys(Keys.ENTER);
        System.out.println("PhaseSave display = " + GetWebElement("PhaseSave").isDisplayed());
        System.out.println("PhaseSave enabled = " + GetWebElement("PhaseSave").isEnabled());

        WebClick("PhaseSave");
        System.out.println("Click on save");
        Wait2();
    }

    //Method Name:SpecLevers
    //Description:common method for speclevers tab
    public static void SpecLevers() throws InterruptedException {
        try {
            //until supplier set overview table is located
            WaitForPresenceOfElementLocated("SupplierSetOverview");
            //click on spec levers
            WebClick("SpecLeversTab");
            driver.navigate().refresh();
            System.out.println("Entering all details of New Spec Lever");
            Allure.step("Entering all details of New Spec Lever");
            // wait until new spec lever button is located
            WaitForPresenceOfElementLocated("NewSpecLeverButton");
            //click on New Spec lever button
            WebClick("NewSpecLeverButton");
            //WaitForElementTovisibile("NewSpecLeverDropDown");
            Thread.sleep(2000);
            Select NewSpecLeverSelect = new Select(GetWebElement("NewSpecLeverDropDown"));
            NewSpecLeverSelect.selectByVisibleText("Pre-RFQ");
            //Measure/ideas text field data is passed
            WebSend("MeasureText", Measure);
            //cost reduction data is passed
            WebSend("CostReduction", CostReductionValue);
            Select NewSpecLeverStatusSelect = new Select(GetWebElement("NewSpecLeverStatusDropdown"));
            NewSpecLeverStatusSelect.selectByVisibleText("Planned");
            Scroll("ScrollToSourcingBundle");
            Select NewSpecLeverFTPMgmtSelect = new Select(GetWebElement("NewSpecLEverFTPMgmtDropdown"));
            NewSpecLeverFTPMgmtSelect.selectByVisibleText("Yes, further clarification with supplier required");
            WebClick("NewSpecLeverTargetDate");
            WebClick("PopUpYearDuration");
            WebClick("PopUpYearSelect");
            WebClick("PopUpYear");
            WebClick("PopUpMonth");
            WebClick("PopUpDate");
            Thread.sleep(2000);
            WebClick("CreateSpecLeverButton");
            System.out.println("New Spec Lever Details are entered");
            Allure.step("New Spec Lever Details are entered");
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Method Name: TimeLine
    //Description: common method for Timeline tab
    public static void TimeLine() throws InterruptedException {
        try {
            System.out.println("Creating Milestones");
            Allure.step("Creating Milestones");
            //click on TimeLine tab
            WebClick("TimeLine");
            //until create milestone is located
            WaitForPresenceOfElementLocated("CreateMileStone");
            //click on the create milstone
            WebClick("CreateMileStone");
            Thread.sleep(5000);
            WebClick("CreateMileStoneInitialDate");
            Thread.sleep(1000);
            WebClick("PopUpYearDuration");
            WebClick("PopUpYearSelect");
            WebClick("PopUpYear");
            WebClick("PopUpMonth");
            WebClick("PopUpDate");
            Thread.sleep(1000);
            WebSend("MileStoneName", MileStoneNameValue);
            WebClick("MileStoneNextButton");
            System.out.println("MileStone is created!");
            Allure.step("MileStone is created!");
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Method Name: Tasks
    //Description: common method for Tasks tab
    public static void Tasks() {
        try {

            //click on Tasks
            WebClick("Tasks");
            System.out.println("Entering all Details of New Task");
            Allure.step("Entering all Details of New Task");
            //until New Task button is located
            Wait1();
            WaitForPresenceOfElementLocated("NewTaskButton");
            Wait1();
            //click on New Task button
            WebClick("NewTaskButton");
            //Until the title text "Provide details for the new task" is located
            Wait2();
            WaitForPresenceOfElementLocated("NewTaskTileText");
            WebSend("TaskName", TaskValue);
            WebClick("CreateTaskButton");
            System.out.println("New Task is created");
            Allure.step("New Task is created");
            Wait2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Method Name: Attachments
    //Description: common method for Attachments tab
    public static void Attachments() {
        try {
            //click on Attachments
            WebClick("Attachments");
            System.out.println("Attachment is successful");
            Allure.step("Attachment is successful");
        } catch (Exception e) {
            System.out.println("Element click intercepted");
        }
    }

    //Method Name: BusinessPartnerAccess
    //Description: common method for BusinessPartnerAccess tab
    public static void BusinessPartnerAccess() {
        try {
            //click on Business Partner access
            WebClick("BusinessPartner");

        } catch (Exception e) {
            System.out.println("Element click intercepted");
        }
    }

    //Method Name: ProPlanCreateSourcingBundle
    //Description: method for creating sourcing bubdle
    public static void ProPlanCreateSourcingBundle() {
        try {
            //click on My FTP
            WebClick("MyFTP");
            WaitForPresenceOfElementLocated("CreateSourcingBundleTile");
            //click on create sourcing bundle
            WebClick("CreateSourcingBundle");
            System.out.println("Create sourcing bundle button is clicked");
            String ParentWindow = driver.getWindowHandle();
            Set<String> allWindowHandles = driver.getWindowHandles();
            Iterator<String> iterator = allWindowHandles.iterator();

            while (iterator.hasNext()) {
                ParentWindow = iterator.next();
                String ChildWindow = iterator.next();
                if (!ParentWindow.equals(ChildWindow)) {
                    driver.switchTo().window(ChildWindow);
                    //until the Authenticate pop up is located
                    Thread.sleep(10000);
                    WaitForPresenceOfElementLocated("AuthenticationPopUp");
                    WebSend("AuthenticationPopUp", Authentication);
                    WebClick("AuthenticationPopUpOkButton");
                    //enter mandatory details in create sourcing bundle
                    WebSend("CreateSourcingBundleTitle", SourcingBundleTitle);
                    System.out.println("Sourcing bundle title is created");
                    Allure.step("Sourcing bundle title is created");
                    WebClick("CommodityCodeField");
                    //until commodity code pop up - item - 0000 field located
                    WaitForPresenceOfElementLocated("CommodyCodeDummy");
                    //Click on the dummy commodity code
                    WebClick("CommodyCodeDummy");
                    System.out.println("commodity code is selected");
                    Allure.step("commodity code is selected");
                    //until save button is located
                    WaitForPresenceOfElementLocated("CreateSourcingBundleSaveButton");
                    //click on save
                    WebClick("CreateSourcingBundleSaveButton");
                    System.out.println("save button clicked");
                    Allure.step("Sourcing Bundle is Created !");

                    GeneratedId = GeneratedSourcingBundleID("IDAlertMsg");
                    System.out.println("The Sourcing Bundle Id is :" + GeneratedId);
                    Allure.step("The Sourcing bundle ID is :" + GeneratedId);
                    //until search table - Items is located
                    //Thread.sleep(2000);
                    WaitForPresenceOfElementLocated("SearchItemsTable");
                    WebSend("SearchSourcingBundleField", GeneratedId);
                    WebClick("SearchSourcingBundleIcon");
                    WaitForPresenceOfElementLocated("SourcingBundleStatus");
                    String ActualStatus = WebGetText("SourcingBundleStatus");
                    try {
                        Assert.assertEquals(ExpectedStatus, ActualStatus);
                        System.out.println("The status of the Sourcing bundle is active");
                        Allure.step("The status of the Sourcing bundle is active");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    driver.close();
                }
                driver.switchTo().window(ParentWindow);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Method Name : ImplementationLevel
    //Description : This method displays the dropdown of Implementation Levels
    public static void ImplementationLevel() {
        try {
            //click on overview tab
            WebClick("Overview");
            //Thread.sleep(2000);
            WaitForElementTovisibile("ImplementationLevelField");
            //IL - implementationlevel field
            MouseHover("ImplementationLevelField");
            //Thread.sleep(1000);
            WaitForElementTovisibile("ImplementationLevelEditIcon");
            MouseHover("ImplementationLevelEditIcon");
            //Thread.sleep(1000);
            WebClick("ImplementationLevelEditIcon");
            //Thread.sleep(2000);
            WaitForElementTovisibile("ImplementationLevelDropdowns");
            WebClick("ImplementationLevelDropdowns");
            //Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Method Name: MySourcingBundle
    //Description: method for IL0
    public static void SourcingBundleIL0() throws InterruptedException {
        try {
            //click on My FTP
            WebClick("MyFTP");
            WaitForPresenceOfElementLocated("MySourcingBundles");
            WebClick("MySourcingBundles");
            WaitForPresenceOfElementLocated("IL0DraftTable");
            Scroll("IL0DraftTable");
            Thread.sleep(2000);
            if (!GetWebElement("IL0TableSearch").isDisplayed()) {
                WebClick("IL0TableSearchIcon");
                Thread.sleep(2000);
                WebSend("IL0TableSearch", GeneratedId);
                Thread.sleep(2000);
                WebClick("IL0SearchEnterButton");
                Thread.sleep(2000);
            } else {
                WebClick("IL0TableSearchIcon");
                Thread.sleep(2000);
                WebClick("IL0TableSearchIcon");
                Thread.sleep(2000);
                WebSend("IL0TableSearch", GeneratedId);
                Thread.sleep(2000);
                WebClick("IL0SearchEnterButton");
                Thread.sleep(2000);
            }
            int ColumnCount = TableCoulmns("IL0DraftTableColumns").size();
            System.out.println("The number of columns in My Open FTP Sourcing Bundles in IL 0 = Draft are : " + ColumnCount);
            List<WebElement> MySBTableRows = TableRows("IL0DraftTableRows");
            int RowCount = TableRows("IL0DraftTableRows").size();
            System.out.println("The number of rows in My Open FTP Sourcing Bundles in IL 0 = Draft are : " + RowCount);
            String ActualMySBId = GeneratedId;
            for (WebElement MySBId : MySBTableRows) {
                if (MySBId.getText().contains(ActualMySBId)) {
                    System.out.println(MySBId.getText());
                    MySBId.click();
                    break;
                }
            }
            System.out.println("Implementation Level-0");
            Allure.step("Implementation Level-0");
            System.out.println("Entering Performance Measurement details");
            Allure.step("Entering Performance Measurement details");
            //until performance measurement tab is located
            WaitForPresenceOfElementLocated("PerformanceMeasurementTab");
            //click on performance measurement
            WebClick("PerformanceMeasurementTab");
            //until local currency is located
            WaitForPresenceOfElementLocated("LocalCurrencyField");
            MouseHover("LocalCurrencyField");
            //Thread.sleep(2000);
            WaitForElementTovisibile("LocalCurrencyEditField");
            MouseHover("LocalCurrencyEditField");
            WebClick("LocalCurrencyEditField");
            //Thread.sleep(2000);
            WaitForElementTovisibile("LocalCurrencyDropDown");
            WebClick("LocalCurrencyDropDown");
            //Thread.sleep(2000);
            WaitForElementTovisibile("LocalCurrencySave");
            WebClick("LocalCurrencySave");
            Thread.sleep(2000);
            SupplierSet();
            SpecLevers();
            TimeLine();
            Tasks();
            Attachments();
            BusinessPartnerAccess();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Method Name: ScourcingBundleIL1
    //DESCRIPTION: Method for IL1
    public static void ScourcingBundleIL1() throws InterruptedException {
        try {
            ImplementationLevel();
            //Thread.sleep(2000);
            System.out.println("Implementation Level -1");
            Allure.step("Implementation Level -1");
            WaitForElementTovisibile("ImplementationLevel1");
            WebClick("ImplementationLevel1");
            //Thread.sleep(2000);
            WaitForElementTovisibile("ImplementationLevelSaveButton");
            WebClick("ImplementationLevelSaveButton");
            Thread.sleep(2000);
            Scroll("IL1PlanningDataText");
            Thread.sleep(1000);
            System.out.println("Entering Overview Details");
            Allure.step("Entering Overview Details");
            // MouseHover("IL1FTPRegionField");
            //Thread.sleep(1000);
            WaitForElementTovisibile("IL1FTPEditIconField");
            MouseHover("IL1FTPEditIconField");
            Thread.sleep(1000);
            WebClick("IL1FTPEditIconField");
            //Thread.sleep(1000);
            WaitForElementTovisibile("IL1FTPRegionTextField");
            WebClick("IL1FTPRegionTextField");
            WaitForElementTovisibile("IL1FTPRegionDropdown");
            WebClick("IL1FTPRegionDropdown");
            //Thread.sleep(2000);
            WaitForElementTovisibile("IL1FTPSaveButton");
            WebClick("IL1FTPSaveButton");
            Thread.sleep(2000);
            MouseHover("IL1MainLegalEntityField");
            //Thread.sleep(1000);
            WaitForElementTovisibile("IL1MainLegalEntityEditIconField");
            MouseHover("IL1MainLegalEntityEditIconField");
            Thread.sleep(1000);
            WebClick("IL1MainLegalEntityEditIconField");
            //Thread.sleep(1000);
            WaitForElementTovisibile("IL1MainLegalEntityTextField");
            WebClick("IL1MainLegalEntityTextField");
            WaitForElementTovisibile("IL1MainLegalEntityDropdown");
            WebClick("IL1MainLegalEntityDropdown");
            //Thread.sleep(2000);
            WaitForElementTovisibile("Il1MainLegalEntitySaveButton");
            WebClick("Il1MainLegalEntitySaveButton");
            Thread.sleep(2000);
            MouseHover("IL1InternalBusinessPartnerField");
            //Thread.sleep(1000);
            WaitForElementTovisibile("IL1InternalBusinessPartnerEditIcon");
            MouseHover("IL1InternalBusinessPartnerEditIcon");
            Thread.sleep(1000);
            WebClick("IL1InternalBusinessPartnerEditIcon");
            //Thread.sleep(1000);
            WaitForElementTovisibile("IL1InternalBusinessPartnerTextField");
            WebClick("IL1InternalBusinessPartnerTextField");
            WaitForElementTovisibile("IL1InternalBusinessPartnerDropdown");
            WebClick("IL1InternalBusinessPartnerDropdown");
            //Thread.sleep(2000);
            WaitForElementTovisibile("IL1InternalBusinessPartnerSave");
            WebClick("IL1InternalBusinessPartnerSave");
            Thread.sleep(2000);
            Scroll("IL1ValidityTo");
            System.out.println("Planing Data Fields :");
            Allure.step("Planing Data Fields :");
            MouseHover("IL1DetailedLevel");
            Thread.sleep(1000);
            //WaitForElementTovisibile("IL1IDLEditIcon");
            MouseHover("IL1IDLEditIcon");
            Thread.sleep(1000);
            WebClick("IL1IDLEditIcon");
            Thread.sleep(1000);
            //WaitForElementTovisibile("IL1DLField")
            WebClick("IL1DLField");
            //WaitForElementTovisibile("ILDLDropdownText")
            WebClick("ILDLDropdownText");
            Thread.sleep(2000);
            //WaitForElementTovisibile("IL1DLSave");
            WebClick("IL1DLSave");
            Thread.sleep(2000);
            MouseHover("IL1BusinessType");
            Thread.sleep(1000);
            //WaitForElementTovisibile("IL1IBTEditIcon");
            MouseHover("IL1IBTEditIcon");
            Thread.sleep(1000);
            WebClick("IL1IBTEditIcon");
            Thread.sleep(1000);
            //WaitForElementTovisibile("IL1BTField")
            WebClick("IL1BTField");
            //WaitForElementTovisibile("ILBTDropdownText")
            WebClick("ILBTDropdownText");
            Thread.sleep(2000);
            //WaitForElementTovisibile("IL1BTSave");
            WebClick("IL1BTSave");
            Thread.sleep(2000);
            MouseHover("IL1ValidityFrom");
            Thread.sleep(1000);
            //WaitForElementTovisibile("IL1VFEditIcon");
            MouseHover("IL1VFEditIcon");
            Thread.sleep(1000);
            WebClick("IL1VFEditIcon");
            Thread.sleep(1000);
            //WaitForElementTovisibile("IL1VFField")
            WebClick("IL1VFField");
            Thread.sleep(1000);
            WebClick("YearDuration");
            WebClick("YearSelect");
            WebClick("Year");
            WebClick("Month");
            WebClick("Date");
            Thread.sleep(1000);
            //WaitForElementTovisibile("IL1VFSave");
            WebClick("IL1VFSave");
            Thread.sleep(2000);
            MouseHover("IL1ValidityTo");
            Thread.sleep(1000);
            //WaitForElementTovisibile("IL1IVTEditIcon");
            MouseHover("IL1IVTEditIcon");
            Thread.sleep(1000);
            WebClick("IL1IVTEditIcon");
            Thread.sleep(1000);
            //WaitForElementTovisibile("IL1VTField")
            WebClick("IL1VTField");
            Thread.sleep(1000);
            WebClick("YearDuration");
            WebClick("YearSelect");
            WebClick("Year");
            WebClick("Month");
            WebClick("Date");
            Thread.sleep(1000);
            //WaitForElementTovisibile("IL1VTSave");
            WebClick("IL1VTSave");
            Thread.sleep(2000);
            MouseHover("IL1ApprovalDate");
            Thread.sleep(1000);
            //WaitForElementTovisibile("IL1ADEditIcon");
            MouseHover("IL1ADEditIcon");
            Thread.sleep(1000);
            WebClick("IL1ADEditIcon");
            Thread.sleep(1000);
            //WaitForElementTovisibile("IL1ADField")
            WebClick("IL1ADField");
            Thread.sleep(1000);
            WebClick("YearDuration");
            WebClick("YearSelect");
            WebClick("Year");
            WebClick("Month");
            WebClick("Date");
            Thread.sleep(1000);
            //WaitForElementTovisibile("IL1ADSave");
            WebClick("IL1ADSave");
            Thread.sleep(2000);
            System.out.println("Filling the details of assignment fields ");
            MouseHover("IL1TypeOfCost");
            Thread.sleep(1000);
            //WaitForElementTovisibile("IL1TCEditIcon");
            MouseHover("IL1TCEditIcon");
            Thread.sleep(1000);
            WebClick("IL1TCEditIcon");
            Thread.sleep(1000);
            //WaitForElementTovisibile("IL1TCField")
            WebClick("IL1TCField");
            //WaitForElementTovisibile("IL1TCDropdownText")
            WebClick("IL1TCDropdownText");
            Thread.sleep(2000);
            //WaitForElementTovisibile("IL1TCSave");
            WebClick("IL1TCSave");
            Thread.sleep(2000);
            MouseHover("IL1CompetitiveBid");
            Thread.sleep(1000);
            //WaitForElementTovisibile("IL1CBEditIcon");
            MouseHover("IL1CBEditIcon");
            Thread.sleep(1000);
            WebClick("IL1CBEditIcon");
            Thread.sleep(1000);
            //WaitForElementTovisibile("IL1CBField")
            WebClick("IL1CBField");
            //WaitForElementTovisibile("IL1CBDropdownText")
            WebClick("IL1CBDropdownText");
            Thread.sleep(2000);
            //WaitForElementTovisibile("IL1CBSave");
            WebClick("IL1CBSave");
            Thread.sleep(2000);
            MouseHover("IL1PPB");
            Thread.sleep(1000);
            //WaitForElementTovisibile("IL1PPbEditIcon");
            MouseHover("IL1PPbEditIcon");
            Thread.sleep(1000);
            WebClick("IL1PPbEditIcon");
            Thread.sleep(1000);
            //WaitForElementTovisibile("IL1PPBField")
            WebClick("IL1PPBField");
            //WaitForElementTovisibile("IL1PPBDropdownText")
            WebClick("IL1PPBDropdownText");
            Thread.sleep(2000);
            //WaitForElementTovisibile("IL1PPBSave");
            WebClick("IL1PPBSave");
            Thread.sleep(2000);
            System.out.println("Filling the details of Divisions fields :");
            Scroll("IL1DivisionScroll");
            MouseHover("IL1DaimlerTrucks");
            Thread.sleep(1000);
            //WaitForElementTovisibile("IL1DTEditIcon");
            MouseHover("IL1DTEditIcon");
            Thread.sleep(1000);
            WebClick("IL1DTEditIcon");
            Thread.sleep(1000);
            //WaitForElementTovisibile("IL1DTField")
            WebSend("IL1DTField", "100");
            Thread.sleep(1000);
            //WaitForElementTovisibile("IL1DTSave");
            WebClick("IL1DTSave");
            Thread.sleep(2000);
            MouseHover("IL1DaimlerBuses");
            Thread.sleep(1000);
            //WaitForElementTovisibile("IL1DBEditIcon");
            MouseHover("IL1DBEditIcon");
            Thread.sleep(1000);
            WebClick("IL1DBEditIcon");
            Thread.sleep(1000);
            //WaitForElementTovisibile("IL1DBField")
            WebSend("IL1DBField", "0");
            Thread.sleep(1000);
            //WaitForElementTovisibile("IL1DBSave");
            WebClick("IL1DBSave");
            Thread.sleep(2000);
            System.out.println("Entering Performance Measurement Details");
            // scrolling to performance measurement
            MouseHover("PerformanceTab");
            Thread.sleep(1000);
            //WaitForElementTovisibile("PerformanceTab");
            WebClick("PerformanceTab");
            Thread.sleep(2000);
            MouseHover("IL1PreviousPrice");
            Thread.sleep(1000);
            //WaitForElementTovisibile("IL1PPEditIcon");
            MouseHover("IL1PPEditIcon");
            Thread.sleep(1000);
            WebClick("IL1PPEditIcon");
            Thread.sleep(1000);
            //WaitForElementTovisibile("IL1PPField")
            WebSend("IL1PPField", "100");
            Thread.sleep(1000);
            //WaitForElementTovisibile("IL1PPSave");
            WebClick("IL1PPSave");
            Thread.sleep(2000);
            Scroll("PerformanceMeasurementBLScroll");
            Thread.sleep(1000);
            MouseHover("IL1VolumeEffect");
            Thread.sleep(1000);
            //WaitForElementTovisibile("IL1VEEditIcon");
            MouseHover("IL1VEEditIcon");
            Thread.sleep(1000);
            WebClick("IL1VEEditIcon");
            Thread.sleep(1000);
            //WaitForElementTovisibile("IL1VEField")
            WebSend("IL1VEField", "100");
            Thread.sleep(1000);
            //WaitForElementTovisibile("IL1VESave");
            WebClick("IL1VESave");
            Thread.sleep(2000);
            MouseHover("IL1RDInCost");
            Thread.sleep(1000);
            //WaitForElementTovisibile("IL1RDCEditIcon");
            MouseHover("IL1RDCEditIcon");
            Thread.sleep(1000);
            WebClick("IL1RDCEditIcon");
            Thread.sleep(1000);
            //WaitForElementTovisibile("IL1RDCField")
            WebSend("IL1RDCField", "0");
            Thread.sleep(1000);
            //WaitForElementTovisibile("IL1RDCSave");
            WebClick("IL1RDCSave");
            Thread.sleep(2000);
            Scroll("PerformanceMeasurementFieldScroll");
            MouseHover("IL1MarketEnvironment");
            Thread.sleep(1000);
            //WaitForElementTovisibile("IL1MEEditIcon");
            MouseHover("IL1MEEditIcon");
            Thread.sleep(1000);
            WebClick("IL1MEEditIcon");
            Thread.sleep(1000);
            //WaitForElementTovisibile("IL1MEField")
            WebSend("IL1MEField", "0");
            Thread.sleep(1000);
            //WaitForElementTovisibile("IL1MESave");
            WebClick("IL1MESave");
            Wait2();
            Refresh();
            // MouseHover("SupplierSet");
            // Thread.sleep(2000);
            // SupplierSet();
            // SpecLevers();
            // TimeLine();
            // Tasks();
            System.out.println("No new task is planned");
            Attachments();
            BusinessPartnerAccess();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Method Name : SourcingBundleIL2
    //Description : Method for IL2
    public static void SourcingBundleIL2() throws InterruptedException {
        try {
            ImplementationLevel();
            System.out.println("Implementation Level-2");
            Allure.step("Implementation Level-2");
            WaitForElementTovisibile("ImplementationLevel2");
            WebClick("ImplementationLevel2");
            //Thread.sleep(2000);
            WaitForElementTovisibile("ImplementationLevelSaveButton");
            WebClick("ImplementationLevelSaveButton");
            Wait2();

            Phase(RFQ);
            System.out.println("The phase of spec lever is RFQ");
            Allure.step("The phase of spec lever is RFQ ");
            Wait2();
            //Tasks();
            Attachments();
            BusinessPartnerAccess();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Method Name : SourcingBundleIL3
    //Description : Method for IL3
    public static void SourcingBundleIL3() throws InterruptedException {
        try {
            ImplementationLevel();
            System.out.println("Implementation  Level-3");
            Allure.step("Implementation  Level-3");
            WaitForElementTovisibile("ImplementationLevel3");
            WebClick("ImplementationLevel3");
            //Thread.sleep(2000);
            WaitForElementTovisibile("ImplementationLevelSaveButton");
            WebClick("ImplementationLevelSaveButton");
            Thread.sleep(2000);
            StatusCheckBox(Quote);
            System.out.println("The supplier has provided the Quote");
            Allure.step("The supplier has provided the Quote");
            Phase(POST_RFQ);
            System.out.println("The phase of spec lever is Post RFQ");
            Allure.step("The phase of spec lever is Post RFQ ");

            Tasks();
            Attachments();
            BusinessPartnerAccess();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Method Name : SourcingBundleIL4
    //Description : Method for IL4
    public static void SourcingBundleIL4() throws InterruptedException {
        try {
            ImplementationLevel();
            System.out.println("Implementation  Level-4");
            Allure.step("Implementation  Level-4");
            WaitForElementTovisibile("ImplementationLevel4");
            WebClick("ImplementationLevel4");
            //Thread.sleep(2000);
            WaitForElementTovisibile("ImplementationLevelSaveButton");
            WebClick("ImplementationLevelSaveButton");
            Thread.sleep(2000);
            //************************
            //until supplier set overview table is located
            WaitForPresenceOfElementLocated("SupplierSetOverview");

            StatusDropDown(Approval);
            System.out.println("The status of spec lever is 'In approval'");
            Allure.step("The status of spec lever is 'In approval' ");

            TimeLine();
            Tasks();
            Attachments();
            BusinessPartnerAccess();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Method Name : SourcingBundleIL
    //Description : Method for IL5
    public static void SourcingBundleIL5() throws InterruptedException {
        try {
            ImplementationLevel();
            System.out.println("Implementation  Level-5");
            Allure.step("Implementation  Level-5");
            WaitForElementTovisibile("ImplementationLevel5");
            WebClick("ImplementationLevel5");

            WaitForElementTovisibile("ImplementationLevelSaveButton");
            WebClick("ImplementationLevelSaveButton");
            Wait2();


            Awarded();

            //until supplier set overview table is located
            WaitForPresenceOfElementLocated("SupplierSetOverview");

            StatusDropDown(Implemented);
            System.out.println("The supplier has been Awarded");
            Allure.step("The supplier has been Awarded");

            Tasks();
            Attachments();
            BusinessPartnerAccess();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Method Name : SourcingBundleIL6
    //Description : Method for IL6 - cancelling sourcing bundle

    /*public static void SourcingBundleIL6() throws InterruptedException {
        try {
            ImplementationLevel();
            WaitForElementTovisibile("ImplementationLevel6");
            WebClick("ImplementationLevel6");
            //Thread.sleep(2000);
            WaitForElementTovisibile("ImplementationLevelSaveButton");
            WebClick("ImplementationLevelSaveButton");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }*/

    //Method Name : Logout
    //Description : This method is used to logout of the proPlan application
    public static void Logout() throws InterruptedException {
        try {
            Thread.sleep(5000);
            WebClick("Icon");
            Thread.sleep(1000);
            WebClick("LogOut");
            System.out.println("Successfully Logged Out! ");
            Allure.step("Successfully Logged Out!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Method Name : CloseProPlanApplication
    //Description : This method is used to close the ProPlan Application
    public static void CloseProPlanApplication() {
        try {
            System.out.println(" E2E Customer Journey is Successful! ");
            Allure.step(" E2E Customer Journey is Successful! ");
            CloseBrowser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*******************************************************************************/

    static String applicationName;

    /* Application : CERTUS
     * Method Name : validateLogin
     * Description : This method is used to validate the successful login in application
     * Parameters  : fileName, scrNo
     * Author      : Aastha Uppal
     * Date        : 10/18/2022
     */
    public static void validateLogin(String fileName, String srcNo) {
        try {
            JSONObject data = FileUtil.getDataFromJsonFile(fileName, srcNo);
            applicationName = (String) data.get("applicationName");
            WaitForPresenceOfElementLocated("LoginHeader");
            String appNameOnScreen = WebGetText("LoginHeader");
            System.out.println(appNameOnScreen);
            Allure.step("Validating Login to the application");
            if (appNameOnScreen.equalsIgnoreCase(applicationName)) {
                Allure.step("Successfully logged in to the application : " + applicationName);
                System.out.println("successful login");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Allure.step("Login to the application unsuccessful : " + applicationName);
        }
    }

    /* Application : CERTUS
     * Method Name : navigateToPartNo_OpenSupplierTasks
     * Description : This method is used to navigate to open supplier tasks under tasks tab
     * Parameters  : -
     * Author      : Aastha Uppal
     * Date        : 10/19/2022
     */
    public static void navigateToPartNo_OpenSupplierTasks() {
        try {
            WebClick("TasksBtn");
            WebClick("PartNumTab");
            WaitForPresenceOfElementLocated("OpenSupplTasksTab");
            Thread.sleep(5000);
            WebClick("OpenSupplTasksTab");
            Allure.step("Navigation successful");
            System.out.println("Navigation successful");

        } catch (Exception e) {
            e.printStackTrace();
            Allure.step("Navigation unsuccessful");
        }
    }

    /* Application : CERTUS
     * Method Name : searchPartNumber
     * Description : This method is used to search part number and select it  from the list
     * Parameters  : fileName, srcNo
     * Author      : Aastha Uppal
     * Date        : 10/19/2022
     */
    public static void searchPartNumber(String fileName, String srcNo) {
        try {
            JSONObject data = FileUtil.getDataFromJsonFile(fileName, srcNo);
            String partNo = (String) data.get("partNumber");
            WaitForPresenceOfElementLocated("searchField");
            Thread.sleep(5000);
            WebSend("searchField", partNo);
            Thread.sleep(1000);
            WebClick("searchIcon");
            Thread.sleep(6000);
            WebClick("selectTask");
            Thread.sleep(3000);
            WebClick("assignBtn");
            Allure.step("Search successful");
            Thread.sleep(3000);
            if (GetWebElement("assignDocCB").isSelected()) {
                System.out.println("checked");
                Thread.sleep(3000);
                WebClick("assignDocBtn");
            } else {
                System.out.println("unchecked");
                WebClick("assignDocCB");
                WebClick("assignDocBtn");
            }

            Allure.step("Assigning Document");

        } catch (Exception e) {
            e.printStackTrace();
            Allure.step("Search unsuccessful");
        }
    }

    /* Application : CERTUS
     * Method Name : addDocumentToTask
     * Description : This method is used to upload document to task
     * Parameters  : fileName, srcNo
     * Author      : Aastha Uppal
     * Date        : 10/20/2022
     */
    public static void addDocumentToTask(String fileName, String srcNo) {
        try {
            JSONObject data = FileUtil.getDataFromJsonFile(fileName, srcNo);
            String documentTitle = (String) data.get("documentTitle");
            String documentName = (String) data.get("documentName");
            WaitForPresenceOfElementLocated("documentTitle");
            //add doc title
            Allure.step("Uploading Document");
            WebSend("docTitle", documentTitle);
            WebClick("docDropZone");
            Thread.sleep(6000);

            //click on folder button
            CommonPage.setTextToClipBoard(System.getProperty("user.dir") + Constants.testArtifactsPath + documentName);
            Thread.sleep(4000);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            Thread.sleep(2000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            //click create button

            WaitForPresenceOfElementLocated("createDocBtn");
            Thread.sleep(6000);
            WebClick("createDocBtn");
            Thread.sleep(3000);
            if (GetWebElement("docSuccessToast").isDisplayed()) {
                Allure.step("Uploaded Document successfully");
            }

        } catch (Exception e) {
            e.printStackTrace();
            Allure.step("Upload unsuccessful");
        }
    }


    /* Application : DSP
     * Method Name : LoginToPortal
     * Description : This method is used to validate the login in application
     * Parameters  : sFileName, sFileNo
     * Author      : Chaitanya
     * Date        : 10/20/2022
     */
    public static void LoginToPortal(String sFileName, String sFileNo) {
        try {

            JSONObject data = FileUtil.getDataFromJsonFile(sFileName, sFileNo);
            String DSPurl = (String) data.get("url");
            String DSPloginid = (String) data.get("loginId");
            String DSPPwd = (String) data.get("Password");
            Launch(DSPurl);
            System.out.println("User navigates to DSP url");
            Allure.step("User navigates to DSP url", Status.PASSED);
            Sync(8000);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("document.querySelector('#usercentrics-root').shadowRoot.querySelector('[data-testid=\"uc-accept-all-button\"]').click()");
            Sync(5000);
            WebClick("DSPSignIn");
            //Clicks on Sign in Button
            Sync(2000);
            WaitForPresenceOfElementLocated("DSPUserId");
            WebSend("DSPUserId", DSPloginid);
            //UserId is entered
            WebClick("DSPNextButton");
            Sync(1000);
            WebSend("SignInPassword", DSPPwd);
            //Password is entered
            WebClick("DSPLoginSubmit");
            //Clicks on Login Button
            String Welcome_text = WebGetText("Welcome");
            Assert.assertEquals(welcometext, Welcome_text);
            System.out.println("Login Successful");//need to add validation
            Allure.step("User logged to DSP successful");
            Sync(3000);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    /* Application : DSP
     * Method Name : ValidateFields_on_homepage
     * Description : This method is used to validate the fields on homepage
     * Author      : Chaitanya
     * Date        : 10/20/2022
     */
    public static void HomepageField() {
        try {
            validateElementExistence("logo", "Daimler Logo");
            String HomePage_Field = WebGetText("Home");
            Assert.assertEquals(Expected_field2, HomePage_Field);
            System.out.println("The HomePage_Field is present");
            String title = driver.getTitle();
            System.out.println(title);
            Allure.step("The HomePage_Field is validated");

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void Procurement() {
        try {
            String Procurement_Field = WebGetText("Procurement");
            Assert.assertEquals(Expected_field3, Procurement_Field);
            System.out.println("The Procurement_Field is present");
            WebClick("Procurement");
            String Procurement_page = driver.getTitle();
            Assert.assertEquals(Procurement_Page, Procurement_page);
            System.out.println("Successfully navigated to Procurement page");
            validateElementExistence("DTNA", "DTNA");
            validateElementExistence("DDC", "DDC");
            validateElementExistence("Daimler Trucks do Brasil", "Daimler Trucks do Brasil");
            validateElementExistence("DVCM", "DVCM");
            validateElementExistence("Procurement", "Procurement");
            WebClick("Prrocurement");
            String NewProcurement_page = driver.getTitle();
            System.out.println(NewProcurement_page);
            Assert.assertEquals(Procurement_Page, NewProcurement_page);
            //            Scroll("ll");
            validateElementExistence("ll", "Description");
            driver.navigate().back();
            Allure.step("The Procurement_Field is validated", Status.PASSED);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Collaboration() {
        try {
            String Collaboration_Field = WebGetText("Collaboration");
            Assert.assertEquals(Expected_field4, Collaboration_Field);
            System.out.println("The Collaboration_Field is present");
            WebClick("Collaboration");
            String Collaboration_page = driver.getTitle();
            Assert.assertEquals(Collaboration_Page, Collaboration_page);
            System.out.println("Successfully navigated to Collaboration page");
            validateElementExistence("Production_and_Logistics", "Production and Logistics");
            validateElementExistence("After_Sales", "After Sales");
            validateElementExistence("Accounting", "Accounting");
            validateElementExistence("Standards_and_Requirements", "Standards and Requirements");
            validateElementExistence("collaboration", "Collaboration");
            WebClick("collaboration");
            String NewCollaboration_page = driver.getTitle();
            Assert.assertEquals(Collaboration_Page, NewCollaboration_page);
            driver.navigate().back();
            Allure.step("The Collaboration_Field is validated", Status.PASSED);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Sustainability() {
        try {
            String Sustainability_Field = WebGetText("Sustainability");
            Assert.assertEquals(Expected_field5, Sustainability_Field);
            System.out.println("The Sustainability_Field is present");
            WebClick("Sustainability");
            String Sustainability_page = driver.getTitle();
            Assert.assertEquals(Sustainability_Page, Sustainability_page);
            System.out.println("Successfully navigated to Sustainability page");
            validateElementExistence("Standards", "Standards and Requirements");
            validateElementExistence("Supplier_Reviews", "Supplier Reviews");
            validateElementExistence("sustainability", "Sustainability");
            WebClick("sustainability");
            String NewSustainability_page = driver.getTitle();
            Assert.assertEquals(Sustainability_Page, NewSustainability_page);
            validateElementExistence("ll1", "Description");
            driver.navigate().back();
            Allure.step("The Sustainability_Field is validated", Status.PASSED);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void support() {
        try {
            String Support_Field = WebGetText("Support");
            Assert.assertEquals(Expected_field6, Support_Field);
            System.out.println("The Support_Field is present");
            WebClick("Support");
            String Support_page = driver.getTitle();
            Assert.assertEquals(Help_Page, Support_page);
            System.out.println("Successfully navigated to Support page");
            driver.navigate().back();
            Allure.step("The Support_Field is validated", Status.PASSED);
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Logoutsupplierportal() {
        try {
            Sync(5000);
            WebClick("Profile");
            Sync(2000);
            WebClick("Sign_out");
            String textdisplayed = WebGetText("log_out");
            System.out.println(textdisplayed);
            Assert.assertEquals(logout, textdisplayed);
            System.out.println("Successfully Logged Out!");
            Allure.step("Successfully logged out", Status.PASSED);
            Sync(2000);
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* Application : DSP
     * Method Name : NegativeLogin
     * Description : This method is used to check login is unsuccessful using invalid credentials
     * Author      : Chaitanya
     * Date        : 11/02/2022
     */
    public static void NegativeLogin(String sFileName, String sFileNo) {

        try {
            JSONObject data = FileUtil.getDataFromJsonFile(sFileName, sFileNo);
            String DSPurl = (String) data.get("url");
            String DSPloginid = (String) data.get("loginId");
            String DSPPwd = (String) data.get("Password");
            Launch(DSPurl);
            System.out.println("User navigates to DSP url");
            Allure.step("User navigates to DSP url");
            Thread.sleep(10000);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("document.querySelector('#usercentrics-root').shadowRoot.querySelector('[data-testid=\"uc-accept-all-button\"]').click()");
            js.executeScript("document.querySelector('#usercentrics-root').shadowRoot.querySelector('[data-testid=\"uc-accept-all-button\"]').click()");
            Thread.sleep(5000);
            WebClick("DSPSignIn");
            //Clicks on Sign in Button
            Thread.sleep(2000);
            WaitForPresenceOfElementLocated("DSPUserId");
            WebSend("DSPUserId", DSPloginid);
            //UserId is entered
            WebClick("DSPNextButton");
            Thread.sleep(1000);
            WebSend("SignInPassword", DSPPwd);
            //Password is entered
            WebClick("DSPLoginSubmit");
            Thread.sleep(10000);
            WaitForElementTovisibile("Login_Error");
            WebElement Actual_Error1 = GetWebElement("Login_Error");
            String Actual_Error = Actual_Error1.getText();
            System.out.println(Actual_Error);
            Assert.assertEquals(Actual_Error, error);
            System.out.println("Login was not successful using Invalid Credentials!");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /* Application : DSP
     * Method Name : ValidateFields_on_homepage
     * Description : This method is used to validate the fields on homepage
     * Author      : Chaitanya
     * Date        : 11/02/2022
     */

    public static void Validate_subsidiaries() throws InterruptedException {
        try {
            Scroll("Freightliner_Logo");
            Thread.sleep(3000);
            WebElement Benz_Logo = GetWebElement("Benz");
            String ParentWindow = driver.getWindowHandle();
            System.out.println(ParentWindow);
            if (Benz_Logo.isDisplayed()) {
                System.out.println("Benz Icon is displayed");
                WebClick("Benz_Logo");
                Thread.sleep(3000);
                Set<String> allWindowHandles = driver.getWindowHandles();
                for (String Child : allWindowHandles) {
                    if (!Child.equals(ParentWindow)) {
                        driver.switchTo().window(Child);
                        Thread.sleep(10000);
//                        JavascriptExecutor js = (JavascriptExecutor) driver;
//                        js.executeScript("document.querySelector('#usercentrics-root').shadowRoot.querySelector('[data-testid='uc-accept-all-button']').click()");
                        WebClick("BENZ");
                        String BenzPage_Title = driver.getTitle();
                        System.out.println(BenzPage_Title);
                        Assert.assertEquals(BenzPage_Title, Actual_Title1);
                        System.out.println("Benz icon is validated");
                        driver.close();
                    }
                    driver.switchTo().window(ParentWindow);
                }
            }
            Thread.sleep(3000);
            WebElement Freightliner_Logo = GetWebElement("Freightliner_Logo");
            if (Freightliner_Logo.isDisplayed()) {
                System.out.println("Freightliner_Logo is displayed");
                WebClick("Logo");
                Thread.sleep(3000);
                Set<String> allWindowHandles = driver.getWindowHandles();
                for (String Child : allWindowHandles) {
                    if (!Child.equals(ParentWindow)) {
                        driver.switchTo().window(Child);
                        String Page_Title = driver.getTitle();
                        System.out.println(Page_Title);
                        Assert.assertEquals(Page_Title, Actual_Title2);
                        System.out.println("Freightliner icon is validated");
                        driver.close();
                    }
                    driver.switchTo().window(ParentWindow);
                }
            }
            Thread.sleep(5000);
            WebElement Fuso_Logo = GetWebElement("FUSO_Logo");
            Thread.sleep(3000);
            if (Fuso_Logo.isDisplayed()) {
                System.out.println("FUSO icon is displayed");
                WebClick("Fuso_Logo");
                Set<String> allWindowHandle = driver.getWindowHandles();
                for (String Child1 : allWindowHandle) {
                    if (!Child1.equals(ParentWindow)) {
                        driver.switchTo().window(Child1);
                        WaitForElementTovisibile("COOKIE");
                        WebClick("COOKIE");
                        String FUSOPage_Title = driver.getTitle();
                        System.out.println(FUSOPage_Title);
                        Assert.assertEquals(FUSOPage_Title, Actual_Title3);
                        System.out.println("Fuso icon is validated");
                        driver.close();
                    }
                    driver.switchTo().window(ParentWindow);
                }
            } else {
                System.out.println("Fuso icon is not displayed");
            }

            Thread.sleep(5000);
            WebElement WesternStar_Logo = GetWebElement("Western_Logo");
            Thread.sleep(3000);
            if (WesternStar_Logo.isDisplayed()) {
                System.out.println("WesternStar Logo is displayed");
                WebClick("WesternStar_Logo");
                Set<String> allWindowHandle = driver.getWindowHandles();
                for (String Child1 : allWindowHandle) {
                    if (!Child1.equals(ParentWindow)) {
                        driver.switchTo().window(Child1);
                        String WesternStarPage_Title = driver.getTitle();
                        System.out.println(WesternStarPage_Title);
                        Assert.assertEquals(WesternStarPage_Title, Actual_Title4);
                        System.out.println("Westernstar icon is validated");
                        driver.close();
                    }
                    driver.switchTo().window(ParentWindow);
                }
            }
            Thread.sleep(5000);
            WebElement Thomas_Logo = GetWebElement("Thomas");
            Thread.sleep(3000);
            if (Thomas_Logo.isDisplayed()) {
                System.out.println("Thomas Logo is displayed");
                WebClick("Thomas_Logo");
                Set<String> allWindowHandle = driver.getWindowHandles();
                for (String Child1 : allWindowHandle) {
                    if (!Child1.equals(ParentWindow)) {
                        driver.switchTo().window(Child1);
                        String ThomasPage_Title = driver.getTitle();
                        System.out.println(ThomasPage_Title);
                        Assert.assertEquals(ThomasPage_Title, Actual_Title5);
                        System.out.println(" Thomas icon is validated");
                        driver.close();
                    }
                    driver.switchTo().window(ParentWindow);
                }
            }
            Thread.sleep(5000);
            WebElement BharatBenz_Logo = GetWebElement("BharatBenz");
            Thread.sleep(3000);
            if (BharatBenz_Logo.isDisplayed()) {
                System.out.println("BharatBenz Icon is displayed");
                WebClick("BharatBenz_Logo");
                Set<String> allWindowHandle = driver.getWindowHandles();
                for (String Child1 : allWindowHandle) {
                    if (!Child1.equals(ParentWindow)) {
                        driver.switchTo().window(Child1);
                        String BharatBenz_Title = driver.getTitle();
                        System.out.println(BharatBenz_Title);
                        Assert.assertEquals(BharatBenz_Title, Actual_Title6);
                        System.out.println("BharatBenz icon is validated");
                        driver.close();
                    }
                    driver.switchTo().window(ParentWindow);
                }
            }
            Thread.sleep(5000);
            WebElement Setra_Logo = GetWebElement("Setra");
            Thread.sleep(3000);
            if (Setra_Logo.isDisplayed()) {
                System.out.println("Setra Icon is displayed");
                WebClick("Setra_Logo");
                Set<String> allWindowHandle = driver.getWindowHandles();
                for (String Child1 : allWindowHandle) {
                    if (!Child1.equals(ParentWindow)) {
                        driver.switchTo().window(Child1);
                        Thread.sleep(2000);
                        WebClick("Setracookie");
                        Thread.sleep(2000);
                        WebClick("Setra_close");
                        String SetraPage_Title = driver.getTitle();
                        System.out.println(SetraPage_Title);
                        Assert.assertEquals(SetraPage_Title, Actual_Title7);
                        System.out.println("Setra icon is validated");
                        driver.close();
                    }
                    driver.switchTo().window(ParentWindow);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void validate_other_topics() {

        try {
            Thread.sleep(5000);
            Scroll("otherTopics");
            List<WebElement> other_topics = driver.findElements(By.xpath("//*[text()='Other Topics/../../following-sibling::div//a[1]']"));
            for (WebElement ee1 : other_topics) {
                System.out.println(ee1.getText());
            }
            Thread.sleep(2000);
            WebClick("Pro_curement");
            String name = driver.getTitle();
            driver.navigate().back();
            Assert.assertEquals(name, Procurement_Page);
            System.out.println("Procument is validated");
            WebClick("Co_llaboration");
            String name1 = driver.getTitle();
            Assert.assertEquals(name1, Collaboration_Page);
            System.out.println("Collaboration is validated");
            driver.navigate().back();
            WebClick("Sus_tainability");
            String name2 = driver.getTitle();
            Assert.assertEquals(name2, Sustainability_Page);
            System.out.println("Sustainability is validated");
            driver.navigate().back();
            WebClick("Help");
            String name3 = driver.getTitle();
            Assert.assertEquals(name3, Help_Page);
            System.out.println("Help is validated");
            driver.navigate().back();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void validate_services() {

        try {
            Thread.sleep(3000);
            List<WebElement> _services = driver.findElements(By.xpath("//*[text()='Services']/../../following-sibling::div//a[1]"));
            for (WebElement ee : _services) {
                System.out.println(ee.getText());
            }
            WebClick("Supp_ort");
            String name = WebGetText("Email_Id");
            System.out.println("Emailid:" + name);
            String num = WebGetText("number");
            System.out.println(num);
            String Toll_num = WebGetText("Tollnum");
            System.out.println(Toll_num);
            WebClick("Closepopup");
            Thread.sleep(2000);
            WebClick("Downloads");
            String name1 = driver.getTitle();
            System.out.println(name1);
            driver.navigate().back();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void validate_HeaderItems(String sFileName, String sFileNo) {
        try {
            JSONObject data = FileUtil.getDataFromJsonFile(sFileName, sFileNo);
            String DSPurl = (String) data.get("url");
            Launch(DSPurl);
            System.out.println("User navigates to DSP url");
            Thread.sleep(8000);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("document.querySelector('#usercentrics-root').shadowRoot.querySelector('[data-testid=\"uc-accept-all-button\"]').click()");
            Thread.sleep(5000);
            WebElement Daimler_logo = driver.findElement(By.xpath("/html/body/div[3]/header/div[1]/div/a[2]/img[@class=\"logo-daimler-web logo-daimler-svg\"]"));
            if (Daimler_logo.isDisplayed()) {
                System.out.println("Daimler Logo is displayed");
            }
            validateElementExistence("Search_icon", "Search Icon");
            WebElement Search = GetWebElement("Search_icon");
            if (Search.isEnabled()) {
                System.out.println(" Search icon is enabled ");
                Thread.sleep(2000);
                WebClick("Search");
                WebClick("Close_icon");
            } else {
                System.out.println(" Search icon is  not enabled ");
            }
            validateElementExistence("Signin", "SIgnin Button");
            WebElement Sign_in = GetWebElement("Signin");
            if (Sign_in.isEnabled()) {
                System.out.println(" Sign_in is enabled ");
                WebClick("Sign_in");
                WebElement text = GetWebElement("Welcome");
                String textonpage = text.getText();
                System.out.println(textonpage);
                Assert.assertEquals(textonpage, siginverify);
                System.out.println("navigates to sigin page ");
            } else {
                System.out.println(" Sign_in is  not enabled ");
            }
            driver.navigate().back();
            Thread.sleep(2000);

            validateElementExistence("Language_Switch", "Language Switch");
            WebElement LanguageSwitch = GetWebElement("Language_Switch");
            if (LanguageSwitch.isEnabled()) {
                System.out.println(" Language Switch is enabled ");
                Thread.sleep(2000);
                WebClick("LanguageSwitch");

            } else {
                System.out.println(" Language Switch is  not enabled ");
            }
            validateElementExistence("Burger_icon", "Burger icon");
            WebElement Burgericon = GetWebElement("Burger_icon");
            if (Burgericon.isEnabled()) {
                System.out.println(" Burger icon is enabled ");
                WebClick("Burgericon");
                WebElement list = GetWebElement("burger_menu_list");
                String asscess_list = WebGetText("list");
                System.out.println("Burger menu options  are:\n" + asscess_list);
                Thread.sleep(3000);
                WebClick("Burgericon");
            } else {
                System.out.println(" Burger icon is  not enabled ");
            }


        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    static void Sync(int time) throws InterruptedException {
        Thread.sleep(time);
    }

}