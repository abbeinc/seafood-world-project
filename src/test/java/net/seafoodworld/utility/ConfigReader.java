package net.seafoodworld.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * A Utility class that load the keyvalue pair inside config.properties file
 * into Properties object and probide single method called
 * read to fer the value out of the properties file we created.
 */



public class ConfigReader {
    //declare properties object at class level, so it can be accessible in
    //static method
    private static Properties properties = new Properties();
    // we want to only load the file once, so we can use static block
    static {
        try {
            FileInputStream in = new FileInputStream("config.properties");
            properties.load(in);
            in.close();
        }catch (IOException e){
            e.printStackTrace();

        }
        }
        // get the value of the key according to the key provided
    public static String read(String key){
        return properties.getProperty(key);
    }

}
