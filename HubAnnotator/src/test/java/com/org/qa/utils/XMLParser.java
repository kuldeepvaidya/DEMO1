package com.org.qa.utils;

import io.cucumber.java.eo.Se;
import io.cucumber.java.sl.In;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

public class XMLParser {

    public LinkedHashMap<String,String> ReadObjectRepo(String functionname,String Attribute)
    {
        try{
            System.out.println("Read XML parser");
            String expression="";
            String FieldName;
            String locValue;
            String OR1="C:\\DEMO\\DEMO_FRM\\HubAnnotator\\src\\test\\resources\\OR\\OR.xml"; // OR path
            int val=0;
            InputStream  inputStream;

            ClassLoader classLoader = getClass().getClassLoader();

            System.out.println(System.getProperty("user.dir"));
            LinkedHashMap<String,String> hmObject =new LinkedHashMap<String,String>();

            DocumentBuilderFactory builderFactory =DocumentBuilderFactory.newInstance();
            inputStream=classLoader.getResourceAsStream("OR/OR.xml");

            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document xmlDocument = builder.parse(inputStream);

            XPath xPath= XPathFactory.newInstance().newXPath();

            System.out.println("**********************************");
            if(Attribute.length()==0) expression="/Browser/Function[@label='"+functionname+"']/Object";
            else expression="/Browser/Function[@label='"+functionname+"']/Object[@label='"+Attribute+"']";

            System.out.println(expression);

            NodeList nodeList =(NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);

             for(int i=0; i< nodeList.getLength();i++ )
             {
                 Node node=nodeList.item(i);
                 System.out.println(nodeList.item(i).hasAttributes());
                 NamedNodeMap attributes = node.getAttributes();
                FieldName=""; // Reset the field as data to fill in hash
                 locValue=""; // reset the data as to fill in hash

                 for(int b=0;b<attributes.getLength();b++)
                 {
                     Node theAttribute1=attributes.item(b);
                     System.out.println(theAttribute1.getNodeName()+ "="+ theAttribute1.getNodeValue());
                     if(theAttribute1.getNodeName().equalsIgnoreCase("label")) FieldName=theAttribute1.getNodeValue();
                     System.out.println("Reach to Select case ");

                     switch(theAttribute1.getNodeName().toLowerCase())
                     {
                         case "type":
                             System.setProperty("type",theAttribute1.getNodeValue());
                             locValue=locValue+";"+theAttribute1.getNodeValue();
                             break;
                         case "locator":
                             System.setProperty("locator",theAttribute1.getNodeValue());
                             locValue=locValue+";"+theAttribute1.getNodeValue();
                             break;
                         case "locatorvalue":
                             System.setProperty("locatorvalue",theAttribute1.getNodeValue());
                             locValue=locValue+";"+theAttribute1.getNodeValue();
                             break;
                         case "actvalue":
                             System.setProperty("actvalue",theAttribute1.getNodeValue());
                             locValue=locValue+";"+theAttribute1.getNodeValue();
                             break;
                         case "name":
                             System.setProperty("name",theAttribute1.getNodeValue());
                             locValue=locValue+";"+theAttribute1.getNodeValue();
                             break;
                         case "key":
                             System.setProperty("key",theAttribute1.getNodeValue());
                             locValue=locValue+";"+theAttribute1.getNodeValue();
                             break;
                         default: break;
                     }

                 }
                 hmObject.put(FieldName,locValue);

             }
             System.out.println("********************************");
             return hmObject;

        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public String FillDetails(String functionName)
    {
        String type;
        String locator;
        String locatorvalue;
        String actvalue;
        String label;
        String AllLocators;
        String key;
        String []arrLoc;
        String fname=functionName;
        functionName=functionName +"-->FillDetails";
        String sresult="true";
        WebElement element=null;
        int i=0;
        try{
            LinkedHashMap<String,String> hmLocal = new LinkedHashMap<String,String>();
            XMLParser x = new XMLParser();
            hmLocal = x.ReadObjectRepo(fname,"");
            JavascriptExecutor js =(JavascriptExecutor) PageElement.driver;

            String RLacVal="";
            String sTitle="";
            int val=0;
            for(Map.Entry m:hmLocal.entrySet()) {
                i++;
                System.out.println(m.getKey() + "::" + m.getValue());
                AllLocators = m.getValue().toString();
                Actions action = new Actions(PageElement.driver);
                System.out.println(AllLocators);
                arrLoc = AllLocators.split(";");
                label = m.getKey().toString();
                actvalue = arrLoc[1];
                locator = arrLoc[3];
                locatorvalue = arrLoc[4];
                type = arrLoc[5];
                key = arrLoc[2];

                System.out.println("================Start=======================");
                System.out.println("label:" + label);
                System.out.println("actvalue:" + actvalue);
                System.out.println("locator:" + locator);
                System.out.println("locatorValue:" + locatorvalue);
                System.out.println("Type" + type);
                System.out.println("key" + key);

                System.setProperty("type", type);
                System.setProperty("locator", locator);
                System.setProperty("locatorvalue", locatorvalue);
                System.setProperty("actvalue", actvalue);
                System.setProperty("label", label);
                System.setProperty("key", key);
                System.out.println("================END=======================");

                //If Actual value is blnck the code to read data from JSON or from MongoDB
                if (actvalue.length() == 0) {
                    if (key.length() > 0) {
                        //fetch act value from DB and assign tp actvalu var
                        // System.setProperty("actvalue","");
                    }

                }

                //Dynamic Xpath
                if (locatorvalue.contains("START_")) {
                    String temp;
                    temp = locatorvalue.substring(locatorvalue.indexOf("START_"), locatorvalue.indexOf("END"));
                    temp = temp.replace("START_", "");
                    locatorvalue = locatorvalue.replace("START_", "");
                    locatorvalue = locatorvalue.replace("_END", "");
                    locatorvalue = locatorvalue.replace(temp, System.getProperty("DYNAMIC"));
                }
                element=PageElement.getElementForCommonOpps();
                //checking the existance of field
                if (element!= null) {


                    switch (type.toLowerCase()) {
                        case "textbox":
                            System.out.println("In text box");
                            if (actvalue.length() > 0 && (!(actvalue.equalsIgnoreCase("BLANK")))) {

                                element.click();
                                element.clear();
                                element.sendKeys(actvalue.toString());
                                System.out.println("enmtered Value : " + actvalue.toString());

//                                if (!element.getText().equalsIgnoreCase(actvalue)) {
//                                    JavascriptExecutor jse = (JavascriptExecutor) PageElement.driver;
//                                    jse.executeScript("arguments[0].value=" + actvalue + "';", element);
//                                }
                            } else if (actvalue.equalsIgnoreCase("BLANK")) {
                                element.clear();
                            }
                            break;
                        case "select":
                            System.out.println("In SELECT");
                            Select selObj = new Select(element);
                            selObj.selectByValue(actvalue);
                            selObj=null;
                            break;
                        case "selectbyvisibletext":
                            System.out.println("In selectbyvisibletext");
                            Select objSel1= new Select(element);
                            objSel1.selectByVisibleText(actvalue);
                            objSel1=null;
                            break;
                        case "selectbyindex":
                            System.out.println("In selectbyindex");
                            Select objSel2= new Select(element);
                            objSel2.selectByIndex(Integer.parseInt(actvalue));
                            break;
                        case "checkbox":
                            System.out.println("In checkbox");
                            if(actvalue.equalsIgnoreCase("check"))
                            {   //if check box is selected then only perform action
                                if(!element.isSelected()) PageElement.getElementForCommonOpps().click();

                            }else if(actvalue.equalsIgnoreCase("uncheck"))
                            {   // if checkobox is unselecred then only perform action
                                if(element.isSelected()) element.click();
                            }
                            break;
                        case "radiobutton":
                            System.out.println("In radiobutton");
                            if(actvalue.equalsIgnoreCase("check"))
                            {
                                if(!element.isSelected()) element.click();

                            }else if(actvalue.equalsIgnoreCase("uncheck"))
                            {
                                if(element.isSelected()) element.click();
                            }
                            break;
                        case "link":
                            System.out.println("In LINK");
                            if(actvalue.length()>0)
                            {
                                Thread.sleep(Integer.parseInt(actvalue));

                            }
                            element.click();

                            break;
                        case "partiallink":
                            System.out.println("In PARTIAL LINK");
                            element.click();
                            break;
                        case "label":
                            System.out.println("In LABEL");
                            if(actvalue.length()>0)
                            {
                                Thread.sleep(Integer.parseInt(actvalue));

                            }
                            element.click();
                            break;
                        case "labelerror":
                            break;
                        case "image":
                            element.click();
                            break;
                        case "button":
                            System.out.println("In Button");
                            if(actvalue.length()>0)Thread.sleep(Integer.parseInt(actvalue));
                            element.click();
                            break;
                        case "rightclick":
                            System.out.println("In RIGHT CLICK");

                            if(actvalue.length()>0)Thread.sleep(Integer.parseInt(actvalue));
                            element.click();
                            Thread.sleep(2000);
                            action.contextClick(element).build().perform();
                            break;

                        case "alert":
                            if(actvalue.length()>0)Thread.sleep(Integer.parseInt(actvalue));
                            PageElement.driver.switchTo().alert().accept();
                            break;
                        case "table":
                            break;
                        case "menuitemfield":
                            break;
                        case "meniitem":
                            break;

                    }


                }else
                {
                    System.out.println("Element is null" );
                    sresult="false";
                }


            }
        }catch(Exception e)
        {
            sresult="false";

        }
        return sresult;
    }


}
