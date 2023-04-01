package com.org.qa.config;

import com.org.qa.utils.constants.Constants;
//import gherkin.lexer.Fi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import static com.org.qa.utils.constants.Constants.envPropertyPath;

public class Config {

//    public String getReportConfigPath(){
////        String reportConfigPath = properties.getProperty("reportConfigPath");
////        if(reportConfigPath!= null) return reportConfigPath;
////        else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
////    }


   public static final String testEnvirinment =System.getProperty("testEnvironment")==null || System.getProperty("testEnvironment").isEmpty()? "INT" : System.getProperty("testEnvironment");
    public static final String basepath= System.getProperty("user.dir");
   private static Properties config;
    static Properties environement=new Properties();

    public Config() throws IOException { loadConfig();}

    public static void loadConfig() throws IOException {
       /* Properties config;
        config = new Properties();
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+ Constants.configPath);
        config.load(fileInputStream);
        Properties environment = new Properties();
        fileInputStream = new FileInputStream(System.getProperty("user.dir")+ Constants.envPath);
        environment.load(fileInputStream);*/

        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + Constants.envPropertyPath);
        environement.load(fileInputStream);

    }

    public static String getEnvironmentProperty(String propertyName){
        return environement.getProperty(propertyName);}




    public static String getReportConfigPath(){
        String reportConfigPath= System.getProperty("user.dir")+"\\src\\test\\java\\com\\dtici\\qa\\config\\extent-config.xml";
        //String reportConfigPath = properties.getProperty("reportConfigPath");
        if(reportConfigPath!= null) return reportConfigPath;
        else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
    }


}
