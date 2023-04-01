package com.org.qa.utils;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

import static java.nio.charset.StandardCharsets.UTF_8;
public class FileUtil {
private static final String jsonfilePath=System.getProperty("user.dir")+File.separator+"src"+
        File.separator+ "test"+ File.separator+ "resources"+File.separator+ "inputjson" + File.separator;
        static Properties props = new Properties();
        static FileInputStream ip=null;

        private static String propertyfilepath = System.getProperty("user.dir")+ File.separator+"src"+
                File.separator+"test"+File.separator+"resources"+File.separator+ "properties"+
                File.separator+"environment.properties";

        public static String getProperty(String property)
        {
            try{
                System.out.println("Selected Env is:" + System.getProperty("testEnv"));
                String env=System.getProperty("testEnv");
                if(env.length() >0)
                {
                    switch(env)
                    {
                        case "int":
                            propertyfilepath=System.getProperty("user.dir")+ File.separator+"src"+
                                    File.separator+"test"+File.separator+"resources"+File.separator+ "properties"+
                                    File.separator+"int.properties";
                            break;
                        case "Regression":
                            propertyfilepath=System.getProperty("user.dir")+ File.separator+"src"+
                                    File.separator+"test"+File.separator+"resources"+File.separator+ "properties"+
                                    File.separator+"regression.properties";
                            break;
                        case "test":
                            propertyfilepath=System.getProperty("user.dir")+ File.separator+"src"+
                                    File.separator+"test"+File.separator+"resources"+File.separator+ "properties"+
                                    File.separator+"test.properties";
                            break;
                    }
                }
                ip=new FileInputStream(propertyfilepath);
                props.load(ip);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            return props.getProperty(property);
        }

        public static String readJSONFile(String fileName)
        {
            String fileData="";
            try{
                File file=new File(jsonfilePath+fileName);
                fileData=Files.toString(file,UTF_8);

            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            return fileData;
        }

        public static JSONObject getDataFromJsonFile(String FileName,String Scenario)
        {
            try{
                JSONParser parser = new JSONParser();
                JSONObject obj=(JSONObject) parser.parse(new FileReader(System.getProperty("user.dir")+
                        File.separator+"src"+File.separator+"test"+File.separator+ "resources"+File.separator+"inputjson"+File.separator+FileName+".json"));
                JSONArray arr= (JSONArray) obj.get("Scenarios");
               // System.out.println("Array :" + arr.size());
                String dataId;
                for (int i=0;i<arr.size();i++)
                {
                    JSONObject data=(JSONObject) arr.get(i);
                    dataId=(String)data.get("sc_id");
                    if (dataId.equalsIgnoreCase(Scenario))
                    {
                        //System.out.println((String)data.get("loginID"));
                        //System.out.println((String)data.get("password"));
                        //System.out.println((String) data.get("url"));
                        return data;
                    }
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            return null;
        }
}
