package utils;
import java.io.FileInputStream;


import java.util.Properties;
public class ConfigReader {
    private static Properties prop = new Properties();
    static {
    try {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
		prop.load(fis);
}
	catch(Exception e) {
		e.printStackTrace();
		System.out.println("could not load config.properties file !");
	
	}
}
    //get any value by key 
    public static String get(String key) {
    		// first try to read from jenkins environment variables
    	String envValue = System.getenv(key);
    	if(envValue != null && !envValue.isEmpty()) {
    		return envValue;
    	}
    	//otherwise fallback to config properties 
    	return prop.getProperty(key);
    		
    	}
    //get base URI dynamically based on ENV paramente
    public static String getBaseURI() {
    	String baseUri = System.getenv("BASE_URI");
    	if(baseUri != null && !baseUri.isEmpty()) {
    		return baseUri;
    	}
    	//Read ENV parameter(dev , qa , prod) from jenkins or default to dev
    	String env = System.getenv("ENV");
    	if(env==null || env.isEmpty()) {
    		env = "dev";
    	}
    	return prop.getProperty(env.toLowerCase()+ ".baseURI");
    }
    //Get API Token
    public static String getToken() {
    	//first check if the token is passed by jenkins
    	String token = System.getenv("TOKEN");
    	if(token!=null && !token.isEmpty()) {
    		return token;
    	}
    	
    	//otherwise fallback to default in config.properties
    	return prop.getProperty("token");
    }
}
